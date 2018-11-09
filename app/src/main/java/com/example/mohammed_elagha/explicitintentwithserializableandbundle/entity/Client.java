package com.example.mohammed_elagha.explicitintentwithserializableandbundle.entity;

import java.io.Serializable;

/**
 * Created by Mohammed El-Agha on 09/11/18.
 */

public class Client implements Serializable {

    private String name;
    private long phone;

    public Client(){}

    public Client(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
