package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import Pojo.NguoiDung;
import Pojo.SQLServerDataProvider;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NguoiDungDAO {

    public NguoiDungDAO() {
        
    }
    
     public ArrayList<NguoiDung> layDanhSachNguoiDung() {
        ArrayList<NguoiDung> dsNguoiDung = new ArrayList<>();
        SQLServerDataProvider provider = null;
        try {
            String sql = "SELECT * FROM NguoiDung";
            provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setMaND(rs.getLong("MaND"));
                nd.setHo(rs.getString("Ho"));
                nd.setTen(rs.getString("Ten"));
                nd.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
                nd.setMatKhau(rs.getString("MatKhau"));
                nd.setChucVu(rs.getString("ChucVu"));
                nd.setNgayTao(rs.getTimestamp("NgayTao").toLocalDateTime());
                nd.setNgayCapNhat(rs.getTimestamp("NgayCapNhat").toLocalDateTime());
                dsNguoiDung.add(nd);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();  // Print the stack trace for debugging
        } finally {
            if (provider != null) {
                provider.close();
            }
        }
        return dsNguoiDung;
    }

    public static boolean themNguoiDung(NguoiDung nd) {
        try {
            boolean kq = false;
            String sql = String.format("INSERT INTO NguoiDung (Ho, Ten, TenTaiKhoan, MatKhau, ChucVu) VALUES (N'%s', N'%s', '%s', '%s', N'%s')",
                    nd.getHo(), nd.getTen(), nd.getTenTaiKhoan(), nd.getMatKhau(), nd.getChucVu());
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean xoaNguoiDung(Long maND) {
        try {
            boolean kq = false;
            String sql = String.format("DELETE FROM NguoiDung WHERE MaND='%d'", maND);
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean capNhatNguoiDung(NguoiDung nd) {
        try {
            boolean kq = false;
            String sql = String.format("UPDATE NguoiDung SET Ho = N'%s', Ten = N'%s', TenTaiKhoan = '%s', MatKhau = '%s', ChucVu = N'%s' WHERE MaND= %d",
                    nd.getHo(), nd.getTen(), nd.getTenTaiKhoan(), nd.getMatKhau(), nd.getChucVu(), nd.getMaND());
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            int n = provider.executeUpdate(sql);
            if (n == 1) {
                kq = true;
            }
            provider.close();
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static NguoiDung layThongTinNguoiDung(long maND) {
        NguoiDung nguoiDung = null;
        try {
            String sql = "SELECT * FROM NguoiDung WHERE MaND = ?";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            PreparedStatement ps = provider.getConnection().prepareStatement(sql);
            ps.setLong(1, maND);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nguoiDung = new NguoiDung();
                nguoiDung.setMaND(rs.getLong("MaND"));
                nguoiDung.setHo(rs.getString("Ho"));
                nguoiDung.setTen(rs.getString("Ten"));
                nguoiDung.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
                nguoiDung.setMatKhau(rs.getString("MatKhau"));
                nguoiDung.setChucVu(rs.getString("ChucVu"));
                nguoiDung.setNgayTao(rs.getTimestamp("NgayTao").toLocalDateTime());
                nguoiDung.setNgayCapNhat(rs.getTimestamp("NgayCapNhat").toLocalDateTime());
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nguoiDung;
    }
}
