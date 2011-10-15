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
public class Department extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8462378428704258531L;
	
	private String code;
	
	private String name;
	
	private Employee manager;
	
	@SuppressWarnings("unused")
	private Department() {
	}

	public Department(String code, String name, Employee manager) {
		super();
		this.code = code;
		this.name = name;
		this.manager = manager;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}
	
	

}
