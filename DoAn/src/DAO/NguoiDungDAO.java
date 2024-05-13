package DAO;

import Pojo.SQLServerDataProvider;
import Pojo.NguoiDung;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class NguoiDungDAO {
    
    public static ArrayList<NguoiDung> layDanhSachNguoiDung() throws SQLException {
        ArrayList<NguoiDung> dsND = new ArrayList<>();
        SQLServerDataProvider provider = new SQLServerDataProvider(); // Tạo đối tượng SQLServerDataProvider
        
        try {
            provider.open(); // Mở kết nối tới cơ sở dữ liệu
            
            String sql = "SELECT * FROM NguoiDung";
            ResultSet rs = provider.executeQuery(sql); // Thực thi truy vấn SELECT
            
            while (rs.next()) {
                // Lấy thông tin từ ResultSet và tạo đối tượng NguoiDung tương ứng
                long maND = rs.getLong("maND");
                String ho = rs.getString("ho");
                String ten = rs.getString("ten");
                String tenTaiKhoan = rs.getString("tenTaiKhoan");
                String matKhau = rs.getString("matKhau");
                String chucVu = rs.getString("chucVu");
                // Lấy ngày tạo và ngày cập nhật từ cơ sở dữ liệu
                java.sql.Timestamp ngayTaoTimestamp = rs.getTimestamp("ngayTao");
                java.sql.Timestamp ngayCapNhatTimestamp = rs.getTimestamp("ngayCapNhat");
                // Chuyển đổi Timestamp thành LocalDateTime
                LocalDateTime ngayTao = ngayTaoTimestamp.toLocalDateTime();
                LocalDateTime ngayCapNhat = ngayCapNhatTimestamp.toLocalDateTime();
                
                // Tạo đối tượng NguoiDung và thêm vào danh sách
                NguoiDung user = new NguoiDung(maND, ho, ten, tenTaiKhoan, matKhau, chucVu, ngayTao, ngayCapNhat);
                dsND.add(user);
            }
        } catch (SQLException ex) {
            
        } finally {
            provider.close(); // Đóng kết nối sau khi hoàn thành công việc
        }
    
        return dsND;
    }
    // Tương tự cho các phương thức CRUD khác (thêm, sửa, xóa)
}