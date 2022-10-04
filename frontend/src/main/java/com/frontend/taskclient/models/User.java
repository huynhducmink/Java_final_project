package com.frontend.taskclient.models;

import java.util.ArrayList;
import java.util.List;

public class User {
  private String user_id;
  private String user_name;
  private List<Task> user_task_list = new ArrayList<Task>();

  public User() {
  }

  public User(String user_id, String user_name, List<Task> user_task_list) {
    this.user_id = user_id;
    this.user_name = user_name;
    this.user_task_list = user_task_list;
  }

  public String getUser_id() {
    return this.user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getUser_name() {
    return this.user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public List<Task> getUser_task_list() {
    return this.user_task_list;
  }

  public void setUser_task_list(List<Task> user_task_list) {
    this.user_task_list = user_task_list;
  }

  public User user_id(String user_id) {
    setUser_id(user_id);
    return this;
  }

  public User user_name(String user_name) {
    setUser_name(user_name);
    return this;
  }

  public User user_task_list(List<Task> user_task_list) {
    setUser_task_list(user_task_list);
    return this;
  }

  @Override
  public String toString() {
    return getUser_name();
  }

}
