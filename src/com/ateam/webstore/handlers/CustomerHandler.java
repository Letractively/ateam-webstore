package com.ateam.webstore.handlers;

import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Customer;
import com.ateam.webstore.service.impl.CartService;
import com.ateam.webstore.service.impl.CustomerService;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.forms.LoginForm;
import com.ateam.webstore.ui.forms.RegistrationForm;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.RegistrationView;
import com.ateam.webstore.ui.views.View;

public class CustomerHandler extends Handler {
	CustomerService service;
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
		return getLoginView(null);
	}
	
	/**
	 * Gets the registration view
	 * @param req
	 * @return
	 */
	public RegistrationView getRegistrationView() {
		return getRegistrationView("");
	}
	
	/**
	 * 
	 * @param message
	 * @return
	 */
	public RegistrationView getRegistrationView(String message) {
		return getRegistrationView(message, null);
	}
	
	/**
	 * 
	 * @param message
	 * @param form
	 * @return
	 */
	public RegistrationView getRegistrationView(RegistrationForm form) {
		return getRegistrationView(form.getResultMessage(), form);
	}
	
	/**
	 * 
	 * @param message
	 * @param form
	 * @return
	 */
	public RegistrationView getRegistrationView(String message, RegistrationForm form) {
		RegistrationView r = new RegistrationView(getMainView());
		
		SecurityQuestionHandler sech = new SecurityQuestionHandler(req);
		r.setSecurityQuestions(sech.getSecurityQuestions());
		
		if (message != null) {
			r.setMessage(message);
		}
		
		r.setForm(form);
		
		r.setShowVisitorInfo(false);
		
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
		
		Customer cust = null;
		View resultView = null;
		
		try {
			cust = service.authenticateCustomer(req.getParameter(Parameters.EMAIL.getId()), req.getParameter(Parameters.PASSWORD.getId()));
			if (cust != null) {
				l.info("Login Successful for "+cust.getPerson().getLogin());
				v.setCustomer(cust);
				v.setAuthenticated(true);
				v.setKnown(true);
				v.setEmail(req.getParameter(Parameters.EMAIL.getId()));
				
				req.getSession().setAttribute(SESSION_ATTRIBUTE_VISITOR, v);
				login.setForm(FormName.LOGIN);
				login.setSuccess(true);

			}
			else {
				resultView = getLoginView("Invalid email or password. Please try again.", getMainView());
			}
			
		} catch (Exception e) {
			l.log(Level.INFO, "Failed authentication", e);
			resultView = getLoginView("Invalid email or password. Please try again.", getMainView());
		}

		if (v.isAuthenticated()) try {
			CartService cs = new CartService();
			l.info("retrieving cart for customerId:"+cust.getId());
			req.getSession().setAttribute(SESSION_ATTRIBUTE_CART, cs.getByCustomerId(cust.getId()));
			
			if (login.getRedirect() != null) {
				resultView = new View();
				resultView.setRedirectPath(login.getRedirect());
			}
			else {
				//Build view
				ProductHandler ph = new ProductHandler(req);
				resultView = ph.getHomePageView();
			}

		} catch (Exception e) {
			l.log(Level.INFO, "", e);			
		}
		
		login.setResultView(resultView);
		
		l.info("Login results:"+v);
		
		return login;
	}
	
	/**
	 * Get the login view
	 * @param loginMessage
	 * @return
	 */
	public View getLoginView(String loginMessage) {
		
		return getLoginView(loginMessage, getMainView());
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
		
		if (!reg.isValid()) {
			reg.setResultView(getRegistrationView(reg));
		}
		else if (service.customerExists(reg.getEmail())) {
			reg.setResultView(getRegistrationView("An account for"+reg.getEmail()+" already exists"));
		}
		else {
			View rv = new View(getMainView());
			
			rv.addContentView(new ContentView(JSP_LOGIN, "Login"));
			
			try {
				service.registerCustomer(reg.getFirstName(), reg.getLastName(), reg.getEmail(), reg.getPw(), reg.getSecurityQuestionIdLong(), reg.getSecurityAnswer());
				rv.setMessage("Registration Complete, please login.");
			} catch (Exception e) {
				l.log(Level.WARNING, "", e);
				rv.setError(true);
				//rv.setMessage("Failed!! "+e.getMessage());
				reg.setResultView(getRegistrationView("An error occured."));
			}

			reg.setResultView(rv);			
		}
		
		return reg;
	}
	
	private RegistrationForm getRegistrationRequest() {
		l.info("Parsing Registration Request from session "+req.getSession().getId());
		
		RegistrationForm reg = new RegistrationForm();

		reg.setFirstName(req.getParameter(Parameters.FIRST_NAME.getId()));
		reg.setLastName(req.getParameter(Parameters.LAST_NAME.getId()));
		reg.setEmail(req.getParameter(Parameters.EMAIL.getId()));
		reg.setPw(req.getParameter(Parameters.PASSWORD.getId()));
		reg.setCpw(req.getParameter(Parameters.CONFIRMPASSWORD.getId()));
		reg.setSecurityQuestionId(req.getParameter(Parameters.SECURITY_QUESTION.getId()));
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
		login.setRedirect(req.getParameter(Parameters.REDIRECT.getId()));
		
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

	public View getMyAccountView() {
		
		View v = new View(getMainView());
		
		v.addContentView(new ContentView(JSP_MY_ACCOUNT, "My Account"));
		
		return v;
	}

	public View getFeedbackView() {
		
		View v = new View();
		
		v.addContentView(new ContentView(JSP_CUSTOMER_FEEDBACK, "Send Feedback"));
		return v;
	}

}
