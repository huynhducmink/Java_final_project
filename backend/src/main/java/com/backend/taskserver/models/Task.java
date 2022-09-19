package com.backend.taskserver.models;

public class Task {
  private String task_id;
  private String task_name;
  private String task_status;

  public Task() {
  }

  public Task(String task_id, String task_name, String task_status) {
    this.task_id = task_id;
    this.task_name = task_name;
    this.task_status = task_status;
  }

  public String getTask_id() {
    return this.task_id;
  }

  public void setTask_id(String task_id) {
    this.task_id = task_id;
  }

  public String getTask_name() {
    return this.task_name;
  }

  public void setTask_name(String task_name) {
    this.task_name = task_name;
  }

  public String getTask_status() {
    return this.task_status;
  }

  public void setTask_status(String task_status) {
    this.task_status = task_status;
  }

  public Task task_id(String task_id) {
    setTask_id(task_id);
    return this;
  }

  public Task task_name(String task_name) {
    setTask_name(task_name);
    return this;
  }

  public Task task_status(String task_status) {
    setTask_status(task_status);
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " task_id='" + getTask_id() + "'" +
      ", task_name='" + getTask_name() + "'" +
      ", task_status='" + getTask_status() + "'" +
      "}";
  }

}