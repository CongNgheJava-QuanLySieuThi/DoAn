/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Phi_Vu
 */
public class DonHang implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long madonhang;
    private String tendonhang;
    private BigDecimal tongtien;
    private BigDecimal tonggiamgia;
    private LocalDateTime ngaytao;
    private Long maND;

    public DonHang() {
    }

    public DonHang(Long madonhang, String tendonhang, BigDecimal tongtien, BigDecimal tonggiamgia, LocalDateTime ngaytao, Long maND) {
        this.madonhang = madonhang;
        this.tendonhang = tendonhang;
        this.tongtien = tongtien;
        this.tonggiamgia = tonggiamgia;
        this.ngaytao = ngaytao;
        this.maND = maND;
    }

    public Long getMadonhang() {
        return madonhang;
    }

    public void setMadonhang(Long madonhang) {
        this.madonhang = madonhang;
    }

    public String getTendonhang() {
        return tendonhang;
    }

    public void setTendonhang(String tendonhang) {
        this.tendonhang = tendonhang;
    }

    public BigDecimal getTongtien() {
        return tongtien;
    }

    public void setTongtien(BigDecimal tongtien) {
        this.tongtien = tongtien;
    }

    public BigDecimal getTonggiamgia() {
        return tonggiamgia;
    }

    public void setTonggiamgia(BigDecimal tonggiamgia) {
        this.tonggiamgia = tonggiamgia;
    }

    public LocalDateTime getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(LocalDateTime ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Long getMaNguoiDung() {
        return maND;
    }

    public void setMaNguoiDung(Long maND) {
        this.maND = maND;
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 53 * hash + Objects.hashCode(this.madonhang);
//        hash = 53 * hash + Objects.hashCode(this.tendonhang);
//        hash = 53 * hash + Objects.hashCode(this.tongtien);
//        hash = 53 * hash + Objects.hashCode(this.tonggiamgia);
//        hash = 53 * hash + Objects.hashCode(this.ngaytao);
//        hash = 53 * hash + Objects.hashCode(this.nguoiDung);
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
//        final DonHang other = (DonHang) obj;
//        if (!Objects.equals(this.tendonhang, other.tendonhang)) {
//            return false;
//        }
//        if (!Objects.equals(this.madonhang, other.madonhang)) {
//            return false;
//        }
//        if (!Objects.equals(this.tongtien, other.tongtien)) {
//            return false;
//        }
//        if (!Objects.equals(this.tonggiamgia, other.tonggiamgia)) {
//            return false;
//        }
//        if (!Objects.equals(this.ngaytao, other.ngaytao)) {
//            return false;
//        }
//        return Objects.equals(this.nguoiDung, other.nguoiDung);
//    }

    
}
