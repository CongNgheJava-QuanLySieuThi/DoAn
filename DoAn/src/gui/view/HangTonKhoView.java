package gui.view;

import dao.HangTonKhoService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import pojo.HangTonKho;

public class HangTonKhoView extends javax.swing.JPanel {

    private final HangTonKhoService service = new HangTonKhoService();

    public HangTonKhoView() {
        initComponents();
        initComponents();
        loadTable();
        resetSearchFieldBtn.setEnabled(true);
        deleteBtn.setEnabled(false);
        fromDatePicker.setDate(LocalDate.now().minusMonths(1));
        toDatePicker.setDate(LocalDate.now());
        statusInsertField.setSelectedItem(1);
        loadThongKe(LocalDate.now().minusMonths(1), LocalDate.now());
        addEvents();
    }

    private void addEvents() {
        fromDatePicker.addDateChangeListener((dce) -> {
            LocalDate newDate = dce.getNewDate();

            if (newDate.isAfter(toDatePicker.getDate())
                    || newDate.equals(toDatePicker.getDate())) {
                toDatePicker.setDate(newDate.plusDays(1));
            }

            loadThongKe(newDate, toDatePicker.getDate());
        });

        toDatePicker.addDateChangeListener((dce) -> {
            LocalDate newDate = dce.getNewDate();

            if (newDate.isBefore(fromDatePicker.getDate())
                    || newDate.equals(fromDatePicker.getDate())) {
                fromDatePicker.setDate(newDate.minusDays(1));
            }
            loadThongKe(fromDatePicker.getDate(), newDate);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
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
        totalPriceLabel2 = new javax.swing.JLabel();
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        maSPInsertField = new javax.swing.JTextField();
        statusInsertField = new javax.swing.JComboBox<>();
        importDayInsertDatePicker = new gui.view.components.datepicker.DatePicker();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tongDonHangLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        tongDoanhThuLabel = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        hangTonKhoKhaDungLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        fromDatePicker = new gui.view.components.datepicker.DatePicker();
        toDatePicker = new gui.view.components.datepicker.DatePicker();

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "#", "Số lượng trong kho", "Ngày nhập hàng", "Ngày xuất hàng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabletableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table);

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

        jLabel16.setText("Thông tin hàng tồn kho");
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        jLabel17.setText("Ngày nhập hàng");

        jLabel18.setText("Số lượng");
        jLabel18.setPreferredSize(new java.awt.Dimension(100, 16));

        jLabel19.setText("Nhập kho");
        jLabel19.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N

        totalPriceLabel2.setText("Trạng thái");

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

        jLabel22.setText("Xuất kho");
        jLabel22.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N

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

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resetEditFormBtn))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateBtn)
                            .addComponent(quantityEditField, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(exportDayEditDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, 0))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetEditFormBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityEditField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(exportDayEditDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(updateBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("Mã sản phẩm");

        statusInsertField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trong kho", "Xuất kho", "Hết hàng", "Hỏng hóc" }));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalPriceLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(statusInsertField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quantityInsertField, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(importDayInsertDatePicker, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(maSPInsertField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insertBtn)))
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(resetInsertFormBtn)))
                .addGap(0, 0, 0))
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
                    .addComponent(totalPriceLabel2)
                    .addComponent(statusInsertField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(maSPInsertField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(insertBtn)
                .addGap(15, 15, 15)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setPreferredSize(new java.awt.Dimension(1164, 100));

        jLabel11.setText("Thống kê");
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.X_AXIS));

        jPanel7.setPreferredSize(new java.awt.Dimension(300, 254));

        jLabel10.setText("Tổng số hàng nhập kho");
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        tongDonHangLabel.setText("0");
        tongDonHangLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tongDonHangLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(tongDonHangLabel)
                .addContainerGap())
        );

        jPanel6.add(jPanel7);

        jPanel8.setPreferredSize(new java.awt.Dimension(300, 0));

        jLabel13.setText("Tổng số hàng xuất kho");
        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        tongDoanhThuLabel.setText("0");
        tongDoanhThuLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tongDoanhThuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tongDoanhThuLabel)
                .addContainerGap())
        );

        jPanel6.add(jPanel8);

        jLabel1.setText("Hàng tồn kho khả dụng");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        hangTonKhoKhaDungLabel.setText("0");
        hangTonKhoKhaDungLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(hangTonKhoKhaDungLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hangTonKhoKhaDungLabel)
                .addGap(0, 0, 0))
        );

        jPanel6.add(jPanel9);

        jLabel12.setText("Bắt đầu");

        jLabel14.setText("Kết thúc");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(fromDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(toDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
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
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn)
                            .addComponent(deleteBtn)
                            .addComponent(resetSearchFieldBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabletableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabletableMouseClicked
        deleteBtn.setEnabled(true);
        int selectedRow = table.getSelectedRow();
        TableModel tableModel = table.getModel();
        if (selectedRow != -1) {
            fillFields(tableModel, selectedRow);
        }
    }//GEN-LAST:event_tabletableMouseClicked

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
        int selectedRow = table.getSelectedRow();
        TableModel tableModel = table.getModel();
        if (selectedRow != -1) {
            int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?");
            if (showConfirmDialog == 0) {
                Long id = Long.valueOf(tableModel.getValueAt(selectedRow, 0).toString());
                JOptionPane.showMessageDialog(null, service.xoaHangTonKho(id));
                loadTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn hàng để xóa!");
        }
    }//GEN-LAST:event_deleteBtndeleteBtnActionPerformed

    private void resetSearchFieldBtnresetSearchFieldBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetSearchFieldBtnresetSearchFieldBtnActionPerformed
        searchField.setText("");
        loadTable();
        resetSearchFieldBtn.setEnabled(true);
    }//GEN-LAST:event_resetSearchFieldBtnresetSearchFieldBtnActionPerformed

    private void insertBtninsertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtninsertBtnActionPerformed
        if (validateFields(quantityInsertField) && validateFields(statusInsertField) && importDayInsertDatePicker != null) {
            String soLuong = quantityInsertField.getText();
            LocalDate ngayNhap = importDayInsertDatePicker.getDate();
            String trangThai = statusInsertField.getSelectedItem().toString();
            HangTonKho donHangMoi = taoHangTonKho(Long.valueOf(soLuong), trangThai);
            if (donHangMoi == null) {
                return;
            }
            donHangMoi.setNgayNhapHang(ngayNhap.atStartOfDay());
            Long maSP = Long.valueOf(maSPInsertField.getText());
            donHangMoi.setMaSanPham(maSP);

            String response = validateFields(maSPInsertField)
                    ? service.them(donHangMoi)
                    : service.capNhatHangTonKho(maSP, donHangMoi);

            JOptionPane.showMessageDialog(this.getParent(), response);

            loadTable();
            clearFields(quantityInsertField, maSPInsertField);
            clearFields(statusInsertField);
        }
    }//GEN-LAST:event_insertBtninsertBtnActionPerformed

    private void resetInsertFormBtnresetInsertFormBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetInsertFormBtnresetInsertFormBtnActionPerformed
        clearFields(quantityInsertField, maSPInsertField);
        clearFields(statusInsertField);
        importDayInsertDatePicker.setDate(null);
    }//GEN-LAST:event_resetInsertFormBtnresetInsertFormBtnActionPerformed

    private void updateBtnupdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnupdateBtnActionPerformed
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng nào");
            return;
        }
        if (validateFields(quantityEditField) && exportDayEditDatePicker != null) {
            TableModel tableModel = table.getModel();
            Long maHang = Long.valueOf(tableModel.getValueAt(selectedRow, 0).toString());
            Long soLuong = Long.valueOf(quantityEditField.getText());
            LocalDate exportDay = exportDayEditDatePicker.getDate();
            HangTonKho donHangMoi = new HangTonKho();
            donHangMoi.setSoLuongTrongKho(soLuong);
            donHangMoi.setNgayXuatHang(exportDay == null ? null : exportDay.atStartOfDay());
            JOptionPane.showMessageDialog(null, service.capNhatHangTonKhoVaSanPham(maHang, donHangMoi));
            loadTable();
            clearFields(quantityEditField);
        }
    }//GEN-LAST:event_updateBtnupdateBtnActionPerformed

    private void resetEditFormBtnresetEditFormBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetEditFormBtnresetEditFormBtnActionPerformed
        clearFields(quantityEditField);
        exportDayEditDatePicker.setDate(null);
    }//GEN-LAST:event_resetEditFormBtnresetEditFormBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private gui.view.components.datepicker.DatePicker exportDayEditDatePicker;
    private gui.view.components.datepicker.DatePicker fromDatePicker;
    private javax.swing.JLabel hangTonKhoKhaDungLabel;
    private gui.view.components.datepicker.DatePicker importDayInsertDatePicker;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
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
    private javax.swing.JComboBox<String> statusInsertField;
    private javax.swing.JTable table;
    private gui.view.components.datepicker.DatePicker toDatePicker;
    private javax.swing.JLabel tongDoanhThuLabel;
    private javax.swing.JLabel tongDonHangLabel;
    private javax.swing.JLabel totalPriceLabel2;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

    private void loadTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        table.setRowHeight(35);
        model.setRowCount(0);
        List<HangTonKho> danhSach = service.danhSachHangTonKho();
        for (HangTonKho row : danhSach) {
            model.addRow(row.toRow());
        }

        table.setModel(model);
        resetSearchFieldBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
    }

    private void fillFields(TableModel tableModel, int selectedRow) {
        quantityEditField.setText(tableModel.getValueAt(selectedRow, 1).toString());
        String value = tableModel.getValueAt(selectedRow, 2).toString();
        importDayInsertDatePicker.setDate(LocalDate.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    private boolean validateFields(JTextField... inputs) {
        for (JTextField input : inputs) {
            if (input.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private boolean validateFields(JComboBox<String>... inputs) {
        for (JComboBox<String> input : inputs) {
            if (input.getSelectedItem() == null || input.getSelectedItem().toString().isEmpty()) {
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

    private void clearFields(JComboBox<String>... inputs) {
        for (JComboBox<String> input : inputs) {
            input.setSelectedItem(null);
        }
    }

    private void search(Long maHang) {
        HangTonKho rowData = service.timTheoMaSanPham(maHang);
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        if (rowData != null) {
            tableModel.addRow(rowData.toRow());
        }

        table.setModel(tableModel);
    }

    private HangTonKho taoHangTonKho(Long soLuong, String trangThai) {
        try {
            return new HangTonKho(
                    soLuong,
                    trangThai
            );
        } catch (NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại giá trị đầu vào!");
            return null;
        }
    }

    private void loadThongKe(LocalDate from, LocalDate to) {
        Map<Integer, Object> statistics = service.thongKeTheoPhamVi(from, to);
        if (statistics == null) {
            return;
        }

        tongDonHangLabel.setText(statistics.get(1).toString() + " sản phẩm");
        tongDoanhThuLabel.setText(statistics.get(2).toString() + " sản phẩm");
        hangTonKhoKhaDungLabel.setText(statistics.get(3).toString() + " sản phẩm");
    }
}
