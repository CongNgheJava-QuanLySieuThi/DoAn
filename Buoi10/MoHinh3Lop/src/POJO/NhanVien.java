/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class NhanVien {
    private int MaSV, Phong;
    private String HoTen, Phai, DiaChi;
    private Date NgaySinh;
    private float Luong;
    private boolean TrangThai;

    public NhanVien() {
    }

    public NhanVien(int MaSV, int Phong, String HoTen, String Phai, String DiaChi, Date NgaySinh, float Luong, boolean TrangThai) {
        this.MaSV = MaSV;
        this.Phong = Phong;
        this.HoTen = HoTen;
        this.Phai = Phai;
        this.DiaChi = DiaChi;
        this.NgaySinh = NgaySinh;
        this.Luong = Luong;
        this.TrangThai = TrangThai;
    }

    public int getMaSV() {
        return MaSV;
    }

    public void setMaSV(int MaSV) {
        this.MaSV = MaSV;
    }

    public int getPhong() {
        return Phong;
    }

    public void setPhong(int Phong) {
        this.Phong = Phong;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getPhai() {
        return Phai;
    }

    public void setPhai(String Phai) {
        this.Phai = Phai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public float getLuong() {
        return Luong;
    }

    public void setLuong(float Luong) {
        this.Luong = Luong;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    

    
}
