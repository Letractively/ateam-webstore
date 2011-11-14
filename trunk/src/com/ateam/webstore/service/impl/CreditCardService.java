/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.CreditCardDAO;
import com.ateam.webstore.model.CreditCard;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class CreditCardService implements RepositoryService<CreditCard> {

	@Override
	public CreditCard store(CreditCard creditCard) {

		CreditCardDAO repository = new CreditCardDAO();  
		return repository.save(creditCard);
		
	}

	@Override
	public void remove(CreditCard creditCard) {
		
		CreditCardDAO repository = new CreditCardDAO();
		repository.delete(creditCard);
		
	}

	@Override
	public Collection<CreditCard> getAll() {

		CreditCardDAO repository = new CreditCardDAO();
		return repository.getAll();
		
	}

	@Override
	public CreditCard getById(Serializable id) {
		CreditCardDAO repository = new CreditCardDAO();
		return repository.get(id);
	}

}
