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
	
	private String description;
	
	private Product product;
	
	private Customer customer;
	
	@SuppressWarnings("unused")
	private Review() {
	}

	public Review(String description, Product product, Customer customer) {
		super();
		this.description = description;
		this.product = product;
		this.customer = customer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	

}
