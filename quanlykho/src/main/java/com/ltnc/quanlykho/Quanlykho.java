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
    return;
  }
}
