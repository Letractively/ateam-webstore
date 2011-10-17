package com.ateam.webstore.servlets;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Orders;
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
		//Orders order = new Orders();
		OrderShippingView osv = new OrderShippingView();
		//Add order to session
		//req.getSession().setAttribute(SESSION_ATTRIBUTE_ORDER, order);
		//osv.setOrder(order);
		
		//osv.setUserAddresses(userAddresses);
		//osv.setShippers(shippers);
		
		return null;
	}
}
