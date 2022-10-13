package com.ltnc.quanlykho.Database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class DatabaseConnect {
  public void connect_to_database() {
    try {
      InputStream serviceAccount = getClass().getResourceAsStream("/serviceAccountKey.json");
      FirebaseOptions options = FirebaseOptions.builder()
          .setCredentials(GoogleCredentials.fromStream(serviceAccount))
          .setDatabaseUrl("https://testing-project-01.firebaseio.com/")
          .build();
      FirebaseApp.initializeApp(options);
      System.out.println("Initialized connection with Firebase DB");
    } catch (FileNotFoundException e) {
      System.out.println("ERROR: invalid service account credentials.");
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
