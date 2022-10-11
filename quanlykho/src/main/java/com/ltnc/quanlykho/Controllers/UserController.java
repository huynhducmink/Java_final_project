package com.ltnc.quanlykho.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.ltnc.quanlykho.Models.User;

public class UserController {

  public List<User> getAllUsers() throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<QuerySnapshot> future = dbFirestore.collection("users").get();
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    List<User> user_list = new ArrayList<User>();
    for (QueryDocumentSnapshot document : documents) {
      if (document.exists()) {
        Integer doc_number = document.getData().size();
        if (doc_number == 0){continue;}
        User user = new User();
        user.setId(document.getString("id"));
        user.setName(document.getString("name"));
        user.setUser_name(document.getString("username"));
        user.setPassword(document.getString("password"));
        user_list.add(user);
      }
    }
    return user_list;
  }

  public User getUserById(String id) throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<DocumentSnapshot> future = dbFirestore.collection("users").document(id).get();
    DocumentSnapshot document = future.get();
    User user = new User();
    if (document.exists()) {
      user.setId(document.getString("id"));
      user.setName(document.getString("name"));
    }
    return user;
  }

  public Boolean login(String user_name, String password ) throws ExecutionException, InterruptedException {
    List<User> user_list = this.getAllUsers();
    Boolean allow_login = false;
    for (User user : user_list){
      if (user.getUser_name().equals(user_name) && user.getPassword().equals(password)){
        allow_login = true;
        Global.current_user = user;
      }
    }
    return allow_login;
  }
}
