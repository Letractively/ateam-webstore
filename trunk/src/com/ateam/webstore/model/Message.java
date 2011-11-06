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
public class Message extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private boolean empOrCust;
	
	private int sequence;
	
	private String message;
	
	private ServiceCase serviceCase;
	
	private Person person;
	
	@SuppressWarnings("unused")
	private Message() {
	}
	
	public Message(ServiceCase serviceCase, Person person, boolean empOrCust, int sequence, String message) {
		super();
		this.serviceCase = serviceCase;
		this.person = person;
		this.empOrCust = empOrCust;
		this.sequence = sequence;
		this.message = message;
	}

	public boolean isEmpOrCust() {
		return empOrCust;
	}

	public void setEmpOrCust(boolean empOrCust) {
		this.empOrCust = empOrCust;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ServiceCase getServiceCase() {
		return serviceCase;
	}

	public void setServiceCase(ServiceCase serviceCase) {
		this.serviceCase = serviceCase;
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
