package com.ateam.webstore.servlets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Product;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.HomePageView;
import com.ateam.webstore.ui.views.ProductDetailsView;
import com.ateam.webstore.ui.views.View;

public class ProductHandler extends Handler {
	
	static Logger l = Logger.getLogger(ProductHandler.class.getName().toString());

	/**
	 * 
	 * @param req
	 */
	public ProductHandler(HttpServletRequest req) {
		super(req);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Product getProduct(String id) {
		// TODO Implement for real
		Product p = new Product();
		p.setProductName(id);
		p.setPrice(12.99);
		p.setDescription("hello description!");
		return p;
	}
	
	/**
	 * Get festured from DB
	 * @param id
	 * @return
	 */
	private Collection<Product> getFeaturedProducts() {
		// TODO Implement for real
		Collection<Product> featured = new ArrayList<Product>();
		featured.add(getProduct("Foo"));
		featured.add(getProduct("Bar"));
		featured.add(getProduct("Thing 1"));
		featured.add(getProduct("Thing 2"));
		featured.add(getProduct("One Fish"));
		featured.add(getProduct("Two Fish"));
		l.info("returning "+featured.size()+" products");
		return featured;
		
	}
	
	/**
	 * Gets the home page view.
	 * @return
	 */
	public HomePageView getHomePageView() {
		
		HomePageView hp = new HomePageView(getMainView(req));
		
		hp.setFeaturedProducts(getFeaturedProducts());
		
		ContentView cv = new ContentView();
		cv.setContentHeader("Featured Products");
		cv.setContentText("Check out these winners...");
		cv.setJspf(JSP_HOME);
		
		hp.getContentViews().add(cv);

		return hp;
		
	}
	
	public Collection<Product> getCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public View getCategoryView(String category) {
		// TODO Auto-generated method stub
		//TODO Should return ProductListView
		return null;
	}

	
	/**
	 * 
	 * @param query
	 * @return
	 */
	public Collection<Product> getSearchResults(String query) {
		return null;
		
	}
	
	/**
	 * Get the product view
	 * @param req
	 * @return
	 */
	public ProductDetailsView getProductView() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
