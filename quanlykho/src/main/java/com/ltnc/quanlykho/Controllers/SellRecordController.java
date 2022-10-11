package com.ltnc.quanlykho.Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.ltnc.quanlykho.Models.Good;
import com.ltnc.quanlykho.Models.SellRecord;
import com.ltnc.quanlykho.Models.User;

public class SellRecordController {
  public List<SellRecord> getAllDoneSellRecords() throws ExecutionException, InterruptedException {
    List<SellRecord> sellrecorddone_list = new ArrayList<SellRecord>();
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<QuerySnapshot> future = dbFirestore.collection("sell_records_done").get();
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    for (QueryDocumentSnapshot document : documents) {
      if (document.exists()) {
        Integer doc_number = document.getData().size();
        if (doc_number == 0){continue;}
        SellRecord sellrecorddone = new SellRecord();
        sellrecorddone.setId(document.getString("id"));
        List<Good> good_list = new ArrayList<Good>();
        List<Map<String, Object>> good_listmap = (List<Map<String, Object>>) document.get("good_list");
        for (Map<String, Object> good_map : good_listmap) {
          Good good = new Good();
          good.setId((String) good_map.get("id"));
          good.setShop_id((String) good_map.get("shop_id"));
          good.setName((String) good_map.get("name"));
          good.setQuantity(((Long) good_map.get("quantity")).intValue());
          good.setPrice(((Long) good_map.get("price")).intValue());
          good_list.add(good);
        }
        sellrecorddone.setGood_list(good_list);
        sellrecorddone.setUser(document.get("user",User.class));
        sellrecorddone.setCustomer(document.get("customer",Customer.class));
        sellrecorddone.setTime(document.getString("time"));
        sellrecorddone.setStatus(document.getString("status"));
        sellrecorddone.setPrice(((Long)document.get("price")).intValue());
        sellrecorddone_list.add(sellrecorddone);
      }
    }
    return sellrecorddone_list;
  }

