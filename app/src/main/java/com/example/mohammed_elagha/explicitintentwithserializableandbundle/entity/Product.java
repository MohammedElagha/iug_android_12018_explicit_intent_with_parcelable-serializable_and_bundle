package com.example.mohammed_elagha.explicitintentwithserializableandbundle.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mohammed El-Agha on 09/11/18.
 */

public class Product implements Parcelable  {
    private int id;
    private String name;

    public Product() {

    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    private Product(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }
}
