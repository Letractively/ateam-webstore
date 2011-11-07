package com.ateam.webstore.handlers;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Cart;
import com.ateam.webstore.model.Orders;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.CartView;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.OrderShippingView;

public class CartHandler extends Handler {

	/**
	 * 
	 */
	Cart cart;
	
	public CartHandler(HttpServletRequest req) {
		super(req);
	
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
		
		cv.setCart(cart);
		
		cv.addContentView(new ContentView(JSP_CART, "Your Cart"));
		
		return cv;
	}
	
	/**
	 * Initiate an order from a cart.
	 * @return
	 */
	public OrderShippingView checkout() {

		Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
				
		//TODO the Cart needs to supply # of items, and subtotal
		Orders order = new Orders(2, 99.99, 0.0, 0.0, v.getCustomer(), null, null, null);
		
		//Add order to session
		req.getSession().setAttribute(SESSION_ATTRIBUTE_ORDER, order);
		
		OrderHandler oh = new OrderHandler(req);
		
		return oh.getOrderShippingView(v.getCustomer().getId());
	}
	
	public FormSubmission addProduct() {
		FormSubmission add = new FormSubmission();
		add.setResultView(getCartView());
		return add;
	}
}
