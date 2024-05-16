package DAO;

import Pojo.NguoiDung;
import Pojo.SQLServerDataProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {
    private SQLServerDataProvider dataProvider;

    public NguoiDungDAO(SQLServerDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }
    
    // Thêm người dùng vào cơ sở dữ liệu
    public void addNguoiDung(NguoiDung nguoiDung) throws SQLException {
        String query = "INSERT INTO NguoiDung (maND, ho, ten, tenTaiKhoan, matKhau, chucVu, ngayTao, ngayCapNhat) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, nguoiDung.getMaND());
            statement.setString(2, nguoiDung.getHo());
            statement.setString(3, nguoiDung.getTen());
            statement.setString(4, nguoiDung.getTenTaiKhoan());
            statement.setString(5, nguoiDung.getMatKhau());
            statement.setString(6, nguoiDung.getChucVu());
            statement.setObject(7, nguoiDung.getNgayTao());
            statement.setObject(8, nguoiDung.getNgayCapNhat());
            statement.executeUpdate();
        }
    }

    // Cập nhật thông tin người dùng trong cơ sở dữ liệu
    public void updateNguoiDung(NguoiDung nguoiDung) throws SQLException {
        String query = "UPDATE NguoiDung SET ho=?, ten=?, tenTaiKhoan=?, matKhau=?, chucVu=?, ngayCapNhat=? WHERE maND=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nguoiDung.getHo());
            statement.setString(2, nguoiDung.getTen());
            statement.setString(3, nguoiDung.getTenTaiKhoan());
            statement.setString(4, nguoiDung.getMatKhau());
            statement.setString(5, nguoiDung.getChucVu());
            statement.setObject(6, nguoiDung.getNgayCapNhat());
            statement.setLong(7, nguoiDung.getMaND());
            statement.executeUpdate();
        }
    }

    // Xóa người dùng từ cơ sở dữ liệu
    public void deleteNguoiDung(long maND) throws SQLException {
        String query = "DELETE FROM NguoiDung WHERE maND=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, maND);
            statement.executeUpdate();
        }
    }

    // Lấy thông tin của một người dùng dựa trên mã người dùng
    public NguoiDung getNguoiDungById(long maND) throws SQLException {
        String query = "SELECT * FROM NguoiDung WHERE maND=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, maND);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractNguoiDungFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    // Lấy danh sách tất cả người dùng từ cơ sở dữ liệu
    public List<NguoiDung> getAllNguoiDung() throws SQLException {
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        String query = "SELECT * FROM NguoiDung";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                NguoiDung nguoiDung = extractNguoiDungFromResultSet(resultSet);
                nguoiDungList.add(nguoiDung);
            }
        }
        return nguoiDungList;
    }

    // Phương thức hỗ trợ trích xuất thông tin người dùng từ ResultSet
    private NguoiDung extractNguoiDungFromResultSet(ResultSet resultSet) throws SQLException {
        long maND = resultSet.getLong("maND");
        String ho = resultSet.getString("ho");
        String ten = resultSet.getString("ten");
        String tenTaiKhoan = resultSet.getString("tenTaiKhoan");
        String matKhau = resultSet.getString("matKhau");
        String chucVu = resultSet.getString("chucVu");
        LocalDateTime ngayTao = resultSet.getObject("ngayTao", LocalDateTime.class);
        LocalDateTime ngayCapNhat = resultSet.getObject("ngayCapNhat", LocalDateTime.class);

        return new NguoiDung(maND, ho, ten, tenTaiKhoan, matKhau, chucVu, ngayTao, ngayCapNhat);
    }
}
