/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main_package;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class ViewProductsFrame extends javax.swing.JFrame {

    DashboardFrame frame = new DashboardFrame(false, null);
    public ViewProductsFrame() {
        initComponents();
        dbManager.loadProducts(productsTable);
        setLocationRelativeTo(null);
        styleTableHeader();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Listener.addLabelListenerDontClose(cozyCrateLogo, this, frame);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        updatePrdctsButton = new javax.swing.JButton();
        cozyCrateLogo = new javax.swing.JLabel();
        updatePrdctsButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(228, 166, 107));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/products category icons.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/products category label.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 420, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/products details.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        productsTable.setBackground(new java.awt.Color(246, 212, 142));
        productsTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Product Name", "Category", "Price", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productsTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 650, 320));

        btnDelete.setBackground(new java.awt.Color(169, 122, 98));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete Product");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, 150, 40));

        updatePrdctsButton.setBackground(new java.awt.Color(169, 122, 98));
        updatePrdctsButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updatePrdctsButton.setForeground(new java.awt.Color(255, 255, 255));
        updatePrdctsButton.setText("Update Product");
        updatePrdctsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updatePrdctsButton.setFocusable(false);
        updatePrdctsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePrdctsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(updatePrdctsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 160, 40));

        cozyCrateLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo - admin.png"))); // NOI18N
        cozyCrateLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(cozyCrateLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 420, -1, 90));

        updatePrdctsButton1.setBackground(new java.awt.Color(169, 122, 98));
        updatePrdctsButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updatePrdctsButton1.setForeground(new java.awt.Color(255, 255, 255));
        updatePrdctsButton1.setText("Add Product");
        updatePrdctsButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updatePrdctsButton1.setFocusable(false);
        updatePrdctsButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePrdctsButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(updatePrdctsButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 160, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/goto dashboard indicator icon.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       
        try{
             int row = productsTable.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product to delete!");
            return;
        }

        // Assuming 'id' is in column 0
        int productId = (int) productsTable.getValueAt(row, 0);

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete this product?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            DatabaseManager db = new DatabaseManager();
            db.deleteProduct(productId);
            db.loadProducts(productsTable);
        }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(this, "Please select a valid row to delete");
        }
       
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void updatePrdctsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePrdctsButtonActionPerformed
        try{
            int row = productsTable.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a product to update!");
                return;
            }

            int productId = (int) productsTable.getValueAt(row, 0);
            String name = productsTable.getValueAt(row, 1).toString();
            float price = Float.parseFloat(productsTable.getValueAt(row, 2).toString());
            int quantity = (int) Float.parseFloat(productsTable.getValueAt(row, 3).toString());
            int category = Integer.parseInt(productsTable.getValueAt(row, 4).toString());
            String imagePath = null;

            UpdateProductsFrame updateFrame = new UpdateProductsFrame(
                    this, productId, name, price, quantity, category, imagePath
            );

            updateFrame.setVisible(true);
            updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }catch(NullPointerException e){
            
             JOptionPane.showMessageDialog(rootPane, "Please select a valid row to update!");
        }
        
        
    }//GEN-LAST:event_updatePrdctsButtonActionPerformed

    private void updatePrdctsButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePrdctsButton1ActionPerformed
        AddProductsFrame addFrame = new AddProductsFrame(this);
        addFrame.setVisible(true);
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_updatePrdctsButton1ActionPerformed

    private void styleTableHeader() {
        JTableHeader header = productsTable.getTableHeader();

        header.setFont(new Font("Segoe UI", Font.BOLD, 13));
        header.setForeground(Color.WHITE);
        header.setBackground(new Color(169, 122, 98));
        header.setPreferredSize(new Dimension(header.getWidth(), 29));

        DefaultTableCellRenderer renderer
                = (DefaultTableCellRenderer) header.getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
    }

    public void refreshTable() {
        System.out.println("Refreshing table...");
        dbManager.loadProducts(productsTable); 
        productsTable.revalidate();
        productsTable.repaint();
    }
    
    DatabaseManager dbManager = new DatabaseManager();

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
            java.util.logging.Logger.getLogger(ViewProductsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProductsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProductsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProductsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewProductsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel cozyCrateLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productsTable;
    private javax.swing.JButton updatePrdctsButton;
    private javax.swing.JButton updatePrdctsButton1;
    // End of variables declaration//GEN-END:variables
}
