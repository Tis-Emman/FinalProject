
package adjacencylist;

import java.awt.Image;
import javax.swing.ImageIcon;

public class MainFrame extends javax.swing.JFrame {
    
    static DatabaseManager dbManager = new DatabaseManager();

    public MainFrame() {
        initComponents();
        scaleImage();
    }
    
    private void scaleImage() {
    ImageIcon icon = new ImageIcon(getClass().getResource("/src/aux_1.jpg"));
    Image img = icon.getImage();
    Image imgScale = img.getScaledInstance(aux_1.getWidth(), aux_1.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(imgScale);
    aux_1.setIcon(scaledIcon);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aux_1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        aux_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/aux_1.jpg"))); // NOI18N
        aux_1.setText("jLabel2");

        jLabel3.setText("AUX Split Type");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(675, 675, 675)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aux_1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jLabel3)))))
                .addContainerGap(987, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(aux_1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addContainerGap(655, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aux_1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
