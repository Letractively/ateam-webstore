package com.ateam.webstore.ui.models;

import java.util.List;

public class Cart  {
	List<ProductInCart> productsincart;
    
	public List<ProductInCart> getProducts() {
		return productsincart;
	}

	public void setProducts(List<ProductInCart> productsincart) {
		this.productsincart = productsincart;
	}
	
	
}
