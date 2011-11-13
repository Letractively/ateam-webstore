/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.CategoryDAO;
import com.ateam.webstore.model.Category;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class CategoryService implements RepositoryService<Category> {

	@Override
	public Category store(Category category) {
		
		CategoryDAO repository = new CategoryDAO();
		return repository.save(category);
	}

	@Override
	public void remove(Category category) {
		
		CategoryDAO repository = new CategoryDAO();
		repository.delete(category);
		
	}

	@Override
	public Collection<Category> getAll() {
		
		CategoryDAO repository = new CategoryDAO();
		return repository.getAll();
	}

	@Override
	public Category getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
