package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class OtherProducts extends AppCompatActivity {

    ImageButton BACK;

    ImageView SHOE,CYCLE,MONITOR,BAT,BAG;
    TextView Product7,Product8,Product9,Product10,Product11,
            Price7,Price8,Price9,Price10,Price11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_products);

        BACK=findViewById(R.id.back);
        BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),ProductDetails.class);
                startActivity(intent);
            }
        });

        SHOE=findViewById(R.id.shoe);
        Product7=findViewById(R.id.productName7);
        Price7=findViewById(R.id.productPrize7);
        SHOE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String StoreProductName=Product7.getText().toString();
                String StorePrice=Price7.getText().toString();

                Intent intent=new Intent(getApplicationContext(),IndividualProduct.class);
                intent.putExtra("image",R.drawable.shoe);
                intent.putExtra("StoreProductName",StoreProductName);
                intent.putExtra("StorePrice",StorePrice);
                startActivity(intent);
            }
        });

        CYCLE=findViewById(R.id.cycle);
        Product8=findViewById(R.id.productName8);
        Price8=findViewById(R.id.productPrize8);
        CYCLE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String StoreProductName=Product8.getText().toString();
                String StorePrice=Price8.getText().toString();

                Intent intent=new Intent(getApplicationContext(),IndividualProduct.class);
                intent.putExtra("image",R.drawable.cycle);
                intent.putExtra("StoreProductName",StoreProductName);
                intent.putExtra("StorePrice",StorePrice);
                startActivity(intent);
            }
        });

        MONITOR=findViewById(R.id.monitor);
        Product9=findViewById(R.id.productName9);
        Price9=findViewById(R.id.productPrize9);
        MONITOR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String StoreProductName=Product9.getText().toString();
                String StorePrice=Price9.getText().toString();

                Intent intent=new Intent(getApplicationContext(),IndividualProduct.class);
                intent.putExtra("image",R.drawable.moniter);
                intent.putExtra("StoreProductName",StoreProductName);
                intent.putExtra("StorePrice",StorePrice);
                startActivity(intent);
            }
        });

        BAT=findViewById(R.id.cricket);
        Product10=findViewById(R.id.productName10);
        Price10=findViewById(R.id.productPrize10);
        BAT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String StoreProductName=Product10.getText().toString();
                String StorePrice=Price10.getText().toString();

                Intent intent=new Intent(getApplicationContext(),IndividualProduct.class);
                intent.putExtra("image",R.drawable.cricketbat);
                intent.putExtra("StoreProductName",StoreProductName);
                intent.putExtra("StorePrice",StorePrice);
                startActivity(intent);
            }
        });

        BAG=findViewById(R.id.bag);
        Product11=findViewById(R.id.productName11);
        Price11=findViewById(R.id.productPrize11);
        BAG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String StoreProductName=Product11.getText().toString();
                String StorePrice=Price11.getText().toString();

                Intent intent=new Intent(getApplicationContext(),IndividualProduct.class);
                intent.putExtra("image",R.drawable.bag);
                intent.putExtra("StoreProductName",StoreProductName);
                intent.putExtra("StorePrice",StorePrice);
                startActivity(intent);
            }
        });


    }
}