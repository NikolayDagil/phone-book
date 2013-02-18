/**
 * 
 */
package org.nikolay.phonebook.api.entity;

import java.util.List;

/**
 * @author Nikolay Dagil
 * 
 */
public interface User {

	public Long getId();

	public void setId(Long id);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public String getUsername();

	public void setUsername(String username);

	public String getEmail();

	public void setEmail(String email);

	public String getPassword();

	public void setPassword(String password);

	public List<Phone> getPhones();

	public void setPhones(List<Phone> phones);
}