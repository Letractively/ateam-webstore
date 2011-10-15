package com.ateam.webstore.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.forms.LoginForm;
import com.ateam.webstore.ui.forms.RegistrationForm;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.View;

/**
 * Handles Form Submissions
 * @author bdrew
 *
 */
public class SubmissionServlet extends HttpServlet implements Constants {
	static Logger l = Logger.getLogger(MainServlet.class.getName().toString());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		l.info("form submission "+req.getSession().getId());
		//Get the form and process
		FormSubmission results = processFormSubmission(getFormSubmission(req), req);
		
		//Set Result View
		req.setAttribute(REQUEST_ATTRIBUTE_VIEW, results.getResultView());
		
		//Forward to JSP
		getServletConfig().getServletContext().getRequestDispatcher(
				"/main.jsp").forward(req, resp);
	}

	/**
	 * Extracts a FormSubmission from the request.
	 * @param req
	 * @return
	 */
	private FormSubmission getFormSubmission(HttpServletRequest req) {

		String formId = req.getParameter(Parameters.FORM_ID.getId());

		if (formId == null) {
			l.warning("null form ID ");
			//TODO throw execpton
		}
		else if (formId.equals(FormName.LOGIN.getId())) {
			return getLoginRequest(req);
		}
		else {
			l.warning("unknown formId:"+formId);
			//TODO throw execpton
		}
		
		return null;
		
	}

	/**
	 * Builds a LoginForm from the request
	 * @param req
	 * @return
	 */
	private LoginForm getLoginRequest(HttpServletRequest req) {
		
		l.info("Parsing Login Request from session "+req.getSession().getId());
		
		LoginForm login = new LoginForm();
		Visitor v = new Visitor();
		v.setId("12345");
		v.setEmail(req.getParameter(Parameters.PRODUCT_ID.getId()));
		login.setVisitor(v);
		
		req.getSession().setAttribute(SESSION_ATTRIBUTE_VISITOR, v);
		login.setVisitor(v);
		login.setForm(FormName.LOGIN);
		
		return login;
	}
	
	/**
	 * Processes the form submission
	 * @param submission
	 * @param req
	 * @return
	 */
	private FormSubmission processFormSubmission(FormSubmission submission, HttpServletRequest req) {
		
		FormName f = submission.getForm();
		
		
		
		switch (f) {
			case LOGIN:
				return processLoginRequest((LoginForm) submission, req);
			case REGISTER:
				return processRegistrationRequest((RegistrationForm) submission, req);
		}
		
		return null;
		
	}
	
	/**
	 * 
	 * @param registration
	 * @param req
	 * @return
	 */
	private LoginForm processRegistrationRequest(RegistrationForm registration,
			HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Process a login request
	 * @param login
	 * @param req
	 * @return
	 */
	private FormSubmission processLoginRequest(LoginForm login, HttpServletRequest req) {
		
		l.info("Processing Login Request from session "+req.getSession().getId()); 
		Visitor v = login.getVistor();
		//TODO implement a "real" authentication mechanism.
		v.setAuthenticated(true);
		v.setEmail(req.getParameter(Parameters.EMAIL.getId()));
		req.getSession().setAttribute(SESSION_ATTRIBUTE_VISITOR, v);
		login.setForm(FormName.LOGIN);
		login.setSuccess(true);
		ProductHandler ph = new ProductHandler(req);
		View rv = ph.getHomePageView();

		login.setResultView(rv);
		return login;
	}
}
