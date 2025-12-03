/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main_package;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class ViewProductsFrame extends javax.swing.JFrame {

    DashboardFrame frame = new DashboardFrame(false, "");

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
        loadProductsAllLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        updatePrdctsButton = new javax.swing.JButton();
        cozyCrateLogo = new javax.swing.JLabel();
        updatePrdctsButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        beveragesTable = new javax.swing.JLabel();
        butcheryTable = new javax.swing.JLabel();
        dessertsTable = new javax.swing.JLabel();
        fruitsTable = new javax.swing.JLabel();
        groceryTable = new javax.swing.JLabel();
        readyMealsTable = new javax.swing.JLabel();
        bakeryTable = new javax.swing.JLabel();
        seafoodsTable = new javax.swing.JLabel();
        vegetablesTable = new javax.swing.JLabel();
        snacksTable = new javax.swing.JLabel();
        tableNameSetter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(228, 166, 107));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loadProductsAllLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/products category label.png"))); // NOI18N
        loadProductsAllLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loadProductsAllLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadProductsAllLabelMouseClicked(evt);
            }
        });
        jPanel1.add(loadProductsAllLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 420, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/products details.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 17, -1, 40));

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
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 150, 40));

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
        jPanel1.add(updatePrdctsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 160, 40));

        cozyCrateLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo - admin.png"))); // NOI18N
        cozyCrateLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(cozyCrateLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 440, -1, 90));

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
        jPanel1.add(updatePrdctsButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 160, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/goto dashboard indicator icon.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, -1, -1));

        beveragesTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/beverages icon admin.png"))); // NOI18N
        beveragesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        beveragesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                beveragesTableMouseClicked(evt);
            }
        });
        jPanel1.add(beveragesTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 340, -1, -1));

        butcheryTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/butchery icon admin.png"))); // NOI18N
        butcheryTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butcheryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butcheryTableMouseClicked(evt);
            }
        });
        jPanel1.add(butcheryTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 70, -1, 90));

        dessertsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/desserts icon admin.png"))); // NOI18N
        dessertsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dessertsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dessertsTableMouseClicked(evt);
            }
        });
        jPanel1.add(dessertsTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 340, -1, -1));

        fruitsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fruits icon admin.png"))); // NOI18N
        fruitsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fruitsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fruitsTableMouseClicked(evt);
            }
        });
        jPanel1.add(fruitsTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 250, -1, -1));

        groceryTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/grocery icon admin.png"))); // NOI18N
        groceryTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        groceryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                groceryTableMouseClicked(evt);
            }
        });
        jPanel1.add(groceryTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 250, -1, -1));

        readyMealsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ready meals icon admin.png"))); // NOI18N
        readyMealsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        readyMealsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                readyMealsTableMouseClicked(evt);
            }
        });
        jPanel1.add(readyMealsTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, -1, -1));

        bakeryTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bakery icon admin.png"))); // NOI18N
        bakeryTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bakeryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bakeryTableMouseClicked(evt);
            }
        });
        jPanel1.add(bakeryTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, -1, 90));

        seafoodsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seafoods icon admin'.png"))); // NOI18N
        seafoodsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seafoodsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seafoodsTableMouseClicked(evt);
            }
        });
        jPanel1.add(seafoodsTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 100, 110));

        vegetablesTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vegetables icon admin.png"))); // NOI18N
        vegetablesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vegetablesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vegetablesTableMouseClicked(evt);
            }
        });
        jPanel1.add(vegetablesTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 160, 90, -1));

        snacksTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/snacks icon admin.png"))); // NOI18N
        snacksTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        snacksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                snacksTableMouseClicked(evt);
            }
        });
        jPanel1.add(snacksTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 250, -1, -1));

        tableNameSetter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tableNameSetter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tableNameSetter.setText("All Category Table");
        jPanel1.add(tableNameSetter, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 650, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
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
        } catch (NullPointerException e) {
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

            // Get values from table
            int productId = (int) productsTable.getValueAt(row, 0);
            String name = productsTable.getValueAt(row, 1).toString();
            int category = Integer.parseInt(productsTable.getValueAt(row, 2).toString());
            float price = Float.parseFloat(productsTable.getValueAt(row, 3).toString());
            int quantity = Integer.parseInt(productsTable.getValueAt(row, 4).toString());
            String imagePath = dbManager.getImagePath(productId);

            // Open update frame and pass data + this table frame
            UpdateProductsFrame updateFrame = new UpdateProductsFrame(
                    this, productId, name, category, price, quantity, imagePath
            );

            updateFrame.setVisible(true);
            if (imagePath != null && !imagePath.isEmpty()) {
                ImageIcon icon = new ImageIcon(imagePath);

                // Optional: scale image to fit label
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(
                        updateFrame.lblImagePreview.getWidth(),
                        updateFrame.lblImagePreview.getHeight(),
                        Image.SCALE_SMOOTH
                );
                updateFrame.lblImagePreview.setIcon(new ImageIcon(scaledImg));

            }
            updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch(NullPointerException e){
            JOptionPane.showMessageDialog(this, "Please select a valid row to update");
        }
       
    }//GEN-LAST:event_updatePrdctsButtonActionPerformed

    private void updatePrdctsButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePrdctsButton1ActionPerformed
        AddProductsFrame addFrame = new AddProductsFrame(this);
        addFrame.setVisible(true);
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_updatePrdctsButton1ActionPerformed

    private void bakeryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bakeryTableMouseClicked
        dbManager.loadProductsByCategory(productsTable, 2);
        tableNameSetter.setText("Bakery Table (2)");
    }//GEN-LAST:event_bakeryTableMouseClicked

    private void butcheryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcheryTableMouseClicked
       dbManager.loadProductsByCategory(productsTable, 3);
       tableNameSetter.setText("Butchery Table (3)");
    }//GEN-LAST:event_butcheryTableMouseClicked

    private void seafoodsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seafoodsTableMouseClicked
        dbManager.loadProductsByCategory(productsTable, 4);
        tableNameSetter.setText("Seafoods Table (4)");
    }//GEN-LAST:event_seafoodsTableMouseClicked

    private void readyMealsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readyMealsTableMouseClicked
        dbManager.loadProductsByCategory(productsTable, 5);
        tableNameSetter.setText("Ready Meals Table (5)");
    }//GEN-LAST:event_readyMealsTableMouseClicked

    private void vegetablesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vegetablesTableMouseClicked
        dbManager.loadProductsByCategory(productsTable, 6);
        tableNameSetter.setText("Vegetables Table (6)");
    }//GEN-LAST:event_vegetablesTableMouseClicked

    private void fruitsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fruitsTableMouseClicked
        dbManager.loadProductsByCategory(productsTable, 7);
        tableNameSetter.setText("Fruits Table (7)");
    }//GEN-LAST:event_fruitsTableMouseClicked

    private void groceryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groceryTableMouseClicked
       dbManager.loadProductsByCategory(productsTable, 8);
       tableNameSetter.setText("Grocery Table (8)");
    }//GEN-LAST:event_groceryTableMouseClicked

    private void snacksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_snacksTableMouseClicked
        dbManager.loadProductsByCategory(productsTable, 9);
        tableNameSetter.setText("Snacks Table (9)");
    }//GEN-LAST:event_snacksTableMouseClicked

    private void dessertsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dessertsTableMouseClicked
       dbManager.loadProductsByCategory(productsTable, 10);
        tableNameSetter.setText("Desserts Table (10)");
    }//GEN-LAST:event_dessertsTableMouseClicked

    private void beveragesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beveragesTableMouseClicked
        dbManager.loadProductsByCategory(productsTable, 11);
        tableNameSetter.setText("Beverages Table (11)");
    }//GEN-LAST:event_beveragesTableMouseClicked

    private void loadProductsAllLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadProductsAllLabelMouseClicked
       dbManager.loadProducts(productsTable); 
       tableNameSetter.setText("All Category Table");
    }//GEN-LAST:event_loadProductsAllLabelMouseClicked

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
    private javax.swing.JLabel bakeryTable;
    private javax.swing.JLabel beveragesTable;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel butcheryTable;
    private javax.swing.JLabel cozyCrateLogo;
    private javax.swing.JLabel dessertsTable;
    private javax.swing.JLabel fruitsTable;
    private javax.swing.JLabel groceryTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel loadProductsAllLabel;
    private javax.swing.JTable productsTable;
    private javax.swing.JLabel readyMealsTable;
    private javax.swing.JLabel seafoodsTable;
    private javax.swing.JLabel snacksTable;
    private javax.swing.JLabel tableNameSetter;
    private javax.swing.JButton updatePrdctsButton;
    private javax.swing.JButton updatePrdctsButton1;
    private javax.swing.JLabel vegetablesTable;
    // End of variables declaration//GEN-END:variables
}
