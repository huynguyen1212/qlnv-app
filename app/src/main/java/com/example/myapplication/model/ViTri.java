package com.example.myapplication.model;

public class ViTri {
    private int maVT;
    private String tenVT;
    private String moTaVT;

    public ViTri() {
    }

    public ViTri(int maVT, String tenVT, String moTaVT) {
        this.maVT = maVT;
        this.tenVT = tenVT;
        this.moTaVT = moTaVT;
    }

    public ViTri(String tenVT, String moTaVT) {
        this.tenVT = tenVT;
        this.moTaVT = moTaVT;
    }

    public int getMaVT() {
        return maVT;
    }

    public void setMaVT(int maVT) {
        this.maVT = maVT;
    }

    public String getTenVT() {
        return tenVT;
    }

    public void setTenVT(String tenVT) {
        this.tenVT = tenVT;
    }

    public String getMoTaVT() {
        return moTaVT;
    }

    public void setMoTaVT(String moTaVT) {
        this.moTaVT = moTaVT;
    }

    @Override
    public String toString() {
        return "Ma VT: "+getMaVT()+"\n"+"Ten VT: "+getTenVT()+"\n"+"Mo ta: "+getMoTaVT();
    }
}
