package main_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class DashboardFrame extends javax.swing.JFrame {
    private static int[] categoryCounters = new int[11];
    static boolean isLoggedIn;
    SignUpFrame signUpFrame = new SignUpFrame();
    DatabaseManager dbManager = new DatabaseManager();
    
    LoginFrame loginFrame = new LoginFrame(this);
    
    public static JLabel[] category1Slots;
    public static JLabel[] category2Slots;
    public static JLabel[] category3Slots;
    public static JLabel[] category4Slots;
    public static JLabel[] category5Slots;
    public static JLabel[] category6Slots;
    public static JLabel[] category7Slots;
    public static JLabel[] category8Slots;
    public static JLabel[] category9Slots;
    public static JLabel[] category10Slots;
    public static JLabel[] category11Slots;
    
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
        
        bottomFrame.setBackground(new Color(228, 166, 107));
        bottomFrame.setBounds(0, 680, 1600, 105);
        bottomFrame.setLayout(null);
        
        
        setBackground(new Color(251, 239, 215));
       
        
        initComponents();
        
        category1Slots = new JLabel[] {newProductsSlot1, newProductsSlot2, newProductsSlot3, newProductsSlot4, newProductsSlot5, newProductsSlot6, newProductsSlot7, newProductsSlot8};
        category2Slots = new JLabel[] {bakerySlot1, bakerySlot2, bakerySlot3, bakerySlot4, bakerySlot5, bakerySlot6, bakerySlot7, bakerySlot8};
        category3Slots = new JLabel[] {butcherySlot1, butcherySlot2, butcherySlot3, butcherySlot4, butcherySlot5, butcherySlot6, butcherySlot7, butcherySlot8};
        category4Slots = new JLabel[] {seafoodsSlot1, seafoodsSlot2, seafoodsSlot3, seafoodsSlot4, seafoodsSlot5, seafoodsSlot6, seafoodsSlot7, seafoodsSlot8};
        category5Slots = new JLabel[] {readyMealsSlot1, readyMealsSlot2, readyMealsSlot3, readyMealsSlot4, readyMealsSlot5, readyMealsSlot6, readyMealsSlot7, readyMealsSlot8};
        category6Slots = new JLabel[] {vegetablesSlot1, vegetablesSlot2, vegetablesSlot3, vegetablesSlot4, vegetablesSlot5, vegetablesSlot6, vegetablesSlot7, vegetablesSlot8};
        category7Slots = new JLabel[] {fruitsSlot1, fruitsSlot2, fruitsSlot3, fruitsSlot4, fruitsSlot5, fruitsSlot6, fruitsSlot7, fruitsSlot8};
        category8Slots = new JLabel[] {grocerySlot1, grocerySlot2, grocerySlot3, grocerySlot4, grocerySlot5, grocerySlot6, grocerySlot7, grocerySlot8};
        category9Slots = new JLabel[] {snacksSlot1, snacksSlot2, snacksSlot3, snacksSlot4, snacksSlot5, snacksSlot6, snacksSlot7, snacksSlot8};
        category10Slots = new JLabel[] {dessertsSlot1, dessertsSlot2, dessertsSlot3, dessertsSlot4, dessertsSlot5, dessertsSlot6, dessertsSlot7, dessertsSlot8};
        category11Slots = new JLabel[] {winesSlot1, winesSlot2, winesSlot3, winesSlot4, winesSlot5, winesSlot6, winesSlot7, winesSlot8};
        
        setLocationRelativeTo(null);
        setResizable(false);
        sidebarPanel.setBorder(new MatteBorder(0, 0, 0, 3, new Color(228, 166, 107)));
           
       
        
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
       
       Listener.showPanel(jLabel15, landingPanel);
       
       
       
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
    
        public static void addProductToCategory(int category, ImageIcon image, String name) {
        JLabel[] slots = null;

        switch (category) {
            case 1: slots = category1Slots; break;
            case 2: slots = category2Slots; break;
            case 3: slots = category3Slots; break;
            case 4: slots = category4Slots; break;
            case 5: slots = category5Slots; break;
            case 6: slots = category6Slots; break;
            case 7: slots = category7Slots; break;
            case 8: slots = category8Slots; break;
            case 9: slots = category9Slots; break;
            case 10: slots = category10Slots; break;
            case 11: slots = category11Slots; break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid category number!");
                return;
        }

        int index = categoryCounters[category - 1];
        if (index >= slots.length) {
            JOptionPane.showMessageDialog(null, "All slots for this category are full!");
            return;
        }

        JLabel slot = slots[index];
        slot.setIcon(image);
        slot.setText(name);
        slot.setHorizontalTextPosition(SwingConstants.CENTER);
        slot.setVerticalTextPosition(SwingConstants.BOTTOM);
        slot.setHorizontalAlignment(JLabel.CENTER);    // align icon + text in the label
        slot.setVerticalAlignment(JLabel.TOP);         // icon at top
        slot.setFont(new Font("Arial", Font.BOLD, 12));
        slot.setForeground(Color.BLACK);
        categoryCounters[category - 1]++;
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
    
    public void hideAllPanels(){
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
        newProductsPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        newProductsSlot1 = new javax.swing.JLabel();
        newProductsSlot3 = new javax.swing.JLabel();
        newProductsSlot4 = new javax.swing.JLabel();
        newProductsSlot2 = new javax.swing.JLabel();
        newProductsSlot6 = new javax.swing.JLabel();
        newProductsSlot5 = new javax.swing.JLabel();
        newProductsSlot7 = new javax.swing.JLabel();
        newProductsSlot8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        bakeryPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bakerySlot5 = new javax.swing.JLabel();
        bakerySlot1 = new javax.swing.JLabel();
        bakerySlot2 = new javax.swing.JLabel();
        bakerySlot6 = new javax.swing.JLabel();
        bakerySlot7 = new javax.swing.JLabel();
        bakerySlot3 = new javax.swing.JLabel();
        bakerySlot4 = new javax.swing.JLabel();
        bakerySlot8 = new javax.swing.JLabel();
        bakeryLabel2 = new javax.swing.JLabel();
        bakeryLabel1 = new javax.swing.JLabel();
        bakeryLabel3 = new javax.swing.JLabel();
        bakeryLabel4 = new javax.swing.JLabel();
        bakeryLabel8 = new javax.swing.JLabel();
        bakeryLabel7 = new javax.swing.JLabel();
        bakeryLabel6 = new javax.swing.JLabel();
        bakeryLabel5 = new javax.swing.JLabel();
        butcheryPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        butcherySlot5 = new javax.swing.JLabel();
        butcherySlot1 = new javax.swing.JLabel();
        butcherySlot2 = new javax.swing.JLabel();
        butcherySlot6 = new javax.swing.JLabel();
        butcherySlot7 = new javax.swing.JLabel();
        butcherySlot3 = new javax.swing.JLabel();
        butcherySlot4 = new javax.swing.JLabel();
        butcherySlot8 = new javax.swing.JLabel();
        butcheryLabel2 = new javax.swing.JLabel();
        butcheryLabel1 = new javax.swing.JLabel();
        butcheryLabel3 = new javax.swing.JLabel();
        butcheryLabel4 = new javax.swing.JLabel();
        butcheryLabel8 = new javax.swing.JLabel();
        butcheryLabel7 = new javax.swing.JLabel();
        butcheryLabel6 = new javax.swing.JLabel();
        butcheryLabel5 = new javax.swing.JLabel();
        readyMealsPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        readyMealsSlot4 = new javax.swing.JLabel();
        readyMealsSlot8 = new javax.swing.JLabel();
        readyMealsSlot7 = new javax.swing.JLabel();
        readyMealsSlot3 = new javax.swing.JLabel();
        readyMealsSlot2 = new javax.swing.JLabel();
        readyMealsSlot6 = new javax.swing.JLabel();
        readyMealsSlot5 = new javax.swing.JLabel();
        readyMealsSlot1 = new javax.swing.JLabel();
        readyMealsLabel2 = new javax.swing.JLabel();
        readyMealsLabel1 = new javax.swing.JLabel();
        readyMealsLabel3 = new javax.swing.JLabel();
        readyMealsLabel4 = new javax.swing.JLabel();
        readyMealsLabel8 = new javax.swing.JLabel();
        readyMealsLabel7 = new javax.swing.JLabel();
        readyMealsLabel6 = new javax.swing.JLabel();
        readyMealsLabel5 = new javax.swing.JLabel();
        vegetablesPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        vegetablesSlot4 = new javax.swing.JLabel();
        vegetablesSlot8 = new javax.swing.JLabel();
        vegetablesSlot7 = new javax.swing.JLabel();
        vegetablesSlot3 = new javax.swing.JLabel();
        vegetablesSlot2 = new javax.swing.JLabel();
        vegetablesSlot6 = new javax.swing.JLabel();
        vegetablesSlot5 = new javax.swing.JLabel();
        vegetablesSlot1 = new javax.swing.JLabel();
        vegetablesLabel2 = new javax.swing.JLabel();
        vegetablesLabel1 = new javax.swing.JLabel();
        vegetablesLabel3 = new javax.swing.JLabel();
        vegetablesLabel4 = new javax.swing.JLabel();
        vegetablesLabel8 = new javax.swing.JLabel();
        vegetablesLabel7 = new javax.swing.JLabel();
        vegetablesLabel6 = new javax.swing.JLabel();
        vegetablesLabel5 = new javax.swing.JLabel();
        fruitsPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        fruitsSlot4 = new javax.swing.JLabel();
        fruitsSlot8 = new javax.swing.JLabel();
        fruitsSlot7 = new javax.swing.JLabel();
        fruitsSlot3 = new javax.swing.JLabel();
        fruitsSlot2 = new javax.swing.JLabel();
        fruitsSlot6 = new javax.swing.JLabel();
        fruitsSlot5 = new javax.swing.JLabel();
        fruitsSlot1 = new javax.swing.JLabel();
        fruitsLabel2 = new javax.swing.JLabel();
        fruitsLabel1 = new javax.swing.JLabel();
        fruitsLabel3 = new javax.swing.JLabel();
        fruitsLabel4 = new javax.swing.JLabel();
        fruitsLabel8 = new javax.swing.JLabel();
        fruitsLabel7 = new javax.swing.JLabel();
        fruitsLabel6 = new javax.swing.JLabel();
        fruitsLabel5 = new javax.swing.JLabel();
        groceryPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        grocerySlot4 = new javax.swing.JLabel();
        grocerySlot8 = new javax.swing.JLabel();
        grocerySlot7 = new javax.swing.JLabel();
        grocerySlot3 = new javax.swing.JLabel();
        grocerySlot2 = new javax.swing.JLabel();
        grocerySlot6 = new javax.swing.JLabel();
        grocerySlot5 = new javax.swing.JLabel();
        grocerySlot1 = new javax.swing.JLabel();
        groceryLabel2 = new javax.swing.JLabel();
        groceryLabel1 = new javax.swing.JLabel();
        groceryLabel3 = new javax.swing.JLabel();
        groceryLabel4 = new javax.swing.JLabel();
        groceryLabel8 = new javax.swing.JLabel();
        groceryLabel7 = new javax.swing.JLabel();
        groceryLabel6 = new javax.swing.JLabel();
        groceryLabel5 = new javax.swing.JLabel();
        snacksPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        snacksSlot4 = new javax.swing.JLabel();
        snacksSlot8 = new javax.swing.JLabel();
        snacksSlot7 = new javax.swing.JLabel();
        snacksSlot3 = new javax.swing.JLabel();
        snacksSlot2 = new javax.swing.JLabel();
        snacksSlot6 = new javax.swing.JLabel();
        snacksSlot5 = new javax.swing.JLabel();
        snacksSlot1 = new javax.swing.JLabel();
        snacksLabel2 = new javax.swing.JLabel();
        snacksLabel1 = new javax.swing.JLabel();
        snacksLabel3 = new javax.swing.JLabel();
        snacksLabel4 = new javax.swing.JLabel();
        snacksLabel8 = new javax.swing.JLabel();
        snacksLabel7 = new javax.swing.JLabel();
        snacksLabel6 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        dessertsPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        dessertsSlot4 = new javax.swing.JLabel();
        dessertsSlot8 = new javax.swing.JLabel();
        dessertsSlot7 = new javax.swing.JLabel();
        dessertsSlot3 = new javax.swing.JLabel();
        dessertsSlot2 = new javax.swing.JLabel();
        dessertsSlot6 = new javax.swing.JLabel();
        dessertsSlot5 = new javax.swing.JLabel();
        dessertsSlot1 = new javax.swing.JLabel();
        dessertsLabel2 = new javax.swing.JLabel();
        dessertsLabel1 = new javax.swing.JLabel();
        dessertsLabel3 = new javax.swing.JLabel();
        dessertsLabel4 = new javax.swing.JLabel();
        dessertsLabel8 = new javax.swing.JLabel();
        dessertsLabel7 = new javax.swing.JLabel();
        dessertsLabel6 = new javax.swing.JLabel();
        dessertsLabel5 = new javax.swing.JLabel();
        winesPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        winesSlot4 = new javax.swing.JLabel();
        winesSlot8 = new javax.swing.JLabel();
        winesSlot7 = new javax.swing.JLabel();
        winesSlot3 = new javax.swing.JLabel();
        winesSlot2 = new javax.swing.JLabel();
        winesSlot6 = new javax.swing.JLabel();
        winesSlot5 = new javax.swing.JLabel();
        winesSlot1 = new javax.swing.JLabel();
        winesLabel2 = new javax.swing.JLabel();
        winesLabel1 = new javax.swing.JLabel();
        winesLabel3 = new javax.swing.JLabel();
        winesLabel4 = new javax.swing.JLabel();
        winesLabel8 = new javax.swing.JLabel();
        winesLabel7 = new javax.swing.JLabel();
        winesLabel6 = new javax.swing.JLabel();
        winesLabel5 = new javax.swing.JLabel();
        seaFoodsPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        seafoodsSlot4 = new javax.swing.JLabel();
        seafoodsSlot8 = new javax.swing.JLabel();
        seafoodsSlot7 = new javax.swing.JLabel();
        seafoodsSlot3 = new javax.swing.JLabel();
        seafoodsSlot2 = new javax.swing.JLabel();
        seafoodsSlot6 = new javax.swing.JLabel();
        seafoodsSlot5 = new javax.swing.JLabel();
        seafoodsSlot1 = new javax.swing.JLabel();
        seafoodsLabel2 = new javax.swing.JLabel();
        seafoodsLabel1 = new javax.swing.JLabel();
        seafoodsLabel3 = new javax.swing.JLabel();
        seafoodsLabel4 = new javax.swing.JLabel();
        seafoodsLabel8 = new javax.swing.JLabel();
        seafoodsLabel7 = new javax.swing.JLabel();
        seafoodsLabel6 = new javax.swing.JLabel();
        seafoodsLabel5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        gotoLoginImage = new javax.swing.JLabel();
        gotoLoginButton = new javax.swing.JLabel();
        gotoRegisterImage = new javax.swing.JLabel();
        gotoRegisterButton = new javax.swing.JLabel();
        myCartImage = new javax.swing.JLabel();
        myCartButton = new javax.swing.JLabel();
        cartCount = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

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
        setBackground(new java.awt.Color(243, 243, 243));

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
        button9.setText("Beverages");
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

        jPanel2.setBackground(new java.awt.Color(228, 166, 107));

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
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        landingPanel.setBackground(new java.awt.Color(243, 243, 243));
        landingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(243, 243, 243));
        jLabel1.setText("landing page");
        landingPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLayeredPane1.add(landingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 553));

        newProductsPanel.setBackground(new java.awt.Color(238, 238, 238));
        newProductsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(243, 243, 243));
        jLabel2.setText("new products");
        newProductsPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        newProductsSlot1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        newProductsPanel.add(newProductsSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 150, 120));

        newProductsSlot3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        newProductsPanel.add(newProductsSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 160, 120));

        newProductsSlot4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        newProductsPanel.add(newProductsSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 160, 120));

        newProductsSlot2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        newProductsPanel.add(newProductsSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 150, 120));

        newProductsSlot6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        newProductsPanel.add(newProductsSlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 150, 120));

        newProductsSlot5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        newProductsPanel.add(newProductsSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 150, 120));

        newProductsSlot7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        newProductsPanel.add(newProductsSlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 160, 120));

        newProductsSlot8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        newProductsPanel.add(newProductsSlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 160, 120));

        jLabel13.setText("Product Name");
        newProductsPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        jLabel14.setText("Product Name");
        newProductsPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        jLabel16.setText("Product Name");
        newProductsPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, -1, -1));

        jLabel17.setText("Product Name");
        newProductsPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        jLabel20.setText("Product Name");
        newProductsPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, -1, -1));

        jLabel21.setText("Product Name");
        newProductsPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        jLabel22.setText("Product Name");
        newProductsPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        jLabel23.setText("Product Name");
        newProductsPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, -1, -1));

        jLayeredPane1.add(newProductsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 538));

        bakeryPanel.setBackground(new java.awt.Color(238, 238, 238));
        bakeryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(243, 243, 243));
        jLabel3.setText("bakery");
        bakeryPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        bakerySlot5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bakeryPanel.add(bakerySlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 150, 120));

        bakerySlot1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bakeryPanel.add(bakerySlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 150, 120));

        bakerySlot2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bakeryPanel.add(bakerySlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 150, 120));

        bakerySlot6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bakeryPanel.add(bakerySlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 150, 120));

        bakerySlot7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bakeryPanel.add(bakerySlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 160, 120));

        bakerySlot3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bakeryPanel.add(bakerySlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 160, 120));

        bakerySlot4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bakeryPanel.add(bakerySlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 160, 120));

        bakerySlot8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bakeryPanel.add(bakerySlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 160, 120));

        bakeryLabel2.setText("Product Name");
        bakeryPanel.add(bakeryLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        bakeryLabel1.setText("Product Name");
        bakeryPanel.add(bakeryLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        bakeryLabel3.setText("Product Name");
        bakeryPanel.add(bakeryLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        bakeryLabel4.setText("Product Name");
        bakeryPanel.add(bakeryLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, -1, -1));

        bakeryLabel8.setText("Product Name");
        bakeryPanel.add(bakeryLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, -1, -1));

        bakeryLabel7.setText("Product Name");
        bakeryPanel.add(bakeryLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        bakeryLabel6.setText("Product Name");
        bakeryPanel.add(bakeryLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, -1, -1));

        bakeryLabel5.setText("Product Name");
        bakeryPanel.add(bakeryLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        jLayeredPane1.add(bakeryPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 545));

        butcheryPanel.setBackground(new java.awt.Color(238, 238, 238));
        butcheryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(243, 243, 243));
        jLabel4.setText("butchery");
        butcheryPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        butcherySlot5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        butcheryPanel.add(butcherySlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 150, 120));

        butcherySlot1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        butcheryPanel.add(butcherySlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 150, 120));

        butcherySlot2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        butcheryPanel.add(butcherySlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 150, 120));

        butcherySlot6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        butcheryPanel.add(butcherySlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 150, 120));

        butcherySlot7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        butcheryPanel.add(butcherySlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 160, 120));

        butcherySlot3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        butcheryPanel.add(butcherySlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 160, 120));

        butcherySlot4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        butcheryPanel.add(butcherySlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 160, 120));

        butcherySlot8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        butcheryPanel.add(butcherySlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 160, 120));

        butcheryLabel2.setText("Product Name");
        butcheryPanel.add(butcheryLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        butcheryLabel1.setText("Product Name");
        butcheryPanel.add(butcheryLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        butcheryLabel3.setText("Product Name");
        butcheryPanel.add(butcheryLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        butcheryLabel4.setText("Product Name");
        butcheryPanel.add(butcheryLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, -1, -1));

        butcheryLabel8.setText("Product Name");
        butcheryPanel.add(butcheryLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, -1, -1));

        butcheryLabel7.setText("Product Name");
        butcheryPanel.add(butcheryLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        butcheryLabel6.setText("Product Name");
        butcheryPanel.add(butcheryLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, -1, -1));

        butcheryLabel5.setText("Product Name");
        butcheryPanel.add(butcheryLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        jLayeredPane1.add(butcheryPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, -1));

        readyMealsPanel.setBackground(new java.awt.Color(238, 238, 238));
        readyMealsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(243, 243, 243));
        jLabel6.setText("ready meals");
        readyMealsPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        readyMealsSlot4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        readyMealsPanel.add(readyMealsSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 160, 120));

        readyMealsSlot8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        readyMealsPanel.add(readyMealsSlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 160, 120));

        readyMealsSlot7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        readyMealsPanel.add(readyMealsSlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 160, 120));

        readyMealsSlot3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        readyMealsPanel.add(readyMealsSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 160, 120));

        readyMealsSlot2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        readyMealsPanel.add(readyMealsSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 150, 120));

        readyMealsSlot6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        readyMealsPanel.add(readyMealsSlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 150, 120));

        readyMealsSlot5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        readyMealsPanel.add(readyMealsSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 150, 120));

        readyMealsSlot1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        readyMealsPanel.add(readyMealsSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 150, 120));

        readyMealsLabel2.setText("Product Name");
        readyMealsPanel.add(readyMealsLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        readyMealsLabel1.setText("Product Name");
        readyMealsPanel.add(readyMealsLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        readyMealsLabel3.setText("Product Name");
        readyMealsPanel.add(readyMealsLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        readyMealsLabel4.setText("Product Name");
        readyMealsPanel.add(readyMealsLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, -1, -1));

        readyMealsLabel8.setText("Product Name");
        readyMealsPanel.add(readyMealsLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, -1, -1));

        readyMealsLabel7.setText("Product Name");
        readyMealsPanel.add(readyMealsLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        readyMealsLabel6.setText("Product Name");
        readyMealsPanel.add(readyMealsLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, -1, -1));

        readyMealsLabel5.setText("Product Name");
        readyMealsPanel.add(readyMealsLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        jLayeredPane1.add(readyMealsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1256, -1));

        vegetablesPanel.setBackground(new java.awt.Color(238, 238, 238));
        vegetablesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(243, 243, 243));
        jLabel7.setText("vegetables");
        vegetablesPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        vegetablesSlot4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vegetablesPanel.add(vegetablesSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 160, 120));

        vegetablesSlot8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vegetablesPanel.add(vegetablesSlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 160, 120));

        vegetablesSlot7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vegetablesPanel.add(vegetablesSlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 160, 120));

        vegetablesSlot3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vegetablesPanel.add(vegetablesSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 160, 120));

        vegetablesSlot2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vegetablesPanel.add(vegetablesSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 150, 120));

        vegetablesSlot6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vegetablesPanel.add(vegetablesSlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 150, 120));

        vegetablesSlot5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vegetablesPanel.add(vegetablesSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 150, 120));

        vegetablesSlot1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vegetablesPanel.add(vegetablesSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 150, 120));

        vegetablesLabel2.setText("Product Name");
        vegetablesPanel.add(vegetablesLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        vegetablesLabel1.setText("Product Name");
        vegetablesPanel.add(vegetablesLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        vegetablesLabel3.setText("Product Name");
        vegetablesPanel.add(vegetablesLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        vegetablesLabel4.setText("Product Name");
        vegetablesPanel.add(vegetablesLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, -1, -1));

        vegetablesLabel8.setText("Product Name");
        vegetablesPanel.add(vegetablesLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, -1, -1));

        vegetablesLabel7.setText("Product Name");
        vegetablesPanel.add(vegetablesLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        vegetablesLabel6.setText("Product Name");
        vegetablesPanel.add(vegetablesLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, -1, -1));

        vegetablesLabel5.setText("Product Name");
        vegetablesPanel.add(vegetablesLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        jLayeredPane1.add(vegetablesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, -1));

        fruitsPanel.setBackground(new java.awt.Color(238, 238, 238));
        fruitsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(243, 243, 243));
        jLabel8.setText("fruits");
        fruitsPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        fruitsSlot4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fruitsPanel.add(fruitsSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 160, 120));

        fruitsSlot8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fruitsPanel.add(fruitsSlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 160, 120));

        fruitsSlot7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fruitsPanel.add(fruitsSlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 160, 120));

        fruitsSlot3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fruitsPanel.add(fruitsSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 160, 120));

        fruitsSlot2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fruitsPanel.add(fruitsSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 150, 120));

        fruitsSlot6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fruitsPanel.add(fruitsSlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 150, 120));

        fruitsSlot5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fruitsPanel.add(fruitsSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 150, 120));

        fruitsSlot1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fruitsPanel.add(fruitsSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 150, 120));

        fruitsLabel2.setText("Product Name");
        fruitsPanel.add(fruitsLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        fruitsLabel1.setText("Product Name");
        fruitsPanel.add(fruitsLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        fruitsLabel3.setText("Product Name");
        fruitsPanel.add(fruitsLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        fruitsLabel4.setText("Product Name");
        fruitsPanel.add(fruitsLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, -1, -1));

        fruitsLabel8.setText("Product Name");
        fruitsPanel.add(fruitsLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, -1, -1));

        fruitsLabel7.setText("Product Name");
        fruitsPanel.add(fruitsLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        fruitsLabel6.setText("Product Name");
        fruitsPanel.add(fruitsLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, -1, -1));

        fruitsLabel5.setText("Product Name");
        fruitsPanel.add(fruitsLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        jLayeredPane1.add(fruitsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1256, -1));

        groceryPanel.setBackground(new java.awt.Color(238, 238, 238));
        groceryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(243, 243, 243));
        jLabel9.setText("grocery");
        groceryPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        grocerySlot4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        groceryPanel.add(grocerySlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 160, 120));

        grocerySlot8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        groceryPanel.add(grocerySlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 160, 120));

        grocerySlot7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        groceryPanel.add(grocerySlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 160, 120));

        grocerySlot3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        groceryPanel.add(grocerySlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 160, 120));

        grocerySlot2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        groceryPanel.add(grocerySlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 150, 120));

        grocerySlot6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        groceryPanel.add(grocerySlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 150, 120));

        grocerySlot5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        groceryPanel.add(grocerySlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 150, 120));

        grocerySlot1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        groceryPanel.add(grocerySlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 150, 120));

        groceryLabel2.setText("Product Name");
        groceryPanel.add(groceryLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        groceryLabel1.setText("Product Name");
        groceryPanel.add(groceryLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        groceryLabel3.setText("Product Name");
        groceryPanel.add(groceryLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        groceryLabel4.setText("Product Name");
        groceryPanel.add(groceryLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, -1, -1));

        groceryLabel8.setText("Product Name");
        groceryPanel.add(groceryLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, -1, -1));

        groceryLabel7.setText("Product Name");
        groceryPanel.add(groceryLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        groceryLabel6.setText("Product Name");
        groceryPanel.add(groceryLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, -1, -1));

        groceryLabel5.setText("Product Name");
        groceryPanel.add(groceryLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        jLayeredPane1.add(groceryPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1256, -1));

        snacksPanel.setBackground(new java.awt.Color(238, 238, 238));
        snacksPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(243, 243, 243));
        jLabel10.setText("snacks");
        snacksPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        snacksSlot4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        snacksPanel.add(snacksSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 160, 120));

        snacksSlot8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        snacksPanel.add(snacksSlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 160, 120));

        snacksSlot7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        snacksPanel.add(snacksSlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 160, 120));

        snacksSlot3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        snacksPanel.add(snacksSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 160, 120));

        snacksSlot2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        snacksPanel.add(snacksSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 150, 120));

        snacksSlot6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        snacksPanel.add(snacksSlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 150, 120));

        snacksSlot5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        snacksPanel.add(snacksSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 150, 120));

        snacksSlot1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        snacksPanel.add(snacksSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 150, 120));

        snacksLabel2.setText("Product Name");
        snacksPanel.add(snacksLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        snacksLabel1.setText("Product Name");
        snacksPanel.add(snacksLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        snacksLabel3.setText("Product Name");
        snacksPanel.add(snacksLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        snacksLabel4.setText("Product Name");
        snacksPanel.add(snacksLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, -1, -1));

        snacksLabel8.setText("Product Name");
        snacksPanel.add(snacksLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, -1, -1));

        snacksLabel7.setText("Product Name");
        snacksPanel.add(snacksLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        snacksLabel6.setText("Product Name");
        snacksPanel.add(snacksLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, -1, -1));

        jLabel79.setText("Product Name");
        snacksPanel.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        jLayeredPane1.add(snacksPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1256, -1));

        dessertsPanel.setBackground(new java.awt.Color(238, 238, 238));
        dessertsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(243, 243, 243));
        jLabel11.setText("desserts");
        dessertsPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        dessertsSlot4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dessertsPanel.add(dessertsSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 160, 120));

        dessertsSlot8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dessertsPanel.add(dessertsSlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 160, 120));

        dessertsSlot7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dessertsPanel.add(dessertsSlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 160, 120));

        dessertsSlot3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dessertsPanel.add(dessertsSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 160, 120));

        dessertsSlot2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dessertsPanel.add(dessertsSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 150, 120));

        dessertsSlot6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dessertsPanel.add(dessertsSlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 150, 120));

        dessertsSlot5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dessertsPanel.add(dessertsSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 150, 120));

        dessertsSlot1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dessertsPanel.add(dessertsSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 150, 120));

        dessertsLabel2.setText("Product Name");
        dessertsPanel.add(dessertsLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        dessertsLabel1.setText("Product Name");
        dessertsPanel.add(dessertsLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        dessertsLabel3.setText("Product Name");
        dessertsPanel.add(dessertsLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        dessertsLabel4.setText("Product Name");
        dessertsPanel.add(dessertsLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, -1, -1));

        dessertsLabel8.setText("Product Name");
        dessertsPanel.add(dessertsLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, -1, -1));

        dessertsLabel7.setText("Product Name");
        dessertsPanel.add(dessertsLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        dessertsLabel6.setText("Product Name");
        dessertsPanel.add(dessertsLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, -1, -1));

        dessertsLabel5.setText("Product Name");
        dessertsPanel.add(dessertsLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        jLayeredPane1.add(dessertsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1256, -1));

        winesPanel.setBackground(new java.awt.Color(238, 238, 238));
        winesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setText("wines");
        winesPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        winesSlot4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        winesPanel.add(winesSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 160, 120));

        winesSlot8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        winesPanel.add(winesSlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 160, 120));

        winesSlot7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        winesPanel.add(winesSlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 160, 120));

        winesSlot3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        winesPanel.add(winesSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 160, 120));

        winesSlot2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        winesPanel.add(winesSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 150, 120));

        winesSlot6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        winesPanel.add(winesSlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 150, 120));

        winesSlot5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        winesPanel.add(winesSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 150, 120));

        winesSlot1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        winesPanel.add(winesSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 150, 120));

        winesLabel2.setText("Product Name");
        winesPanel.add(winesLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        winesLabel1.setText("Product Name");
        winesPanel.add(winesLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        winesLabel3.setText("Product Name");
        winesPanel.add(winesLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        winesLabel4.setText("Product Name");
        winesPanel.add(winesLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, -1, -1));

        winesLabel8.setText("Product Name");
        winesPanel.add(winesLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, -1, -1));

        winesLabel7.setText("Product Name");
        winesPanel.add(winesLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        winesLabel6.setText("Product Name");
        winesPanel.add(winesLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, -1, -1));

        winesLabel5.setText("Product Name");
        winesPanel.add(winesLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        jLayeredPane1.add(winesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1256, -1));

        seaFoodsPanel.setBackground(new java.awt.Color(238, 238, 238));
        seaFoodsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(243, 243, 243));
        jLabel5.setText("seafoods");
        seaFoodsPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        seafoodsSlot4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        seaFoodsPanel.add(seafoodsSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 160, 120));

        seafoodsSlot8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        seaFoodsPanel.add(seafoodsSlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 160, 120));

        seafoodsSlot7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        seaFoodsPanel.add(seafoodsSlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 160, 120));

        seafoodsSlot3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        seaFoodsPanel.add(seafoodsSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 160, 120));

        seafoodsSlot2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        seaFoodsPanel.add(seafoodsSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 150, 120));

        seafoodsSlot6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        seaFoodsPanel.add(seafoodsSlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 150, 120));

        seafoodsSlot5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        seaFoodsPanel.add(seafoodsSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 150, 120));

        seafoodsSlot1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        seaFoodsPanel.add(seafoodsSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 150, 120));

        seafoodsLabel2.setText("Product Name");
        seaFoodsPanel.add(seafoodsLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        seafoodsLabel1.setText("Product Name");
        seaFoodsPanel.add(seafoodsLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        seafoodsLabel3.setText("Product Name");
        seaFoodsPanel.add(seafoodsLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        seafoodsLabel4.setText("Product Name");
        seaFoodsPanel.add(seafoodsLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, -1, -1));

        seafoodsLabel8.setText("Product Name");
        seaFoodsPanel.add(seafoodsLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, -1, -1));

        seafoodsLabel7.setText("Product Name");
        seaFoodsPanel.add(seafoodsLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        seafoodsLabel6.setText("Product Name");
        seaFoodsPanel.add(seafoodsLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, -1, -1));

        seafoodsLabel5.setText("Product Name");
        seaFoodsPanel.add(seafoodsLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        jLayeredPane1.add(seaFoodsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 9, 1250, -1));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("GROUP 4 - FINAL PROJECT ");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("DITO ILALAGAY OTHER FRAMES/PAGE OR FUNCTIONS - Brainstorm nalang");

        jPanel6.setBackground(new java.awt.Color(251, 239, 215));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gotoLoginImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/login icon - test.png"))); // NOI18N
        jPanel6.add(gotoLoginImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 20, -1, -1));

        gotoLoginButton.setBackground(new java.awt.Color(25, 145, 77));
        gotoLoginButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gotoLoginButton.setForeground(new java.awt.Color(153, 153, 153));
        gotoLoginButton.setText("LOGIN");
        jPanel6.add(gotoLoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 70, -1, -1));

        gotoRegisterImage.setBackground(new java.awt.Color(25, 145, 77));
        gotoRegisterImage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gotoRegisterImage.setForeground(new java.awt.Color(153, 153, 153));
        gotoRegisterImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/register icon - test.png"))); // NOI18N
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
        myCartImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cart icon - test.png"))); // NOI18N
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

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/dashboard logo.png"))); // NOI18N
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sidebarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, Short.MAX_VALUE))
                .addGap(0, 53, Short.MAX_VALUE)
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

    public void selectButton(JButton btn){
        if(selectedButton != null){
            selectedButton.setBackground(Color.WHITE);
            selectedButton.setForeground(Color.black);
            selectedButton.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, new Color(255, 255, 254)));
            selectedButton.setBorder(BorderFactory.createCompoundBorder(null, BorderFactory.createEmptyBorder(0, 20, 0,0)));
        }
        
        btn.setBackground(new Color(242, 242, 243));
        btn.setForeground(new Color(110, 66, 39));
        selectedButton = btn;
    }
    
    private void addLeftGreenColor(JButton btn){
        btn.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 3, 0, 0, new Color(228, 166, 107)),
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
    public static javax.swing.JLabel bakeryLabel1;
    public static javax.swing.JLabel bakeryLabel2;
    public static javax.swing.JLabel bakeryLabel3;
    public static javax.swing.JLabel bakeryLabel4;
    public static javax.swing.JLabel bakeryLabel5;
    public static javax.swing.JLabel bakeryLabel6;
    public static javax.swing.JLabel bakeryLabel7;
    public static javax.swing.JLabel bakeryLabel8;
    private javax.swing.JPanel bakeryPanel;
    public static javax.swing.JLabel bakerySlot1;
    public static javax.swing.JLabel bakerySlot2;
    public static javax.swing.JLabel bakerySlot3;
    public static javax.swing.JLabel bakerySlot4;
    public static javax.swing.JLabel bakerySlot5;
    public static javax.swing.JLabel bakerySlot6;
    public static javax.swing.JLabel bakerySlot7;
    public static javax.swing.JLabel bakerySlot8;
    private javax.swing.JButton butcheryButton;
    private javax.swing.JLabel butcheryLabel1;
    private javax.swing.JLabel butcheryLabel2;
    private javax.swing.JLabel butcheryLabel3;
    private javax.swing.JLabel butcheryLabel4;
    private javax.swing.JLabel butcheryLabel5;
    private javax.swing.JLabel butcheryLabel6;
    private javax.swing.JLabel butcheryLabel7;
    private javax.swing.JLabel butcheryLabel8;
    private javax.swing.JPanel butcheryPanel;
    public static javax.swing.JLabel butcherySlot1;
    public static javax.swing.JLabel butcherySlot2;
    public static javax.swing.JLabel butcherySlot3;
    public static javax.swing.JLabel butcherySlot4;
    public static javax.swing.JLabel butcherySlot5;
    public static javax.swing.JLabel butcherySlot6;
    public static javax.swing.JLabel butcherySlot7;
    public static javax.swing.JLabel butcherySlot8;
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
    private javax.swing.JLabel dessertsLabel1;
    private javax.swing.JLabel dessertsLabel2;
    private javax.swing.JLabel dessertsLabel3;
    private javax.swing.JLabel dessertsLabel4;
    private javax.swing.JLabel dessertsLabel5;
    private javax.swing.JLabel dessertsLabel6;
    private javax.swing.JLabel dessertsLabel7;
    private javax.swing.JLabel dessertsLabel8;
    private javax.swing.JPanel dessertsPanel;
    public static javax.swing.JLabel dessertsSlot1;
    public static javax.swing.JLabel dessertsSlot2;
    public static javax.swing.JLabel dessertsSlot3;
    public static javax.swing.JLabel dessertsSlot4;
    public static javax.swing.JLabel dessertsSlot5;
    public static javax.swing.JLabel dessertsSlot6;
    public static javax.swing.JLabel dessertsSlot7;
    public static javax.swing.JLabel dessertsSlot8;
    private javax.swing.JLabel fruitsLabel1;
    private javax.swing.JLabel fruitsLabel2;
    private javax.swing.JLabel fruitsLabel3;
    private javax.swing.JLabel fruitsLabel4;
    private javax.swing.JLabel fruitsLabel5;
    private javax.swing.JLabel fruitsLabel6;
    private javax.swing.JLabel fruitsLabel7;
    private javax.swing.JLabel fruitsLabel8;
    private javax.swing.JPanel fruitsPanel;
    public static javax.swing.JLabel fruitsSlot1;
    public static javax.swing.JLabel fruitsSlot2;
    public static javax.swing.JLabel fruitsSlot3;
    public static javax.swing.JLabel fruitsSlot4;
    public static javax.swing.JLabel fruitsSlot5;
    public static javax.swing.JLabel fruitsSlot6;
    public static javax.swing.JLabel fruitsSlot7;
    public static javax.swing.JLabel fruitsSlot8;
    private javax.swing.JLabel gotoLoginButton;
    public javax.swing.JLabel gotoLoginImage;
    private javax.swing.JLabel gotoRegisterButton;
    private javax.swing.JLabel gotoRegisterImage;
    private javax.swing.JLabel groceryLabel1;
    private javax.swing.JLabel groceryLabel2;
    private javax.swing.JLabel groceryLabel3;
    private javax.swing.JLabel groceryLabel4;
    private javax.swing.JLabel groceryLabel5;
    private javax.swing.JLabel groceryLabel6;
    private javax.swing.JLabel groceryLabel7;
    private javax.swing.JLabel groceryLabel8;
    private javax.swing.JPanel groceryPanel;
    public static javax.swing.JLabel grocerySlot1;
    public static javax.swing.JLabel grocerySlot2;
    public static javax.swing.JLabel grocerySlot3;
    public static javax.swing.JLabel grocerySlot4;
    public static javax.swing.JLabel grocerySlot5;
    public static javax.swing.JLabel grocerySlot6;
    public static javax.swing.JLabel grocerySlot7;
    public static javax.swing.JLabel grocerySlot8;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel landingPanel;
    private javax.swing.JLabel myCartButton;
    private javax.swing.JLabel myCartImage;
    private javax.swing.JButton newProductsButton;
    private javax.swing.JPanel newProductsPanel;
    public static javax.swing.JLabel newProductsSlot1;
    public static javax.swing.JLabel newProductsSlot2;
    public static javax.swing.JLabel newProductsSlot3;
    public static javax.swing.JLabel newProductsSlot4;
    public static javax.swing.JLabel newProductsSlot5;
    public static javax.swing.JLabel newProductsSlot6;
    public static javax.swing.JLabel newProductsSlot7;
    public static javax.swing.JLabel newProductsSlot8;
    private javax.swing.JLabel readyMealsLabel1;
    private javax.swing.JLabel readyMealsLabel2;
    private javax.swing.JLabel readyMealsLabel3;
    private javax.swing.JLabel readyMealsLabel4;
    private javax.swing.JLabel readyMealsLabel5;
    private javax.swing.JLabel readyMealsLabel6;
    private javax.swing.JLabel readyMealsLabel7;
    private javax.swing.JLabel readyMealsLabel8;
    private javax.swing.JPanel readyMealsPanel;
    public static javax.swing.JLabel readyMealsSlot1;
    public static javax.swing.JLabel readyMealsSlot2;
    public static javax.swing.JLabel readyMealsSlot3;
    public static javax.swing.JLabel readyMealsSlot4;
    public static javax.swing.JLabel readyMealsSlot5;
    public static javax.swing.JLabel readyMealsSlot6;
    public static javax.swing.JLabel readyMealsSlot7;
    public static javax.swing.JLabel readyMealsSlot8;
    private javax.swing.JPanel seaFoodsPanel;
    private javax.swing.JButton seafoodsButton;
    private javax.swing.JLabel seafoodsLabel1;
    private javax.swing.JLabel seafoodsLabel2;
    private javax.swing.JLabel seafoodsLabel3;
    private javax.swing.JLabel seafoodsLabel4;
    private javax.swing.JLabel seafoodsLabel5;
    private javax.swing.JLabel seafoodsLabel6;
    private javax.swing.JLabel seafoodsLabel7;
    private javax.swing.JLabel seafoodsLabel8;
    public static javax.swing.JLabel seafoodsSlot1;
    public static javax.swing.JLabel seafoodsSlot2;
    public static javax.swing.JLabel seafoodsSlot3;
    public static javax.swing.JLabel seafoodsSlot4;
    public static javax.swing.JLabel seafoodsSlot5;
    public static javax.swing.JLabel seafoodsSlot6;
    public static javax.swing.JLabel seafoodsSlot7;
    public static javax.swing.JLabel seafoodsSlot8;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JLabel snacksLabel1;
    private javax.swing.JLabel snacksLabel2;
    private javax.swing.JLabel snacksLabel3;
    private javax.swing.JLabel snacksLabel4;
    private javax.swing.JLabel snacksLabel6;
    private javax.swing.JLabel snacksLabel7;
    private javax.swing.JLabel snacksLabel8;
    private javax.swing.JPanel snacksPanel;
    public static javax.swing.JLabel snacksSlot1;
    public static javax.swing.JLabel snacksSlot2;
    public static javax.swing.JLabel snacksSlot3;
    public static javax.swing.JLabel snacksSlot4;
    public static javax.swing.JLabel snacksSlot5;
    public static javax.swing.JLabel snacksSlot6;
    public static javax.swing.JLabel snacksSlot7;
    public static javax.swing.JLabel snacksSlot8;
    private javax.swing.JLabel vegetablesLabel1;
    private javax.swing.JLabel vegetablesLabel2;
    private javax.swing.JLabel vegetablesLabel3;
    private javax.swing.JLabel vegetablesLabel4;
    private javax.swing.JLabel vegetablesLabel5;
    private javax.swing.JLabel vegetablesLabel6;
    private javax.swing.JLabel vegetablesLabel7;
    private javax.swing.JLabel vegetablesLabel8;
    private javax.swing.JPanel vegetablesPanel;
    public static javax.swing.JLabel vegetablesSlot1;
    public static javax.swing.JLabel vegetablesSlot2;
    public static javax.swing.JLabel vegetablesSlot3;
    public static javax.swing.JLabel vegetablesSlot4;
    public static javax.swing.JLabel vegetablesSlot5;
    public static javax.swing.JLabel vegetablesSlot6;
    public static javax.swing.JLabel vegetablesSlot7;
    public static javax.swing.JLabel vegetablesSlot8;
    private javax.swing.JLabel winesLabel1;
    private javax.swing.JLabel winesLabel2;
    private javax.swing.JLabel winesLabel3;
    private javax.swing.JLabel winesLabel4;
    private javax.swing.JLabel winesLabel5;
    private javax.swing.JLabel winesLabel6;
    private javax.swing.JLabel winesLabel7;
    private javax.swing.JLabel winesLabel8;
    private javax.swing.JPanel winesPanel;
    public static javax.swing.JLabel winesSlot1;
    public static javax.swing.JLabel winesSlot2;
    public static javax.swing.JLabel winesSlot3;
    public static javax.swing.JLabel winesSlot4;
    public static javax.swing.JLabel winesSlot5;
    public static javax.swing.JLabel winesSlot6;
    public static javax.swing.JLabel winesSlot7;
    public static javax.swing.JLabel winesSlot8;
    // End of variables declaration//GEN-END:variables

}
