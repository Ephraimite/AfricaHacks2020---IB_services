package com.example.ibservices.Repository;

import androidx.annotation.NonNull;


import com.example.ibservices.Data.ServicesListModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;
import java.util.Objects;

public class ServiceListRepository {
    private onFireStoreTaskComplete mOnFireStoreTaskComplete;

    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private CollectionReference mServices = firebaseFirestore.collection("our services");

    public ServiceListRepository(onFireStoreTaskComplete onFireStoreTaskComplete){
        this.mOnFireStoreTaskComplete = onFireStoreTaskComplete;
    }


    public void getServicesData() {
        mServices.get().addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                mOnFireStoreTaskComplete.serviceListDataAdded(Objects.requireNonNull(task.getResult()).toObjects(ServicesListModel.class));

            } else {
                mOnFireStoreTaskComplete.onError(task.getException());
            }
        });
    }


    public interface onFireStoreTaskComplete{
        void serviceListDataAdded(List<ServicesListModel> servicesListModelList);
        void onError(Exception e);
    }

}
