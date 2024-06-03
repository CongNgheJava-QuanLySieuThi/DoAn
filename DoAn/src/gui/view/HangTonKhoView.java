package gui.view;

import dao.HangTonKhoService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import pojo.HangTonKho;
import pojo.Recordable;

public class HangTonKhoView extends javax.swing.JPanel {

    private final HangTonKhoService service = new HangTonKhoService();

    public HangTonKhoView() {
        initComponents();
        initComponents();
        loadTable(htkInfoTable, "HTK");
        loadTable(hxkInfoTable, "HXK");
        loadTable(hnkInfoTable, "HNK");

        resetSearchFieldBtn.setEnabled(true);
        deleteBtn.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        htkInfoTable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        resetSearchFieldBtn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        quantityInsertField = new javax.swing.JTextField();
        insertBtn = new javax.swing.JButton();
        resetInsertFormBtn = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        quantityEditField = new javax.swing.JTextField();
        updateBtn = new javax.swing.JButton();
        resetEditFormBtn = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        exportDayEditDatePicker = new gui.view.components.datepicker.DatePicker();
        jLabel3 = new javax.swing.JLabel();
        exportIdField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        exportNameField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        maSPInsertField = new javax.swing.JTextField();
        importDayInsertDatePicker = new gui.view.components.datepicker.DatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        hnkInfoTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        hxkInfoTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jScrollPane5.setBorder(null);
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        htkInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "Tên sản phẩm", "Số lượng trong kho", "Ngày tạo", "Ngày cập nhật", "Mã sản phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        htkInfoTable.getTableHeader().setReorderingAllowed(false);
        htkInfoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                htkInfoTabletableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(htkInfoTable);

        jLabel15.setText("Tìm kiếm");
        jLabel15.setPreferredSize(new java.awt.Dimension(60, 16));

        searchBtn.setText("Tìm");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnsearchBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Xóa");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtndeleteBtnActionPerformed(evt);
            }
        });

        resetSearchFieldBtn.setText("Làm mới");
        resetSearchFieldBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetSearchFieldBtnresetSearchFieldBtnActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel16.setText("Thông tin hàng tồn kho");

        jLabel17.setText("Ngày nhập hàng");

        jLabel18.setText("Số lượng");
        jLabel18.setPreferredSize(new java.awt.Dimension(100, 16));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel19.setText("Nhập kho");

        insertBtn.setText("Thêm");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtninsertBtnActionPerformed(evt);
            }
        });

        resetInsertFormBtn.setText("Làm mới");
        resetInsertFormBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetInsertFormBtnresetInsertFormBtnActionPerformed(evt);
            }
        });

        jLabel21.setText("Số lượng xuất");
        jLabel21.setPreferredSize(new java.awt.Dimension(100, 16));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel22.setText("Xuất kho");

        updateBtn.setText("Xuất kho");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnupdateBtnActionPerformed(evt);
            }
        });

        resetEditFormBtn.setText("Làm mới");
        resetEditFormBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetEditFormBtnresetEditFormBtnActionPerformed(evt);
            }
        });

        jLabel23.setText("Ngày xuất hàng");

        jLabel3.setText("Mã sản phẩm");

        jLabel4.setText("Tên sản phẩm");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetEditFormBtn))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(updateBtn)
                    .addComponent(exportDayEditDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(quantityEditField)
                    .addComponent(exportIdField)
                    .addComponent(exportNameField)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetEditFormBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exportIdField)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(exportNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityEditField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportDayEditDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(updateBtn)
                .addGap(0, 0, 0))
        );

        jLabel9.setText("Mã sản phẩm");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(quantityInsertField)
                                .addComponent(importDayInsertDatePicker, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                            .addComponent(maSPInsertField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insertBtn)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetInsertFormBtn))
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resetInsertFormBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityInsertField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(importDayInsertDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(maSPInsertField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(insertBtn)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        hnkInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Tên sản phẩm", "Số lượng", "Ngày nhập hàng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hnkInfoTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(hnkInfoTable);

        hxkInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "#", "Tên sản phẩm", "Số lượng xuất", "Ngày xuất hàng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hxkInfoTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(hxkInfoTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Thông tin nhập hàng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Thông tin xuất hàng");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetSearchFieldBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn)
                            .addComponent(deleteBtn)
                            .addComponent(resetSearchFieldBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jScrollPane5.setViewportView(jPanel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void htkInfoTabletableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_htkInfoTabletableMouseClicked
        deleteBtn.setEnabled(true);
        int selectedRow = htkInfoTable.getSelectedRow();
        TableModel tableModel = htkInfoTable.getModel();
        if (selectedRow != -1) {
            fillFields(tableModel, selectedRow);
        }
    }//GEN-LAST:event_htkInfoTabletableMouseClicked

    private void searchBtnsearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnsearchBtnActionPerformed
        String value = searchField.getText();
        try {
            if (!value.isEmpty()) {
                search(Long.valueOf(value));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this.getParent(), "Hãy nhập mã sản phẩm");
        }
    }//GEN-LAST:event_searchBtnsearchBtnActionPerformed

    private void deleteBtndeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtndeleteBtnActionPerformed
        int selectedRow = htkInfoTable.getSelectedRow();
        TableModel tableModel = htkInfoTable.getModel();
        if (selectedRow != -1) {
            int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?");
            if (showConfirmDialog == 0) {
                Long id = Long.valueOf(tableModel.getValueAt(selectedRow, 0).toString());
                JOptionPane.showMessageDialog(null, service.xoaHangTonKho(id));
                loadTable(htkInfoTable, "HTK");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn hàng để xóa!");
        }
    }//GEN-LAST:event_deleteBtndeleteBtnActionPerformed

    private void resetSearchFieldBtnresetSearchFieldBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetSearchFieldBtnresetSearchFieldBtnActionPerformed
        searchField.setText("");
        loadTable(htkInfoTable, "HTK");
        resetSearchFieldBtn.setEnabled(true);
    }//GEN-LAST:event_resetSearchFieldBtnresetSearchFieldBtnActionPerformed

    private void insertBtninsertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtninsertBtnActionPerformed
        if (validateFields(quantityInsertField) && importDayInsertDatePicker != null) {
            String soLuong = quantityInsertField.getText();
            LocalDate ngayNhap = importDayInsertDatePicker.getDate();
            HangTonKho donHangMoi = taoHangTonKho(Long.valueOf(soLuong));
            if (donHangMoi == null) {
                return;
            }
            donHangMoi.setNgayNhapHang(ngayNhap.atStartOfDay());
            Long maSP = !maSPInsertField.getText().isEmpty()
                    ? Long.valueOf(maSPInsertField.getText())
                    : null;
            donHangMoi.setMaSanPham(maSP);

            String response = validateFields(maSPInsertField)
                    ? service.capNhatHangTonKho(maSP, donHangMoi)
                    : service.them(donHangMoi);

            JOptionPane.showMessageDialog(this.getParent(), response);

            loadTable(htkInfoTable, "HTK");
            loadTable(hxkInfoTable, "HXK");
            loadTable(hnkInfoTable, "HNK");
            clearFields(quantityInsertField, maSPInsertField);
        }
    }//GEN-LAST:event_insertBtninsertBtnActionPerformed

    private void resetInsertFormBtnresetInsertFormBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetInsertFormBtnresetInsertFormBtnActionPerformed
        clearFields(quantityInsertField, maSPInsertField);
        importDayInsertDatePicker.setDate(null);
    }//GEN-LAST:event_resetInsertFormBtnresetInsertFormBtnActionPerformed

    private void updateBtnupdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnupdateBtnActionPerformed
        int selectedRow = htkInfoTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng nào");
            return;
        }

        if (Long.parseLong(htkInfoTable.getValueAt(selectedRow, 2).toString()) <= 0) {
            JOptionPane.showMessageDialog(null, "Số lượng hàng tồn kho không khả dụng");
            return;
        }

        if (validateFields(quantityEditField) && exportDayEditDatePicker != null) {
            TableModel tableModel = htkInfoTable.getModel();
            Long maHang = Long.valueOf(tableModel.getValueAt(selectedRow, 0).toString());
            Long soLuong = Long.valueOf(quantityEditField.getText());
            LocalDate exportDay = exportDayEditDatePicker.getDate();
            HangTonKho donHangMoi = new HangTonKho();
            donHangMoi.setSoLuongTrongKho(soLuong);
            donHangMoi.setNgayXuatHang(exportDay == null ? null : exportDay.atStartOfDay());
            JOptionPane.showMessageDialog(null, service.capNhatHangTonKhoVaSanPham(maHang, donHangMoi));
            loadTable(htkInfoTable, "HTK");
            loadTable(hxkInfoTable, "HXK");
            loadTable(hnkInfoTable, "HNK");
            clearFields(quantityEditField, exportNameField, exportIdField);
            exportDayEditDatePicker.setDate(null);
        }
    }//GEN-LAST:event_updateBtnupdateBtnActionPerformed

    private void resetEditFormBtnresetEditFormBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetEditFormBtnresetEditFormBtnActionPerformed
        clearFields(quantityEditField);
        exportDayEditDatePicker.setDate(null);
        exportIdField.setText(null);
        exportNameField.setText(null);
    }//GEN-LAST:event_resetEditFormBtnresetEditFormBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private gui.view.components.datepicker.DatePicker exportDayEditDatePicker;
    private javax.swing.JTextField exportIdField;
    private javax.swing.JTextField exportNameField;
    private javax.swing.JTable hnkInfoTable;
    private javax.swing.JTable htkInfoTable;
    private javax.swing.JTable hxkInfoTable;
    private gui.view.components.datepicker.DatePicker importDayInsertDatePicker;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField maSPInsertField;
    private javax.swing.JTextField quantityEditField;
    private javax.swing.JTextField quantityInsertField;
    private javax.swing.JButton resetEditFormBtn;
    private javax.swing.JButton resetInsertFormBtn;
    private javax.swing.JButton resetSearchFieldBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

    private void loadTable(JTable table, String type) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        table.setRowHeight(35);
        model.setRowCount(0);
        List<? extends Recordable> danhSach = new ArrayList<>();

        if (type.equals("HTK")) {
            danhSach = service.danhSachHangTonKho();
        }

        if (type.equals("HNK")) {
            danhSach = service.danhSachHangNhapKho();
        }

        if (type.equals("HXK")) {
            danhSach = service.danhSachHangXuatKho();
        }

        for (Recordable row : danhSach) {
            model.addRow(row.toRow());
        }

        table.setModel(model);
    }

    private void fillFields(TableModel tableModel, int selectedRow) {
        exportIdField.setText(tableModel.getValueAt(selectedRow, 0).toString());
        exportNameField.setText(tableModel.getValueAt(selectedRow, 1).toString());
        String value = tableModel.getValueAt(selectedRow, 3).toString();
        exportDayEditDatePicker.setDate(LocalDate.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    private boolean validateFields(JTextField... inputs) {
        for (JTextField input : inputs) {
            if (input.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void clearFields(JTextField... inputs) {
        for (JTextField input : inputs) {
            input.setText("");
        }
    }

    private void search(Long maHang) {
        HangTonKho rowData = service.timTheoMaSanPham(maHang);
        DefaultTableModel tableModel = (DefaultTableModel) htkInfoTable.getModel();
        tableModel.setRowCount(0);
        if (rowData != null) {
            tableModel.addRow(rowData.toRow());
        }

        htkInfoTable.setModel(tableModel);
    }

    private HangTonKho taoHangTonKho(Long soLuong) {
        try {
            return new HangTonKho(soLuong);
        } catch (NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại giá trị đầu vào!");
            return null;
        }
    }
}
