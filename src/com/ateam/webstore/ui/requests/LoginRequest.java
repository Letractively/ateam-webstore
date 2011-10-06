package com.ateam.webstore.ui.requests;

import com.ateam.webstore.ui.models.Visitor;

public class LoginRequest extends FormSubmission {
	/**
	 * The visitor requesting a login.
	 */
	Visitor v;
	String password;
	boolean rememberEmail;

	public Visitor getVistor() {
		return v;
	}

	public void setVisitor(Visitor v) {
		this.v = v;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRememberEmail() {
		return rememberEmail;
	}

	public void setRememberEmail(boolean rememberEmail) {
		this.rememberEmail = rememberEmail;
	}
}
