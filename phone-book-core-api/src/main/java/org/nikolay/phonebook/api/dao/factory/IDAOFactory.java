/**
 * 
 */
package org.nikolay.phonebook.api.dao.factory;

/**
 * @author Nikolay Dagil
 * @version 1.0.0
 */
public interface IDAOFactory {

  public Object getDAO(String dao);

}
