package com.ateam.webstore.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ateam.webstore.handlers.CartHandler;
import com.ateam.webstore.handlers.Handler;
import com.ateam.webstore.handlers.OrderHandler;
import com.ateam.webstore.handlers.ProductHandler;
import com.ateam.webstore.handlers.VisitorHandler;
import com.ateam.webstore.handlers.WishListHandler;
import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.View;

/**
 * Handles basic GET requests
 *
 */
public class StoreFrontServlet extends HttpServlet implements Constants {
	static Logger l = Logger.getLogger(Constants.LOGGER_NAME);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		View v = null;

		//Debugging
		dumpRequest(req);

		try {
			
			
			if (req.getParameterMap().containsKey(Parameters.LOGIN.getId())) {
				VisitorHandler vh = new VisitorHandler(req);
				v = vh.getLoginView();
			}
			else if (req.getParameterMap().containsKey(Parameters.LOGOUT.getId())) {
				VisitorHandler vh = new VisitorHandler(req);
				v = vh.getLogoutView();
			}
			else if (req.getParameterMap().containsKey(Parameters.FORGOT.getId())) {
				VisitorHandler vh = new VisitorHandler(req);
				v = vh.getForgotPasswordView();
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
			else if (req.getParameterMap().containsKey(Parameters.CHECKOUT.getId())) {
				CartHandler ch = new CartHandler(req);
				v = ch.checkout();
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

				l.info(v.toString());
			}
			else {
				v = new View();
				l.warning("null view:");
			}
			
			
		} catch (Exception e) {
			l.log(Level.SEVERE, "Exception caught in doGet", e);
			Handler h = new Handler(req);
			v = h.getMainView();
			
			ContentView cv = new ContentView(null, "Opps...");
			cv.setContentText(e.getMessage());
			v.addContentView(cv);
		}

		req.setAttribute(REQUEST_ATTRIBUTE_VIEW, v);
		
		getServletConfig().getServletContext().getRequestDispatcher(
				JSP_MAIN).forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		l.info("form submission "+req.getSession().getId());
		
		//Debugging
		dumpRequest(req);
		
		
		try {
			
			//Get the form and process
			FormSubmission results = processFormSubmission(req);
			
			//Set Result View
			req.setAttribute(REQUEST_ATTRIBUTE_VIEW, results.getResultView());

			
		} catch (Exception e) {
			l.log(Level.SEVERE, "Exception caught in doGet", e);
			Handler h = new Handler(req);
			View v = h.getMainView();
			
			ContentView cv = new ContentView(null, "Opps...");
			cv.setContentText(e.getMessage());
			v.addContentView(cv);
			
			req.setAttribute(REQUEST_ATTRIBUTE_VIEW, v);
		}
		
		l.info(req.getAttribute(REQUEST_ATTRIBUTE_VIEW).toString());
		
		//Forward to JSP
		getServletConfig().getServletContext().getRequestDispatcher(
				JSP_MAIN).forward(req, resp);
	}

	/**
	 * Extracts a FormSubmission from the request.
	 * @param req
	 * @return
	 */
	private FormSubmission processFormSubmission(HttpServletRequest req) {

		String formId = req.getParameter(Parameters.FORM_ID.getId());

		if (formId == null) {
			l.warning("null form ID ");
			//TODO throw execpton
		}
		else if (formId.equals(FormName.LOGIN.getId())) {
			VisitorHandler h = new VisitorHandler(req);
			return h.processLoginRequest();
		}
		else if (formId.equals(FormName.REGISTER.getId())) {
			VisitorHandler h = new VisitorHandler(req);
			return h.getRegistrationRequest();
		}
		else if (formId.equals(FormName.ORDER_SHIPPING.getId())) {
			OrderHandler oh = new OrderHandler(req);
			return oh.processOrderShipppingRequest();
		}
		else if (formId.equals(FormName.ORDER_PAYMENT.getId())) {
			OrderHandler oh = new OrderHandler(req);
			return oh.processOrderPaymentRequest();
		}
		else if (formId.equals(FormName.ORDER_CONFIRM.getId())) {
			OrderHandler oh = new OrderHandler(req);
			return oh.processOrderConfirmationRequest();
		}
		else {
			l.warning("unknown formId:"+formId);
			//TODO throw execpton
		}
	
		return null;
		
	}

	/**
	 * 
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	private void dumpRequest(HttpServletRequest request) {
		
		l.fine("queryString: " + request.getQueryString());
		
		l.fine("Request Parameters:----------------------");
		Enumeration<String> en = request.getParameterNames();
		while (en.hasMoreElements()) {
			String parm = en.nextElement();
			l.fine(parm + "=" + request.getParameter(parm) + ", ");
		}
		
//		String classpath = System.getProperty("java.class.path");
//		l.fine("Classpath:" + classpath);
		
//		Enumeration<String> initParms = getInitParameterNames();
//		while (initParms.hasMoreElements()) {
//			l.fine("initparm:" + initParms.nextElement());
//		}
		
		l.fine("Request Attributes:----------------------");
		Enumeration<String> attr = request.getAttributeNames();
		while (attr.hasMoreElements()) {
			String a = attr.nextElement();
			l.fine("requestAttr:" + a + "=" + request.getAttribute(a));
		}
		
		l.fine("Session Attributes:----------------------");
		Enumeration<String> sessionAttrs = request.getSession().getAttributeNames();
		while (sessionAttrs.hasMoreElements()) {
			String a = sessionAttrs.nextElement();
			l.fine("sessionAttr:" + a + "=" + request.getSession().getAttribute(a));
		}

	}
	
}

