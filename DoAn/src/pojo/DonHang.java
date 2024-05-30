/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private int TrangThai;

    public DonHang() {
    }
    
    public DonHang(String tendonhang, BigDecimal tongtien, BigDecimal tonggiamgia, LocalDateTime ngaytao, int TrangThai) {
        this.tendonhang = tendonhang;
        this.tongtien = tongtien;
        this.tonggiamgia = tonggiamgia;
        this.ngaytao = ngaytao;
        this.TrangThai = TrangThai;
    }   

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }





    public Object[] toRow() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new Object[]{
            this.madonhang,
            this.tendonhang,
            this.tongtien,
            this.tonggiamgia,
            this.ngaytao.format(formatter),
            this.maND,
            this.TrangThai
        };
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
}
