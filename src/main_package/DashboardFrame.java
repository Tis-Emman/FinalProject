package main_package;

import java.awt.Color;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class DashboardFrame extends javax.swing.JFrame {

    /** Creates new form DashboardFrame */
    
    LoginFrame loginFrame = new LoginFrame();
    
    public DashboardFrame() {
        JLayeredPane layeredPane = new JLayeredPane();
        JPanel newPanel = new JPanel();
        JPanel topFrame = new JPanel();
        JPanel bottomFrame = new JPanel();
        
        newPanel.setBackground(new Color(255, 255, 254));
        newPanel.setBounds(0, 0, 1400, 120);
        newPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        
        topFrame.setBackground(new Color(25, 145, 77));
        topFrame.setBounds(0, 0, 1250, 30);
        
        bottomFrame.setBackground(new Color(25, 145, 77));
        bottomFrame.setBounds(0, 680, 1400, 105);
         
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        jPanel1.setBorder(new MatteBorder(0, 0, 0, 3, new Color(25, 145, 77)));
        
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
       
       
       add(newPanel);
       add(bottomFrame);
       
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
        jPanel1 = new javax.swing.JPanel();
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
        gotoLoginImage = new javax.swing.JLabel();
        gotoLoginButton = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        landingPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        newProductsPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bakeryPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        butcheryPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        seaFoodsPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        readyMealsPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 254));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
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
                .addContainerGap(35, Short.MAX_VALUE))
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

        gotoLoginImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/login icon.png"))); // NOI18N

        gotoLoginButton.setBackground(new java.awt.Color(25, 145, 77));
        gotoLoginButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gotoLoginButton.setForeground(new java.awt.Color(153, 153, 153));
        gotoLoginButton.setText("LOGIN");

        jLayeredPane1.setBackground(new java.awt.Color(102, 102, 255));

        landingPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("landing page");

        javax.swing.GroupLayout landingPanelLayout = new javax.swing.GroupLayout(landingPanel);
        landingPanel.setLayout(landingPanelLayout);
        landingPanelLayout.setHorizontalGroup(
            landingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(landingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(935, Short.MAX_VALUE))
        );
        landingPanelLayout.setVerticalGroup(
            landingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(landingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(527, Short.MAX_VALUE))
        );

        newProductsPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("new produts");

        javax.swing.GroupLayout newProductsPanelLayout = new javax.swing.GroupLayout(newProductsPanel);
        newProductsPanel.setLayout(newProductsPanelLayout);
        newProductsPanelLayout.setHorizontalGroup(
            newProductsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newProductsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(932, Short.MAX_VALUE))
        );
        newProductsPanelLayout.setVerticalGroup(
            newProductsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newProductsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(529, Short.MAX_VALUE))
        );

        bakeryPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("bakery");

        javax.swing.GroupLayout bakeryPanelLayout = new javax.swing.GroupLayout(bakeryPanel);
        bakeryPanel.setLayout(bakeryPanelLayout);
        bakeryPanelLayout.setHorizontalGroup(
            bakeryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bakeryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(963, Short.MAX_VALUE))
        );
        bakeryPanelLayout.setVerticalGroup(
            bakeryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bakeryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(527, Short.MAX_VALUE))
        );

        butcheryPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("butchery");

        javax.swing.GroupLayout butcheryPanelLayout = new javax.swing.GroupLayout(butcheryPanel);
        butcheryPanel.setLayout(butcheryPanelLayout);
        butcheryPanelLayout.setHorizontalGroup(
            butcheryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(butcheryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(945, Short.MAX_VALUE))
        );
        butcheryPanelLayout.setVerticalGroup(
            butcheryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(butcheryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(528, Short.MAX_VALUE))
        );

        seaFoodsPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("seafoods");

        javax.swing.GroupLayout seaFoodsPanelLayout = new javax.swing.GroupLayout(seaFoodsPanel);
        seaFoodsPanel.setLayout(seaFoodsPanelLayout);
        seaFoodsPanelLayout.setHorizontalGroup(
            seaFoodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seaFoodsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(933, Short.MAX_VALUE))
        );
        seaFoodsPanelLayout.setVerticalGroup(
            seaFoodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seaFoodsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(537, Short.MAX_VALUE))
        );

        readyMealsPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ready meals");

        javax.swing.GroupLayout readyMealsPanelLayout = new javax.swing.GroupLayout(readyMealsPanel);
        readyMealsPanel.setLayout(readyMealsPanelLayout);
        readyMealsPanelLayout.setHorizontalGroup(
            readyMealsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(readyMealsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(898, Short.MAX_VALUE))
        );
        readyMealsPanelLayout.setVerticalGroup(
            readyMealsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(readyMealsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(527, Short.MAX_VALUE))
        );

        vegetablesPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("vegetables");

        javax.swing.GroupLayout vegetablesPanelLayout = new javax.swing.GroupLayout(vegetablesPanel);
        vegetablesPanel.setLayout(vegetablesPanelLayout);
        vegetablesPanelLayout.setHorizontalGroup(
            vegetablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vegetablesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(942, Short.MAX_VALUE))
        );
        vegetablesPanelLayout.setVerticalGroup(
            vegetablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vegetablesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(525, Short.MAX_VALUE))
        );

        fruitsPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("fruits");

        javax.swing.GroupLayout fruitsPanelLayout = new javax.swing.GroupLayout(fruitsPanel);
        fruitsPanel.setLayout(fruitsPanelLayout);
        fruitsPanelLayout.setHorizontalGroup(
            fruitsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fruitsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(971, Short.MAX_VALUE))
        );
        fruitsPanelLayout.setVerticalGroup(
            fruitsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fruitsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(522, Short.MAX_VALUE))
        );

        groceryPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("grocery");

        javax.swing.GroupLayout groceryPanelLayout = new javax.swing.GroupLayout(groceryPanel);
        groceryPanel.setLayout(groceryPanelLayout);
        groceryPanelLayout.setHorizontalGroup(
            groceryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groceryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(932, Short.MAX_VALUE))
        );
        groceryPanelLayout.setVerticalGroup(
            groceryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groceryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(526, Short.MAX_VALUE))
        );

        snacksPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("snacks");

        javax.swing.GroupLayout snacksPanelLayout = new javax.swing.GroupLayout(snacksPanel);
        snacksPanel.setLayout(snacksPanelLayout);
        snacksPanelLayout.setHorizontalGroup(
            snacksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(snacksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(963, Short.MAX_VALUE))
        );
        snacksPanelLayout.setVerticalGroup(
            snacksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(snacksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(527, Short.MAX_VALUE))
        );

        dessertsPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("desserts");

        javax.swing.GroupLayout dessertsPanelLayout = new javax.swing.GroupLayout(dessertsPanel);
        dessertsPanel.setLayout(dessertsPanelLayout);
        dessertsPanelLayout.setHorizontalGroup(
            dessertsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dessertsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(943, Short.MAX_VALUE))
        );
        dessertsPanelLayout.setVerticalGroup(
            dessertsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dessertsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(525, Short.MAX_VALUE))
        );

        winesPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setText("wines");

        javax.swing.GroupLayout winesPanelLayout = new javax.swing.GroupLayout(winesPanel);
        winesPanel.setLayout(winesPanelLayout);
        winesPanelLayout.setHorizontalGroup(
            winesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(winesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(952, Short.MAX_VALUE))
        );
        winesPanelLayout.setVerticalGroup(
            winesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(winesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(528, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(landingPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(newProductsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(bakeryPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(butcheryPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(seaFoodsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(readyMealsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(vegetablesPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(fruitsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(groceryPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(snacksPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(dessertsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(winesPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(landingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(newProductsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(bakeryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(butcheryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(9, 9, 9)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(seaFoodsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(15, 15, 15)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(readyMealsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(vegetablesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(fruitsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(groceryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(snacksPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(dessertsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(winesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(landingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newProductsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(bakeryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(butcheryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(seaFoodsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(15, 15, 15)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(readyMealsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(27, Short.MAX_VALUE)
                    .addComponent(vegetablesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(20, Short.MAX_VALUE)
                    .addComponent(fruitsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(groceryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(snacksPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(dessertsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(winesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gotoLoginButton)
                            .addComponent(gotoLoginImage))
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(gotoLoginImage)
                .addGap(2, 2, 2)
                .addComponent(gotoLoginButton)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
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
                new DashboardFrame().setVisible(true);
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
    private javax.swing.JPanel dessertsPanel;
    private javax.swing.JPanel fruitsPanel;
    private javax.swing.JLabel gotoLoginButton;
    private javax.swing.JLabel gotoLoginImage;
    private javax.swing.JPanel groceryPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel landingPanel;
    private javax.swing.JButton newProductsButton;
    private javax.swing.JPanel newProductsPanel;
    private javax.swing.JPanel readyMealsPanel;
    private javax.swing.JPanel seaFoodsPanel;
    private javax.swing.JButton seafoodsButton;
    private javax.swing.JPanel snacksPanel;
    private javax.swing.JPanel vegetablesPanel;
    private javax.swing.JPanel winesPanel;
    // End of variables declaration//GEN-END:variables

}
