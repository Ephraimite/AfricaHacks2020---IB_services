package com.example.ibservices.Repository;

import com.example.ibservices.Data.LaundryModel;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;
import java.util.Objects;

public class LaundryRepository {

    private laundryInterface mLaundryInterface;

    public LaundryRepository(laundryInterface laundryInterface) {
       this.mLaundryInterface = laundryInterface;
    }
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private Query mLaundry = firebaseFirestore.collection("laundry");


    public void getLaundryData() {
       mLaundry.get().addOnCompleteListener(task -> {
        if (task.isSuccessful()){
            mLaundryInterface.dataAdded(Objects.requireNonNull(task.getResult()).toObjects(LaundryModel.class));
        }else {
            mLaundryInterface.onError(task.getException());

        }
       });
    }

    public interface laundryInterface{
        void dataAdded(List<LaundryModel> laundryModelList);
        void onError(Exception e);
    }
}
