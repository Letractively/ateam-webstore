package com.ateam.webstore.ui.forms;

import com.ateam.webstore.model.CreditCard;

/**
 * Represents the users payment preference for an order.
 * @author bdrew
 *
 */
public class OrderPaymentForm extends FormSubmission  {
	/**
	 * The order id.
	 */
	String id;
	CreditCard card;
}
