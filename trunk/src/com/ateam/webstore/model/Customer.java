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
	
	private String sex;
	
	private static Person person;
	
	@SuppressWarnings("unused")
	private Customer() {
	}

	public Customer(String firstName, String lastName, Person person) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Customer.person = person;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public static Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		Customer.person = person;
	}

	public Long getId() {
		return id;
	}
	
	
	

}
