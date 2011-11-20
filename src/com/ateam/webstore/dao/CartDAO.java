/**
 * 
 */
package com.ateam.webstore.dao;

import java.io.Serializable;

import javax.jdo.Query;

import com.ateam.webstore.dao.common.GenericDAOImpl;
import com.ateam.webstore.model.Cart;

/**
 * @author Hendrix Tavarez
 *
 */
public class CartDAO extends GenericDAOImpl<Cart, Serializable> {

	public Cart getByCustomer(Serializable customer) {
		
		Cart cart = null;
		
		try {
			Query query = getPersistenceManager().newQuery(getPersistentClass(), "customer == :customer");
			query.setUnique(true);
			cart = (Cart) query.execute(customer);
			
			return getPersistenceManager().detachCopy(cart);
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getPersistenceManager().close();
		}
	}
}
