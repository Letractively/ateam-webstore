package com.ateam.webstore.ui.views;

import com.ateam.webstore.model.Orders;
/**
 * Used to pass general order info the the UI.  This can be used for
 * multiple purposes, i.e. an order preview, reviewing a previous order, etc.
 * 
 * @author Brendon Drew
 *
 */
public class OrderDetailsView extends View{
	Orders order;

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
}
