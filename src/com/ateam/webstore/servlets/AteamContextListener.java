package com.ateam.webstore.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.utilities.LogFormatter;

public class AteamContextListener implements ServletContextListener {
	/**
	 * WebApp properties
	 */
	public static Properties ateamProperties = new Properties();
	
	FileHandler fileHandler;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

		Logger l = Logger.getLogger(Constants.LOGGER_NAME);
		l.removeHandler(fileHandler);
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		Logger l = Logger.getLogger(Constants.LOGGER_NAME);
		l.setLevel(Level.FINE);
		try {
			Handler[] ha = l.getHandlers();
			Handler fileHandler = null; 
			for (Handler h : ha) {
				l.info("handler: "+h);
				if (h.getClass().getName().equals(FileHandler.class.getName())) {
					l.fine("LogFileHandler found!");
					//hasFileHandler = true;
					fileHandler = h;
					break;
				}
			}
			
			
			String logFile = "/var/log/tomcat6/"+arg0.getServletContext().getContextPath().substring(1).replace("/", "_")+".log";
			
			fileHandler = new FileHandler(logFile, 0, 1, true);
			fileHandler.setFormatter(new LogFormatter());
			l.addHandler(fileHandler);				


		} catch (SecurityException e) {
			e.printStackTrace();
			l.log(Level.SEVERE, "", e);
		} catch (IOException e) {
			e.printStackTrace();
			l.log(Level.SEVERE, "", e);
		}
		
		
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("ateam-webstore.properties");

		if (is != null) {
			try {
				ateamProperties.load(is);
			} catch (IOException e) {
				e.printStackTrace();
				l.log(Level.SEVERE, "", e);
			}
		}
		else {
			l.warning("Couldnt find properties.");
		}
		
		l.info("Application initialized!");
		
	}
	/**
	 * 
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	protected static void dumpRequest(HttpServletRequest request) {
		Logger l = Logger.getLogger(Constants.LOGGER_NAME);
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
