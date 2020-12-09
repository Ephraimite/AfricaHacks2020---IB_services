package com.example.ibservices.Data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.firestore.DocumentId;

public class LaundryModel {


    @DocumentId
    public String id;
    public String name, images,type;
    public int price;

    public LaundryModel(String id, String name, String images, String type, int price) {
        this.id = id;
        this.name = name;
        this.images = images;
        this.type = type;
        this.price = price;
    }

    public LaundryModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }






}
