package com.ateam.webstore.ui.views;

import java.util.Collection;
import com.ateam.webstore.model.*;
public class RegistrationView extends View {
	Collection<SecurityQuestion> securityQuestions;
       
	public RegistrationView(View mainView) {
		super(mainView);
	}

	public Collection<SecurityQuestion> getSecurityQuestions() {
		return securityQuestions;
	}

	public void setSecurityQuestions(Collection<SecurityQuestion> securityQuestions) {
		this.securityQuestions = securityQuestions;
	}
}
