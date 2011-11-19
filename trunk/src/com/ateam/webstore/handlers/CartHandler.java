package com.ateam.webstore.handlers;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Cart;
import com.ateam.webstore.model.Orders;
import com.ateam.webstore.service.impl.CartService;
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
		
		CartView cv = new CartView(getMainView());
		
		cv.addContentView(new ContentView(JSP_CART, "Your Cart"));
		
		return cv;
	}
	
	/**
	 * Initiate an order from a cart.
	 * @return
	 */
	public View checkout() {

		//Check auth
		Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
		if (v.isAuthenticated()) {
			CustomerHandler ch = new CustomerHandler(req);
			return ch.getLoginView("Please first login");
		}
		
		//TODO the Cart needs to supply # of items, and subtotal
		Orders order = new Orders(2, 99.99, 0.0, 0.0, v.getCustomer(), null, null, null);
		
		//Add order to session
		req.getSession().setAttribute(SESSION_ATTRIBUTE_ORDER, order);
		
		OrderHandler oh = new OrderHandler(req);
		
		return oh.getOrderShippingView(v.getCustomer().getId());
	}
	
	/**
	 * Add a product to the users cart
	 * @return
	 */
	public FormSubmission addProduct() {
		
		FormSubmission add = new FormSubmission();
		
		//Check auth
		Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
		if (v.isAuthenticated()) {
			CustomerHandler ch = new CustomerHandler(req);
			add.setResultView(ch.getLoginView("Please first login"));
			add.setResultMessage("Please first logon");
		}
		String prodId = req.getParameter(Parameters.PRODUCT_ID.getId());
		l.fine("add prodId :"+prodId);		
		//TODO add product to cart via cart service.
		//service.

		add.setResultView(getCartView());
		
		return add;
	}
}
