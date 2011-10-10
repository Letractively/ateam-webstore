package com.ateam.webstore.service;

import java.util.Collection;

import com.ateam.webstore.model.Product;

/**
 * @author Hendrix Tavarez
 *
 */
public interface IProduct {

	/**
	 * Save product in database
	 * 
	 * @param product
	 * @return
	 */
	public Product store(Product product);
	
	/**
	 * Remove product from database
	 * 
	 * @param product
	 */
	public void remove(Product product);
	
	/**
	 * Get all products in the database
	 * 
	 * @return all products
	 */
	public Collection<Product> getAll();
	
	/**
	 * Find products by name
	 * 
	 * @param name
	 * @return a list of products by name
	 */
	public Collection<Product> getProductByName(String name);
	
}
