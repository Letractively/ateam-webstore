package com.ateam.webstore.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.forms.FormResults;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.forms.LoginForm;
import com.ateam.webstore.ui.models.Visitor;

public class FormHandler extends HttpServlet implements Constants {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		FormSubmission submission = processFormSubmission(req);
		FormResults results = handle(submission);
		
		super.doPost(req, resp);
	}

	private FormSubmission processFormSubmission(HttpServletRequest req) {
		String formId = req.getParameter(Parameters.FORM_ID.getId());
		//Constants.Forms formId = new Constants.Forms(req.getParameter(Parameters.FORM_ID.getId()));
		 

		if (formId == null) {
			//TODO throw execpton
		}
		
		else if (formId.equals(Forms.LOGIN.getId())) {
			return processLoginRequest(req);
		}
		else {
			//TODO throw execpton
			
		}
		
		return null;
		
		
	}

	/**
	 * 
	 * @param req
	 * @return
	 */
	private LoginForm processLoginRequest(HttpServletRequest req) {
		LoginForm login = new LoginForm();
		Visitor v = new Visitor();
		v.setId("12345");
		v.setEmail(req.getParameter(Parameters.PRODUCT_ID.getId()));
		//login.setVisitor(v)
		login.setForm(Forms.LOGIN);
		return login;
	}
	
	private FormResults handle(FormSubmission submission) {
		return null;
		
	}
}
