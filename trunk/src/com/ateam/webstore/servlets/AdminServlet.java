package com.ateam.webstore.servlets;

import java.io.IOException;
import java.util.logging.Level;
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
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.View;

public class AdminServlet extends AteamServlet implements Constants  {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			
		Visitor vis = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
		
		View v = null;		
		
			if (vis != null && vis.isEmployeeAuthenticated()) {
				
	
				
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
					v = oh.getAllView(false);
				}
				else if (req.getParameterMap().containsKey(Parameters.ALL_EMPLOYEES.getId())) {
					EmployeeHandler eh = new EmployeeHandler(req);
					v = eh.getEmployeeListView();
				}
				else if (req.getParameterMap().containsKey(Parameters.ADD_EMPLOYEE.getId())) {
					EmployeeHandler eh = new EmployeeHandler(req);
					v = eh.getAdminAddEmployeeView(null);
				}
				else if (req.getParameterMap().containsKey(Parameters.ORDER_ID.getId())) {
					OrderHandler oh = new OrderHandler(req);
					v = oh.getAdminOrderDetailsView();
				}
				else if (req.getParameterMap().containsKey(Parameters.PRODUCT.getId())) {
					ProductHandler ph = new ProductHandler(req);
					v = ph.getProductView(true, null);
				}
				else {
					Handler h = new Handler(req);
					v = h.getAdminHomeView();
				}
				
			}
			else {
				Handler h = new Handler(req);
				v = h.getLoginView("Please Login", h.getMainAdminView());
			}

			v.setServletPath("admin");
			req.setAttribute(REQUEST_ATTRIBUTE_VIEW, v);
			
			getServletConfig().getServletContext().getRequestDispatcher(
					JSP_ADMIN_MAIN).forward(req, resp);
			
		} catch (Exception e) {
			l.log(Level.SEVERE, "Exception caught in doGet", e);
			req.setAttribute(REQUEST_ATTRIBUTE_CONTEXT, "admin");
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}


		
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
			View v = results.getResultView();
			v.setServletPath("admin");
			req.setAttribute(REQUEST_ATTRIBUTE_VIEW, results.getResultView());

			l.info(req.getAttribute(REQUEST_ATTRIBUTE_VIEW).toString());
			
			//Forward to JSP
			getServletConfig().getServletContext().getRequestDispatcher(
					JSP_ADMIN_MAIN).forward(req, resp);

			
		} catch (Exception e) {
			l.log(Level.SEVERE, "Exception caught in doGet", e);
			req.setAttribute(REQUEST_ATTRIBUTE_CONTEXT, "admin");
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
	}


	/**
	 * Extracts a FormSubmission from the request.
	 * @param req
	 * @return
	 * @throws Exception 
	 */
	private FormSubmission processFormSubmission(HttpServletRequest req) throws Exception {

		String formId = req.getParameter(Parameters.FORM_ID.getId());
		
		l.info("process form:"+formId);

		Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
		
		if (v != null && v.isEmployeeAuthenticated()) {
			if (formId == null) {
				l.warning("null form ID ");
				throw new Exception();
			}
			else if (formId.equals(FormName.EDIT_PRODUCT.getId())) {
				ProductHandler ph = new ProductHandler(req); 
				return ph.processEditProductRequest();
			}
			else if (formId.equals(FormName.ADD_EMPLOYEE.getId())) {
				EmployeeHandler eh = new EmployeeHandler(req); 
				return eh.processAddEmployeeRequest();
			}
			else if (formId.equals(FormName.ORDER_UPDATE.getId())) {
				OrderHandler oh = new OrderHandler(req); 
				return oh.processOrderUpdateRequest();
			}
			else if (formId.equals(FormName.ORDER_CANCEL.getId())) {
				OrderHandler oh = new OrderHandler(req); 
				return oh.processOrderCancelRequest();
			}
			else {
				l.warning("unknown formId:"+formId);
				throw new Exception();
			}
		}
		else {
			if (formId.equals(FormName.LOGIN.getId())) {
				EmployeeHandler h = new EmployeeHandler(req);
				return h.processLoginRequest();
			}
			else {
				l.warning("unknown formId:"+formId);
				throw new Exception();
			}
		}
	}

	
}
