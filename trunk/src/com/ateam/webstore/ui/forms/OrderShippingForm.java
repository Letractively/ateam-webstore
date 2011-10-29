package com.ateam.webstore.ui.forms;

import com.ateam.webstore.model.Address;
import com.ateam.webstore.model.ShippingCode;

/**
 * Represents the users shipping preference for an order.
 * @author Brendon Drew
 *
 */
public class OrderShippingForm extends FormSubmission {

	Address address;
	ShippingCode shippingCode;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public ShippingCode getShippingCode() {
		return shippingCode;
	}
	public void setShippingCode(ShippingCode shippingCode) {
		this.shippingCode = shippingCode;
	}
	
}
