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
public class ServiceCase extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4922218303079740070L;
	
	private Long id;
	
	private Customer customer;
	
	@SuppressWarnings("unused")
	private ServiceCase() {
	}
	
	public ServiceCase(Customer customer) {
		super();
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

}
