package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.NhanVien;
import com.example.myapplication.model.ViTri;

import java.util.List;

public class ViTriDs extends AppCompatActivity {
    ListView listVT;
    Button btnAddVT,btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vi_tri_ds);
        btnAddVT=findViewById(R.id.addVT);
        btnHome=findViewById(R.id.home2);
        btnAddVT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAdd=new Intent(ViTriDs.this,ThemVT.class);
                startActivityForResult(intentAdd,1);
        }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ViTriDs.this,MainActivity.class);
                startActivity(intent);
            }
        });
        LoadListVT();

    }
    protected void LoadListVT(){
        DatabaseHelper db1=new DatabaseHelper(getBaseContext());
        final List<ViTri> list1=db1.getAllVT();
        ListView lv1=(ListView) findViewById(R.id.listVT);
        ArrayAdapter<ViTri> adapter=new ArrayAdapter<ViTri>(this,android.R.layout.simple_list_item_1,list1);
        lv1.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if((resultCode==RESULT_OK)&&(requestCode==1)){
            Intent refresh=new Intent(this, ViTriDs.class);
            Toast.makeText(ViTriDs.this,"Them vi tri tc",Toast.LENGTH_SHORT).show();
            startActivity(refresh);
            this.finish();
        }
//

    }
}
