package pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLServerDataProvider implements AutoCloseable{

    private Connection connection; // Sử dụng private để tránh truy cập trực tiếp từ bên ngoài

    // Phương thức mở kết nối tới cơ sở dữ liệu
    public void open() {
        String strServer = "LAPTOP-GSL3DJO2";
        String strDatabase = "QL_BH";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://" + strServer
                    + ":1433;databaseName=" + strDatabase
                    + ";user=sa;password=123;";
            // Khởi tạo kết nối và gán vào trường connection của lớp
            this.connection = DriverManager.getConnection(connectionURL);
            if (this.connection != null && !this.connection.isClosed()) {
                System.out.println("Đã kết nối tới CSDL thành công.");
            } else {
                System.out.println("Kết nối thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Phương thức đóng kết nối tới cơ sở dữ liệu
    public void close() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
                System.out.println("Đã đóng kết nối tới SQL Server.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Phương thức lấy đối tượng Connection
    public Connection getConnection() {
        return this.connection;
    }

    // Phương thức thực thi truy vấn SELECT và trả về ResultSet
    public ResultSet executeQuery(String sql) throws SQLException {
        PreparedStatement ps = this.connection.prepareStatement(sql);
        return ps.executeQuery();
    }

    // Phương thức thực thi truy vấn INSERT, UPDATE hoặc DELETE
    public int executeUpdate(String sql) throws SQLException {
        PreparedStatement ps = this.connection.prepareStatement(sql);
        return ps.executeUpdate();
    }

    // Phương thức thực thi truy vấn INSERT, UPDATE hoặc DELETE với tham số
    public int executeUpdate(String sql, Object... params) throws SQLException {
        PreparedStatement ps = this.connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        return ps.executeUpdate();
    }
}
