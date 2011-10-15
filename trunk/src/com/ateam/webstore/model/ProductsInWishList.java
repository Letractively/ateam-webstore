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
public class ProductsInWishList extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1766128488366368977L;
	
	private int quantity;
	
	private Date timeAdded;
	
	private WishList wishList;
	
	private Product product;
	
	@SuppressWarnings("unused")
	private ProductsInWishList() {
	}

	public ProductsInWishList(int quantity, WishList wishList, Product product) {
		super();
		this.quantity = quantity;
		this.wishList = wishList;
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

	public WishList getWishList() {
		return wishList;
	}

	public void setWishList(WishList wishList) {
		this.wishList = wishList;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
