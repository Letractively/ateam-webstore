package com.ateam.webstore.ui.forms;

import com.ateam.webstore.ui.models.Visitor;

public class LoginForm extends FormSubmission {
	/**
	 * The visitor requesting a login.
	 */
	Visitor v;
	String password;
	String redirect;
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

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
}
