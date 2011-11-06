/**
 * 
 */
package com.ateam.webstore.service.impl;

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

}
