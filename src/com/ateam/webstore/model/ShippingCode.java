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
public class ShippingCode extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8327543085476210053L;
	
	private int shippingCode;
	
	private String description;
	
	private int itemQty;
	
	private Double cost;
	
	private Shipper shipper;
	
	@SuppressWarnings("unused")
	private ShippingCode() {
	}

	public ShippingCode(int shippingCode, String description, Shipper shipper) {
		super();
		this.shippingCode = shippingCode;
		this.description = description;
		this.shipper = shipper;
	}

	public int getShippingCode() {
		return shippingCode;
	}

	public void setShippingCode(int shippingCode) {
		this.shippingCode = shippingCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Shipper getShipper() {
		return shipper;
	}

	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}
	
	

}
