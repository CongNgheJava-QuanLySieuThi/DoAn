/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author Administrator
 */
public class PhongBan {
    private int MaPB;
    private String TenPB;

    public PhongBan() {
    }

    public PhongBan(int MaPB, String TenPB) {
        this.MaPB = MaPB;
        this.TenPB = TenPB;
    }

    public int getMaPB() {
        return MaPB;
    }

    public void setMaPB(int MaPB) {
        this.MaPB = MaPB;
    }

    public String getTenPB() {
        return TenPB;
    }

    public void setTenPB(String TenPB) {
        this.TenPB = TenPB;
    }
    
    
}
