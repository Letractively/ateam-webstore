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
public class EmployeeRoles extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7953730935339863118L;
	
	private Date effectiveDate;
	
	private Date endDate;
	
	private Employee employee;
	
	private Role role;
	
	@SuppressWarnings("unused")
	private EmployeeRoles() {
	}

	public EmployeeRoles(Date effectiveDate, Employee employee, Role role) {
		super();
		this.effectiveDate = effectiveDate;
		this.employee = employee;
		this.role = role;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
