package com.ateam.webstore.ui.views;

import java.util.List;

import com.ateam.webstore.ui.models.Product;

public class HomePageView extends View {
	List<Product> featuredProducts;
	
	public List<Product> getFeaturedProducts() {
		return featuredProducts;
	}
	public void setFeaturedProducts(List<Product> featuredProducts) {
		this.featuredProducts = featuredProducts;
	}
}
