package com.ateam.webstore.servlets;

import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.views.ContentView;


public abstract class AteamServlet extends HttpServlet  {
	static Logger l = Logger.getLogger(Constants.LOGGER_NAME);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * 
	 * @param message
	 * @return
	 */
	protected ContentView getErrorContent() {
		ContentView cv = new ContentView(Constants.JSP_MESSAGE, "Opps...");
		return cv;
	}
	
	/**
	 * 
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	protected void dumpRequest(HttpServletRequest request) {
		//Logger l = Logger.getLogger(Constants.LOGGER_NAME);
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
