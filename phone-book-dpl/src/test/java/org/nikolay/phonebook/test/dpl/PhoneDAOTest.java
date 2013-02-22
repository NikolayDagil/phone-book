/**
 * 
 */
package org.nikolay.phonebook.test.dpl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.nikolay.phonebook.api.entity.Phone;
import org.nikolay.phonebook.api.entity.User;
import org.nikolay.phonebook.dpl.dao.PhoneDAO;
import org.nikolay.phonebook.dpl.entity.PhoneEntity;
import org.nikolay.phonebook.dpl.entity.UserEntity;

/**
 * @author Nikolay Dagil
 * @version 1.0.0
 */
public class PhoneDAOTest {

  private static final String TEST_A_STR = "TEST A";
  private static final Integer TEST_B_INT = 123;

  PhoneDAO phoneDAO = new PhoneDAO();

  @Test
  public void create() {

    /*
     * initialization parameters
     */
    int rowCount = 0;
    List<Phone> phones = null;

    /*
     * Getting a list of phone numbers in the database
     */

    phones = phoneDAO.getAll();

    Assert.assertNotNull(phones);
    rowCount = phones.size();

    /*
     * create a new user
     */

    User user = new UserEntity();
    user.setUsername(TEST_A_STR);
    user.setEmail(TEST_A_STR);
    user.setFirstName(TEST_A_STR);
    user.setLastName(TEST_A_STR);
    user.setPassword(TEST_A_STR);

    /*
     * Create a new phone
     */

    Phone phone = new PhoneEntity();
    phone.setMobile(TEST_B_INT);
    phone.setType(TEST_A_STR);
    phone.setUser(user);

    phoneDAO.save(phone);

    phones = phoneDAO.getAll();

    Assert.assertNotNull(phones);
    Assert.assertEquals(rowCount + 1, phones.size());

  }

  @Test
  public void delete() {
    /*
     * initialization parameters
     */
    int rowCount = 0;
    List<Phone> phones = null;

    /*
     * Getting a list of phone numbers in the database
     */

    phones = phoneDAO.getAll();

    Assert.assertNotNull(phones);
    rowCount = phones.size();

    /*
     * create user
     */
    User user = new UserEntity();
    user.setUsername(TEST_A_STR);
    user.setEmail(TEST_A_STR);
    user.setFirstName(TEST_A_STR);
    user.setLastName(TEST_A_STR);
    user.setPassword(TEST_A_STR);

    /*
     * create phone
     */
    Phone phone = new PhoneEntity();
    phone.setMobile(TEST_B_INT);
    phone.setType(TEST_A_STR);
    phone.setUser(user);

    phoneDAO.save(phone);

    phones = phoneDAO.getAll();

    Assert.assertNotNull(phones);
    Assert.assertEquals(rowCount + 1, phones.size());

    Long phoneId = phone.getId();
    phoneDAO.delete(phone);
    phones = phoneDAO.getAll();
    Assert.assertEquals(rowCount, phones.size());
    Assert.assertNull(phoneDAO.getId(phoneId));
  }

  @Test
  public void update() {
    int rowCount = 0;
    List<Phone> phones = null;

    phones = phoneDAO.getAll();

    Assert.assertNotNull(phones);
    rowCount = phones.size();

    /*
     * create user
     */
    User user = new UserEntity();
    user.setUsername(TEST_A_STR);
    user.setEmail(TEST_A_STR);
    user.setFirstName(TEST_A_STR);
    user.setLastName(TEST_A_STR);
    user.setPassword(TEST_A_STR);

    Phone phone = new PhoneEntity();
    phone.setMobile(TEST_B_INT);
    phone.setType(TEST_A_STR);
    phone.setUser(user);

    phoneDAO.save(phone);

    phones = phoneDAO.getAll();

    Assert.assertNotNull(phones);
    Assert.assertEquals(rowCount + 1, phones.size());

    Phone phoneUpdate = null;
    phoneUpdate = phoneDAO.getId(phone.getId());

    phoneUpdate.setType(TEST_A_STR);

    phoneDAO.update(phoneUpdate);

    Phone phoneFinal = phoneDAO.getId(phone.getId());

    Assert.assertEquals(phoneFinal.getType(), TEST_A_STR);
  }

}
