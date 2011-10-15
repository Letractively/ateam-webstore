package com.ateam.webstore.ui.forms;

import com.ateam.webstore.model.Product;

public class ProductEditForm extends FormSubmission {
	Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
