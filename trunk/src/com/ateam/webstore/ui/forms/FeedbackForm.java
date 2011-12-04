package com.ateam.webstore.ui.forms;

import com.ateam.webstore.ui.models.Visitor;

public class FeedbackForm extends FormSubmission {
	/**
	 * The visitor requesting a login.
	 */
	Visitor v;
	String feedback;
	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Visitor getVistor() {
		return v;
	}

	public void setVisitor(Visitor v) {
		this.v = v;
	}

}
