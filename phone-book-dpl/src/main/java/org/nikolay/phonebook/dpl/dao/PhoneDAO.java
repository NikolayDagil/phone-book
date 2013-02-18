/**
 * 
 */
package org.nikolay.phonebook.dpl.dao;

import org.nikolay.phonebook.api.dao.IPhoneDAO;
import org.nikolay.phonebook.api.entity.Phone;
import org.nikolay.phonebook.dpl.dao.base.BaseDAO;
import org.nikolay.phonebook.dpl.entity.PhoneEntity;

/**
 * @author Nikolay Dagil
 * @version 1.0.0
 */
public class PhoneDAO extends BaseDAO<Phone, PhoneEntity, Long> implements IPhoneDAO {

  public PhoneDAO() {
    super(PhoneEntity.class);
  }

}
