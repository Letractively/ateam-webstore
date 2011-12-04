package com.ateam.webstore.ui.forms;

import java.util.Calendar;
import java.util.logging.Logger;

import com.ateam.webstore.handlers.ProductHandler;
import com.ateam.webstore.model.CreditCard;
import com.ateam.webstore.ui.Constants;

public class CardEditForm extends FormSubmission {
	static Logger l = Logger.getLogger(Constants.LOGGER_NAME);
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
		else if (validCardNumber()) {
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
		else if (!validExpiration()) {
			resultMessage = "Invalid Expiration Date";
			return false;
		}
		else {
			return true;
		}
	}
	
	private boolean validExpiration() {
		Calendar c = Calendar.getInstance();

		int cardMonth = -1;
		int cardYear = -1;
		
		try {
			cardMonth= Integer.parseInt(expMonth);
			cardYear = Integer.parseInt(expYear);
		} catch (Exception e) {
			resultMessage = "Invalid Expiration Date";
			return false;
		}
		
		int thisYear = 2000 - c.get(Calendar.YEAR);
		int thisMonth = c.get(Calendar.MONTH)+1;
		
		l.info("given:"+cardMonth+"/"+cardYear+" now:"+thisMonth+"/"+thisYear);
		
		if (cardYear > thisYear) {
			return true;
		}
		else if (cardYear == thisYear && cardMonth >= thisMonth) {
			return true;
		}
		else {
			resultMessage = "Invalid Expiration Date";
			return false;
		}
	}

	private boolean validCardNumber() {
		
		if (!validInt(cardNumber)) {
			return false;
		}
		int sum = 0;
	    int digit = 0;
	    int addend = 0;
	    boolean timesTwo = false;

	    for (int i = cardNumber.length () - 1; i >= 0; i--) {
	      digit = Integer.parseInt (cardNumber.substring (i, i + 1));
	      if (timesTwo) {
	        addend = digit * 2;
	        if (addend > 9) {
	          addend -= 9;
	        }
	      }
	      else {
	        addend = digit;
	      }
	      sum += addend;
	      timesTwo = !timesTwo;
	    }

	    int modulus = sum % 10;
	    return modulus == 0;

	}

	
	
}
