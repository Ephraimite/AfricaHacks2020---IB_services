package com.example.ibservices.Data;


import com.google.firebase.firestore.DocumentId;

public class ServicesListModel {
    @DocumentId
    private String serviceId;
    private String name, image;

    public ServicesListModel(String serviceId, String name, String image) {
        this.serviceId = serviceId;
        this.name = name;
        this.image = image;
    }

    public ServicesListModel() { }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
