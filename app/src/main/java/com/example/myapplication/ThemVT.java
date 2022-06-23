package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.NhanVien;
import com.example.myapplication.model.ViTri;

public class ThemVT extends AppCompatActivity {
    Button btnAdd;
    EditText ten,mota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_vt);
        btnAdd=(Button)findViewById(R.id.btnAddVTOK);
        ten=(EditText) findViewById(R.id.tenvt);
        mota=(EditText) findViewById(R.id.mota);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db1=new DatabaseHelper(getBaseContext());
                String tenvt=ten.getText().toString();
                String mota1=mota.getText().toString();
                if(tenvt.length()==0||mota.length()==0){
                    Toast.makeText(ThemVT.this,"khong de trong",Toast.LENGTH_SHORT).show();
                }
                else {
                    ViTri nv = new ViTri(tenvt,mota1);
                    db1.addVT(nv);
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
        mota.setText("");
    }
}
