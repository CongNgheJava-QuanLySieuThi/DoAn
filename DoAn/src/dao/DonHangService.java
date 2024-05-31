package dao;

import pojo.DonHang;
import pojo.SQLServerDataProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuuta
 */
public class DonHangService {

    private final SQLServerDataProvider provider = new SQLServerDataProvider();
    private static final Logger LOGGER = Logger.getLogger(DonHangService.class.getName());

    private final String SELECT_QUERY = "SELECT * FROM DonHang";
    private final String FIND_BY_NAME_QUERY = "SELECT * FROM DonHang WHERE LOWER(tendonhang) = ?";

    private final String UPDATE_QUERY = "UPDATE DonHang SET tendonhang = ?, tongtien = ?, tonggiamgia = ?,TrangThai=? WHERE madonhang = ?";
    private final String DELETE_QUERY = "DELETE FROM DonHang WHERE madonhang = ?";

    private final String STATICSTICAL_QUERY = """
        SELECT 
            YEAR(NGAYTAO) AS Year, 
            MONTH(NGAYTAO) AS Month, 
            COUNT(*) AS SoLuongDonHang, 
            SUM(TONGTIEN) AS TongTien
        FROM DONHANG
        WHERE NGAYTAO >= ? AND NGAYTAO <= ? 
          AND TRANGTHAI = 1
        GROUP BY YEAR(NGAYTAO), MONTH(NGAYTAO)
        ORDER BY Year, Month
    """;

    public DonHangService() {
        provider.open();
    }

    public List<DonHang> danhSachDonHang() {
        List<DonHang> list = new ArrayList<>();
        Connection connection = provider.getConnection();
        try (ResultSet result = connection.prepareStatement(SELECT_QUERY).executeQuery()) {
            while (result.next()) {
                list.add(mapToObject(result));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
        return list;
    }

    public String capNhatDonHang(Long id, DonHang donHang) {
        Connection conn = provider.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY)) {
            pstmt.setString(1, donHang.getTendonhang());
            pstmt.setBigDecimal(2, donHang.getTongtien());
            pstmt.setBigDecimal(3, donHang.getTonggiamgia());
            pstmt.setLong(4, id);
            pstmt.setInt(5, donHang.getTrangThai());
            int affectedRows = pstmt.executeUpdate();
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

    public String xoaDonHang(Long madonhang) {
        Connection conn = provider.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY)) {
            pstmt.setLong(1, madonhang);
            int affectedRows = pstmt.executeUpdate();
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

    public DonHang timTheoTen(String name) {
        Connection conn = provider.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(FIND_BY_NAME_QUERY);) {
            pstmt.setString(1, name);
            DonHang donHang;
            try (ResultSet result = pstmt.executeQuery()) {
                donHang = result.next() ? mapToObject(result) : null;
            }
            return donHang;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    private DonHang mapToObject(ResultSet result) throws SQLException {
        if (result == null) {
            return null;
        }

        DonHang dh = new DonHang();
        dh.setMadonhang(result.getLong("Madonhang"));
        dh.setTendonhang(result.getString("Tendonhang"));
        dh.setTongtien(result.getBigDecimal("Tongtien"));
        dh.setTonggiamgia(result.getBigDecimal("Tonggiamgia"));
        dh.setNgaytao(result.getTimestamp("Ngaytao").toLocalDateTime());
        dh.setMaNguoiDung(result.getLong("MaND"));
        dh.setTrangThai(result.getInt("TrangThai"));
        return dh;
    }

    public Map<Integer, Object> thongKeTheoPhamVi(LocalDate from, LocalDate to) {
        Connection connection = provider.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(STATICSTICAL_QUERY);
            statement.setObject(1, from);
            statement.setObject(2, to.plusDays(1));

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next()
                    ? Map.of(1, resultSet.getInt("SoLuongDonHang"), 2, resultSet.getDouble("TongTien"))
                    : Map.of(1, 0, 2, 0);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

}
