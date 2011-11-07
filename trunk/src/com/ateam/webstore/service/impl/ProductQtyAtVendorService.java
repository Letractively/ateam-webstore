/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.util.Collection;

import com.ateam.webstore.dao.ProductQtyAtVendorDAO;
import com.ateam.webstore.model.ProductQtyAtVendor;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class ProductQtyAtVendorService implements
		RepositoryService<ProductQtyAtVendor> {

	@Override
	public ProductQtyAtVendor store(ProductQtyAtVendor productQtyAtVendor) {

		ProductQtyAtVendorDAO repository = new ProductQtyAtVendorDAO();
		return repository.save(productQtyAtVendor);
	}

	@Override
	public void remove(ProductQtyAtVendor productQtyAtVendor) {
		
		ProductQtyAtVendorDAO repository = new ProductQtyAtVendorDAO();
		repository.delete(productQtyAtVendor);
		
	}

	@Override
	public Collection<ProductQtyAtVendor> getAll() {
		
		ProductQtyAtVendorDAO repository = new ProductQtyAtVendorDAO();
		return repository.getAll();
	}

}
