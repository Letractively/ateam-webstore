package com.ateam.webstore.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Cart;
import com.ateam.webstore.model.Customer;
import com.ateam.webstore.model.ItemsOrdered;
import com.ateam.webstore.model.Orders;
import com.ateam.webstore.model.ProductsInCart;
import com.ateam.webstore.model.ProductsInWishList;
import com.ateam.webstore.model.WishList;
import com.ateam.webstore.service.impl.CartService;
import com.ateam.webstore.service.impl.ProductService;
import com.ateam.webstore.service.impl.ProductsInCartService;
import com.ateam.webstore.service.impl.ProductsInWishListService;
import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.CartView;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.View;

public class CartHandler extends Handler {
	/**
	 * 
	 */
	Cart cart;
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * 
	 */
	CartService service;
	
	public CartHandler(HttpServletRequest req) {
		super(req);
	
		service = new CartService();
		//Get Cart from session
		cart = (Cart) req.getSession().getAttribute(SESSION_ATTRIBUTE_CART);
	}
	
	/**
	 * Process a request to view the cart
	 * @param id 
	 * @param req
	 * @return
	 */
	public CartView getCartView() {
		
		l.info("getting cart for session: "+req.getSession().getId());
		
		if (req.getParameter(Parameters.REMOVE.getId()) != null) {
			String removeId = req.getParameter(Parameters.REMOVE.getId());
			l.info("removing cart item "+removeId+" for session: "+req.getSession().getId());
			ProductsInCartService pics = new ProductsInCartService();
			ProductsInCart pic = pics.getById(new Long(removeId));
			pics.remove(pic);
			updateCart();
		}
			
		CartView cv = new CartView(getMainView());
		
		cv.addContentView(new ContentView(JSP_CART, "Your Cart"));
		
		if (cart != null) {
			cv.setProducts(cart.getProducts());
		}
		
		return cv;
	}
	
	/**
	 * Initiate an order from a cart.
	 * @return
	 */
	public View checkout() {

		//Check auth
		Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
		if (!v.isAuthenticated()) {
			l.info("session not authenticated for checkout: "+req.getSession().getId());
			CustomerHandler ch = new CustomerHandler(req);
			View view = ch.getLoginView("Please first login.");
			view.setLoginRedirectPath(req.getContextPath()+"/store?checkout");
			return view;
		}
		
		l.info("start checkout for session: "+req.getSession().getId());
		
		Orders order = new Orders(cart.getProducts().size(), 0.0, 0.0, 0.0, v.getCustomer(), null, null, null);
		
		Collection<ItemsOrdered> items = new ArrayList<ItemsOrdered>();
		for (ProductsInCart prod : cart.getProducts()) {
			ItemsOrdered item = new ItemsOrdered(prod.getProduct().getSalesPrice(), prod.getQuantity(), false, null, prod.getProduct());
			items.add(item);
			order.addItemPrice(prod.getProduct().getSalesPrice());
		}
		
		
		
		//Add order to session
		req.getSession().setAttribute(SESSION_ATTRIBUTE_ORDER, order);
		req.getSession().setAttribute(SESSION_ATTRIBUTE_ORDERED_ITEMS, items);
		
		OrderHandler oh = new OrderHandler(req);
		
		return oh.getOrderShippingView();
	}
	
	/**
	 * Add a product to the users cart
	 * @return
	 */
	public FormSubmission addProduct(String prodId) {
		
		FormSubmission add = new FormSubmission();
		
		//Check auth
		Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
		
		if (prodId == null) {
			prodId = req.getParameter(Parameters.PRODUCT_ID.getId());
		}
		
		req.getSession().setAttribute(SESSION_ATTRIBUTE_PRODUCT_TO_CART, prodId);
		
		if (v == null || !v.isAuthenticated()) {
			l.info("not authenticated for product add ");
			CustomerHandler ch = new CustomerHandler(req);
			add.setResultView(ch.getLoginView());
			add.setResultMessage("Please first login");
			return add;
		}
		
		if (cart == null) {
			l.info("creating cart for session: "+req.getSession().getId());
			Customer cust = v.getCustomer();
			cart = new Cart(cust);
			service.store(cart);
			req.getSession().setAttribute(SESSION_ATTRIBUTE_CART, service.getByCustomerId(cust.getId()));
		}

		l.info("adding product to cart for session: "+req.getSession().getId());

		l.fine("add prodId :"+prodId);		

		ProductsInCart prodInCart = new ProductsInCart(1, cart, new ProductService().getById(new Long(prodId)));
		cart.addProduct(prodInCart);
		service.store(cart);
		
		add.setResultView(getCartView());
		
		return add;
	}

	private void updateCart() {

		l.info("updating cart for session: "+req.getSession().getId());
		
		Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
		cart = service.getByCustomerId(new Long(v.getCustomer().getId()));
		req.getSession().setAttribute(SESSION_ATTRIBUTE_CART, cart);
		
	}

	public FormSubmission processUpdate() {
		
		l.info("modifying cart for session: "+req.getSession().getId());
		
		FormSubmission fs = new FormSubmission();
		
		try {
			String action = req.getParameter(Parameters.CART_ACTION.getId()); 
			
			if (action.equals("Checkout")) {
				fs.setResultView(checkout());
			}
			else if (action.equals("Move Selected to WishList")) {
				fs = moveSelectedToWishList();
			}
			else if (action.equals("Update Quantity")) {
				for (Enumeration e = req.getParameterNames() ; e.hasMoreElements() ;) {
					String name = (String) e.nextElement();
					if (name.endsWith(Constants.Parameters.PRODUCT_QUANTITY.getId())) {
						String[] parts = name.split("_");
						Integer quantity = Integer.parseInt(req.getParameter(name));						
						String id = parts[0];
						l.fine("updating qty for "+id);
						ProductsInCartService pics = new ProductsInCartService();
						ProductsInCart pic = pics.getById(new Long(id));
						
						if (quantity == 0) {
							pics.remove(pic);							
						}
						else {
							pic.setQuantity(quantity);
							pics.store(pic);
						}
					}
				}
				updateCart();
				fs.setResultView(getCartView());			
			}
		} catch (Exception e) {
			l.log(Level.WARNING, "Unable to process cart update", e);
			View v = getCartView();
			v.setMessage("Unable to process request.");
			fs.setResultView(v);
			fs.setResultMessage("Unable to process request.");
		}


		
		return fs;
	}
	
	public FormSubmission moveSelectedToWishList() {

		WishListHandler wlh = new WishListHandler(req);
		ProductsInCartService pics = new ProductsInCartService();
		FormSubmission fs = new FormSubmission();
		
		int i = 0;
		
		for (ProductsInCart p : cart.getProducts()) {
			String prodId = p.getProduct().getId()+"";
			if (req.getParameter(prodId) != null) {
				l.fine("moving prodId :"+prodId+" to wish list");
				wlh.addProduct(prodId);
				pics.remove(p);
				i++;
			}
		}
		
		if (i > 0) {
			fs.setResultView(wlh.getWishListView());	
			fs.setResultMessage(i+" products moved to your wish list.");
		}
		else {
			fs.setResultView(getCartView());	
			fs.setResultMessage("No products were selected");
		}

		return fs;
	}
	
	/**
	 * 
	 */
	public void delete() {
		l.info("Deleting user cart ");
		ProductsInCartService pics = new ProductsInCartService();
		
		for (ProductsInCart p : cart.getProducts()) {
			l.fine("deleting prodId :"+p.getId()+" from cart");
			pics.remove(p);
		}
		
		service.remove(cart);
		updateCart();
	}
}
