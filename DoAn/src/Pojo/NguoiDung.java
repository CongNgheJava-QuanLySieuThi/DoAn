/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Nguyễn Kế Bảo
 */
public class NguoiDung implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long maND;
    private String ho;
    private String ten;
    private String tenTaiKhoan;
    private String matKhau;
    private String chucVu;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayCapNhat;

    public NguoiDung(
            Long maND,
            String ho,
            String ten,
            String tenTaiKhoan,
            String matKhau,
            String chucVu,
            LocalDateTime ngayTao,
            LocalDateTime ngayCapNhat) {
        this.maND = maND;
        this.ho = ho;
        this.ten = ten;
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public NguoiDung() {
    }

    public long getMaND() {
        return maND;
    }

    public void setMaND(long maND) {
        this.maND = maND;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.maND);
        hash = 97 * hash + Objects.hashCode(this.ho);
        hash = 97 * hash + Objects.hashCode(this.ten);
        hash = 97 * hash + Objects.hashCode(this.tenTaiKhoan);
        hash = 97 * hash + Objects.hashCode(this.matKhau);
        hash = 97 * hash + Objects.hashCode(this.chucVu);
        hash = 97 * hash + Objects.hashCode(this.ngayTao);
        hash = 97 * hash + Objects.hashCode(this.ngayCapNhat);
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
        final NguoiDung other = (NguoiDung) obj;
        if (!Objects.equals(this.ho, other.ho)) {
            return false;
        }
        if (!Objects.equals(this.ten, other.ten)) {
            return false;
        }
        if (!Objects.equals(this.tenTaiKhoan, other.tenTaiKhoan)) {
            return false;
        }
        if (!Objects.equals(this.matKhau, other.matKhau)) {
            return false;
        }
        if (!Objects.equals(this.chucVu, other.chucVu)) {
            return false;
        }
        if (!Objects.equals(this.maND, other.maND)) {
            return false;
        }
        if (!Objects.equals(this.ngayTao, other.ngayTao)) {
            return false;
        }
        return Objects.equals(this.ngayCapNhat, other.ngayCapNhat);
    }
}
