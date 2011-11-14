package com.ateam.webstore.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Cart;
import com.ateam.webstore.model.Category;
import com.ateam.webstore.model.Customer;
import com.ateam.webstore.service.RepositoryService;
import com.ateam.webstore.service.impl.CategoryService;
import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.View;

/**
 * Second-level handling of requests. Specific to a single database service.
 * @author bdrew
 *
 */
public class Handler implements Constants {
	
	static Logger l = Logger.getLogger(Constants.LOGGER_NAME);
	HttpServletRequest req;
	RepositoryService service;
	
	public Handler(HttpServletRequest req) {
		this.req = req;
	}

	public HttpServletRequest getRequest() {
		return req;
	}

	public RepositoryService getService() {
		return service;
	}

	public void setService(RepositoryService service) {
		this.service = service;
	}
	
	/**
	 * Builds the main site View
	 * @return
	 */
	public View getMainView() {

		l.fine("building main view");
		View v = new View();
		v.setTitle("A+Team WebStore");
		v.setHeaderTitle(v.getTitle());
		
		Collection<Category> categories = new CategoryService().getAll();
		Map<String, String> navLinks = new HashMap<String,String>();

		int i = 4;
		for (Category c : categories) while (i>1) {
			navLinks.put(c.getName(), req.getContextPath()+"/store?category="+c.getId());
			i--;
		}
		
		v.setNavLinks(navLinks);

		v = setVisitorInfo(v);
		
		return  v;
	}

	/**
	 * Grab visitor info from the request and add it to the view.  
	 * Visitor info is obtained from cookies as well as the session.
	 * 
	 * @param v
	 * @return
	 */
	private View setVisitorInfo(View v) {
		Visitor vis = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);

		v.setShowLogonForm(true);
		
		if (vis != null) {
			l.info("visitor in session:"+vis);
			v.setShowVisitorInfo(vis.isKnown());
		}
		else {
			l.info("No visitor in session");
			//TODO Look for cookies if not in session
			vis = new Visitor();
		}

		v.setVisitor(vis);
		
		return v;
	}
}
