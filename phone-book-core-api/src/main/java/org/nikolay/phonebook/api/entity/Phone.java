/**
 * 
 */
package org.nikolay.phonebook.api.entity;

/**
 * @author Nikolay Dagil
 * 
 */
public interface Phone {

	public Long getId();

	public void setId(Long id);

	public User getUser();

	public void setUser(User user);

	public String getType();

	public void setType(String type);

	public Integer getMobile();

	public void setMobile(Integer mobile);
}