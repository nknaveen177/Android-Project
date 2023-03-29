package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ConfirmAndPay extends AppCompatActivity {

    ImageButton BACK;

    TextView RandomNumber,Generate,GET_PRODUCT_NAME,GET_PRICE,GET_SIZE,GET_QUANTITY,GET_TOTAL,LOGIN;
    EditText NAME,PHONE_NO,ADDRESS;
    Button Confirm;


    OrdersDBHelper dbHelper;

    int payment_time=3000;

    private static final int TEZ_REQUEST_CODE = 123;
    private static final String GOOGLE_TEZ_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user";

    String StoreTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_and_pay);

        BACK=findViewById(R.id.back);
        BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),ProductDetails.class);
                startActivity(intent);
            }
        });

        // Random Number generator

        Generate=findViewById(R.id.generateId);
        RandomNumber=findViewById(R.id.id);

        Generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String StoreId=RandomNumber.getText().toString();
                Random random = new Random();
                int randomNumber = random.nextInt(1000000); // generates a random number between 0 and 100 (exclusive)

                while (TextUtils.isEmpty(StoreId)){
                    RandomNumber.setText(String.valueOf(randomNumber));
                    break;
                }

            }
        });

        // set final details

        GET_PRODUCT_NAME=findViewById(R.id.name);
        GET_PRICE=findViewById(R.id.price);
        GET_SIZE=findViewById(R.id.size);
        GET_QUANTITY=findViewById(R.id.quantity);
        GET_TOTAL=findViewById(R.id.overAllTotal);

        Intent intent=getIntent();

        GET_PRODUCT_NAME.setText(intent.getStringExtra("ProductName"));
        GET_PRICE.setText(intent.getStringExtra("ProductPrice"));
        GET_SIZE.setText(intent.getStringExtra("ProductSize"));
        GET_QUANTITY.setText(intent.getStringExtra("Quantity"));
        GET_TOTAL.setText(intent.getStringExtra("Total"));

        NAME=findViewById(R.id.putName);
        PHONE_NO=findViewById(R.id.putphone);
        ADDRESS=findViewById(R.id.Address);
        Confirm=findViewById(R.id.confirmPay);

        dbHelper=new OrdersDBHelper(this);

        CheckBox confirmationCheck=findViewById(R.id.checkBox);

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String StoreId=RandomNumber.getText().toString();
                String StoreName=NAME.getText().toString();
                String StorePhone=PHONE_NO.getText().toString();
                String StoreProductName=GET_PRODUCT_NAME.getText().toString();
                String StorePrice=GET_PRICE.getText().toString();
                String StoreSize=GET_SIZE.getText().toString();
                String StoreQuantity=GET_QUANTITY.getText().toString();
                StoreTotal=GET_TOTAL.getText().toString();
                String StoreAddress=ADDRESS.getText().toString();


if (TextUtils.isEmpty(StoreId)||TextUtils.isEmpty(StoreName)||TextUtils.isEmpty(StorePhone)||TextUtils.isEmpty(StoreProductName)||TextUtils.isEmpty(StorePrice)||TextUtils.isEmpty(StoreSize)||TextUtils.isEmpty(StoreQuantity)||TextUtils.isEmpty(StoreTotal)||TextUtils.isEmpty(StoreAddress)){
    Toast.makeText(ConfirmAndPay.this, "Fill The required details", Toast.LENGTH_SHORT).show();
}else {

    boolean Insert= dbHelper.InsertOrders(StoreId,StoreName,StorePhone,StoreProductName,StorePrice,StoreSize,StoreQuantity,StoreTotal,StoreAddress);
    if (Insert==true){
        Toast.makeText(ConfirmAndPay.this, "Payment processing is going on.. kindly wait", Toast.LENGTH_SHORT).show();

       confirmationCheck.setChecked(true);


       // payment



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Uri uri = new Uri.Builder()
                                .scheme("upi")
                                .authority("pay")
                                .appendQueryParameter("pa", "test@edubank")
                                .appendQueryParameter("pn", "Test Account")
                                .appendQueryParameter("mc", "1234")
                                .appendQueryParameter("tr", "123456789")
                                .appendQueryParameter("tn", "test transaction")
                                .appendQueryParameter("am", StoreTotal)
                                .appendQueryParameter("cu", "INR")
                                .appendQueryParameter("url", "https://developers.google.com/pay/india/api/android/in-app-payments")
                                .build();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                intent.setPackage(GOOGLE_TEZ_PACKAGE_NAME);
                startActivityForResult(intent, TEZ_REQUEST_CODE);

                confirmationCheck.setChecked(false);
                RandomNumber.setText("");

            }
        },payment_time);




    }else{
        Toast.makeText(ConfirmAndPay.this, "Confirmation Failed", Toast.LENGTH_SHORT).show();
    }
}

            }
        });




        LOGIN=findViewById(R.id.login);

        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(),PopupLogin.class);
                startActivity(intent1);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEZ_REQUEST_CODE) {
            // Process based on the data in response.
            Log.d("result", data.getStringExtra("Status"));
        }
    }


}