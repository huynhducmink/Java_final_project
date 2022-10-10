package com.ltnc.quanlykho.Models;

import java.util.ArrayList;
import java.util.List;

public class SellRecord {
  private String id;
  private List<Good> good_list = new ArrayList<Good>();
  private User user;
  private Customer customer;
  private String time;
  private String status; // create, delivering, reject
  private String price;

  public SellRecord() {
  }

  public SellRecord(String id, List<Good> good_list, User user, Customer customer, String time, String status, String price) {
    this.id = id;
    this.good_list = good_list;
    this.user = user;
    this.customer = customer;
    this.time = time;
    this.status = status;
    this.price = price;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Good> getGood_list() {
    return this.good_list;
  }

  public void setGood_list(List<Good> good_list) {
    this.good_list = good_list;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Customer getCustomer() {
    return this.customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public String getTime() {
    return this.time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getPrice() {
    return this.price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public SellRecord id(String id) {
    setId(id);
    return this;
  }

  public SellRecord good_list(List<Good> good_list) {
    setGood_list(good_list);
    return this;
  }

  public SellRecord user(User user) {
    setUser(user);
    return this;
  }

  public SellRecord customer(Customer customer) {
    setCustomer(customer);
    return this;
  }

  public SellRecord time(String time) {
    setTime(time);
    return this;
  }

  public SellRecord status(String status) {
    setStatus(status);
    return this;
  }

  public SellRecord price(String price) {
    setPrice(price);
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", good_list='" + getGood_list() + "'" +
      ", user='" + getUser() + "'" +
      ", customer='" + getCustomer() + "'" +
      ", time='" + getTime() + "'" +
      ", status='" + getStatus() + "'" +
      ", price='" + getPrice() + "'" +
      "}";
  }

}
