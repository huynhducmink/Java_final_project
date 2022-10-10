package com.ltnc.quanlykho.Controllers;

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
import com.ltnc.quanlykho.Models.OutRecord;
import com.ltnc.quanlykho.Models.User;

public class OutRecordController {
  public List<OutRecord> getAllOutRecords() throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<QuerySnapshot> future = dbFirestore.collection("out_records").get();
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    List<OutRecord> outrecord_list = new ArrayList<OutRecord>();
    for (QueryDocumentSnapshot document : documents) {
      if (document.exists()) {
        OutRecord outrecord = new OutRecord();
        outrecord.setId(document.getString("id"));
        outrecord.setGood_list((List<Good>)document.get("good_list"));
        outrecord.setUser(document.get("user",User.class));
        outrecord.setTime(document.getString("time"));
        outrecord.setStatus(document.getString("status"));
        outrecord_list.add(outrecord);
      }
    }
    return outrecord_list;
  }

  public void createNewOutRecord(OutRecord newoutrecord) throws ExecutionException, InterruptedException {
    OutRecord outrecord = newoutrecord;
    String uuid_outrecord = UUID.randomUUID().toString();
    outrecord.setId(uuid_outrecord);
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> future = dbFirestore.collection("out_records").document(uuid_outrecord).set(outrecord);
    System.out.println("Update time : " + future.get().getUpdateTime());
    for (Good good : outrecord.getGood_list()){
      GoodController good_controller = new GoodController();
      good_controller.decreaseGoodQuantityById(good.getId(), good.getQuantity());
    }
  }
}
