/*
 *
 * Date         Change Flag    Shortname  Change Summary
 * ------------ -------------- ---------- --------------------------------------------
 * Jan 5, 2011	                   Hendrix Tavarez	  Created.
 */
package com.ateam.webstore.dao.common;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author Hendrix Tavarez
 *
 * The <code>GenericDAO</code> class represents a ....
 *
 */
public interface GenericDAO <T, PK extends Serializable>  {

  /**
   * Persist the newInstance object into database
   * 
   * @param newInstance
   * @return detached copy of persisted object
   */
  T save(T newInstance);

  /**
   * Retrieve an object that was previously persisted to the database using
   * the indicated id as primary key
   * 
   * @param id
   * @return object
   */
  T get(PK id);
  
  /**
   * Remove an object from persistent storage in the database
   * 
   * @param persistentObject
   */
  void delete(T persistentObject);

  /**
   * Refreshes the transient object
   * 
   * @param transientObject
   */
//  void refresh(T transientObject); /* NOT IMPLEMENTED YET */
  
  /**
   * @return all objects from persistent storage in the database
   */
  public Collection<T> getAll();
  
  /**
   * @param <T>
   * @param tInstance
   * @return
   */
//  @SuppressWarnings("hiding") 
//  <T> T mergeTransient(T tInstance); /* NOT IMPLEMENTED YET */
  
}
