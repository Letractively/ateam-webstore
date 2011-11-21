package com.ateam.webstore.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ateam.webstore.handlers.EmployeeHandler;
import com.ateam.webstore.handlers.Handler;
import com.ateam.webstore.handlers.OrderHandler;
import com.ateam.webstore.handlers.ProductHandler;
import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.View;

public class AdminServlet extends HttpServlet implements Constants  {
	static Logger l = Logger.getLogger(Constants.LOGGER_NAME);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		View v = null;
		
		if (req.getParameterMap().containsKey(Parameters.LOGIN.getId())) {
			EmployeeHandler eh = new EmployeeHandler(req);
			v = eh.getLoginView(null);
		}
		else if (req.getParameterMap().containsKey(Parameters.ALL_PRODUCTS.getId())) {
			ProductHandler ph = new ProductHandler(req);
			v = ph.getAllView(true);
		}
		else if (req.getParameterMap().containsKey(Parameters.ALL_ORDERS.getId())) {
			OrderHandler oh = new OrderHandler(req);
			v = oh.getAllView();
		}

		else if (req.getParameterMap().containsKey(Parameters.ALL_EMPLOYEES.getId())) {
			EmployeeHandler eh = new EmployeeHandler(req);
			v = eh.getEmployeeListView();
		}
		else if (req.getParameterMap().containsKey(Parameters.ORDER_ID.getId())) {
			OrderHandler oh = new OrderHandler(req);
			v = oh.getAdminOrderDetailsView();
		}
		else if (req.getParameterMap().containsKey(Parameters.PRODUCT.getId())) {
			ProductHandler ph = new ProductHandler(req);
			v = ph.getProductView(true);
		}
		else {
			Handler h = new Handler(req);
			if (req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR) != null
					&& ((Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR)).isAuthenticated()) {
				v = h.getAdminHomeView();				
			}
			else {
				v = h.getLoginView("Please Login", h.getMainAdminView());
			}
 
		}

		v.setServletPath("admin");
		req.setAttribute(REQUEST_ATTRIBUTE_VIEW, v);
		
		getServletConfig().getServletContext().getRequestDispatcher(
				JSP_ADMIN_MAIN).forward(req, resp);

		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
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
			EmployeeHandler h = new EmployeeHandler(req);
			return h.processLoginRequest();
		}
		else {
			l.warning("unknown formId:"+formId);
			//TODO throw execpton
		}
	
		return null;
		
	}

	
}
