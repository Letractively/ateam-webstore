package com.ateam.webstore.ui.views;

import com.ateam.webstore.model.Product;

public class ProductDetailsView extends View {
	Product product;

	public ProductDetailsView(View mainView) {
		super(mainView);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
