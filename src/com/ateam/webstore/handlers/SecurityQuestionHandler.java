package com.ateam.webstore.handlers;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.SecurityQuestion;

public class SecurityQuestionHandler extends Handler {

	public SecurityQuestionHandler(HttpServletRequest req) {
		super(req);
		// TODO Auto-generated constructor stub
	}

	public Collection<SecurityQuestion> getSecurityQuestions() {
		//TODO get from service
		return getDummies();
	}

	private Collection<SecurityQuestion> getDummies() {
		Collection<SecurityQuestion> secs = new ArrayList<SecurityQuestion>();
		
		SecurityQuestion sec = new SecurityQuestion((long) 12, "Mothers maiden name?");
		secs.add(sec);
		
		return secs;
	}
}
