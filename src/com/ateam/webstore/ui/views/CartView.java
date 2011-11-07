package com.ateam.webstore.ui.views;

import java.util.Collection;

import com.ateam.webstore.model.ProductsInCart;

public class CartView extends View {
	private static final long serialVersionUID = 6996210412301012927L;

	Collection<ProductsInCart> productincart;
	String listTitle;

	public CartView(View v) {
		super(v);
	}

	public Collection<ProductsInCart> getProducts() {
		return productincart;
	}

	public void setProducts(Collection<ProductsInCart> productincart) {
		this.productincart = productincart;
	}

}
