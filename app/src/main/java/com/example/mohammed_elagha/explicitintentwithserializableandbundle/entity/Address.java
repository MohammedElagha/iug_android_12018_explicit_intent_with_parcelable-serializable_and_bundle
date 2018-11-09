package com.example.mohammed_elagha.explicitintentwithserializableandbundle.entity;

import java.io.Serializable;

/**
 * Created by Mohammed El-Agha on 09/11/18.
 */

public class Address implements Serializable {

    private String city;
    private String street;
    private int postCode;

    public Address() {
    }

    public Address(String city, String street, int postCode) {
        this.city = city;
        this.street = street;
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }
}
