package com.ateam.webstore.ui.views;

import java.util.List;

public class RegistrationView extends View {
	List<String> securityQuestions;

	public List<String> getSecurityQuestions() {
		return securityQuestions;
	}

	public void setSecurityQuestions(List<String> securityQuestions) {
		this.securityQuestions = securityQuestions;
	}
}
