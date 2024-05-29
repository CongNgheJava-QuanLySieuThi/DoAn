package dao;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.DonHang;
import pojo.SQLServerDataProvider;

public class DonHangDAO {

    public static ArrayList<DonHang> layDanhSachDonHang() {
        ArrayList<DonHang> dsDonHang = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DonHang";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                DonHang dh = new DonHang();
                dh.setMadonhang(rs.getLong("Madonhang"));
                dh.setTendonhang(rs.getString("Tendonhang"));
                dh.setTongtien(rs.getBigDecimal("Tongtien"));
                dh.setTonggiamgia(rs.getBigDecimal("Tonggiamgia"));
                dh.setNgaytao(rs.getTimestamp("Ngaytao").toLocalDateTime());
                dh.setMaNguoiDung(rs.getLong("MaND"));
                dsDonHang.add(dh);
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDonHang;
    }

    public static boolean themDonHang(DonHang dh) {
    SQLServerDataProvider provider = new SQLServerDataProvider();
    try {
        boolean kq = false;
        String sql = "INSERT INTO DonHang (Tendonhang, Tongtien, Tonggiamgia, Ngaytao, MaND, TrangThai) VALUES (?, ?, ?, ?, ?, ?)";

        provider.open();
        PreparedStatement pstmt = provider.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        pstmt.setString(1, dh.getTendonhang());
        pstmt.setBigDecimal(2, dh.getTongtien());
        pstmt.setBigDecimal(3, dh.getTonggiamgia());
        pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(dh.getNgaytao()));
        pstmt.setLong(5, dh.getMaNguoiDung());
        pstmt.setInt(6, dh.getTrangThai());

        int n = pstmt.executeUpdate();

        if (n == 1) {
            kq = true;

            // Lấy mã đơn hàng tự động tăng
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                dh.setMadonhang(generatedKeys.getLong(1));
            }
        }

        provider.close();
        return kq;
    } catch (SQLException ex) {
        Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        provider.close();
    }
    return false;
}
    public static boolean xoaDonHang(Long maDonHang) {
        try {
            boolean kq = false;
            String sql = "DELETE FROM DonHang WHERE Madonhang=?";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();

            PreparedStatement pstmt = provider.getConnection().prepareStatement(sql);
            pstmt.setLong(1, maDonHang);

            int n = pstmt.executeUpdate();
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean capNhatDonHang(DonHang dh) {
        try {
            boolean kq = false;
            String sql = "UPDATE DonHang SET Tendonhang=?, Tongtien=?, Tonggiamgia=?, Ngaytao=?, MaND=?, TrangThai = ? WHERE Madonhang=?";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();

            PreparedStatement pstmt = provider.getConnection().prepareStatement(sql);
            pstmt.setString(1, dh.getTendonhang());
            pstmt.setBigDecimal(2, dh.getTongtien());
            pstmt.setBigDecimal(3, dh.getTonggiamgia());
            pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(dh.getNgaytao()));
            pstmt.setLong(5, dh.getMaNguoiDung());
            pstmt.setLong(6, dh.getTrangThai());
            pstmt.setLong(7, dh.getMadonhang());

            int n = pstmt.executeUpdate();
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static ArrayList<DonHang> layDanhSachDonHangCuaNguoiDung(Long maNguoiDung) {
        ArrayList<DonHang> dsDonHang = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DonHang WHERE MaND = ?";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();

            PreparedStatement pstmt = provider.getConnection().prepareStatement(sql);
            pstmt.setLong(1, maNguoiDung);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                DonHang dh = new DonHang();
                dh.setMadonhang(rs.getLong("Madonhang"));
                dh.setTendonhang(rs.getString("Tendonhang"));
                dh.setTongtien(rs.getBigDecimal("Tongtien"));
                dh.setTonggiamgia(rs.getBigDecimal("Tonggiamgia"));
                dh.setNgaytao(rs.getTimestamp("Ngaytao").toLocalDateTime());
                dh.setMaNguoiDung(rs.getLong("MaND"));
                dh.setTrangThai(rs.getInt("TrangThai"));
                dsDonHang.add(dh);
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDonHang;
    }
}
