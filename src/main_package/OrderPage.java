package main_package;

import java.awt.Image;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.swing.ImageIcon;
import static main_package.FunctionFrame.dbManager;

public class OrderPage extends javax.swing.JFrame {

    private DashboardFrame dbFrame;
    private LocalDateTime now = LocalDateTime.now();
    private String currentTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    private DatabaseManager db = new DatabaseManager();

    private Order order;
    private String email;

    private String transactionNumber;
    
     private void generateTransactionNumber() {
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        int random = (int) (Math.random() * 900 + 100); // 3-digit random number
        transactionNumber = "TXN-" + timestamp + "-" + random;

        transactionNumberLabel.setText(transactionNumber); // show in UI
    }
     
    public OrderPage(DashboardFrame dbFrame, Order order) {

        this.dbFrame = dbFrame;
        this.order = order;

        email = dbFrame.getUserEmail();

        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        setEmail(email);

        Listener.addLabelListener(gotoLandingPanel, this, dbFrame);
        orderPlacedLabel.setText(currentTime);

        loadOrderDetails();

    }

    private void loadOrderDetails() {

        // PRODUCT 1
        if (order.getProduct1() != null) {
            lblProd1Name.setText(order.getProduct1().getName());
            lblProd1Qty.setText("x" + order.getQuantity1());
            lblProd1Price.setText("₱" + order.getProduct1().getPrice());

            // IMAGE 1
            ImageIcon icon1 = new ImageIcon(order.getProduct1().getImagePath());
            Image img1 = icon1.getImage().getScaledInstance(
                    lblProd1Image.getWidth(), lblProd1Image.getHeight(), Image.SCALE_SMOOTH);
            lblProd1Image.setIcon(new ImageIcon(img1));
        }

        // PRODUCT 2
        if (order.getProduct2() != null) {
            lblProd2Name.setText(order.getProduct2().getName());
            lblProd2Qty.setText("x" + order.getQuantity2());
            lblProd2Price.setText("₱" + order.getProduct2().getPrice());

            // IMAGE 2
            ImageIcon icon2 = new ImageIcon(order.getProduct2().getImagePath());
            Image img2 = icon2.getImage().getScaledInstance(
                    lblProd2Image.getWidth(), lblProd2Image.getHeight(), Image.SCALE_SMOOTH);
            lblProd2Image.setIcon(new ImageIcon(img2));
        }

        // TOTALS
        lblPaymentMethod.setText(order.getPaymentMethod());
        lblDeliveryFee.setText("₱" + order.getDeliveryFee());
        lblSubtotal.setText("₱" + order.getSubtotal());
        lblGrandTotal.setText("₱" + order.getGrandTotal());

        String userProvince = db.getUserProvince(email);
        String assignedPartner = null;

        Map<String, List<String>> deliveryMap = new HashMap<>();
        deliveryMap.put("J&T Express", Arrays.asList("Bulacan", "Pampanga", "Tarlac"));
        deliveryMap.put("LBC Express", Arrays.asList("Zambales", "Bataan", "Nueva Ecija"));
        deliveryMap.put("Ninja Van", Arrays.asList("La Union", "Pangasinan", "Ilocos Sur"));

        Map<String, ImageIcon> courierLogos = new HashMap<>();
        courierLogos.put("J&T Express", loadIcon("/icons/jnt.png"));
        courierLogos.put("LBC Express", loadIcon("/icons/lbc.png"));
        courierLogos.put("Ninja Van", loadIcon("/icons/ninja.png"));
        courierLogos.put("Default Courier", loadIcon("/icons/default.png"));

        assignedPartner = "Default Courier"; // default
        for (String partner : deliveryMap.keySet()) {
            if (deliveryMap.get(partner).contains(userProvince)) {
                assignedPartner = partner;
                break;
            }
        }

        if (assignedPartner == null) {
            assignedPartner = "Default Courier";
        }

        ImageIcon icon = courierLogos.getOrDefault(assignedPartner, courierLogos.get("Default Courier"));
        if (icon != null) {
            Image img = icon.getImage().getScaledInstance(lblCourierLogo.getWidth(), lblCourierLogo.getHeight(), Image.SCALE_SMOOTH);
            lblCourierLogo.setIcon(new ImageIcon(img));
        } else {
            System.out.println("Courier logo not found for: " + assignedPartner);
        }
        
        lblAssignedCourier.setText(assignedPartner);
        generateTransactionNumber();
        
    }
    
