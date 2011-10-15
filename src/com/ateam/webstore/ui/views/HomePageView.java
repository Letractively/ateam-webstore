package com.ateam.webstore.ui.views;

import java.util.Collection;
import java.util.logging.Logger;

import com.ateam.webstore.model.Product;


public class HomePageView extends View {
	static Logger l = Logger.getLogger(HomePageView.class.getName().toString());
	Collection<Product> featuredProducts;
	
	public HomePageView(View v) {
		super(v);
	}
	public Collection<Product> getFeaturedProducts() {
		if (featuredProducts != null) {
			l.info("returning "+featuredProducts.size()+" products");	
		}
		return featuredProducts;
	}
	public void setFeaturedProducts(Collection<Product> featuredProducts) {
		this.featuredProducts = featuredProducts;
	}
}
