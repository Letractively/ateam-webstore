/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.util.Collection;

import com.ateam.webstore.dao.BrandDAO;
import com.ateam.webstore.model.Brand;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class BrandService implements RepositoryService<Brand> {

	@Override
	public Brand store(Brand brand) {
		
		BrandDAO repository = new BrandDAO();
		return repository.save(brand);
		
	}

	@Override
	public void remove(Brand brand) {

		BrandDAO repository = new BrandDAO();
		repository.delete(brand);
	}

	@Override
	public Collection<Brand> getAll() {

		BrandDAO repository = new BrandDAO();
		return repository.getAll();
		
	}

}
