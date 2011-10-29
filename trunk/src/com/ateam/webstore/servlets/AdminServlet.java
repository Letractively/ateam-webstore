package com.ateam.webstore.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ateam.webstore.handlers.VisitorHandler;
import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.Constants.Parameters;
import com.ateam.webstore.ui.views.View;

public class AdminServlet extends HttpServlet implements Constants  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		View v = null;
		
		if (req.getParameterMap().containsKey(Parameters.LOGIN.getId())) {
			VisitorHandler vh = new VisitorHandler(req);
			v = vh.getLoginView();
		}
		else {
			VisitorHandler vh = new VisitorHandler(req);
			v = vh.getLoginView();
		}

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

}
