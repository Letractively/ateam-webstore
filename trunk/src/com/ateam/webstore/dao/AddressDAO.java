/**
 * 
 */
package com.ateam.webstore.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.jdo.Query;

import com.ateam.webstore.dao.common.GenericDAOImpl;
import com.ateam.webstore.model.Address;

/**
 * @author Hendrix Tavarez
 *
 */
public class AddressDAO extends GenericDAOImpl<Address, Serializable> {
	
	
	@SuppressWarnings("unchecked")
	public Collection<Address> getByPerson(Serializable person) {
		Collection<Address> addresses = null;
		
		try {
			Query query = getPersistenceManager().newQuery(getPersistentClass(), "person == :person");
			addresses = (Collection<Address>) query.execute(person);
			
			return (Collection<Address>) getPersistenceManager().detachCopyAll(addresses);
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getPersistenceManager().close();
		}		
	}

}
