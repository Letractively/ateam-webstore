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
public class SalesTax extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1902492344380248130L;

	private String state;
	
	private Double percent;
	
	@SuppressWarnings("unused")
	private SalesTax() {
	}

	public SalesTax(String state, Double percent) {
		super();
		this.state = state;
		this.percent = percent;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getPercent() {
		return percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}
	
	
}
