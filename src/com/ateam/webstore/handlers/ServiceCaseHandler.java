package com.ateam.webstore.handlers;

import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Customer;
import com.ateam.webstore.model.Message;
import com.ateam.webstore.model.ServiceCase;
import com.ateam.webstore.service.impl.MessageService;
import com.ateam.webstore.service.impl.ServiceCaseService;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.View;

public class ServiceCaseHandler extends Handler {
	ServiceCaseService service;
	
	public ServiceCaseHandler(HttpServletRequest req) {
		super(req);
		service = new ServiceCaseService();
	}
	
	
	public View getFeedbackView() {
		
		View v = new View(getMainView());
		
		v.addContentView(new ContentView(JSP_CUSTOMER_FEEDBACK, "Send Feedback"));
		return v;
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
			
			
			try {
				Customer person = v.getCustomer();
				
				ServiceCase scase = new ServiceCase(person); 
				service.store(scase);
				
				MessageService ms = new MessageService();
				
				Message mess = new Message(scase, person.getPerson(), false, 0, message);
				ms.store(mess);
				fs.setResultMessage("Feedback sent.");
				
				fs.setResultView(getMessageView("Feedback Sent.", "Send Feedback"));
				
			} catch (Exception e) {
				l.log(Level.WARNING, "Failed to store feedback", e);
				fs.setResultMessage("Failed to send feedback.");
				fs.setResultView(getFeedbackView());
			}
			
		}
		
		else {
			fs.setResultMessage("Invalid Message Text");
			fs.setResultView(getFeedbackView());
		}
		
		
		return fs;
	}

}
