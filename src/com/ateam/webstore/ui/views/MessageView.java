package com.ateam.webstore.ui.views;

public class MessageView extends View {

	String message;
	boolean error;
	
	public MessageView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessageView(View v) {
		super(v);
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

}
