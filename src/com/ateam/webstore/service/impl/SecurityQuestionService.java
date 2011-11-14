/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.SecurityQuestionDAO;
import com.ateam.webstore.model.SecurityQuestion;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class SecurityQuestionService implements
		RepositoryService<SecurityQuestion> {

	@Override
	public SecurityQuestion store(SecurityQuestion securityQuestion) {

		SecurityQuestionDAO repository = new SecurityQuestionDAO();
		return repository.save(securityQuestion);
		
	}

	@Override
	public void remove(SecurityQuestion securityQuestion) {

		SecurityQuestionDAO repository = new SecurityQuestionDAO();
		repository.delete(securityQuestion);
		
	}

	@Override
	public Collection<SecurityQuestion> getAll() {

		SecurityQuestionDAO repository = new SecurityQuestionDAO();
		return repository.getAll();
		
	}

	@Override
	public SecurityQuestion getById(Serializable id) {
		SecurityQuestionDAO repository = new SecurityQuestionDAO();
		return repository.get(id);
	}

}
