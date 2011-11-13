/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.ProductsInCartDAO;
import com.ateam.webstore.model.ProductsInCart;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class ProductsInCartService implements RepositoryService<ProductsInCart> {

	@Override
	public ProductsInCart store(ProductsInCart productsInCart) {
		
		ProductsInCartDAO repository = new ProductsInCartDAO();
		return repository.save(productsInCart);
	}

	@Override
	public void remove(ProductsInCart productsInCart) {
		
		ProductsInCartDAO repository = new ProductsInCartDAO();
		repository.delete(productsInCart);
		
	}

	@Override
	public Collection<ProductsInCart> getAll() {

		ProductsInCartDAO repository = new ProductsInCartDAO();
		return repository.getAll();
	}

	@Override
	public ProductsInCart getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
