/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.DepartmentDAO;
import com.ateam.webstore.model.Department;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class DepartmentService implements RepositoryService<Department> {

	@Override
	public Department store(Department department) {

		DepartmentDAO repository = new DepartmentDAO();
		return repository.save(department);
		
	}

	@Override
	public void remove(Department department) {

		DepartmentDAO repository = new DepartmentDAO();
		repository.delete(department);
		
	}

	@Override
	public Collection<Department> getAll() {

		DepartmentDAO repository = new DepartmentDAO();
		return repository.getAll();
		
	}

	@Override
	public Department getById(Serializable id) {
		DepartmentDAO repository = new DepartmentDAO();
		return repository.get(id);
	}

}
