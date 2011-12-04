package com.ateam.webstore.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;

import com.ateam.webstore.dao.common.BaseModel;

/**
 * @author Hendrix Tavarez
 *
 */
@PersistenceCapable
public class Employee extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5651266149333412769L;
	
	private Long id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private Date dob;
	
	private String sex;
	
	private String ssn;
	
	private String jobTitle;
	
	private Date dateOfHire;
	
	private String departmentCode;
	
	private Double salary;
	
	private Person person;
	
	private Collection<EmployeeRoles> roles;
	
	@SuppressWarnings("unused")
	private Employee() {
	}

	public Employee(String firstName, String lastName, String ssn,
			String jobTitle, Date dateOfHire, String departmentCode,
			Double salary, Person person) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.jobTitle = jobTitle;
		this.dateOfHire = dateOfHire;
		this.departmentCode = departmentCode;
		this.salary = salary;
		this.person = person;
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getDateOfHire() {
		return dateOfHire;
	}

	public void setDateOfHire(Date dateOfHire) {
		this.dateOfHire = dateOfHire;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
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
	
	public void addRole(EmployeeRoles role) {
		this.roles.add(role);
	}
	
	public void removeRole(EmployeeRoles role) {
		this.roles.remove(role);
	}
	
	public Collection<EmployeeRoles> getRoles() {
		return this.roles;
	}

}
