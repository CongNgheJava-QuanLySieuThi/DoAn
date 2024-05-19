package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import Pojo.HangTonKho;
import Pojo.SQLServerDataProvider;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HangTonKhoDAO {

    public static ArrayList<HangTonKho> layDanhSachHangTonKho() {
        ArrayList<HangTonKho> dsHangTonKho = new ArrayList<>();
        try {
            String sql = "SELECT * FROM HangTonKho";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                HangTonKho htk = new HangTonKho();
                htk.setMaHTK(rs.getLong("MaHTK"));
                htk.setSoLuongTrongKho(rs.getLong("SoLuongTrongKho"));
                htk.setNgayNhapHang(rs.getTimestamp("NgayNhapHang").toLocalDateTime());
                htk.setNgayXuatHang(rs.getTimestamp("NgayXuatHang").toLocalDateTime());
                htk.setTrangThai(rs.getString("TrangThai"));
                htk.setMaSanPham(rs.getLong("MaSP"));
                dsHangTonKho.add(htk);
            }
            provider.close();
        } catch (SQLException ex) {
        }
        return dsHangTonKho;
    }

    public static boolean themHangTonKho(HangTonKho htk) {
        try {
            boolean kq = false;
            String sql = String.format("INSERT INTO HangTonKho (SoLuongTrongKho, NgayNhapHang, NgayXuatHang, TrangThai, MaSP) VALUES (%d, '%s', '%s', '%s', %d)",
                    htk.getSoLuongTrongKho(), htk.getNgayNhapHang(), htk.getNgayXuatHang(), htk.getTrangThai(), htk.getMaSanPham());
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(HangTonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean xoaHangTonKho(Long maHTK) {
        try {
            boolean kq = false;
            String sql = String.format("DELETE FROM HangTonKho WHERE MaHTK='%d'", maHTK);
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(HangTonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean capNhatHangTonKho(HangTonKho htk) {
        try {
            boolean kq = false;
            String sql = String.format("UPDATE HangTonKho SET SoLuongTrongKho = %d, NgayNhapHang = '%s', NgayXuatHang = '%s', TrangThai = '%s', MaSP = %d WHERE MaHTK= %d",
                    htk.getSoLuongTrongKho(), htk.getNgayNhapHang(), htk.getNgayXuatHang(), htk.getTrangThai(), htk.getMaSanPham(), htk.getMaHTK());
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(HangTonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
