package com.example.lab1_and.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lab1_and.DTO.CatDTO;
import com.example.lab1_and.DbHelper.MyDbHelper;

import java.util.ArrayList;

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
    // haàm lấy danh sach
    public ArrayList<CatDTO> getList(){
        ArrayList<CatDTO> listCat = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT id, name FROM tb_cat ", null);
        if(c != null && c.getCount()>0){
            // lay duoc du lieu
            c.moveToFirst();
            // duyet vong lap
            do {
                // Thu tu cot: id la 0, name la 1
                int id = c.getInt(0);
                String name = c.getString(1);
                CatDTO objCat = new CatDTO();
                objCat.setId(id);
                objCat.setName(name);
                //cho vao list
                listCat.add(objCat);
            }while (c.moveToNext());

        }else{
            // log: khong lay duoc du lieu
            Log.d("zzzzzz", "CatDAO::getList: Khong lay duoc du lieu");
        }
        return  listCat;
    }

    // hàm lấy 1 bản ghi, nếu không lấy được thì trả về null
    public CatDTO getOneById( int id){
        CatDTO objCat = null;
        String [] params = { String.valueOf( id ) };
        Cursor c = db.rawQuery("SELECT id, name FROM tb_cat WHERE id = ? ", params);
        if(c!=null && c.getCount() ==1){
            objCat = new CatDTO();// khởi tạo đối tượng
            objCat.setId(  c.getInt(0)  );
            objCat.setName( c.getString(1) );
        }
        return  objCat;
    }




}
