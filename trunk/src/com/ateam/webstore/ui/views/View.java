package com.ateam.webstore.ui.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ateam.webstore.ui.models.Visitor;

public class View {
	String title;
	String headerTitle;
	String headerSubText;
	String footerText;
	Visitor visitor;
	Map<String,String> navLinks;
	List<ContentView> contentViews;
	
	public View () {
		navLinks = new HashMap<String,String>();
		contentViews = new ArrayList<ContentView>();
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
}
