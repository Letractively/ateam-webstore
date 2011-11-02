package com.ateam.webstore.ui.views;

import java.util.Collection;

import com.ateam.webstore.model.Product;

public class ProductListView extends View {
	Collection<Product> product;
	String listTitle;

	public ProductListView(View v) {
		super(v);
	}
	public Collection<Product> getProducts() {
		return product;
	}

	public void setProducts(Collection<Product> product) {
		this.product = product;
	}

	public String getListTitle() {
		return listTitle;
	}

	public void setListTitle(String listTitle) {
		this.listTitle = listTitle;
	}

	

	
}
