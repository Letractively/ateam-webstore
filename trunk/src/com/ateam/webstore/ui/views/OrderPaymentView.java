package com.ateam.webstore.ui.views;

import java.util.Collection;

import com.ateam.webstore.model.Address;
import com.ateam.webstore.model.CreditCard;
import com.ateam.webstore.model.Orders;

/**
 * Presents the payment options to a user. 
 * @author bdrew
 *
 */
public class OrderPaymentView extends View {
	Collection<CreditCard> userCards;
	Address address;
	CreditCard card;

	public OrderPaymentView(View v) {
		super(v);
		context = View.Contexts.ORDER_PAYMENT.getId();
	}
	public Collection<CreditCard> getUserCards() {
		return userCards;
	}
	public void setUserCards(Collection<CreditCard> userCards) {
		this.userCards = userCards;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public CreditCard getCard() {
		return card;
	}
	public void setCard(CreditCard card) {
		this.card = card;
	}
}
