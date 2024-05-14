/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Phi_Vu
 */
public class DanhMuc implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long maDanhMuc;

    private String tenDanhMuc;

    private LocalDateTime ngayTao;

    public DanhMuc() {
    }

    public DanhMuc(Long maDanhMuc, String tenDanhMuc, LocalDateTime ngayTao) {
        this.maDanhMuc = maDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.ngayTao = ngayTao;
    }

    public Long getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(Long maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.maDanhMuc);
        hash = 59 * hash + Objects.hashCode(this.tenDanhMuc);
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
        final DanhMuc other = (DanhMuc) obj;
        if (!Objects.equals(this.tenDanhMuc, other.tenDanhMuc)) {
            return false;
        }
        if (!Objects.equals(this.maDanhMuc, other.maDanhMuc)) {
            return false;
        }
        return Objects.equals(this.ngayTao, other.ngayTao);
    }

}
