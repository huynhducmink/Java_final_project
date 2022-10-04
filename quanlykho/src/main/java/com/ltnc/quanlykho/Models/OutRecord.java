package com.ltnc.quanlykho.Models;

import java.util.ArrayList;
import java.util.List;

public class OutRecord {
  private String id;
  private List<Good> good_list = new ArrayList<Good>();
  private User user;
  private String time;
  private String status;

  public OutRecord() {
  }

  public OutRecord(String id, List<Good> good_list, User user, String time, String status) {
    this.id = id;
    this.good_list = good_list;
    this.user = user;
    this.time = time;
    this.status = status;
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

  public OutRecord id(String id) {
    setId(id);
    return this;
  }

  public OutRecord good_list(List<Good> good_list) {
    setGood_list(good_list);
    return this;
  }

  public OutRecord user(User user) {
    setUser(user);
    return this;
  }

  public OutRecord time(String time) {
    setTime(time);
    return this;
  }

  public OutRecord status(String status) {
    setStatus(status);
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", good_list='" + getGood_list() + "'" +
      ", user='" + getUser() + "'" +
      ", time='" + getTime() + "'" +
      ", status='" + getStatus() + "'" +
      "}";
  }

}
