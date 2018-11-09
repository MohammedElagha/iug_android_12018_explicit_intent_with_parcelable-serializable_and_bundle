package com.example.mohammed_elagha.explicitintentwithserializableandbundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohammed_elagha.explicitintentwithserializableandbundle.entity.Address;
import com.example.mohammed_elagha.explicitintentwithserializableandbundle.entity.Client;
import com.example.mohammed_elagha.explicitintentwithserializableandbundle.entity.Product;

import java.util.ArrayList;

/**
 * Created by Mohammed El-Agha on 09/11/18.
 */

public class SecondActivity extends AppCompatActivity {

    Spinner productsSpinner;
    TextView nameTextView, phoneTextView, cityTextView, streetTextView, postCodeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        productsSpinner = findViewById(R.id.products_spinner);

        nameTextView = findViewById(R.id.name_tv);
        phoneTextView = findViewById(R.id.phone_tv);
        cityTextView = findViewById(R.id.city_tv);
        streetTextView = findViewById(R.id.street_tv);
        postCodeTextView = findViewById(R.id.code_tv);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        Product test = bundle.getParcelable("test");

        fillSpinner(bundle);
        setTextViewsTexts(bundle);
    }


    private void fillSpinner(Bundle bundle) {
        ArrayList<Product> products = bundle.getParcelableArrayList("products");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(SecondActivity.this, android.R.layout.simple_spinner_item);
        arrayAdapter.add("Products");
        for(Product product : products) {
            arrayAdapter.add(product.getName());
        }
        productsSpinner.setAdapter(arrayAdapter);
    }


    private void setTextViewsTexts(Bundle bundle) {
        Client client = (Client) bundle.getSerializable("client");
        Address address = (Address) bundle.getSerializable("address");

        nameTextView.setText(client.getName());
        phoneTextView.setText(client.getPhone() + "");

        cityTextView.setText(address.getCity());
        streetTextView.setText(address.getStreet());
        postCodeTextView.setText(address.getPostCode() + "");
    }
}
