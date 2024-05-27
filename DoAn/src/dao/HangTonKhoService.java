/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import gui.bean.Pageable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.HangTonKho;
import pojo.SQLServerDataProvider;

/**
 *
 * @author Yuuta
 */
public class HangTonKhoService {

    private final SQLServerDataProvider provider = new SQLServerDataProvider();
    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    private final String SELECT_QUERY = "SELECT * FROM HangTonKho";
    private final String COUNT_QUERY = "SELECT COUNT(*) FROM HangTonKho";
    private final String FIND_BY_ID_QUERY = "SELECT HangTonKho.* FROM HangTonKho LEFT JOIN SANPHAM ON SANPHAM.MASP = HANGTONKHO.MASP WHERE MAHTK = ?";

    private final String INSERT_QUERY = "INSERT INTO HangTonKho(soluongtrongkho, ngaynhaphang, trangthai, masp) VALUES (?, ?, ?, ?)";
    private final String UPDATE_QUERY = "UPDATE HangTonKho SET soluongtrongkho = ?, ngaynhaphang = ?, ngayxuathang = ?, trangthai = ? WHERE MAHTK = ?";
    private final String DELETE_QUERY = "DELETE FROM HangTonKho WHERE MAHTK = ?";

    private final String STATICSTICAL_QUERY = "SELECT "
            + "YEAR(NGAYNHAPHANG) AS Year, "
            + "MONTH(NGAYNHAPHANG) AS Month, "
            + "SUM(CASE WHEN NGAYNHAPHANG IS NOT NULL THEN SOLUONGTRONGKHO ELSE 0 END) AS TongSoHangNhap, "
            + "SUM(CASE WHEN NGAYXUATHANG IS NOT NULL THEN SOLUONGTRONGKHO ELSE 0 END) AS TongSoHangXuat, "
            + "SUM(CASE WHEN TRANGTHAI = 'Trong kho' THEN SOLUONGTRONGKHO ELSE 0 END) AS SoLuongTrongKho "
            + "FROM HANGTONKHO "
            + "WHERE NGAYNHAPHANG BETWEEN ? AND ? "
            + "GROUP BY YEAR(NGAYNHAPHANG), MONTH(NGAYNHAPHANG) "
            + "ORDER BY Year, Month";

    public HangTonKhoService() {
        provider.open();
    }

    public Pageable<HangTonKho> danhSachHangTonKho() {
        List<HangTonKho> list = new ArrayList<>();

        try {
            Connection connection = provider.getConnection();
            PreparedStatement prepareStatement
                    = connection.prepareStatement(SELECT_QUERY);
            ResultSet result = prepareStatement.executeQuery();
            while (result.next()) {
                list.add(mapToObject(result));
            }
            prepareStatement.close();
            result.close();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
        return new Pageable<>(list, dem());
    }

    public int dem() {
        try {
            ResultSet result = provider.executeQuery(COUNT_QUERY);
            int count = result.next() ? result.getInt(1) : 0;
            result.close();
            return count;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return 0;
        }
    }

    public String capNhatHangTonKho(Long id, HangTonKho donHang) {
        try {
            Connection conn = provider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY);
            pstmt.setObject(1, donHang.getSoLuongTrongKho());
            pstmt.setObject(2, donHang.getNgayNhapHang());
            pstmt.setObject(3, donHang.getNgayXuatHang());
            pstmt.setObject(4, donHang.getTrangThai());
            pstmt.setLong(5, id);

            int affectedRows = pstmt.executeUpdate();
            pstmt.close();
            if (affectedRows > 0) {
                return "Cập nhật thành công!";
            } else {
                return "Không có dữ liệu nào bị ảnh hưởng";
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return "Cập nhật thất bại";
        }
    }

    public String xoaHangTonKho(Long madonhang) {
        try {
            Connection conn = provider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY);
            pstmt.setLong(1, madonhang);

            int affectedRows = pstmt.executeUpdate();
            pstmt.close();
            if (affectedRows > 0) {
                return "Xóa thành công!";
            } else {
                return "Không có dữ liệu nào bị ảnh hưởng";
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return "Xóa thất bại";
        }
    }

    public HangTonKho timTheoMaSanPham(Long maHang) {
        try {
            Connection conn = provider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(FIND_BY_ID_QUERY);
            pstmt.setLong(1, maHang);

            ResultSet result = pstmt.executeQuery();
            HangTonKho donHang = result.next() ? mapToObject(result) : null;
            pstmt.close();
            result.close();
            return donHang;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    public boolean them(HangTonKho donHangMoi) {
        try {
            Connection conn = provider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY);
            pstmt.setObject(1, donHangMoi.getSoLuongTrongKho());
            pstmt.setObject(2, donHangMoi.getNgayNhapHang());
            pstmt.setString(3, donHangMoi.getTrangThai());
            pstmt.setLong(4, donHangMoi.getMaSanPham());

            int affectedRows = pstmt.executeUpdate();
            pstmt.close();
            return affectedRows > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return false;
        }
    }

    private HangTonKho mapToObject(ResultSet result) throws SQLException {
        if (result == null) {
            return null;
        }
        Date nhapHang = result.getDate(3);
        Date xuatHang = result.getDate(4);

        HangTonKho dh = new HangTonKho();
        dh.setMaHTK(result.getLong(1));
        dh.setSoLuongTrongKho(result.getLong(2));
        dh.setNgayNhapHang(nhapHang == null ? null : nhapHang.toLocalDate().atStartOfDay());
        dh.setNgayXuatHang(xuatHang == null ? null : xuatHang.toLocalDate().atStartOfDay());
        dh.setTrangThai(result.getString(5));
        dh.setMaSanPham(result.getLong(6));
        return dh;
    }

    public Map<Integer, Object> thongKeTheoPhamVi(LocalDate from, LocalDate to) {
        Connection connection = provider.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(STATICSTICAL_QUERY);
            statement.setObject(1, from);
            statement.setObject(2, to);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next()
                    ? Map.of(
                            1, resultSet.getObject("TongSoHangNhap"),
                            2, resultSet.getObject("TongSoHangXuat"),
                            3, resultSet.getObject("SoLuongTrongKho")
                    ) : null;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }
}
