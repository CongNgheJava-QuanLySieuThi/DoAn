package gui.view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import pojo.SQLServerDataProvider;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author DELL
 */
public class ChiTietHoaDonView extends javax.swing.JFrame {

    private SQLServerDataProvider dataProvider;

    DefaultTableModel dtm = new DefaultTableModel();
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public ChiTietHoaDonView(long maHD) {

        initComponents();
        String[] tieuDe = {"Mã hóa đơn", "Tên sản phẩm", "Giá", "Giảm giá", "Số lượng mua", "Tổng tiền"};
        dtm = new NonEditableTableModel(tieuDe);
        dtm = new NonEditableTableModel(tieuDe);
        dgvCTHD.setModel(dtm);
        dataProvider = new SQLServerDataProvider();
        dataProvider.open();
        connection = dataProvider.getConnection();
        setLocationRelativeTo(null);
        hienThongTinHoaDon(maHD);
        loadBang(maHD);
        tinhTongTien();

    }

    private ChiTietHoaDonView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Creates new form ChiTietHoaDonView
     */
    private void hienThongTinHoaDon(long maHD) {
        String query = "SELECT H.MAHD, N.TEN, H.NGAYTAO FROM HOADON H JOIN NGUOIDUNG N ON H.MAND = N.MAND WHERE H.[MAHD] = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, maHD);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                lbMHD.setText(rs.getString("MAHD"));
                lbNguoitao.setText(rs.getString("TEN")); // Sử dụng tên cột chính xác
                // Lấy giá trị DateTime từ cột NGAYTAO
                java.sql.Timestamp ngayTaoTimestamp = rs.getTimestamp("NGAYTAO");
                // Chuyển đổi Timestamp thành kiểu Date
                java.util.Date ngayTaoDate = new java.util.Date(ngayTaoTimestamp.getTime());
                // Format ngày thành chuỗi chỉ chứa ngày, tháng và năm
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                String ngayTaoFormatted = sdf.format(ngayTaoDate);
                lbNgayTao.setText(ngayTaoFormatted);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadBang(long maHD) {
        String query = "SELECT [MAHD], [TENSP], [GIA], [GIAMGIA], [SOLUONGMUA], [TONGTIEN] FROM [dbo].[CHITIETHOADON] WHERE [MAHD] = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, maHD);
            ResultSet rs = pstmt.executeQuery();

            // Sử dụng NumberFormat cho tiền Việt Nam
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);;

            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getInt("MAHD"),
                    rs.getString("TENSP"),
                    currencyFormat.format(rs.getDouble("GIA")),
                    rs.getDouble("GIAMGIA"),
                    rs.getInt("SOLUONGMUA"),
                    currencyFormat.format(rs.getDouble("TONGTIEN"))
                };
                dtm.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataProvider.close();
        }
    }

    private void tinhTongTien() {
        double tongTien = 0.0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String tongTienStr = dtm.getValueAt(i, 5).toString();
            tongTienStr = tongTienStr.replace("$", "").replace(",", "").replaceAll("[^\\d.]", "");
            tongTien += Double.parseDouble(tongTienStr);
        }
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        jlbThanhTien.setText(currencyFormat.format(tongTien));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvCTHD = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jlbThanhTien = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnXHDPDF = new javax.swing.JButton();
        btnXHDEX = new javax.swing.JButton();
        lbMHD1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbMHD = new javax.swing.JLabel();
        lbNguoitao = new javax.swing.JLabel();
        lbNgayTao = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setForeground(new java.awt.Color(255, 51, 51));

        dgvCTHD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dgvCTHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dgvCTHD.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(dgvCTHD);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Thành Tiền:");

        jlbThanhTien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbThanhTien.setForeground(new java.awt.Color(255, 102, 102));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        btnXHDPDF.setText("Xuất Hóa Đơn PDF");
        btnXHDPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXHDPDFActionPerformed(evt);
            }
        });

        btnXHDEX.setText("Xuất Hóa Đơn EXCEL");
        btnXHDEX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXHDEXActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnXHDPDF)
                                .addGap(88, 88, 88)
                                .addComponent(btnXHDEX))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlbThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXHDPDF)
                    .addComponent(btnXHDEX))
                .addGap(24, 24, 24))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Mã Hóa Đơn:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Người Tạo:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Ngày Tạo:");

        lbMHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMHD.setForeground(new java.awt.Color(255, 0, 51));
        lbMHD.setText("hello");

        lbNguoitao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNguoitao.setText("jLabel11");

        lbNgayTao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNgayTao.setText("jLabel12");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Chi Tiết Hóa Đơn");

        javax.swing.GroupLayout lbMHD1Layout = new javax.swing.GroupLayout(lbMHD1);
        lbMHD1.setLayout(lbMHD1Layout);
        lbMHD1Layout.setHorizontalGroup(
            lbMHD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbMHD1Layout.createSequentialGroup()
                .addGroup(lbMHD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbMHD1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbMHD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(lbNguoitao, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lbMHD1Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lbMHD1Layout.setVerticalGroup(
            lbMHD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbMHD1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lbMHD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(lbMHD)
                    .addComponent(lbNguoitao)
                    .addComponent(lbNgayTao))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMHD1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lbMHD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void xuatDuLieuRaExcel() {
        // Tạo workbook và sheet Excel mới
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("DuLieuFormVaJTable");

        // Dòng hiện tại để viết dữ liệu
        int currentRow = 0;

        // Tiêu đề của sheet
        XSSFRow titleRow = sheet.createRow(currentRow++);
        XSSFCell titleCell = titleRow.createCell(0, CellType.STRING);
        titleCell.setCellValue("Thông tin hóa đơn và chi tiết");

        // Tiêu đề của sheet (thuộc tính từ label và JTable)
        XSSFRow labelTitleRow = sheet.createRow(currentRow++);
        XSSFCell labelTitleCell = labelTitleRow.createCell(0, CellType.STRING);
        labelTitleCell.setCellValue("Thông tin từ label và JTable");

        // Tạo một XSSFCellStyle để đặt căn giữa và đặt định dạng in đậm màu đỏ
        XSSFCellStyle boldRedStyle = workbook.createCellStyle();
        boldRedStyle.setAlignment(HorizontalAlignment.CENTER);
        XSSFFont boldRedFont = workbook.createFont();
        boldRedFont.setBold(true);
        boldRedFont.setColor(IndexedColors.RED.getIndex());
        boldRedStyle.setFont(boldRedFont);

        // Thêm thông tin từ các label vào tệp Excel
        String[] labelInfo = {"Mã Hóa đơn:", "Người tạo:", "Ngày tạo:"};
        for (int i = 0; i < 3; i++) { // Số lượng label bạn có thể điều chỉnh tùy theo số lượng JLabels bạn có
            JLabel label;
            switch (i) {
                case 0:
                    label = lbMHD;
                    break;
                case 1:
                    label = lbNguoitao;
                    break;
                case 2:
                    label = lbNgayTao;
                    break;
                default:
                    label = null;
                    break;
            }
            if (label != null) {
                // Tạo ô mới trong dòng cho thông tin của mỗi label
                XSSFCell infoLabelCell = labelTitleRow.createCell(i * 2, CellType.STRING);
                infoLabelCell.setCellValue(labelInfo[i]);
                infoLabelCell.setCellStyle(boldRedStyle); // Đặt căn giữa và định dạng in đậm màu đỏ cho ô

                // Tạo ô mới trong dòng cho giá trị của mỗi label
                XSSFCell valueLabelCell = labelTitleRow.createCell(i * 2 + 1, CellType.STRING);
                valueLabelCell.setCellValue(label.getText());
                valueLabelCell.setCellStyle(boldRedStyle); // Đặt căn giữa và định dạng in đậm màu đỏ cho ô
            }
        }

        // Tạo hai dòng trống giữa thông tin từ label và tiêu đề của JTable
        currentRow += 2;

        // Tạo hàng cho tiêu đề cột (thuộc tính từ JTable)
        XSSFRow headerRow = sheet.createRow(currentRow++);
        int columnCount = dgvCTHD.getColumnCount();
        for (int j = 0; j < columnCount; j++) {
            Object columnName = dgvCTHD.getColumnName(j);
            XSSFCell headerCell = headerRow.createCell(j, CellType.STRING);
            headerCell.setCellValue(String.valueOf(columnName));
            headerCell.setCellStyle(boldRedStyle); // Đặt căn giữa và định dạng in đậm màu đỏ cho ô
        }

        // Xuất dữ liệu từ JTable (thuộc tính từ JTable)
        int rowCount = dgvCTHD.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            XSSFRow row = sheet.createRow(currentRow++);
            for (int j = 0; j < columnCount; j++) {
                Object cellValue = dgvCTHD.getValueAt(i, j);
                XSSFCell cell = row.createCell(j, CellType.STRING);
                cell.setCellValue(String.valueOf(cellValue));
            }
        }

        // Tạo một dòng trống nữa giữa dữ liệu của JTable và label "Tổng tiền"
        currentRow += 2;
        String totalString = jlbThanhTien.getText();
        // Loại bỏ ký tự "$" và dấu phẩy từ chuỗi và chuyển đổi thành kiểu số
        BigDecimal totalPrice = new BigDecimal(totalString.replaceAll("[$,]", ""));
        // Label "Tổng tiền"
        XSSFRow totalRow = sheet.createRow(currentRow++);
        XSSFCell totalCell = totalRow.createCell(0, CellType.STRING);
        totalCell.setCellValue("Tổng tiền:");
        totalCell.setCellStyle(boldRedStyle); // Đặt căn giữa và định dạng in đậm màu đỏ cho ô
        XSSFCell totalValueCell = totalRow.createCell(1, CellType.NUMERIC);
        totalValueCell.setCellValue(totalPrice.doubleValue());
        totalCell.setCellStyle(boldRedStyle); // Đặt căn giữa và định dạng in đậm màu đỏ cho ô
        JOptionPane.showMessageDialog(this, "Xuất hóa đơn ra EXCEL thành công!");

        // Lưu workbook vào một tập tin Excel
        try (FileOutputStream fileOut = new FileOutputStream("DuLieuFormVaJTable.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel file exported successfully: DuLieuFormVaJTable.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnXHDEXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXHDEXActionPerformed
        xuatDuLieuRaExcel();

        // Tiếp theo, bạn có thể ghi workbook vào một tập tin Excel

    }//GEN-LAST:event_btnXHDEXActionPerformed

    private void btnXHDPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXHDPDFActionPerformed
        String maHDString = lbMHD.getText();

        if (maHDString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hóa đơn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        long maHD;
        try {
            maHD = Long.parseLong(maHDString);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Mã hóa đơn không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return; // Kết thúc phương thức nếu chuỗi không thể chuyển đổi thành số
        }

        // Kết nối tới cơ sở dữ liệu và lấy thông tin hóa đơn
        SQLServerDataProvider dataProvider = new SQLServerDataProvider();
        dataProvider.open();

        try {
            // Truy vấn để lấy thông tin hóa đơn và thông tin người dùng
            String sql = "SELECT HOADON.MAHD, HOADON.NgayTao, NGUOIDUNG.TEN "
                    + "FROM HOADON "
                    + "JOIN NGUOIDUNG ON HOADON.MAND = NGUOIDUNG.MAND "
                    + "WHERE HOADON.MAHD = " + maHD;
            ResultSet rs = dataProvider.executeQuery(sql);

            if (rs.next()) {
                // Lấy thông tin chi tiết hóa đơn
                String sqlDetails = "SELECT * FROM CHITIETHOADON WHERE MAHD = " + maHD;
                ResultSet rsDetails = dataProvider.executeQuery(sqlDetails);

                // Tạo tài liệu PDF
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream("HoaDon_" + maHD + ".pdf"));
                document.open();

                // Thêm tiêu đề
                Font boldRedFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
                Paragraph title = new Paragraph("HOA DON BAN HANG", boldRedFont);
                title.setAlignment(Element.ALIGN_CENTER);
                document.add(title);

                // Thêm thông tin từ các label
                String[] labelInfo = {"Ma hoa don", "Nguoi Tao", "Ngay tao:"};
                JLabel[] labels = {lbMHD, lbNguoitao, lbNgayTao};
                for (int i = 0; i < labels.length; i++) {
                    Paragraph p = new Paragraph(labelInfo[i] + " " + labels[i].getText(), boldRedFont);
                    document.add(p);
                }

                document.add(new Paragraph(" ")); // Thêm khoảng trắng

                // Tạo bảng chi tiết hóa đơn
                PdfPTable table = new PdfPTable(dgvCTHD.getColumnCount());
                table.setWidthPercentage(100);
                table.setSpacingBefore(10f);
                table.setSpacingAfter(10f);

                // Thêm tiêu đề cột của bảng
                for (int j = 0; j < dgvCTHD.getColumnCount(); j++) {
                    PdfPCell headerCell = new PdfPCell(new Phrase(dgvCTHD.getColumnName(j), boldRedFont));
                    headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(headerCell);
                }

                // Thêm dữ liệu từ JTable
                for (int i = 0; i < dgvCTHD.getRowCount(); i++) {
                    for (int j = 0; j < dgvCTHD.getColumnCount(); j++) {
                        Object cellValue = dgvCTHD.getValueAt(i, j);
                        PdfPCell cell = new PdfPCell(new Phrase(String.valueOf(cellValue)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);
                    }
                }

                document.add(table);

                // Thêm thông tin tổng tiền
                document.add(new Paragraph(" ")); // Thêm khoảng trắng
                Paragraph totalParagraph = new Paragraph("Tong Tien " + jlbThanhTien.getText(), boldRedFont);
                document.add(totalParagraph);

                document.close();

                JOptionPane.showMessageDialog(this, "Xuất hóa đơn ra PDF thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | DocumentException | FileNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi xuất hóa đơn ra PDF: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {
            dataProvider.close();
        }
    }//GEN-LAST:event_btnXHDPDFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietHoaDonView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXHDEX;
    private javax.swing.JButton btnXHDPDF;
    private javax.swing.JTable dgvCTHD;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlbThanhTien;
    private javax.swing.JLabel lbMHD;
    private javax.swing.JPanel lbMHD1;
    private javax.swing.JLabel lbNgayTao;
    private javax.swing.JLabel lbNguoitao;
    // End of variables declaration//GEN-END:variables
}
