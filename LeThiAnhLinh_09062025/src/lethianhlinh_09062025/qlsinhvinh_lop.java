/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lethianhlinh_09062025;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anhlinh
 */
public class qlsinhvinh_lop extends javax.swing.JFrame {

    /**
     * Creates new form qlsinhvinh_lop
     */
    public qlsinhvinh_lop() {
        initComponents();
    }

    public void loadLop() {
        DefaultTableModel model = (DefaultTableModel) tblLop.getModel();
        model.setRowCount(0);

        try {
            Connection conn = DBConnect.getDBConnect();

            String sql = "SELECT * FROM Lop";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String maLop = rs.getString("maLop");
                String tenLop = rs.getString("tenLop");
                String cvht = rs.getString("cvht");

                model.addRow(new Object[]{maLop, tenLop, cvht});

            }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadSinhVien() {
        DefaultTableModel model = (DefaultTableModel) tblSv.getModel();
        model.setRowCount(0);

        try {
            Connection conn = DBConnect.getDBConnect();
            String sql = "SELECT * FROM SinhVien";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String maSV = rs.getString("maSV");
                String maLop = rs.getString("maLop");
                String hoTen = rs.getString("hoTen");
                Date ngaySinh = rs.getDate("ngaySinh");
                model.addRow(new Object[]{maSV, maLop, hoTen, ngaySinh});

            }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadSinhVienLop() {
        DefaultTableModel model = (DefaultTableModel) tblSinhvien_Lop.getModel();
        model.setRowCount(0); // clear dữ liệu cũ

        try {
            Connection conn = DBConnect.getDBConnect();

            String sql = "SELECT SinhVien.maSV, SinhVien.maLop, SinhVien.hoTen, SinhVien.ngaySinh,\n"
                    + "       Lop.tenLop, Lop.cvht\n"
                    + "FROM SinhVien\n"
                    + "JOIN Lop ON SinhVien.maLop = Lop.maLop";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("maSV"),
                    rs.getString("maLop"),
                    rs.getString("hoTen"),
                    rs.getDate("ngaySinh"),
                    rs.getString("tenLop"),
                    rs.getString("cvht")
                });

            }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHienthi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSinhvien_Lop = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLop = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSv = new javax.swing.JTable();
        btnSuaLop = new javax.swing.JButton();
        txtTenlop = new javax.swing.JTextField();
        txtCVHT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMasv = new javax.swing.JTextField();
        txtMalop = new javax.swing.JTextField();
        txtHoten = new javax.swing.JTextField();
        txtNgaysinh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnThemSv = new javax.swing.JButton();
        txtMa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnHienthi.setText("Hien thi");
        btnHienthi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienthiActionPerformed(evt);
            }
        });

        tblSinhvien_Lop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ma Sv", "Ma lop", "Ho ten", "Ngay sinh", "Ten lop", "cvht"
            }
        ));
        jScrollPane1.setViewportView(tblSinhvien_Lop);

        tblLop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ma lop", "Ten lop", "cvht"
            }
        ));
        tblLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLopMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLop);

        tblSv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma sv", "Ma Lop", "Ho ten", "Ngay sinh"
            }
        ));
        tblSv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSvMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSv);

        btnSuaLop.setText("Sua Lop");
        btnSuaLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaLopActionPerformed(evt);
            }
        });

        jLabel1.setText("Ten Lop");

        jLabel2.setText("CVHT");

        jLabel3.setText("Masv");

        jLabel4.setText("Ma Lop");

        jLabel5.setText("Ngay sinh");

        jLabel7.setText("Ho ten");

        btnThemSv.setText("Them Sinh Vien");
        btnThemSv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSvActionPerformed(evt);
            }
        });

        txtMa.setEditable(false);
        txtMa.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel6.setText("Ma");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel8.setText("QUAN LY SINH VIEN - LOP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)
                                .addComponent(txtTenlop, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel7))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel5)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtHoten)
                                        .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCVHT)
                                        .addComponent(txtMasv)
                                        .addComponent(txtMalop, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSuaLop)
                        .addGap(100, 100, 100))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnThemSv)
                .addGap(81, 81, 81))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(397, 397, 397)
                        .addComponent(btnHienthi, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnHienthi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenlop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCVHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSuaLop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMalop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(18, 18, 18)
                .addComponent(btnThemSv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHienthiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienthiActionPerformed
        // TODO add your handling code here:
        loadLop();
        loadSinhVien();
        loadSinhVienLop();

    }//GEN-LAST:event_btnHienthiActionPerformed

    private void btnSuaLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaLopActionPerformed
        // TODO add your handling code here:

        String maLop = txtMa.getText().trim();
        String tenLopMoi = txtTenlop.getText().trim();
        String cvhtMoi = txtCVHT.getText().trim();

        if (maLop.isEmpty() || tenLopMoi.isEmpty() || cvhtMoi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
            return;
        }

        try {
            Connection conn = DBConnect.getDBConnect();
            String sql = "UPDATE Lop SET tenLop = ?, cvht = ? WHERE maLop = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenLopMoi);
            ps.setString(2, cvhtMoi);
            ps.setString(3, maLop);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                loadLop();
                loadSinhVien();
                loadSinhVienLop();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy lớp để cập nhật");
            }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật lớp");
        }
    }//GEN-LAST:event_btnSuaLopActionPerformed

    private void btnThemSvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSvActionPerformed
        String maSV = txtMasv.getText().trim();
        String maLop = txtMalop.getText().trim();
        String hoTen = txtHoten.getText().trim();
        String ngaySinh = txtNgaysinh.getText().trim();

        if (maSV.isEmpty() || maLop.isEmpty() || hoTen.isEmpty() || ngaySinh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
            return;
        }

        try {
            Connection conn = DBConnect.getDBConnect();

            String checkLop = "SELECT * FROM Lop WHERE maLop = ?";
            PreparedStatement psCheck = conn.prepareStatement(checkLop);
            psCheck.setString(1, maLop);
            ResultSet rs = psCheck.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Mã lớp không tồn tại");
                conn.close();
                return;
            }

            String sql = "INSERT INTO SinhVien (maSV, maLop, hoTen, ngaySinh) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSV);
            ps.setString(2, maLop);
            ps.setString(3, hoTen);
            ps.setDate(4, Date.valueOf(ngaySinh));
            int rows = ps.executeUpdate();

            if (rows > 0) {
                loadSinhVien();
                loadSinhVienLop();
                JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm sinh viên");
        }
    }//GEN-LAST:event_btnThemSvActionPerformed

    private void tblLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLopMouseClicked
        // TODO add your handling code here:
        int row = tblLop.getSelectedRow();
        if (row >= 0) {
            txtMa.setText(tblLop.getValueAt(row, 0).toString());
            txtTenlop.setText(tblLop.getValueAt(row, 1).toString());
            txtCVHT.setText(tblLop.getValueAt(row, 2).toString());
        }
    }//GEN-LAST:event_tblLopMouseClicked

    private void tblSvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSvMouseClicked
        // TODO add your handling code here:
//        
//        
//        int row = tblSv.getSelectedRow();
//    if (row >= 0) {
//        txtMa.setText(tblSv.getValueAt(row, 0).toString());
//        txtMalop.setText(tblSv.getValueAt(row, 1).toString());
//        txtHoten.setText(tblSv.getValueAt(row, 2).toString());
//        txtNgaysinh.setText(tblSv.getValueAt(row, 3).toString());
//    }
//        
        
    }//GEN-LAST:event_tblSvMouseClicked

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
            java.util.logging.Logger.getLogger(qlsinhvinh_lop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(qlsinhvinh_lop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(qlsinhvinh_lop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(qlsinhvinh_lop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new qlsinhvinh_lop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHienthi;
    private javax.swing.JButton btnSuaLop;
    private javax.swing.JButton btnThemSv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblLop;
    private javax.swing.JTable tblSinhvien_Lop;
    private javax.swing.JTable tblSv;
    private javax.swing.JTextField txtCVHT;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMalop;
    private javax.swing.JTextField txtMasv;
    private javax.swing.JTextField txtNgaysinh;
    private javax.swing.JTextField txtTenlop;
    // End of variables declaration//GEN-END:variables
}
