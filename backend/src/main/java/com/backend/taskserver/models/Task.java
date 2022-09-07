package com.backend.taskserver.models;

public class Task {
  private String task_name;
  private String status;

  public Task() {
  }

  public Task(String task_name, String status) {
    this.task_name = task_name;
    this.status = status;
  }

  public String getTask_name() {
    return this.task_name;
  }

  public void setTask_name(String task_name) {
    this.task_name = task_name;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "{" +
      " task_name='" + getTask_name() + "'" +
      ", status='" + getStatus() + "'" +
      "}";
  }

}