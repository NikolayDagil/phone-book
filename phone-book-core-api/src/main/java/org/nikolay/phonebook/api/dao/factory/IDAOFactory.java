/**
 * 
 */
package org.nikolay.phonebook.api.dao.factory;

/**
 * @author Nikolay Dagil
 *
 */
public interface IDAOFactory {
	
	public Object getDAO(String dao);

}