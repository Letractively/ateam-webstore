package com.ateam.webstore.handlers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Person;
import com.ateam.webstore.service.impl.PersonService;

public class PersonHandler extends Handler {

	public PersonHandler(HttpServletRequest req) {
		super(req);
		service = new PersonService();
	}

	public void store(Person p) {
		service.store(p);
	}
	
//	public Person getPerson() {
//		Collection col = service.getAll();
//		
//		col.size()
//	}
	
}
