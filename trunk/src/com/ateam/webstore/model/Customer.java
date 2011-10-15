package com.ateam.webstore.model;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;

import com.ateam.webstore.dao.common.BaseModel;

/**
 * @author Hendrix Tavarez
 *
 */
@PersistenceCapable
public class Customer extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3747424470222065757L;
	
	private Long id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private Date dob;
	
	private Person person;
	
	@SuppressWarnings("unused")
	private Customer() {
	}

	public Customer(String firstName, String lastName, Person person) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.person = person;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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
