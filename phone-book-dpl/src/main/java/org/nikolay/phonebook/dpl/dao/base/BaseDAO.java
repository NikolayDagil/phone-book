/**
 * 
 */
package org.nikolay.phonebook.dpl.dao.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nikolay.phonebook.dpl.dao.util.HibernateUtil;

/**
 * @author Nikolay Dagil
 * @version 1.0.0
 */
public abstract class BaseDAO<I, T extends I, PK extends Serializable> {

  private Class<T> entityClass;

  /**
   * @param entityClass
   */
  public BaseDAO(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  /*
   * Create new object
   */
  public void save(I newInstance) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    try {
      transaction = session.beginTransaction();
      session.save(newInstance);
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  /*
   * Update object
   */
  public void update(I transientObject) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    try {
      transaction = session.beginTransaction();
      session.update(transientObject);
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  /*
   * Delete object
   */
  public void delete(I persistentObject) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    try {
      transaction = session.beginTransaction();
      session.delete(persistentObject);
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  /*
   * get id number of object
   */
  public I getId(Long PK) {
    I i = null;

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    try {
      transaction = session.beginTransaction();

      i = (I) session.get(entityClass, PK);
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }

    return i;
  }

  /*
   * get a list of objects
   */
  public List<I> getAll() {
    List<I> list = new ArrayList<I>();

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    try {
      transaction = session.beginTransaction();

      list = session.createQuery("FROM " + entityClass.getName()).list();
      System.out.println(list);

      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }

    return list;
  }
}
