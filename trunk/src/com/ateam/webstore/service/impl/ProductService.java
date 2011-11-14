package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.ProductDAO;
import com.ateam.webstore.model.Product;
import com.ateam.webstore.service.RepositoryService;

public class ProductService implements RepositoryService<Product> {
	
	/**
	 * Initializes a <code>ProductService</code> 
	 */
	public ProductService(){
		super();
	}

	@Override
	public Product store(Product product) {
		
		ProductDAO repository = new ProductDAO();
		return repository.save(product);
		
	}

	@Override
	public void remove(Product product) {
		
		ProductDAO repository = new ProductDAO();
		repository.delete(product);
		
	}

	@Override
	public Collection<Product> getAll() {
		
		ProductDAO repository = new ProductDAO();
		return repository.getAll();
		
	}

	public Collection<Product> getProductByName(String name) {
		
		ProductDAO repository = new ProductDAO();
		return repository.getProductByName(name);
	}

	@Override
	public Product getById(Serializable id) {
		ProductDAO repository = new ProductDAO();
		return repository.get(id);
	}

	public Collection<Product> getFeaturedProducts() {
		ProductDAO repository = new ProductDAO();
		
		return repository.getFeaturedProducts();
	}
}
