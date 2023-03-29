package com.example.eshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserOrdersDetails extends SQLiteOpenHelper {

    public static final String DBNAME="UserOrders.db";

    public UserOrdersDetails(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String Query="Create table Orders(PRODUCT_ID TEXT Primary key, USER_NAME TEXT, USER_PHONE TEXT)";

        sqLiteDatabase.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("Drop table if exists Orders");

    }

    // For Insert

    public boolean InsertData(String PRODUCT_ID,String USER_NAME,String USER_PHONE){

        // , String ProductName,String ProductPrice,String ProductSize

        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues  contentValues=new ContentValues();
        contentValues.put("PRODUCT_ID",PRODUCT_ID);
        contentValues.put("USER_NAME",USER_NAME);
        contentValues.put("USER_PHONE",USER_PHONE);
        /*
        contentValues.put("ProductName",ProductName);
        contentValues.put("ProductPrice",ProductPrice);
        contentValues.put("ProductSize",ProductSize);*/

        long result=DB.insert("Orders",null,contentValues);

        if (result==-1){
            return  false;
        }else{
            return true;
        }

    }


}
