package com.ateam.webstore.handlers;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Cart;
import com.ateam.webstore.model.ProductsInWishList;
import com.ateam.webstore.model.WishList;
import com.ateam.webstore.service.impl.ProductService;
import com.ateam.webstore.service.impl.ProductsInWishListService;
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

	
	public WishList getWishList() {
		Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
		WishList wl = service.getByCustomerId(v.getCustomer().getId());
		return wl;
	}
	/**
	 * Return the WishList View
	 * @return
	 */
	public WishListView getWishListView() {

		WishListView wlv = new WishListView(getMainView());
		
		WishList wl = getWishList();
		
		if (req.getParameter(Parameters.REMOVE.getId()) != null) {
			String removeId = req.getParameter(Parameters.REMOVE.getId());
			l.info("removing wish list item "+removeId+" for session: "+req.getSession().getId());
			ProductsInWishListService piwls = new ProductsInWishListService();
			ProductsInWishList piwl = piwls.getById(new Long(removeId));
			piwls.remove(piwl);
		}

		wlv.setWishList(wl);
		
		wlv.addContentView(new ContentView(JSP_WISHLIST, wl.getName()));
		
		return wlv;
		
	}
	
	/**
	 * Add a product to the users wish list
	 * @param prodId 
	 * @return
	 */
	public FormSubmission addProduct(String prodId) {
		
		FormSubmission add = new FormSubmission();
		
		if (prodId == null) {
			prodId = req.getParameter(Parameters.PRODUCT_ID.getId());
		}
		
		req.getSession().setAttribute(SESSION_ATTRIBUTE_PRODUCT_TO_WISHLIST, prodId);
		
		//Check auth
		Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
		if (v == null || !v.isAuthenticated()) {
			l.info("not authenticated for product add ");
			CustomerHandler ch = new CustomerHandler(req);
			add.setResultView(ch.getLoginView("Please first login"));
			return add;
		}
		
		WishList wl = getWishList();
		if (wl == null) {
			wl = new WishList(v.getCustomer());
			wl.setName("My Wish List");
			wl = service.store(wl);
		}
		
		l.fine("adding prodId :"+prodId);

		ProductsInWishList prodInList = new ProductsInWishList(1, wl,new ProductService().getById(new Long(prodId)));
		wl.addProduct(prodInList);
		service.store(wl);

		add.setResultView(getWishListView());
		
		return add;
	}


	public FormSubmission moveSelectedToCart() {

		WishList wl = getWishList();
		CartHandler ch = new CartHandler(req);
		ProductsInWishListService pinwl = new ProductsInWishListService();
		FormSubmission fs = new FormSubmission();
		
		int i = 0;
		
		for (ProductsInWishList p : wl.getProducts()) {
			String prodId = p.getProduct().getId()+"";
			if (req.getParameter(prodId) != null) {
				l.fine("moving prodId :"+prodId+" to cart");
				ch.addProduct(prodId);
				pinwl.remove(p);
				i++;
			}
		}
		
		if (i > 0) {
			fs.setResultView(ch.getCartView());	
			fs.setResultMessage(i+" products moved to your cart");
		}
		else {
			fs.setResultView(getWishListView());	
			fs.setResultMessage("No products were selected");
		}

		return fs;
	}
}
