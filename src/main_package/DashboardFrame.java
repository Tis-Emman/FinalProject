package main_package;

import java.awt.Color;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class DashboardFrame extends javax.swing.JFrame {
    
    static boolean isLoggedIn;
    SignUpFrame signUpFrame = new SignUpFrame();
    DatabaseManager dbManager = new DatabaseManager();
    
    LoginFrame loginFrame = new LoginFrame(this);
    
    public DashboardFrame(boolean isLoggedIn, String email) {
        JLayeredPane layeredPane = new JLayeredPane();
        JPanel newPanel = new JPanel();
        JPanel topFrame = new JPanel();
        JPanel bottomFrame = new JPanel();
        
        newPanel.setBackground(new Color(255, 255, 254));
        newPanel.setBounds(0, 0, 1600, 120);
        newPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        
        topFrame.setBackground(new Color(25, 145, 77));
        topFrame.setBounds(0, 0, 1600, 30);
        
        bottomFrame.setBackground(new Color(25, 145, 77));
        bottomFrame.setBounds(0, 680, 1600, 105);
        bottomFrame.setLayout(null);
        
       
        
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        sidebarPanel.setBorder(new MatteBorder(0, 0, 0, 3, new Color(25, 145, 77)));
           
       
        
       defaultLeft(bakeryButton);
       defaultLeft(butcheryButton);
       defaultLeft(seafoodsButton);
       defaultLeft(button4);
       defaultLeft(button5);
       defaultLeft(button6);
       defaultLeft(button7);
       defaultLeft(button8);
       defaultLeft(button9);
       defaultLeft(button10);
       defaultLeft(newProductsButton);
       
       Listener.addLabelListener(gotoLoginButton, this, loginFrame);
       Listener.addLabelListener(gotoLoginImage, this, loginFrame);
       Listener.addLabelListener(gotoRegisterImage, this, signUpFrame);
       Listener.addLabelListener(gotoRegisterButton, this, signUpFrame);
       
       add(newPanel);
       add(bottomFrame);
       
       DashboardFrame.isLoggedIn = true;
       
       if(isLoggedIn){
           gotoLoginImage.setVisible(false);
           gotoLoginButton.setVisible(false);
           gotoRegisterButton.setText("MY ACCOUNT");
           
        for (java.awt.event.MouseListener listener : gotoRegisterImage.getMouseListeners()) {
        gotoRegisterImage.removeMouseListener(listener);
        }

         System.out.println(email);
         String rt = dbManager.retrieveUsername(email);        
       }
       
       hideAllPanels();
       setPanelSizes();
       landingPanel.setVisible(true);
    }
    
    private void defaultLeft(JButton btn){
         btn.setBorder(BorderFactory.createCompoundBorder(null, BorderFactory.createEmptyBorder(0, 20, 0,0)));
    }
    
    private void setPanelSizes() {
    int width = 975;
    int height = 550;

    newProductsPanel.setSize(width, height);
    readyMealsPanel.setSize(width, height);
    seaFoodsPanel.setSize(width, height);
    dessertsPanel.setSize(width, height);
    fruitsPanel.setSize(width, height);
    bakeryPanel.setSize(width, height);
    butcheryPanel.setSize(width, height);
    vegetablesPanel.setSize(width, height);
    groceryPanel.setSize(width, height);
}
    
    private void hideAllPanels(){
        newProductsPanel.setVisible(false);
        readyMealsPanel.setVisible(false);
        seaFoodsPanel.setVisible(false);
        dessertsPanel.setVisible(false);
        fruitsPanel.setVisible(false);
        bakeryPanel.setVisible(false);
        butcheryPanel.setVisible(false);
        vegetablesPanel.setVisible(false);
        groceryPanel.setVisible(false);
        snacksPanel.setVisible(false);
        winesPanel.setVisible(false);
        landingPanel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        sidebarPanel = new javax.swing.JPanel();
        bakeryButton = new javax.swing.JButton();
        butcheryButton = new javax.swing.JButton();
        seafoodsButton = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button7 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        newProductsButton = new javax.swing.JButton();
        button10 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        landingPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        newProductsPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        bakeryPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        butcheryPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        readyMealsPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        vegetablesPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        fruitsPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        groceryPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        snacksPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        dessertsPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        winesPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        seaFoodsPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        gotoLoginImage = new javax.swing.JLabel();
        gotoLoginButton = new javax.swing.JLabel();
        gotoRegisterImage = new javax.swing.JLabel();
        gotoRegisterButton = new javax.swing.JLabel();
        myCartImage = new javax.swing.JLabel();
        myCartButton = new javax.swing.JLabel();
        cartCount = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        sidebarPanel.setBackground(new java.awt.Color(255, 255, 254));

        bakeryButton.setBackground(new java.awt.Color(255, 255, 254));
        bakeryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bakery icon.png"))); // NOI18N
        bakeryButton.setText("Bakery");
        bakeryButton.setBorder(null);
        bakeryButton.setFocusable(false);
        bakeryButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        bakeryButton.setIconTextGap(14);
        bakeryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bakeryButtonActionPerformed(evt);
            }
        });

        butcheryButton.setBackground(new java.awt.Color(255, 255, 254));
        butcheryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/butchery icon.png"))); // NOI18N
        butcheryButton.setText("Butchery");
        butcheryButton.setBorder(null);
        butcheryButton.setFocusable(false);
        butcheryButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryButton.setIconTextGap(14);
        butcheryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butcheryButtonActionPerformed(evt);
            }
        });

        seafoodsButton.setBackground(new java.awt.Color(255, 255, 254));
        seafoodsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seafoods icon.png"))); // NOI18N
        seafoodsButton.setText("Seafoods");
        seafoodsButton.setBorder(null);
        seafoodsButton.setFocusable(false);
        seafoodsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsButton.setIconTextGap(14);
        seafoodsButton.setInheritsPopupMenu(true);
        seafoodsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seafoodsButtonActionPerformed(evt);
            }
        });

        button4.setBackground(new java.awt.Color(255, 255, 254));
        button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ready meals icon.png"))); // NOI18N
        button4.setText("Ready Meals");
        button4.setBorder(null);
        button4.setFocusable(false);
        button4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        button4.setIconTextGap(14);
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button5.setBackground(new java.awt.Color(255, 255, 254));
        button5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vegetables icon.png"))); // NOI18N
        button5.setText("Vegetables");
        button5.setBorder(null);
        button5.setFocusable(false);
        button5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        button5.setIconTextGap(14);
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        button6.setBackground(new java.awt.Color(255, 255, 254));
        button6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fruits icon.png"))); // NOI18N
        button6.setText("Fruits");
        button6.setBorder(null);
        button6.setFocusable(false);
        button6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        button6.setIconTextGap(14);
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        button7.setBackground(new java.awt.Color(255, 255, 254));
        button7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/grocery icon.png"))); // NOI18N
        button7.setText("Grocery");
        button7.setBorder(null);
        button7.setFocusable(false);
        button7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        button7.setIconTextGap(14);
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        button8.setBackground(new java.awt.Color(255, 255, 254));
        button8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/snacks icon.png"))); // NOI18N
        button8.setText("Snacks");
        button8.setBorder(null);
        button8.setFocusable(false);
        button8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        button8.setIconTextGap(14);
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        button9.setBackground(new java.awt.Color(255, 255, 254));
        button9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/desserts icon.png"))); // NOI18N
        button9.setText("Desserts");
        button9.setBorder(null);
        button9.setFocusable(false);
        button9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        button9.setIconTextGap(14);
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        newProductsButton.setBackground(new java.awt.Color(255, 255, 254));
        newProductsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new products icon.png"))); // NOI18N
        newProductsButton.setText("New Products");
        newProductsButton.setBorder(null);
        newProductsButton.setFocusable(false);
        newProductsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsButton.setIconTextGap(14);
        newProductsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProductsButtonActionPerformed(evt);
            }
        });

        button10.setBackground(new java.awt.Color(255, 255, 254));
        button10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/wine icon.png"))); // NOI18N
        button10.setText("Wines");
        button10.setBorder(null);
        button10.setFocusable(false);
        button10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        button10.setIconTextGap(14);
        button10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
        sidebarPanel.setLayout(sidebarPanelLayout);
        sidebarPanelLayout.setHorizontalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seafoodsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butcheryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bakeryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newProductsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(button10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sidebarPanelLayout.setVerticalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(newProductsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bakeryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butcheryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seafoodsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(25, 145, 77));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jLayeredPane1.setBackground(new java.awt.Color(102, 102, 255));

        landingPanel.setBackground(new java.awt.Color(243, 243, 243));
        landingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(243, 243, 243));
        jLabel1.setText("landing page");
        landingPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jButton1.setText("-");
        landingPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 70, -1));

        jButton2.setText("+ ");
        landingPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 90, -1));

        jLabel21.setText("TEST THAT SHIT");
        landingPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, -1, -1));

        newProductsPanel.setBackground(new java.awt.Color(243, 243, 243));
        newProductsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(243, 243, 243));
        jLabel2.setText("new products");
        newProductsPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        newProductsPanel.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 28, 160, 161));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        newProductsPanel.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 170, 161));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        newProductsPanel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 170, 161));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        newProductsPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 160, 161));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        newProductsPanel.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 170, 160));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        newProductsPanel.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 30, 170, 160));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        newProductsPanel.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 170, 161));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        newProductsPanel.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 160, 161));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        newProductsPanel.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 160, 161));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        newProductsPanel.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 170, 161));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        newProductsPanel.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 250, 170, 160));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        newProductsPanel.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 250, 170, 160));

        bakeryPanel.setBackground(new java.awt.Color(243, 243, 243));
        bakeryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(243, 243, 243));
        jLabel3.setText("bakery");
        bakeryPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 166, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        bakeryPanel.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, 161));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 166, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        bakeryPanel.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, 161));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 166, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        bakeryPanel.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, -1, 161));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 166, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );

        bakeryPanel.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 166, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        bakeryPanel.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, -1, 161));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 166, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        bakeryPanel.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, -1, 161));

        butcheryPanel.setBackground(new java.awt.Color(243, 243, 243));

        jLabel4.setBackground(new java.awt.Color(243, 243, 243));
        jLabel4.setText("butchery");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout butcheryPanelLayout = new javax.swing.GroupLayout(butcheryPanel);
        butcheryPanel.setLayout(butcheryPanelLayout);
        butcheryPanelLayout.setHorizontalGroup(
            butcheryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(butcheryPanelLayout.createSequentialGroup()
                .addGroup(butcheryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(butcheryPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(butcheryPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1022, Short.MAX_VALUE))
        );
        butcheryPanelLayout.setVerticalGroup(
            butcheryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(butcheryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(373, Short.MAX_VALUE))
        );

        readyMealsPanel.setBackground(new java.awt.Color(243, 243, 243));

        jLabel6.setBackground(new java.awt.Color(243, 243, 243));
        jLabel6.setText("ready meals");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout readyMealsPanelLayout = new javax.swing.GroupLayout(readyMealsPanel);
        readyMealsPanel.setLayout(readyMealsPanelLayout);
        readyMealsPanelLayout.setHorizontalGroup(
            readyMealsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(readyMealsPanelLayout.createSequentialGroup()
                .addGroup(readyMealsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(readyMealsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(readyMealsPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1041, Short.MAX_VALUE))
        );
        readyMealsPanelLayout.setVerticalGroup(
            readyMealsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(readyMealsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(390, Short.MAX_VALUE))
        );

        vegetablesPanel.setBackground(new java.awt.Color(243, 243, 243));

        jLabel7.setBackground(new java.awt.Color(243, 243, 243));
        jLabel7.setText("vegetables");

        javax.swing.GroupLayout vegetablesPanelLayout = new javax.swing.GroupLayout(vegetablesPanel);
        vegetablesPanel.setLayout(vegetablesPanelLayout);
        vegetablesPanelLayout.setHorizontalGroup(
            vegetablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vegetablesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(1139, Short.MAX_VALUE))
        );
        vegetablesPanelLayout.setVerticalGroup(
            vegetablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vegetablesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(513, Short.MAX_VALUE))
        );

        fruitsPanel.setBackground(new java.awt.Color(243, 243, 243));

        jLabel8.setBackground(new java.awt.Color(243, 243, 243));
        jLabel8.setText("fruits");

        javax.swing.GroupLayout fruitsPanelLayout = new javax.swing.GroupLayout(fruitsPanel);
        fruitsPanel.setLayout(fruitsPanelLayout);
        fruitsPanelLayout.setHorizontalGroup(
            fruitsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fruitsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(1174, Short.MAX_VALUE))
        );
        fruitsPanelLayout.setVerticalGroup(
            fruitsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fruitsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(518, Short.MAX_VALUE))
        );

        groceryPanel.setBackground(new java.awt.Color(243, 243, 243));

        jLabel9.setBackground(new java.awt.Color(243, 243, 243));
        jLabel9.setText("grocery");

        javax.swing.GroupLayout groceryPanelLayout = new javax.swing.GroupLayout(groceryPanel);
        groceryPanel.setLayout(groceryPanelLayout);
        groceryPanelLayout.setHorizontalGroup(
            groceryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groceryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(1155, Short.MAX_VALUE))
        );
        groceryPanelLayout.setVerticalGroup(
            groceryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groceryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(518, Short.MAX_VALUE))
        );

        snacksPanel.setBackground(new java.awt.Color(243, 243, 243));

        jLabel10.setBackground(new java.awt.Color(243, 243, 243));
        jLabel10.setText("snacks");

        javax.swing.GroupLayout snacksPanelLayout = new javax.swing.GroupLayout(snacksPanel);
        snacksPanel.setLayout(snacksPanelLayout);
        snacksPanelLayout.setHorizontalGroup(
            snacksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(snacksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(1160, Short.MAX_VALUE))
        );
        snacksPanelLayout.setVerticalGroup(
            snacksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(snacksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(518, Short.MAX_VALUE))
        );

        dessertsPanel.setBackground(new java.awt.Color(243, 243, 243));

        jLabel11.setBackground(new java.awt.Color(243, 243, 243));
        jLabel11.setText("desserts");

        javax.swing.GroupLayout dessertsPanelLayout = new javax.swing.GroupLayout(dessertsPanel);
        dessertsPanel.setLayout(dessertsPanelLayout);
        dessertsPanelLayout.setHorizontalGroup(
            dessertsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dessertsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(1153, Short.MAX_VALUE))
        );
        dessertsPanelLayout.setVerticalGroup(
            dessertsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dessertsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(518, Short.MAX_VALUE))
        );

        winesPanel.setBackground(new java.awt.Color(243, 243, 243));

        jLabel12.setText("wines");

        javax.swing.GroupLayout winesPanelLayout = new javax.swing.GroupLayout(winesPanel);
        winesPanel.setLayout(winesPanelLayout);
        winesPanelLayout.setHorizontalGroup(
            winesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(winesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(1165, Short.MAX_VALUE))
        );
        winesPanelLayout.setVerticalGroup(
            winesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(winesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(537, Short.MAX_VALUE))
        );

        seaFoodsPanel.setBackground(new java.awt.Color(243, 243, 243));

        jLabel5.setBackground(new java.awt.Color(243, 243, 243));
        jLabel5.setText("seafoods");

        javax.swing.GroupLayout seaFoodsPanelLayout = new javax.swing.GroupLayout(seaFoodsPanel);
        seaFoodsPanel.setLayout(seaFoodsPanelLayout);
        seaFoodsPanelLayout.setHorizontalGroup(
            seaFoodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seaFoodsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(1148, Short.MAX_VALUE))
        );
        seaFoodsPanelLayout.setVerticalGroup(
            seaFoodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seaFoodsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(522, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(landingPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(newProductsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(bakeryPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(butcheryPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(readyMealsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(vegetablesPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(fruitsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(groceryPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(snacksPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(dessertsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(winesPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(seaFoodsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(landingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(newProductsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(bakeryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(butcheryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(readyMealsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(vegetablesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(fruitsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(groceryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(snacksPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dessertsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(winesPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(seaFoodsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(landingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(newProductsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 21, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(bakeryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 14, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(butcheryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 16, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(readyMealsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 19, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(vegetablesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 24, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(fruitsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 19, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(groceryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 19, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(snacksPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 19, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(dessertsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 19, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(winesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(seaFoodsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("GROUP 4 - FINAL PROJECT ");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("DITO ILALAGAY OTHER FRAMES/PAGE OR FUNCTIONS - Brainstorm nalang");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setText("SEARCHBAR?");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        jLabel13.setText("DITO ILALAGAY ANG LOGO");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        gotoLoginImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/login icon.png"))); // NOI18N
        jPanel6.add(gotoLoginImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 20, -1, -1));

        gotoLoginButton.setBackground(new java.awt.Color(25, 145, 77));
        gotoLoginButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gotoLoginButton.setForeground(new java.awt.Color(153, 153, 153));
        gotoLoginButton.setText("LOGIN");
        jPanel6.add(gotoLoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 70, -1, -1));

        gotoRegisterImage.setBackground(new java.awt.Color(25, 145, 77));
        gotoRegisterImage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gotoRegisterImage.setForeground(new java.awt.Color(153, 153, 153));
        gotoRegisterImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/register icon.png"))); // NOI18N
        jPanel6.add(gotoRegisterImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 20, -1, -1));

        gotoRegisterButton.setBackground(new java.awt.Color(25, 145, 77));
        gotoRegisterButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gotoRegisterButton.setForeground(new java.awt.Color(153, 153, 153));
        gotoRegisterButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gotoRegisterButton.setText("REGISTER");
        jPanel6.add(gotoRegisterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 70, 210, 20));

        myCartImage.setBackground(new java.awt.Color(25, 145, 77));
        myCartImage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        myCartImage.setForeground(new java.awt.Color(153, 153, 153));
        myCartImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cart icon.png"))); // NOI18N
        jPanel6.add(myCartImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 30, -1, 37));

        myCartButton.setBackground(new java.awt.Color(25, 145, 77));
        myCartButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        myCartButton.setForeground(new java.awt.Color(153, 153, 153));
        myCartButton.setText("MY CART");
        jPanel6.add(myCartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 70, -1, -1));

        cartCount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cartCount.setForeground(new java.awt.Color(255, 102, 102));
        cartCount.setText("0");
        jPanel6.add(cartCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 10, 20, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel18)
                                .addGap(102, 102, 102)
                                .addComponent(jLabel19)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sidebarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, Short.MAX_VALUE))
                .addGap(0, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private JButton selectedButton = null;
    private boolean isClicked = false;
 
    private void bakeryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bakeryButtonActionPerformed

       selectButton(bakeryButton);
       addLeftGreenColor(bakeryButton);
       hideAllPanels();
       bakeryPanel.setVisible(true);
    }//GEN-LAST:event_bakeryButtonActionPerformed

    private void butcheryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butcheryButtonActionPerformed
       selectButton(butcheryButton);
       addLeftGreenColor(butcheryButton);
       hideAllPanels();
       butcheryPanel.setVisible(true);
       
    }//GEN-LAST:event_butcheryButtonActionPerformed

    private void seafoodsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seafoodsButtonActionPerformed
       selectButton(seafoodsButton);
       addLeftGreenColor(seafoodsButton);
       hideAllPanels();
       seaFoodsPanel.setVisible(true);
    }//GEN-LAST:event_seafoodsButtonActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
       selectButton(button4);
       addLeftGreenColor(button4);
       hideAllPanels();
       readyMealsPanel.setVisible(true);
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
       selectButton(button5);
       addLeftGreenColor(button5);
       hideAllPanels();
       vegetablesPanel.setVisible(true);
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
       selectButton(button6);
       addLeftGreenColor(button6);
       hideAllPanels();
       fruitsPanel.setVisible(true);
    }//GEN-LAST:event_button6ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
       selectButton(button7);
       addLeftGreenColor(button7);
       hideAllPanels();
       groceryPanel.setVisible(true);
    }//GEN-LAST:event_button7ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
       selectButton(button8);
       addLeftGreenColor(button8);
       hideAllPanels();
       snacksPanel.setVisible(true);
    }//GEN-LAST:event_button8ActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
       selectButton(button9);
       addLeftGreenColor(button9);
       hideAllPanels();
       dessertsPanel.setVisible(true);
    }//GEN-LAST:event_button9ActionPerformed
    
    private void newProductsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProductsButtonActionPerformed
       selectButton(newProductsButton);
       addLeftGreenColor(newProductsButton);
       hideAllPanels();
       newProductsPanel.setVisible(true);
    }//GEN-LAST:event_newProductsButtonActionPerformed

    private void button10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button10ActionPerformed
       selectButton(button10);
       addLeftGreenColor(button10);
       hideAllPanels();
       winesPanel.setVisible(true);
    }//GEN-LAST:event_button10ActionPerformed

    private void selectButton(JButton btn){
        if(selectedButton != null){
            selectedButton.setBackground(Color.WHITE);
            selectedButton.setForeground(Color.black);
            selectedButton.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, new Color(255, 255, 254)));
            selectedButton.setBorder(BorderFactory.createCompoundBorder(null, BorderFactory.createEmptyBorder(0, 20, 0,0)));
        }
        
        btn.setBackground(new Color(242, 242, 243));
        btn.setForeground(new Color(25, 145, 77));
        selectedButton = btn;
    }
    
    private void addLeftGreenColor(JButton btn){
        btn.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 3, 0, 0, new Color(25, 145, 77)),
        BorderFactory.createEmptyBorder(0, 20, 0,0)
        ));
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardFrame(true, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bakeryButton;
    private javax.swing.JPanel bakeryPanel;
    private javax.swing.JButton butcheryButton;
    private javax.swing.JPanel butcheryPanel;
    private javax.swing.JButton button10;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel cartCount;
    private javax.swing.JPanel dessertsPanel;
    private javax.swing.JPanel fruitsPanel;
    private javax.swing.JLabel gotoLoginButton;
    public javax.swing.JLabel gotoLoginImage;
    private javax.swing.JLabel gotoRegisterButton;
    private javax.swing.JLabel gotoRegisterImage;
    private javax.swing.JPanel groceryPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel landingPanel;
    private javax.swing.JLabel myCartButton;
    private javax.swing.JLabel myCartImage;
    private javax.swing.JButton newProductsButton;
    private javax.swing.JPanel newProductsPanel;
    private javax.swing.JPanel readyMealsPanel;
    private javax.swing.JPanel seaFoodsPanel;
    private javax.swing.JButton seafoodsButton;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JPanel snacksPanel;
    private javax.swing.JPanel vegetablesPanel;
    private javax.swing.JPanel winesPanel;
    // End of variables declaration//GEN-END:variables

}
