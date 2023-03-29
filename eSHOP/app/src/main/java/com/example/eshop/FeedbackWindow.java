package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class FeedbackWindow extends AppCompatActivity {

    RatingBar ratingBar;
    EditText Message,RatingValue,NumberValue;
    String FinalRating,MSG,NUM;
    Button SEND;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_window);

        ratingBar=findViewById(R.id.ratingBar);
        Message=findViewById(R.id.message);
        RatingValue=findViewById(R.id.ratingValue);
        NumberValue=findViewById(R.id.NumberValue);
        SEND=findViewById(R.id.send);


        SEND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float rating=ratingBar.getRating();
                RatingValue.setText("Ratting  " +rating);
                FinalRating=RatingValue.getText().toString();

              //  Toast.makeText(FeedbackWindow.this, FinalRating, Toast.LENGTH_SHORT).show();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                    if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                        SendSMS();
                    }else{

                        requestPermissions(new String[]{Manifest.permission.SEND_SMS},1);
                    }
                }

            }
        });


    }

    private  void SendSMS(){

        try {


            MSG=Message.getText().toString().trim();
            NUM=NumberValue.getText().toString().trim();

            SmsManager SMS=SmsManager.getDefault();
            SMS.sendTextMessage(NUM,null,FinalRating+"\n"+MSG,null,null);
            Toast.makeText(getApplicationContext(), "sent", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
        }

    }



}