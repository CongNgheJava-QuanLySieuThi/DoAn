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
 * @author Yuuta
 */
public class HangXuatKho implements Recordable, Serializable {

    private Long maHXK;
    private Long soluong;
    private LocalDateTime ngayXuat;
    private Long maSP;
    private String tenSP;

    public HangXuatKho() {
    }

    @Override
    public Object[] toRow() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new Object[]{
            this.maHXK,
            this.tenSP,
            this.soluong,
            this.ngayXuat == null ? "" : this.ngayXuat.format(formatter),
            this.maSP
        };
    }

    public HangXuatKho(Long id, Long soluong, LocalDateTime ngayXuat, Long maSP) {
        this.maHXK = id;
        this.soluong = soluong;
        this.ngayXuat = ngayXuat;
        this.maSP = maSP;
    }

    public Long getMaHXK() {
        return maHXK;
    }

    public void setMaHXK(Long maHXK) {
        this.maHXK = maHXK;
    }

    public Long getSoluong() {
        return soluong;
    }

    public void setSoluong(Long soluong) {
        this.soluong = soluong;
    }

    public LocalDateTime getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(LocalDateTime ngayXuat) {
        this.ngayXuat = ngayXuat;
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
