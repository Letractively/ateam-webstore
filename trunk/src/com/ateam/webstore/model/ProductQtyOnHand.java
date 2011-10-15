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
public class ProductQtyOnHand extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 297713466307691138L;
	
	private int qtyOnHand;
	
	private int openOrderQty;
	
	private Product product;
	
	@SuppressWarnings("unused")
	private ProductQtyOnHand() {
	}

	public ProductQtyOnHand(int qtyOnHand, Product product) {
		super();
		this.qtyOnHand = qtyOnHand;
		this.product = product;
	}

	public int getQtyOnHand() {
		return qtyOnHand;
	}

	public void setQtyOnHand(int qtyOnHand) {
		this.qtyOnHand = qtyOnHand;
	}

	public int getOpenOrderQty() {
		return openOrderQty;
	}

	public void setOpenOrderQty(int openOrderQty) {
		this.openOrderQty = openOrderQty;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
