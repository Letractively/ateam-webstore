package com.ateam.webstore.model;

import java.util.Date;

/**
 * @author Hendrix Tavarez
 *
 * The <code>ProductListing</code> class represents a product listing.
 * 
 * This class is NOT persistent in inventory. Only use as a JDO Result class.
 * 
 *
 */
public class ProductListing {
	
	private int productID;
	
	private String productName;
	
	private String sku;
	
	private String modelNumber;
	
	/**
	 * product's price
	 */
	private Double price;
	
	
	private Double percentDiscount;
	
	/**
	 * product's description
	 */
	private String description;
	
	private int qtyOnHand;
	
	private String imagePath = "/images/no_img/";
	
	private Date firstOffered;
	
	private String saleInd;
	
	private Date lastUpdated;
	
	public ProductListing() {
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPercentDiscount() {
		return percentDiscount;
	}

	public void setPercentDiscount(Double percentDiscount) {
		this.percentDiscount = percentDiscount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQtyOnHand() {
		return qtyOnHand;
	}

	public void setQtyOnHand(int qtyOnHand) {
		this.qtyOnHand = qtyOnHand;
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
