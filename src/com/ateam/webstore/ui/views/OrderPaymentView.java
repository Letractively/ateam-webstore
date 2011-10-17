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
	Orders order;
	Collection<CreditCard> userCards;
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Collection<CreditCard> getUserCards() {
		return userCards;
	}
	public void setUserCards(Collection<CreditCard> userCards) {
		this.userCards = userCards;
	}
}
