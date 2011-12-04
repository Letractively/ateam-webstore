package com.ateam.webstore.ui.models;

import com.ateam.webstore.model.Customer;
import com.ateam.webstore.model.Employee;

public class Visitor {
	Customer customer;
	Employee employee;
	String email = "";
	boolean authenticated;
	boolean employeeAuthenticated;
	boolean known;
	boolean remember;
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
	public boolean isEmployeeAuthenticated() {
		return employeeAuthenticated;
	}
	public void setEmployeeAuthenticated(boolean employeeAuthenticated) {
		this.employeeAuthenticated = employeeAuthenticated;
	}
	public void setRemember(boolean b) {
		remember = b;
	}
	public boolean isRemember() {
		return remember;
	}
	public String getName() {
		if (customer != null) {
			return customer.getFirstName();
		}
		else if (employee != null) {
			return employee.getFirstName();
		}
		else {
			return null;
		}
	}
	public boolean isEmployee() {
		return employeeAuthenticated || employee != null;
	}
}
