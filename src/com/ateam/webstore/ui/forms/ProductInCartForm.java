package com.ateam.webstore.ui.forms;

import com.ateam.webstore.model.Product;

public class ProductInCartForm {
private static final long serialVersionUID = 6996210412301012927L;
	
	private int itemQuantity;
	
	private Product product;
	
	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	

}
