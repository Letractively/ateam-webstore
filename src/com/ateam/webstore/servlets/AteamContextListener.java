package com.ateam.webstore.servlets;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.utilities.LogFormatter;

public class AteamContextListener implements ServletContextListener {

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
			
			String logFile = "/var/log/tomcat6/ateam.log";
			
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
		
		l.info("Application initialized!");
		
	}

}
