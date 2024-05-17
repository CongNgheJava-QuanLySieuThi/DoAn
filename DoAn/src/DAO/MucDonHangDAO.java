package DAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import Pojo.MucDonHang;
import Pojo.SQLServerDataProvider;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MucDonHangDAO {
    public static ArrayList<MucDonHang> layDanhSachMucDonHang() {
        ArrayList<MucDonHang> dsMucDonHang = new ArrayList<>();
        try {
            String sql = "SELECT * FROM MucDonHang";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()) {
                MucDonHang mdh = new MucDonHang();
                mdh.setMaMuc(rs.getLong("MaMuc"));
                mdh.setSoLuong(rs.getInt("SoLuong"));
                mdh.setGiaHienTai(rs.getBigDecimal("GiaHienTai"));
                mdh.setGiamGiaHienTai(rs.getBigDecimal("GiamGiaHienTai"));
                mdh.setMaDonHang(rs.getLong("MaDonHang"));
                mdh.setMaSanPham(rs.getLong("MaSanPham"));
                dsMucDonHang.add(mdh);
            }
            provider.close();
        } catch(SQLException ex) {
        }
        return dsMucDonHang;
    }

    public static boolean themMucDonHang(MucDonHang mdh) {
        try {
            boolean kq = false;
            String sql = String.format("INSERT INTO MucDonHang (SoLuong, GiaHienTai, GiamGiaHienTai, MaDonHang, MaSanPham) VALUES (%d, %f, %f, %d, %d)",
                    mdh.getSoLuong(), mdh.getGiaHienTai(), mdh.getGiamGiaHienTai(), mdh.getMaDonHang(), mdh.getMaSanPham());
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(MucDonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean xoaMucDonHang(Long maMuc) {
        try {
            boolean kq = false;
            String sql = String.format("DELETE FROM MucDonHang WHERE MaMuc='%d'", maMuc);
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(MucDonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean capNhatMucDonHang(MucDonHang mdh) {
        try {
            boolean kq = false;
            String sql = String.format("UPDATE MucDonHang SET SoLuong = %d, GiaHienTai = %f, GiamGiaHienTai = %f, MaDonHang = %d, MaSanPham = %d WHERE MaMuc= %d",
                    mdh.getSoLuong(), mdh.getGiaHienTai(), mdh.getGiamGiaHienTai(), mdh.getMaDonHang(), mdh.getMaSanPham(), mdh.getMaMuc());
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(MucDonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
