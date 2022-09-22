package com.backend.taskserver.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.backend.taskserver.models.Task;
import com.backend.taskserver.models.User;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.Gson;

@Service
public class FirebaseService {

  @PostConstruct
  public void initialization() throws IOException{

    File file = ResourceUtils.getFile("classpath:serviceAccountKey.json");
    FileInputStream serviceAccount = new FileInputStream(file);

    FirebaseOptions options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .setDatabaseUrl("https://testing-project-01.firebaseio.com/")
        .build();

    FirebaseApp.initializeApp(options);
    System.out.println("Initialized connection with Firebase DB");
  }

  public String getAllUsers() throws ExecutionException, InterruptedException {
    Gson gson = new Gson();
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<QuerySnapshot> future = dbFirestore.collection("users").get();
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    List<User> user_list = new ArrayList<User>();
    for (QueryDocumentSnapshot document : documents) {
      if (document.exists()) {
        User user = new User();
        user.setUser_id(document.getString("user_id"));
        user.setUser_name(document.getString("user_name"));
        ApiFuture<QuerySnapshot> future2 = document.getReference().collection("tasks").get();
        List<QueryDocumentSnapshot> documents2 = future2.get().getDocuments();
        for (QueryDocumentSnapshot document2 : documents2) {
          if (document2.exists()) {
            Task task = new Task();
            task.setTask_id(document2.getString("task_id"));
            task.setTask_name(document2.getString("task_name"));
            task.setTask_status(document2.getString("task_status"));
            user.getUser_task_list().add(task);
          }
        }
        user_list.add(user);
      }
    }
    return gson.toJson(user_list);
  }

  public User getUser(String user_id_) throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<DocumentSnapshot> future = dbFirestore.collection("users").document(user_id_).get();
    DocumentSnapshot document = future.get();
    if (document.exists()) {
      User user = new User();
      user.setUser_id(document.getString("user_id"));
      user.setUser_name(document.getString("user_name"));
      ApiFuture<QuerySnapshot> future2 = document.getReference().collection("tasks").get();
      List<QueryDocumentSnapshot> documents2 = future2.get().getDocuments();
      for (QueryDocumentSnapshot document2 : documents2) {
        if (document2.exists()) {
          Task task = new Task();
          task.setTask_id(document2.getString("task_id"));
          task.setTask_name(document2.getString("task_name"));
          task.setTask_status(document2.getString("task_status"));
          user.getUser_task_list().add(task);
        }
      }
      return user;
    }
    return null;
  }

  public Task getTask(String user_id_, String task_id_) throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<DocumentSnapshot> future = dbFirestore.collection("users").document(user_id_).collection("tasks").document(task_id_).get();
    DocumentSnapshot document = future.get();
    if (document.exists()) {
      Task task = new Task();
      task.setTask_id(document.getString("task_id"));
      task.setTask_name(document.getString("task_name"));
      task.setTask_status(document.getString("task_status"));
      return task;
    }
    return null;
  }

  public String createUser(User user) throws ExecutionException, InterruptedException {
    User newUser = new User();
    String uuid_user = UUID.randomUUID().toString();
    newUser.setUser_name(user.getUser_name());
    newUser.setUser_id(uuid_user);

    Map<String,String> userdoc = new HashMap<>();
    userdoc.put("user_id",newUser.getUser_id());
    userdoc.put("user_name",newUser.getUser_name());

    String uuid_task = UUID.randomUUID().toString();
    Task newTask = new Task();
    newTask.setTask_id(uuid_task);
    newTask.setTask_name("place_holder");

    Firestore dbFirestore = FirestoreClient.getFirestore();
    // ApiFuture<WriteResult> future = 
    dbFirestore.collection("users").document(uuid_user).set(userdoc);
    dbFirestore.collection("users").document(uuid_user).collection("tasks").document(uuid_task).set(newTask);
    return null;
  }

  public String updateOrCreateTask(String user_id_, String task_id_, String task_name_, String task_status_) throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<DocumentSnapshot> future = dbFirestore.collection("users").document(user_id_).get();
    DocumentSnapshot document = future.get();
    if (!document.exists()){
      return "User not exist";
    }
    Task newTask = new Task();
    newTask.setTask_id(task_id_);
    newTask.setTask_name(task_name_);
    newTask.setTask_status(task_status_);
    dbFirestore.collection("users").document(user_id_).collection("tasks").document(task_id_).set(newTask);
    return "Create/update task successfully";
  }

}
