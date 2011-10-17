package com.ateam.webstore.servlets;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Product;
import com.ateam.webstore.service.impl.ProductService;
import com.ateam.webstore.ui.forms.ProductEditForm;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.HomePageView;
import com.ateam.webstore.ui.views.ProductDetailsView;
import com.ateam.webstore.ui.views.View;

/**
 * Handles all Servlet requests related to Products
 * @author Brendon Drew
 *
 */
public class ProductHandler extends Handler {
	
	static Logger l = Logger.getLogger(ProductHandler.class.getName().toString());

	/**
	 * 
	 * @param req
	 */
	public ProductHandler(HttpServletRequest req) {
		super(req);
		//service = new ProductService();
	}
	
	/**
	 * Gets a product from DB
	 * @param id
	 * @return
	 */
	private Product getProduct(String name) {
		
		//ProductService productServ = new ProductService();			
		//return (Product) productServ.getProductByName(name).toArray()[0];
		return null;
	}
	
	/**
	 * Get featured products from DB
	 * @param id
	 * @return
	 */
	private Collection<Product> getFeaturedProducts() {
		// TODO Implement for real
		//      We need to either a flag on product table to know what's featured, or
		//      We could just pick them from getAll()
		//      BEWARE: the output should be limited to 6 records.
		
		Collection<Product> featured = new ArrayList<Product>();
		
		//ProductService productServ = new ProductService();
		//Collection<com.ateam.webstore.model.Product> products = productServ.getAll();
		//for (com.ateam.webstore.model.Product product : products) {
		//	featured.add(product);
		//}	
				
//		featured.add(getProduct("iMac"));
//		featured.add(getProduct("iPod"));
//		featured.add(getProduct("iPhone"));
//		featured.add(getProduct("iPad"));
		l.info("returning "+featured.size()+" products");
		return featured;
		
	}
	
	/**
	 * Gets all products in the given category
	 * @param category
	 * @return
	 */
	private Collection<Product> getCategory(String category) {
		// TODO Auto-generated method stub
		//category = service.getCategory(id);
		return null;
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

	/**
	 * Builds a returns the view for a product category.
	 * @param category
	 * @return
	 */
	public View getCategoryView(String category) {
		// TODO Auto-generated method stub
		//TODO Should return ProductListView
		return null;
	}

	
	/**
	 * Builds a returns the view for search results
	 * @param query
	 * @return
	 */
	public Collection<Product> getSearchResults(String query) {
		// TODO Auto-generated method stub
		//TODO Should return ProductListView
		return null;
		
	}
	
	/**
	 * Get the view for a specific product.
	 * @param req
	 * @return
	 */
	public ProductDetailsView getProductView(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Updates a product entry.
	 */
	public void update(ProductEditForm update) {
		service.store(update.getProduct());
	}

}
