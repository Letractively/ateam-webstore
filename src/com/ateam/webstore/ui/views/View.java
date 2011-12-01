package com.ateam.webstore.ui.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ateam.webstore.model.Cart;
import com.ateam.webstore.ui.models.Visitor;

public class View {
	String title = "";
	String headerTitle = "";
	String headerSubText = "";
	String footerText = "";
	String message;
	Visitor visitor;
	String servletPath;
	String redirectPath;
	String loginRedirectPath;
	Map<String,String> navLinks;
	List<ContentView> contentViews;
	boolean showLogonForm;
	boolean showVisitorInfo;
	private boolean error;
	String context;
	
	
	public enum Contexts {
		ORDER_SHIPPING ("orderShipping"),
		ORDER_PAYMENT ("orderPayment"),
		CART ("cart");
		
		String id;
		Contexts (String id) {
            this.id = id;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
	}
	/**
	 * 
	 */
	public View () {
		contentViews = new ArrayList<ContentView>();
		navLinks = new HashMap<String,String>();
		contentViews = new ArrayList<ContentView>();
		visitor = new Visitor(); 
	}
	/**
	 * Copy Constructor
	 * @param v
	 */
	public View (View v) {
		this.title = v.title;
		this.headerTitle = v.headerTitle;
		this.headerSubText = v.headerSubText;
		this.footerText = v.footerText;
		this.visitor = v.visitor;
		this.navLinks = v.navLinks;
		this.contentViews = v.contentViews;
		this.showLogonForm = v.showLogonForm;
		this.showVisitorInfo = v.showVisitorInfo;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHeaderTitle() {
		return headerTitle;
	}
	public void setHeaderTitle(String headerTitle) {
		this.headerTitle = headerTitle;
	}
	public String getHeaderSubText() {
		return headerSubText;
	}
	public void setHeaderSubText(String headerSubText) {
		this.headerSubText = headerSubText;
	}
	public String getFooterText() {
		return footerText;
	}
	public void setFooterText(String footerText) {
		this.footerText = footerText;
	}
	public Map<String, String> getNavLinks() {
		return navLinks;
	}
	public void setNavLinks(Map<String, String> navLinks) {
		this.navLinks = navLinks;
	}
	public List<ContentView> getContentViews() {
		return contentViews;
	}
	public void setContentViews(List<ContentView> contentViews) {
		this.contentViews = contentViews;
	}
	public void addContentView(ContentView contentView) {
		this.contentViews.add(contentView);
	}

	public Visitor getVisitor() {
		return visitor;
	}
	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
	/**
	 * 
	 * @return
	 */
	public String getGreeting() {
		String greet = "Welcome ";
		
		if (visitor.getCustomer().getFirstName() != null) {
			greet+=visitor.getCustomer().getFirstName();
		}
		else if (visitor != null && visitor.getEmail() != null
				&& !visitor.getEmail().isEmpty()) {
			greet+=" "+visitor.getEmail();
		}

		return greet+"!";
		
	}
	public boolean showLogonForm() {
		return showLogonForm;
	}
	public void setShowLogonForm(boolean showLogonForm) {
		this.showLogonForm = showLogonForm;
	}
	public boolean showVisitorInfo() {
		return showVisitorInfo;
	}
	public void setShowVisitorInfo(boolean showVisitorInfo) {
		this.showVisitorInfo = showVisitorInfo;
	}
	
	public String toString() {
		return "[View :: "+this.getClass().getName()+", "+contentViews.size()+" content views ]";
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
	public String getServletPath() {
		return servletPath;
	}
	public void setServletPath(String servletPath) {
		this.servletPath = servletPath;
	}
	public String getRedirectPath() {
		return redirectPath;
	}
	public void setRedirectPath(String redirectPath) {
		this.redirectPath = redirectPath;
	}
	public String getLoginRedirectPath() {
		return loginRedirectPath;
	}
	public void setLoginRedirectPath(String loginRedirectPath) {
		this.loginRedirectPath = loginRedirectPath;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
}
