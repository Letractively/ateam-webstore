package com.ateam.webstore.ui.views;

import java.util.Collection;

import com.ateam.webstore.model.Address;
import com.ateam.webstore.model.Orders;
import com.ateam.webstore.model.Shipper;

/**
 * Presents the shipping options to a user. 
 * 
 * @author Brendon Drew
 *
 */
public class OrderShippingView extends View {
	Orders order;
	Collection<Address> userAddresses;
	Collection<Shipper> shippers;
	

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Collection<Address> getUserAddresses() {
		return userAddresses;
	}

	public void setUserAddresses(Collection<Address> userAddresses) {
		this.userAddresses = userAddresses;
	}

	public Collection<Shipper> getShippers() {
		return shippers;
	}

	public void setShippers(Collection<Shipper> shippers) {
		this.shippers = shippers;
	}
}
