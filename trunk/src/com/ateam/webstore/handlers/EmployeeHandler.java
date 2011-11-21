package com.ateam.webstore.handlers;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Employee;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.View;

public class EmployeeHandler extends Handler {

	public EmployeeHandler(HttpServletRequest req) {
		super(req);
		// TODO Auto-generated constructor stub
	}
	
	public Employee getEmployee() {
		// TODO Auto-generated constructor stub
		return null;
	}
	public View getEmployeeListView() {
		// TODO Auto-generated constructor stub
		return null;
	}
	public View getEmployeeDetailsView() {
		// TODO Auto-generated constructor stub
		return null;
	}
	public FormSubmission processLoginRequest() {
		// TODO Auto-generated constructor stub
		return null;
	}
	public FormSubmission processAddEmployeeRequest() {
		// TODO Auto-generated constructor stub
		return null;
	}
	
	/**
	 * Get the login view
	 * @param loginMessage
	 * @return
	 */
	public View getLoginView(String loginMessage) {
		
		return getLoginView(loginMessage, getMainAdminView());
		
	}


}
