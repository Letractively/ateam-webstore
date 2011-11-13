package com.ateam.webstore.dao;

import java.io.Serializable;

import javax.jdo.Query;

import com.ateam.webstore.dao.common.GenericDAOImpl;
import com.ateam.webstore.model.Customer;

public class CustomerDAO extends GenericDAOImpl<Customer, Serializable> {
	
	public Customer getCustomerByPersonID(Serializable id) {
		
		Customer customer = null;
		
		try {
			Query query = getPersistenceManager().newQuery(getPersistentClass(), "personID == :id");
			query.setUnique(true);
			customer = (Customer) query.execute(id);
			
			return getPersistenceManager().detachCopy(customer);
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getPersistenceManager().close();
		}
	}

}
