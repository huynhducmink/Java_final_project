package com.frontend.taskclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
  public static void main(String[] args) throws IOException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/get")).build();
    try {
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
      if (response.statusCode() == 200) {
        System.out.println(response.body());
      }

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
