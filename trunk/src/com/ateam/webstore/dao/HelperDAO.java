/**
 * 
 */
package com.ateam.webstore.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.jdo.Query;

import org.datanucleus.store.rdbms.query.ForwardQueryResult;

import com.ateam.webstore.dao.common.GenericDAOImpl;

/**
 * @author Hendrix Tavarez
 *
 */
public class HelperDAO extends GenericDAOImpl<Object, Serializable> {
	
	@SuppressWarnings("unchecked")
	public Collection<Object> runQuery(String queryText) {
		try {	      
			Query query = getPersistenceManager().newQuery("javax.jdo.query.SQL", queryText);
			return (ForwardQueryResult) query.execute();
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getPersistenceManager().close();
		}
	}
}
