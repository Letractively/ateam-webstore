package com.ateam.webstore.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.HomePageView;
import com.ateam.webstore.ui.views.LoginView;
import com.ateam.webstore.ui.views.RegistrationView;
import com.ateam.webstore.ui.views.View;


public class MainServlet extends HttpServlet implements Constants {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		View v;
		
		if (req.getParameterMap().containsKey("login")) {
			
			v = getLoginView(req);
		}
		else {
			v = getHomePageView(req);
		}
		
		req.setAttribute(REQUEST_ATTRIBUTE_VIEW, v);
		
		getServletConfig().getServletContext().getRequestDispatcher(
				"/main.jsp").forward(req, resp);

	}
	
	private LoginView getLoginView (HttpServletRequest req) {
		
		LoginView l = new LoginView();
		
		ContentView cv = new ContentView();
		cv.setContentHeader("Login");
		cv.setContentText("Please Login");
		cv.setJspf("/login.jspf");
		l.getContentViews().add(cv);

		Visitor v = new Visitor();
		v.setName("John Doe");
		v.setEmail("john.doe@foo");
		l.setVisitor(v);
		
		return l;
	}
	
	/**
	 * 
	 * @param req 
	 * @return
	 */
	private HomePageView getHomePageView(HttpServletRequest req) {
		HomePageView hp = new HomePageView();
		hp.setTitle("Welcome to ATeam WebStore");
		hp.setHeaderTitle(hp.getTitle());
		Map<String, String> navLinks = new HashMap<String,String>();
		navLinks.put("Electronics", "/electronics");
		navLinks.put("Furniture", "/furniture");
		hp.setNavLinks(navLinks );
		
		Visitor v = new Visitor();
		v.setName("John Doe");
		hp.setVisitor(v);
		return hp;
		
	}
	
	private RegistrationView getRegistrationView() {
		RegistrationView r = new RegistrationView();
		//ArrayList<String> sec;
		//r.setSecurityQuestions(sec);
		return null;
		
	}

}
