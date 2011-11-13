/*
 *
 * Date         Change Flag    Shortname  Change Summary
 * ------------ -------------- ---------- --------------------------------------------
 * Jan 9, 2011	                   Hendrix Tavarez	  Created.
 */
package com.ateam.webstore.dao.common;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Properties;

import javax.jdo.annotations.PrimaryKey;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DataSourceConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.KeyedObjectPoolFactory;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.commons.pool.impl.StackKeyedObjectPoolFactory;


/**
 * @author Hendrix Tavarez
 *
 * The <code>PersistenceHelper</code> class represents a ....
 *
 */
public class PersistenceHelper {
  
  /**
   * This is the actual properties values passed-on to JDO PersistenceManagerFactory.
   * 
   * The values for this properties are a mix from hardcoded values defined in the 
   * getDatanucleusProperties() method and the values in the inventory properties
   * 
   */
  private static Properties properties = null;
  
  /**
   * This is the inventory properties file.
   * 
   * It is used to load the actual properties file and select ONLY the JDO connections 
   * arguments, if they are not defined in the Context (Websphere) Namespace.
   */
  private static Properties propertiesFile = new Properties();
  
  static {
    try {
      propertiesFile.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("ateam-webstore.properties"));
    } catch (IOException e) {
      System.err.println("PersistenceHelper failed to load inventory.properties file.");
    }
  }
    
  public static final String CONNECTION_FACTORY_NAME = "javax.jdo.option.ConnectionFactory";
  
  public static final String CONNECTION_DRIVER_NAME = "javax.jdo.option.ConnectionDriverName";
  
  public static final String CONNECTION_URL = "javax.jdo.option.ConnectionURL";
  
  public static final String CONNECTION_USER_NAME = "javax.jdo.option.ConnectionUserName";
  
  public static final String CONNECTION_PASSWORD = "javax.jdo.option.ConnectionPassword";
    
  /**
   * Load and append the datanucleus properties
   * 
   * @return properties
   * @throws Exception
   */
  public static Properties getDatanucleusProperties() throws Exception {
        
    System.out.println("getDatanucleusProperties (start)");
    if(properties == null) {
      
      properties = new Properties();
      
//      // datanucleus JDOPersistenceManagerFactory implementation
      properties.put("javax.jdo.PersistenceManagerFactoryClass", "org.datanucleus.jdo.JDOPersistenceManagerFactory");
      
      properties.put("datanucleus.storeManagerType", "rdbms");      
      properties.put("datanucleus.Mapping", "mysql");
      
      // for performance reason
      properties.put("datanucleus.metadata.validate", "false");
      properties.put("datanucleus.validateTables", "false");
      properties.put("datanucleus.validateConstraints", "false");
      properties.put("datanucleus.validateColumns", "false");
      properties.put("datanucleus.rdbms.CheckExistTablesOrViews", "false");
      properties.put("datanucleus.rdbms.initializeColumnInfo", "None");
      properties.put("datanucleus.persistenceByReachabilityAtCommit", "false");
      
      properties.put("datanucleus.cache.collections", "true");      
      properties.put("datanucleus.cache.collections.lazy", "true");
      
      // our DB is fixed, schema already exists
      properties.put("datanucleus.autoCreateSchema", "false");
      properties.put("datanucleus.autoCreateTables", "false");
      properties.put("datanucleus.autoCreateColumns", "false");
      properties.put("datanucleus.autoCreateConstraints", "false");
      properties.put("datanucleus.fixedDatastore", "true");
      
      // all of our entities are detachable 
      properties.put("datanucleus.DetachAllOnCommit", "true");
      properties.put("datanucleus.CopyOnAttach", "true");
      
      // disable L2 caching 
//      properties.put("datanucleus.cache.level2.type", "none");
      
      properties.put("datanucleus.maxFetchDepth", "2");
//      properties.put("datanucleus.NontransactionalWrite", "false");
      
//      properties.put("datanucleus.Schema", "database");
      
//      try {
//        
//        Context ctx = new InitialContext();
//        DataSource ds = (DataSource) ctx.lookup("webapp-datasource");
//        properties.put("datanucleus.ConnectionFactoryName", ds);
//        
//      } catch (Exception e) {
//        
//        System.err.println(String.format("data source connection does not exists or could not be set: %s", e.getLocalizedMessage()));
        // if data source does not exists, fall back to generic JDBC connection
//        getGenericJdbcConnection(properties);
//      }
        
        loadPropertyFile();
      
    }
    
    return properties;
  }
  
  /**
   * This method creates a JDBC connection pool
   * 
   * @param properties
   * @throws Exception
   */
  private static void getGenericJdbcConnection(Properties properties) throws Exception {
    
    String driver = getPropertyValue(CONNECTION_DRIVER_NAME);
    String url = getPropertyValue(CONNECTION_URL);
    String user = getPropertyValue(CONNECTION_USER_NAME);
    String passwd = getPropertyValue(CONNECTION_PASSWORD);
    
    // Load the JDBC driver
    Class.forName(driver);

    // Create the actual pool of connections 
    ObjectPool connectionPool = new GenericObjectPool(null);

    // Create the factory to be used by the pool to create the connections
    ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(url, user, passwd);

    // Create a factory for caching the PreparedStatements
    KeyedObjectPoolFactory kpf = new StackKeyedObjectPoolFactory(null, 20);

    // Wrap the connections with pooled variants
//    PoolableConnectionFactory pcf = 
        new PoolableConnectionFactory(connectionFactory, connectionPool, kpf, null, false, true, Connection.TRANSACTION_READ_COMMITTED);

    // Create the datasource
    DataSource ds = new PoolingDataSource(connectionPool);
    
    // Create our PMF
    properties.put(CONNECTION_DRIVER_NAME, driver);
    properties.put("datanucleus.ConnectionFactory", ds);
    
  }
  
  private static void loadPropertyFile() {
	  for(Object key: propertiesFile.keySet()) {
		  if(!properties.containsKey(key)) {
			  properties.put(key, getPropertyValue((String)key));
		  }
	  }
  }
  
  
  private static String getPropertyValue(String key) {
	  
    return propertiesFile.getProperty(key);
    
  }
  
  public static void logProperties(Properties prop) {
    
    for (Object key : prop.keySet()) {
      if( ((String)key).indexOf("Password") > 0) {
        System.out.println(key + " -- XXXXXXXXXXXXXXXXXXX");
      } else {
        System.out.println(key + " -- " + prop.get(key));
      }
    }    
  }
  
  
  public static <T> Object findPrimaryKey(T tInstance) {
    if (tInstance == null) {
      return null;
    }
    for (Field l : tInstance.getClass().getDeclaredFields()) {
      if (l.getAnnotation(PrimaryKey.class) != null
          /* JPA => || l.getAnnotation(Id.class) != null */ ) {
        l.setAccessible(true);
        try {
          return l.get(tInstance);
        } catch (IllegalArgumentException e) {
          e.printStackTrace();
          return null;
        } catch (IllegalAccessException e) {
          e.printStackTrace();
          return null;
        }
      }
    }
    return new IllegalArgumentException(
        "Class " + tInstance.getClass().getName()
            + " does not have a method called getId()");
  }

  public static <T> void copyPersistentFields(Object entity, T tInstance)
      throws IllegalAccessException, NoSuchMethodException,
      InvocationTargetException {
    for (Method f : tInstance.getClass().getMethods()) {
      if (f.getName().startsWith("set") && Character
          .isUpperCase(f.getName().charAt(3))) {
       f.setAccessible(true);
        Method getter = tInstance.getClass()
            .getMethod("get" + f.getName().substring(3));
        getter.setAccessible(true);
        f.invoke(entity, getter.invoke(tInstance));
      }
    }
  }
}
