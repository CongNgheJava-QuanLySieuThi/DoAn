package DAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import Pojo.NguoiDung;
import Pojo.SQLServerDataProvider;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NguoiDungDAO {
    public static ArrayList<NguoiDung> layDanhSachNguoiDung() {
        ArrayList<NguoiDung> dsNguoiDung = new ArrayList<>();
        try {
            String sql = "SELECT * FROM NguoiDung";
            SQLServerDataProvider provider = new SQLServerDataProvider();
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
            provider.close();
        } catch(SQLException ex) {
        }
        return dsNguoiDung;
    }

    public static boolean themNguoiDung(NguoiDung nd) {
        try {
            boolean kq = false;
            String sql = String.format("INSERT INTO NguoiDung (Ho, Ten, TenTaiKhoan, MatKhau, ChucVu, NgayTao, NgayCapNhat) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    nd.getHo(), nd.getTen(), nd.getTenTaiKhoan(), nd.getMatKhau(), nd.getChucVu(), nd.getNgayTao(), nd.getNgayCapNhat());
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
            String sql = String.format("UPDATE NguoiDung SET Ho = '%s', Ten = '%s', TenTaiKhoan = '%s', MatKhau = '%s', ChucVu = '%s', NgayTao = '%s', NgayCapNhat = '%s' WHERE MaND= %d",
                    nd.getHo(), nd.getTen(), nd.getTenTaiKhoan(), nd.getMatKhau(), nd.getChucVu(), nd.getNgayTao(), nd.getNgayCapNhat(), nd.getMaND());
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
}
