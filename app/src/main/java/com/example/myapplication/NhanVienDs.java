package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.model.NhanVien;

import java.util.List;

public class NhanVienDs extends AppCompatActivity {
    ListView listNV;
    Button btnAddNV, btnHome, btnLietke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien_ds);
        btnAddNV = findViewById(R.id.addNV);
        btnHome = findViewById(R.id.home1);
        btnLietke = findViewById(R.id.lietke);

        btnAddNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAdd = new Intent(NhanVienDs.this, ThemNV.class);
                startActivityForResult(intentAdd, 1);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NhanVienDs.this, MainActivity.class);
                startActivity(intent);
            }
        });

        LoadListNV();

        btnLietke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadListNVLietke();
            }
        });

    }

    protected void LoadListNV() {
        DatabaseHelper db1 = new DatabaseHelper(getBaseContext());
        final List<NhanVien> list1 = db1.getAllNV();
        ListView lv1 = (ListView) findViewById(R.id.listNV);
        ArrayAdapter<NhanVien> adapter = new ArrayAdapter<NhanVien>(this, android.R.layout.simple_list_item_1, list1);
        lv1.setAdapter(adapter);
    }

    protected void LoadListNVLietke() {
        DatabaseHelper db1 = new DatabaseHelper(getBaseContext());
        final List<NhanVien> list1 = db1.getNVLietke();
        ListView lv1 = (ListView) findViewById(R.id.listNV);
        ArrayAdapter<NhanVien> adapter = new ArrayAdapter<NhanVien>(this, android.R.layout.simple_list_item_1, list1);
        lv1.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((resultCode == RESULT_OK) && (requestCode == 1)) {
            Intent refresh = new Intent(this, NhanVienDs.class);
            Toast.makeText(NhanVienDs.this, "Them nhan vien tc", Toast.LENGTH_SHORT).show();
            startActivity(refresh);
            this.finish();
        }
//

    }
}
