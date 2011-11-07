/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.util.Collection;

import com.ateam.webstore.dao.OrdersDAO;
import com.ateam.webstore.model.Orders;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class OrdersService implements RepositoryService<Orders> {

	@Override
	public Orders store(Orders orders) {
		
		OrdersDAO repository = new OrdersDAO();
		return repository.save(orders);
		
	}

	@Override
	public void remove(Orders orders) {
		
		OrdersDAO repository = new OrdersDAO();
		repository.delete(orders);
		
	}

	@Override
	public Collection<Orders> getAll() {
		
		OrdersDAO repository = new OrdersDAO();
		return repository.getAll();
	}

}