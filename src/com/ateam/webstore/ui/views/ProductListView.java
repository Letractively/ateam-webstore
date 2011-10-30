package com.ateam.webstore.ui.views;

import java.util.List;

import com.ateam.webstore.model.Product;

public class ProductListView extends View {
	List<Product> product;

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	
}
