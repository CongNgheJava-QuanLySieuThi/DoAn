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
import Pojo.HoaDon;
import Pojo.DonHang;
import Pojo.NguoiDung;
import Pojo.SQLServerDataProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HoaDonDAO {
    private SQLServerDataProvider dataProvider;

    public HoaDonDAO(SQLServerDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    // Thêm hóa đơn vào cơ sở dữ liệu
    public void addHoaDon(HoaDon hoaDon) throws SQLException {
        String query = "INSERT INTO HoaDon (maHD, tenHoaDon, phuongThucMuaHang, maDonHang, maNguoiDung, ngayTao) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, hoaDon.getMaHoaDon());
            statement.setString(2, hoaDon.getTenHoaDon());
            statement.setString(3, hoaDon.getPhuongThucMuaHang());
            statement.setLong(4, hoaDon.getDonHang().getMadonhang());
            statement.setLong(5, hoaDon.getNguoiDung().getMaND());
            statement.setObject(6, hoaDon.getNgayTao());
            statement.executeUpdate();
        }
    }

    // Cập nhật thông tin hóa đơn trong cơ sở dữ liệu
    public void updateHoaDon(HoaDon hoaDon) throws SQLException {
        String query = "UPDATE HoaDon SET tenHoaDon=?, phuongThucMuaHang=?, maDonHang=?, maNguoiDung=?, ngayTao=? WHERE maHD=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, hoaDon.getTenHoaDon());
            statement.setString(2, hoaDon.getPhuongThucMuaHang());
            statement.setLong(3, hoaDon.getDonHang().getMadonhang());
            statement.setLong(4, hoaDon.getNguoiDung().getMaND());
            statement.setObject(5, hoaDon.getNgayTao());
            statement.setLong(6, hoaDon.getMaHoaDon());
            statement.executeUpdate();
        }
    }

    // Xóa hóa đơn từ cơ sở dữ liệu
    public void deleteHoaDon(long maHoaDon) throws SQLException {
        String query = "DELETE FROM HoaDon WHERE maHD=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, maHoaDon);
            statement.executeUpdate();
        }
    }

    // Lấy thông tin của một hóa đơn dựa trên mã hóa đơn
    public HoaDon getHoaDonById(long maHoaDon) throws SQLException {
        String query = "SELECT * FROM HoaDon WHERE maHD=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, maHoaDon);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractHoaDonFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    // Lấy danh sách tất cả các hóa đơn từ cơ sở dữ liệu
    public List<HoaDon> getAllHoaDon() throws SQLException {
        List<HoaDon> hoaDonList = new ArrayList<>();
        String query = "SELECT * FROM HoaDon";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                HoaDon hoaDon = extractHoaDonFromResultSet(resultSet);
                hoaDonList.add(hoaDon);
            }
        }
        return hoaDonList;
    }

    // Phương thức hỗ trợ trích xuất thông tin hóa đơn từ ResultSet
    private HoaDon extractHoaDonFromResultSet(ResultSet resultSet) throws SQLException {
        long maHD = resultSet.getLong("maHD");
        String tenHoaDon = resultSet.getString("tenHoaDon");
        String phuongThucMuaHang = resultSet.getString("phuongThucMuaHang");
        long maDonHang = resultSet.getLong("maDonHang");
        long maNguoiDung = resultSet.getLong("maNguoiDung");
        LocalDateTime ngayTao = resultSet.getObject("ngayTao", LocalDateTime.class);

        // Lấy đối tượng DonHang từ cơ sở dữ liệu hoặc các thông tin liên quan
        DonHang donHang = new DonHang(); // Chưa cần gán chi tiết, chỉ cần ID của đơn hàng là đủ
        donHang.setMadonhang(maDonHang);

        // Lấy đối tượng NguoiDung từ cơ sở dữ liệu hoặc các thông tin liên quan
        NguoiDung nguoiDung = new NguoiDung(); // Chưa cần gán chi tiết, chỉ cần ID của người dùng là đủ
        nguoiDung.setMaND(maNguoiDung);

        HoaDon hoaDon = new HoaDon(maHD, tenHoaDon, phuongThucMuaHang, donHang, nguoiDung, ngayTao);
        return hoaDon;
    }
}

