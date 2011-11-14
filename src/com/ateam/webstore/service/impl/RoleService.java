/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.RoleDAO;
import com.ateam.webstore.model.Role;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class RoleService implements RepositoryService<Role> {

	@Override
	public Role store(Role role) {
		
		RoleDAO repository = new RoleDAO();
		return repository.save(role);
	}

	@Override
	public void remove(Role role) {
		
		RoleDAO repository = new RoleDAO();
		repository.delete(role);
		
	}

	@Override
	public Collection<Role> getAll() {
		
		RoleDAO repository = new RoleDAO();
		return repository.getAll();
	}

	@Override
	public Role getById(Serializable id) {
		RoleDAO repository = new RoleDAO();
		return repository.get(id);
	}

}
