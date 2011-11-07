package com.ateam.webstore.handlers;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.WishList;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.WishListView;

public class WishListHandler extends Handler {

	public WishListHandler(HttpServletRequest req) {
		super(req);
		// TODO Auto-generated constructor stub
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
	 * Adds the product ID from the request to the wishlist.
	 * @return
	 */
	public FormSubmission addProduct() {
		
		FormSubmission add = new FormSubmission();
		
		//TODO Add item to DB
		
		add.setResultView(getWishListView());
		
		return add;
	}
}
