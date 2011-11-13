/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.SubCategoryDAO;
import com.ateam.webstore.model.SubCategory;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class SubCategoryService implements RepositoryService<SubCategory> {

	@Override
	public SubCategory store(SubCategory subCategory) {
		
		SubCategoryDAO repository = new SubCategoryDAO();
		return repository.save(subCategory);
	}

	@Override
	public void remove(SubCategory subCategory) {
		
		SubCategoryDAO repository = new SubCategoryDAO();
		repository.delete(subCategory);
		
	}

	@Override
	public Collection<SubCategory> getAll() {
		
		SubCategoryDAO repository = new SubCategoryDAO();
		return repository.getAll();
	}

	@Override
	public SubCategory getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
