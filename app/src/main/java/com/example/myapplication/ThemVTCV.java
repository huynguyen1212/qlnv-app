package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.model.NhanVien;
import com.example.myapplication.model.ViTri;
import com.example.myapplication.model.ViTriCV;

import java.util.Date;
import java.util.List;

public class ThemVTCV extends AppCompatActivity {
    Spinner spNV,spVT;
    EditText edDate,edMota;
    Button btnAddVTCV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_vtcv);
        edDate=findViewById(R.id.date);
        edMota=findViewById(R.id.motavtcv);
        btnAddVTCV=findViewById(R.id.btnAddVTCV);
        btnAddVTCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db1=new DatabaseHelper(getBaseContext());
                String textidNV=spNV.getSelectedItem().toString();
                System.out.println("textidNV"+textidNV);
                String textidVT=spVT.getSelectedItem().toString();
                String textdate=edDate.getText().toString();
                String moTa=edMota.getText().toString();
                if(textidNV.length()==0||textidVT.length()==0||textdate.length()==0||moTa.length()==0){
                    Toast.makeText(ThemVTCV.this,"khong de trong",Toast.LENGTH_SHORT).show();
                }
                else {
                    int idNV=Integer.parseInt(spNV.getSelectedItem().toString());
                    int idVT=Integer.parseInt(spVT.getSelectedItem().toString());
                    String tdg=edDate.getText().toString();
                    ViTriCV viTriCV=new ViTriCV(idNV,idVT,tdg,moTa);
                    db1.addVTCV(viTriCV);
                    Toast.makeText(getBaseContext(), "Them dl tcong", Toast.LENGTH_SHORT).show();
                    Reset();
                    setResult(RESULT_OK, null);
                    finish();
                }
            }
        });
        LoadListNV();
        LoadListVT();

    }
    protected void LoadListNV(){
            DatabaseHelper db1=new DatabaseHelper(getBaseContext());
            final List<String> list1=db1.getAllMaNV();
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list1);
            spNV=findViewById(R.id.spNV);
            spNV.setAdapter(adapter);
            spNV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(ThemVTCV.this,"position "+i,Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    Toast.makeText(ThemVTCV.this,"nothing selected",Toast.LENGTH_SHORT).show();
                }
            });
    }
    protected void LoadListVT(){
        DatabaseHelper db1=new DatabaseHelper(getBaseContext());
        final List<String> list2=db1.getAllMaVT();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list2);
        spVT=findViewById(R.id.spVT);
        spVT.setAdapter(adapter);
        spVT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ThemVTCV.this,"position "+i,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(ThemVTCV.this,"nothing selected",Toast.LENGTH_SHORT).show();
            }
        });

    }
    protected void Reset(){
        edDate.setText("");
        edMota.setText("");
    }

}
