package com.example.eshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LoginDBHelper extends SQLiteOpenHelper {

    public static final String DBName="Login.db";

    public LoginDBHelper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {

        DB.execSQL(" create table Users(username TEXT primary key, password TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL(" drop table if exists Users");

    }



    public Boolean insertData(String username, String password){

        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result=DB.insert("Users",null,contentValues);
        if(result==-1) return false;
        else{
            return true;
        }

    }

    public Boolean UpdateData(String username, String password){

        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("password",password);
        long result=DB.update("Users",contentValues,"username=?",new String[]{username});
        if(result==-1) return false;
        else{
            return true;
        }

    }

    public  Boolean checkUserName(String username){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery(" select * from Users where username=?",new String[]{username});
        if(cursor.getCount()>0){
            return  true;
        }else{
            return false;
        }
    }

    public Boolean CheckUserNamePassword(String username, String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("select * from Users where username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0){
            return  true;
        }else{
            return false;
        }

    }






}
