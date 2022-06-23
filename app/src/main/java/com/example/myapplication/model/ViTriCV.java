package com.example.myapplication.model;

import java.util.Date;

public class ViTriCV {
    private int maNV;
    private int maVT;
    private String thoiDiemGan;
    private String moTa;

    public ViTriCV() {
    }

    public ViTriCV(int maNV, int maVT, String thoiDiemGan, String moTa) {
        this.maNV = maNV;
        this.maVT = maVT;
        this.thoiDiemGan = thoiDiemGan;
        this.moTa = moTa;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaVT() {
        return maVT;
    }

    public void setMaVT(int maVT) {
        this.maVT = maVT;
    }

    public String getThoiDiemGan() {
        return thoiDiemGan;
    }

    public void setThoiDiemGan(String thoiDiemGan) {
        this.thoiDiemGan = thoiDiemGan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "maNV:" + maNV +"\n"+
                "maVT:" + maVT +"\n"+
                "moTa:" + moTa;
    }
}
