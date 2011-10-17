package com.ateam.webstore.ui.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ateam.webstore.ui.models.Cart;
import com.ateam.webstore.ui.models.Visitor;

public class View {
	String title = "";
	String headerTitle = "";
	String headerSubText = "";
	String footerText = "";
	Visitor visitor;
	Cart cart;
	Map<String,String> navLinks;
	List<ContentView> contentViews;
	boolean showLogonForm;
	boolean showVisitorInfo;
	
	/**
	 * 
	 */
	public View () {
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
		this.cart = v.cart;
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
		String greet = "Welcome";
		if (visitor != null && visitor.getEmail() != null
				&& !visitor.getEmail().isEmpty()) {
			greet+=" "+visitor.getEmail();
		}

		return greet+"!";
		
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
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
}
