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

public class Resetpage extends AppCompatActivity {

    TextView Username, CancelPage;
    EditText password,rePassword;
    Button Confirm;
    LoginDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpage);



        Username=findViewById(R.id.username);
        CancelPage=findViewById(R.id.cancel);
        password=findViewById(R.id.password);
        rePassword=findViewById(R.id.retypePassword);
        Confirm=findViewById(R.id.confirm);

        CancelPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),PopupLogin.class);
                startActivity(intent);
            }
        });

        Intent intent=getIntent();
        Username.setText(intent.getStringExtra("username"));

        DB=new LoginDBHelper(this);

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=Username.getText().toString();
                String pass=password.getText().toString();
                String repass=rePassword.getText().toString();


                if (TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass)) {
                    Toast.makeText(getApplicationContext(), "Kindly Fill the Required Details", Toast.LENGTH_SHORT).show();
                } else {

                    if(pass.equals(repass)){

                        Boolean  CheckUpdate=DB.UpdateData(user,pass);
                        if(CheckUpdate==true){
                            Toast.makeText(getApplicationContext(), "Password Updated", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),PopupLogin.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(getApplicationContext(), "Password Not Updated", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(getApplicationContext(), "Password Not Matching", Toast.LENGTH_SHORT).show();
                    }


                }


            }
        });

    }
}