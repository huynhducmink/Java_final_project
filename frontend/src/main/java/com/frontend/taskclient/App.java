package com.frontend.taskclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.frontend.taskclient.models.User;
import com.google.gson.Gson;

public class App {
  public static void main(String[] args) throws IOException {

    User user = new User();
    user.setUser_name("test_user_name_01");
    Gson gson = new Gson();
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create("http://localhost:8080/create_new_user"))
      .header("Content-Type", "application/json")
      .PUT(BodyPublishers.ofString(gson.toJson(user)))
      .build();
    try {
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
      if (response.statusCode() == 200) {
        System.out.println(response.body());
      }

    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
