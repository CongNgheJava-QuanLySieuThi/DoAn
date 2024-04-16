/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.PhongBan;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class PhongBanDAO {

    public static ArrayList<PhongBan> dsPhongBan() {
        ArrayList<PhongBan> dspb = new ArrayList<PhongBan>();
        String sql = "Select * from PhongBan";
        KetNoiCSDL kn = new KetNoiCSDL();
        kn.open();
        ResultSet rs = kn.executeQuery(sql);
        try {
            while (rs.next()) {
                PhongBan pb = new PhongBan();
                pb.setMaPB(rs.getInt("MaPHG"));
                pb.setTenPB(rs.getNString("TenPHG"));
                dspb.add(pb);
            }
            kn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PhongBanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dspb;
    }

    public static boolean themPhongBan(PhongBan pb) {
        boolean kq = false;
        String sql = "Insert into PhongBan(TenPHG) values('" + pb.getTenPB() + "')";
        KetNoiCSDL kn = new KetNoiCSDL();
        kn.open();
        int n = kn.executeUpdate(sql);
        if (n == 1) {
            kq = true;
        }
        kn.close();
        return kq;
    }

    public static boolean capNhatPB(PhongBan pb) {
        boolean kq = false;
        String sql = String.format("Update PhongBan set TenPHG = '%s'"
                + "Where MaPHG = %d", pb.getTenPB(), pb.getMaPB());
        KetNoiCSDL kn = new KetNoiCSDL();
        kn.open();
        int n = kn.executeUpdate(sql);
        if (n == 1) {
            kq = true;
        }
        kn.close();
        return kq;
    }

    public static boolean xoaPB(int MaPB) {
        boolean kq = false;
        String sql = String.format("Delete from PhongBan where MaPHG = %d", MaPB);
        KetNoiCSDL kn = new KetNoiCSDL();
        kn.open();
        int n = kn.executeUpdate(sql);
        if (n == 1) {
            kq = true;
        }
        kn.close();
        return kq;
    }

    public static ArrayList<PhongBan> timkiem(String tenPB) {
        ArrayList<PhongBan> dspb = new ArrayList<PhongBan>();
        try {
            String sql = "Select * from PhongBan where TenPHG like '%" + tenPB + "%'";
            KetNoiCSDL kn = new KetNoiCSDL();
            ResultSet rs = kn.executeQuery(sql);
            while (rs.next()) {
                PhongBan pb = new PhongBan();
                pb.setMaPB(rs.getInt("MaPHG"));
                pb.setTenPB(rs.getString("TenPHG"));
                dspb.add(pb);
            }
            kn.close();
        } catch (Exception e) {
        }
        return dspb;

    }
}
