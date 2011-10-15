package com.ateam.webstore.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
		
		View l = getMainView(req);
		
		ContentView cv = new ContentView();
		cv.setContentHeader("Login");
		//cv.setContentText("Please Login");
		cv.setJspf(JSP_LOGIN);
		l.getContentViews().add(cv);
		
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

}
