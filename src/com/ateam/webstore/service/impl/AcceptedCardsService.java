/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.util.Collection;

import com.ateam.webstore.dao.AcceptedCardsDAO;
import com.ateam.webstore.model.AcceptedCards;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class AcceptedCardsService implements RepositoryService<AcceptedCards> {

	@Override
	public AcceptedCards store(AcceptedCards acceptedCards) {
		
		AcceptedCardsDAO repository = new AcceptedCardsDAO();
		return repository.save(acceptedCards);
		
	}

	@Override
	public void remove(AcceptedCards acceptedCards) {
		
		AcceptedCardsDAO repository = new AcceptedCardsDAO();
		repository.delete(acceptedCards);
		
	}

	@Override
	public Collection<AcceptedCards> getAll() {

		AcceptedCardsDAO repository = new AcceptedCardsDAO();
		return repository.getAll();
		
	}

}
