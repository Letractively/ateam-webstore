/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.WishListDAO;
import com.ateam.webstore.model.Customer;
import com.ateam.webstore.model.WishList;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class WishListService implements RepositoryService<WishList> {

	@Override
	public WishList store(WishList wishList) {

		WishListDAO repository = new WishListDAO();
		return repository.save(wishList);
		
	}

	@Override
	public void remove(WishList wishList) {
		
		WishListDAO repository = new WishListDAO();
		repository.delete(wishList);
		
	}

	@Override
	public Collection<WishList> getAll() {
		
		WishListDAO repository = new WishListDAO();
		return repository.getAll();
		
	}

	@Override
	public WishList getById(Serializable id) {
		WishListDAO repository = new WishListDAO();
		return repository.get(id);
	}
	
	public WishList getByCustomerId(Serializable customerID) {
		
		Customer customer = new CustomerService().getById(customerID);		
		WishListDAO repository = new WishListDAO();
		return repository.getByCustomer(customer);
	}	

}
