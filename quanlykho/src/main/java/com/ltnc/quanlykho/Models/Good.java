package com.ltnc.quanlykho.Models;

public class Good {
  private String id;
  private String shop_id;
  private String name;
  private Integer quantity;
  private Integer price;

  public Good() {
  }

  public Good(String id, String shop_id, String name, Integer quantity, Integer price) {
    this.id = id;
    this.shop_id = shop_id;
    this.name = name;
    this.quantity = quantity;
    this.price = price;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getShop_id() {
    return this.shop_id;
  }

  public void setShop_id(String shop_id) {
    this.shop_id = shop_id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getPrice() {
    return this.price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Good id(String id) {
    setId(id);
    return this;
  }

  public Good shop_id(String shop_id) {
    setShop_id(shop_id);
    return this;
  }

  public Good name(String name) {
    setName(name);
    return this;
  }

  public Good quantity(Integer quantity) {
    setQuantity(quantity);
    return this;
  }

  public Good price(Integer price) {
    setPrice(price);
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", shop_id='" + getShop_id() + "'" +
      ", name='" + getName() + "'" +
      ", quantity='" + getQuantity() + "'" +
      ", price='" + getPrice() + "'" +
      "}";
  }

}
