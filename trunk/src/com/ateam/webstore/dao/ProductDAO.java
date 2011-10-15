package com.ateam.webstore.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.jdo.Query;

import com.ateam.webstore.dao.common.GenericDAOImpl;
import com.ateam.webstore.model.Product;

public class ProductDAO extends GenericDAOImpl<Product, Serializable>{
	
	@SuppressWarnings("unchecked")
	public Collection<Product> getProductByName(String name) {
		
		Collection<Product> products = null;
		
		try {
			Query query = getPersistenceManager().newQuery(getPersistentClass(), "productName == :name");
			products = (Collection<Product>) query.execute(name);
			
			return (Collection<Product>) getPersistenceManager().detachCopyAll(products);
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getPersistenceManager().close();
		}
	}

}
