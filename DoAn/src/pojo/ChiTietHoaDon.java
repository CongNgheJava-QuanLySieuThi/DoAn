package pojo;

import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nguyễn Kế Bảo
 */
public class ChiTietHoaDon implements Serializable {
    private static final long serialVersionUID = 1L;

    private int maChiTiet;
    private long maHD;
    private long maSP;
    private String tenSP;
    private double gia;
    private double giamGia;
    private int soLuongMua;
    private double tongTien;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int maChiTiet, long maHD, long maSP, String tenSP, double gia, double giamGia, int soLuongMua, double tongTien) {
        this.maChiTiet = maChiTiet;
        this.maHD = maHD;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.gia = gia;
        this.giamGia = giamGia;
        this.soLuongMua = soLuongMua;
        this.tongTien = tongTien;
    }

    public int getMaChiTiet() {
        return maChiTiet;
    }

    public void setMaChiTiet(int maChiTiet) {
        this.maChiTiet = maChiTiet;
    }

    public long getMaHD() {
        return maHD;
    }

    public void setMaHD(long maHD) {
        this.maHD = maHD;
    }

    public long getMaSP() {
        return maSP;
    }

    public void setMaSP(long maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
}
