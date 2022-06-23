package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.model.NhanVien;

public class ThemNV extends AppCompatActivity {
    Button btnAdd;
    EditText ten,namsinh,quequan,trinhdo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nv);
        btnAdd=(Button)findViewById(R.id.btnAddOK);
        ten=(EditText) findViewById(R.id.tennv);
        namsinh=(EditText) findViewById(R.id.namsinh);
        quequan=(EditText) findViewById(R.id.quequan);
        trinhdo=(EditText) findViewById(R.id.trinhdo);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db1=new DatabaseHelper(getBaseContext());
                String tennv=ten.getText().toString();
                String namsinhnv=namsinh.getText().toString();
                String quequannv=quequan.getText().toString();
                String trinhdonv=trinhdo.getText().toString();
                if(tennv.length()==0||namsinhnv.length()==0||quequannv.length()==0||trinhdonv.length()==0){
                    Toast.makeText(ThemNV.this,"khong de trong",Toast.LENGTH_SHORT).show();
                }
                else {
                    int namsinhit=Integer.parseInt(namsinhnv);
                    NhanVien nv = new NhanVien(tennv, namsinhit, quequannv, trinhdonv);
                    db1.addNV(nv);
                    Toast.makeText(getBaseContext(), "Them dl tcong", Toast.LENGTH_SHORT).show();
                    Reset();
                    setResult(RESULT_OK, null);
                    finish();
                }
            }
        });

    }
    protected void Reset(){
        ten.setText("");
        namsinh.setText("");
        quequan.setText("");
        trinhdo.setText("");
    }
}
