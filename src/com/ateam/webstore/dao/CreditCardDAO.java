/**
 * 
 */
package com.ateam.webstore.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.jdo.Query;

import com.ateam.webstore.dao.common.GenericDAOImpl;
import com.ateam.webstore.model.CreditCard;

/**
 * @author Hendrix Tavarez
 *
 */
public class CreditCardDAO extends GenericDAOImpl<CreditCard, Serializable> {

	@SuppressWarnings("unchecked")
	public Collection<CreditCard> getByCustomer(Serializable customer) {
		
		Collection<CreditCard> creditCards = null;
		
		try {
			Query query = getPersistenceManager().newQuery(getPersistentClass(), "customer == :customer");
			creditCards = (Collection<CreditCard>) query.execute(customer);
			
			return (Collection<CreditCard>) getPersistenceManager().detachCopyAll(creditCards);
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getPersistenceManager().close();
		}		
	}
}
