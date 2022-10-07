package com.ltnc.quanlykho.Models;

public class User {
  private String id;
  private String name;
  private String user_name;
  private String password;

  public User() {
  }

  public User(String id, String name, String user_name, String password) {
    this.id = id;
    this.name = name;
    this.user_name = user_name;
    this.password = password;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUser_name() {
    return this.user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User id(String id) {
    setId(id);
    return this;
  }

  public User name(String name) {
    setName(name);
    return this;
  }

  public User user_name(String user_name) {
    setUser_name(user_name);
    return this;
  }

  public User password(String password) {
    setPassword(password);
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", user_name='" + getUser_name() + "'" +
      ", password='" + getPassword() + "'" +
      "}";
  }

}
