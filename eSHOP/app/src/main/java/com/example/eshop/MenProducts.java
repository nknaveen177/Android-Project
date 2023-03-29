package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MenProducts extends AppCompatActivity {

    ImageButton BACK;

    ImageView SHIRT,T_SHIRT,T_SHIRT_TWO,T_SHIRT_THREE;
    TextView Product1,Product2,Product3,Product4,
                Price1,Price2,Price3,Price4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_products);

        BACK=findViewById(R.id.back);
        BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),ProductDetails.class);
                startActivity(intent);
            }
        });


        SHIRT=findViewById(R.id.shirt);
        Product1=findViewById(R.id.productName1);
        Price1=findViewById(R.id.productPrize1);
        SHIRT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String StoreProductName=Product1.getText().toString();
                String StorePrice=Price1.getText().toString();

                Intent intent=new Intent(getApplicationContext(),IndividualProduct.class);
                intent.putExtra("image",R.drawable.shirt);
                intent.putExtra("StoreProductName",StoreProductName);
                intent.putExtra("StorePrice",StorePrice);
                startActivity(intent);
            }
        });

        T_SHIRT=findViewById(R.id.tShirt);
        Product2=findViewById(R.id.productName2);
        Price2=findViewById(R.id.productPrize2);
        T_SHIRT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String StoreProductName=Product2.getText().toString();
                String StorePrice=Price2.getText().toString();

                Intent intent=new Intent(getApplicationContext(),IndividualProduct.class);
                intent.putExtra("image",R.drawable.tshirt);
                intent.putExtra("StoreProductName",StoreProductName);
                intent.putExtra("StorePrice",StorePrice);
                startActivity(intent);
            }
        });

        T_SHIRT_TWO=findViewById(R.id.tShirtTwo);
        Product3=findViewById(R.id.productName3);
        Price3=findViewById(R.id.productPrize3);
        T_SHIRT_TWO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String StoreProductName=Product3.getText().toString();
                String StorePrice=Price3.getText().toString();

                Intent intent=new Intent(getApplicationContext(),IndividualProduct.class);
                intent.putExtra("image",R.drawable.tshirttwo);
                intent.putExtra("StoreProductName",StoreProductName);
                intent.putExtra("StorePrice",StorePrice);
                startActivity(intent);
            }
        });

        T_SHIRT_THREE=findViewById(R.id.tShirtThree);
        Product4=findViewById(R.id.productName4);
        Price4=findViewById(R.id.productPrize4);
        T_SHIRT_THREE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String StoreProductName=Product4.getText().toString();
                String StorePrice=Price4.getText().toString();

                Intent intent=new Intent(getApplicationContext(),IndividualProduct.class);
                intent.putExtra("image",R.drawable.tshirtthree);
                intent.putExtra("StoreProductName",StoreProductName);
                intent.putExtra("StorePrice",StorePrice);
                startActivity(intent);
            }
        });






    }
}