/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ltnc.quanlykho;

import java.util.concurrent.ExecutionException;

import com.ltnc.quanlykho.Controllers.SellRecordController;
import com.ltnc.quanlykho.Database.DatabaseConnect;

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

    // CustomerController customer_controller = new CustomerController();

    // Edit customer by Id
    // Customer customer = new
    // Customer("178dc6f9-1f8d-4021-a35f-39e221c94e28","customer_new_name","0","0");
    // customer_controller.editCustomerById(customer);

    // Add new customer
    // Customer newcustomer = new Customer("", "customer_mink_2", "012345678", "hust");
    // customer_controller.createNewCustomer(newcustomer);

    // Get customer list
    // List<Customer> customer_list = customer_controller.getAllCustomers();
    // for (Customer customer : customer_list) {
    //   System.out.println(customer.toString());
    // }

    // InRecordController inrecord_controller = new InRecordController();

    // Good good = new Good("8bbf6a22-a817-41ea-b28c-7e3a145d4f0d","apple",100);
    // List <Good> good_list = new ArrayList<Good> ();
    // good_list.add(good);
    // User user = new User("1", "minh", "mink", "1");
    // InRecord inrecord = new InRecord("",good_list,user,"1","pending");
    // inrecord_controller.createNewInRecord(inrecord);
    // System.out.println(inrecord_controller.getAllInRecords().toString());

    // OutRecordController outrecord_controller = new OutRecordController();

    // Good good = new Good("8bbf6a22-a817-41ea-b28c-7e3a145d4f0d","apple",100);
    // List <Good> good_list = new ArrayList<Good> ();
    // good_list.add(good);
    // User user = new User("1", "minh", "mink", "1");
    // OutRecord outrecord = new OutRecord("",good_list,user,"1","pending");
    // outrecord_controller.createNewOutRecord(outrecord);
    // System.out.println(outrecord_controller.getAllOutRecords().toString());

    // GoodController good_controller = new GoodController();

    // Good good = new Good("1","apple",1);
    // good_controller.createNewGood(good);
    // good_controller.increaseGoodQuantityById("8bbf6a22-a817-41ea-b28c-7e3a145d4f0d", 10);

    SellRecordController sellrecord_controller = new SellRecordController();
    // Good good = new Good("8bbf6a22-a817-41ea-b28c-7e3a145d4f0d","apple",1);
    // List <Good> good_list = new ArrayList<Good> ();
    // good_list.add(good);
    // User user = new User("1", "minh", "mink", "1");
    // Customer customer = new Customer("", "customer_mink_2", "012345678", "hust");
    // SellRecord sellrecord = new SellRecord("",good_list,user,customer,"1","","1");
    // sellrecord_controller.createNewSellRecord(sellrecord);
    sellrecord_controller.doneSellRecord("def68b77-4209-4d45-a6a4-a66aedc6c560");

    return;
  }
}
