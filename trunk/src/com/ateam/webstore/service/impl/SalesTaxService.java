/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.SalesTaxDAO;
import com.ateam.webstore.model.SalesTax;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class SalesTaxService implements RepositoryService<SalesTax> {

	@Override
	public SalesTax store(SalesTax salesTax) {

		SalesTaxDAO repository = new SalesTaxDAO();
		return repository.save(salesTax);
		
	}

	@Override
	public void remove(SalesTax salesTax) {
		
		SalesTaxDAO repository = new SalesTaxDAO();
		repository.delete(salesTax);
		
	}

	@Override
	public Collection<SalesTax> getAll() {

		SalesTaxDAO repository = new SalesTaxDAO();
		return repository.getAll();
		
	}

	@Override
	public SalesTax getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
