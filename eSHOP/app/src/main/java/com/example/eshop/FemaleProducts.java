package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class FemaleProducts extends AppCompatActivity {

    ImageButton BACK;


    ImageView SAREE,CHURIDAR;
    TextView Product5,Product6,Price5,Price6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female_products);

        BACK=findViewById(R.id.back);
        BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),ProductDetails.class);
                startActivity(intent);
            }
        });

        SAREE=findViewById(R.id.saree);
        Product5=findViewById(R.id.productName5);
        Price5=findViewById(R.id.productPrize5);
        SAREE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String StoreProductName=Product5.getText().toString();
                String StorePrice=Price5.getText().toString();

                Intent intent=new Intent(getApplicationContext(),IndividualProduct.class);
                intent.putExtra("image",R.drawable.saree);
                intent.putExtra("StoreProductName",StoreProductName);
                intent.putExtra("StorePrice",StorePrice);
                startActivity(intent);
            }
        });

        CHURIDAR=findViewById(R.id.womenWear);
        Product6=findViewById(R.id.productName6);
        Price6=findViewById(R.id.productPrize6);
        CHURIDAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String StoreProductName=Product6.getText().toString();
                String StorePrice=Price6.getText().toString();

                Intent intent=new Intent(getApplicationContext(),IndividualProduct.class);
                intent.putExtra("image",R.drawable.womenswear);
                intent.putExtra("StoreProductName",StoreProductName);
                intent.putExtra("StorePrice",StorePrice);
                startActivity(intent);
            }
        });


    }
}