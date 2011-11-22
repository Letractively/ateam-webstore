package com.ateam.webstore.handlers;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.WishList;
import com.ateam.webstore.service.impl.WishListService;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.WishListView;

public class WishListHandler extends Handler {

	WishListService service;
	public WishListHandler(HttpServletRequest req) {
		super(req);
		service = new WishListService();
	}

	/**
	 * Return the WishList View
	 * @return
	 */
	public WishListView getWishListView() {

		WishListView wlv = new WishListView(getMainView());
		
		//TODO get wl from DB
		WishList wl = new WishList(null);
		
		wlv.addContentView(new ContentView(JSP_CART, wl.getName()));
		
		return wlv;
		
	}
	
	/**
	 * Add a product to the users cart
	 * @return
	 */
	public FormSubmission addProduct() {
		
		FormSubmission add = new FormSubmission();
		
		//Check auth
		Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
		if (v.isAuthenticated()) {
			CustomerHandler ch = new CustomerHandler(req);
			add.setResultView(ch.getLoginView("Please first login"));
			add.setResultMessage("Please first logon");
		}
		String prodId = req.getParameter(Parameters.PRODUCT_ID.getId());
		l.fine("add prodId :"+prodId);
		//TODO add product to cart via cart service.
		//service.add

		add.setResultView(getWishListView());
		
		return add;
	}
}
