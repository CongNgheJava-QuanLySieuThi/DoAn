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

    public HangTonKho(Long soLuongTrongKho, LocalDateTime ngayNhapHang, String trangThai) {
        this.soLuongTrongKho = soLuongTrongKho;
        this.ngayNhapHang = ngayNhapHang;
        this.trangThai = trangThai;
    }

    public Object[] toRow() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        return new Object[]{
            this.maHTK,
            this.soLuongTrongKho,
            this.ngayNhapHang == null ? "" : this.ngayNhapHang.format(formatter),
            this.ngayXuatHang == null ? "" : this.ngayXuatHang.format(formatter),
            this.trangThai
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
}
