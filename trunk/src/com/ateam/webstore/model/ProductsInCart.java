/**
 * 
 */
package com.ateam.webstore.model;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;

import com.ateam.webstore.dao.common.BaseModel;

/**
 * @author Hendrix Tavarez
 *
 */
@PersistenceCapable
public class ProductsInCart extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2556110206738038991L;
	
	private Long id;
	
	private int quantity;
	
	private Date timeAdded;
	
	private Cart cart;
	
	private Product product;
	
	@SuppressWarnings("unused")
	private ProductsInCart() {
	}

	public ProductsInCart(int quantity, Cart cart, Product product) {
		super();
		this.quantity = quantity;
		this.cart = cart;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getTimeAdded() {
		return timeAdded;
	}

	public void setTimeAdded(Date timeAdded) {
		this.timeAdded = timeAdded;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getId() {
		return id;
	}
	
	

}
