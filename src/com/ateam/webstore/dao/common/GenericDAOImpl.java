/*
 *
 * Date         Change Flag    Shortname  Change Summary
 * ------------ -------------- ---------- --------------------------------------------
 * Jan 5, 2011	                   Hendrix Tavarez	  Created.
 * Feb 10, 2011                    Hendrix Tavarez    Commented out all the transactions begin/commit/rollback
 *                                                    letting the managed container handle transactions. WebSphere
 */
package com.ateam.webstore.dao.common;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;
import javax.naming.NamingException;

/**
 * @author Hendrix Tavarez
 *
 * The <code>GenericDAOImpl</code> class represents a ....
 *
 */
public class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK> {
  
  private Class<T> persistentClass;

  private PersistenceManager pm;

//  private static Log log;

  /**
   * Default constructor.
   * @throws NamingException 
   * @throws IOException 
   */
  @SuppressWarnings("unchecked")
  public GenericDAOImpl() {
    this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//    log = LogFactory.getLog(this.persistentClass);
    try {
      pm = AppPersistenceFactory.getInstance().getPM();
      pm.setMultithreaded(true);
    } catch (Exception ex) {
//    log.error("fail to get persistence manager instance", re);      
      ex.printStackTrace();
      throw new RuntimeException(ex);      
    } 
    
  }

  /**
   * @return EntityManager used to persist this object
   */
  protected PersistenceManager getPersistenceManager() {
    return this.pm;
  }

  /**
   * @return class type being persisted
   */
  protected Class<T> getPersistentClass() {
    return this.persistentClass;
  }

//  /**
//   * @return component logger object
//   */
//  public static Log getLog() {
//    return log;
//  }

  /*
   * (non-Javadoc)
   * @see com.ibm.sbg.inventory.dao.common.GenericDao#save(java.lang.Object)
   */
  public T save(T obj) {
//    log.debug("persisting new instance: " + obj.getClass());
    Transaction tx = pm.currentTransaction();
    try {
      tx.begin();
      pm.makePersistent(obj);
      tx.commit();
//      log.debug("persist successful");
    }
    catch (RuntimeException re) {
//      log.error("persist failed", re);
      throw re;
    }
    finally {
      if ( tx.isActive() ) {
        tx.rollback();
      }
      pm.close();
    }
    return (T) obj;
  }

  /*
   * (non-Javadoc)
   * @see com.ibm.sbg.inventory.dao.common.GenericDao#delete(java.lang.Object)
   */
  public void delete(T obj) {
//    log.debug("removing: " + obj.getClass());
    if(obj == null) return;
    Transaction tx = pm.currentTransaction();
    try {
      tx.begin();      
      pm.deletePersistent(obj);
      tx.commit();
//      log.debug("remove successful");
    }
    catch (RuntimeException re) {
//      log.error("remove failed", re);
      throw re;
    }
    finally {
      if ( tx.isActive() ) {
        tx.rollback();
      }
      pm.close();
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ibm.sbg.inventory.dao.common.GenericDao#read(java.io.Serializable)
   */
  public T get(PK id) {
//    log.debug("getting instance " + persistentClass + " with id: " + id);
    if (id == null) return null;
    try {
      T instance = pm.getObjectById(persistentClass, id);
      return pm.detachCopy(instance);
    }
    catch (RuntimeException re) {
//      log.error("read failed", re);
      throw re;
    }   
  }

  /*
   * (non-Javadoc)
   * @see com.ibm.sbg.inventory.dao.common.GenericDao#findAll()
   */
  @SuppressWarnings("unchecked")
  public Collection<T> getAll() {
//    log.debug("getting all instances " + persistentClass);
    try {
      Collection<T> query_entities = (Collection<T>) pm.newQuery(this.persistentClass).execute();
      Collection<T> detachedEntities = pm.detachCopyAll(query_entities);
//      entities.size();
//      log.debug("get successful");
      return detachedEntities;
    }
    catch (RuntimeException re) {
//      log.error("getAll failed", re);
      throw re;
    }
    finally {
      pm.close();
    }
  }

  /* (non-Javadoc)
   * @see com.ibm.sbg.inventory.dao.common.GenericDao#refresh(java.lang.Object)
   */
  @SuppressWarnings("unused")
  private void refresh(T transientObject) {
//    log.debug("refreshing " + persistentClass);
    try {
      pm.refresh(transientObject);
//      log.debug("refreshing successful");
    }
    catch (RuntimeException re) {
//      log.error("refresh failed", re);
      throw re;
    }
    finally {
      pm.close();
    }    
  }

//  /* (non-Javadoc)
//   * @see com.ibm.sbg.inventory.dao.common.GenericDao#mergeTransient(java.lang.Object)
//   */
//  @SuppressWarnings({ "unchecked", "hiding", "unused" })
//  public <T> T mergeTransient(T tInstance) { 
//    if( get((PK) ((BaseModel) tInstance).getId()) != null ) {
//      pm.makePersistent(tInstance);
//      return tInstance;
//    } else {
//      PK primaryKey = (PK) PersistenceHelper.findPrimaryKey(tInstance);
//      if(primaryKey != null) {
//        Object entity = pm.getObjectById(tInstance.getClass(), primaryKey);
//        if(entity == null) {
//          pm.makePersistent(tInstance);
//          return tInstance;
//        }
//        else {
//          try {
//            PersistenceHelper.copyPersistentFields(entity, tInstance);
//          } catch (IllegalAccessException e1) {
//            e1.printStackTrace();
//            throw new IllegalArgumentException("Can't copy fields from transient class to persistent class.");
//          } catch (NoSuchMethodException e1) {
//            throw new IllegalArgumentException("Can't copy fields from transient class to persistent class.");
//          } catch (InvocationTargetException e1) {
//            throw new IllegalArgumentException("Can't copy fields from transient class to persistent class.");
//          }
//          pm.makePersistent(entity);
//          return (T) entity;
//        }
//      } else {
//        // primary key may be null, assume insert
//        pm.makePersistent(tInstance);
//        return tInstance;
//      }
//    }
//  }

}
