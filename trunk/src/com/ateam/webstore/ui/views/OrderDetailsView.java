package com.ateam.webstore.ui.views;

import java.util.Collection;

import com.ateam.webstore.model.ItemsOrdered;
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
	Collection<ItemsOrdered> items;
	boolean orderPreview;

	public OrderDetailsView(View v) {
		super(v);
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Collection<ItemsOrdered> getItems() {
		return items;
	}

	public void setItems(Collection<ItemsOrdered> items) {
		this.items = items;
	}

	public boolean isOrderPreview() {
		return orderPreview;
	}

	public void setOrderPreview(boolean orderPreview) {
		this.orderPreview = orderPreview;
	}
}
