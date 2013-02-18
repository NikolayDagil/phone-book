/**
 * 
 */
package org.nikolay.phonebook.dpl.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nikolay.phonebook.api.dao.IUserDAO;
import org.nikolay.phonebook.api.entity.User;
import org.nikolay.phonebook.dpl.dao.base.BaseDAO;
import org.nikolay.phonebook.dpl.dao.util.HibernateUtil;
import org.nikolay.phonebook.dpl.entity.UserEntity;

/**
 * @author Nikolay Dagil
 * @version 1.0.0
 */
public class UserDAO extends BaseDAO<User, UserEntity, Long> implements IUserDAO {

  public UserDAO() {
    super(UserEntity.class);
  }

  // control username
  @Override
  public Boolean isExistsByUsername(String username) {
    Boolean result = true;

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    try {
      transaction = session.beginTransaction();

      Query query = session.createQuery("from UserEntity user where user.username = :username");
      query.setParameter("username", username);

      List<User> users = new ArrayList<>();
      users = query.list();

      if (users.isEmpty()) {
        result = false;
      }

      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }

    return result;
  }

  // control email
  @Override
  public Boolean isExistsByEmail(String email) {
    Boolean result = true;

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    try {
      transaction = session.beginTransaction();

      Query query = session.createQuery("from UserEntity user where user.email = :email");
      query.setParameter("email", email);

      List<User> users = new ArrayList<>();
      users = query.list();

      if (users.isEmpty()) {
        result = false;
      }

      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }

    return result;
  }
}
