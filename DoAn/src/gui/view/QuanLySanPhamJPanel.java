/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import dao.SanPhamDAO;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pojo.DanhMuc;
import pojo.SQLServerDataProvider;
import pojo.SanPham;

/**
 *
 * @author Admin
 */
public class QuanLySanPhamJPanel extends javax.swing.JPanel {
    ArrayList<String> dsSanPham;
    SanPhamDAO sanphamDAO;
    /**
     * Creates new form QuanLySanPhamJPanel
     */
    public QuanLySanPhamJPanel() {
        initComponents();
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachSanPham = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        txtMaDanhMuc = new javax.swing.JTextField();
        txtSoLuongTonKho = new javax.swing.JTextField();
        txtGiamGia = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        jbtThem = new javax.swing.JButton();
        jbtXoa = new javax.swing.JButton();
        jbtSua = new javax.swing.JButton();
        jbtCapNhat = new javax.swing.JButton();
        jbtLuu = new javax.swing.JButton();
        jbtTaiLai = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 0));
        jPanel1.setForeground(new java.awt.Color(204, 204, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1545, 930));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tblDanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá", "Giảm giá", "Mô tả", "Số lượng tồn kho", "Ngày tạo", "Ngày cập nhật", "Mã danh mục"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachSanPham);
        if (tblDanhSachSanPham.getColumnModel().getColumnCount() > 0) {
            tblDanhSachSanPham.getColumnModel().getColumn(0).setResizable(false);
            tblDanhSachSanPham.getColumnModel().getColumn(1).setResizable(false);
            tblDanhSachSanPham.getColumnModel().getColumn(2).setResizable(false);
            tblDanhSachSanPham.getColumnModel().getColumn(3).setResizable(false);
            tblDanhSachSanPham.getColumnModel().getColumn(4).setResizable(false);
            tblDanhSachSanPham.getColumnModel().getColumn(5).setResizable(false);
            tblDanhSachSanPham.getColumnModel().getColumn(6).setResizable(false);
            tblDanhSachSanPham.getColumnModel().getColumn(7).setResizable(false);
            tblDanhSachSanPham.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã sản phẩm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Giá");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên sản phẩm");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Giảm giá");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mô tả");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Số lượng tồn kho");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Mã danh mục");

        txtMaSanPham.setEditable(false);

        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });

        txtGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiamGiaActionPerformed(evt);
            }
        });

        jbtThem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Image/note_add.png"))); // NOI18N
        jbtThem.setText("Thêm");
        jbtThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtThemMouseClicked(evt);
            }
        });
        jbtThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtThemActionPerformed(evt);
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
        jbtXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtXoaActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtSoLuongTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(31, 31, 31)
                                    .addComponent(txtMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMoTa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGiamGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMaSanPham)
                                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                            .addComponent(txtGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
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
                        .addContainerGap(68, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSoLuongTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtThem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtSua, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtTaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(82, 82, 82))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 396, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDanhSachSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachSanPhamMouseClicked
        int row = tblDanhSachSanPham.getSelectedRow();
        if (row != -1) {
            txtMaSanPham.setText(String.valueOf(tblDanhSachSanPham.getValueAt(row, 0)));
            txtTenSanPham.setText(String.valueOf(tblDanhSachSanPham.getValueAt(row, 1)));
            txtGia.setText(String.valueOf(tblDanhSachSanPham.getValueAt(row, 2)));
            txtGiamGia.setText(String.valueOf(tblDanhSachSanPham.getValueAt(row, 3)));
            txtMoTa.setText(String.valueOf(tblDanhSachSanPham.getValueAt(row, 4)));
            txtSoLuongTonKho.setText(String.valueOf(tblDanhSachSanPham.getValueAt(row, 5)));
            txtMaDanhMuc.setText(String.valueOf(tblDanhSachSanPham.getValueAt(row, 8)));
        }
    }//GEN-LAST:event_tblDanhSachSanPhamMouseClicked

    private void jbtThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtThemMouseClicked
        // TODO add your handling code here:
        txtTenSanPham.requestFocus();
        txtMaSanPham.setText("");
        txtTenSanPham.setText("");
        txtGia.setText("");
        txtGiamGia.setText("");
        txtMoTa.setText("");
        txtSoLuongTonKho.setText("");
        txtMaDanhMuc.setText("");
    }//GEN-LAST:event_jbtThemMouseClicked

    private void jbtXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtXoaMouseClicked

        int choice = JOptionPane.showConfirmDialog(jbtXoa, "Bạn có muốn xoá?", "Xác nhận xóa", JOptionPane.YES_NO_CANCEL_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            int row = tblDanhSachSanPham.getSelectedRow();
            if (row != -1) {
                long maSP = Long.parseLong(dsSanPham.get(row));
                boolean kq = sanphamDAO.xoaSanPham(maSP);
                if (kq == true) {
                    JOptionPane.showMessageDialog(this, "Xoa thanh cong");
                    loadData();
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
         int row = tblDanhSachSanPham.getSelectedRow();
        if (row != -1) {
            txtMaSanPham.setText(String.valueOf(tblDanhSachSanPham.getValueAt(row, 0)));
            txtTenSanPham.requestFocus();
            txtTenSanPham.setText(String.valueOf(tblDanhSachSanPham.getValueAt(row, 1)));
            txtGia.setText(String.valueOf(tblDanhSachSanPham.getValueAt(row, 2)));
            txtGiamGia.setText(String.valueOf(tblDanhSachSanPham.getValueAt(row, 3)));
            txtMoTa.setText(String.valueOf(tblDanhSachSanPham.getValueAt(row, 4)));
            txtSoLuongTonKho.setText(String.valueOf(tblDanhSachSanPham.getValueAt(row, 5)));
            txtMaDanhMuc.setText(String.valueOf(tblDanhSachSanPham.getValueAt(row, 8)));
        }

    }//GEN-LAST:event_jbtSuaMouseClicked

    private void jbtSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSuaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jbtSuaActionPerformed

    private void jbtCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtCapNhatMouseClicked
        // TODO add your handling code here:
        long maSanPham = Long.parseLong(txtMaSanPham.getText());
            String tenSanPham = txtTenSanPham.getText();
            BigDecimal gia = new BigDecimal(txtGia.getText());
            int giamGia = Integer.parseInt(txtGiamGia.getText());
            String moTa = txtMoTa.getText();
            int soLuongTonKho = Integer.parseInt(txtSoLuongTonKho.getText());
            long maDanhMuc = Long.parseLong(txtMaDanhMuc.getText());
            
            LocalDateTime ngayCapNhat = LocalDateTime.now();

            // Tạo đối tượng sản phẩm mới với thông tin cập nhật
            SanPham sp = new SanPham();
            sp.setMaSanPham(maSanPham);
            sp.setTenSanPham(tenSanPham);
            sp.setGia(gia);
            sp.setGiamGia(giamGia);
            sp.setHinhAnh("default.png");
            sp.setTuKhoa("..");
            sp.setMoTa(moTa);
            sp.setSoLuongTonKho(soLuongTonKho);
            sp.setNgayCapNhat(ngayCapNhat);
            sp.setMaDanhMuc(maDanhMuc);

            // Gọi phương thức cập nhật sản phẩm từ lớp SanPhamDAO
            boolean result = SanPhamDAO.capNhatSanPham(sp);
            if (result) {
                JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thất bại");
            }
    }//GEN-LAST:event_jbtCapNhatMouseClicked

    private void jbtLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtLuuMouseClicked
        // TODO add your handling code here:
        long maSanPham = Long.parseLong(txtMaSanPham.getText());
            String tenSanPham = txtTenSanPham.getText();
            BigDecimal gia = new BigDecimal(txtGia.getText());
            int giamGia = Integer.parseInt(txtGiamGia.getText());
            String moTa = txtMoTa.getText();
            int soLuongTonKho = Integer.parseInt(txtSoLuongTonKho.getText());
            long maDanhMuc = Long.parseLong(txtMaDanhMuc.getText());
            
            // Ngày tạo và ngày cập nhật là ngày hiện tại
            LocalDateTime ngayTao = LocalDateTime.now();
            LocalDateTime ngayCapNhat = LocalDateTime.now();
            SanPham sp = new SanPham();
            sp.setMaSanPham(maSanPham);
            sp.setTenSanPham(tenSanPham);
            sp.setGia(gia);
            sp.setGiamGia(giamGia);
            sp.setHinhAnh("defaul.png");
            sp.setTuKhoa("...");
            sp.setMoTa(moTa);
            sp.setSoLuongTonKho(soLuongTonKho);
            sp.setNgayTao(ngayTao);
            sp.setNgayCapNhat(ngayCapNhat);
            sp.setMaDanhMuc(maDanhMuc);
            boolean result = SanPhamDAO.themSanPham(sp);
            if (result) {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại");
            }
    }//GEN-LAST:event_jbtLuuMouseClicked

    private void jbtTaiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtTaiLaiActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_jbtTaiLaiActionPerformed

    private void jbtThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtThemActionPerformed

    private void jbtXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtXoaActionPerformed

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaActionPerformed

    private void txtGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiamGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiamGiaActionPerformed

    void loadData(){
        ArrayList<SanPham> dsSanPham = SanPhamDAO.layDanhSachSanPham();
        DefaultTableModel dtmSanPham = (DefaultTableModel)tblDanhSachSanPham.getModel();
        dtmSanPham.setRowCount(0);
        for(SanPham sp:dsSanPham)
        {
            Vector<Object> vec = new Vector<Object>();
            vec.add(sp.getMaSanPham());
            vec.add(sp.getTenSanPham());
            vec.add(sp.getGia());
            vec.add(sp.getGiamGia());
            vec.add(sp.getMoTa());
            vec.add(sp.getSoLuongTonKho());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            // Sử dụng DateTimeFormatter để định dạng lại ngày tạo thành chuỗi ngày/tháng/năm
            String ngayTaoFormatted = sp.getNgayTao().format(formatter);
            vec.add(ngayTaoFormatted);
            // Sử dụng DateTimeFormatter để định dạng lại ngày tạo thành chuỗi ngày/tháng/năm
            String ngayCapNhatFormatted = sp.getNgayCapNhat().format(formatter);
            vec.add(ngayCapNhatFormatted);
            vec.add(sp.getMaDanhMuc());
            dtmSanPham.addRow(vec);
        }
        tblDanhSachSanPham.setModel(dtmSanPham);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtCapNhat;
    private javax.swing.JButton jbtLuu;
    private javax.swing.JButton jbtSua;
    private javax.swing.JButton jbtTaiLai;
    private javax.swing.JButton jbtThem;
    private javax.swing.JButton jbtXoa;
    private javax.swing.JTable tblDanhSachSanPham;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMaDanhMuc;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSoLuongTonKho;
    private javax.swing.JTextField txtTenSanPham;
    // End of variables declaration//GEN-END:variables
}
