package com.ateam.webstore.ui.views;

import java.util.Collection;

import com.ateam.webstore.model.Address;
import com.ateam.webstore.model.Orders;
import com.ateam.webstore.model.Shipper;
import com.ateam.webstore.model.ShippingCode;

/**
 * Presents the shipping options to a user. 
 * 
 * @author Brendon Drew
 *
 */
public class OrderShippingView extends View {

	Collection<Address> userAddresses;
	Collection<ShippingCode> shippers;
	Address address;

	public OrderShippingView(View v) {
		super(v);
		context = View.Contexts.ORDER_SHIPPING.getId();
	}

	public Collection<Address> getUserAddresses() {
		return userAddresses;
	}

	public void setUserAddresses(Collection<Address> userAddresses) {
		this.userAddresses = userAddresses;
	}

	public Collection<ShippingCode> getShippers() {
		return shippers;
	}

	public void setShippers(Collection<ShippingCode> shippers) {
		this.shippers = shippers;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
