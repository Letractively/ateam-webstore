package com.ateam.webstore.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import com.ateam.webstore.model.Employee;


public class AdminEmployeeDetailsView extends View {
        Employee employee;
        
        Collection<String> roles;

        public Collection<String> getRoles() {
			return roles;
		}

		public void addRole(String role) {
			if (roles == null) {
				roles = new ArrayList<String>();
			}
			roles.add(role);
		}

		public AdminEmployeeDetailsView (View v) {
                super(v);
        }
        
        public Employee getEmployee() {
                return employee;
        }

        public void setEmployee(Employee employee) {
                this.employee = employee;
        }

        

        
} 