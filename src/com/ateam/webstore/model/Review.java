/**
 * 
 */
package com.ateam.webstore.model;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;

import com.ateam.webstore.dao.common.BaseModel;

/**
 * @author Hendrix Tavarez
 *
 */
@PersistenceCapable
public class Review extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6215890916134251857L;
	
	private Long id;
	
	private int rating;
	
	private String review;
	
	private Product product;
	
	private Customer customer;
	
	@SuppressWarnings("unused")
	private Review() {
	}

	public Review(String review, Product product, Customer customer) {
		super();
		this.review = review;
		this.product = product;
		this.customer = customer;
	}

	public String getDescription() {
		return review;
	}

	public void setDescription(String review) {
		this.review = review;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
