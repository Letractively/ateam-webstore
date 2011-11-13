/**
 * 
 */
package com.ateam.webstore.dao;

import java.io.Serializable;
import java.util.HashMap;

import javax.jdo.Query;

import com.ateam.webstore.dao.common.GenericDAOImpl;
import com.ateam.webstore.model.Person;

/**
 * @author Hendrix Tavarez
 *
 */
public class PersonDAO extends GenericDAOImpl<Person, Serializable> {

	public Person getPersonByLogin(String email) {
		
		Person person = null;
		
		try {
			Query query = getPersistenceManager().newQuery(getPersistentClass(), "login == :email");
			query.setUnique(true);
			person = (Person) query.execute(email);
			
			return getPersistenceManager().detachCopy(person);
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getPersistenceManager().close();
		}
	}
	
	public Person getPersonByLoginAndPassword(String email, String password) {
		
		Person person = null;
		
		try {
			Query query = getPersistenceManager().newQuery(getPersistentClass(), "login == :email && password == :password");
			query.setUnique(true);
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("email", email);
			params.put("password", password);
			person = (Person) query.executeWithMap(params);
			
			return getPersistenceManager().detachCopy(person);
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getPersistenceManager().close();
		}
	}
}
