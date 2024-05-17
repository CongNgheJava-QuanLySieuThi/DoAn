/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Phi_Vu
 */
public class HangTonKho implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long maHTK;
    private Long soLuongTrongKho;
    private LocalDateTime ngayNhapHang;
    private LocalDateTime ngayXuatHang;
    private String trangThai;
    private Long maSP;

    public HangTonKho() {
    }

    public HangTonKho(
            Long maHTK,
            Long soLuongTrongKho,
            LocalDateTime ngayNhapHang,
            LocalDateTime ngayXuatHang,
            String trangThai,
            Long maSP) {
        this.maHTK = maHTK;
        this.soLuongTrongKho = soLuongTrongKho;
        this.ngayNhapHang = ngayNhapHang;
        this.ngayXuatHang = ngayXuatHang;
        this.trangThai = trangThai;
        this.maSP = maSP;
    }

    public Long getMaHTK() {
        return maHTK;
    }

    public void setMaHTK(Long maHTK) {
        this.maHTK = maHTK;
    }

    public Long getSoLuongTrongKho() {
        return soLuongTrongKho;
    }

    public void setSoLuongTrongKho(Long soLuongTrongKho) {
        this.soLuongTrongKho = soLuongTrongKho;
    }

    public LocalDateTime getNgayNhapHang() {
        return ngayNhapHang;
    }

    public void setNgayNhapHang(LocalDateTime ngayNhapHang) {
        this.ngayNhapHang = ngayNhapHang;
    }

    public LocalDateTime getNgayXuatHang() {
        return ngayXuatHang;
    }

    public void setNgayXuatHang(LocalDateTime ngayXuatHang) {
        this.ngayXuatHang = ngayXuatHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Long getMaSanPham() {
        return maSP;
    }

    public void setMaSanPham(Long maSP) {
        this.maSP = maSP;
    }

//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 89 * hash + Objects.hashCode(this.maHTK);
//        hash = 89 * hash + Objects.hashCode(this.soLuongTrongKho);
//        hash = 89 * hash + Objects.hashCode(this.ngayNhapHang);
//        hash = 89 * hash + Objects.hashCode(this.ngayXuatHang);
//        hash = 89 * hash + Objects.hashCode(this.trangThai);
//        hash = 89 * hash + Objects.hashCode(this.sanPham);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final HangTonKho other = (HangTonKho) obj;
//        if (!Objects.equals(this.trangThai, other.trangThai)) {
//            return false;
//        }
//        if (!Objects.equals(this.maHTK, other.maHTK)) {
//            return false;
//        }
//        if (!Objects.equals(this.soLuongTrongKho, other.soLuongTrongKho)) {
//            return false;
//        }
//        if (!Objects.equals(this.ngayNhapHang, other.ngayNhapHang)) {
//            return false;
//        }
//        if (!Objects.equals(this.ngayXuatHang, other.ngayXuatHang)) {
//            return false;
//        }
//        return Objects.equals(this.sanPham, other.sanPham);
//    }
}
