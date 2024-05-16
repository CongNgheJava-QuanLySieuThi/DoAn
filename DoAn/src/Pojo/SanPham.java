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

    private Long maSanPham;

    private String tenSanPham;
    private BigDecimal gia;
    private Integer giamGia;
    private String hinhAnh;
    private String tuKhoa;
    private String moTa;
    private Integer soLuoưngTonKho;

    private LocalDateTime ngayTao;

    private LocalDateTime ngayCapNhat;

    // Many - One relation
    private DanhMuc danhMuc;

    public SanPham() {
    }

    public SanPham(
            Long maSanPham, 
            String tenSanPham, 
            BigDecimal gia, 
            Integer giamGia, 
            String hinhAnh, 
            String tuKhoa, 
            String moTa, 
            Integer soLuoưngTonKho, 
            LocalDateTime ngayTao, 
            LocalDateTime ngayCapNhat, 
            DanhMuc danhMuc) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.giamGia = giamGia;
        this.hinhAnh = hinhAnh;
        this.tuKhoa = tuKhoa;
        this.moTa = moTa;
        this.soLuoưngTonKho = soLuoưngTonKho;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
        this.danhMuc = danhMuc;
    }

    public Long getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(Long maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
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

    public Integer getSoLuoưngTonKho() {
        return soLuoưngTonKho;
    }

    public void setSoLuoưngTonKho(Integer soLuoưngTonKho) {
        this.soLuoưngTonKho = soLuoưngTonKho;
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

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.maSanPham);
        hash = 31 * hash + Objects.hashCode(this.tenSanPham);
        hash = 31 * hash + Objects.hashCode(this.gia);
        hash = 31 * hash + Objects.hashCode(this.giamGia);
        hash = 31 * hash + Objects.hashCode(this.hinhAnh);
        hash = 31 * hash + Objects.hashCode(this.tuKhoa);
        hash = 31 * hash + Objects.hashCode(this.moTa);
        hash = 31 * hash + Objects.hashCode(this.soLuoưngTonKho);
        hash = 31 * hash + Objects.hashCode(this.ngayTao);
        hash = 31 * hash + Objects.hashCode(this.ngayCapNhat);
        hash = 31 * hash + Objects.hashCode(this.danhMuc);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SanPham other = (SanPham) obj;
        if (!Objects.equals(this.tenSanPham, other.tenSanPham)) {
            return false;
        }
        if (!Objects.equals(this.hinhAnh, other.hinhAnh)) {
            return false;
        }
        if (!Objects.equals(this.tuKhoa, other.tuKhoa)) {
            return false;
        }
        if (!Objects.equals(this.moTa, other.moTa)) {
            return false;
        }
        if (!Objects.equals(this.maSanPham, other.maSanPham)) {
            return false;
        }
        if (!Objects.equals(this.gia, other.gia)) {
            return false;
        }
        if (!Objects.equals(this.giamGia, other.giamGia)) {
            return false;
        }
        if (!Objects.equals(this.soLuoưngTonKho, other.soLuoưngTonKho)) {
            return false;
        }
        if (!Objects.equals(this.ngayTao, other.ngayTao)) {
            return false;
        }
        if (!Objects.equals(this.ngayCapNhat, other.ngayCapNhat)) {
            return false;
        }
        return Objects.equals(this.danhMuc, other.danhMuc);
    }
}
