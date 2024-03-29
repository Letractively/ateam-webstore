/**
 * 
 */
package com.ateam.webstore.model;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;

import com.ateam.webstore.dao.common.BaseModel;

/**
 * @author Hendrix Tavarez
 *
 */
@PersistenceCapable
public class CreditCard extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7307756490906559607L;
	
	private Long id;
	
	private String cardNumber;
	
	private String expMonth;
	
	private String expYear;
	
	private String securityCode;
	
	private String nameOnCard;
	
	private boolean defaultInd;
	
	private String cardType;
	
	private Customer customer;
	
	private Address billingAddress;
	
	@SuppressWarnings("unused")
	private CreditCard() {
	}

	public CreditCard(String cardNmber, String expMonth, String expYear,
			String securityCode, String nameOnCard, boolean defaultInd,
			Customer customer, Address billingAddress) {
		super();
		this.cardNumber = cardNmber;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.securityCode = securityCode;
		this.nameOnCard = nameOnCard;
		this.defaultInd = defaultInd;
		this.customer = customer;
		this.billingAddress = billingAddress;
	}

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

	public boolean isDefaultInd() {
		return defaultInd;
	}

	public void setDefaultInd(boolean defaultInd) {
		this.defaultInd = defaultInd;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Long getId() {
		return id;
	}
	
	public String getObfusticatedCardInfo() {
		return cardType +" ending in " + cardNumber.substring(cardNumber.length()-4, cardNumber.length());
	}

}
