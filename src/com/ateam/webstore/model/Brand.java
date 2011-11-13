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
public class Brand extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2767538394276604281L;

	private Long brandID;
	
	private String brandName;
	
	@SuppressWarnings("unused")
	private Brand() {
	}
	
	public Brand(String brandName) {
		super();
		this.brandName = brandName;
	}

	public String getName() {
		return brandName;
	}

	public void setName(String brandName) {
		this.brandName = brandName;
	}

	public Long getId() {
		return brandID;
	}
}
