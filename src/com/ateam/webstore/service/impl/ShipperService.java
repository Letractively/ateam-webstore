/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.ShipperDAO;
import com.ateam.webstore.model.Shipper;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class ShipperService implements RepositoryService<Shipper> {

	@Override
	public Shipper store(Shipper shipper) {
		
		ShipperDAO repository = new ShipperDAO();
		return repository.save(shipper);
		
	}

	@Override
	public void remove(Shipper shipper) {
		
		ShipperDAO repository = new ShipperDAO();
		repository.delete(shipper);
		
	}

	@Override
	public Collection<Shipper> getAll() {

		ShipperDAO repository = new ShipperDAO();
		return repository.getAll();
		
	}

	@Override
	public Shipper getById(Serializable id) {
		ShipperDAO repository = new ShipperDAO();
		return repository.get(id);
	}

}
