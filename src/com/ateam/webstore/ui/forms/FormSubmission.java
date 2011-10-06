package com.ateam.webstore.ui.forms;

import com.ateam.webstore.ui.Constants.Forms;
import com.ateam.webstore.ui.views.ContentView;

public abstract class FormSubmission {
	/**
	 * The action
	 */
	String action;
	/**
	 * 
	 */
	String method;
	
	Forms f;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}



	public Forms getForm() {
		return f;
	}

	public void setForm(Forms f) {
		this.f = f;
	}
	
}
