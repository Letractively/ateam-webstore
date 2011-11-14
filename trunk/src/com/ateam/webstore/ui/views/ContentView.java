package com.ateam.webstore.ui.views;


public class ContentView {
	String contentHeader;
	String jspf;

	public ContentView (String jspf, String contentHeader) {
		this.jspf = jspf;
		this.contentHeader = contentHeader;
	}
	
	public String getContentHeader() {
		return contentHeader;
	}
	public void setContentHeader(String contentHeader) {
		this.contentHeader = contentHeader;
	}
//	public String getContentText() {
//		return contentText;
//	}
//	public void setContentText(String contentText) {
//		this.contentText = contentText;
//	}
	public String getJspf() {
		return jspf;
	}
	public void setJspf(String jspf) {
		this.jspf = jspf;
	}
}
