package com.ateam.webstore.handlers;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.CreditCard;
import com.ateam.webstore.service.impl.CreditCardService;
import com.ateam.webstore.ui.Constants.Parameters;

public class CreditCardHandler extends Handler {

	CreditCardService service;
	
	public CreditCardHandler(HttpServletRequest req) {
		super(req);

		service = new CreditCardService();
	}

	public Collection<CreditCard> getUsersCards() {
		Collection<CreditCard> cards = new ArrayList<CreditCard>();
		
		
//		//TODO Get cards from DB
//		CreditCard card = new CreditCard("1234", "12", "14", null, null, false, null, null);
//		cards.add(card);
//		
//		CreditCard card2 = new CreditCard("4567", "12", "15", null, null, false, null, null);
//		cards.add(card2);

		return service.getAll();
		
	}

	public CreditCard getSelectedCard() {
		// TODO Auto-generated method stub
//		CreditCard card = new CreditCard("1234", "12", "14", null, null, false, null, null);
//		return card;
		
		Long id = Long.parseLong(req.getParameter(Parameters.CARD_ID.getId()));
		l.fine("get user card id:"+id);
		//Address addr = new Address("PO Box 123","Pougheepsie","NY","12601",true, null);
		
		return service.getById(id);
	}

}
