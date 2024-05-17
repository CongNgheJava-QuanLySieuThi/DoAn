package dao;

import Pojo.HangTonKho;
import Pojo.SQLServerDataProvider;
import Pojo.SanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HangTonKhoDAO {
    private SQLServerDataProvider dataProvider;

    public HangTonKhoDAO(SQLServerDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    // Thêm hàng tồn kho vào cơ sở dữ liệu
    public void addHangTonKho(HangTonKho hangTonKho) throws SQLException {
        String query = "INSERT INTO HangTonKho (maHTK, soLuongTrongKho, ngayNhapHang, ngayXuatHang, trangThai, maSanPham) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, hangTonKho.getMaHTK());
            statement.setLong(2, hangTonKho.getSoLuongTrongKho());
            statement.setObject(3, hangTonKho.getNgayNhapHang());
            statement.setObject(4, hangTonKho.getNgayXuatHang());
            statement.setString(5, hangTonKho.getTrangThai());
            statement.setLong(6, hangTonKho.getMaSanPham());
            statement.executeUpdate();
        }
    }

    // Cập nhật thông tin hàng tồn kho trong cơ sở dữ liệu
    public void updateHangTonKho(HangTonKho hangTonKho) throws SQLException {
        String query = "UPDATE HangTonKho SET soLuongTrongKho=?, ngayNhapHang=?, ngayXuatHang=?, trangThai=?, maSanPham=? WHERE maHTK=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, hangTonKho.getSoLuongTrongKho());
            statement.setObject(2, hangTonKho.getNgayNhapHang());
            statement.setObject(3, hangTonKho.getNgayXuatHang());
            statement.setString(4, hangTonKho.getTrangThai());
            statement.setLong(5, hangTonKho.getMaSanPham());
            statement.setLong(6, hangTonKho.getMaHTK());
            statement.executeUpdate();
        }
    }

    // Xóa hàng tồn kho từ cơ sở dữ liệu
    public void deleteHangTonKho(long maHTK) throws SQLException {
        String query = "DELETE FROM HangTonKho WHERE maHTK=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, maHTK);
            statement.executeUpdate();
        }
    }

    // Lấy thông tin của một hàng tồn kho dựa trên mã hàng tồn kho
    public HangTonKho getHangTonKhoById(long maHTK) throws SQLException {
        String query = "SELECT * FROM HangTonKho WHERE maHTK=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, maHTK);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractHangTonKhoFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    // Lấy danh sách tất cả hàng tồn kho từ cơ sở dữ liệu
    public List<HangTonKho> getAllHangTonKho() throws SQLException {
        List<HangTonKho> hangTonKhoList = new ArrayList<>();
        String query = "SELECT * FROM HangTonKho";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                HangTonKho hangTonKho = extractHangTonKhoFromResultSet(resultSet);
                hangTonKhoList.add(hangTonKho);
            }
        }
        return hangTonKhoList;
    }

    // Phương thức hỗ trợ trích xuất thông tin hàng tồn kho từ ResultSet
    private HangTonKho extractHangTonKhoFromResultSet(ResultSet resultSet) throws SQLException {
        long maHTK = resultSet.getLong("maHTK");
        long soLuongTrongKho = resultSet.getLong("soLuongTrongKho");
        LocalDateTime ngayNhapHang = resultSet.getObject("ngayNhapHang", LocalDateTime.class);
        LocalDateTime ngayXuatHang = resultSet.getObject("ngayXuatHang", LocalDateTime.class);
        String trangThai = resultSet.getString("trangThai");

        // Lấy thông tin sản phẩm từ cơ sở dữ liệu hoặc các thông tin liên quan
        long maSanPham = resultSet.getLong("maSanPham");
        

        HangTonKho hangTonKho = new HangTonKho(maHTK, soLuongTrongKho, ngayNhapHang, ngayXuatHang, trangThai, maSanPham);
        return hangTonKho;
    }
}
