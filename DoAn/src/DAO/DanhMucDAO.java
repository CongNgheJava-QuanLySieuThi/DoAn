package DAO;

import Pojo.DanhMuc;
import Pojo.SQLServerDataProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DanhMucDAO {
    private SQLServerDataProvider dataProvider;

    public DanhMucDAO(SQLServerDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    // Thêm danh mục vào cơ sở dữ liệu
    public void addDanhMuc(DanhMuc danhMuc) throws SQLException {
        String query = "INSERT INTO DanhMuc (maDanhMuc, tenDanhMuc, ngayTao) VALUES (?, ?, ?)";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, danhMuc.getMaDanhMuc());
            statement.setString(2, danhMuc.getTenDanhMuc());
            statement.setObject(3, danhMuc.getNgayTao());
            statement.executeUpdate();
        }
    }

    // Cập nhật thông tin danh mục trong cơ sở dữ liệu
    public void updateDanhMuc(DanhMuc danhMuc) throws SQLException {
        String query = "UPDATE DanhMuc SET tenDanhMuc=?, ngayTao=? WHERE maDanhMuc=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, danhMuc.getTenDanhMuc());
            statement.setObject(2, danhMuc.getNgayTao());
            statement.setLong(3, danhMuc.getMaDanhMuc());
            statement.executeUpdate();
        }
    }

    // Xóa danh mục từ cơ sở dữ liệu
    public void deleteDanhMuc(Long maDanhMuc) throws SQLException {
        String query = "DELETE FROM DanhMuc WHERE maDanhMuc=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, maDanhMuc);
            statement.executeUpdate();
        }
    }

    // Lấy thông tin của một danh mục dựa trên mã danh mục
    public DanhMuc getDanhMucById(Long maDanhMuc) throws SQLException {
        String query = "SELECT * FROM DanhMuc WHERE maDanhMuc=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, maDanhMuc);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractDanhMucFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    // Lấy danh sách tất cả danh mục từ cơ sở dữ liệu
    public List<DanhMuc> getAllDanhMuc() throws SQLException {
        List<DanhMuc> danhMucList = new ArrayList<>();
        String query = "SELECT * FROM DanhMuc";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                DanhMuc danhMuc = extractDanhMucFromResultSet(resultSet);
                danhMucList.add(danhMuc);
            }
        }
        return danhMucList;
    }

    // Phương thức hỗ trợ trích xuất thông tin danh mục từ ResultSet
    private DanhMuc extractDanhMucFromResultSet(ResultSet resultSet) throws SQLException {
        Long maDanhMuc = resultSet.getLong("maDanhMuc");
        String tenDanhMuc = resultSet.getString("tenDanhMuc");
        LocalDateTime ngayTao = resultSet.getObject("ngayTao", LocalDateTime.class);
        return new DanhMuc(maDanhMuc, tenDanhMuc, ngayTao);
    }
}
