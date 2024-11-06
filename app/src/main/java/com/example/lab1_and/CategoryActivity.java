package com.example.lab1_and;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab1_and.Adapter.CatAdapter;
import com.example.lab1_and.DAO.CatDAO;
import com.example.lab1_and.DTO.CatDTO;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
    CatDAO catDAO;
    ArrayList<CatDTO> listCat;
    ListView lvCat;
    Button btnAdd, btnUpdate, btnDelete;
    EditText edCatName;
    CatAdapter adapter ;

    String TAG = "zzzzzz";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lvCat = findViewById(R.id.lv_cat);
        btnAdd = findViewById(R.id.btn_add);
        btnUpdate = findViewById(R.id.btn_update);
        btnDelete = findViewById(R.id.btn_delete);
        edCatName = findViewById(R.id.ed_catname);


        catDAO = new CatDAO(this); // Khởi tạo DAO

        listCat = catDAO.getList();
        // khởi tạo Adapter
        adapter = new CatAdapter(this,listCat);
        lvCat.setAdapter( adapter ); // gắn adapter vào listview


    }
}