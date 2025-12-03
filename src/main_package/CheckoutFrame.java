/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main_package;

import java.awt.Color;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class CheckoutFrame extends javax.swing.JFrame {

    /**
     * Creates new form CheckoutFrame
     */
    private String shippingMethod = "Pickup"; // default

    public void setVoucher(float discount, boolean isPercent) {
        if (isPercent) {
            this.voucherDiscountPercent = discount; // assign to the percentage variable
        } else {
            this.voucherDiscountPercent = 0f; // ignore peso vouchers
        }

        updateCombinedSubtotal();
    }

    public void setShippingMethod(String method) {
        if (method == null || (!method.equals("Pickup") && !method.equals("Delivery"))) {
            // invalid method, do nothing
            JOptionPane.showMessageDialog(this, "Please select a shipping method.");
            return;
        }

        this.shippingMethod = method;

        float baseFee = 50;
        float cityFee = 0;
        String city = dbManager != null ? dbManager.retrieveCity(email) : null;

        if ("Pickup".equals(method)) {
            deliveryFee1 = 0;
            deliveryFee2 = 0;
        } else { // Delivery
            if (city != null && !"Baliwag".equals(city) && shippingFees.containsKey(city)) {
                cityFee = shippingFees.get(city);
            }

            deliveryFee1 = selectedProduct1 != null ? baseFee + cityFee : 0;
            deliveryFee2 = selectedProduct2 != null ? baseFee + cityFee : 0;

        }

        selectShippingOption.setText(method);
        updateCombinedSubtotal();
    }
    private Map<String, Integer> shippingFees = new HashMap<>() {
        {
            put("Baliwag", 50);
            put("Bustos", 60);
            put("Plaridel", 80);
            put("San Ildefonso", 80);
            put("San Rafael", 70);
            put("Balagtas", 80);
            put("Bulakan", 80);
            put("Bocaue", 90);
            put("Guiguinto", 90);
            put("Pulilan", 90);
            put("Marilao", 100);
            put("Meycauayan", 100);
            put("Pandi", 110);
            put("Paombong", 110);
            put("Obando", 110);
            put("Hagonoy", 120);
            put("San Jose del Monte", 120);
            put("San Miguel", 130);
            put("Santa Maria", 140);
            put("Angat", 130);
            put("Calumpit", 130);
            put("Doña Remedios Trinidad", 150);
        }
    };

    private DatabaseManager dbManager;

    private Product selectedProduct1;
    private Product selectedProduct2;
    private int quantity1;
    private int quantity2;
    private float deliveryFee1;
    private float deliveryFee2;
    private String email;

    private String temp;

    public CheckoutFrame(DatabaseManager dbManager, CartFrame cFrame, String email) {
        initComponents();

        this.dbManager = dbManager;
        this.email = email;

        setLocationRelativeTo(null);
        setResizable(false);

        // Set up navigation
        Listener.addLabelListener(gotoLandingPanelLogo, this, cFrame);
        setShippingMethod("Delivery");

    }

    public void setCartData(Product p1, int q1, float d1, Product p2, int q2, float d2) {
        this.selectedProduct1 = p1;
        this.quantity1 = q1;
        this.deliveryFee1 = d1;

        this.selectedProduct2 = p2;
        this.quantity2 = q2;
        this.deliveryFee2 = d2;

        loadCartProductsToUI();
    }

    public void refreshAfterAddressUpdate(String email) {
        setEmail(email);           // reload address + phone + shipping fee
        updateCombinedSubtotal();  // recalc subtotal + delivery + grand total
    }

    private void loadCartProductsToUI() {
        if (selectedProduct1 != null) {
            productName1.setText(selectedProduct1.getName());
            productPrice1.setText("₱" + String.format("%.2f", selectedProduct1.getPrice()));
            qty1.setText(String.valueOf(quantity1));

            ImageIcon icon = new ImageIcon(selectedProduct1.getImagePath());
            Image img = icon.getImage().getScaledInstance(lblImage1.getWidth(), lblImage1.getHeight(), Image.SCALE_SMOOTH);
            lblImage1.setIcon(new ImageIcon(img));
        }

        if (selectedProduct2 != null) {
            productName2.setText(selectedProduct2.getName());
            productPrice2.setText("₱" + String.format("%.2f", selectedProduct2.getPrice()));
            qty2.setText(String.valueOf(quantity2));
            ImageIcon icon = new ImageIcon(selectedProduct2.getImagePath());
            Image img = icon.getImage().getScaledInstance(lblImage2.getWidth(), lblImage2.getHeight(), Image.SCALE_SMOOTH);
            lblImage2.setIcon(new ImageIcon(img));
        }

        updateCombinedSubtotal();
    }

    private void updateCombinedSubtotal() {
        float productTotal = 0;
        float baseFeeTotal = 0;
        float distanceFeeTotal = 0;

// Base fee is fixed
        float baseFee = 50;

// Get city fee
        String city = dbManager != null ? dbManager.retrieveCity(email) : null;
        float cityFee = 0;
        if (city != null && !"Baliwag".equals(city) && shippingFees.containsKey(city)) {
            cityFee = shippingFees.get(city);
        }

        if (selectedProduct1 != null) {
            productTotal += selectedProduct1.getPrice() * quantity1;
            if ("Delivery".equals(shippingMethod)) {
                baseFeeTotal += baseFee;
                distanceFeeTotal += cityFee;
            }
        }

        if (selectedProduct2 != null) {
            productTotal += selectedProduct2.getPrice() * quantity2;
            if ("Delivery".equals(shippingMethod)) {
                baseFeeTotal += baseFee;
                distanceFeeTotal += cityFee;
            }
        }

        float deliveryTotal = baseFeeTotal + distanceFeeTotal;

// --- APPLY PERCENTAGE VOUCHER ---
        float discountedProductTotal = productTotal;
        if (voucherDiscountPercent > 0) { // voucherDiscountPercent is 0.1 for 10%, 0.15 for 15%, etc.
            discountedProductTotal -= (productTotal * voucherDiscountPercent);
        }

// GRAND TOTAL = discounted product subtotal + delivery
        float grandTotal = discountedProductTotal + deliveryTotal;

// Update GUI labels
        subTotalLabel.setText("₱" + String.format("%.2f", productTotal));
        lblBaseFee.setText("₱" + String.format("%.2f", baseFeeTotal));
        lblDistanceFee.setText("₱" + String.format("%.2f", distanceFeeTotal));
        lblDeliveryFee.setText("₱" + String.format("%.2f", deliveryTotal));

        lblDiscount.setText("-" + (int) (voucherDiscountPercent * 100) + "%"); // optional
        lblGrandTotal.setText("₱" + String.format("%.2f", grandTotal));
    }

    private float voucherDiscountPercent = 0f;

    private String userAddress;

    public void setEmail(String email) {
        if (email == null) {
            return;
        }

        this.email = email; // store email for later use

        // --- Load user info ---
        String fullName = dbManager.getNameByEmail(email);
        String fullAddress = dbManager.retrieveFullAddress(email);
        String phoneNumber = dbManager.retrievePhoneNumber(email);

        System.out.println("HERE IT IS");
        System.out.println(fullName);
        System.out.println(fullAddress);
        System.out.println(phoneNumber);

        nameLabel1.setText(fullName);
        addressLabel.setText(fullAddress);
        phoneNumberLabel.setText(phoneNumber);

        this.userAddress = fullAddress;

        // --- Get shipping fee based on city ---
        String city = dbManager.retrieveCity(email);

        float shippingFee = 0;

        System.out.println("Retrieved city: " + city);

        if (city != null && shippingFees.containsKey(city)) {
            shippingFee = shippingFees.get(city);
        }

        System.out.println("Calculated shipping fee: " + shippingFee);

        // --- Reset delivery fees to base product delivery + shipping ---
        if (selectedProduct1 != null) {
            deliveryFee1 = shippingFee; // only shipping, or add base fee if any
        }
        if (selectedProduct2 != null) {
            deliveryFee2 = shippingFee; // only shipping, or add base fee if any
        }

        // --- Refresh totals on UI ---
        updateCombinedSubtotal();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jDialog1 = new javax.swing.JDialog();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel6 = new javax.swing.JPanel();
        gotoLandingPanelLogo = new javax.swing.JLabel();
        myCartImage = new javax.swing.JLabel();
        gotoRegisterImage = new javax.swing.JLabel();
        myCartButton1 = new javax.swing.JLabel();
        myCartButton = new javax.swing.JLabel();
        cartPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cashOnDeliverPanel = new javax.swing.JPanel();
        cashOnDeliverCB = new javax.swing.JCheckBox();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cashOnDeliverySeperator = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        gcashPanel = new javax.swing.JPanel();
        gcashCheckBox = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        gcashSeperator = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnPlaceOrder = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        lblGrandTotal = new javax.swing.JLabel();
        subTotalLabel = new javax.swing.JLabel();
        lblDeliveryFee = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        selectShippingOption = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblDiscount = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        noteField = new javax.swing.JTextField();
        editAddressLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblDistanceFee = new javax.swing.JLabel();
        lblBaseFee = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        warningLabel2 = new javax.swing.JLabel();
        warningLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        editAddressLabel = new javax.swing.JLabel();
        shippingAddressLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblImage5 = new javax.swing.JLabel();
        productName1 = new javax.swing.JLabel();
        productPrice1 = new javax.swing.JLabel();
        lblImage1 = new javax.swing.JLabel();
        qty1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblImage4 = new javax.swing.JLabel();
        productPrice2 = new javax.swing.JLabel();
        lblImage2 = new javax.swing.JLabel();
        productName2 = new javax.swing.JLabel();
        qty2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(251, 239, 215));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gotoLandingPanelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/dashboard logo.png"))); // NOI18N
        gotoLandingPanelLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.add(gotoLandingPanelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 140, 80));

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

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1542, 96));

        cartPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(164, 113, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Order Summary");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 340, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Total:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, -1, -1));

        cashOnDeliverPanel.setBackground(new java.awt.Color(255, 255, 255));
        cashOnDeliverPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        cashOnDeliverPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cashOnDeliverCB.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(cashOnDeliverCB);
        cashOnDeliverCB.setForeground(new java.awt.Color(255, 51, 51));
        cashOnDeliverCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cashOnDeliverCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashOnDeliverCBActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel27.setText("Cash on Delivery");

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cash on deliver icon.png"))); // NOI18N

        cashOnDeliverySeperator.setForeground(new java.awt.Color(204, 204, 204));

        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Pay When you recieve");

        javax.swing.GroupLayout cashOnDeliverPanelLayout = new javax.swing.GroupLayout(cashOnDeliverPanel);
        cashOnDeliverPanel.setLayout(cashOnDeliverPanelLayout);
        cashOnDeliverPanelLayout.setHorizontalGroup(
            cashOnDeliverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cashOnDeliverPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cashOnDeliverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cashOnDeliverPanelLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                        .addComponent(cashOnDeliverCB)
                        .addContainerGap())
                    .addGroup(cashOnDeliverPanelLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(cashOnDeliverySeperator)
        );
        cashOnDeliverPanelLayout.setVerticalGroup(
            cashOnDeliverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cashOnDeliverPanelLayout.createSequentialGroup()
                .addGroup(cashOnDeliverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cashOnDeliverPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(cashOnDeliverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cashOnDeliverCB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(cashOnDeliverySeperator, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(cashOnDeliverPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 400, 100));

        gcashPanel.setBackground(new java.awt.Color(255, 255, 255));
        gcashPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        gcashPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        gcashCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(gcashCheckBox);
        gcashCheckBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gcashCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gcashCheckBoxActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel28.setText("GCash e-Wallet ");

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gcash icon.png"))); // NOI18N

        gcashSeperator.setForeground(new java.awt.Color(204, 204, 204));

        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setText("GCash e-Wallet");

        javax.swing.GroupLayout gcashPanelLayout = new javax.swing.GroupLayout(gcashPanel);
        gcashPanel.setLayout(gcashPanelLayout);
        gcashPanelLayout.setHorizontalGroup(
            gcashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gcashPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(gcashCheckBox)
                .addContainerGap())
            .addComponent(gcashSeperator, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(gcashPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gcashPanelLayout.setVerticalGroup(
            gcashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gcashPanelLayout.createSequentialGroup()
                .addGroup(gcashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gcashPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(gcashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(gcashCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(gcashSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel32)
                .addContainerGap())
        );

        jPanel3.add(gcashPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 400, 100));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setText("Select Payment Method");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnPlaceOrder.setBackground(new java.awt.Color(215, 118, 25));
        btnPlaceOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPlaceOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnPlaceOrder.setText("PLACE ORDER NOW");
        btnPlaceOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlaceOrder.setFocusable(false);
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceOrderActionPerformed(evt);
            }
        });
        jPanel3.add(btnPlaceOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 690, 400, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel11.setText("Discount");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 90, 30));

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 400, 10));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setText("Order Detail");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        lblGrandTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGrandTotal.setForeground(new java.awt.Color(215, 118, 25));
        lblGrandTotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblGrandTotal.setText("0.00");
        jPanel3.add(lblGrandTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 650, 280, 30));

        subTotalLabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        subTotalLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        subTotalLabel.setText("0.00");
        jPanel3.add(subTotalLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 280, 20));

        lblDeliveryFee.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblDeliveryFee.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblDeliveryFee.setText("0.00");
        jPanel3.add(lblDeliveryFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, 280, 20));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel31.setText("Subtotal");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        selectShippingOption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectShippingOption.setForeground(new java.awt.Color(51, 153, 255));
        selectShippingOption.setText("Select Shipping Option>");
        selectShippingOption.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectShippingOption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectShippingOptionMouseClicked(evt);
            }
        });
        jPanel3.add(selectShippingOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("b. Distance Fee . . . . . . . . . . . . . . . . . . . . . . . . . . . .  ");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, -1, -1));

        lblDiscount.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblDiscount.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblDiscount.setText("0.00");
        jPanel3.add(lblDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 610, 280, 20));

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Message");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 70, 20));

        noteField.setForeground(new java.awt.Color(153, 153, 153));
        noteField.setText("Note to Delivery Rider");
        noteField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteFieldActionPerformed(evt);
            }
        });
        jPanel3.add(noteField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 390, 50));

        editAddressLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editAddressLabel2.setForeground(new java.awt.Color(51, 153, 255));
        editAddressLabel2.setText("View all methods>");
        editAddressLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(editAddressLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel17.setText("Total Shipping Fee");
        jLabel17.setToolTipText("Delivery fee includes base fee + distance fee based on your city.");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel19.setText("Shipping Fee");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("a. Base Fee . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .  ");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, -1));

        lblDistanceFee.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblDistanceFee.setForeground(new java.awt.Color(102, 102, 102));
        lblDistanceFee.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblDistanceFee.setText("0.00");
        jPanel3.add(lblDistanceFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 520, 280, 20));

        lblBaseFee.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblBaseFee.setForeground(new java.awt.Color(102, 102, 102));
        lblBaseFee.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblBaseFee.setText("0.00");
        lblBaseFee.setToolTipText("");
        jPanel3.add(lblBaseFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 280, 20));

        cartPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 440, 750));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        warningLabel2.setForeground(new java.awt.Color(255, 51, 51));
        warningLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(warningLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 190, 20));

        warningLabel1.setForeground(new java.awt.Color(255, 51, 51));
        warningLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(warningLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 190, 20));

        jPanel4.setBackground(new java.awt.Color(245, 245, 245));

        editAddressLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editAddressLabel.setForeground(new java.awt.Color(51, 153, 255));
        editAddressLabel.setText("Edit Shipping Address");
        editAddressLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editAddressLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editAddressLabelMouseClicked(evt);
            }
        });

        shippingAddressLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        shippingAddressLabel.setText("Shipping Address");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(shippingAddressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 485, Short.MAX_VALUE)
                .addComponent(editAddressLabel)
                .addGap(34, 34, 34))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editAddressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(shippingAddressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 40));

        addressLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addressLabel.setText("Address of the user");
        jPanel1.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        nameLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameLabel1.setText("Name of the User");
        jPanel1.add(nameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        phoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phoneNumberLabel.setText("Contact Number / Email of the user");
        jPanel1.add(phoneNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        cartPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 780, 130));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        cartPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 40));

        jPanel5.setBackground(new java.awt.Color(245, 245, 245));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(108, 108, 108));
        jLabel8.setText("Unit Quantity");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 0, -1, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Package 1 of 2 ");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 6, -1, 28));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(108, 108, 108));
        jLabel13.setText("Product Name");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, -1, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(108, 108, 108));
        jLabel14.setText("Product Price");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, 40));

        cartPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 780, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImage5.setForeground(new java.awt.Color(204, 204, 204));
        lblImage5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.add(lblImage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 130, 120));

        productName1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        productName1.setText("Product Name");
        jPanel7.add(productName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        productPrice1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        productPrice1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productPrice1.setText("Product Price");
        jPanel7.add(productPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        lblImage1.setForeground(new java.awt.Color(204, 204, 204));
        lblImage1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.add(lblImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 134, 129));

        qty1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        qty1.setText("0");
        jPanel7.add(qty1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

        cartPanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 780, 170));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImage4.setForeground(new java.awt.Color(204, 204, 204));
        lblImage4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel8.add(lblImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 130, 120));

        productPrice2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        productPrice2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productPrice2.setText("Product Price");
        jPanel8.add(productPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, 20));

        lblImage2.setForeground(new java.awt.Color(204, 204, 204));
        lblImage2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel8.add(lblImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 134, 129));

        productName2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        productName2.setText("Product Name");
        jPanel8.add(productName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, 20));

        qty2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        qty2.setText("0");
        jPanel8.add(qty2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 10, -1));

        cartPanel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 780, 190));

        jPanel9.setBackground(new java.awt.Color(245, 245, 245));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Package 2 of 2 ");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(108, 108, 108));
        jLabel15.setText("Product Name");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(108, 108, 108));
        jLabel16.setText("Product Price");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(108, 108, 108));
        jLabel18.setText("Unit Quantity");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel10)
                .addGap(42, 42, 42)
                .addComponent(jLabel15)
                .addGap(163, 163, 163)
                .addComponent(jLabel16)
                .addGap(130, 130, 130)
                .addComponent(jLabel18)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        cartPanel.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 780, -1));

        getContentPane().add(cartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1540, 770));

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel12.setBackground(new java.awt.Color(228, 166, 107));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1540, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 910, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaceOrderActionPerformed

        if (shippingMethod == null) {
            JOptionPane.showMessageDialog(this, "Please select a shipping method before proceeding.");
            return;
        }

        if (selectedPaymentMethod == null) {
            JOptionPane.showMessageDialog(this, "Please select a payment method");
            return;
        }

        if (addressLabel.getText().equalsIgnoreCase("No address set")) {
            JOptionPane.showMessageDialog(this, "Please set an address for the user first!");
            return;
        }

