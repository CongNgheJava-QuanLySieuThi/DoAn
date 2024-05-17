package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import Pojo.HoaDon;
import Pojo.SQLServerDataProvider;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDonDAO {
    public static ArrayList<HoaDon> layDanhSachHoaDon() {
        ArrayList<HoaDon> dsHoaDon = new ArrayList<>();
        try {
            String sql = "SELECT * FROM HoaDon";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getLong("MaHD"));
                hd.setTenHoaDon(rs.getString("TenHoaDon"));
                hd.setPhuongThucMuaHang(rs.getString("PhuongThucMuaHang"));
                hd.setMaDonHang(rs.getLong("MaDonHang"));
                hd.setMaNguoiDung(rs.getLong("MaND"));
                hd.setNgayTao(rs.getTimestamp("NgayTao").toLocalDateTime());
                dsHoaDon.add(hd);
            }
            provider.close();
        } catch(SQLException ex) {
        }
        return dsHoaDon;
    }

    public static boolean themHoaDon(HoaDon hd) {
        try {
            boolean kq = false;
            String sql = String.format("INSERT INTO HoaDon (TenHoaDon, PhuongThucMuaHang, MaDonHang, MaND, NgayTao) VALUES ('%s', '%s', %d, %d, '%s')",
                    hd.getTenHoaDon(), hd.getPhuongThucMuaHang(), hd.getMaDonHang(), hd.getMaNguoiDung(), hd.getNgayTao());
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean xoaHoaDon(Long maHoaDon) {
        try {
            boolean kq = false;
            String sql = String.format("DELETE FROM HoaDon WHERE MaHD='%d'", maHoaDon);
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean capNhatHoaDon(HoaDon hd) {
        try {
            boolean kq = false;
            String sql = String.format("UPDATE HoaDon SET TenHoaDon = '%s', PhuongThucMuaHang = '%s', MaDonHang = %d, MaND = %d, NgayTao = '%s' WHERE MaHD= %d",
                    hd.getTenHoaDon(), hd.getPhuongThucMuaHang(), hd.getMaDonHang(), hd.getMaNguoiDung(), hd.getNgayTao(), hd.getMaHoaDon());
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
