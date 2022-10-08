/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ltnc.quanlykho;

import java.util.concurrent.ExecutionException;

import com.ltnc.quanlykho.Controllers.CustomerController;
import com.ltnc.quanlykho.Database.DatabaseConnect;
import com.ltnc.quanlykho.Models.Customer;

/**
 *
 * @author huynhmink
 */
public class Quanlykho {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // Leave this in main to create connect to the database
    DatabaseConnect db = new DatabaseConnect();
    db.connect_to_database();

    // Login lg = new Login();
    // lg.setVisible(true);

    CustomerController customer_controller = new CustomerController();
    // Customer customer = new
    // Customer("178dc6f9-1f8d-4021-a35f-39e221c94e28","customer_new_name","0","0");
    // customer_controller.editCustomerById(customer);

    // // Add new customer
    Customer newcustomer = new Customer("", "customer_mink_2", "012345678", "hust");
    customer_controller.createNewCustomer(newcustomer);

    // Get customer list
    // List<Customer> customer_list = customer_controller.getAllCustomers();
    // for (Customer customer : customer_list) {
    //   System.out.println(customer.toString());
    // }

    return;
  }
}
