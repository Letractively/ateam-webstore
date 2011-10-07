package com.ateam.webstore.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.models.Product;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.HomePageView;
import com.ateam.webstore.ui.views.LoginView;
import com.ateam.webstore.ui.views.ProductDetailsView;
import com.ateam.webstore.ui.views.RegistrationView;
import com.ateam.webstore.ui.views.View;


public class MainServlet extends HttpServlet implements Constants {
	static Logger l = Logger.getLogger(MainServlet.class.getName().toString());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		View v;
		
		if (req.getParameterMap().containsKey(Parameters.LOGIN.getId())) {
			v = getLoginView(req);
		}
		else if (req.getParameterMap().containsKey(Parameters.REGISTER.getId())) {
			v = getLoginView(req);
		}		
		else if (req.getParameterMap().containsKey(Parameters.PRODUCT_ID.getId())) {
			v = getProductView(req);
		}
		else if (req.getParameterMap().containsKey(Parameters.CART.getId())) {
			v = getCartView(req);
		}
		else if (req.getParameterMap().containsKey(Parameters.CATEGORY.getId())) {
			v = getProductList(req);
		}

		else {
			v = getHomePageView(req);
		}
		
		l.info("passing view:"+v);
		
		if (v.getVisitor() != null) {
			l.info("visitor:"+v.getVisitor().toString());
		}
		else {
			l.info("null visitor");
		}
		
		req.setAttribute(REQUEST_ATTRIBUTE_VIEW, v);
		
		getServletConfig().getServletContext().getRequestDispatcher(
				"/main.jsp").forward(req, resp);

	}
	
	private View getProductList(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Process a request to view the cart
	 * @param req
	 * @return
	 */
	private View getCartView(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Get the product view
	 * @param req
	 * @return
	 */
	private ProductDetailsView getProductView(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Process a request to view the login form.
	 * @param req
	 * @return
	 */
	private View getLoginView (HttpServletRequest req) {
		
		View l = getMainView(req);
		
		ContentView cv = new ContentView();
		cv.setContentHeader("Login");
		cv.setContentText("Please Login");
		cv.setJspf("/login.jsp");
		l.getContentViews().add(cv);

//		Visitor v = new Visitor();
//		v.setName("John Doe");
//		v.setEmail("john.doe@foo");
//		l.setVisitor(v);
		
		return l;
	}
	
	/**
	 * Gets the home page view.
	 * @param req 
	 * @return
	 */
	static HomePageView getHomePageView(HttpServletRequest req) {
		HomePageView hp = new HomePageView(getMainView(req));
		
		List<Product> featuredProducts = new ArrayList<Product>();
		hp.setFeaturedProducts(featuredProducts );
		
		ContentView cv = new ContentView();
		cv.setContentHeader("Featured Products");
		cv.setContentText("Check out these winners...");
		cv.setJspf("/home.jsp");
		hp.getContentViews().add(cv);

		
		return hp;
		
	}
	
	/**
	 * Gets the registration view
	 * @param req
	 * @return
	 */
	private RegistrationView getRegistrationView(HttpServletRequest req) {
		RegistrationView r = new RegistrationView();
		List<String> sec = new ArrayList<String>();
		r.setSecurityQuestions(sec);
		return null;
		
	}
	
	/**
	 * Builds the main site View
	 * @return
	 */
	static View getMainView(HttpServletRequest req) {
		View v = new View();
		v.setTitle("A+Team WebStore");
		v.setHeaderTitle(v.getTitle());
		Map<String, String> navLinks = new HashMap<String,String>();
		navLinks.put("Category 1", req.getContextPath()+"/store?category=cat1");
		navLinks.put("Category 2", req.getContextPath()+"/store?category=cat2");
		navLinks.put("Category 3", req.getContextPath()+"/store?category=cat3");
		v.setNavLinks(navLinks);
		Object o = req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
		if (o != null) {
			v.setVisitor((Visitor) o);			
		}
		return  v;
	}

}

