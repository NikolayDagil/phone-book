/**
 * 
 */
package org.nikolay.phonebook.api.dao;

import org.nikolay.phonebook.api.dao.base.IBaseDAO;
import org.nikolay.phonebook.api.entity.User;

/**
 * @author Nikolay Dagil
 * @version 1.0.0
 */

public interface IUserDAO extends IBaseDAO<User, Long> {

  public Boolean isExistsByUsername(String login);

  public Boolean isExistsByEmail(String email);
}
