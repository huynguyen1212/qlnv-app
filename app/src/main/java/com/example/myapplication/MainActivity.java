package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnNV,btnVT,btnVTCV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNV=findViewById(R.id.button);
        btnVT=findViewById(R.id.button2);
        btnVTCV=findViewById(R.id.button3);
        btnNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,NhanVienDs.class);
                startActivity(intent);
                finish();
            }
        });
        btnVT.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View view) {
                    Intent intent=new Intent(MainActivity.this,ViTriDs.class);
                    startActivity(intent);
                    finish();

            }
        });
        btnVTCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,VTCVDs.class);
                startActivity(intent);
            }
        });
    }
}
