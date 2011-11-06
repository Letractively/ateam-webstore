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
public class Category extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4888146895760885491L;
	
	private Long id;
	
	private String name;
	
	@SuppressWarnings("unused")
	private Category(){
	}
	
	public Category(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

}
