package com.ateam.webstore.ui.models;

import com.ateam.webstore.model.Customer;
import com.ateam.webstore.model.Employee;

public class Visitor {
	Customer customer;
	Employee employee;
	String email = "";
	String name = "";
	boolean authenticated;
	boolean known;
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
		
		return "[ Visitor :: email="+email+","+
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
