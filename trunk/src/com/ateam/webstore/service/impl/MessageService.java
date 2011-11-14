/**
 * 
 */
package com.ateam.webstore.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ateam.webstore.dao.MessageDAO;
import com.ateam.webstore.model.Message;
import com.ateam.webstore.service.RepositoryService;

/**
 * @author Hendrix Tavarez
 *
 */
public class MessageService implements RepositoryService<Message> {

	@Override
	public Message store(Message message) {
		
		MessageDAO repository = new MessageDAO();
		return repository.save(message);
	}

	@Override
	public void remove(Message message) {
		
		MessageDAO repository = new MessageDAO();
		repository.delete(message);
		
	}

	@Override
	public Collection<Message> getAll() {
		
		MessageDAO repository = new MessageDAO();
		return repository.getAll();
	}

	@Override
	public Message getById(Serializable id) {
		MessageDAO repository = new MessageDAO();
		return repository.get(id);
	}

}
