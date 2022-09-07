package com.backend.taskserver.models;

import java.util.ArrayList;
import java.util.List;

public class User {
  private String name;
  private List<Task> task_list = new ArrayList<Task>();

  public User() {
  }

  public User(String name, List<Task> task_list) {
    this.name = name;
    this.task_list = task_list;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Task> getTask_list() {
    return this.task_list;
  }

  public void setTask_list(List<Task> task_list) {
    this.task_list = task_list;
  }

  @Override
  public String toString() {
    return "{" +
      " name='" + getName() + "'" +
      ", task_list='" + getTask_list() + "'" +
      "}";
  }

}
