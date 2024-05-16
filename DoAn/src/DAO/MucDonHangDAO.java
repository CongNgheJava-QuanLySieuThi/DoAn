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
import Pojo.MucDonHang;
import Pojo.DonHang;
import Pojo.SQLServerDataProvider;
import Pojo.SanPham;
import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MucDonHangDAO {
    private SQLServerDataProvider dataProvider;

    public MucDonHangDAO(SQLServerDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    // Thêm mục đơn hàng vào cơ sở dữ liệu
    public void addMucDonHang(MucDonHang mucDonHang) throws SQLException {
        String query = "INSERT INTO MucDonHang (maMuc, soLuong, giaHienTai, giamGiaHienTai, maDonHang, maSanPham) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, mucDonHang.getMaMuc());
            statement.setInt(2, mucDonHang.getSoLuong());
            statement.setBigDecimal(3, mucDonHang.getGiaHienTai());
            statement.setBigDecimal(4, mucDonHang.getGiamGiaHienTai());
            statement.setLong(5, mucDonHang.getDonHang().getMadonhang());
            statement.setLong(6, mucDonHang.getSanPham().getMaSanPham());
            statement.executeUpdate();
        }
    }

    // Cập nhật thông tin mục đơn hàng trong cơ sở dữ liệu
    public void updateMucDonHang(MucDonHang mucDonHang) throws SQLException {
        String query = "UPDATE MucDonHang SET soLuong=?, giaHienTai=?, giamGiaHienTai=?, maDonHang=?, maSanPham=? WHERE maMuc=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, mucDonHang.getSoLuong());
            statement.setBigDecimal(2, mucDonHang.getGiaHienTai());
            statement.setBigDecimal(3, mucDonHang.getGiamGiaHienTai());
            statement.setLong(4, mucDonHang.getDonHang().getMadonhang());
            statement.setLong(5, mucDonHang.getSanPham().getMaSanPham());
            statement.setLong(6, mucDonHang.getMaMuc());
            statement.executeUpdate();
        }
    }

    // Xóa mục đơn hàng từ cơ sở dữ liệu
    public void deleteMucDonHang(long maMuc) throws SQLException {
        String query = "DELETE FROM MucDonHang WHERE maMuc=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, maMuc);
            statement.executeUpdate();
        }
    }

    // Lấy thông tin của một mục đơn hàng dựa trên mã mục
    public MucDonHang getMucDonHangById(long maMuc) throws SQLException {
        String query = "SELECT * FROM MucDonHang WHERE maMuc=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, maMuc);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractMucDonHangFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    // Lấy danh sách tất cả các mục đơn hàng từ cơ sở dữ liệu
    public List<MucDonHang> getAllMucDonHang() throws SQLException {
        List<MucDonHang> mucDonHangList = new ArrayList<>();
        String query = "SELECT * FROM MucDonHang";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                MucDonHang mucDonHang = extractMucDonHangFromResultSet(resultSet);
                mucDonHangList.add(mucDonHang);
            }
        }
        return mucDonHangList;
    }

    // Phương thức hỗ trợ trích xuất thông tin mục đơn hàng từ ResultSet
    private MucDonHang extractMucDonHangFromResultSet(ResultSet resultSet) throws SQLException {
        long maMuc = resultSet.getLong("maMuc");
        int soLuong = resultSet.getInt("soLuong");
        BigDecimal giaHienTai = resultSet.getBigDecimal("giaHienTai");
        BigDecimal giamGiaHienTai = resultSet.getBigDecimal("giamGiaHienTai");
        long maDonHang = resultSet.getLong("maDonHang");
        long maSanPham = resultSet.getLong("maSanPham");

        // Lấy đối tượng DonHang từ cơ sở dữ liệu hoặc các thông tin liên quan
        DonHang donHang = new DonHang(); // Chưa cần gán chi tiết, chỉ cần ID của đơn hàng là đủ
        donHang.setMadonhang(maDonHang);

        // Lấy đối tượng SanPham từ cơ sở dữ liệu hoặc các thông tin liên quan
        SanPham sanPham = new SanPham(); // Chưa cần gán chi tiết, chỉ cần ID của sản phẩm là đủ
        sanPham.setMaSanPham(maSanPham);

        MucDonHang mucDonHang = new MucDonHang(maMuc, soLuong, giaHienTai, giamGiaHienTai, donHang, sanPham);
        return mucDonHang;
    }
}
