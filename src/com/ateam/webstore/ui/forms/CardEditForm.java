package com.ateam.webstore.ui.forms;

import com.ateam.webstore.model.CreditCard;

public class CardEditForm extends FormSubmission {
	private String cardNumber;
	
	private String expMonth;
	
	private String expYear;
	
	private String securityCode;
	
	private String nameOnCard;
	
	private String defaultInd;
	
	private String cardType;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getDefaultInd() {
		return defaultInd;
	}

	public void setDefaultInd(String defaultInd) {
		this.defaultInd = defaultInd;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Override
	public boolean isValid() {
		if (!validString(nameOnCard)) {
			resultMessage = "Name on card required";
			return false;
		}
		else if (!validString(cardNumber)) {
			resultMessage = "Invalid Card Number";
			return false;
		}
		else if (!validString(securityCode)) {
			resultMessage = "Invalid Security Code";
			return false;
		}
		else if (!validString(cardType)) {
			resultMessage = "Invalid Card Type";
			return false;
		}

		else {
			return true;
		}
	}

	
	
}
