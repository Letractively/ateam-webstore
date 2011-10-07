package com.ateam.webstore.ui.forms;

import com.ateam.webstore.ui.Constants.FormName;
import com.ateam.webstore.ui.views.View;

public abstract class FormSubmission {
	/**
	 * The action
	 */
	String action;
	/**
	 * 
	 */
	String method;
	/**
	 * 
	 */
	FormName f;
	/**
	 * If it was successful
	 */
	boolean success;
	/**
	 * 
	 */
	String resultMessage;
	
	/**
	 * The view that should be presented after processing the form
	 */
	View resultView;
	
	public View getResultView() {
		return resultView;
	}

	public void setResultView(View view) {
		this.resultView = view;
	}

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

	public FormName getForm() {
		return f;
	}

	public void setForm(FormName f) {
		this.f = f;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
}
