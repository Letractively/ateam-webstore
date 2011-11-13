/**
 * 
 */
package com.ateam.webstore.service.impl;

import com.ateam.webstore.model.Customer;
import com.ateam.webstore.model.Person;
import com.ateam.webstore.model.SecurityQuestion;

/**
 * @author Hendrix Tavarez
 *
 */
public class RegistrationService {
	
	public Customer registerCustomer(String fname, String lname, String email, String password, Long securityQuestionID, String securityAnswer) {
		
		SecurityQuestion secQuestion = new SecurityQuestionService().getById(securityQuestionID);
		Person person = new Person(email, password, secQuestion, securityAnswer);
		CustomerService custService = new CustomerService();
		return custService.store(new Customer(fname, lname, person));
	}
	
	public boolean customerExists(String email) {
		PersonService personServ = new PersonService();
		Person person = personServ.getByLogin(email);
		return (person != null);
	}
	
	public Customer getCustomer(String email) {
		PersonService personServ = new PersonService();
		Person person = personServ.getByLogin(email);
		return person.getCustomer();
		
	}
}
