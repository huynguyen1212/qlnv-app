package com.example.myapplication.model;

public class NhanVien {
    private int maNV;
    private String ten;
    private int namSinh;
    private String queQuan;
    private String trinhDo;

    public NhanVien() {
    }

    public NhanVien(int maNV, String ten, int namSinh, String queQuan, String trinhDo) {
        this.maNV = maNV;
        this.ten = ten;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.trinhDo = trinhDo;
    }

    public NhanVien(String ten, int namSinh, String queQuan, String trinhDo) {
        this.ten = ten;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.trinhDo = trinhDo;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    @Override
    public String toString() {
        return
                "Ma nhan vien: " + getMaNV() +"\n"+ "Ten nhan vien: " + getTen()+"\n" +"Nam sinh: " + getNamSinh();
    }
}
