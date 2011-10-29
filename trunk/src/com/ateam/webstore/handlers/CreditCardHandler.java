package com.ateam.webstore.handlers;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.CreditCard;

public class CreditCardHandler extends Handler {

	public CreditCardHandler(HttpServletRequest req) {
		super(req);
		// TODO Auto-generated constructor stub
	}

	public Collection<CreditCard> getUsersCards() {
		Collection<CreditCard> cards = new ArrayList<CreditCard>();
		
		
		//TODO Get cards from DB
		CreditCard card = new CreditCard("1234", "12", "14", null, null, false, null, null);
		cards.add(card);
		
		CreditCard card2 = new CreditCard("4567", "12", "15", null, null, false, null, null);
		cards.add(card2);

		return cards;
		
	}

	public CreditCard getUsersCard(int i) {
		// TODO Auto-generated method stub
		CreditCard card = new CreditCard("1234", "12", "14", null, null, false, null, null);
		return card;		
	}

}
