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
public class Role extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6079942106748346619L;
	
	private int code;
	
	private String description;
	
	@SuppressWarnings("unused")
	private Role() {
	}

	public Role(int code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
