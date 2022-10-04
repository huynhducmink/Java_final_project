package com.frontend.taskclient.lib.httplib;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.frontend.taskclient.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class HttpLib {

  public static void create_new_user(String user_name_){
    User user = new User();
    user.setUser_name(user_name_);
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
        System.out.println("Create user successfully");
      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static List<User> get_all_user(){
    Gson gson = new Gson();
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:8080/get_all_users"))
        .header("Content-Type", "application/json")
        .GET()
        .build();
    try {
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
      if (response.statusCode() == 200) {
        Type collectionType = new TypeToken<Collection<User>>(){}.getType();
        Collection<User> user_col = gson.fromJson(response.body(), collectionType);
        List<User> user_list = new ArrayList<User>(user_col);
        System.out.println("Retreive data successfully!");
        return user_list;
      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return null;
  }
}
