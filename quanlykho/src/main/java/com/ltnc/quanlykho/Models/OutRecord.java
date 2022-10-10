package com.ltnc.quanlykho.Models;

public class OutRecord {
  private String id;
  private Good good = new Good();
  private User user = new User();;
  private String time;

  public OutRecord() {
  }

  public OutRecord(String id, Good good, User user, String time) {
    this.id = id;
    this.good = good;
    this.user = user;
    this.time = time;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Good getGood() {
    return this.good;
  }

  public void setGood(Good good) {
    this.good = good;
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

  public OutRecord id(String id) {
    setId(id);
    return this;
  }

  public OutRecord good(Good good) {
    setGood(good);
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

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", good='" + getGood() + "'" +
      ", user='" + getUser() + "'" +
      ", time='" + getTime() + "'" +
      "}";
  }

}
