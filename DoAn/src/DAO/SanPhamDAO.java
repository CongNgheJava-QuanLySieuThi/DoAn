package DAO;

import Pojo.SQLServerDataProvider;
import java.sql.ResultSet;
import java.util.ArrayList;
import Pojo.SanPham;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SanPhamDAO {
    public static ArrayList<SanPham> layDanhSachSanPham() {
        ArrayList<SanPham> dsSanPham = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SanPham";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getLong("MaSP"));
                sp.setTenSanPham(rs.getString("TenSP"));
                sp.setGia(rs.getBigDecimal("Gia"));
                sp.setGiamGia(rs.getInt("GiamGia"));
                sp.setHinhAnh(rs.getString("HinhAnh"));
                sp.setTuKhoa(rs.getString("TuKhoa"));
                sp.setMoTa(rs.getString("MoTa"));
                sp.setSoLuongTonKho(rs.getInt("SoLuongTonKho"));
                sp.setNgayTao(rs.getTimestamp("NgayTao").toLocalDateTime());
                sp.setNgayCapNhat(rs.getTimestamp("NgayCapNhat").toLocalDateTime());
                sp.setMaDanhMuc(rs.getLong("MaDanhMuc"));
                dsSanPham.add(sp);
            }
            provider.close();
        } catch(SQLException ex) {
        }
        return dsSanPham;
    }

    public static boolean themSanPham(SanPham sp) {
        try {
            boolean kq = false;
            String sql = String.format("INSERT INTO SanPham (TenSP, Gia, GiamGia, HinhAnh, TuKhoa, MoTa, SoLuongTonKho, NgayTao, NgayCapNhat, MaDanhMuc) VALUES ('%s', %f, %d, '%s', '%s', '%s', %d, '%s', '%s', %d)",
                    sp.getTenSanPham(), sp.getGia(), sp.getGiamGia(), sp.getHinhAnh(), sp.getTuKhoa(), sp.getMoTa(), sp.getSoLuongTonKho(), sp.getNgayTao(), sp.getNgayCapNhat(), sp.getMaDanhMuc());
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean xoaSanPham(Long maSP) {
        try {
            boolean kq = false;
            String sql = String.format("DELETE FROM SanPham WHERE MaSP='%d'", maSP);
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean capNhatSanPham(SanPham sp) {
        try {
            boolean kq = false;
            String sql = String.format("UPDATE SanPham SET TenSP = '%s', Gia = %f, GiamGia = %d, HinhAnh = '%s', TuKhoa = '%s', MoTa = '%s', SoLuongTonKho = %d, NgayTao = '%s', NgayCapNhat = '%s', MaDanhMuc = %d WHERE MaSP= %d",
                    sp.getTenSanPham(), sp.getGia(), sp.getGiamGia(), sp.getHinhAnh(), sp.getTuKhoa(), sp.getMoTa(), sp.getSoLuongTonKho(), sp.getNgayTao(), sp.getNgayCapNhat(), sp.getMaDanhMuc(), sp.getMaSanPham());
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
