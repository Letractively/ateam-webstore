/**
 * 
 */
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
public class WishList extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9044899967230243877L;
	
	private Long id;
	
	private Date createdDate;
	
	private Date lastUdated;
	
	private Customer customer;
	
	@SuppressWarnings("unused")
	private WishList() {
	}

	public WishList(Customer customer) {
		super();
		this.customer = customer;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUdated() {
		return lastUdated;
	}

	public void setLastUdated(Date lastUdated) {
		this.lastUdated = lastUdated;
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
