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
public class ItemsOrdered extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4290106147044135362L;
	
	private Double unitPrice;
	
	private int itemQty;
	
	private boolean shippedInd;
	
	private Orders orders;
	
	private Product product;
	
	@SuppressWarnings("unused")
	private ItemsOrdered() {
	}

	public ItemsOrdered(Double unitPrice, int itemQty, boolean shippedInd,
			Orders orders, Product product) {
		super();
		this.unitPrice = unitPrice;
		this.itemQty = itemQty;
		this.shippedInd = shippedInd;
		this.orders = orders;
		this.product = product;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	public boolean isShippedInd() {
		return shippedInd;
	}

	public void setShippedInd(boolean shippedInd) {
		this.shippedInd = shippedInd;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
