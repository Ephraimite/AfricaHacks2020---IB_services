package com.example.ibservices.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ibservices.Data.ServicesListModel;
import com.example.ibservices.Repository.ServiceListRepository;

import java.util.List;

public class ServicesViewModel extends ViewModel implements ServiceListRepository.onFireStoreTaskComplete {

    private MutableLiveData<List<ServicesListModel>> servicesListModelData = new MutableLiveData<>();

    public MutableLiveData<List<ServicesListModel>> getServicesListModelData() {
        return servicesListModelData;
    }

    public void setServicesListModelData(MutableLiveData<List<ServicesListModel>> servicesListModelData) {
        this.servicesListModelData = servicesListModelData;
    }


    private ServiceListRepository mServiceListRepository = new ServiceListRepository(this);

    public ServicesViewModel(){
        mServiceListRepository.getServicesData();
    }


    @Override
    public void serviceListDataAdded(List<ServicesListModel> servicesListModelList) {
        servicesListModelData.setValue(servicesListModelList);

    }

    @Override
    public void onError(Exception e) {

    }
}
