package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.CustomerDAO;
import com.ateam.webstore.model.Customer;
import com.ateam.webstore.service.RepositoryService;

public class CustomerService implements RepositoryService<Customer> {

	@Override
	public Customer store(Customer customer) {
		
		CustomerDAO repository = new CustomerDAO();
		return repository.save(customer);
		
	}

	@Override
	public void remove(Customer customer) {
		
		CustomerDAO repository = new CustomerDAO();
		repository.delete(customer);
	}

	@Override
	public Collection<Customer> getAll() {
		
		CustomerDAO repository = new CustomerDAO();
		return repository.getAll();
	}

	@Override
	public Customer getById(Serializable id) {
		CustomerDAO repository = new CustomerDAO();
		return repository.get(id);
	}
	
	public Customer getByPersonId(Serializable id) {
		CustomerDAO repository = new CustomerDAO();
		return repository.getCustomerByPersonID(id);
	}

}
