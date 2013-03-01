/**
 * 
 */
package org.nikolay.phonebook.dpl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.nikolay.phonebook.api.entity.Phone;
import org.nikolay.phonebook.api.entity.User;

/**
 * @author Nikolay Dagil
 * @version 1.0.0
 */
@Entity
@Table(name = "phone")
public class PhoneEntity implements Phone, Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, targetEntity = UserEntity.class)
  @JoinColumn(name = "user_fk")
  private User user;

  @Column(name = "type")
  private String type;

  @Column(name = "number")
  private String number;

  public PhoneEntity() {}

  public PhoneEntity(Long id, User user, String type, String number) {
    this.id = id;
    this.user = user;
    this.type = type;
    this.number = number;
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
  public User getUser() {
    return user;
  }

  @Override
  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String getNumber() {
    return number;
  }

  @Override
  public void setNumber(String number) {
    this.number = number;
  }

}
