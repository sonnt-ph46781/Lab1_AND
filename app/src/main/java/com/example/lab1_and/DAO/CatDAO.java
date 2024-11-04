package com.example.lab1_and.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab1_and.DTO.CatDTO;
import com.example.lab1_and.DbHelper.MyDbHelper;

public class CatDAO {
    MyDbHelper dbHelper;
    SQLiteDatabase db;
    public CatDAO(Context context){
        dbHelper = new MyDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public int addRow(CatDTO objCat){
        ContentValues v = new ContentValues();
        v.put("name",objCat.getName());
        int kq = (int)db.insert("tb_cat",null,v);
        return kq;
    }


}
