package com.ateam.webstore.model;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;

import com.ateam.webstore.dao.common.BaseModel;

/**
 * @author Hendrix Tavarez
 *
 */
@PersistenceCapable
public class Product extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4724907274187650862L;
	
	/**
	 * object id
	 */
	private Long id;
	
	/**
	 * product's name
	 */
	private String name;
	
	/**
	 * product's price
	 */
	private Double price;
	
	/**
	 * product's description
	 */
	private String description;
	
	/**
	 * Product
	 */
	private Product() { 		
	}
	
	/**
	 * Initializes a <code>Product</code> and sets...
	 * 
	 * @param name
	 * @param price
	 * @param description
	 */
	private Product(String name, Double price, String description) {
		
		this.name = name;
		this.price = price;
		this.description = description;
		
	}

	/**
	 * Get the product's name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the product's name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	/**
	 * Set the product's price
	 * 
	 * @param price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Get the product's description
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the product's description
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the product object id
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

}
