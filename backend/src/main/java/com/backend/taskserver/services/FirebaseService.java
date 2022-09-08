package com.backend.taskserver.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.backend.taskserver.models.Task;
import com.backend.taskserver.models.User;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {

  public List<User> getAllUsers() throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<QuerySnapshot> future = dbFirestore.collection("users").get();
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    List <User> user_list = new ArrayList<User> ();
    for (QueryDocumentSnapshot document : documents) {
      if(document.exists()) {
        User user = new User();
        user.setName(document.getString("name"));
        ApiFuture<QuerySnapshot> future2 =  document.getReference().collection("tasks").get();
        List<QueryDocumentSnapshot> documents2 = future2.get().getDocuments();
        for (QueryDocumentSnapshot document2 : documents2) {
          if(document2.exists()) {
            Task task = new Task();
            task.setTask_name(document2.getString("task_name"));
            task.setStatus(document2.getString("status"));
            user.getTask_list().add(task);
          }
        }
        user_list.add(user);
      }
    }
    return user_list;
  }

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
}
