package dao;

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

public class HangTonKhoService {

    private final SQLServerDataProvider provider = new SQLServerDataProvider();
    private static final Logger LOGGER = Logger.getLogger(HangTonKhoService.class.getName());

    private final String SELECT_QUERY = "SELECT * FROM HangTonKho";
    private final String FIND_BY_ID_QUERY = "SELECT HangTonKho.* FROM HangTonKho LEFT JOIN SANPHAM ON SANPHAM.MASP = HANGTONKHO.MASP WHERE MAHTK = ?";

    private final String INSERT_QUERY = "INSERT INTO HangTonKho(soluongtrongkho, ngaynhaphang, trangthai) VALUES (?, ?, ?)";
    private final String UPDATE_QUANTITY_OF_PRODUCT = "UPDATE HangTonKho SET soluongtrongkho = ?, ngayxuathang = ?, trang thai = ? WHERE MASP = ?";
    private final String UPDATE_INVENTORY_QUANTITY = "UPDATE HangTonKho SET soluongtrongkho = soluongtrongkho - ?, ngayxuathang = ? WHERE MAHTK = ?";
    private final String UPDATE_PRODUCT_QUANTITY = "UPDATE SANPHAM SET SOLUONGTONKHO = SOLUONGTONKHO + ? WHERE MASP = (SELECT MASP FROM HangTonKho WHERE MAHTK = ?)";
    private final String DELETE_QUERY = "DELETE FROM HangTonKho WHERE MAHTK = ?";

    private final String STATICSTICAL_QUERY = """
            SELECT YEAR(NGAYNHAPHANG) AS Year, MONTH(NGAYNHAPHANG) AS Month,
            SUM(CASE WHEN NGAYNHAPHANG IS NOT NULL THEN SOLUONGTRONGKHO ELSE 0 END) AS TongSoHangNhap,
            SUM(CASE WHEN NGAYXUATHANG IS NOT NULL THEN SOLUONGTRONGKHO ELSE 0 END) AS TongSoHangXuat,
            SUM(CASE WHEN TRANGTHAI = 'Trong kho' THEN SOLUONGTRONGKHO ELSE 0 END) AS SoLuongTrongKho
            FROM HANGTONKHO
            WHERE NGAYNHAPHANG BETWEEN ? AND ?
            GROUP BY YEAR(NGAYNHAPHANG), MONTH(NGAYNHAPHANG)
            ORDER BY Year, Month""";

    public HangTonKhoService() {
        provider.open();
    }

    public List<HangTonKho> danhSachHangTonKho() {
        List<HangTonKho> list = new ArrayList<>();
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

    public String capNhatHangTonKhoVaSanPham(Long id, HangTonKho donHang) {
        try {
            Connection conn = provider.getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement pstmtUpdateProduct = conn.prepareStatement(UPDATE_PRODUCT_QUANTITY); PreparedStatement pstmtUpdateInventory = conn.prepareStatement(UPDATE_INVENTORY_QUANTITY)) {
                pstmtUpdateProduct.setLong(1, donHang.getSoLuongTrongKho());
                pstmtUpdateProduct.setLong(2, id);

                pstmtUpdateInventory.setLong(1, donHang.getSoLuongTrongKho());
                pstmtUpdateInventory.setObject(2, donHang.getNgayXuatHang());
                pstmtUpdateInventory.setLong(3, id);

                synchronized (this) {
                    pstmtUpdateInventory.executeUpdate();
                    pstmtUpdateProduct.executeUpdate();
                }

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                return "Lỗi cập không xác định";
            }
            return "Cập nhật thành công";
        } catch (SQLException e) {
            return "Lỗi kết nối cơ sở dữ liệu";
        }
    }

    public String xoaHangTonKho(Long madonhang) {
        Connection conn = provider.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY)) {
            pstmt.setLong(1, madonhang);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0
                    ? "Cập nhật thành công!"
                    : "Không có dữ liệu nào bị ảnh hưởng";
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return "Xóa thất bại";
        }
    }

    public HangTonKho timTheoMaSanPham(Long maHang) {
        Connection conn = provider.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(FIND_BY_ID_QUERY);) {
            pstmt.setLong(1, maHang);

            HangTonKho donHang;
            try (ResultSet result = pstmt.executeQuery()) {
                donHang = result.next() ? mapToObject(result) : null;
            }
            return donHang;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    public String them(HangTonKho donHangMoi) {
        Connection conn = provider.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY);) {
            pstmt.setObject(1, donHangMoi.getSoLuongTrongKho());
            pstmt.setObject(2, donHangMoi.getNgayNhapHang());
            pstmt.setString(3, donHangMoi.getTrangThai());

            return pstmt.executeUpdate() > 0 ? "Thêm mới thành công" : "Thêm mới thất bại";
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return "Lỗi server không xác định";
        }
    }

    public Map<Integer, Object> thongKeTheoPhamVi(LocalDate from, LocalDate to) {
        Connection connection = provider.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(STATICSTICAL_QUERY);) {
            statement.setObject(1, from);
            statement.setObject(2, to);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next()
                    ? Map.of(
                            1, resultSet.getObject("TongSoHangNhap"),
                            2, resultSet.getObject("TongSoHangXuat"),
                            3, resultSet.getObject("SoLuongTrongKho")
                    ) : Map.of(1, 0, 2, 0, 3, 0);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return null;
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

    public void capNhatSoLuongSanPham(Long maHTK, Long soLuong) {
        Connection connection = provider.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(UPDATE_PRODUCT_QUANTITY)) {
            pstmt.setObject(1, soLuong);
            pstmt.setObject(2, maHTK);
            pstmt.setObject(3, maHTK);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public String capNhatHangTonKho(Long maSP, HangTonKho donHangMoi) {
        Connection conn = provider.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUANTITY_OF_PRODUCT)) {
            pstmt.setObject(1, donHangMoi.getSoLuongTrongKho());
            pstmt.setObject(2, donHangMoi.getNgayNhapHang());
            pstmt.setString(3, donHangMoi.getTrangThai());
            pstmt.setLong(4, donHangMoi.getMaSanPham());

            return pstmt.executeUpdate() > 0 ? "Cập nhật số lượng thành công" : "Cập nhật số lượng thất bại";
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return "Lỗi server không xác định";
        }
    }
}
