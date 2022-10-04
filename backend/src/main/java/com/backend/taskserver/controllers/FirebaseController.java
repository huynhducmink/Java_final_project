package com.backend.taskserver.controllers;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

  @RequestMapping(path="/get_all_users", method = RequestMethod.GET, produces = "application/json")
  public String getAllUsers() throws InterruptedException, ExecutionException {
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

  @RequestMapping(path="/create_new_user", method = RequestMethod.PUT, consumes = "application/json")
  public String createUser( @RequestBody User user) throws InterruptedException, ExecutionException {
    return firebaseService.createUser(user);
  }

  @PutMapping(path="/update_or_create_task")
  public String updateOrCreateTask( @RequestParam String user_id, @RequestParam String task_id, @RequestParam String task_name, @RequestParam String task_status ) throws InterruptedException, ExecutionException {
    return firebaseService.updateOrCreateTask(user_id,task_id,task_name,task_status);
  }
}
