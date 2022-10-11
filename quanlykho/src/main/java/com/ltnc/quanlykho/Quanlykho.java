/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ltnc.quanlykho;

import java.util.concurrent.ExecutionException;

import com.ltnc.quanlykho.Database.DatabaseConnect;
import com.ltnc.quanlykho.View.Login;

/**
 *
 * @author huynhmink
 */
public class Quanlykho {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    DatabaseConnect db = new DatabaseConnect();
    db.connect_to_database();
    Login lg = new Login();
    lg.setVisible(true);

    // Good good = new Good("1","","apple",20,1000);
    // List<Good> good_list = new ArrayList<Good>();
    // good_list.add(good);
    // User user = new User();
    // user.setName("mink");
    // user.setId("1");
    // Customer customer = new Customer();
    // customer.setName("dung");
    // customer.setId("1");
    // SellRecord sellrecord = new SellRecord("",good_list,user,customer,"","",0);
    // SellRecordController sellrecord_controller = new SellRecordController();
    // sellrecord_controller.createNewSellRecord(sellrecord);

    // sellrecord_controller.doneSellRecord("c0c88a9c-56e1-48aa-890e-8310b91a3c66");

    return;
  }
}
