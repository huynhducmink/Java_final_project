package com.ltnc.quanlykho.Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.ltnc.quanlykho.Models.Good;
import com.ltnc.quanlykho.Models.InRecord;
import com.ltnc.quanlykho.Models.User;

public class InRecordController {
  public List<InRecord> getAllInRecords() throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<QuerySnapshot> future = dbFirestore.collection("in_records").get();
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    List<InRecord> inrecord_list = new ArrayList<InRecord>();
    for (QueryDocumentSnapshot document : documents) {
      if (document.exists()) {
        Integer doc_number = document.getData().size();
        if (doc_number == 0){continue;}
        InRecord inrecord = new InRecord();
        inrecord.setId(document.getString("id"));
        inrecord.setGood(document.get("good",Good.class));
        inrecord.setUser(document.get("user",User.class));
        inrecord.setTime(document.getString("time"));
        inrecord_list.add(inrecord);
      }
    }
    return inrecord_list;
  }

  public void createNewInRecord(InRecord newinrecord) throws ExecutionException, InterruptedException {
    InRecord inrecord = newinrecord;
    String uuid_inrecord = UUID.randomUUID().toString();
    inrecord.setId(uuid_inrecord);
    inrecord.setTime(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> future = dbFirestore.collection("in_records").document(uuid_inrecord).set(inrecord);
    System.out.println("Update time : " + future.get().getUpdateTime());
    GoodController good_controller = new GoodController();
    good_controller.increaseGoodQuantityById(inrecord.getGood().getId(), inrecord.getGood().getQuantity());
  }
}
