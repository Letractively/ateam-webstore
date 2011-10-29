package com.ateam.webstore.ui.forms;

import com.ateam.webstore.model.CreditCard;

/**
 * Represents the users payment preference for an order.
 * @author bdrew
 *
 */
public class OrderPaymentForm extends FormSubmission  {

	CreditCard card;

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}
}
