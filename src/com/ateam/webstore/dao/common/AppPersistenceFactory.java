/*
 *
 * Date         Change Flag    Shortname  Change Summary
 * ------------ -------------- ---------- --------------------------------------------
 * Jan 22, 2011	                   Hendrix Tavarez	  Created.
 */
package com.ateam.webstore.dao.common;

import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.naming.NamingException;

/**
 * @author Hendrix Tavarez
 *
 * The <code>AppPersistenceFactory</code> class represents a ....
 *
 */
public class AppPersistenceFactory {
  
  /**
   * Singlenton
   */
  private static AppPersistenceFactory instance;
  
  /**
   * Persistence Manager Factory
   */
  private static PersistenceManagerFactory pmfInstance;
  
  /**
   * Properties used to create this PersistenceManager
   */
  private Properties properties;

  /**
   * Initializes a <code>AppPersistenceFactory</code> and sets the properties and persistenceManagerFactory
   *
   * @throws Exception
   * @throws NamingException
   */
  private AppPersistenceFactory() throws Exception {
    init();
  }
  
  /**
   * Set properties used to create the persistence manager factory
   * @throws Exception
   */
  private void init() throws Exception {
    
    System.out.println("init-1");
    properties = PersistenceHelper.getDatanucleusProperties();
    
    System.out.println("init-2");
    PersistenceHelper.logProperties(properties);
    
    System.out.println("init-3");
    pmfInstance = JDOHelper.getPersistenceManagerFactory(properties);
    System.out.println("init-4");
  }
  
  /**
   * @return properties
   */
  public Properties getProperties() {
    return properties;
  }
  
  /**
   * @return the persistence manager
   */
  public synchronized PersistenceManager getPM() {
    return pmfInstance.getPersistenceManager();
  }
  
  /**
   * 
   * @return the App Persistence Factory
   * @throws Exception
   * @throws NamingException
   */
  public synchronized static AppPersistenceFactory getInstance() throws Exception, NamingException {
      if( instance == null ) {
        System.out.println("instance == null");
        instance = new AppPersistenceFactory();
        System.out.println("new AppPersistenceFactory() created");
      }
      return instance;
  }

}
