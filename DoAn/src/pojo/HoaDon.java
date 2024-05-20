/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Phi_Vu
 */
public class HoaDon implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long maHD;
    private String tenHoaDon;
    private String phuongThucMuaHang;
    private Long maDonHang;
    private Long maND;
    private LocalDateTime ngayTao;

    public HoaDon() {
    }

    public HoaDon(
            Long maHD,
            String tenHoaDon,
            String phuongThucMuaHang,
            Long maDonHang,
            Long maND,
            LocalDateTime ngayTao) {
        this.maHD = maHD;
        this.tenHoaDon = tenHoaDon;
        this.phuongThucMuaHang = phuongThucMuaHang;
        this.maDonHang = maDonHang;
        this.maND = maND;
        this.ngayTao = ngayTao;
    }

    public Long getMaHoaDon() {
        return maHD;
    }

    public void setMaHoaDon(Long maHD) {
        this.maHD = maHD;
    }

    public String getTenHoaDon() {
        return tenHoaDon;
    }

    public void setTenHoaDon(String tenHoaDon) {
        this.tenHoaDon = tenHoaDon;
    }

    public String getPhuongThucMuaHang() {
        return phuongThucMuaHang;
    }

    public void setPhuongThucMuaHang(String phuongThucMuaHang) {
        this.phuongThucMuaHang = phuongThucMuaHang;
    }

    public Long getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(Long maDonHang) {
        this.maDonHang = maDonHang;
    }

    public Long getMaNguoiDung() {
        return maND;
    }

    public void setMaNguoiDung(Long maND) {
        this.maND = maND;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

}
