/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.ShippingCodeDAO;
import com.ateam.webstore.model.ShippingCode;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class ShippingCodeService implements RepositoryService<ShippingCode> {

	@Override
	public ShippingCode store(ShippingCode shippingCode) {

		ShippingCodeDAO repository = new ShippingCodeDAO();
		return repository.save(shippingCode);
		
	}

	@Override
	public void remove(ShippingCode shippingCode) {

		ShippingCodeDAO repository = new ShippingCodeDAO();
		repository.delete(shippingCode);
		
	}

	@Override
	public Collection<ShippingCode> getAll() {

		ShippingCodeDAO repository = new ShippingCodeDAO();
		return repository.getAll();
	}

	@Override
	public ShippingCode getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
