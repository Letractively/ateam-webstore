package com.ateam.webstore.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Customer;
import com.ateam.webstore.model.Person;
import com.ateam.webstore.model.SecurityQuestion;
import com.ateam.webstore.service.impl.CustomerService;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.forms.LoginForm;
import com.ateam.webstore.ui.forms.RegistrationForm;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.MessageView;
import com.ateam.webstore.ui.views.RegistrationView;
import com.ateam.webstore.ui.views.View;

public class CustomerHandler extends Handler {

	public CustomerHandler(HttpServletRequest req) {
		super(req);
		service = new CustomerService();
	}
	
	/**
	 * Process a request to view the login form.
	 * @param req
	 * @return
	 */
	public View getLoginView () {
		
		View l = getMainView();
		
		l.setShowLogonForm(false);
		
		l.addContentView(new ContentView(JSP_LOGIN, "Login"));
		
		return l;
	}
	
	/**
	 * Gets the registration view
	 * @param req
	 * @return
	 */
	public RegistrationView getRegistrationView() {
		RegistrationView r = new RegistrationView(getMainView());
		
		SecurityQuestionHandler sech = new SecurityQuestionHandler(req);
		r.setSecurityQuestions(sech.getSecurityQuestions());
		
		r.addContentView(new ContentView(JSP_REGISTRATION, "Register"));
		
		return r;
		
	}
	
	/**
	 * Process a login request
	 * @param login
	 * @param req
	 * @return
	 */
	public FormSubmission processLoginRequest() {
		
		LoginForm login = getLoginRequest();
		
		l.info("Processing Login Request from session "+req.getSession().getId()); 
		Visitor v = login.getVistor();
		
		//TODO implement a "real" authentication mechanism.
		v.setCustomer(new Customer("John", "Doe", null));
		
		v.setAuthenticated(true);
		v.setKnown(true);
		v.setEmail(req.getParameter(Parameters.EMAIL.getId()));
		req.getSession().setAttribute(SESSION_ATTRIBUTE_VISITOR, v);
		login.setForm(FormName.LOGIN);
		login.setSuccess(true);

		ProductHandler ph = new ProductHandler(req);
		View rv = ph.getHomePageView();

		login.setResultView(rv);
		
		l.info("Login results:"+v);
		
		return login;
	}
	
	/**
	 * Process a login request
	 * @param login
	 * @param req
	 * @return
	 */
	public FormSubmission processRegistrationRequest() {
		
		l.info("Processing registration request from session "+req.getSession().getId());
		
		RegistrationForm reg = getRegistrationRequest();
		
		SecurityQuestion sq = new SecurityQuestion(reg.getSecurityQuestionId(), "???");
		Person newPerson = new Person(reg.getEmail(), reg.getPw(), sq , reg.getSecurityAnswer());
		Customer newCustomer = new Customer("John", "Doe", newPerson );
		
		MessageView rv = new MessageView(getMainView());
		
		rv.addContentView(new ContentView(JSP_MESSAGE, "Registration"));
		
		try {
			PersonHandler ph = new PersonHandler(req);
			ph.store(newPerson);
			service.store(newCustomer);
			rv.setMessage("Success!!");
		} catch (Exception e) {
			l.log(Level.WARNING, "", e);
			rv.setError(true);
			rv.setMessage("Failed!! "+e.getMessage());
		}

		reg.setResultView(rv);
		
		return reg;
	}
	
	private RegistrationForm getRegistrationRequest() {
		l.info("Parsing Registration Request from session "+req.getSession().getId());
		
		RegistrationForm reg = new RegistrationForm();

		reg.setFirstName("John"); //TODO add form support
		reg.setLastName("Doe"); //TODO add form support
		reg.setEmail(req.getParameter(Parameters.EMAIL.getId()));
		reg.setPw(req.getParameter(Parameters.PASSWORD.getId())); //TODO confirm password
		reg.setSecurityQuestionId(Long.parseLong(req.getParameter(Parameters.SECURITY_QUESTION.getId())));
		reg.setSecurityAnswer(req.getParameter(Parameters.SECURITY_ANSWER.getId()));
		reg.setForm(FormName.REGISTER);
		
		return reg;
	}

	/**
	 * Builds a LoginForm from the request
	 * @param req
	 * @return
	 */
	public LoginForm getLoginRequest() {
		
		l.info("Parsing Login Request from session "+req.getSession().getId());
		
		LoginForm login = new LoginForm();
		Visitor v = new Visitor();
		v.setEmail(req.getParameter(Parameters.EMAIL.getId()));
		login.setVisitor(v);
		
		req.getSession().setAttribute(SESSION_ATTRIBUTE_VISITOR, v);
		login.setVisitor(v);
		login.setForm(FormName.LOGIN);
		
		return login;
	}
	
	/**
	 * 
	 * @return
	 */
	public View getLogoutView() {

		Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
		
		if (v != null ) {
			//req.getSession().invalidate();
			v.setAuthenticated(false);
		}
		
		ProductHandler ph = new ProductHandler(req);
		View rv = ph.getHomePageView();
		return rv;
	}

	public View getForgotPasswordView() {
		// TODO Auto-generated method stub
		return null;
	}

}
