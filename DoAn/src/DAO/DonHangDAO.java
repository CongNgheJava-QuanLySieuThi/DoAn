package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import Pojo.DonHang;
import Pojo.SQLServerDataProvider;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        }
        return dsDonHang;
    }

    public static boolean themDonHang(DonHang dh) {
        try {
            boolean kq = false;
            String sql = String.format("INSERT INTO DonHang (Tendonhang, Tongtien, Tonggiamgia, Ngaytao, MaND) VALUES ('%s', %f, %f, '%s', %d)",
                    dh.getTendonhang(), dh.getTongtien(), dh.getTonggiamgia(), dh.getNgaytao(), dh.getMaNguoiDung());
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
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

    public static boolean xoaDonHang(Long maDonHang) {
        try {
            boolean kq = false;
            String sql = String.format("DELETE FROM DonHang WHERE Madonhang='%d'", maDonHang);
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
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
            String sql = String.format("UPDATE DonHang SET Tendonhang = '%s', Tongtien = %f, Tonggiamgia = %f, Ngaytao = '%s', MaND = %d WHERE Madonhang= %d",
                    dh.getTendonhang(), dh.getTongtien(), dh.getTonggiamgia(), dh.getNgaytao(), dh.getMaNguoiDung(), dh.getMadonhang());
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
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
}
