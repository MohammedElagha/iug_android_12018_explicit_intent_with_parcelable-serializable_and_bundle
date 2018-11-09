package com.example.mohammed_elagha.explicitintentwithserializableandbundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.mohammed_elagha.explicitintentwithserializableandbundle.entity.Address;
import com.example.mohammed_elagha.explicitintentwithserializableandbundle.entity.Client;
import com.example.mohammed_elagha.explicitintentwithserializableandbundle.entity.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CheckBox shoesCheckBox, tshirtCheckBox, bagCheckBox, trousersCheckBox;
    EditText nameEditText, phoneEditText, cityEditText, streetEditText, postCodeEditText;
    Button nextButton;
    ArrayList<Product> selectProducts;
    Client client;
    Address address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shoesCheckBox = findViewById(R.id.shoes_checkBox);
        tshirtCheckBox = findViewById(R.id.tshirt_checkBox);
        bagCheckBox = findViewById(R.id.bag_checkBox);
        trousersCheckBox = findViewById(R.id.trousers_checkBox);

        nameEditText = findViewById(R.id.name_edittext);
        phoneEditText = findViewById(R.id.phone_edittext);
        cityEditText = findViewById(R.id.city_edittext);
        streetEditText = findViewById(R.id.street_edittext);
        postCodeEditText = findViewById(R.id.code_edittext);

        nextButton = findViewById(R.id.next_btn);

        selectProducts = new ArrayList();

        setShoesCheckBoxAction();
        setTshirtCheckBoxAction();
        setBagCheckBoxAction();
        setTrousersCheckBoxAction();
        setNextButtonAction();
    }


    private void setShoesCheckBoxAction() {
        shoesCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Product shoes = new Product();
                shoes.setId(1);
                shoes.setName(shoesCheckBox.getText().toString());

                selectProducts.add(shoes);
            }
        });
    }


    private void setTshirtCheckBoxAction() {
        tshirtCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Product tshirt = new Product();
                tshirt.setId(2);
                tshirt.setName(tshirtCheckBox.getText().toString());

                selectProducts.add(tshirt);
            }
        });
    }


    private void setBagCheckBoxAction() {
        bagCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Product bag = new Product();
                bag.setId(3);
                bag.setName(bagCheckBox.getText().toString());

                selectProducts.add(bag);
            }
        });
    }


    private void setTrousersCheckBoxAction() {
        trousersCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Product trousers = new Product();
                trousers.setId(4);
                trousers.setName(trousersCheckBox.getText().toString());

                selectProducts.add(trousers);
            }
        });
    }


    private void setNextButtonAction() {
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nameEditText.getText().toString().trim().isEmpty()
                        && !phoneEditText.getText().toString().trim().isEmpty()
                        && !cityEditText.getText().toString().trim().isEmpty()
                        && !streetEditText.getText().toString().trim().isEmpty()
                        && !postCodeEditText.getText().toString().trim().isEmpty()
                        && !selectProducts.isEmpty()) {

                    Client client = new Client();
                    client.setName(nameEditText.getText().toString());
                    client.setPhone(Long.parseLong(phoneEditText.getText().toString()));

                    Address address = new Address();
                    address.setCity(cityEditText.getText().toString());
                    address.setStreet(streetEditText.getText().toString());
                    address.setPostCode(Integer.parseInt(postCodeEditText.getText().toString()));

                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("products", selectProducts);
                    bundle.putSerializable("client", client);
                    bundle.putSerializable("address", address);

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("data", bundle);
                    startActivity(intent);
                }
            }
        });
    }
}
