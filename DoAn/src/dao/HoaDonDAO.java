package dao;

import java.beans.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pojo.HoaDon;
import pojo.SQLServerDataProvider;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getLong("MaHD"));
                hd.setTenHoaDon(rs.getString("TenHoaDon"));
                hd.setPhuongThucMuaHang(rs.getString("PhuongThucMuaHang"));
                hd.setMaNguoiDung(rs.getLong("MaND"));
                hd.setNgayTao(rs.getTimestamp("NgayTao").toLocalDateTime());
                hd.setTongTien(rs.getDouble("TongTien"));
                dsHoaDon.add(hd);
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }

    public static Long themHoaDon(HoaDon hd) {
        Long maHoaDon = null;
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            
            String sql = "INSERT INTO HoaDon (TenHoaDon, PhuongThucMuaHang, MaND, NgayTao, TongTien) VALUES (?, ?, ?, ?, ?)";
            provider.open();
            Connection connection = provider.getConnection();

            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, hd.getTenHoaDon());
            pstmt.setString(2, hd.getPhuongThucMuaHang());
            pstmt.setLong(3, hd.getMaNguoiDung());
            pstmt.setTimestamp(4, Timestamp.valueOf(hd.getNgayTao()));
            pstmt.setDouble(5, hd.getTongTien());

            int n = pstmt.executeUpdate();
            if (n == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    maHoaDon = rs.getLong(1);
                }
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maHoaDon;
    }


    public static boolean xoaHoaDon(Long maHoaDon) {
        try {
            boolean kq = false;
            String sql = String.format("DELETE FROM HoaDon WHERE MaHD=%d", maHoaDon);
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
        boolean result = false;
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            String sql = "UPDATE HoaDon SET TenHoaDon = ?, PhuongThucMuaHang = ?, MaND = ?, NgayTao = ?, TongTien = ? WHERE MaHD = ?";
            provider.open();
            Connection connection = provider.getConnection();

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, hd.getTenHoaDon());
            pstmt.setString(2, hd.getPhuongThucMuaHang());
            pstmt.setLong(3, hd.getMaNguoiDung());
            pstmt.setTimestamp(4, Timestamp.valueOf(hd.getNgayTao()));
            pstmt.setDouble(5, hd.getTongTien());
            pstmt.setLong(6, hd.getMaHoaDon());

            int n = pstmt.executeUpdate();
            if (n == 1) {
                result = true;
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }


    public static ArrayList<HoaDon> layDanhSachHoaDonTheoNhanVien(Long maND) {
        ArrayList<HoaDon> dsHoaDon = new ArrayList<>();
        try {
            String sql = "SELECT * FROM HoaDon WHERE MaND = " + maND;
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getLong("MaHD"));
                hd.setTenHoaDon(rs.getString("TenHoaDon"));
                hd.setPhuongThucMuaHang(rs.getString("PhuongThucMuaHang"));
                hd.setMaNguoiDung(rs.getLong("MaND"));
                hd.setNgayTao(rs.getTimestamp("NgayTao").toLocalDateTime());
                hd.setTongTien(rs.getDouble("TongTien"));
                dsHoaDon.add(hd);
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }
}
