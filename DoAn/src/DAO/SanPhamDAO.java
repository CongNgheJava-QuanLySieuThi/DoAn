package dao;

import Pojo.SanPham;
import Pojo.DanhMuc;
import DAO.DanhMucDAO;
import Pojo.SQLServerDataProvider;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {
    private SQLServerDataProvider dataProvider;

    public SanPhamDAO(SQLServerDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    // Thêm sản phẩm vào cơ sở dữ liệu
    public void addSanPham(SanPham sanPham) throws SQLException {
        String query = "INSERT INTO SANPHAM (TenSP, gia, giamgia, hinhanh, tukhoa, mota, soluongtonkho, ngaytao, ngaycapnhat, madanhmuc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, sanPham.getTenSanPham());
            statement.setBigDecimal(2, sanPham.getGia());
            statement.setInt(3, sanPham.getGiamGia());
            statement.setString(4, sanPham.getHinhAnh());
            statement.setString(5, sanPham.getTuKhoa());
            statement.setString(6, sanPham.getMoTa());
            statement.setInt(7, sanPham.getSoLuongTonKho());
            statement.setObject(8, sanPham.getNgayTao());
            statement.setObject(9, sanPham.getNgayCapNhat());
            statement.setLong(10, sanPham.getDanhMuc().getMaDanhMuc());
            statement.executeUpdate();
        }
    }

    // Cập nhật thông tin sản phẩm trong cơ sở dữ liệu
    public void updateSanPham(SanPham sanPham) throws SQLException {
        String query = "UPDATE san_pham SET tensp=?, gia=?, giamgia=?, hinhanh=?, tukhoa=?, mota=?, soluongtonkho=?, ngaytao=?, ngaycapnhat=?, madanhmuc=? WHERE masp=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, sanPham.getTenSanPham());
            statement.setBigDecimal(2, sanPham.getGia());
            statement.setInt(3, sanPham.getGiamGia());
            statement.setString(4, sanPham.getHinhAnh());
            statement.setString(5, sanPham.getTuKhoa());
            statement.setString(6, sanPham.getMoTa());
            statement.setInt(7, sanPham.getSoLuongTonKho());
            statement.setObject(8, sanPham.getNgayTao());
            statement.setObject(9, sanPham.getNgayCapNhat());
            statement.setLong(10, sanPham.getDanhMuc().getMaDanhMuc());
            statement.setLong(11, sanPham.getMaSanPham());
            statement.executeUpdate();
        }
    }

    // Xóa sản phẩm từ cơ sở dữ liệu
    public void deleteSanPham(Long maSP) throws SQLException {
        String query = "DELETE FROM sanpham WHERE masp=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, maSP);
            statement.executeUpdate();
        }
    }

    // Lấy thông tin của một sản phẩm dựa trên mã sản phẩm
    public SanPham getSanPhamById(Long maSP) throws SQLException {
        String query = "SELECT * FROM sanpham WHERE masp=?";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, maSP);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractSanPhamFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    // Lấy danh sách tất cả sản phẩm từ cơ sở dữ liệu
    public List<SanPham> getAllSanPham() throws SQLException {
        List<SanPham> sanPhamList = new ArrayList<>();
        String query = "SELECT * FROM sanpham";
        try (Connection connection = dataProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                SanPham sanPham = extractSanPhamFromResultSet(resultSet);
                sanPhamList.add(sanPham);
            }
        }
        return sanPhamList;
    }

    // Phương thức hỗ trợ trích xuất thông tin sản phẩm từ ResultSet
    private SanPham extractSanPhamFromResultSet(ResultSet resultSet) throws SQLException {
        Long masp = resultSet.getLong("masp");
        String tensp = resultSet.getString("tensp");
        BigDecimal gia = resultSet.getBigDecimal("gia");
        Integer giamGia = resultSet.getInt("giamgia");
        String hinhAnh = resultSet.getString("hinhanh");
        String tuKhoa = resultSet.getString("tukhoa");
        String moTa = resultSet.getString("mota");
        Integer soLuoưngTonKho = resultSet.getInt("soluongtonkho");
        LocalDateTime ngayTao = resultSet.getObject("ngaytao", LocalDateTime.class);
        LocalDateTime ngayCapNhat = resultSet.getObject("ngaycapnhat", LocalDateTime.class);
        Long maDanhMuc = resultSet.getLong("madanhmuc");
        
        // Lấy danh mục từ mã danh mục
        DanhMuc danhMuc = getDanhMucById(maDanhMuc);
        
        return new SanPham(masp, tensp, gia, giamGia, hinhAnh, tuKhoa, moTa, soLuoưngTonKho, ngayTao, ngayCapNhat, danhMuc);
    }

    // Phương thức hỗ trợ lấy danh mục từ mã danh mục
    private DanhMuc getDanhMucById(Long maDanhMuc) throws SQLException {
        // Gọi DAO của DanhMuc để lấy thông tin danh mục
        DanhMucDAO danhMucDAO = new DanhMucDAO(dataProvider);
        return danhMucDAO.getDanhMucById(maDanhMuc);
    }
}
