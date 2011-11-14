/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.EmployeeRolesDAO;
import com.ateam.webstore.model.EmployeeRoles;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class EmployeeRolesService implements RepositoryService<EmployeeRoles> {

	@Override
	public EmployeeRoles store(EmployeeRoles employeeRoles) {
		
		EmployeeRolesDAO repository = new EmployeeRolesDAO();
		return repository.save(employeeRoles);
	}

	@Override
	public void remove(EmployeeRoles employeeRoles) {
		
		EmployeeRolesDAO repository = new EmployeeRolesDAO();
		repository.delete(employeeRoles);
		
	}

	@Override
	public Collection<EmployeeRoles> getAll() {
		
		EmployeeRolesDAO repository = new EmployeeRolesDAO();
		return repository.getAll();
	}

	@Override
	public EmployeeRoles getById(Serializable id) {
		EmployeeRolesDAO repository = new EmployeeRolesDAO();
		return repository.get(id);
	}

}
