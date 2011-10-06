package com.ateam.webstore.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.View;


public class MainServlet extends HttpServlet implements Constants {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		View v = getMainView();
		
		if (req.getParameterMap().containsKey("login")) {
			List<ContentView> contentViews = new ArrayList<ContentView>();
			contentViews.add(getLoginView());
			v.setContentViews(contentViews );
		}
		
		req.setAttribute(REQUEST_ATTRIBUTE_VIEW, v);
		
		getServletConfig().getServletContext().getRequestDispatcher(
				"/main.jsp").forward(req, resp);

	}
	
	private View getMainView() {
		View v = new View();
		v.setTitle("A+Team WebStore");
		v.setHeaderTitle("A+Team WebStore");
		v.setHeaderSubText("pitty the foo");
		Map<String, String> navLinks = new HashMap<String,String>();
		navLinks.put("Login", "main?login");
		v.setNavLinks(navLinks );
		return v;

	}
	
	private ContentView getLoginView () {
		ContentView cv = new ContentView();
		cv.setContentHeader("Login");
		cv.setContentText("Please Login");
		cv.setJspf("/login.jspf");
		return cv;
	}

}
