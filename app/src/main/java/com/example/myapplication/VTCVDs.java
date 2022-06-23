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
import com.example.myapplication.model.ViTriCV;

import java.util.List;

public class VTCVDs extends AppCompatActivity {
    Button btnAdd,btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vtcvds);
        btnAdd=findViewById(R.id.addVTCV);
        btnHome=findViewById(R.id.home3);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(VTCVDs.this,ThemVTCV.class);
                startActivityForResult(intent,1);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(VTCVDs.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        LoadListVTCV();
    }
    protected void LoadListVTCV(){
        DatabaseHelper db1=new DatabaseHelper(getBaseContext());
        final List<ViTriCV> list1=db1.getAllVTCV();
        ListView lv1=(ListView) findViewById(R.id.listVTCV);
        ArrayAdapter<ViTriCV> adapter=new ArrayAdapter<ViTriCV>(this,android.R.layout.simple_list_item_1,list1);
        lv1.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if((resultCode==RESULT_OK)&&(requestCode==1)){
            Intent refresh=new Intent(this, VTCVDs.class);
            Toast.makeText(VTCVDs.this,"Them vi tri cong viec tc",Toast.LENGTH_SHORT).show();
            startActivity(refresh);
            this.finish();
        }

    }
}
