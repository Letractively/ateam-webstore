package com.ateam.webstore.ui.forms;

import com.ateam.webstore.model.Address;
import com.ateam.webstore.model.Shipper;
import com.ateam.webstore.ui.forms.FormSubmission;

/**
 * Represents the users shipping preference for an order.
 * @author Brendon Drew
 *
 */
public class OrderShippingForm extends FormSubmission {
	/**
	 * The order ID
	 */
	String id;
	Address address;
	Shipper shipper;
}
