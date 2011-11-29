package com.ateam.webstore.handlers;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Customer;
import com.ateam.webstore.model.Message;
import com.ateam.webstore.model.ServiceCase;
import com.ateam.webstore.service.impl.MessageService;
import com.ateam.webstore.service.impl.ServiceCaseService;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.models.Visitor;

public class ServiceCaseHandler extends Handler {
	ServiceCaseService service;
	
	public ServiceCaseHandler(HttpServletRequest req) {
		super(req);
		service = new ServiceCaseService();
	}
	
	/**
	 * Submit a new service case
	 * @return
	 */
	public FormSubmission submitNewCase() {
		FormSubmission fs = new FormSubmission();

		String message = req.getParameter(Parameters.MESSAGE.getId()); 
		
		if (fs.validString(message)) {
			Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
			
			Customer person = v.getCustomer();
			
			ServiceCase scase = new ServiceCase(person); 
			service.store(scase);
			
			MessageService ms = new MessageService();
			
			Message mess = new Message(scase, person.getPerson(), false, 0, message);
			ms.store(mess);
			
		}
		
		else {
			//TODO redisplay the feedback form.
		}
		
		
		return fs;
	}

}
