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
public class AcceptedCards extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -856499722030150440L;
	
	private String cardType;
	
	@SuppressWarnings("unused")
	private AcceptedCards() {
	}
	
	public AcceptedCards (String cardType) {
		super();
		this.setCardType(cardType);
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

}