  public List<SellRecord> getAllPendingSellRecords() throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<QuerySnapshot> future = dbFirestore.collection("sell_records_pending").get();
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    List<SellRecord> sellrecordpending_list = new ArrayList<SellRecord>();
    for (QueryDocumentSnapshot document : documents) {
      if (document.exists()) {
        Integer doc_number = document.getData().size();
        if (doc_number == 0){continue;}
        SellRecord sellrecordpending = new SellRecord();
        sellrecordpending.setId(document.getString("id"));
        List<Good> good_list = new ArrayList<Good>();
        List<Map<String, Object>> good_listmap = (List<Map<String, Object>>) document.get("good_list");
        for (Map<String, Object> good_map : good_listmap) {
          Good good = new Good();
          good.setId((String) good_map.get("id"));
          good.setShop_id((String) good_map.get("shop_id"));
          good.setName((String) good_map.get("name"));
          good.setQuantity(((Long) good_map.get("quantity")).intValue());
          good.setPrice(((Long) good_map.get("price")).intValue());
          good_list.add(good);
        }
        sellrecordpending.setGood_list(good_list);
        sellrecordpending.setUser(document.get("user",User.class));
        sellrecordpending.setCustomer(document.get("customer",Customer.class));
        sellrecordpending.setTime(document.getString("time"));
        sellrecordpending.setStatus(document.getString("status"));
        sellrecordpending.setPrice(((Long)document.get("price")).intValue());
        sellrecordpending_list.add(sellrecordpending);

        Boolean customer_exist = false;
        CustomerController customer_controller = new CustomerController();
        List<Customer> customer_list = customer_controller.getAllCustomers();
        for (Customer customer : customer_list){
          if (customer.getId().equals(sellrecordpending.getCustomer().getId())){
            customer_exist = true;
          }
        }
        if (!customer_exist){
          customer_controller.createNewCustomer(sellrecordpending.getCustomer());
        }
      }
    }
    return sellrecordpending_list;
  }

  public void createNewSellRecord(SellRecord newsellrecord) throws ExecutionException, InterruptedException {
    SellRecord sellrecord = newsellrecord;
    String uuid_sellrecord = UUID.randomUUID().toString();
    sellrecord.setId(uuid_sellrecord);
    sellrecord.setStatus("pending");
    Integer price = 0;
    for (Good good : sellrecord.getGood_list()){
      price += good.getPrice()*good.getQuantity();
    }
    sellrecord.setPrice(price);
    sellrecord.setTime(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> future = dbFirestore.collection("sell_records_pending").document(uuid_sellrecord).set(sellrecord);
    System.out.println("Update time : " + future.get().getUpdateTime());
  }

  public void doneSellRecord(String id) throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<DocumentSnapshot> future = dbFirestore.collection("sell_records_pending").document(id).get();
    DocumentSnapshot document = future.get();
    if (document.exists()) {
      SellRecord sellrecord = new SellRecord();
      sellrecord.setId(document.getString("id"));

      List<Good> good_list = new ArrayList<Good>();
      List<Map<String,Object>> good_listmap = (List<Map<String, Object>>) document.get("good_list");
      for (Map<String, Object> good_map : good_listmap) {
        Good good = new Good();
        good.setId((String) good_map.get("id"));
        good.setShop_id((String) good_map.get("shop_id"));
        good.setName((String) good_map.get("name"));
        good.setQuantity(((Long) good_map.get("quantity")).intValue());
        good.setPrice(((Long) good_map.get("price")).intValue());
        good_list.add(good);
      }
      sellrecord.setGood_list(good_list);

      sellrecord.setUser(document.get("user",User.class));
      sellrecord.setCustomer(document.get("customer",Customer.class));
      sellrecord.setTime(document.getString("time"));
      sellrecord.setStatus(document.getString("status"));
      sellrecord.setPrice(((Long)document.get("price")).intValue());

      // decrease good in stock
      GoodController good_controller = new GoodController();
      for (Good good : sellrecord.getGood_list()){
        good_controller.decreaseGoodQuantityById(good.getId(), good.getQuantity());
      }

      // move sell record to done 
      sellrecord.setStatus("done");
      ApiFuture<WriteResult> future2 = dbFirestore.collection("sell_records_done").document(sellrecord.getId()).set(sellrecord);
      System.out.println("Update time : " + future2.get().getUpdateTime());

      ApiFuture<WriteResult> future3 = dbFirestore.collection("sell_records_pending").document(sellrecord.getId()).delete();
      System.out.println("Update time : " + future3.get().getUpdateTime());
    }
  }

  public void rejectSellRecord(String id) throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<DocumentSnapshot> future = dbFirestore.collection("sell_records_pending").document(id).get();
    DocumentSnapshot document = future.get();
    if (document.exists()) {
      SellRecord sellrecord = new SellRecord();
      sellrecord.setId(document.getString("id"));

      List<Good> good_list = new ArrayList<Good>();
      List<Map<String,Object>> good_listmap = (List<Map<String, Object>>) document.get("good_list");
      for (Map<String, Object> good_map : good_listmap) {
        Good good = new Good();
        good.setId((String) good_map.get("id"));
        good.setShop_id((String) good_map.get("shop_id"));
        good.setName((String) good_map.get("name"));
        good.setQuantity(((Long) good_map.get("quantity")).intValue());
        good.setPrice(((Long) good_map.get("price")).intValue());
        good_list.add(good);
      }
      sellrecord.setGood_list(good_list);

      sellrecord.setUser(document.get("user",User.class));
      sellrecord.setCustomer(document.get("customer",Customer.class));
      sellrecord.setTime(document.getString("time"));
      sellrecord.setStatus(document.getString("status"));
      sellrecord.setPrice(((Long)document.get("price")).intValue());

      // move sell record to done 
      sellrecord.setStatus("reject");
      ApiFuture<WriteResult> future2 = dbFirestore.collection("sell_records_done").document(sellrecord.getId()).set(sellrecord);
      System.out.println("Update time : " + future2.get().getUpdateTime());

      ApiFuture<WriteResult> future3 = dbFirestore.collection("sell_records_pending").document(sellrecord.getId()).delete();
      System.out.println("Update time : " + future3.get().getUpdateTime());
    }
  }
}
