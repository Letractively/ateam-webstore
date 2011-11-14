package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.CustomerDAO;
import com.ateam.webstore.model.Customer;
import com.ateam.webstore.model.Person;
import com.ateam.webstore.model.SecurityQuestion;
import com.ateam.webstore.service.RepositoryService;

public class CustomerService implements RepositoryService<Customer> {

	@Override
	public Customer store(Customer customer) {
		
		CustomerDAO repository = new CustomerDAO();
		return repository.save(customer);
		
	}

	@Override
	public void remove(Customer customer) {
		
		CustomerDAO repository = new CustomerDAO();
		repository.delete(customer);
	}

	@Override
	public Collection<Customer> getAll() {
		
		CustomerDAO repository = new CustomerDAO();
		return repository.getAll();
	}

	@Override
	public Customer getById(Serializable id) {
		CustomerDAO repository = new CustomerDAO();
		return repository.get(id);
	}
	
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
	
	public Customer authenticateCustomer(String email, String password) {
		PersonService personServ = new PersonService();
		Person person = personServ.getByLoginAndPassword(email, password);
		return person.getCustomer();
	}	

}
