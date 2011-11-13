/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.ReviewDAO;
import com.ateam.webstore.model.Review;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class ReviewService implements RepositoryService<Review> {

	@Override
	public Review store(Review review) {
		
		ReviewDAO repository = new ReviewDAO();
		return repository.save(review);
	}

	@Override
	public void remove(Review review) {

		ReviewDAO repository = new ReviewDAO();
		repository.delete(review);
		
	}

	@Override
	public Collection<Review> getAll() {
		
		ReviewDAO repository = new ReviewDAO();
		return repository.getAll();
	}

	@Override
	public Review getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
