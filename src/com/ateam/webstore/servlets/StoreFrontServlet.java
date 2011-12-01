package com.ateam.webstore.servlets;

import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ateam.webstore.handlers.AddressHandler;
import com.ateam.webstore.handlers.CartHandler;
import com.ateam.webstore.handlers.CreditCardHandler;
import com.ateam.webstore.handlers.CustomerHandler;
import com.ateam.webstore.handlers.OrderHandler;
import com.ateam.webstore.handlers.ProductHandler;
import com.ateam.webstore.handlers.WishListHandler;
import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.views.View;

/**
 * Handles basic GET requests
 *
 */
public class StoreFrontServlet extends AteamServlet implements Constants {
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
				CustomerHandler vh = new CustomerHandler(req);
				v = vh.getLoginView();
			}
			else if (req.getParameterMap().containsKey(Parameters.LOGOUT.getId())) {
				CustomerHandler vh = new CustomerHandler(req);
				v = vh.getLogoutView();
			}
			else if (req.getParameterMap().containsKey(Parameters.MY_ACCOUNT.getId())) {
				CustomerHandler vh = new CustomerHandler(req);
				v = vh.getMyAccountView();
			}
			else if (req.getParameterMap().containsKey(Parameters.FORGOT.getId())) {
				CustomerHandler vh = new CustomerHandler(req);
				v = vh.getForgotPasswordView();
			}
			else if (req.getParameterMap().containsKey(Parameters.REGISTER.getId())) {
				CustomerHandler vh = new CustomerHandler(req);
				v = vh.getRegistrationView();
			}		
			else if (req.getParameterMap().containsKey(Parameters.WISHLIST.getId())) {
				WishListHandler wlh = new WishListHandler(req);
				v = wlh.getWishListView();
			}
			else if (req.getParameterMap().containsKey(Parameters.VIEW_CART.getId())) {
				CartHandler ch = new CartHandler(req);
				v = ch.getCartView();
			}
			else if (req.getParameterMap().containsKey(Parameters.CART_ID.getId())) {
				CartHandler ch = new CartHandler(req);
				v = ch.getCartView();
			}
			else if (req.getParameterMap().containsKey(Parameters.CHECKOUT.getId())) {
				CartHandler ch = new CartHandler(req);
				v = ch.checkout();
			}
			else if (req.getParameterMap().containsKey(Parameters.CATEGORY_ID.getId())) {
				ProductHandler ph = new ProductHandler(req);
				v = ph.getCategoryView();
			}
			else if (req.getParameterMap().containsKey(Parameters.ORDER_ID.getId())) {
				OrderHandler oh = new OrderHandler(req);
				v = oh.getOrderDetailsView();
			}
			else if (req.getParameterMap().containsKey(Parameters.PRODUCT.getId())) {
				ProductHandler ph = new ProductHandler(req);
				v = ph.getProductView();
			}
			else if (req.getParameterMap().containsKey(Parameters.ALL_PRODUCTS.getId())) {
				ProductHandler ph = new ProductHandler(req);
				v = ph.getAllView(false);
			}
			else if (req.getParameterMap().containsKey(Parameters.FEEDBACK.getId())) {
				CustomerHandler ch = new CustomerHandler(req);
				v = ch.getFeedbackView();
			}
			else if (req.getParameterMap().containsKey("error")) {
				throw new Exception("Error Test");
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

			v.setServletPath("store");
			req.setAttribute(REQUEST_ATTRIBUTE_VIEW, v);
			
			getServletConfig().getServletContext().getRequestDispatcher(
					JSP_MAIN).forward(req, resp);

			
		} catch (Exception e) {
			l.log(Level.SEVERE, "Exception caught in doGet", e);
//			Handler h = new Handler(req);
//			View mv = new View(h.getMainView());
//			mv.setMessage(e.getMessage());
//			
//			mv.addContentView(getErrorContent());
//			
//			v = mv;
			
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		l.info("form submission "+req.getSession().getId());
		
		//Debugging
		dumpRequest(req);
		
		View v = null;
		
		try {
			
			//Get the form and process
			FormSubmission results = processFormSubmission(req);
			
			v = results.getResultView();

			v.setServletPath("store");
			req.setAttribute(REQUEST_ATTRIBUTE_VIEW, v);

			l.info(req.getAttribute(REQUEST_ATTRIBUTE_VIEW).toString());

			//Forward to JSP
			getServletConfig().getServletContext().getRequestDispatcher(
					JSP_MAIN).forward(req, resp);

		} catch (Exception e) {
			l.log(Level.WARNING, "Exception processing doGet", e);
//			Handler h = new Handler(req);
//			v = h.getMainView();
//			v.setMessage(e.getMessage());
//			v.addContentView(getErrorContent());

			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		}
		
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
			CustomerHandler h = new CustomerHandler(req);
			return h.processLoginRequest();
		}
		else if (formId.equals(FormName.REGISTER.getId())) {
			CustomerHandler h = new CustomerHandler(req);
			return h.processRegistrationRequest();
		}
		else if (formId.equals(FormName.EDIT_CART.getId())) {
			CartHandler ch = new CartHandler(req);
			return ch.processUpdate();
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
		else if (formId.equals(FormName.ADDRESS.getId())) {
			AddressHandler oh = new AddressHandler(req);
			return oh.processAddAddressRequest();
		}
		else if (formId.equals(FormName.CREDIT_CARD.getId())) {
			CreditCardHandler cch = new CreditCardHandler(req);
			return cch.processAddCardRequest();
		}
		else if (formId.equals(FormName.ADD_TO_CART.getId())) {
			CartHandler ch = new CartHandler(req);
			return ch.addProduct();
		}
		else if (formId.equals(FormName.ADD_TO_WISHLIST.getId())) {
			WishListHandler wh = new WishListHandler(req);
			return wh.addProduct();
		}
		else if (formId.equals(FormName.SEARCH.getId())) {
			ProductHandler ph = new ProductHandler(req);
			return ph.search();
		}

		else {
			l.warning("unknown formId:"+formId);
			//TODO throw execpton
		}
	
		return null;
		
	}

}

