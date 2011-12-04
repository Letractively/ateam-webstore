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
	
	private Boolean active = true;

	private Date lastUpdated;
	
	private Brand brand;
	
	private SubCategory subCategory;
	
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
	 * Get a limited form of the product name
	 * @return
	 */
	public String getShortProductName(int limit) {
		if (productName != null && productName.length() > limit) {
			return productName.substring(0,limit)+"...";
		}
		else {
			return productName;
		}
	}

	/**
	 * Set the product's name
	 * @param name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Get the current sale price
	 * @return
	 */
	public Double getPrice() {
		return price;
	}
	
	/**
	 * Get the current sale price
	 * @return
	 */
	public Double getSalesPrice() {
		if (isOnSale()) {
			return price - (percentDiscount / 100) * price;
		}
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

	public int getQtyOnHand() {
		return qtyOnHand;
	}

	public void setQtyOnHand(int qtyOnHand) {
		this.qtyOnHand = qtyOnHand;
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

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
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
	
	/**
	 * Check if the sale indicator is set
	 * @return
	 */
	public boolean isOnSale() {
		if (saleInd != null) {
			return saleInd.contains("T");
		}
		else {
			return false;
		}
	}
	
	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}	

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

}
