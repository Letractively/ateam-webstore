package com.ateam.webstore.ui.views;

import java.util.Collection;

import com.ateam.webstore.model.Product;
import com.ateam.webstore.model.ProductListing;

public class ProductListingView extends View {
	Collection<ProductListing> product;
	String listTitle;

	public ProductListingView(View v) {
		super(v);
	}
	public Collection<ProductListing> getProducts() {
		return product;
	}

	public void setProducts(Collection<ProductListing> product) {
		this.product = product;
	}

	public String getListTitle() {
		return listTitle;
	}

	public void setListTitle(String listTitle) {
		this.listTitle = listTitle;
	}

	
}
