package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterUser extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup;
    LoginDBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);



        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.retypePassword);
        signup = (Button) findViewById(R.id.signUp);

        DB=new LoginDBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=username.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)|| TextUtils.isEmpty(repass)){
                    Toast.makeText(getApplicationContext(),"Kindly Fill the Required Details",Toast.LENGTH_SHORT).show();
                }else{

                    if(pass.equals(repass)){
                        Boolean checkUser=DB.checkUserName(user);
                        if(checkUser==false){
                            Boolean insert=DB.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Registration Success ",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),Home.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(getApplicationContext(),"Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getApplicationContext(),"User Name Already Exists Kindly Login",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"Password Not Matching",Toast.LENGTH_SHORT).show();
                    }
                }

                EmptyTextAfterEntered();
            }
        });






    }




    public void EmptyTextAfterEntered(){
        username.getText().clear();
        password.getText().clear();
        repassword.getText().clear();

    }



}