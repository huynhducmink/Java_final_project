package com.ltnc.quanlykho.Models;

public class Good {
  private String id;
  private String name;
  private String quantity;

  public Good() {
  }

  public Good(String id, String name, String quantity) {
    this.id = id;
    this.name = name;
    this.quantity = quantity;
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

  public String getQuantity() {
    return this.quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public Good id(String id) {
    setId(id);
    return this;
  }

  public Good name(String name) {
    setName(name);
    return this;
  }

  public Good quantity(String quantity) {
    setQuantity(quantity);
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", quantity='" + getQuantity() + "'" +
      "}";
  }

}