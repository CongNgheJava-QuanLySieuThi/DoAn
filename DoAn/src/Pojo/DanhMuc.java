/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojo;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Phi_Vu
 */
public class DanhMuc implements Serializable {

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

}
