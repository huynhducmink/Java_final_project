package com.backend.taskserver.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.taskserver.models.User;
import com.backend.taskserver.services.FirebaseService;

@RestController
public class FirebaseController {

  public FirebaseService firebaseService;

  @Autowired
  public FirebaseController(FirebaseService firebaseService){
    this.firebaseService = firebaseService;
  }

  @GetMapping(path="/get")
  public List<User> getAllUsers() throws InterruptedException, ExecutionException {
    return firebaseService.getAllUsers();
  }

}
