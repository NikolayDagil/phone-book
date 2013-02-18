/**
 * 
 */
package org.nikolay.phonebook.api.dao.base;

import java.io.Serializable;
import java.util.List;

/**
 * @author Nikolay Dagil
 * @version 1.0.0
 */
public interface IBaseDAO<I, PK extends Serializable> {

  public void save(I i);

  public void update(I i);

  public void delete(I i);

  public I getId(Long PK);

  public List<I> getAll();
}
