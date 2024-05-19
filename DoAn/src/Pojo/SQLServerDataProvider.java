package Pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerDataProvider {

    private Connection connection; // Sử dụng private để tránh truy cập trực tiếp từ bên ngoài

    // Phương thức mở kết nối tới cơ sở dữ liệu
    public void open() {
        String strServer = "localhost";
        String strDatabase = "QL_BH";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://" + strServer
                    + ":1433;databaseName=" + strDatabase
                    + ";user=sa;password=Tuan@2003;";
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
        Statement sm = this.connection.createStatement();
        return sm.executeQuery(sql);
    }

    // Phương thức thực thi truy vấn INSERT, UPDATE hoặc DELETE
    public int executeUpdate(String sql) throws SQLException {
        Statement sm = this.connection.createStatement();
        return sm.executeUpdate(sql);
    }
}
