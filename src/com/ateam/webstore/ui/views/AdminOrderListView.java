package com.ateam.webstore.ui.views;

import java.util.Collection;

import com.ateam.webstore.model.Orders;


public class AdminOrderListView extends View {
	Collection<Orders> order;
	String listTitle;
	
	
	public Collection<Orders> getOrder() {
		return order;
	}

	public void setOrder(Collection<Orders> order) {
		this.order = order;
	}

	
	public AdminOrderListView(View v) {
		super(v);
	}
	
	public String getListTitle() {
		return listTitle;
	}

	public void setListTitle(String listTitle) {
		this.listTitle = listTitle;
	}

	

	
}
