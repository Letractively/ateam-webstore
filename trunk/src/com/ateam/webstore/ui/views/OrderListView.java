package com.ateam.webstore.ui.views;

import java.util.Collection;

import com.ateam.webstore.model.Orders;

public class OrderListView extends View {

	Collection<Orders> orders;
	String listTitle;
	
	public OrderListView() {
		// TODO Auto-generated constructor stub
	}

	public OrderListView(View v) {
		super(v);
		// TODO Auto-generated constructor stub
	}

	public Collection<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Orders> orders) {
		this.orders = orders;
	}

	public String getListTitle() {
		return listTitle;
	}

	public void setListTitle(String listTitle) {
		this.listTitle = listTitle;
	}
	
	

}
