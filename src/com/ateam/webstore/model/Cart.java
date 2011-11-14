/**
 * 
 */
package com.ateam.webstore.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;

import com.ateam.webstore.dao.common.BaseModel;

/**
 * @author Hendrix Tavarez
 *
 */
@PersistenceCapable
public class Cart extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5198809297825666966L;
	
	private Long id;
	
	private Date lastUpdated;
	
	private Date lastOrderDate;
	
	private Customer customer;
	
	private Collection<ProductsInCart> products;
	
	@SuppressWarnings("unused")
	private Cart() {
	}

	public Cart(Customer customer) {
		super();
		this.customer = customer;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Date getLastOrderDate() {
		return lastOrderDate;
	}

	public void setLastOrderDate(Date lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
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
	
	public void addProduct(ProductsInCart product) {
		this.products.add(product);
	}
	
	public void removeProduct(ProductsInCart product) {
		this.products.remove(product);
	}
	
	public Collection<ProductsInCart> getProducts() {
		return this.products;
	}
	

}
