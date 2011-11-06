package com.ateam.webstore.service.impl;

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

}
