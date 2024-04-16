/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GUI.QLPhongBan;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class KetNoiCSDL {

    private Connection conn;
    private Statement sta;
    private Component QLPhongBan;

    public void open() {
        String strName = "A203PC42";
        String strDatabase = "ql_nhanvien";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KetNoiCSDL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String connectionURL = "jdbc:sqlserver://" + strName
                + ":1433;databaseName=" + strDatabase
                + ";user= sa; password = 123";
        try {
            conn = DriverManager.getConnection(connectionURL);
            if (conn != null) {
                System.out.println("Ket noi thanh cong");
            } else {
                System.out.println("Ket noi that bai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KetNoiCSDL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KetNoiCSDL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            sta = conn.createStatement();
            rs = sta.executeQuery(sql);
        } catch (SQLException ex) {
            
            Logger.getLogger(KetNoiCSDL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int executeUpdate(String sql) {
        int n = -1;
        try {
            sta = conn.createStatement();
            n = sta.executeUpdate(sql);
        } catch (SQLException ex) {
            if(ex.getErrorCode()==2627)
            {
                JOptionPane.showConfirmDialog(QLPhongBan, "Trùng khóa chính");
            }
            Logger.getLogger(KetNoiCSDL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
