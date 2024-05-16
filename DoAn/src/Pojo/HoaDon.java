/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Phi_Vu
 */
public class HoaDon implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long maHoaDon;
    private String tenHoaDon;
    private String phuongThucMuaHang;
    private DonHang donHang;
    private NguoiDung nguoiDung;
    private LocalDateTime ngayTao;

    public HoaDon() {
    }

    public HoaDon(
            Long maHoaDon,
            String tenHoaDon,
            String phuongThucMuaHang,
            DonHang donHang,
            NguoiDung nguoiDung,
            LocalDateTime ngayTao) {
        this.maHoaDon = maHoaDon;
        this.tenHoaDon = tenHoaDon;
        this.phuongThucMuaHang = phuongThucMuaHang;
        this.donHang = donHang;
        this.nguoiDung = nguoiDung;
        this.ngayTao = ngayTao;
    }

    public Long getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(Long maHoaDon) {
        this.maHoaDon = maHoaDon;
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

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.maHoaDon);
        hash = 59 * hash + Objects.hashCode(this.tenHoaDon);
        hash = 59 * hash + Objects.hashCode(this.phuongThucMuaHang);
        hash = 59 * hash + Objects.hashCode(this.donHang);
        hash = 59 * hash + Objects.hashCode(this.nguoiDung);
        hash = 59 * hash + Objects.hashCode(this.ngayTao);
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
        final HoaDon other = (HoaDon) obj;
        if (!Objects.equals(this.tenHoaDon, other.tenHoaDon)) {
            return false;
        }
        if (!Objects.equals(this.phuongThucMuaHang, other.phuongThucMuaHang)) {
            return false;
        }
        if (!Objects.equals(this.maHoaDon, other.maHoaDon)) {
            return false;
        }
        if (!Objects.equals(this.donHang, other.donHang)) {
            return false;
        }
        if (!Objects.equals(this.nguoiDung, other.nguoiDung)) {
            return false;
        }
        return Objects.equals(this.ngayTao, other.ngayTao);
    }

}
