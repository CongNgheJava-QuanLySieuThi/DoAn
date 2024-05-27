package dao;

import gui.bean.Statistics;
import gui.bean.Pageable;
import pojo.DonHang;
import pojo.SQLServerDataProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuuta
 */
public class DonHangService {

    private final SQLServerDataProvider provider = new SQLServerDataProvider();
    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    private final String SELECT_QUERY = "SELECT * FROM DonHang";
    private final String COUNT_QUERY = "SELECT COUNT(*) FROM DonHang";
    private final String FIND_BY_NAME_QUERY = "SELECT * FROM DonHang WHERE LOWER(tendonhang) = ?";

    private final String INSERT_QUERY = "INSERT INTO DonHang(tendonhang, tongtien, tonggiamgia, ngaytao, mand) VALUES (?, ?, ?, ?, ?)";
    private final String UPDATE_QUERY = "UPDATE DonHang SET tendonhang = ?, tongtien = ?, tonggiamgia = ? WHERE madonhang = ?";
    private final String DELETE_QUERY = "DELETE FROM DonHang WHERE madonhang = ?";

    private final String STATICSTICAL_QUERY = "SELECT YEAR(NGAYTAO) AS Year, MONTH(NGAYTAO) AS Month, COUNT(*) AS SoLuongDonHang, SUM(TONGTIEN) AS TongTien "
            + "FROM DONHANG "
            + "WHERE NGAYTAO BETWEEN ? AND ? "
            + "GROUP BY YEAR(NGAYTAO), MONTH(NGAYTAO) "
            + "ORDER BY Year, Month";

    public DonHangService() {
        provider.open();
    }

    public Pageable<DonHang> danhSachDonHang() {
        List<DonHang> list = new ArrayList<>();

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

    public String capNhatDonHang(Long id, DonHang donHang) {
        try {
            Connection conn = provider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY);
            pstmt.setString(1, donHang.getTendonhang());
            pstmt.setBigDecimal(2, donHang.getTongtien());
            pstmt.setBigDecimal(3, donHang.getTonggiamgia());
            pstmt.setLong(4, id);

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

    public String xoaDonHang(Long madonhang) {
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

    public DonHang timTheoTen(String name) {
        try {
            Connection conn = provider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(FIND_BY_NAME_QUERY);
            pstmt.setString(1, name);

            ResultSet result = pstmt.executeQuery();
            DonHang donHang = result.next() ? mapToObject(result) : null;
            pstmt.close();
            result.close();
            return donHang;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    public boolean them(DonHang donHangMoi) {
        try {
            Connection conn = provider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY);
            pstmt.setString(1, donHangMoi.getTendonhang());
            pstmt.setBigDecimal(2, donHangMoi.getTongtien());
            pstmt.setBigDecimal(3, donHangMoi.getTonggiamgia());
            pstmt.setString(4, donHangMoi.getNgaytao().toString());
            pstmt.setLong(5, donHangMoi.getMaNguoiDung());

            int affectedRows = pstmt.executeUpdate();
            pstmt.close();
            return affectedRows > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return false;
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
        return dh;
    }

    public Statistics thongKeTheoPhamVi(LocalDate from, LocalDate to) {
        Connection connection = provider.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(STATICSTICAL_QUERY);
            statement.setObject(1, from);
            statement.setObject(2, to);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next()
                    ? new Statistics(resultSet.getInt("SoLuongDonHang"), resultSet.getDouble("TongTien"))
                    : new Statistics(0, 0d);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

}
