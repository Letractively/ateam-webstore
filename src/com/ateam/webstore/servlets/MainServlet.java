package com.ateam.webstore.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.views.View;

/**
 * Handles basic GET requests
 *
 */
public class MainServlet extends HttpServlet implements Constants {
	static Logger l = Logger.getLogger(MainServlet.class.getName().toString());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		View v = null;
		
		if (req.getParameterMap().containsKey(Parameters.LOGIN.getId())) {
			VisitorHandler vh = new VisitorHandler(req);
			v = vh.getLoginView();
		}
		else if (req.getParameterMap().containsKey(Parameters.REGISTER.getId())) {
			VisitorHandler vh = new VisitorHandler(req);
			v = vh.getRegistrationView();
		}		
		else if (req.getParameterMap().containsKey(Parameters.PRODUCT_ID.getId())) {
			ProductHandler ph = new ProductHandler(req);
			v = ph.getProductView(req.getParameter(Parameters.PRODUCT_ID.getId()));
		}
		else if (req.getParameterMap().containsKey(Parameters.CART_ID.getId())) {
			CartHandler ch = new CartHandler(req);
			v = ch.getCartView(req.getParameter(Parameters.CART_ID.getId()));
		}
		else if (req.getParameterMap().containsKey(Parameters.WISHLIST.getId())) {
			WishListHandler wlh = new WishListHandler(req);
			v = wlh.getWishListView();
		}
		else if (req.getParameterMap().containsKey(Parameters.CATEGORY_ID.getId())) {
			String category = req.getParameter(Parameters.CATEGORY_ID.getId());
			ProductHandler ph = new ProductHandler(req);
			v = ph.getCategoryView(category);
		}
		else if (req.getParameterMap().containsKey(Parameters.ORDER_ID.getId())) {
			OrderHandler oh = new OrderHandler(req);
			v = oh.getOrderDetailsView(req.getParameter(Parameters.ORDER_ID.getId()));
		}
		else {
			ProductHandler ph = new ProductHandler(req);
			v = ph.getHomePageView();
		}
		
		if (v != null) {
			if (v.getVisitor() != null) {
				l.info("visitor:"+v.getVisitor().toString());
			}
			else {
				l.info("null visitor");
			}

			l.info("passing view:"+v);
		}
		else {
			v = new View();
			l.warning("null view:");
		}
		
		req.setAttribute(REQUEST_ATTRIBUTE_VIEW, v);
		
		getServletConfig().getServletContext().getRequestDispatcher(
				JSP_MAIN).forward(req, resp);

	}
	
}

