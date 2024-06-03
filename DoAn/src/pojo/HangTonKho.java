/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Phi_Vu
 */
public class HangTonKho implements Recordable, Serializable {

    private static final long serialVersionUID = 1L;

    private Long maHTK;
    private Long soLuongTrongKho;
    private LocalDateTime ngayNhapHang;
    private LocalDateTime ngayXuatHang;
    private String trangThai;
    private Long maSP;
    private String tenSP;

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

    public HangTonKho(Long soLuongTrongKho) {
        this.soLuongTrongKho = soLuongTrongKho;
    }

    @Override
    public Object[] toRow() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new Object[]{
            this.maHTK,
            this.tenSP,
            this.soLuongTrongKho,
            this.ngayNhapHang == null ? "" : this.ngayNhapHang.format(formatter),
            this.ngayXuatHang == null ? "" : this.ngayXuatHang.format(formatter),
            this.maSP
        };
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

    public Long getMaSP() {
        return maSP;
    }

    public void setMaSP(Long maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
}
