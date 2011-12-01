/**
 * 
 */
package com.ateam.webstore.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

import javax.jdo.Query;

import com.ateam.webstore.dao.common.GenericDAOImpl;
import com.ateam.webstore.model.Orders;

/**
 * @author Hendrix Tavarez
 *
 */
public class OrdersDAO extends GenericDAOImpl<Orders, Serializable> {
	
	@SuppressWarnings("unchecked")
	public Collection<Orders> getOrdersInProgress() {
		
		
		Collection<Orders> orders = null;
		
		try {
			Query query = getPersistenceManager().newQuery(getPersistentClass(), "timeShipped == :zero");
			orders = (Collection<Orders>) query.execute(new Timestamp(0));
			
			return (Collection<Orders>) getPersistenceManager().detachCopyAll(orders);
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getPersistenceManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Orders> getOrdersInCompleted() {
		
		
		Collection<Orders> orders = null;
		
		try {
			Query query = getPersistenceManager().newQuery(getPersistentClass(), "timeShipped > :zero");
			orders = (Collection<Orders>) query.execute(new Timestamp(0));
			
			return (Collection<Orders>) getPersistenceManager().detachCopyAll(orders);
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getPersistenceManager().close();
		}
	}	
	
	@SuppressWarnings("unchecked")
	public Collection<Orders> getByCustomer(Serializable customer) {
		
		
		Collection<Orders> orders = null;
		
		try {
			Query query = getPersistenceManager().newQuery(getPersistentClass(), "customer == :customer");
			orders = (Collection<Orders>) query.execute(customer);
			
			return (Collection<Orders>) getPersistenceManager().detachCopyAll(orders);
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getPersistenceManager().close();
		}
	}		

}
