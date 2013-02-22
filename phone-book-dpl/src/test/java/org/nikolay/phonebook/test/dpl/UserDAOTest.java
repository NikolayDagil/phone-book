/**
 * 
 */
package org.nikolay.phonebook.test.dpl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.nikolay.phonebook.api.entity.User;
import org.nikolay.phonebook.dpl.dao.UserDAO;
import org.nikolay.phonebook.dpl.entity.UserEntity;

/**
 * @author Nikolay Dagil
 * @version 1.0.0
 */
public class UserDAOTest {

  private static final String TEST_A_STR = "TEST A";
  private static final String TEST_B_STR = "TEST B";

  UserDAO userDAO = new UserDAO();

  @Test
  public void create() {

    /*
     * initialization parameters
     */
    int rowCount = 0;
    List<User> users = null;

    /*
     * Getting a list of users in the database
     */

    users = userDAO.getAll();

    Assert.assertNotNull(users);
    rowCount = users.size();

    /*
     * Create a new user
     */
    User user = new UserEntity();
    user.setFirstName(TEST_A_STR);
    user.setLastName(TEST_A_STR);
    user.setUsername(TEST_A_STR);
    user.setPassword(TEST_A_STR);
    user.setEmail(TEST_A_STR);

    userDAO.save(user);

    users = userDAO.getAll();

    Assert.assertNotNull(users);
    Assert.assertEquals(rowCount + 1, users.size());

  }

  @Test
  public void delete() {
    int rowCount = 0;
    List<User> users = null;

    users = userDAO.getAll();

    Assert.assertNotNull(users);
    rowCount = users.size();

    User user = new UserEntity();
    user.setFirstName(TEST_A_STR);
    user.setLastName(TEST_A_STR);
    user.setUsername(TEST_A_STR);
    user.setEmail(TEST_A_STR);
    user.setPassword(TEST_A_STR);
    userDAO.save(user);

    users = userDAO.getAll();
    Assert.assertNotNull(users);
    Assert.assertEquals(rowCount + 1, users.size());

    Long userId = user.getId();
    userDAO.delete(user);
    users = userDAO.getAll();
    Assert.assertEquals(rowCount, users.size());
    Assert.assertNull(userDAO.getId(userId));
  }

  @Test
  public void update() {
    int rowCount = 0;
    List<User> users = null;

    users = userDAO.getAll();

    Assert.assertNotNull(users);
    rowCount = users.size();

    User user = new UserEntity();
    user.setFirstName(TEST_A_STR);
    user.setLastName(TEST_A_STR);
    user.setUsername(TEST_A_STR);
    user.setEmail(TEST_A_STR);
    user.setPassword(TEST_A_STR);
    userDAO.save(user);

    users = userDAO.getAll();
    Assert.assertNotNull(users);
    Assert.assertEquals(rowCount + 1, users.size());

    User userUpdate = null;
    userUpdate = userDAO.getId(user.getId());

    userUpdate.setFirstName(TEST_B_STR);
    userUpdate.setLastName(TEST_B_STR);
    userUpdate.setUsername(TEST_B_STR);
    userUpdate.setEmail(TEST_B_STR);

    userDAO.update(userUpdate);

    User userFinal = userDAO.getId(user.getId());

    Assert.assertEquals(userFinal.getFirstName(), TEST_B_STR);
  }

}
