package com.ateam.webstore.ui.views;

import com.ateam.webstore.ui.models.Product;

public class ProductDetailsView extends View {
	Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}