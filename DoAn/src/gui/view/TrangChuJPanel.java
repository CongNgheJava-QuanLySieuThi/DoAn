/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import dao.DanhMucDAO;
import pojo.DanhMuc;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class TrangChuJPanel extends javax.swing.JPanel {
    ArrayList<String> maDMList;
    DanhMucDAO danhmucdao;
    public TrangChuJPanel() {
        initComponents();
        loadDanhMuc();
    }
    
    
    public void loadDanhMuc()
    {
        danhmucdao = new DanhMucDAO();
        maDMList = new ArrayList<>();

        DefaultTableModel model = new DefaultTableModel(new Object[]{
            "Mã Danh Mục", "Tên Danh Mục","Ngày Tạo"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        ArrayList<DanhMuc> DSDM = danhmucdao.layDanhSachDanhMuc();

        if (  DSDM != null) {
            for (DanhMuc dm : DSDM ) {
                String maDM = String.valueOf(dm.getMaDanhMuc());
                maDMList.add(maDM);
                model.addRow(new Object[]{
                    dm.getMaDanhMuc(), dm.getTenDanhMuc(), dm.getNgayTao()
                });
            }
        } else {
            System.out.println("Error: DSND is null");
        }

        // Set the table model to the JTable
        jtbDanhMuc.setModel(model);
        jtbDanhMuc.getTableHeader().setReorderingAllowed(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbDanhMuc = new javax.swing.JTable();
        jpnDanhMuc = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfmaDanhMuc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtftenDanhMuc = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jbtThem = new javax.swing.JButton();
        jbtXoa = new javax.swing.JButton();
        jbtSua = new javax.swing.JButton();
        jbtCapNhat = new javax.swing.JButton();
        jbtLuu = new javax.swing.JButton();
        jbtTaiLai = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 238));
        jPanel1.setPreferredSize(new java.awt.Dimension(1545, 930));

        jPanel2.setBackground(new java.awt.Color(255, 255, 238));

        jPanel3.setBackground(new java.awt.Color(245, 242, 235));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ DANH MỤC");

        jtbDanhMuc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtbDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbDanhMucMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbDanhMuc);

        jpnDanhMuc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Mã Danh Mục:");

        jtfmaDanhMuc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfmaDanhMuc.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tên Danh Mục:");

        jtftenDanhMuc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtftenDanhMuc.setEnabled(false);

        javax.swing.GroupLayout jpnDanhMucLayout = new javax.swing.GroupLayout(jpnDanhMuc);
        jpnDanhMuc.setLayout(jpnDanhMucLayout);
        jpnDanhMucLayout.setHorizontalGroup(
            jpnDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDanhMucLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jtfmaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addComponent(jtftenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnDanhMucLayout.setVerticalGroup(
            jpnDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDanhMucLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jpnDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfmaDanhMuc)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtftenDanhMuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbtThem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/note_add.png"))); // NOI18N
        jbtThem.setText("Thêm");
        jbtThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtThemMouseClicked(evt);
            }
        });

        jbtXoa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/delete.png"))); // NOI18N
        jbtXoa.setText("Xóa");
        jbtXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtXoaMouseClicked(evt);
            }
        });

        jbtSua.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/fix.png"))); // NOI18N
        jbtSua.setText("Sửa");
        jbtSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtSuaMouseClicked(evt);
            }
        });
        jbtSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSuaActionPerformed(evt);
            }
        });

        jbtCapNhat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/update.png"))); // NOI18N
        jbtCapNhat.setText("Cập Nhật");
        jbtCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtCapNhatMouseClicked(evt);
            }
        });

        jbtLuu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/save.png"))); // NOI18N
        jbtLuu.setText("Lưu");
        jbtLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtLuuMouseClicked(evt);
            }
        });

        jbtTaiLai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtTaiLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/refresh.png"))); // NOI18N
        jbtTaiLai.setText("Refresh");
        jbtTaiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtTaiLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jbtThem, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtSua, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtCapNhat)
                .addGap(18, 18, 18)
                .addComponent(jbtLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtTaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtThem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtSua, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtTaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(504, 504, 504)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jpnDanhMuc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(jpnDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 316, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 193, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtThemMouseClicked
        // TODO add your handling code here:
        jtftenDanhMuc.setEnabled(true);
        jtftenDanhMuc.requestFocus();
        jtfmaDanhMuc.setText("");
        jtftenDanhMuc.setText("");
    }//GEN-LAST:event_jbtThemMouseClicked

    private void jtbDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbDanhMucMouseClicked
        // TODO add your handling code here:
        int row = jtbDanhMuc.getSelectedRow();
         if (row != -1) {
        jtfmaDanhMuc.setText(maDMList.get(row));
        jtftenDanhMuc.setText((String) jtbDanhMuc.getValueAt(row, 1));
        }
    }//GEN-LAST:event_jtbDanhMucMouseClicked

    private void jbtLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtLuuMouseClicked
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(jbtXoa, "Bạn có muốn thêm danh mục này không?", "Xác nhận thêm", JOptionPane.YES_NO_CANCEL_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
        String tenDanhMuc = jtftenDanhMuc.getText();
        DanhMuc dm = new DanhMuc(tenDanhMuc);
        boolean kq = danhmucdao.themDanhMuc(dm);
        if (kq == true) {
                JOptionPane.showMessageDialog(this, "Them thanh cong");
                loadDanhMuc();
            } else {
                JOptionPane.showMessageDialog(this, "Them that bai");
            }
        } else if (choice == JOptionPane.NO_OPTION) {
                } else if (choice == JOptionPane.CANCEL_OPTION) {
                }
    }//GEN-LAST:event_jbtLuuMouseClicked

    private void jbtXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtXoaMouseClicked

        int choice = JOptionPane.showConfirmDialog(jbtXoa, "Bạn có muốn xoá?", "Xác nhận xóa", JOptionPane.YES_NO_CANCEL_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
         int row = jtbDanhMuc.getSelectedRow();
         if (row != -1) {
            long madm = Long.parseLong(maDMList.get(row));
            boolean kq = danhmucdao.xoaDanhMuc(madm);
            if (kq == true) {
                JOptionPane.showMessageDialog(this, "Xoa thanh cong");
                loadDanhMuc();
            } else {
                JOptionPane.showMessageDialog(this, "Xoa that bai");
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Vui Long chon 1 dong");
        }
          } else if (choice == JOptionPane.NO_OPTION) {
                } else if (choice == JOptionPane.CANCEL_OPTION) {
                }
    }//GEN-LAST:event_jbtXoaMouseClicked

    private void jbtSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSuaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jbtSuaMouseClicked

    private void jbtCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtCapNhatMouseClicked
        // TODO add your handling code here:
         Long maDM = Long.parseLong(jtfmaDanhMuc.getText());
         String tendm = jtftenDanhMuc.getText();
         DanhMuc dm = new DanhMuc(maDM,tendm);
         boolean kq = danhmucdao.capNhatDanhMuc(dm);
         if (kq == true) {
                JOptionPane.showMessageDialog(this, "Cap nhat thanh cong");
                 loadDanhMuc();
            } else {
                JOptionPane.showMessageDialog(this, "Cap nhat that bai");
            }
    }//GEN-LAST:event_jbtCapNhatMouseClicked

    private void jbtSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSuaActionPerformed
        // TODO add your handling code here:
        int row = jtbDanhMuc.getSelectedRow();
        if (row != -1) {
            jtfmaDanhMuc.setEnabled(false);
            jtftenDanhMuc.setEnabled(true);
            jtftenDanhMuc.setEditable(true);
            jtfmaDanhMuc.setText(maDMList.get(row));
            jtftenDanhMuc.setText((String) jtbDanhMuc.getValueAt(row, 1));
            jtftenDanhMuc.requestFocus();
        }
    }//GEN-LAST:event_jbtSuaActionPerformed

    private void jbtTaiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtTaiLaiActionPerformed
        // TODO add your handling code here:
        loadDanhMuc();
    }//GEN-LAST:event_jbtTaiLaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtCapNhat;
    private javax.swing.JButton jbtLuu;
    private javax.swing.JButton jbtSua;
    private javax.swing.JButton jbtTaiLai;
    private javax.swing.JButton jbtThem;
    private javax.swing.JButton jbtXoa;
    private javax.swing.JPanel jpnDanhMuc;
    private javax.swing.JTable jtbDanhMuc;
    private javax.swing.JTextField jtfmaDanhMuc;
    private javax.swing.JTextField jtftenDanhMuc;
    // End of variables declaration//GEN-END:variables
}
