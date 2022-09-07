package com.backend.taskserver.models;

import java.time.LocalDate;

public class Student {

  private String name;
  private String email;
  private Long age;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getAge() {
    return this.age;
  }

  public void setAge(Long age) {
    this.age = age;
  }

  public Student() {
  }

  public Student(String name, String email, LocalDate dob, Long age) {
    this.name = name;
    this.email = email;
    this.age = age;
  }

  @Override
  public String toString() {
    return "{" +
        ", name='" + getName() + "'" +
        ", email='" + getEmail() + "'" +
        ", age='" + getAge() + "'" +
        "}";
  }

}
