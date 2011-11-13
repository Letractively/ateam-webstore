/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.PersonDAO;
import com.ateam.webstore.model.Person;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class PersonService implements RepositoryService<Person> {

	@Override
	public Person store(Person person) {
		
		PersonDAO repository = new PersonDAO();
		return repository.save(person);
		
	}

	@Override
	public void remove(Person person) {

		PersonDAO repository = new PersonDAO();
		repository.delete(person);
		
	}

	@Override
	public Collection<Person> getAll() {

		PersonDAO repository = new PersonDAO();
		return repository.getAll();
		
	}

	@Override
	public Person getById(Serializable id) {
		PersonDAO repository = new PersonDAO();
		return repository.get(id);
	}
	
	public Person getByLogin(String email) {
		PersonDAO repository = new PersonDAO();
		return repository.getPersonByLogin(email);
	}

	public Person getByLoginAndPassword(String email, String password) {
		PersonDAO repository = new PersonDAO();
		return repository.getPersonByLoginAndPassword(email, password);
	}
}
