package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import pojo.DanhMuc;
import pojo.SQLServerDataProvider;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DanhMucDAO {
    public static ArrayList<DanhMuc> layDanhSachDanhMuc() {
        ArrayList<DanhMuc> dsDanhMuc = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DanhMuc";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setMaDanhMuc(rs.getLong("MaDanhMuc"));
                dm.setTenDanhMuc(rs.getString("TenDanhMuc"));
                dm.setNgayTao(rs.getTimestamp("NgayTao").toLocalDateTime());
                dsDanhMuc.add(dm);
            }
            provider.close();
        } catch(SQLException ex) {
        }
        return dsDanhMuc;
    }


    public static boolean themDanhMuc(DanhMuc dm) {
        try {
            boolean kq = false;
            String sql = String.format("INSERT INTO DanhMuc (TenDanhMuc) VALUES (N'%s')",
                    dm.getTenDanhMuc());
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean xoaDanhMuc(Long maDanhMuc) {
        try {
            boolean kq = false;
            String sql = String.format("DELETE FROM DanhMuc WHERE MaDanhMuc='%d'", maDanhMuc);
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean capNhatDanhMuc(DanhMuc dm) {
        try {
            boolean kq = false;
            String sql = String.format("UPDATE DanhMuc SET TenDanhMuc = N'%s'  WHERE MaDanhMuc= %d",
                    dm.getTenDanhMuc(), dm.getMaDanhMuc());
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
