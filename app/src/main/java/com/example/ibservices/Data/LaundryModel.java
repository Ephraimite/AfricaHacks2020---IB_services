package com.example.ibservices.Data;

import com.google.firebase.firestore.DocumentId;

public class LaundryModel {


    @DocumentId
    public String id;
    public String name, images,type;
    public Long price;

    public LaundryModel(String id, String name, String images, String type, Long price) {
        this.id = id;
        this.name = name;
        this.images = images;
        this.type = type;
        this.price = price;
    }



    public LaundryModel() {
    }

    public int quantitySelected = 0;

    public Long totalPrice() {
        return quantitySelected * price;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }






}