// Make sure cart is not empty
        if ((selectedProduct1 == null || quantity1 <= 0)
                && (selectedProduct2 == null || quantity2 <= 0)) {
            JOptionPane.showMessageDialog(this, "Your cart is empty!");
            return;
        }

// Create the order object
        Order order = new Order(
                selectedProduct1, quantity1,
                selectedProduct2, quantity2,
                selectedPaymentMethod,
                Float.parseFloat(lblDeliveryFee.getText().replace("₱", "")),
                Float.parseFloat(subTotalLabel.getText().replace("₱", "")),
                Float.parseFloat(lblGrandTotal.getText().replace("₱", "")),
                shippingMethod
        );

        String deliveryNote = noteField.getText();

// Go to OrderPage directly
        DashboardFrame dbFrame = new DashboardFrame(true, dbManager.retrieveEmailUsingFullName(nameLabel1.getText()));
        OrderPage orderPage = new OrderPage(dbFrame, order, deliveryNote);
        System.out.println("UPDATRED EMAIL" + email);
        orderPage.setEmail(email);

        this.dispose();
        orderPage.setVisible(true);

    }//GEN-LAST:event_btnPlaceOrderActionPerformed

    private String selectedPaymentMethod;

    private void gcashCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gcashCheckBoxActionPerformed
        updatePaymentPanel();
        selectedPaymentMethod = "GCash";
    }//GEN-LAST:event_gcashCheckBoxActionPerformed

    private void cashOnDeliverCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashOnDeliverCBActionPerformed
        updatePaymentPanel();
        selectedPaymentMethod = "COD";

    }//GEN-LAST:event_cashOnDeliverCBActionPerformed

    private void myCartImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myCartImageMouseEntered
        myCartButton.setForeground(new Color(101, 13, 2));
    }//GEN-LAST:event_myCartImageMouseEntered

    private void myCartImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myCartImageMouseExited
        myCartButton.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_myCartImageMouseExited

    private void gotoRegisterImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gotoRegisterImageMouseEntered

    }//GEN-LAST:event_gotoRegisterImageMouseEntered

    private void gotoRegisterImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gotoRegisterImageMouseExited

    }//GEN-LAST:event_gotoRegisterImageMouseExited

    private void noteFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noteFieldActionPerformed

    private void selectShippingOptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectShippingOptionMouseClicked
        ShippingOptionDialog shipOption = new ShippingOptionDialog(this, true, this);
        shipOption.setVisible(true);

    }//GEN-LAST:event_selectShippingOptionMouseClicked

    private void editAddressLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editAddressLabelMouseClicked
        AddressDialog s = new AddressDialog(this, true, this);
        s.setVisible(true);
    }//GEN-LAST:event_editAddressLabelMouseClicked

    private void updatePaymentPanel() {
        if (cashOnDeliverCB.isSelected()) {
            cashOnDeliverPanel.setBorder(BorderFactory.createLineBorder(new Color(51, 153, 255)));
            cashOnDeliverySeperator.setForeground(new Color(51, 153, 255));
        } else {
            cashOnDeliverPanel.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
            cashOnDeliverySeperator.setForeground(new Color(204, 204, 204));
        }

        if (gcashCheckBox.isSelected()) {
            gcashPanel.setBorder(BorderFactory.createLineBorder(new Color(51, 153, 255)));
            gcashSeperator.setForeground(new Color(51, 153, 255));
        } else {
            gcashPanel.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
            gcashSeperator.setForeground(new Color(204, 204, 204));
        }

        cashOnDeliverPanel.revalidate();
        cashOnDeliverPanel.repaint();
        gcashPanel.revalidate();
        gcashPanel.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel addressLabel;
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel cartPanel;
    private javax.swing.JCheckBox cashOnDeliverCB;
    private javax.swing.JPanel cashOnDeliverPanel;
    private javax.swing.JSeparator cashOnDeliverySeperator;
    private javax.swing.JLabel editAddressLabel;
    private javax.swing.JLabel editAddressLabel2;
    private javax.swing.JCheckBox gcashCheckBox;
    private javax.swing.JPanel gcashPanel;
    private javax.swing.JSeparator gcashSeperator;
    private javax.swing.JLabel gotoLandingPanelLogo;
    private javax.swing.JLabel gotoRegisterImage;
    private javax.swing.JDialog jDialog1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblBaseFee;
    private javax.swing.JLabel lblDeliveryFee;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblDistanceFee;
    private javax.swing.JLabel lblGrandTotal;
    public javax.swing.JLabel lblImage1;
    public javax.swing.JLabel lblImage2;
    public javax.swing.JLabel lblImage4;
    public javax.swing.JLabel lblImage5;
    private javax.swing.JLabel myCartButton;
    private javax.swing.JLabel myCartButton1;
    private javax.swing.JLabel myCartImage;
    public static javax.swing.JLabel nameLabel1;
    private javax.swing.JTextField noteField;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JLabel productName1;
    private javax.swing.JLabel productName2;
    private javax.swing.JLabel productPrice1;
    private javax.swing.JLabel productPrice2;
    private javax.swing.JLabel qty1;
    private javax.swing.JLabel qty2;
    public static javax.swing.JLabel selectShippingOption;
    public static javax.swing.JLabel shippingAddressLabel;
    private javax.swing.JLabel subTotalLabel;
    private javax.swing.JLabel warningLabel1;
    private javax.swing.JLabel warningLabel2;
    // End of variables declaration//GEN-END:variables
}
