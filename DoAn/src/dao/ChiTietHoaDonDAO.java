package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.ChiTietHoaDon;
import pojo.SQLServerDataProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ChiTietHoaDonDAO {

    public static ArrayList<ChiTietHoaDon> layDanhSachChiTietHoaDon() {
        ArrayList<ChiTietHoaDon> dsChiTietHoaDon = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ChiTietHoaDon";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMaChiTiet(rs.getInt("MaChiTiet"));
                cthd.setMaHD(rs.getLong("MaHD"));
                cthd.setMaSP(rs.getLong("MaSP"));
                cthd.setTenSP(rs.getString("TenSP"));
                cthd.setGia(rs.getDouble("Gia"));
                cthd.setGiamGia(rs.getDouble("GiamGia"));
                cthd.setSoLuongMua(rs.getInt("SoLuongMua"));
                cthd.setTongTien(rs.getDouble("TongTien"));
                dsChiTietHoaDon.add(cthd);
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsChiTietHoaDon;
    }

    public static boolean themChiTietHoaDon(ChiTietHoaDon cthd) {
        boolean result = false;
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            String sql = "INSERT INTO ChiTietHoaDon (MaHD, MaSP, TenSP, Gia, GiamGia, SoLuongMua, TongTien) VALUES (?, ?, ?, ?, ?, ?, ?)";
            provider.open();
            Connection connection = provider.getConnection();

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cthd.getMaHD());
            pstmt.setLong(2, cthd.getMaSP());
            pstmt.setString(3, cthd.getTenSP());
            pstmt.setDouble(4, cthd.getGia());
            pstmt.setDouble(5, cthd.getGiamGia());
            pstmt.setInt(6, cthd.getSoLuongMua());
            pstmt.setDouble(7, cthd.getTongTien());
            int n = pstmt.executeUpdate();
            if (n == 1) {
                result = true;
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }



    public static boolean xoaChiTietHoaDon(int maChiTiet) {
        try {
            boolean kq = false;
            String sql = String.format("DELETE FROM ChiTietHoaDon WHERE MaChiTiet=%d", maChiTiet);
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean capNhatChiTietHoaDon(ChiTietHoaDon cthd) {
        try {
            boolean kq = false;
            String sql = String.format("UPDATE ChiTietHoaDon SET MaHD = %d, MaSP = %d, TenSP = '%s', Gia = %.2f, GiamGia = %.2f, SoLuongMua = %d, TongTien = %.2f WHERE MaChiTiet = %d",
                    cthd.getMaHD(), cthd.getMaSP(), cthd.getTenSP(), cthd.getGia(), cthd.getGiamGia(), cthd.getSoLuongMua(), cthd.getTongTien(), cthd.getMaChiTiet());
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static ArrayList<ChiTietHoaDon> layDanhSachChiTietHoaDonTheoHoaDon(long maHD) {
        ArrayList<ChiTietHoaDon> dsChiTietHoaDon = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ChiTietHoaDon WHERE MaHD = " + maHD;
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMaChiTiet(rs.getInt("MaChiTiet"));
                cthd.setMaHD(rs.getLong("MaHD"));
                cthd.setMaSP(rs.getLong("MaSP"));
                cthd.setTenSP(rs.getString("TenSP"));
                cthd.setGia(rs.getDouble("Gia"));
                cthd.setGiamGia(rs.getDouble("GiamGia"));
                cthd.setSoLuongMua(rs.getInt("SoLuongMua"));
                cthd.setTongTien(rs.getDouble("TongTien"));
                dsChiTietHoaDon.add(cthd);
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsChiTietHoaDon;
    }
}
