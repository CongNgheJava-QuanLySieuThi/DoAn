package pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Yuuta
 */
public class HangNhapKho implements Recordable, Serializable {

    private Long maHNK;
    private Long soluong;
    private LocalDateTime ngayNhap;
    private Long maSP;
    private String tenSP;

    public HangNhapKho() {
    }

    public HangNhapKho(Long id, Long soluong, LocalDateTime ngayXuat, Long maSP) {
        this.maHNK = id;
        this.soluong = soluong;
        this.ngayNhap = ngayXuat;
        this.maSP = maSP;
    }

    @Override
    public Object[] toRow() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new Object[]{
            this.maHNK,
            this.tenSP,
            this.soluong,
            this.ngayNhap == null ? "" : this.ngayNhap.format(formatter),
            this.maSP
        };
    }

    public Long getMaHNK() {
        return maHNK;
    }

    public void setMaHNK(Long maHNK) {
        this.maHNK = maHNK;
    }

    public Long getSoluong() {
        return soluong;
    }

    public void setSoluong(Long soluong) {
        this.soluong = soluong;
    }

    public LocalDateTime getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDateTime ngayNhap) {
        this.ngayNhap = ngayNhap;
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
