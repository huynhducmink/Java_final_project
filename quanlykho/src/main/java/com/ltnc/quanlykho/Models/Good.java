package com.ltnc.quanlykho.Models;

public class Good {
  private String name;
  private String id;

  public Good() {
  }

  public Good(String name, String id) {
    this.name = name;
    this.id = id;
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

  public Good name(String name) {
    setName(name);
    return this;
  }

  public Good id(String id) {
    setId(id);
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " name='" + getName() + "'" +
      ", id='" + getId() + "'" +
      "}";
  }

}
