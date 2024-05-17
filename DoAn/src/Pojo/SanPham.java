/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Phi_Vu
 */
public class SanPham implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long maSP;

    private String tenSP;
    private BigDecimal gia;
    private Integer giamGia;
    private String hinhAnh;
    private String tuKhoa;
    private String moTa;
    private Integer soLuongTonKho;

    private LocalDateTime ngayTao;

    private LocalDateTime ngayCapNhat;

    // Many - One relation
    private Long maDanhMuc;

    public SanPham() {
    }

    public SanPham(
            Long maSP, 
            String tenSP, 
            BigDecimal gia, 
            Integer giamGia, 
            String hinhAnh, 
            String tuKhoa, 
            String moTa, 
            Integer soLuongTonKho, 
            LocalDateTime ngayTao, 
            LocalDateTime ngayCapNhat, 
            Long maDanhMuc) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.gia = gia;
        this.giamGia = giamGia;
        this.hinhAnh = hinhAnh;
        this.tuKhoa = tuKhoa;
        this.moTa = moTa;
        this.soLuongTonKho = soLuongTonKho;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
        this.maDanhMuc = maDanhMuc;
    }

    public Long getMaSanPham() {
        return maSP;
    }

    public void setMaSanPham(Long maSP) {
        this.maSP = maSP;
    }

    public String getTenSanPham() {
        return tenSP;
    }

    public void setTenSanPham(String tenSP) {
        this.tenSP = tenSP;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public Integer getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(Integer giamGia) {
        this.giamGia = giamGia;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTuKhoa() {
        return tuKhoa;
    }

    public void setTuKhoa(String tuKhoa) {
        this.tuKhoa = tuKhoa;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void getSoLuongTonKho(Integer soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
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

    public Long getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(Long maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 31 * hash + Objects.hashCode(this.maSP);
//        hash = 31 * hash + Objects.hashCode(this.tenSP);
//        hash = 31 * hash + Objects.hashCode(this.gia);
//        hash = 31 * hash + Objects.hashCode(this.giamGia);
//        hash = 31 * hash + Objects.hashCode(this.hinhAnh);
//        hash = 31 * hash + Objects.hashCode(this.tuKhoa);
//        hash = 31 * hash + Objects.hashCode(this.moTa);
//        hash = 31 * hash + Objects.hashCode(this.soLuongTonKho);
//        hash = 31 * hash + Objects.hashCode(this.ngayTao);
//        hash = 31 * hash + Objects.hashCode(this.ngayCapNhat);
//        hash = 31 * hash + Objects.hashCode(this.danhMuc);
//        return hash;
//}
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
//        final SanPham other = (SanPham) obj;
//        if (!Objects.equals(this.tenSP, other.tenSP)) {
//            return false;
//        }
//        if (!Objects.equals(this.hinhAnh, other.hinhAnh)) {
//            return false;
//        }
//        if (!Objects.equals(this.tuKhoa, other.tuKhoa)) {
//            return false;
//        }
//        if (!Objects.equals(this.moTa, other.moTa)) {
//            return false;
//        }
//        if (!Objects.equals(this.maSP, other.maSP)) {
//            return false;
//        }
//        if (!Objects.equals(this.gia, other.gia)) {
//            return false;
//        }
//        if (!Objects.equals(this.giamGia, other.giamGia)) {
//            return false;
//        }
//        if (!Objects.equals(this.soLuongTonKho, other.soLuongTonKho)) {
//            return false;
//        }
//        if (!Objects.equals(this.ngayTao, other.ngayTao)) {
//            return false;
//        }
//        if (!Objects.equals(this.ngayCapNhat, other.ngayCapNhat)) {
//            return false;
//        }
//        return Objects.equals(this.danhMuc, other.danhMuc);
//    }
}
