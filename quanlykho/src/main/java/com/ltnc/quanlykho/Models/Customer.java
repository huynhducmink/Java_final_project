package com.ltnc.quanlykho.Models;

public class Customer {
  private String id;
  private String name;
  private String phone;
  private String address;

  public Customer() {
  }

  public Customer(String id, String name, String phone, String address) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.address = address;
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

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Customer id(String id) {
    setId(id);
    return this;
  }

  public Customer name(String name) {
    setName(name);
    return this;
  }

  public Customer phone(String phone) {
    setPhone(phone);
    return this;
  }

  public Customer address(String address) {
    setAddress(address);
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", phone='" + getPhone() + "'" +
      ", address='" + getAddress() + "'" +
      "}";
  }

}