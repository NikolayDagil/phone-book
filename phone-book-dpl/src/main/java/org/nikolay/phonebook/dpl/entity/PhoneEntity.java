/**
 * 
 */
package org.nikolay.phonebook.dpl.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

  @ManyToOne(targetEntity = UserEntity.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "user_fk")
  private User user;

  @Column(name = "type")
  private String type;

  @Column(name = "mobile")
  private Integer mobile;

  public PhoneEntity() {}

  public PhoneEntity(Long id, User user, String type, Integer mobile) {
    this.id = id;
    this.user = user;
    this.type = type;
    this.mobile = mobile;
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
  public Integer getMobile() {
    return mobile;
  }

  @Override
  public void setMobile(Integer mobile) {
    this.mobile = mobile;
  }

  @Override
  public String toString() {
    return "PhoneEntity [" + (id != null ? "id=" + id + ", " : "")
        + (user != null ? "user=" + user + ", " : "") + (type != null ? "type=" + type + ", " : "")
        + (mobile != null ? "mobile=" + mobile : "") + "]";
  }
}
