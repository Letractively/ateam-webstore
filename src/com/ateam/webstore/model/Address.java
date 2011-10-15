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
public class Address extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -969420546742770711L;
	
	private Long id;
	
	private String streetAddress1;
	
	private String streetAddress2;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	private String plusFour;
	
	private boolean defaultInd;
	
	private Person person;
	
	@SuppressWarnings("unused")
	private Address() {
	}

	public Address(String streetAddress1, String city, String state,
			String zip, boolean defaultInd, Person person) {
		super();
		this.streetAddress1 = streetAddress1;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.defaultInd = defaultInd;
		this.person = person;
	}

	public String getStreetAddress1() {
		return streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		return streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPlusFour() {
		return plusFour;
	}

	public void setPlusFour(String plusFour) {
		this.plusFour = plusFour;
	}

	public boolean isDefaultInd() {
		return defaultInd;
	}

	public void setDefaultInd(boolean defaultInd) {
		this.defaultInd = defaultInd;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Long getId() {
		return id;
	}
	

}
