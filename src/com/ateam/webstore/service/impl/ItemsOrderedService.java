/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.util.Collection;

import com.ateam.webstore.dao.ItemsOrderedDAO;
import com.ateam.webstore.model.ItemsOrdered;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class ItemsOrderedService implements RepositoryService<ItemsOrdered> {

	@Override
	public ItemsOrdered store(ItemsOrdered itemsOrdered) {
		
		ItemsOrderedDAO repository = new ItemsOrderedDAO();
		return repository.save(itemsOrdered);
	}

	@Override
	public void remove(ItemsOrdered itemsOrdered) {
		
		ItemsOrderedDAO repository = new ItemsOrderedDAO();
		repository.delete(itemsOrdered);
		
	}

	@Override
	public Collection<ItemsOrdered> getAll() {

		ItemsOrderedDAO repository = new ItemsOrderedDAO();
		return repository.getAll();
	}

}