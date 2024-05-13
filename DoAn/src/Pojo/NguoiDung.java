/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.time.LocalDateTime;

/**
 *
 * @author Nguyễn Kế Bảo
 */
public class NguoiDung {
    private long maND;
    private String ho;
    private String ten;
    private String tenTaiKhoan;
    private String matKhau;
    private String chucVu;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayCapNhat;
    
    public NguoiDung(long maND,String ho,String ten,String tenTaiKhoan,String matKhau,String chucVu,LocalDateTime ngayTao,LocalDateTime ngayCapNhat){
        this.maND=maND;
        this.ho=ho;
        this.ten=ten;
        this.tenTaiKhoan=tenTaiKhoan;
        this.matKhau=matKhau;
        this.chucVu=chucVu;
        this.ngayTao=ngayTao;
        this.ngayCapNhat=ngayCapNhat;
    }
    public NguoiDung(){}
    public long getMaND() {
        return maND;
    }

    public void setMaND(long maND) {
        this.maND = maND;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public LocalDateTime getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(LocalDateTime ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }
}
