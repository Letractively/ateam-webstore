package com.ateam.webstore.servlets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.dao.common.BaseModel;
import com.ateam.webstore.service.RepositoryService;
import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.models.Cart;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.View;

/**
 * Second-level handling of requests. Specific to a single database service.
 * @author bdrew
 *
 */
public abstract class Handler implements Constants {
	HttpServletRequest req;
	RepositoryService<BaseModel> service;
	
	public Handler(HttpServletRequest req) {
		this.req = req;
	}

	public HttpServletRequest getRequest() {
		return req;
	}

	public RepositoryService<BaseModel> getService() {
		return service;
	}

	public void setService(RepositoryService<BaseModel> service) {
		this.service = service;
	}
	
	/**
	 * Builds the main site View
	 * @return
	 */
	public View getMainView(HttpServletRequest req) {
		View v = new View();
		v.setTitle("A+Team WebStore");
		v.setHeaderTitle(v.getTitle());
		Map<String, String> navLinks = new HashMap<String,String>();
		navLinks.put("Category 1", req.getContextPath()+"/store?category=cat1");
		navLinks.put("Category 2", req.getContextPath()+"/store?category=cat2");
		navLinks.put("Category 3", req.getContextPath()+"/store?category=cat3");
		v.setNavLinks(navLinks);
		Object o = req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
		if (o != null) {
			v.setVisitor((Visitor) o);			
		}
		
		Cart cart = new Cart();
		List list = new ArrayList();
		list.add("123");
		list.add("123");
		cart.setProducts(list);
		v.setCart(cart);
		return  v;
	}

}
