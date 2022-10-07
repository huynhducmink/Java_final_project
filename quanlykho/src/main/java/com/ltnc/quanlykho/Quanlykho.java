/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ltnc.quanlykho;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.ltnc.quanlykho.Controllers.CustomerController;
import com.ltnc.quanlykho.Controllers.UserController;
import com.ltnc.quanlykho.Database.DatabaseConnect;
import com.ltnc.quanlykho.Models.Customer;
import com.ltnc.quanlykho.Models.User;

/**
 *
 * @author huynhmink
 */
public class Quanlykho {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
      // Leave this in main to create connect to the database
      DatabaseConnect db = new DatabaseConnect();
      db.connect_to_database();

      CustomerController customer_controller = new CustomerController();
      // Add new customer
      Customer newcustomer = new Customer("","customer_mink","012345678","hust");
      customer_controller.createNewCustomer(newcustomer);


      // Get customer list
      List<Customer> customer_list = customer_controller.getAllCustomers();
      for (Customer customer : customer_list) {
        System.out.println(customer.toString());
      }

      // Get user list
      UserController user_controller = new UserController();
      List<User> user_list = user_controller.getAllUsers();
      for (User user : user_list) {
        System.out.println(user.toString());
      }

      // Login
      Boolean allow_login = user_controller.login("huynhmink","12345678");
      if (allow_login){
        System.out.println("Login successfully!");
      }
      else {
        System.out.println("Incorrect username or password");
      }
    }
}
