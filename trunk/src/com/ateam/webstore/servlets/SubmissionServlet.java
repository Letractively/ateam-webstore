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
		FormSubmission results = processFormSubmission(req);
		
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
	private FormSubmission processFormSubmission(HttpServletRequest req) {

		String formId = req.getParameter(Parameters.FORM_ID.getId());

		if (formId == null) {
			l.warning("null form ID ");
			//TODO throw execpton
		}
		else if (formId.equals(FormName.LOGIN.getId())) {
			VisitorHandler h = new VisitorHandler(req);
			return h.processLoginRequest();
		}
		else if (formId.equals(FormName.REGISTER.getId())) {
			VisitorHandler h = new VisitorHandler(req);
			return h.getRegistrationRequest();
		}
		else if (formId.equals(FormName.ORDER_SHIPPING.getId())) {
			OrderHandler oh = new OrderHandler(req);
			return oh.processOrderShipppingRequest();
		}
		else if (formId.equals(FormName.ORDER_PAYMENT.getId())) {
			OrderHandler oh = new OrderHandler(req);
			return oh.processOrderPaymentRequest();
		}
		else if (formId.equals(FormName.ORDER_CONFIRM.getId())) {
			OrderHandler oh = new OrderHandler(req);
			return oh.processOrderConfirmationRequest();
		}
		else {
			l.warning("unknown formId:"+formId);
			//TODO throw execpton
		}
	
		return null;
		
	}


	
//	/**
//	 * Processes the form submission
//	 * @param submission
//	 * @param req
//	 * @return
//	 */
//	private FormSubmission processFormSubmission(FormSubmission submission, HttpServletRequest req) {
//		
//		FormName f = submission.getForm();
//		
//		
//		
//		switch (f) {
//			case LOGIN:
//				VisitorHandler vh = new VisitorHandler(req);
//				return vh.processLoginRequest((LoginForm) submission);
//			case REGISTER:
//				return processRegistrationRequest((RegistrationForm) submission);
//			case ORDER_SHIPPING:
//				OrderHandler os = new OrderHandler(req);
//				return os.processOrderShipppingRequest(submission);
//			case ORDER_PAYMENT:
//				OrderHandler op = new OrderHandler(req);
//				return op.processOrderPaymentRequest(submission);
//			case ORDER_CONFIRM:
//				OrderHandler oc = new OrderHandler(req);
//				return oc.processOrderConfimationRequest(submission);
//
//			
//		}
//		
//		return null;
//		
//	}

}
