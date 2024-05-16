/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Nguyễn Kế Bảo
 */
import Pojo.DonHang;
import Pojo.NguoiDung;
import Pojo.SQLServerDataProvider;
import java.math.BigDecimal;
import DAO.NguoiDungDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DonHangDAO {
    private SQLServerDataProvider dataProvider;

    public DonHangDAO(SQLServerDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }
    // Thêm đơn hàng vào cơ sở dữ liệu
    public void addDonHang(DonHang donHang) throws SQLException {
        String query = "INSERT INTO DonHang (madonhang, tendonhang, tongtien, tonggiamgia, ngaytao, maNguoiDung) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, donHang.getMadonhang());
            statement.setString(2, donHang.getTendonhang());
            statement.setBigDecimal(3, donHang.getTongtien());
            statement.setBigDecimal(4, donHang.getTonggiamgia());
            statement.setObject(5, donHang.getNgaytao());
            statement.setLong(6, donHang.getNguoiDung().getMaND()); // Assuming maNguoiDung is the foreign key in DonHang table
            statement.executeUpdate();
        }
    }

    // Cập nhật thông tin đơn hàng trong cơ sở dữ liệu
    public void updateDonHang(DonHang donHang) throws SQLException {
        String query = "UPDATE DonHang SET tendonhang=?, tongtien=?, tonggiamgia=?, ngaytao=?, maNguoiDung=? WHERE madonhang=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, donHang.getTendonhang());
            statement.setBigDecimal(2, donHang.getTongtien());
            statement.setBigDecimal(3, donHang.getTonggiamgia());
            statement.setObject(4, donHang.getNgaytao());
            statement.setLong(5, donHang.getNguoiDung().getMaND());
            statement.setLong(6, donHang.getMadonhang());
            statement.executeUpdate();
        }
    }

    // Xóa đơn hàng từ cơ sở dữ liệu
    public void deleteDonHang(Long madonhang) throws SQLException {
        String query = "DELETE FROM DonHang WHERE madonhang=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, madonhang);
            statement.executeUpdate();
        }
    }

    // Lấy thông tin của một đơn hàng dựa trên mã đơn hàng
    public DonHang getDonHangById(Long madonhang) throws SQLException {
        String query = "SELECT * FROM DonHang WHERE madonhang=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, madonhang);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractDonHangFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    // Lấy danh sách tất cả đơn hàng từ cơ sở dữ liệu
    public List<DonHang> getAllDonHang() throws SQLException {
        List<DonHang> donHangList = new ArrayList<>();
        String query = "SELECT * FROM DonHang";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                DonHang donHang = extractDonHangFromResultSet(resultSet);
                donHangList.add(donHang);
            }
        }
        return donHangList;
    }

    // Phương thức hỗ trợ trích xuất thông tin đơn hàng từ ResultSet
    private DonHang extractDonHangFromResultSet(ResultSet resultSet) throws SQLException {
        Long madonhang = resultSet.getLong("madonhang");
        String tendonhang = resultSet.getString("tendonhang");
        BigDecimal tongtien = resultSet.getBigDecimal("tongtien");
        BigDecimal tonggiamgia = resultSet.getBigDecimal("tonggiamgia");
        LocalDateTime ngaytao = resultSet.getObject("ngaytao", LocalDateTime.class);
        Long maNguoiDung = resultSet.getLong("maNguoiDung");

        // Lấy thông tin người dùng từ cơ sở dữ liệu
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(dataProvider);
        NguoiDung nguoiDung = nguoiDungDAO.getNguoiDungById(maNguoiDung);

        return new DonHang(madonhang, tendonhang, tongtien, tonggiamgia, ngaytao, nguoiDung);
    }
}
