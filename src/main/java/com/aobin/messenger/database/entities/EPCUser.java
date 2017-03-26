package com.aobin.messenger.database.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "auth_user")
public class EPCUser implements Serializable
{

  private static final long serialVersionUID = -5708626959269671796L;

  @Id
  @GeneratedValue
  @Column(name = "id", unique = true, nullable = false)
  private Long id;
  @Column(name = "first_name", nullable = false)
  private String firstName;
  @Column(name = "last_name", nullable = false)
  private String lastName;
  @Column(name = "username", nullable = false)
  private String username;
  @Column(name = "email", nullable = false)
  private String email;
  @Column(name = "is_active", nullable = false)
  private Boolean isActive;
  @Column(name = "last_login", nullable = false)
  private Date lastLogin;
  @Column(name = "date_joined", nullable = false)
  private Date dateJoined;
  
  public EPCUser()
  {
    this.firstName = "";
    this.lastName = "";
    this.isActive = true;
    this.lastLogin = new Date();
    this.dateJoined = new Date();
  }

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public Boolean getIsActive()
  {
    return isActive;
  }

  public void setIsActive(Boolean isActive)
  {
    this.isActive = isActive;
  }

  public Date getLastLogin()
  {
    return lastLogin;
  }

  public void setLastLogin(Date lastLogin)
  {
    this.lastLogin = lastLogin;
  }

  public Date getDateJoined()
  {
    return dateJoined;
  }

  public void setDateJoined(Date dateJoined)
  {
    this.dateJoined = dateJoined;
  }

}
