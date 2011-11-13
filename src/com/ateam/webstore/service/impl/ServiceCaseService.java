/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.ServiceCaseDAO;
import com.ateam.webstore.model.ServiceCase;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class ServiceCaseService implements RepositoryService<ServiceCase> {

	@Override
	public ServiceCase store(ServiceCase serviceCase) {
		
		ServiceCaseDAO repository = new ServiceCaseDAO();
		return repository.save(serviceCase);
	}

	@Override
	public void remove(ServiceCase serviceCase) {
		
		ServiceCaseDAO repository = new ServiceCaseDAO();
		repository.delete(serviceCase);
		
	}

	@Override
	public Collection<ServiceCase> getAll() {
		
		ServiceCaseDAO repository = new ServiceCaseDAO();
		return repository.getAll();
	}

	@Override
	public ServiceCase getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
