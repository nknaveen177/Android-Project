package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PopupLogin extends AppCompatActivity {

    EditText username, password;
    TextView forgetTXT,registerTXT;
    Button login,CancelPage;
    ImageView Content;

    LoginDBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_login);


        Content=findViewById(R.id.startImage);

        forgetTXT = (TextView) findViewById(R.id.forget);
        registerTXT = (TextView) findViewById(R.id.register);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.signin);
        CancelPage = (Button) findViewById(R.id.cancel);

        Content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PopupLogin.this, "Created by NAVEEN", Toast.LENGTH_SHORT).show();
            }
        });

        CancelPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();

            }
        });

        forgetTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ForgotPass.class);
                startActivity(intent);
            }
        });

        registerTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),RegisterUser.class);
                startActivity(intent);
            }
        });

        DB = new LoginDBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                    Toast.makeText(getApplicationContext(),"Kindly Fill the Required Details",Toast.LENGTH_SHORT).show();
                }else {

                    Boolean CheckUserPass=DB.CheckUserNamePassword(user,pass);
                    if(CheckUserPass==true){
                        Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),Home.class);
                        intent.putExtra("username",user);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Login Failed (This user name or password is not Registered)",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




    }
}