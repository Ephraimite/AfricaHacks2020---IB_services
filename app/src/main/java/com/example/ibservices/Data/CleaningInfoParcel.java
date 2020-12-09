package com.example.ibservices.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class CleaningInfoParcel implements Parcelable {
    private String name;
    private String email;
    private String phone;
    private String location;
    private String special_requirement;

    public CleaningInfoParcel() {
    }

    public CleaningInfoParcel(String name, String email, String phone, String date, String location, String special_requirement, String time) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.special_requirement = special_requirement;

    }

    protected CleaningInfoParcel(Parcel in) {
        name = in.readString();
        email = in.readString();
        phone = in.readString();
        location = in.readString();
        special_requirement = in.readString();
    }

    public static final Creator<CleaningInfoParcel> CREATOR = new Creator<CleaningInfoParcel>() {
        @Override
        public CleaningInfoParcel createFromParcel(Parcel in) {
            return new CleaningInfoParcel(in);
        }

        @Override
        public CleaningInfoParcel[] newArray(int size) {
            return new CleaningInfoParcel[size];
        }
    };

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(phone);
        parcel.writeString(location);
        parcel.writeString(special_requirement);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpecial_requirement() {
        return special_requirement;
    }

    public void setSpecial_requirement(String special_requirement) {
        this.special_requirement = special_requirement;
    }


}
