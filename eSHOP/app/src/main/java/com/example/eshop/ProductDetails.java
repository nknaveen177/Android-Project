package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDetails extends AppCompatActivity {

    Spinner CategorySpinner;
    String CategoryValue[]={"Select...","Men","Female","Other Products"};
    ArrayAdapter<String> arrayAdapter;

    ImageView SHIRT,T_SHIRT,T_SHIRT_TWO,T_SHIRT_THREE,SAREE,CHURIDAR,SHOE,CYCLE,MONITOR,BAT,BAG;
    TextView Product1,Price1,Product2,Price2,Product3,Price3,
            Product4,Price4,Product5,Price5,Product6,Price6,
            Product7,Price7,Product8,Price8,Product9,Price9,
            Product10,Price10,Product11,Price11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);


        //choose category of product

        CategorySpinner=findViewById(R.id.categorySpinner);
        arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,CategoryValue);
        CategorySpinner.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();

        CategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){

                    case 1:
                        Intent intent=new Intent(getApplicationContext(),MenProducts.class);
                        startActivity(intent);
                        break;

                    case 2:
                        Intent intent1=new Intent(getApplicationContext(),FemaleProducts.class);
                        startActivity(intent1);
                        break;

                    case 3:
                        Intent intent2=new Intent(getApplicationContext(),OtherProducts.class);
                        startActivity(intent2);
                        break;

                    default:
                       // Toast.makeText(ProductDetails.this, "Kindly select the categories", Toast.LENGTH_SHORT).show();

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // individual Product details

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