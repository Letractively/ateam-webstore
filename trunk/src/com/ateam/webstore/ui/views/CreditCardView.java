package com.ateam.webstore.ui.views;

import com.ateam.webstore.model.CreditCard;

public class CreditCardView extends View {
	CreditCard creditcard;
	
	public CreditCardView(View mainView) {
		super(mainView);
	}
	public CreditCard getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(CreditCard creditcard) {
		this.creditcard = creditcard;
	}

}
