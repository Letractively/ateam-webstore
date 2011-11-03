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
	private String productName;
	
	
	private String sku;
	
	/**
	 * product's price
	 */
	private Double price;
	
	
	private Double percentDiscount;
	
	/**
	 * product's description
	 */
	private String description;
	
	private String imagePath = "/images/no_img/";
	
	private Date firstOffered;
	
	private String saleInd;
	
	private Date lastUpdated;
	
	/**
	 * Product
	 */
	@SuppressWarnings("unused")
	private Product() { 		
	}
	
	/**
	 * Initializes a <code>Product</code> and sets...
	 * 
	 * @param name
	 * @param price
	 * @param description
	 */
	public Product(String productName, Double price, String description) {
		super();
		this.productName = productName;
		this.price = price;
		this.description = description;
		
	}

	/**
	 * Get the product's name
	 * 
	 * @return name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Set the product's name
	 * @param name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getSKU() {
		return sku;
	}

	public void setSKU(String sku) {
		this.sku = sku;
	}

	public Double getPercentDiscount() {
		return percentDiscount;
	}

	public void setPercentDiscount(Double percentDiscount) {
		this.percentDiscount = percentDiscount;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Date getFirstOffered() {
		return firstOffered;
	}

	public void setFirstOffered(Date firstOffered) {
		this.firstOffered = firstOffered;
	}

	public String getSaleInd() {
		return saleInd;
	}

	public void setSaleInd(String saleInd) {
		this.saleInd = saleInd;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}