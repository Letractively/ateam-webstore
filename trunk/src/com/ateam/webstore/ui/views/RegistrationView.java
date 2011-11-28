package com.ateam.webstore.ui.views;

import java.util.Collection;
import com.ateam.webstore.model.*;
import com.ateam.webstore.ui.forms.RegistrationForm;
public class RegistrationView extends View {
	Collection<SecurityQuestion> securityQuestions;
    RegistrationForm form;
    
	public RegistrationView(View mainView) {
		super(mainView);
	}

	public Collection<SecurityQuestion> getSecurityQuestions() {
		return securityQuestions;
	}

	public void setSecurityQuestions(Collection<SecurityQuestion> securityQuestions) {
		this.securityQuestions = securityQuestions;
	}

	public RegistrationForm getForm() {
		return form;
	}

	public void setForm(RegistrationForm form) {
		this.form = form;
	}
}
