package com.ltnc.quanlykho.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
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

  public Customer getCustomerById(String id) throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<DocumentSnapshot> future = dbFirestore.collection("customers").document(id).get();
    DocumentSnapshot document = future.get();
    Customer customer = new Customer();
    if (document.exists()) {
      customer.setId(document.getString("id"));
      customer.setName(document.getString("name"));
      customer.setPhone(document.getString("phone"));
      customer.setAddress(document.getString("address"));
    }
    return customer;
  }

  public void createNewCustomer(Customer newcustomer) throws ExecutionException, InterruptedException {
    Customer customer = newcustomer;
    String uuid_customer = UUID.randomUUID().toString();
    customer.setId(uuid_customer);
    System.out.println(uuid_customer);

    Map<String,String> customerdoc = new HashMap<>();
    customerdoc.put("id",customer.getId());
    customerdoc.put("name",customer.getName());
    customerdoc.put("phone",customer.getPhone());
    customerdoc.put("address",customer.getAddress());

    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> future = dbFirestore.collection("customers").document(uuid_customer).set(customerdoc);
    System.out.println("Update time : " + future.get().getUpdateTime());
  }

  public void editCustomer(Customer newcustomer) throws ExecutionException, InterruptedException {
    Map<String,String> customerdoc = new HashMap<>();
    customerdoc.put("id",newcustomer.getId());
    customerdoc.put("name",newcustomer.getName());
    customerdoc.put("phone",newcustomer.getPhone());
    customerdoc.put("address",newcustomer.getAddress());

    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> future = dbFirestore.collection("customers").document(newcustomer.getId()).set(customerdoc);
    System.out.println("Update time : " + future.get().getUpdateTime());
  }

  public void deleteCustomer(Customer newcustomer) throws ExecutionException, InterruptedException {
    Map<String,String> customerdoc = new HashMap<>();
    customerdoc.put("id",newcustomer.getId());
    customerdoc.put("name",newcustomer.getName());
    customerdoc.put("phone",newcustomer.getPhone());
    customerdoc.put("address",newcustomer.getAddress());

    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> future = dbFirestore.collection("customers").document(newcustomer.getId()).delete();
    System.out.println("Update time : " + future.get().getUpdateTime());
  }
}
