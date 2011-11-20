/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import com.ateam.webstore.dao.EmployeeDAO;
import com.ateam.webstore.model.Employee;
import com.ateam.webstore.model.Person;
import com.ateam.webstore.model.SecurityQuestion;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class EmployeeService implements RepositoryService<Employee> {

	@Override
	public Employee store(Employee employee) {

		EmployeeDAO repository = new EmployeeDAO();
		return repository.save(employee);
		
	}

	@Override
	public void remove(Employee employee) {

		EmployeeDAO repository = new EmployeeDAO();
		repository.delete(employee);
		
	}

	@Override
	public Collection<Employee> getAll() {

		EmployeeDAO repository = new EmployeeDAO();
		return repository.getAll();
		
	}

	@Override
	public Employee getById(Serializable id) {

		EmployeeDAO repository = new EmployeeDAO();
		return repository.get(id);
	}
	
	public Employee registerEmployee(String fname, String lname, String email, String password, Long securityQuestionID, String securityAnswer
			, String ssn, String jobTitle, Date dateOfHire, String deptCode, Double salary) {
		SecurityQuestion secQuestion = new SecurityQuestionService().getById(securityQuestionID);
		Person person = new Person(email, password, secQuestion, securityAnswer);
		return store(new Employee(fname, lname, ssn, jobTitle, dateOfHire, deptCode, salary, person));
	}
	
	public boolean employeeExists(String email) {
		PersonService personServ = new PersonService();
		Person person = personServ.getByLogin(email);
		return (person != null);
	}
	
	public Employee getEmployee(String email) {
		PersonService personServ = new PersonService();
		Person person = personServ.getByLogin(email);
		return person.getEmployee();
	}
	
	public Employee authenticateEmployee(String email, String password) {
		PersonService personServ = new PersonService();
		Person person = personServ.getByLoginAndPassword(email, password);
		return person.getEmployee();
	}	

}
