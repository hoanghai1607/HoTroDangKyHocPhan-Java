/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.admin;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DonDeXuat;
import model.FakeData;

/**
 *
 * @author Le Thi Ngoc
 */
public class ThongKeDeXuat extends javax.swing.JDialog {
    List<DonDeXuat> dsDon = FakeData.layDonDeXuat_Test();
    /**
     * Creates new form ThongKeDeXuat
     */
    public ThongKeDeXuat(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Thống kê đơn đề xuất");
        loadTable();
    }

    public void loadTable() {
        DefaultTableModel model = (DefaultTableModel) this.tblDonDeXuat.getModel();
        model.setRowCount(0);//reset nội dung trong bảng về 0

        Iterator<DonDeXuat> itr = dsDon.iterator();
        while (itr.hasNext()) {
            DonDeXuat x = itr.next();
            model.addRow(new Object[]{x.getMaDon(), x.getCauHoi1() + "," + x.getCauHoi2() + "," + x.getCauHoi3() + "," + x.getCauHoi4() + "," + x.getGopY()});

        }
    }
    
     public void writeDSDonToFile(List<DonDeXuat> dsDon, String filePath) {
        try {
            FileWriter wt = new FileWriter(filePath);
            PrintWriter pt = new PrintWriter(wt);
            for (DonDeXuat don : dsDon) {
                String line = String.join(",", don.getMaDon(), don.getCauHoi1(), don.getCauHoi2(),
                        don.getCauHoi3(), don.getCauHoi4(), don.getGopY());
                pt.write(line + "\n");
            }
            pt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void capNhatDS(String fileName) {
        dsDon = new ArrayList<>();
        dsDon.clear();
        for (int i = 0; i < tblDonDeXuat.getRowCount(); i++) {
            String maDon = tblDonDeXuat.getValueAt(i, 0).toString();
            String deXuat = tblDonDeXuat.getValueAt(i, 1).toString();
            String[] parts = deXuat.split(",");
            DonDeXuat ddx = new DonDeXuat(maDon, parts[0], parts[1], parts[2], parts[3], parts[4]);
            dsDon.add(ddx);
        }
        writeDSDonToFile(dsDon, fileName);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDonDeXuat = new javax.swing.JTable();
        btnExit = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXemChiTiet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblDonDeXuat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblDonDeXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã đơn", "Nội dung đơn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDonDeXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonDeXuatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDonDeXuat);

        btnExit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnExit.setText("Quay lại");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnXemChiTiet.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXemChiTiet.setText("Xem chi tiết");
        btnXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiTietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExit)
                        .addGap(73, 73, 73)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXemChiTiet))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnXoa)
                    .addComponent(btnXemChiTiet))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDonDeXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonDeXuatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDonDeXuatMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            TrangChuAdmin admin = new TrangChuAdmin();
            admin.setVisible(true); //Truy cập đến trang chủ Admin
            dispose(); //Đóng giao diện hiện tại
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int pos = this.tblDonDeXuat.getSelectedRow();
        if (pos == -1) { // Kiểm tra xem có dòng nào được chọn không
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            DonDeXuat don = dsDon.get(pos);
            if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xoá", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (dsDon.contains(don)) {
                    dsDon.remove(don);
                }
                loadTable();
                String filePath = "src/data/DonDeXuat.txt";
                capNhatDS(filePath); //cập nhật lại ds trong file txt
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        // TODO add your handling code here:
        int pos = this.tblDonDeXuat.getSelectedRow();
        if (pos == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xem chi tiết.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String maDon = (String) tblDonDeXuat.getValueAt(pos, 0);
            // Gọi giao diện xem chi tiết đề xuất , truy xuất bằng mã đơn đề xuất
            ChiTietDeXuat ctdx = new ChiTietDeXuat(this, true, maDon);
            ctdx.setVisible(true);
        }
    }//GEN-LAST:event_btnXemChiTietActionPerformed

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
            java.util.logging.Logger.getLogger(ThongKeDeXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeDeXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeDeXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeDeXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThongKeDeXuat dialog = new ThongKeDeXuat(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDonDeXuat;
    // End of variables declaration//GEN-END:variables
}
