package com.ateam.webstore.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Category;
import com.ateam.webstore.model.Product;
import com.ateam.webstore.service.impl.ProductService;
import com.ateam.webstore.servlets.AteamContextListener;
import com.ateam.webstore.ui.forms.ProductEditForm;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.ProductDetailsView;
import com.ateam.webstore.ui.views.ProductListView;

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
		service = new ProductService();
	}
	
	/**
	 * Gets a product from DB
	 * @param id
	 * @return
	 */
	private Product getProduct(String name) {
		
		//ProductService productServ = new ProductService();
		//service.p
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
	public ProductListView getHomePageView() {
		
		ProductListView hp = new ProductListView(getMainView());
		
		hp.setProducts(getDummyProductList());
		
		ContentView cv = new ContentView(JSP_HOME, "Featured Products");
		//cv.setContentText("Check out these winners...");
		
		hp.getContentViews().add(cv);

		return hp;
		
	}

	/**
	 * Builds a returns the view for a product category.
	 * @param category
	 * @return
	 */
	public ProductListView getCategoryView() {
		
		String category = req.getParameter(Parameters.CATEGORY_ID.getId());
		
		Category cat = new Category(category);
		
		ProductListView hp = new ProductListView(getMainView());
		
		hp.setProducts(getDummyProductList());
		
		ContentView cv = new ContentView(JSP_PRODUCT_LIST, cat.getName());
		
		hp.getContentViews().add(cv);

		return hp;
		

	}

	/**
	 * Builds a returns the view for a list of all products
	 * @param category
	 * @return
	 */
	public ProductListView getAllView() {
		
		ProductListView hp = new ProductListView(getMainView());
		
		hp.setProducts(getAllProducts());
		
		ContentView cv = new ContentView(JSP_PRODUCT_LIST, "All Products");
		
		hp.getContentViews().add(cv);

		return hp;
		

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
	public ProductDetailsView getProductView() {
		
		String id = req.getParameter(Parameters.PRODUCT.getId());
		
		ProductDetailsView pv = new ProductDetailsView(getMainView());
		pv.setProduct(getDummyProduct());
		return pv;
	}
	
	/**
	 * Updates a product entry.
	 */
	public void update(ProductEditForm update) {
		service.store(update.getProduct());
	}
	
	/**
	 * 
	 * @return
	 */
	private Collection<Product> getAllProducts() {
		return service.getAll();
	}
	
	private Collection<Product> getDummyProductList() {
		Collection<Product> products = new ArrayList<Product>();
		
		products.add(new Product("TV", 699.99, "A television"));
		products.add(new Product("Tablet", 299.99, "A tablet"));
		products.add(new Product("Laptop", 999.99, "A laptop"));
		products.add(new Product("Blu-ray player", 99.99, "A blue-ray player"));
		products.add(new Product("Stereo", 199.99, "A stero"));
		products.add(new Product("PS3", 299.99, "A playstation"));
		
		return products;
	}

	/**
	 * 
	 * @return
	 */
	private Product getDummyProduct() {
		
		Product prod = new Product("TV", 699.99, "A television");
		//prod.setImagePath("/images/no_img/");
		return prod;
		
	}
	
}
