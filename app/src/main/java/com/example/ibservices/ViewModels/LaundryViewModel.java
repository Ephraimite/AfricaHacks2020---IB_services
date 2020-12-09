package com.example.ibservices.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.ibservices.Data.LaundryModel;
import com.example.ibservices.Data.ServicesListModel;
import com.example.ibservices.Repository.LaundryRepository;
import com.example.ibservices.Repository.ServiceListRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaundryViewModel extends ViewModel implements LaundryRepository.laundryInterface {

    private MutableLiveData<List<LaundryModel>> laundryListData = new MutableLiveData<>();

    public MutableLiveData<List<LaundryModel>> getLaundryListModelData() {
        return laundryListData;
    }

    public void setLaundryListData(MutableLiveData<List<LaundryModel>> laundryListData) {
        this.laundryListData = laundryListData;
    }

    private LaundryRepository laundryRepository = new LaundryRepository(this);

    public LaundryViewModel(){
        laundryRepository.getLaundryData();
    }


    @Override
    public void dataAdded(List<LaundryModel> laundryModelList) {
        laundryListData.setValue(laundryModelList);
    }

    @Override
    public void onError(Exception e) {

    }




}
