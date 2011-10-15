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
public class Shipper extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2355453911918456778L;
	
	private Long id;
	
	private String name;
	
	private String streetAddress1;
	
	private String streetAddress2;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	private String plusFour;
	
	private String acctNumber;
	
	private String acctMgrFirstNm;
	
	private String acctMgrLastNm;
	
	@SuppressWarnings("unused")
	private Shipper() {
	}

	public Shipper(String name, String streetAddress1, String city,
			String state, String zip) {
		super();
		this.name = name;
		this.streetAddress1 = streetAddress1;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}

	public String getAcctMgrFirstNm() {
		return acctMgrFirstNm;
	}

	public void setAcctMgrFirstNm(String acctMgrFirstNm) {
		this.acctMgrFirstNm = acctMgrFirstNm;
	}

	public String getAcctMgrLastNm() {
		return acctMgrLastNm;
	}

	public void setAcctMgrLastNm(String acctMgrLastNm) {
		this.acctMgrLastNm = acctMgrLastNm;
	}

	public Long getId() {
		return id;
	}
	
	

}
