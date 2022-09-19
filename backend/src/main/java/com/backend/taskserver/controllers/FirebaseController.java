package com.backend.taskserver.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.taskserver.models.Task;
import com.backend.taskserver.models.User;
import com.backend.taskserver.services.FirebaseService;

@RestController
public class FirebaseController {

  public FirebaseService firebaseService;

  @Autowired
  public FirebaseController(FirebaseService firebaseService){
    this.firebaseService = firebaseService;
  }

  @GetMapping(path="/get_all_users")
  public List<User> getAllUsers() throws InterruptedException, ExecutionException {
    return firebaseService.getAllUsers();
  }

  @GetMapping(path="/get_user_task/{user_id}")
  public User getUser(@PathVariable String user_id) throws InterruptedException, ExecutionException {
    return firebaseService.getUser(user_id);
  }

  @GetMapping(path="/get_user_task/{user_id}/{task_id}")
  public Task getTask(@PathVariable String user_id, @PathVariable String task_id) throws InterruptedException, ExecutionException {
    return firebaseService.getTask(user_id,task_id);
  }

  @PutMapping(path="/create_new_user")
  public String createUser( @RequestParam String name) throws InterruptedException, ExecutionException {
    return firebaseService.createUser(name);
  }
}
