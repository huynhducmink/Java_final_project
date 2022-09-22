package com.frontend.taskclient;

import java.io.IOException;
import java.util.List;

import com.frontend.taskclient.lib.HttpLib;
import com.frontend.taskclient.models.User;

public class App {
  public static void main(String[] args) throws IOException {

    //HttpLib.create_new_user("user_name_01");

    List <User> user_list = HttpLib.get_all_user();
    System.out.println(user_list);

  }
}
