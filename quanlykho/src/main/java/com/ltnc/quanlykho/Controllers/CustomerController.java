package com.ltnc.quanlykho.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.ltnc.quanlykho.Models.Customer;

public class CustomerController {
  public List<Customer> getAllCustomers() throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<QuerySnapshot> future = dbFirestore.collection("customers").get();
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    List<Customer> customer_list = new ArrayList<Customer>();
    for (QueryDocumentSnapshot document : documents) {
      if (document.exists()) {
        Customer customer = new Customer();
        customer.setId(document.getString("id"));
        customer.setName(document.getString("name"));
        customer.setPhone(document.getString("phone"));
        customer.setAddress(document.getString("address"));
        customer_list.add(customer);
      }
    }
    return customer_list;
  }
  
}
