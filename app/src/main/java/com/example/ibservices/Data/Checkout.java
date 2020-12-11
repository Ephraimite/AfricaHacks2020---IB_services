package com.example.ibservices.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public  class Checkout implements Parcelable {
        public List<LaundryModel> items;

        public Checkout(List<LaundryModel> items) {
            this.items = items;
        }

    protected Checkout(Parcel in) {
    }

    public static final Creator<Checkout> CREATOR = new Creator<Checkout>() {
        @Override
        public Checkout createFromParcel(Parcel in) {
            return new Checkout(in);
        }

        @Override
        public Checkout[] newArray(int size) {
            return new Checkout[size];
        }
    };

    public long totalPrice() {
            long total = 0L;
            for (LaundryModel item : items) {
                total += item.totalPrice();
            }
            return total;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}