    private ImageIcon loadIcon(String path) {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL);
    } else {
        System.out.println("Image not found: " + path);
        return null;
    }
}

    public void setEmail(String email) {
        if (email == null) {
            return; // safety check
        }
        String fullName = dbManager.getNameByEmail(email);
        String fullAddress = dbManager.retrieveFullAddress(email);
        String phoneNumber = dbManager.retrievePhoneNumber(email);

        nameLabel1.setText(fullName != null ? fullName : "");
        addressLabel.setText(fullAddress != null ? fullAddress : "");
        phoneNumberLabel.setText(phoneNumber);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel6 = new javax.swing.JPanel();
        gotoLandingPanel = new javax.swing.JLabel();
        myCartImage = new javax.swing.JLabel();
        gotoRegisterImage = new javax.swing.JLabel();
        myCartButton1 = new javax.swing.JLabel();
        myCartButton = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        warningLabel2 = new javax.swing.JLabel();
        warningLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        shippingAddressLabel = new javax.swing.JLabel();
        transactionNumberLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        lblProd1Qty = new javax.swing.JLabel();
        lblProd1Image = new javax.swing.JLabel();
        lblProd1Price = new javax.swing.JLabel();
        lblProd2Image = new javax.swing.JLabel();
        lblProd2Qty = new javax.swing.JLabel();
        lblProd2Name = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblGrandTotal = new javax.swing.JLabel();
        lblProd2Price = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        productPrice3 = new javax.swing.JLabel();
        productName11 = new javax.swing.JLabel();
        lblProd1Name = new javax.swing.JLabel();
        lblPaymentMethod = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        productName14 = new javax.swing.JLabel();
        productName15 = new javax.swing.JLabel();
        productName16 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        productName17 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        productPrice2 = new javax.swing.JLabel();
        lblDeliveryFee = new javax.swing.JLabel();
        productName20 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        productName18 = new javax.swing.JLabel();
        lblAssignedCourier = new javax.swing.JLabel();
        lblCourierLogo = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        productName13 = new javax.swing.JLabel();
        orderPlacedLabel = new javax.swing.JLabel();
        productName21 = new javax.swing.JLabel();
        productName22 = new javax.swing.JLabel();
        productName23 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(251, 239, 215));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gotoLandingPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/dashboard logo.png"))); // NOI18N
        gotoLandingPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.add(gotoLandingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 140, 80));

        myCartImage.setBackground(new java.awt.Color(25, 145, 77));
        myCartImage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        myCartImage.setForeground(new java.awt.Color(153, 153, 153));
        myCartImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cart icon - test.png"))); // NOI18N
        myCartImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        myCartImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                myCartImageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                myCartImageMouseExited(evt);
            }
        });
        jPanel6.add(myCartImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 20, -1, 50));

        gotoRegisterImage.setBackground(new java.awt.Color(25, 145, 77));
        gotoRegisterImage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gotoRegisterImage.setForeground(new java.awt.Color(153, 153, 153));
        gotoRegisterImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/register icon - test.png"))); // NOI18N
        gotoRegisterImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gotoRegisterImageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gotoRegisterImageMouseExited(evt);
            }
        });
        jPanel6.add(gotoRegisterImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 10, -1, 60));

        myCartButton1.setBackground(new java.awt.Color(25, 145, 77));
        myCartButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        myCartButton1.setForeground(new java.awt.Color(153, 153, 153));
        myCartButton1.setText("MY CART");
        jPanel6.add(myCartButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 70, -1, -1));

        myCartButton.setBackground(new java.awt.Color(25, 145, 77));
        myCartButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        myCartButton.setForeground(new java.awt.Color(153, 153, 153));
        myCartButton.setText("MY ACCOUNT");
        jPanel6.add(myCartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 70, -1, -1));

        jPanel2.setBackground(new java.awt.Color(228, 166, 107));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1542, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1542, 96));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        warningLabel2.setForeground(new java.awt.Color(255, 51, 51));
        warningLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(warningLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 190, 20));

        warningLabel1.setForeground(new java.awt.Color(255, 51, 51));
        warningLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(warningLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 190, 20));

        jPanel4.setBackground(new java.awt.Color(245, 245, 245));

        shippingAddressLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        shippingAddressLabel.setText("Shipping Address");

        transactionNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        transactionNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        transactionNumberLabel.setText("Transaction Number");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(shippingAddressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 735, Short.MAX_VALUE)
                .addComponent(transactionNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(shippingAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(transactionNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 40));

        addressLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addressLabel.setText("Address of the user");
        jPanel3.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        nameLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameLabel1.setText("Name of the User");
        jPanel3.add(nameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        phoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phoneNumberLabel.setText("Contact Number / Email of the user");
        jPanel3.add(phoneNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1180, 110));

        lblProd1Qty.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblProd1Qty.setText("x1");
        jPanel1.add(lblProd1Qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 90, -1));

        lblProd1Image.setForeground(new java.awt.Color(204, 204, 204));
        lblProd1Image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(lblProd1Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 100, 90));

        lblProd1Price.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblProd1Price.setForeground(new java.awt.Color(102, 102, 102));
        lblProd1Price.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblProd1Price.setText("0");
        jPanel1.add(lblProd1Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 190, 130, 20));

        lblProd2Image.setForeground(new java.awt.Color(204, 204, 204));
        lblProd2Image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(lblProd2Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 100, 90));

        lblProd2Qty.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblProd2Qty.setText("x1");
        jPanel1.add(lblProd2Qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 90, -1));

        lblProd2Name.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblProd2Name.setText("Product Name");
        jPanel1.add(lblProd2Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 500, -1));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 1190, -1));

        lblGrandTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblGrandTotal.setForeground(new java.awt.Color(215, 118, 25));
        lblGrandTotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblGrandTotal.setText("ORDER TOTAL");
        jPanel1.add(lblGrandTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 540, 220, 80));

        lblProd2Price.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblProd2Price.setForeground(new java.awt.Color(102, 102, 102));
        lblProd2Price.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblProd2Price.setText("0");
        jPanel1.add(lblProd2Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 300, 130, 20));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 410, -1, -1));

        jSeparator6.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator6.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 1160, 10));

        productPrice3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        productPrice3.setForeground(new java.awt.Color(215, 118, 25));
        productPrice3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        productPrice3.setText("Product Price");
        jPanel1.add(productPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 140, 210, 40));

        productName11.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        productName11.setForeground(new java.awt.Color(51, 51, 51));
        productName11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(productName11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 460, 90, -1));

        lblProd1Name.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblProd1Name.setText("Product Name");
        jPanel1.add(lblProd1Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 510, -1));

        lblPaymentMethod.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblPaymentMethod.setForeground(new java.awt.Color(51, 51, 51));
        lblPaymentMethod.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPaymentMethod.setText("XXXXX");
        jPanel1.add(lblPaymentMethod, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, 340, 40));

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 1200, 10));

        productName14.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        productName14.setForeground(new java.awt.Color(51, 51, 51));
        productName14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productName14.setText("Delivery Partner");
        jPanel1.add(productName14, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, 110, -1));

        productName15.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        productName15.setForeground(new java.awt.Color(51, 51, 51));
        productName15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        productName15.setText("Order Total");
        jPanel1.add(productName15, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 540, 110, 80));

        productName16.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        productName16.setForeground(new java.awt.Color(51, 51, 51));
        productName16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productName16.setText("Shipping Fee");
        jPanel1.add(productName16, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 430, 100, -1));

        jSeparator4.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 1190, 20));

        jSeparator5.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 1190, 10));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 380, 10, 240));

        productName17.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        productName17.setForeground(new java.awt.Color(51, 51, 51));
        productName17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productName17.setText("(0 item)");
        jPanel1.add(productName17, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 390, 60, -1));

        lblSubtotal.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblSubtotal.setForeground(new java.awt.Color(51, 51, 51));
        lblSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblSubtotal.setText("XXXXX");
        jPanel1.add(lblSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 380, 340, 40));

        productPrice2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        productPrice2.setForeground(new java.awt.Color(215, 118, 25));
        productPrice2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        productPrice2.setText("Product Price");
        jPanel1.add(productPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 1180, 60));

        lblDeliveryFee.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblDeliveryFee.setForeground(new java.awt.Color(51, 51, 51));
        lblDeliveryFee.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblDeliveryFee.setText("XXXXX");
        jPanel1.add(lblDeliveryFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, 340, 40));

        productName20.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        productName20.setForeground(new java.awt.Color(51, 51, 51));
        productName20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productName20.setText("Payment Method");
        jPanel1.add(productName20, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, 120, 40));

        jSeparator7.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator7.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 1190, 10));

        productName18.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        productName18.setForeground(new java.awt.Color(51, 51, 51));
        productName18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productName18.setText("Subtotal");
        jPanel1.add(productName18, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, 60, -1));

        lblAssignedCourier.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblAssignedCourier.setForeground(new java.awt.Color(51, 51, 51));
        lblAssignedCourier.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblAssignedCourier.setText("XXXXXX");
        jPanel1.add(lblAssignedCourier, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 460, 240, 40));

        lblCourierLogo.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblCourierLogo.setForeground(new java.awt.Color(51, 51, 51));
        lblCourierLogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCourierLogo.setText("LOGO");
        jPanel1.add(lblCourierLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 460, 60, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1210, 620));

        jPanel12.setBackground(new java.awt.Color(228, 166, 107));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1540, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 1540, 90));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/order status.png"))); // NOI18N

        productName13.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        productName13.setForeground(new java.awt.Color(51, 51, 51));
        productName13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productName13.setText("Order Placed");

        orderPlacedLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        orderPlacedLabel.setForeground(new java.awt.Color(153, 153, 153));
        orderPlacedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderPlacedLabel.setText("0/0/0");

        productName21.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        productName21.setForeground(new java.awt.Color(51, 51, 51));
        productName21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productName21.setText("To Ship");

        productName22.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        productName22.setForeground(new java.awt.Color(51, 51, 51));
        productName22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productName22.setText("To Pay");

        productName23.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        productName23.setForeground(new java.awt.Color(51, 51, 51));
        productName23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productName23.setText("To Recieve");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productName21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productName22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(productName13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54))
                                    .addComponent(productName23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(orderPlacedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(productName13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderPlacedLabel)
                        .addGap(116, 116, 116)
                        .addComponent(productName22)
                        .addGap(128, 128, 128)
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(productName21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(productName23)
                        .addGap(71, 71, 71))))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 120, 300, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myCartImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myCartImageMouseEntered
    }//GEN-LAST:event_myCartImageMouseEntered

    private void myCartImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myCartImageMouseExited
    }//GEN-LAST:event_myCartImageMouseExited

    private void gotoRegisterImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gotoRegisterImageMouseEntered

    }//GEN-LAST:event_gotoRegisterImageMouseEntered

    private void gotoRegisterImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gotoRegisterImageMouseExited

    }//GEN-LAST:event_gotoRegisterImageMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel addressLabel;
    private javax.swing.JLabel gotoLandingPanel;
    private javax.swing.JLabel gotoRegisterImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblAssignedCourier;
    private javax.swing.JLabel lblCourierLogo;
    private javax.swing.JLabel lblDeliveryFee;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JLabel lblPaymentMethod;
    public javax.swing.JLabel lblProd1Image;
    private javax.swing.JLabel lblProd1Name;
    private javax.swing.JLabel lblProd1Price;
    private javax.swing.JLabel lblProd1Qty;
    public javax.swing.JLabel lblProd2Image;
    private javax.swing.JLabel lblProd2Name;
    private javax.swing.JLabel lblProd2Price;
    private javax.swing.JLabel lblProd2Qty;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel myCartButton;
    private javax.swing.JLabel myCartButton1;
    private javax.swing.JLabel myCartImage;
    public static javax.swing.JLabel nameLabel1;
    private javax.swing.JLabel orderPlacedLabel;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JLabel productName11;
    private javax.swing.JLabel productName13;
    private javax.swing.JLabel productName14;
    private javax.swing.JLabel productName15;
    private javax.swing.JLabel productName16;
    private javax.swing.JLabel productName17;
    private javax.swing.JLabel productName18;
    private javax.swing.JLabel productName20;
    private javax.swing.JLabel productName21;
    private javax.swing.JLabel productName22;
    private javax.swing.JLabel productName23;
    private javax.swing.JLabel productPrice2;
    private javax.swing.JLabel productPrice3;
    public static javax.swing.JLabel shippingAddressLabel;
    private javax.swing.JLabel transactionNumberLabel;
    private javax.swing.JLabel warningLabel1;
    private javax.swing.JLabel warningLabel2;
    // End of variables declaration//GEN-END:variables
}
