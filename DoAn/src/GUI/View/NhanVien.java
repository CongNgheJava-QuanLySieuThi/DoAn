/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.View;

import GUI.Bean.DanhMuc;
import GUI.Transition.TransitionController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class NhanVien extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     */
    public NhanVien() {
        initComponents();
        
        
        setTitle("QUẢN LÝ SIÊU THỊ");
        TransitionController trans =  new TransitionController(jpnView);
        trans.setView(jpnDanhMuc, jlbTrangChu);
        
        List<DanhMuc> listItem = new ArrayList<>();
        listItem.add(new DanhMuc("TrangChu",jpnDanhMuc,jlbTrangChu));
        listItem.add(new DanhMuc("SanPham",jpnSanPham,jlbSanPham));
        listItem.add(new DanhMuc("DonHang",jpnDonHang,jlbDonHang));
        listItem.add(new DanhMuc("HangTonKho",jpnHangTonKho,jlbHangTonKho));
        listItem.add(new DanhMuc("HoaDon",jpnHoaDon,jlbHoaDon));
        listItem.add(new DanhMuc("User",jpnUser,jlbUser));
        listItem.add(new DanhMuc("MucDonHang",jpnMucDonHang,jlbMucDonHang));
        
        
        
        trans.setEvent(listItem);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnDanhMuc = new javax.swing.JPanel();
        jlbTrangChu = new javax.swing.JLabel();
        jpnSanPham = new javax.swing.JPanel();
        jlbSanPham = new javax.swing.JLabel();
        jpnDonHang = new javax.swing.JPanel();
        jlbDonHang = new javax.swing.JLabel();
        jpnHangTonKho = new javax.swing.JPanel();
        jlbHangTonKho = new javax.swing.JLabel();
        jpnUser = new javax.swing.JPanel();
        jlbUser = new javax.swing.JLabel();
        jpnHoaDon = new javax.swing.JPanel();
        jlbHoaDon = new javax.swing.JLabel();
        jpnMucDonHang = new javax.swing.JPanel();
        jlbMucDonHang = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnRoot.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jpnMenu.setBackground(new java.awt.Color(204, 204, 204));

        jPanel4.setBackground(new java.awt.Color(102, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/2x profile user.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ SIÊU THỊ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(44, 44, 44))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jpnDanhMuc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlbTrangChu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/1x profile user.png"))); // NOI18N
        jlbTrangChu.setText("QUẢN LÝ DANH MỤC");

        javax.swing.GroupLayout jpnDanhMucLayout = new javax.swing.GroupLayout(jpnDanhMuc);
        jpnDanhMuc.setLayout(jpnDanhMucLayout);
        jpnDanhMucLayout.setHorizontalGroup(
            jpnDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDanhMucLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jlbTrangChu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnDanhMucLayout.setVerticalGroup(
            jpnDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDanhMucLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jlbTrangChu)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jpnSanPham.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlbSanPham.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/store_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        jlbSanPham.setText("QUẢN LÝ SẢN PHẨM");

        javax.swing.GroupLayout jpnSanPhamLayout = new javax.swing.GroupLayout(jpnSanPham);
        jpnSanPham.setLayout(jpnSanPhamLayout);
        jpnSanPhamLayout.setHorizontalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSanPhamLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jlbSanPham)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnSanPhamLayout.setVerticalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSanPhamLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jlbSanPham)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jpnDonHang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlbDonHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/description_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        jlbDonHang.setText("QUẢN LÝ ĐƠN HÀNG");

        javax.swing.GroupLayout jpnDonHangLayout = new javax.swing.GroupLayout(jpnDonHang);
        jpnDonHang.setLayout(jpnDonHangLayout);
        jpnDonHangLayout.setHorizontalGroup(
            jpnDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDonHangLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jlbDonHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnDonHangLayout.setVerticalGroup(
            jpnDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDonHangLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jlbDonHang)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jpnHangTonKho.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlbHangTonKho.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbHangTonKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/category_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        jlbHangTonKho.setText("QUẢN LÝ HÀNG TỒN KHO");

        javax.swing.GroupLayout jpnHangTonKhoLayout = new javax.swing.GroupLayout(jpnHangTonKho);
        jpnHangTonKho.setLayout(jpnHangTonKhoLayout);
        jpnHangTonKhoLayout.setHorizontalGroup(
            jpnHangTonKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHangTonKhoLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jlbHangTonKho)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnHangTonKhoLayout.setVerticalGroup(
            jpnHangTonKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHangTonKhoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jlbHangTonKho)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jpnUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlbUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/category_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        jlbUser.setText("QUẢN LÝ USER");

        javax.swing.GroupLayout jpnUserLayout = new javax.swing.GroupLayout(jpnUser);
        jpnUser.setLayout(jpnUserLayout);
        jpnUserLayout.setHorizontalGroup(
            jpnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnUserLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jlbUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnUserLayout.setVerticalGroup(
            jpnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnUserLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jlbUser)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jpnHoaDon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlbHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/category_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        jlbHoaDon.setText("QUẢN LÝ HÓA ĐƠN");

        javax.swing.GroupLayout jpnHoaDonLayout = new javax.swing.GroupLayout(jpnHoaDon);
        jpnHoaDon.setLayout(jpnHoaDonLayout);
        jpnHoaDonLayout.setHorizontalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jlbHoaDon)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jpnHoaDonLayout.setVerticalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jlbHoaDon)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jpnMucDonHang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlbMucDonHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbMucDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/category_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        jlbMucDonHang.setText("QUẢN LÝ MỤC ĐƠN HÀNG");

        javax.swing.GroupLayout jpnMucDonHangLayout = new javax.swing.GroupLayout(jpnMucDonHang);
        jpnMucDonHang.setLayout(jpnMucDonHangLayout);
        jpnMucDonHangLayout.setHorizontalGroup(
            jpnMucDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMucDonHangLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jlbMucDonHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnMucDonHangLayout.setVerticalGroup(
            jpnMucDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMucDonHangLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jlbMucDonHang)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jButton1.setText("EXIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("NhanVien");

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnHangTonKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnDonHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnDanhMuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnMucDonHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(88, 88, 88))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jpnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jpnHangTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnMucDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1529, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         int choice = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn thoát không?", "Xác nhận thoát", JOptionPane.YES_NO_CANCEL_OPTION);
    if (choice == JOptionPane.YES_OPTION) {
        // If the user selects Yes, dispose of the current form and show the login form
        this.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    } else if (choice == JOptionPane.NO_OPTION) {
        // If the user selects No, do nothing
    } else if (choice == JOptionPane.CANCEL_OPTION) {
        // If the user selects Cancel, do nothing
    }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlbDonHang;
    private javax.swing.JLabel jlbHangTonKho;
    private javax.swing.JLabel jlbHoaDon;
    private javax.swing.JLabel jlbMucDonHang;
    private javax.swing.JLabel jlbSanPham;
    private javax.swing.JLabel jlbTrangChu;
    private javax.swing.JLabel jlbUser;
    private javax.swing.JPanel jpnDanhMuc;
    private javax.swing.JPanel jpnDonHang;
    private javax.swing.JPanel jpnHangTonKho;
    private javax.swing.JPanel jpnHoaDon;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnMucDonHang;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnSanPham;
    private javax.swing.JPanel jpnUser;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
