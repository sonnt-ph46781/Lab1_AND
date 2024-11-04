package com.example.lab1_and.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab1_and.DTO.ProductDTO;
import com.example.lab1_and.DbHelper.MyDbHelper;

public class ProductDAO {
    MyDbHelper dbHelper;
    SQLiteDatabase db;
    public ProductDAO(Context context){
        dbHelper = new MyDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public int addRow(ProductDTO objProduct){
        ContentValues v = new ContentValues();
        v.put("name",objProduct.getName());
        v.put("price",objProduct.getPrice());
        v.put("id_cat",objProduct.getId_cat());
        int kq = (int)db.insert("tb_product",null,v);
        return kq;
    }

}
