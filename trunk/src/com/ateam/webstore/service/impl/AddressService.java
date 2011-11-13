/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.AddressDAO;
import com.ateam.webstore.model.Address;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class AddressService implements RepositoryService<Address> {

	@Override
	public Address store(Address address) {
		
		AddressDAO repository = new AddressDAO();
		return repository.save(address);
		
	}

	@Override
	public void remove(Address address) {
		
		AddressDAO repository = new AddressDAO();
		repository.delete(address);
		
	}

	@Override
	public Collection<Address> getAll() {

		AddressDAO repository = new AddressDAO();
		return repository.getAll();
		
	}

	@Override
	public Address getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
