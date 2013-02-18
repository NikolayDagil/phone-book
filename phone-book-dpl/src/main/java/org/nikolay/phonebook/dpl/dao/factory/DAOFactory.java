/**
 * 
 */
package org.nikolay.phonebook.dpl.dao.factory;

import org.nikolay.phonebook.api.dao.factory.IDAOFactory;
import org.nikolay.phonebook.dpl.dao.PhoneDAO;
import org.nikolay.phonebook.dpl.dao.UserDAO;

/**
 * @author Nikolay Dagil
 * @version 1.0.0
 */
public class DAOFactory implements IDAOFactory {

  public Object getDAO(String dao) {

    Object result = null;
    if (dao.equals("UserDAO")) {
      result = new UserDAO();
    }
    if (dao.equals("PhoneDAO")) {
      result = new PhoneDAO();
    }

    return result;
  }

}
