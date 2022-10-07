package com.ltnc.quanlykho.Models;

import java.util.ArrayList;
import java.util.List;

public class SellRecord {
  private String id;
  private List<Good> good_list = new ArrayList<Good>();
  private User user;
  private Customer customer;
  private String time_create;
  private String time_deliver;
  private String status; // create, delivering, reject
  private String price;

  public SellRecord() {
  }

  public SellRecord(String id, List<Good> good_list, User user, Customer customer, String time_create, String time_deliver, String status, String price) {
    this.id = id;
    this.good_list = good_list;
    this.user = user;
    this.customer = customer;
    this.time_create = time_create;
    this.time_deliver = time_deliver;
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

  public String getTime_create() {
    return this.time_create;
  }

  public void setTime_create(String time_create) {
    this.time_create = time_create;
  }

  public String getTime_deliver() {
    return this.time_deliver;
  }

  public void setTime_deliver(String time_deliver) {
    this.time_deliver = time_deliver;
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

  public SellRecord time_create(String time_create) {
    setTime_create(time_create);
    return this;
  }

  public SellRecord time_deliver(String time_deliver) {
    setTime_deliver(time_deliver);
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
      ", time_create='" + getTime_create() + "'" +
      ", time_deliver='" + getTime_deliver() + "'" +
      ", status='" + getStatus() + "'" +
      ", price='" + getPrice() + "'" +
      "}";
  }

}
