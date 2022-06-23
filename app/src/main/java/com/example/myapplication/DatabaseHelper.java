package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.myapplication.model.NhanVien;
import com.example.myapplication.model.ViTri;
import com.example.myapplication.model.ViTriCV;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "quanlinhanvien";
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery = "CREATE TABLE nhanvien ( manv integer primary key,"
                + "ten TEXT, namsinh integer, quequan TEXT, trinhdo TEXT)";
        sqLiteDatabase.execSQL(sqlQuery);

        Toast.makeText(context, "Create table nhanvien thanh cong", Toast.LENGTH_SHORT).show();

        String sqlQuery1 = "CREATE TABLE vitri ( mavt integer primary key,"
                + "tenvt TEXT, motavt TEXT)";
        sqLiteDatabase.execSQL(sqlQuery1);

        Toast.makeText(context, "Create table vi tri thanh cong", Toast.LENGTH_SHORT).show();

        String sqlQuery2 = "CREATE TABLE ViTriCV("
                + "maNV integer NOT NULL,"
                + "maVT integer NOT NULL,"
                + "thoigian text,"
                + "mota text,"
                + "FOREIGN KEY(maNV) REFERENCES NhanVien(maNV),"
                + "FOREIGN KEY(maVT) REFERENCES NhanVien(maVT),"
                + "CONSTRAINT PK_VTCV PRIMARY KEY (maNV,maVT));";
        sqLiteDatabase.execSQL(sqlQuery2);

        Toast.makeText(context, "Create table vi tri cong viec thanh cong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS nhanvien");
        onCreate(sqLiteDatabase);
        Toast.makeText(context, "Drop thanh cong", Toast.LENGTH_SHORT).show();
    }

    public void addNV(NhanVien nv) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten", nv.getTen());
        values.put("namsinh", nv.getNamSinh());
        values.put("quequan", nv.getQueQuan());
        values.put("trinhdo", nv.getTrinhDo());
        db.insert("nhanvien", null, values);
        db.close();
    }

    public List<NhanVien> getAllNV() {
        List<NhanVien> listNV = new ArrayList<NhanVien>();
        String sql = "SELECT * FROM nhanvien";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                NhanVien nv = new NhanVien();
                nv.setMaNV(cursor.getInt(0));
                nv.setTen(cursor.getString(1));
                nv.setNamSinh(cursor.getInt(2));
                nv.setQueQuan(cursor.getString(3));
                nv.setTrinhDo(cursor.getString(4));
                listNV.add(nv);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listNV;
    }

    public void addVT(ViTri vt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenvt", vt.getTenVT());
        values.put("motavt", vt.getMoTaVT());
        db.insert("vitri", null, values);
        db.close();
    }

    public List<ViTri> getAllVT() {
        List<ViTri> listVT = new ArrayList<ViTri>();
        String sql = "SELECT * FROM vitri";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                ViTri nv = new ViTri();
                nv.setMaVT(cursor.getInt(0));
                nv.setTenVT(cursor.getString(1));
                nv.setMoTaVT(cursor.getString(2));
                listVT.add(nv);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listVT;
    }

    public List<String> getAllMaNV() {
        List<String> listNV = new ArrayList<String>();
        String sql = "SELECT MaNV,ten FROM nhanvien";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                listNV.add(cursor.getInt(0) + "");
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listNV;
    }

    public List<String> getAllMaVT() {
        List<String> listVT = new ArrayList<String>();
        String sql = "SELECT mavt FROM  vitri";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                listVT.add(String.valueOf(cursor.getInt(0)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listVT;
    }

    public List<ViTriCV> getAllVTCV() {
        List<ViTriCV> listVTCV = new ArrayList<ViTriCV>();
        String sql = "SELECT * FROM vitricv";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                ViTriCV nv = new ViTriCV();
                nv.setMaNV(cursor.getInt(0));
                nv.setMaVT(cursor.getInt(1));
                nv.setThoiDiemGan(cursor.getString(2));
                nv.setMoTa(cursor.getString(3));
                listVTCV.add(nv);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listVTCV;
    }

    public void addVTCV(ViTriCV vt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("maNV", vt.getMaNV());
        values.put("maVT", vt.getMaVT());
        values.put("thoigian", vt.getThoiDiemGan());
        values.put("mota", vt.getMoTa());
        db.insert("ViTriCV", null, values);
        db.close();
    }

    public List<NhanVien> getNVLietke() {
        List<NhanVien> listNV = new ArrayList<NhanVien>();
        String sql = "SELECT * FROM nhanvien WHERE ten='NAM' AND  namsinh=1995;";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                NhanVien nv = new NhanVien();
                nv.setMaNV(cursor.getInt(0));
                nv.setTen(cursor.getString(1));
                nv.setNamSinh(cursor.getInt(2));
                nv.setQueQuan(cursor.getString(3));
                nv.setTrinhDo(cursor.getString(4));
                listNV.add(nv);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listNV;
    }
}
