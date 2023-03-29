package com.example.eshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class OrdersDBHelper extends SQLiteOpenHelper {

    public static final String DBNAME="OrderDetails.db";

    public OrdersDBHelper(@Nullable Context context) {
        super(context, "OrderDetails.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String Query="Create table UserOrder(Product_ID TEXT, User_Name TEXT, User_Phone TEXT, Product_Name TEXT,Product_price TEXT,Product_size TEXT,Product_Quantity TEXT,TotalPrice TEXT,Address TEXT)";
        sqLiteDatabase.execSQL(Query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("Drop table if exists UserOrder");

    }

    //Insert data for orders


    public boolean InsertOrders(String Product_ID,String User_Name,String User_Phone,String Product_Name,String Product_price,String Product_size,String Product_Quantity,String TotalPrice,String Address){

        SQLiteDatabase Database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Product_ID",Product_ID);
        contentValues.put("User_Name",User_Name);
        contentValues.put("User_Phone",User_Phone);
        contentValues.put("Product_Name",Product_Name);
        contentValues.put("Product_price",Product_price);
        contentValues.put("Product_size",Product_size);
        contentValues.put("Product_Quantity",Product_Quantity);
        contentValues.put("TotalPrice",TotalPrice);
        contentValues.put("Address",Address);

        long result=Database.insert("UserOrder",null,contentValues);
        if (result==-1){
            return  false;
        }else {
            return true;
        }

    }


    //get data

    public Cursor getOrderedData(){

        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from UserOrder",null);
        return cursor;

    }


}
