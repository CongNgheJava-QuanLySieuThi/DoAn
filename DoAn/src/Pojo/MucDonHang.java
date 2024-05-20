/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Phi_Vu
 */
public class MucDonHang implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long maMuc;
    private Integer soLuong;
    private BigDecimal giaHienTai;
    private BigDecimal giamGiaHienTai;
    private Long maDonHang;
    private Long maSanPham;

    
    public MucDonHang(
            Long maMuc,
            Integer soLuong,
            BigDecimal giaHienTai,
            BigDecimal giamGiaHienTai,
            Long maDonHang,
            Long maSanPham) {
        this.maMuc = maMuc;
        this.soLuong = soLuong;
        this.giaHienTai = giaHienTai;
        this.giamGiaHienTai = giamGiaHienTai;
        this.maDonHang = maDonHang;
        this.maSanPham = maSanPham;
    }
    public MucDonHang(
            Integer soLuong,
            BigDecimal giaHienTai,
            BigDecimal giamGiaHienTai,
            Long maDonHang,
            Long maSanPham) {
        this.soLuong = soLuong;
        this.giaHienTai = giaHienTai;
        this.giamGiaHienTai = giamGiaHienTai;
        this.maDonHang = maDonHang;
        this.maSanPham = maSanPham;
    }
    public MucDonHang() {
    }

    public Long getMaMuc() {
        return maMuc;
    }

    public void setMaMuc(Long maMuc) {
        this.maMuc = maMuc;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaHienTai() {
        return giaHienTai;
    }

    public void setGiaHienTai(BigDecimal giaHienTai) {
        this.giaHienTai = giaHienTai;
    }

    public BigDecimal getGiamGiaHienTai() {
        return giamGiaHienTai;
    }

    public void setGiamGiaHienTai(BigDecimal giamGiaHienTai) {
        this.giamGiaHienTai = giamGiaHienTai;
    }

    public Long getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(Long maDonHang) {
        this.maDonHang = maDonHang;
    }

    public Long getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(Long maSanPham) {
        this.maSanPham = maSanPham;
    }

}
