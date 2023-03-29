package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ForgotPass extends AppCompatActivity {

    EditText username;
    Button resetButton;
    LoginDBHelper DB;
    TextView CancelPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);


        username=findViewById(R.id.username);
        resetButton=findViewById(R.id.reset);
        CancelPage=findViewById(R.id.cancel);

        CancelPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),PopupLogin.class);
                startActivity(intent);
            }
        });

        DB=new LoginDBHelper(this);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=username.getText().toString();

                if(TextUtils.isEmpty(user)){
                    Toast.makeText(getApplicationContext(),"Kindly Fill the Required Details", Toast.LENGTH_SHORT).show();
                }else {

                    Boolean CheckUser=DB.checkUserName(user);
                    if(CheckUser==true){
                        Intent intent=new Intent(getApplicationContext(),Resetpage.class);
                        intent.putExtra("username",user);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"User Name Not Matching",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });




    }
}