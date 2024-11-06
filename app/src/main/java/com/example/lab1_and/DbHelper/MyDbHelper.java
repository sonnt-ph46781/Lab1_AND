package com.example.lab1_and.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {

    public MyDbHelper(Context context){
        super(context,"QLBH.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCategory = "CREATE TABLE tb_cat(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT UNIQUE NOT NULL)";
        db.execSQL(sqlCategory);
        String sqlProduct = "CREATE TABLE tb_product (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT UNIQUE NOT NULL,  price REAL DEFAULT (0.0) NOT NULL,  id_cat INTEGER REFERENCES tb_cat (id))";
        db.execSQL((sqlProduct));
        //Moi khi chinh sua cau lenh SQL o tren thi tang version o ham khoi tao

        // Thêm dữ liệu mẫu cho tb_cat
        db.execSQL("INSERT INTO tb_cat(name) VALUES ('Dien thoai')");
        db.execSQL("INSERT INTO tb_cat(name) VALUES ('TIVI')");
        db.execSQL("INSERT INTO tb_cat(name) VALUES ('Tu lanh')");

        // Thêm dữ liệu mẫu cho tb_product
        db.execSQL("INSERT INTO tb_product(name, price, id_cat) VALUES ('Xiaomi', 1200.0, 1)");
        db.execSQL("INSERT INTO tb_product(name, price, id_cat) VALUES ('Sony', 15.0, 2)");
        db.execSQL("INSERT INTO tb_product(name, price, id_cat) VALUES ('Toshiba', 70.0, 3)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i < i1) { //i1 la phien ban moi i la phien ban cu
            db.execSQL("DROP TABLE IF EXISTS tb_cat");
            db.execSQL("DROP TABLE IF EXISTS tb_product");
            onCreate(db);
        }
    }
}
