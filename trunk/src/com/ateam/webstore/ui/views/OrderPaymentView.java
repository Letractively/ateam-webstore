package com.ateam.webstore.ui.views;

import java.util.Collection;

import com.ateam.webstore.model.CreditCard;
import com.ateam.webstore.model.Orders;

/**
 * Presents the payment options to a user. 
 * @author bdrew
 *
 */
public class OrderPaymentView extends View {
	Collection<CreditCard> userCards;

	public OrderPaymentView(View v) {
		super(v);
	}
	public Collection<CreditCard> getUserCards() {
		return userCards;
	}
	public void setUserCards(Collection<CreditCard> userCards) {
		this.userCards = userCards;
	}
}
