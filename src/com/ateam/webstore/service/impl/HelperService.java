/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.ateam.webstore.dao.HelperDAO;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class HelperService implements RepositoryService<Object> {

	/* (non-Javadoc)
	 * @see com.ateam.webstore.service.RepositoryService#store(java.lang.Object)
	 */
	@Override
	public Object store(Object BaseModel) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ateam.webstore.service.RepositoryService#remove(java.lang.Object)
	 */
	@Override
	public void remove(Object BaseModel) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.ateam.webstore.service.RepositoryService#getAll()
	 */
	@Override
	public Collection<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ateam.webstore.service.RepositoryService#getById(java.io.Serializable)
	 */
	@Override
	public Object getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
		
	public Collection<Object> runAnyQuery(String queryText) {
		HelperDAO repository = new HelperDAO();
		Collection<Object> results = repository.runQuery(queryText); // array of arrays for all multi-columns queries
		Collection<Object> res = new ArrayList<Object>();
		for (Object result : results) {
			if(result != null) {
				if(result.getClass().isArray()) {
					return results; // multi-columns query
				} else {
					res.add(new Object[]{result}); // add result to array
				}
			}
		}
		Collection<Object> r = new ArrayList<Object>(); 
		r.addAll(res); // array of arrays
		return r;
	}

}
