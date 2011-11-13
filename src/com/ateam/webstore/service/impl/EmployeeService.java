/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.EmployeeDAO;
import com.ateam.webstore.model.Employee;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class EmployeeService implements RepositoryService<Employee> {

	@Override
	public Employee store(Employee employee) {

		EmployeeDAO repository = new EmployeeDAO();
		return repository.save(employee);
		
	}

	@Override
	public void remove(Employee employee) {

		EmployeeDAO repository = new EmployeeDAO();
		repository.delete(employee);
		
	}

	@Override
	public Collection<Employee> getAll() {

		EmployeeDAO repository = new EmployeeDAO();
		return repository.getAll();
		
	}

	@Override
	public Employee getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
