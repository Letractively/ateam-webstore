package com.ateam.webstore.handlers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.handlers.Handler;
import com.ateam.webstore.model.Address;
import com.ateam.webstore.model.Cart;
import com.ateam.webstore.model.Orders;
import com.ateam.webstore.model.Shipper;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.OrderShippingView;
import com.ateam.webstore.ui.views.View;

public class CartHandler extends Handler {

	public CartHandler(HttpServletRequest req) {
		super(req);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Process a request to view the cart
	 * @param id 
	 * @param req
	 * @return
	 */
	public View getCartView(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Initiate an order from a cart.
	 * @return
	 */
	public OrderShippingView checkout() {

		//Get Cart from session
		Cart c = (Cart) req.getSession().getAttribute(SESSION_ATTRIBUTE_CART);
		
		Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
				
		//TODO the Cart needs to supply # of items, and subtotal
		Orders order = new Orders(2, 99.99, 0.0, 0.0, v.getCustomer(), null, null, null);
		
		//Add order to session
		req.getSession().setAttribute(SESSION_ATTRIBUTE_ORDER, order);
		
		OrderHandler oh = new OrderHandler(req);
		
		return oh.getOrderShippingView(v.getCustomer().getId());
	}
}
