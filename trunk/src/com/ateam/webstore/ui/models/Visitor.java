package com.ateam.webstore.ui.models;

import com.ateam.webstore.model.Customer;
import com.ateam.webstore.model.Employee;

public class Visitor {
	Customer customer;
	Employee employee;
	String email = "";
	boolean authenticated;
	boolean known;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
	@Override
	public String toString() {
		
		return "[ Visitor :: email="+email+","+
				"customer="+customer+","+
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
