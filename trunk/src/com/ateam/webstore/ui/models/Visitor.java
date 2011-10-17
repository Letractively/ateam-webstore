package com.ateam.webstore.ui.models;

public class Visitor {
	String id;
	String email = "";
	String name = "";
	boolean authenticated;
	boolean known;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
	@Override
	public String toString() {
		
		return "[ Visitor :: id="+id+", " +
				"email="+email+","+
				"name="+name+","+
				"authenticated="+authenticated+","+
				"known="+known
				+" ]";
				
	}
	public boolean isKnown() {
		return known;
	}
	public void setKnown(boolean known) {
		this.known = known;
	}
	
}
