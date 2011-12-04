package com.ateam.webstore.ui.views;

import java.util.Collection;

import com.ateam.webstore.model.Employee;


public class AdminEmployeeListView extends View {
	Collection<Employee> employee;
	String listTitle;
	
	
	
	public Collection<Employee> getEmployee() {
		return employee;
	}

	public void setEmployees(Collection<Employee> employee) {
		this.employee = employee;
	}
	
	
	public AdminEmployeeListView(View v) {
		super(v);
	}
	
	public String getListTitle() {
		return listTitle;
	}

	public void setListTitle(String listTitle) {
		this.listTitle = listTitle;
	}

	

	
}
