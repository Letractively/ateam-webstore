/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.CartDAO;
import com.ateam.webstore.model.Cart;
import com.ateam.webstore.model.Customer;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class CartService implements RepositoryService<Cart> {

	@Override
	public Cart store(Cart cart) {
		
		CartDAO repository = new CartDAO();
		return repository.save(cart);
		
	}

	@Override
	public void remove(Cart cart) {
		
		CartDAO repository = new CartDAO();
		repository.delete(cart);
		
	}

	@Override
	public Collection<Cart> getAll() {

		CartDAO repository = new CartDAO();
		return repository.getAll();
		
	}

	@Override
	public Cart getById(Serializable id) {
		CartDAO repository = new CartDAO();
		return repository.get(id);
	}
	
	public Cart getByCustomerId(Serializable customerID) {
		
		Customer customer = new CustomerService().getById(customerID);		
		CartDAO repository = new CartDAO();
		return repository.getByCustomer(customer);
	}

}
