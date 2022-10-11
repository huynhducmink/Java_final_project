package com.ltnc.quanlykho.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.ltnc.quanlykho.Models.Good;

public class GoodController {
  public List<Good> getAllGoods() throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<QuerySnapshot> future = dbFirestore.collection("goods").get();
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    List<Good> good_list = new ArrayList<Good>();
    for (QueryDocumentSnapshot document : documents) {
      if (document.exists()) {
        Integer doc_number = document.getData().size();
        if (doc_number == 0){continue;}
        Good good = new Good();
        good.setId(document.getString("id"));
        good.setShop_id(document.getString("shop_id"));
        good.setName(document.getString("name"));
        good.setQuantity(document.get("quantity",Integer.class));
        good.setPrice(document.get("price",Integer.class));
        good_list.add(good);
      }
    }
    return good_list;
  }

  public void createNewGood(Good newgood) throws ExecutionException, InterruptedException {
    Good good = newgood;
    String uuid_good = UUID.randomUUID().toString();
    good.setId(uuid_good);
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> future = dbFirestore.collection("goods").document(uuid_good).set(good);
    System.out.println("Update time : " + future.get().getUpdateTime());
  }
  
  public void increaseGoodQuantityById(String id, Integer increase_amount) throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    String good_id = id;
    if (id.equals(null)){good_id = "placeholderpath";}
    ApiFuture<DocumentSnapshot> future = dbFirestore.collection("goods").document(good_id).get();
    DocumentSnapshot document = future.get();
    if (document.exists()) {
      Integer old_quantity = document.get("quantity",Integer.class);
      Integer new_quantity = old_quantity + increase_amount;
      ApiFuture<WriteResult> future2 = dbFirestore.collection("goods").document(id).update("quantity",new_quantity);
      System.out.println("Update time : " + future2.get().getUpdateTime());
    }
  }

  public void decreaseGoodQuantityById(String id, Integer decrease_amount) throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    String good_id = id;
    if (id.equals(null)){good_id = "placeholderpath";}
    ApiFuture<DocumentSnapshot> future = dbFirestore.collection("goods").document(good_id).get();
    DocumentSnapshot document = future.get();
    if (document.exists()) {
      Integer old_quantity = document.get("quantity",Integer.class);
      Integer new_quantity = old_quantity - decrease_amount;
      ApiFuture<WriteResult> future2 = dbFirestore.collection("goods").document(id).update("quantity",new_quantity);
      System.out.println("Update time : " + future2.get().getUpdateTime());
    }
  }

  public void editGood(Good newgood) throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> future = dbFirestore.collection("goods").document(newgood.getId()).update(
      "shop_id", newgood.getShop_id(),"name",newgood.getName(),"price",newgood.getPrice());
    System.out.println("Update time : " + future.get().getUpdateTime());
  }

  public void deleteGood(Good newgood) throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> future = dbFirestore.collection("goods").document(newgood.getId()).delete();
    System.out.println("Update time : " + future.get().getUpdateTime());
  }
}
