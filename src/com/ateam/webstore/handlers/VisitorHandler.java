package com.ateam.webstore.handlers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Customer;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.forms.LoginForm;
import com.ateam.webstore.ui.forms.RegistrationForm;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.RegistrationView;
import com.ateam.webstore.ui.views.View;

public class VisitorHandler extends Handler {

	public VisitorHandler(HttpServletRequest req) {
		super(req);
		// TODO Auto-generated constructor stub
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
		RegistrationView r = new RegistrationView();
		List<String> sec = new ArrayList<String>();
		r.setSecurityQuestions(sec);
		return null;
		
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
	 * Builds a LoginForm from the request
	 * @param req
	 * @return
	 */
	public LoginForm getLoginRequest() {
		
		l.info("Parsing Login Request from session "+req.getSession().getId());
		
		LoginForm login = new LoginForm();
		Visitor v = new Visitor();
		v.setEmail(req.getParameter(Parameters.PRODUCT_ID.getId()));
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
	public RegistrationForm getRegistrationRequest() {
		return null;
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
