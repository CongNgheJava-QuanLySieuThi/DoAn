/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

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

    public void setSoLuongTonKho(Integer soLuongTonKho) {
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
}
