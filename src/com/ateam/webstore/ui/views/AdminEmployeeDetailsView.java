package com.ateam.webstore.ui.views;

import com.ateam.webstore.model.Employee;


public class AdminEmployeeDetailsView extends View {
        Employee employee;
        
        
     
        
        
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