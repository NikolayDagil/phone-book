/**
 * 
 */
package org.nikolay.phonebook.dpl.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.nikolay.phonebook.api.entity.Phone;
import org.nikolay.phonebook.api.entity.User;

/**
 * @author Nikolay Dagil
 * @version 1.0.0
 */
@Entity
@Table(name = "user")
public class UserEntity implements User, Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "email")
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @OneToMany(mappedBy = "user", targetEntity = PhoneEntity.class)
  private List<Phone> phones;

  public UserEntity() {}

  public UserEntity(Long id, String firstName, String lastName, String username, String email,
      String password, List<Phone> phones) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.email = email;
    this.password = password;
    this.phones = phones;
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String getFirstName() {
    return firstName;
  }

  @Override
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public String getLastName() {
    return lastName;
  }

  @Override
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public List<Phone> getPhones() {
    return phones;
  }

  @Override
  public void setPhones(List<Phone> phones) {
    this.phones = phones;
  }

  @Override
  public String toString() {
    return "UserEntity [" + (id != null ? "id=" + id + ", " : "")
        + (firstName != null ? "firstName=" + firstName + ", " : "")
        + (lastName != null ? "lastName=" + lastName + ", " : "")
        + (username != null ? "username=" + username + ", " : "")
        + (email != null ? "email=" + email + ", " : "")
        + (password != null ? "password=" + password + ", " : "")
        + (phones != null ? "phones=" + phones : "") + "]";
  }

}
