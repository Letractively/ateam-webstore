/**
 * 
 */
package com.ateam.webstore.model;

import java.io.Serializable;
import java.util.Collection;

import javax.jdo.annotations.PersistenceCapable;

import com.ateam.webstore.dao.common.BaseModel;

/**
 * @author Hendrix Tavarez
 *
 */
@PersistenceCapable
public class SubCategory extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6953582594821141998L;
	
	private Long subcategoryID;
	
	private String subcategoryName;
	
	private Category category;
	
	private Collection<Product> products;
	
	@SuppressWarnings("unused")
	private SubCategory(){
	}
	
	public SubCategory(String subcategoryName) {
		super();
		this.subcategoryName = subcategoryName;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getId() {
		return subcategoryID;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	public void removeProduct(Product product) {
		this.products.remove(product);
	}
	
	public Collection<Product> getProducts() {
		return this.products;
	}

}
