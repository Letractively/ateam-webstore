package com.ateam.webstore.ui.forms;

import com.ateam.webstore.ui.views.ContentView;

public class FormResults extends FormSubmission {
	boolean success;
	/**
	 * The view that should be presented after processing the form
	 */
	ContentView view;
	
	public ContentView getView() {
		return view;
	}

	public void setView(ContentView view) {
		this.view = view;
	}
}
