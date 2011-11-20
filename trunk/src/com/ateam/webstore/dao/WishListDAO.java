/**
 * 
 */
package com.ateam.webstore.dao;

import java.io.Serializable;

import javax.jdo.Query;

import com.ateam.webstore.dao.common.GenericDAOImpl;
import com.ateam.webstore.model.WishList;

/**
 * @author Hendrix Tavarez
 *
 */
public class WishListDAO extends GenericDAOImpl<WishList, Serializable> {

	public WishList getByCustomer(Serializable customer) {
		
		WishList WishList = null;
		
		try {
			Query query = getPersistenceManager().newQuery(getPersistentClass(), "customer == :customer");
			query.setUnique(true);
			WishList = (WishList) query.execute(customer);
			
			return getPersistenceManager().detachCopy(WishList);
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getPersistenceManager().close();
		}
	}
}
