package com.ltnc.quanlykho.Models;

public class Customer {
  private String name;
  private String id;
  private String phone;

  public Customer() {
  }

  public Customer(String name, String id, String phone) {
    this.name = name;
    this.id = id;
    this.phone = phone;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Customer name(String name) {
    setName(name);
    return this;
  }

  public Customer id(String id) {
    setId(id);
    return this;
  }

  public Customer phone(String phone) {
    setPhone(phone);
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " name='" + getName() + "'" +
      ", id='" + getId() + "'" +
      ", phone='" + getPhone() + "'" +
      "}";
  }

}
