package com.ateam.webstore.handlers;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.SecurityQuestion;
import com.ateam.webstore.service.impl.SecurityQuestionService;

public class SecurityQuestionHandler extends Handler {

	public SecurityQuestionHandler(HttpServletRequest req) {
		super(req);
		service = new SecurityQuestionService();
	}

	public Collection<SecurityQuestion> getSecurityQuestions() {
		return service.getAll();
	}

	private Collection<SecurityQuestion> getDummies() {
		Collection<SecurityQuestion> secs = new ArrayList<SecurityQuestion>();
		
		SecurityQuestion sec = new SecurityQuestion(("Mothers maiden name?"));
		secs.add(sec);
		
		return secs;
	}
}
