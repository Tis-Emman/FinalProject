package main_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class DashboardFrame extends javax.swing.JFrame {

    public static int[] categoryCounters = new int[11];
    static boolean isLoggedIn;
    private String address;
    DatabaseManager dbManager = new DatabaseManager();
    TestLoginFrame tFrame = new TestLoginFrame();
    CartFrame cFrame = new CartFrame(dbManager, this);

    private String email; // store logged-in email
    CheckoutFrame checkoutFrame = new CheckoutFrame(dbManager, cFrame, email);
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

    public static JLabel[] category1Labels;
    public static JLabel[] category2Labels;
    public static JLabel[] category3Labels;
    public static JLabel[] category4Labels;
    public static JLabel[] category5Labels;
    public static JLabel[] category6Labels;
    public static JLabel[] category7Labels;
    public static JLabel[] category8Labels;
    public static JLabel[] category9Labels;
    public static JLabel[] category10Labels;
    public static JLabel[] category11Labels;

    public static JLabel[] category1Price;
    public static JLabel[] category2Price;
    public static JLabel[] category3Price;
    public static JLabel[] category4Price;
    public static JLabel[] category5Price;
    public static JLabel[] category6Price;
    public static JLabel[] category7Price;
    public static JLabel[] category8Price;
    public static JLabel[] category9Price;
    public static JLabel[] category10Price;
    public static JLabel[] category11Price;

    public static JLabel[] category1Stock;
    public static JLabel[] category2Stock;
    public static JLabel[] category3Stock;
    public static JLabel[] category4Stock;
    public static JLabel[] category5Stock;
    public static JLabel[] category6Stock;
    public static JLabel[] category7Stock;
    public static JLabel[] category8Stock;
    public static JLabel[] category9Stock;
    public static JLabel[] category10Stock;
    public static JLabel[] category11Stock;

    public String getUserEmail() {
        return email;
    }

    public DashboardFrame(boolean isLoggedIn, String email) {

        DashboardFrame.isLoggedIn = isLoggedIn;

        this.isLoggedIn = isLoggedIn;
        this.email = email;
        this.address = address;

        System.out.println("The email is " + email);

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

        String rememberedEmail = dbManager.getRememberedUser();
        System.out.println(rememberedEmail);

        gotoLandingPanelLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gotoRegisterImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gotoLoginImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paymentOptionsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        category1Slots = new JLabel[]{newProductsSlot1, newProductsSlot2, newProductsSlot3, newProductsSlot4, newProductsSlot5, newProductsSlot6, newProductsSlot7, newProductsSlot8};
        category2Slots = new JLabel[]{bakerySlot1, bakerySlot2, bakerySlot3, bakerySlot4, bakerySlot5, bakerySlot6, bakerySlot7, bakerySlot8};
        category3Slots = new JLabel[]{butcherySlot1, butcherySlot2, butcherySlot3, butcherySlot4, butcherySlot5, butcherySlot6, butcherySlot7, butcherySlot8};
        category4Slots = new JLabel[]{seafoodsSlot1, seafoodsSlot2, seafoodsSlot3, seafoodsSlot4, seafoodsSlot5, seafoodsSlot6, seafoodsSlot7, seafoodsSlot8};
        category5Slots = new JLabel[]{readyMealsSlot1, readyMealsSlot2, readyMealsSlot3, readyMealsSlot4, readyMealsSlot5, readyMealsSlot6, readyMealsSlot7, readyMealsSlot8};
        category6Slots = new JLabel[]{vegetablesSlot1, vegetablesSlot2, vegetablesSlot3, vegetablesSlot4, vegetablesSlot5, vegetablesSlot6, vegetablesSlot7, vegetablesSlot8};
        category7Slots = new JLabel[]{fruitsSlot1, fruitsSlot2, fruitsSlot3, fruitsSlot4, fruitsSlot5, fruitsSlot6, fruitsSlot7, fruitsSlot8};
        category8Slots = new JLabel[]{grocerySlot1, grocerySlot2, grocerySlot3, grocerySlot4, grocerySlot5, grocerySlot6, grocerySlot7, grocerySlot8};
        category9Slots = new JLabel[]{snacksSlot1, snacksSlot2, snacksSlot3, snacksSlot4, snacksSlot5, snacksSlot6, snacksSlot7, snacksSlot8};
        category10Slots = new JLabel[]{dessertsSlot1, dessertsSlot2, dessertsSlot3, dessertsSlot4, dessertsSlot5, dessertsSlot6, dessertsSlot7, dessertsSlot8};
        category11Slots = new JLabel[]{winesSlot1, winesSlot2, winesSlot3, winesSlot4, winesSlot5, winesSlot6, winesSlot7, winesSlot8};

        category1Labels = new JLabel[]{newProductsLabel1, newProductsLabel2, newProductsLabel3, newProductsLabel4, newProductsLabel5, newProductsLabel6, newProductsLabel7, newProductsLabel8};
        category2Labels = new JLabel[]{bakeryLabel1, bakeryLabel2, bakeryLabel3, bakeryLabel4, bakeryLabel5, bakeryLabel6, bakeryLabel7, bakeryLabel8};
        category3Labels = new JLabel[]{butcheryLabel1, butcheryLabel2, butcheryLabel3, butcheryLabel4, butcheryLabel5, butcheryLabel6, butcheryLabel7, butcheryLabel8};
        category4Labels = new JLabel[]{seafoodsLabel1, seafoodsLabel2, seafoodsLabel3, seafoodsLabel4, seafoodsLabel5, seafoodsLabel6, seafoodsLabel7, seafoodsLabel8};
        category5Labels = new JLabel[]{readyMealsLabel1, readyMealsLabel2, readyMealsLabel3, readyMealsLabel4, readyMealsLabel5, readyMealsLabel6, readyMealsLabel7, readyMealsLabel8};
        category6Labels = new JLabel[]{vegetablesLabel1, vegetablesLabel2, vegetablesLabel3, vegetablesLabel4, vegetablesLabel5, vegetablesLabel6, vegetablesLabel7, vegetablesLabel8};
        category7Labels = new JLabel[]{fruitsLabel1, fruitsLabel2, fruitsLabel3, fruitsLabel4, fruitsLabel5, fruitsLabel6, fruitsLabel7, fruitsLabel8};
        category8Labels = new JLabel[]{groceryLabel1, groceryLabel2, groceryLabel3, groceryLabel4, groceryLabel5, groceryLabel6, groceryLabel7, groceryLabel8};
        category9Labels = new JLabel[]{snacksLabel1, snacksLabel2, snacksLabel3, snacksLabel4, snacksLabel5, snacksLabel6, snacksLabel7, snacksLabel8};
        category10Labels = new JLabel[]{dessertsLabel1, dessertsLabel2, dessertsLabel3, dessertsLabel4, dessertsLabel5, dessertsLabel6, dessertsLabel7, dessertsLabel8};
        category11Labels = new JLabel[]{winesLabel1, winesLabel2, winesLabel3, winesLabel4, winesLabel5, winesLabel6, winesLabel7, winesLabel8};

        category1Price = new JLabel[]{newProductsPrice1, newProductsPrice2, newProductsPrice3, newProductsPrice4, newProductsPrice5, newProductsPrice6, newProductsPrice7, newProductsPrice8};
        category2Price = new JLabel[]{bakeryPrice1, bakeryPrice2, bakeryPrice3, bakeryPrice4, bakeryPrice5, bakeryPrice6, bakeryPrice7, bakeryPrice8};
        category3Price = new JLabel[]{butcheryPrice1, butcheryPrice2, butcheryPrice3, butcheryPrice4, butcheryPrice5, butcheryPrice6, butcheryPrice7, butcheryPrice8};
        category4Price = new JLabel[]{seafoodsPrice1, seafoodsPrice2, seafoodsPrice3, seafoodsPrice4, seafoodsPrice5, seafoodsPrice6, seafoodsPrice7, seafoodsPrice8};
        category5Price = new JLabel[]{readyMealsPrice1, readyMealsPrice2, readyMealsPrice3, readyMealsPrice4, readyMealsPrice5, readyMealsPrice6, readyMealsPrice7, readyMealsPrice8};
        category6Price = new JLabel[]{vegetablesPrice1, vegetablesPrice2, vegetablesPrice3, vegetablesPrice4, vegetablesPrice5, vegetablesPrice6, vegetablesPrice7, vegetablesPrice8};
        category7Price = new JLabel[]{fruitsPrice1, fruitsPrice2, fruitsPrice3, fruitsPrice4, fruitsPrice5, fruitsPrice6, fruitsPrice7, fruitsPrice8};
        category8Price = new JLabel[]{groceryPrice1, groceryPrice2, groceryPrice3, groceryPrice4, groceryPrice5, groceryPrice6, groceryPrice7, groceryPrice8};
        category9Price = new JLabel[]{snacksPrice1, snacksPrice2, snacksPrice3, snacksPrice4, snacksPrice5, snacksPrice6, snacksPrice7, snacksPrice8};
        category10Price = new JLabel[]{dessertsPrice1, dessertsPrice2, dessertsPrice3, dessertsPrice4, dessertsPrice5, dessertsPrice6, dessertsPrice7, dessertsPrice8};
        category11Price = new JLabel[]{winesPrice1, winesPrice2, winesPrice3, winesPrice4, winesPrice5, winesPrice6, winesPrice7, winesPrice8};

        category1Stock = new JLabel[]{newProductsStockLabel1, newProductsStockLabel2, newProductsStockLabel3, newProductsStockLabel4, newProductsStockLabel5, newProductsStockLabel6, newProductsStockLabel7, newProductsStockLabel8};
        category2Stock = new JLabel[]{bakeryStock1, bakeryStock2, bakeryStock3, bakeryStock4, bakeryStock5, bakeryStock6, bakeryStock7, bakeryStock8};
        category3Stock = new JLabel[]{butcheryStock1, butcheryStock2, butcheryStock3, butcheryStock4, butcheryStock5, butcheryStock6, butcheryStock7, butcheryStock8};
        category4Stock = new JLabel[]{seafoodsStock1, seafoodsStock2, seafoodsStock3, seafoodsStock4, seafoodsStock5, seafoodsStock6, seafoodsStock7, seafoodsStock8};
        category5Stock = new JLabel[]{readyMealsStock1, readyMealsStock2, readyMealsStock3, readyMealsStock4, readyMealsStock5, readyMealsStock6, readyMealsStock7, readyMealsStock8};
        category6Stock = new JLabel[]{vegetablesStock1, vegetablesStock2, vegetablesStock3, vegetablesStock4, vegetablesStock5, vegetablesStock6, vegetablesStock7, vegetablesStock8};
        category7Stock = new JLabel[]{fruitsStock1, fruitsStock2, fruitsStock3, fruitsStock4, fruitsStock5, fruitsStock6, fruitsStock7, fruitsStock8};
        category8Stock = new JLabel[]{groceryStock1, groceryStock2, groceryStock3, groceryStock4, groceryStock5, groceryStock6, groceryStock7, groceryStock8};
        category9Stock = new JLabel[]{snacksStock1, snacksStock2, snacksStock3, snacksStock4, snacksStock5, snacksStock6, snacksStock7, snacksStock8};
        category10Stock = new JLabel[]{dessertsStock1, dessertsStock2, dessertsStock3, dessertsStock4, dessertsStock5, dessertsStock6, dessertsStock7, dessertsStock8};
        category11Stock = new JLabel[]{winesStock1, winesStock2, winesStock3, winesStock4, winesStock5, winesStock6, winesStock7, winesStock8};

        setLocationRelativeTo(null);
        setResizable(false);
        sidebarPanel.setBorder(new MatteBorder(0, 0, 0, 3, new Color(228, 166, 107)));

        defaultLeft(bakeryButton);
        defaultLeft(butcheryButton);
        defaultLeft(seafoodsButton);
        defaultLeft(readyMealsButton);
        defaultLeft(vegetableButton);
        defaultLeft(fruitsButton);
        //defaultLeft(groceryButton);
        defaultLeft(snacksButton);
        defaultLeft(iceCreamButton);
        defaultLeft(beveragesButton);

        Listener.addLabelListener(gotoLoginButton, this, tFrame);
        Listener.addLabelListener(gotoLoginImage, this, tFrame);
        Listener.addLabelListener(shopNowButton, this, tFrame);
        Listener.gotoRegisterPanel(gotoRegisterImage, this, tFrame, TestLoginFrame.loginPanel, TestLoginFrame.registerPanel);
        Listener.gotoRegisterPanel(gotoRegisterButton, this, tFrame, TestLoginFrame.loginPanel, TestLoginFrame.registerPanel);

        showPanel(gotoLandingPanelLogo, landingPanel);

        add(newPanel);
        add(bottomFrame);

        dateChooser.setForeground(Color.GRAY);
        monthChooser.setForeground(Color.GRAY);
        yearChooser.setForeground(Color.GRAY);

        if (isLoggedIn) {
            gotoLoginImage.setVisible(false);
            gotoLoginButton.setVisible(false);
            shopNowButton.setVisible(false);
            gotoRegisterButton.setText("MY ACCOUNT");

            showPanel(gotoRegisterImage, accountPanel, this);
            showPanel(gotoRegisterButton, accountPanel, this);

            //IMPORTANT!!!!
            cFrame.setUserEmail(email);
            Listener.addLabelListener(myCartImage, this, cFrame);

            gotoRegisterImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            setup(this);
            switchPanel(this, landingPanel);

            fullNameHolder.setText(dbManager.retrieveUsername(email));
            emailHolder.setText(dbManager.retrieveEmail(email));
            phoneNumberHolder.setText(dbManager.retrievePhoneNumber(email));

            String fullAddress = dbManager.readFullAddress(email);

            String gender = dbManager.readGender(email);

            setGenderRadioButton(gender, maleGenderButton, femaleGenderButton, otherGenderButton);

            if (fullAddress == null || fullAddress.isEmpty()) {
                addressReader.setText("");
                addAddressLabel.setText("Add"); // default text
            } else {
                addressReader.setText(fullAddress);
                addAddressLabel.setText("Change");
            }

            String imagePath = dbManager.getProfileImage(email);
            if (imagePath != null && !imagePath.isEmpty()) {
                ImageIcon icon = new ImageIcon(
                        new ImageIcon(imagePath)
                                .getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)
                );
                imageProfileHolder.setIcon(icon);
            }

        } else {
            switchPanel(this, landingPanel);
            clickCartNotLoggedIn(myCartImage);
        }

        DatabaseManager.loadProductsFromDB();

        DatabaseManager.loadProductsFromDB();

        getOrderSlot1(bakeryAddToCart1, bakeryLabel1, bakeryPrice1);
        getOrderSlot1(bakeryAddToCart2, bakeryLabel2, bakeryPrice2);
        getOrderSlot1(bakeryAddToCart3, bakeryLabel3, bakeryPrice3);
        getOrderSlot1(bakeryAddToCart4, bakeryLabel4, bakeryPrice4);
        getOrderSlot1(bakeryAddToCart5, bakeryLabel5, bakeryPrice5);
        getOrderSlot1(bakeryAddToCart6, bakeryLabel6, bakeryPrice6);
        getOrderSlot1(bakeryAddToCart7, bakeryLabel7, bakeryPrice7);
        getOrderSlot1(bakeryAddToCart8, bakeryLabel8, bakeryPrice8);

        getOrderSlot2(butcheryAddToCart1, butcheryLabel1, butcheryPrice1);
        getOrderSlot2(butcheryAddToCart2, butcheryLabel2, butcheryPrice2);
        getOrderSlot2(butcheryAddToCart3, butcheryLabel3, butcheryPrice3);
        getOrderSlot2(butcheryAddToCart4, butcheryLabel4, butcheryPrice4);
        getOrderSlot2(butcheryAddToCart5, butcheryLabel5, butcheryPrice5);
        getOrderSlot2(butcheryAddToCart6, butcheryLabel6, butcheryPrice6);
        getOrderSlot2(butcheryAddToCart7, butcheryLabel7, butcheryPrice7);
        getOrderSlot2(butcheryAddToCart8, butcheryLabel8, butcheryPrice8);

        getOrderSlot1(readyMealsAddToCart1, readyMealsLabel1, readyMealsPrice1);
        getOrderSlot1(readyMealsAddToCart2, readyMealsLabel2, readyMealsPrice2);
        getOrderSlot1(readyMealsAddToCart3, readyMealsLabel3, readyMealsPrice3);
        getOrderSlot1(readyMealsAddToCart4, readyMealsLabel4, readyMealsPrice4);
        getOrderSlot1(readyMealsAddToCart5, readyMealsLabel5, readyMealsPrice5);
        getOrderSlot1(readyMealsAddToCart6, readyMealsLabel6, readyMealsPrice6);
        getOrderSlot1(readyMealsAddToCart7, readyMealsLabel7, readyMealsPrice7);
        getOrderSlot1(readyMealsAddToCart8, readyMealsLabel8, readyMealsPrice8);

        getOrderSlot2(vegetablesAddToCart1, vegetablesLabel1, vegetablesPrice1);
        getOrderSlot2(vegetablesAddToCart2, vegetablesLabel2, vegetablesPrice2);
        getOrderSlot2(vegetablesAddToCart3, vegetablesLabel3, vegetablesPrice3);
        getOrderSlot2(vegetablesAddToCart4, vegetablesLabel4, vegetablesPrice4);
        getOrderSlot2(vegetablesAddToCart5, vegetablesLabel5, vegetablesPrice5);
        getOrderSlot2(vegetablesAddToCart6, vegetablesLabel6, vegetablesPrice6);
        getOrderSlot2(vegetablesAddToCart7, vegetablesLabel7, vegetablesPrice7);
        getOrderSlot2(vegetablesAddToCart8, vegetablesLabel8, vegetablesPrice8);

        getOrderSlot1(fruitsAddToCart1, fruitsLabel1, fruitsPrice1);
        getOrderSlot1(fruitsAddToCart2, fruitsLabel2, fruitsPrice2);
        getOrderSlot1(fruitsAddToCart3, fruitsLabel3, fruitsPrice3);
        getOrderSlot1(fruitsAddToCart4, fruitsLabel4, fruitsPrice4);
        getOrderSlot1(fruitsAddToCart5, fruitsLabel5, fruitsPrice5);
        getOrderSlot1(fruitsAddToCart6, fruitsLabel6, fruitsPrice6);
        getOrderSlot1(fruitsAddToCart7, fruitsLabel7, fruitsPrice7);
        getOrderSlot1(fruitsAddToCart8, fruitsLabel8, fruitsPrice8);

        getOrderSlot2(snacksAddToCart1, snacksLabel1, snacksPrice1);
        getOrderSlot2(snacksAddToCart2, snacksLabel2, snacksPrice2);
        getOrderSlot2(snacksAddToCart3, snacksLabel3, snacksPrice3);
        getOrderSlot2(snacksAddToCart4, snacksLabel4, snacksPrice4);
        getOrderSlot2(snacksAddToCart5, snacksLabel5, snacksPrice5);
        getOrderSlot2(snacksAddToCart6, snacksLabel6, snacksPrice6);
        getOrderSlot2(snacksAddToCart7, snacksLabel7, snacksPrice7);
        getOrderSlot2(snacksAddToCart8, snacksLabel8, snacksPrice8);
        
        getOrderSlot1(dessertsAddToCart1, dessertsLabel1, dessertsPrice1);
        getOrderSlot1(dessertsAddToCart2, dessertsLabel2, dessertsPrice2);
        getOrderSlot1(dessertsAddToCart3, dessertsLabel3, dessertsPrice3);
        getOrderSlot1(dessertsAddToCart4, dessertsLabel4, dessertsPrice4);
        getOrderSlot1(dessertsAddToCart5, dessertsLabel5, dessertsPrice5);
        getOrderSlot1(dessertsAddToCart6, dessertsLabel6, dessertsPrice6);
        getOrderSlot1(dessertsAddToCart7, dessertsLabel7, dessertsPrice7);
        getOrderSlot1(dessertsAddToCart8, dessertsLabel8, dessertsPrice8);
        
        
        getOrderSlot2(winesAddToCart1, winesLabel1, winesPrice1);
        getOrderSlot2(winesAddToCart2, winesLabel2, winesPrice2);
        getOrderSlot2(winesAddToCart3, winesLabel3, winesPrice3);
        getOrderSlot2(winesAddToCart4, winesLabel4, winesPrice4);
        getOrderSlot2(winesAddToCart5, winesLabel5, winesPrice5);
        getOrderSlot2(winesAddToCart6, winesLabel6, winesPrice6);
        getOrderSlot2(winesAddToCart7, winesLabel7, winesPrice7);
        getOrderSlot2(winesAddToCart8, winesLabel8, winesPrice8);
        
        getOrderSlot1(seafoodsAddToCart1, seafoodsLabel1, seafoodsPrice1);
        getOrderSlot1(seafoodsAddToCart2, seafoodsLabel2, seafoodsPrice2);
        getOrderSlot1(seafoodsAddToCart3, seafoodsLabel3, seafoodsPrice3);
        getOrderSlot1(seafoodsAddToCart4, seafoodsLabel4, seafoodsPrice4);
        getOrderSlot1(seafoodsAddToCart5, seafoodsLabel5, seafoodsPrice5);
        getOrderSlot1(seafoodsAddToCart6, seafoodsLabel6, seafoodsPrice6);
        getOrderSlot1(seafoodsAddToCart7, seafoodsLabel7, seafoodsPrice7);
        getOrderSlot1(seafoodsAddToCart8, seafoodsLabel8, seafoodsPrice8);
        
        

        showPanel(paymentOptionsLabel, paymentOptionsPanel, this);
        showPanel(privacyPolicyLabel, privacyPolicyPanel, this);
        showPanel(FAQsLabel, faqsPanel, this);
        showPanel(aboutUsLabel, aboutUsPanel, this);
    }

    public void setGenderRadioButton(String gender, JRadioButton maleButton, JRadioButton femaleButton, JRadioButton othersButton) {
        maleButton.setSelected(false);
        femaleButton.setSelected(false);
        othersButton.setSelected(false);

        if (gender == null) {
            return; // nothing to select
        }
        // select the right button
        switch (gender.toLowerCase()) {
            case "m":
                maleButton.setSelected(true);
                break;
            case "f":
                femaleButton.setSelected(true);
                break;
            case "o":
                othersButton.setSelected(true);
                break;
            default:
                // no button selected
                break;
        }
    }

    public void getOrderSlot1(JLabel label, JLabel name, JLabel price) {

        label.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                
                if(name.getText().equalsIgnoreCase("Product Name")){
                    JOptionPane.showMessageDialog(rootPane, "Slot is Empty! Please choose another product");
                    return;
                }

                String productName = name.getText();

                // Load product but do NOT automatically select it
                cFrame.loadProduct1(productName);

                // Uncheck the checkbox initially
                cFrame.checkBoxSlot1.setSelected(false);

                JOptionPane.showMessageDialog(rootPane,
                        "Product added to cart! Please check the box to include it in checkout.");
            }
        });
    }

    public void getOrderSlot2(JLabel label, JLabel name, JLabel price) {

        label.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {

                if(name.getText().equalsIgnoreCase("Product Name")){
                    JOptionPane.showMessageDialog(rootPane, "Slot is Empty! Please choose another product");
                    return;
                }
                
                String productName = name.getText();

                // Load product but do NOT automatically select it
                cFrame.loadProduct2(productName);

                // Uncheck the checkbox initially
                cFrame.checkBoxSlot2.setSelected(false);

                JOptionPane.showMessageDialog(rootPane,
                        "Product added to cart! Please check the box to include it in checkout.");
            }
        });
    }

    public static boolean registerLabelClicked = false;

    private void setup(DashboardFrame frame) {

        gotoRegisterImage.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                registerLabelClicked = true;
                System.out.println("REGISTER LABEL CLICKED");
            }
        });
    }

    private void clickCartNotLoggedIn(JLabel label) {

        label.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                JOptionPane.showMessageDialog(rootPane, "Please log in first");
            }
        });
    }

    public static void switchPanel(DashboardFrame frame, JPanel panelToShow) {
        frame.hideAllPanels();
        panelToShow.setVisible(true);
        panelToShow.revalidate();
        panelToShow.repaint();
        System.out.println("DEBUGGER: Showing panel " + panelToShow.getName());
    }

    public static void showPanel(JLabel label, JPanel panelToShow, DashboardFrame frame) {
        // Remove old listeners
        for (MouseListener listener : label.getMouseListeners()) {
            label.removeMouseListener(listener);
        }

        label.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                switchPanel(frame, panelToShow);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(new Color(101, 13, 2));
            }
        });
    }

    public static void showPanel(JLabel label, JPanel panelToShow) {
        label.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                panelToShow.setVisible(true);
                accountPanel.setVisible(false);
            }
        });
    }

    public static void addProductToCategory(int category, ImageIcon image, String name, String price) {
        JLabel[][] allCategorySlots = {
            category1Slots, category2Slots, category3Slots, category4Slots, category5Slots,
            category6Slots, category7Slots, category8Slots, category9Slots, category10Slots, category11Slots
        };

        JLabel[][] allCategoryLabels = {
            category1Labels, category2Labels, category3Labels, category4Labels, category5Labels,
            category6Labels, category7Labels, category8Labels, category9Labels, category10Labels, category11Labels
        };

        JLabel[][] allCategoryPrice = {
            category1Price, category2Price, category3Price, category4Price, category5Price,
            category6Price, category7Price, category8Price, category9Price, category10Price, category11Price
        };

        JLabel[][] allCategoryStock = {
            category1Stock, category2Stock, category3Stock, category4Stock, category5Stock,
            category6Stock, category7Stock, category8Stock, category9Stock, category10Stock, category11Stock
        };

        if (category < 1 || category > allCategorySlots.length) {
            JOptionPane.showMessageDialog(null, "Invalid category number!");
            return;
        }

        JLabel[] imageSlots = allCategorySlots[category - 1];
        JLabel[] textSlots = allCategoryLabels[category - 1];
        JLabel[] priceSlots = allCategoryPrice[category - 1];
        JLabel[] stockSlots = allCategoryStock[category - 1];

        int index = categoryCounters[category - 1];

        if (index >= imageSlots.length) {
            JOptionPane.showMessageDialog(null, "All slots for this category are full!");
            return;
        }

        JLabel imageLabel = imageSlots[index];
        imageLabel.setIcon(image);

        JLabel textLabel = textSlots[index];
        textLabel.setText(name);
        textLabel.setHorizontalAlignment(SwingConstants.LEFT);
        textLabel.setFont(new Font("Segoe", Font.BOLD, 14));
        textLabel.setForeground(new Color(111, 65, 44));

        JLabel priceLabel = priceSlots[index];
        priceLabel.setText("P" + price);
        priceLabel.setHorizontalAlignment(SwingConstants.LEFT);
        priceLabel.setFont(new Font("Segoe", Font.BOLD, 12));
        priceLabel.setForeground(new Color(207, 127, 52));

        JLabel stockLabel = stockSlots[index];
        stockLabel.setText("On stock");
        stockLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        stockLabel.setFont(new Font("Segoe", Font.PLAIN, 10));
        stockLabel.setForeground(Color.GRAY);

        categoryCounters[category - 1]++;
    }

    private void defaultLeft(JButton btn) {
        btn.setBorder(BorderFactory.createCompoundBorder(null, BorderFactory.createEmptyBorder(0, 20, 0, 0)));
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

    public void hideAllPanels() {
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
        cartPanel.setVisible(false);
        accountPanel.setVisible(false);
        paymentOptionsPanel.setVisible(false);
        privacyPolicyPanel.setVisible(false);
        faqsPanel.setVisible(false);
        aboutUsPanel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        gotoLoginImage = new javax.swing.JLabel();
        gotoLoginButton = new javax.swing.JLabel();
        gotoRegisterImage = new javax.swing.JLabel();
        gotoRegisterButton = new javax.swing.JLabel();
        myCartImage = new javax.swing.JLabel();
        myCartButton = new javax.swing.JLabel();
        gotoLandingPanelLogo = new javax.swing.JLabel();
        sidebarPanel = new javax.swing.JPanel();
        bakeryButton = new javax.swing.JButton();
        butcheryButton = new javax.swing.JButton();
        seafoodsButton = new javax.swing.JButton();
        readyMealsButton = new javax.swing.JButton();
        vegetableButton = new javax.swing.JButton();
        fruitsButton = new javax.swing.JButton();
        snacksButton = new javax.swing.JButton();
        iceCreamButton = new javax.swing.JButton();
        beveragesButton = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        landingPanel = new javax.swing.JPanel();
        shopNowButton = new javax.swing.JLabel();
        bakeryLandingIcon = new javax.swing.JLabel();
        butcheryLandingIcon = new javax.swing.JLabel();
        seafoodsLandingIcon = new javax.swing.JLabel();
        readyMealsLandingIcon = new javax.swing.JLabel();
        vegetablesLandingIcon = new javax.swing.JLabel();
        fruitsLandingIcon = new javax.swing.JLabel();
        snakcsLandingIcon = new javax.swing.JLabel();
        dessertsLandingIcon = new javax.swing.JLabel();
        newProductsLandingIcon = new javax.swing.JLabel();
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
        newProductsLabel4 = new javax.swing.JLabel();
        newProductsPrice4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        newProductsAddToCart4 = new javax.swing.JLabel();
        newProductsStockLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        newProductsLabel8 = new javax.swing.JLabel();
        newProductsPrice8 = new javax.swing.JLabel();
        newProductsAddToCart8 = new javax.swing.JLabel();
        newProductsStockLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        newProductsLabel2 = new javax.swing.JLabel();
        newProductsPrice2 = new javax.swing.JLabel();
        newProductsAddToCart2 = new javax.swing.JLabel();
        newProductsStockLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        newProductsLabel3 = new javax.swing.JLabel();
        newProductsPrice3 = new javax.swing.JLabel();
        newProductsAddToCart3 = new javax.swing.JLabel();
        newProductsStockLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        newProductsLabel1 = new javax.swing.JLabel();
        newProductsPrice1 = new javax.swing.JLabel();
        newProductsStockLabel1 = new javax.swing.JLabel();
        newProductsAddToCart1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        newProductsLabel5 = new javax.swing.JLabel();
        newProductsPrice5 = new javax.swing.JLabel();
        newProductsAddToCart5 = new javax.swing.JLabel();
        newProductsStockLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        newProductsLabel6 = new javax.swing.JLabel();
        newProductsPrice6 = new javax.swing.JLabel();
        newProductsAddToCart6 = new javax.swing.JLabel();
        newProductsStockLabel6 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        newProductsLabel7 = new javax.swing.JLabel();
        newProductsPrice7 = new javax.swing.JLabel();
        newProductsAddToCart7 = new javax.swing.JLabel();
        newProductsStockLabel7 = new javax.swing.JLabel();
        bakeryPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        bakeryLabel1 = new javax.swing.JLabel();
        bakeryPrice1 = new javax.swing.JLabel();
        bakeryStock1 = new javax.swing.JLabel();
        bakeryAddToCart1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        bakeryStock2 = new javax.swing.JLabel();
        bakeryPrice2 = new javax.swing.JLabel();
        bakeryLabel2 = new javax.swing.JLabel();
        bakeryAddToCart2 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        bakeryStock3 = new javax.swing.JLabel();
        bakeryPrice3 = new javax.swing.JLabel();
        bakeryLabel3 = new javax.swing.JLabel();
        bakeryAddToCart3 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        bakeryStock4 = new javax.swing.JLabel();
        bakeryPrice4 = new javax.swing.JLabel();
        bakeryLabel4 = new javax.swing.JLabel();
        bakeryAddToCart4 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        bakeryStock5 = new javax.swing.JLabel();
        bakeryPrice5 = new javax.swing.JLabel();
        bakeryLabel5 = new javax.swing.JLabel();
        bakeryAddToCart5 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        bakeryStock6 = new javax.swing.JLabel();
        bakeryPrice6 = new javax.swing.JLabel();
        bakeryLabel6 = new javax.swing.JLabel();
        bakeryAddToCart6 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        bakeryStock7 = new javax.swing.JLabel();
        bakeryPrice7 = new javax.swing.JLabel();
        bakeryLabel7 = new javax.swing.JLabel();
        bakeryAddToCart7 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        bakeryStock8 = new javax.swing.JLabel();
        bakeryPrice8 = new javax.swing.JLabel();
        bakeryLabel8 = new javax.swing.JLabel();
        bakeryAddToCart8 = new javax.swing.JLabel();
        bakerySlot1 = new javax.swing.JLabel();
        bakerySlot2 = new javax.swing.JLabel();
        bakerySlot3 = new javax.swing.JLabel();
        bakerySlot4 = new javax.swing.JLabel();
        bakerySlot5 = new javax.swing.JLabel();
        bakerySlot6 = new javax.swing.JLabel();
        bakerySlot7 = new javax.swing.JLabel();
        bakerySlot8 = new javax.swing.JLabel();
        butcheryPanel = new javax.swing.JPanel();
        butcherySlot2 = new javax.swing.JLabel();
        butcherySlot3 = new javax.swing.JLabel();
        butcherySlot4 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        butcherySlot1 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        butcheryLabel1 = new javax.swing.JLabel();
        butcheryStock1 = new javax.swing.JLabel();
        butcheryAddToCart1 = new javax.swing.JLabel();
        butcheryPrice1 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        butcheryStock2 = new javax.swing.JLabel();
        butcheryLabel2 = new javax.swing.JLabel();
        butcheryPrice2 = new javax.swing.JLabel();
        butcheryAddToCart2 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        butcheryStock3 = new javax.swing.JLabel();
        butcheryLabel3 = new javax.swing.JLabel();
        butcheryPrice3 = new javax.swing.JLabel();
        butcheryAddToCart3 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        butcheryStock4 = new javax.swing.JLabel();
        butcheryLabel4 = new javax.swing.JLabel();
        butcheryPrice4 = new javax.swing.JLabel();
        butcheryAddToCart4 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        butcheryStock5 = new javax.swing.JLabel();
        butcheryLabel5 = new javax.swing.JLabel();
        butcheryPrice5 = new javax.swing.JLabel();
        butcheryAddToCart5 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        butcheryStock6 = new javax.swing.JLabel();
        butcheryLabel6 = new javax.swing.JLabel();
        butcheryPrice6 = new javax.swing.JLabel();
        butcheryAddToCart6 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        butcheryStock7 = new javax.swing.JLabel();
        butcheryLabel7 = new javax.swing.JLabel();
        butcheryPrice7 = new javax.swing.JLabel();
        butcheryAddToCart7 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        butcheryStock8 = new javax.swing.JLabel();
        butcheryLabel8 = new javax.swing.JLabel();
        butcheryPrice8 = new javax.swing.JLabel();
        butcheryAddToCart8 = new javax.swing.JLabel();
        butcherySlot5 = new javax.swing.JLabel();
        butcherySlot6 = new javax.swing.JLabel();
        butcherySlot7 = new javax.swing.JLabel();
        butcherySlot8 = new javax.swing.JLabel();
        readyMealsPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        readyMealsStock1 = new javax.swing.JLabel();
        readyMealsLabel1 = new javax.swing.JLabel();
        readyMealsPrice1 = new javax.swing.JLabel();
        readyMealsAddToCart1 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        readyMealsLabel2 = new javax.swing.JLabel();
        readyMealsPrice2 = new javax.swing.JLabel();
        readyMealsStock2 = new javax.swing.JLabel();
        readyMealsAddToCart2 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        readyMealsLabel3 = new javax.swing.JLabel();
        readyMealsPrice3 = new javax.swing.JLabel();
        readyMealsStock3 = new javax.swing.JLabel();
        readyMealsAddToCart3 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        readyMealsLabel4 = new javax.swing.JLabel();
        readyMealsPrice4 = new javax.swing.JLabel();
        readyMealsStock4 = new javax.swing.JLabel();
        readyMealsAddToCart4 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        readyMealsLabel8 = new javax.swing.JLabel();
        readyMealsPrice8 = new javax.swing.JLabel();
        readyMealsStock8 = new javax.swing.JLabel();
        readyMealsAddToCart8 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        readyMealsLabel7 = new javax.swing.JLabel();
        readyMealsPrice7 = new javax.swing.JLabel();
        readyMealsStock7 = new javax.swing.JLabel();
        readyMealsAddToCart7 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        readyMealsLabel6 = new javax.swing.JLabel();
        readyMealsPrice6 = new javax.swing.JLabel();
        readyMealsStock6 = new javax.swing.JLabel();
        readyMealsAddToCart6 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        readyMealsLabel5 = new javax.swing.JLabel();
        readyMealsPrice5 = new javax.swing.JLabel();
        readyMealsStock5 = new javax.swing.JLabel();
        readyMealsAddToCart5 = new javax.swing.JLabel();
        readyMealsSlot1 = new javax.swing.JLabel();
        readyMealsSlot2 = new javax.swing.JLabel();
        readyMealsSlot3 = new javax.swing.JLabel();
        readyMealsSlot4 = new javax.swing.JLabel();
        readyMealsSlot5 = new javax.swing.JLabel();
        readyMealsSlot6 = new javax.swing.JLabel();
        readyMealsSlot7 = new javax.swing.JLabel();
        readyMealsSlot8 = new javax.swing.JLabel();
        vegetablesPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        vegetablesLabel1 = new javax.swing.JLabel();
        vegetablesPrice1 = new javax.swing.JLabel();
        vegetablesStock1 = new javax.swing.JLabel();
        vegetablesAddToCart1 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        vegetablesLabel2 = new javax.swing.JLabel();
        vegetablesPrice2 = new javax.swing.JLabel();
        vegetablesStock2 = new javax.swing.JLabel();
        vegetablesAddToCart2 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        vegetablesLabel3 = new javax.swing.JLabel();
        vegetablesPrice3 = new javax.swing.JLabel();
        vegetablesStock3 = new javax.swing.JLabel();
        vegetablesAddToCart3 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        vegetablesLabel4 = new javax.swing.JLabel();
        vegetablesPrice4 = new javax.swing.JLabel();
        vegetablesStock4 = new javax.swing.JLabel();
        vegetablesAddToCart4 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        vegetablesLabel8 = new javax.swing.JLabel();
        vegetablesPrice8 = new javax.swing.JLabel();
        vegetablesStock8 = new javax.swing.JLabel();
        vegetablesAddToCart8 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        vegetablesLabel7 = new javax.swing.JLabel();
        vegetablesPrice7 = new javax.swing.JLabel();
        vegetablesStock7 = new javax.swing.JLabel();
        vegetablesAddToCart7 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        vegetablesLabel6 = new javax.swing.JLabel();
        vegetablesPrice6 = new javax.swing.JLabel();
        vegetablesStock6 = new javax.swing.JLabel();
        vegetablesAddToCart6 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        vegetablesLabel5 = new javax.swing.JLabel();
        vegetablesPrice5 = new javax.swing.JLabel();
        vegetablesStock5 = new javax.swing.JLabel();
        vegetablesAddToCart5 = new javax.swing.JLabel();
        vegetablesSlot1 = new javax.swing.JLabel();
        vegetablesSlot2 = new javax.swing.JLabel();
        vegetablesSlot3 = new javax.swing.JLabel();
        vegetablesSlot4 = new javax.swing.JLabel();
        vegetablesSlot5 = new javax.swing.JLabel();
        vegetablesSlot6 = new javax.swing.JLabel();
        vegetablesSlot7 = new javax.swing.JLabel();
        vegetablesSlot8 = new javax.swing.JLabel();
        fruitsPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        fruitsPrice1 = new javax.swing.JLabel();
        fruitsStock1 = new javax.swing.JLabel();
        fruitsLabel1 = new javax.swing.JLabel();
        fruitsAddToCart1 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        fruitsLabel2 = new javax.swing.JLabel();
        fruitsPrice2 = new javax.swing.JLabel();
        fruitsStock2 = new javax.swing.JLabel();
        fruitsAddToCart2 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        fruitsLabel3 = new javax.swing.JLabel();
        fruitsPrice3 = new javax.swing.JLabel();
        fruitsStock3 = new javax.swing.JLabel();
        fruitsAddToCart3 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        fruitsLabel4 = new javax.swing.JLabel();
        fruitsPrice4 = new javax.swing.JLabel();
        fruitsStock4 = new javax.swing.JLabel();
        fruitsAddToCart4 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        fruitsLabel8 = new javax.swing.JLabel();
        fruitsPrice8 = new javax.swing.JLabel();
        fruitsStock8 = new javax.swing.JLabel();
        fruitsAddToCart8 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        fruitsLabel7 = new javax.swing.JLabel();
        fruitsPrice7 = new javax.swing.JLabel();
        fruitsStock7 = new javax.swing.JLabel();
        fruitsAddToCart7 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        fruitsLabel6 = new javax.swing.JLabel();
        fruitsPrice6 = new javax.swing.JLabel();
        fruitsStock6 = new javax.swing.JLabel();
        fruitsAddToCart6 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        fruitsLabel5 = new javax.swing.JLabel();
        fruitsPrice5 = new javax.swing.JLabel();
        fruitsStock5 = new javax.swing.JLabel();
        fruitsAddToCart5 = new javax.swing.JLabel();
        fruitsSlot1 = new javax.swing.JLabel();
        vegetablesSlot13 = new javax.swing.JLabel();
        fruitsSlot2 = new javax.swing.JLabel();
        fruitsSlot3 = new javax.swing.JLabel();
        fruitsSlot4 = new javax.swing.JLabel();
        fruitsSlot5 = new javax.swing.JLabel();
        fruitsSlot6 = new javax.swing.JLabel();
        fruitsSlot7 = new javax.swing.JLabel();
        fruitsSlot8 = new javax.swing.JLabel();
        groceryPanel = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        newProductsAddToCart57 = new javax.swing.JLabel();
        groceryLabel1 = new javax.swing.JLabel();
        groceryPrice1 = new javax.swing.JLabel();
        groceryStock1 = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        newProductsAddToCart58 = new javax.swing.JLabel();
        groceryLabel2 = new javax.swing.JLabel();
        groceryPrice2 = new javax.swing.JLabel();
        groceryStock2 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        newProductsAddToCart59 = new javax.swing.JLabel();
        vegetablesStock11 = new javax.swing.JLabel();
        groceryLabel3 = new javax.swing.JLabel();
        groceryPrice3 = new javax.swing.JLabel();
        groceryStock3 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        newProductsAddToCart60 = new javax.swing.JLabel();
        vegetablesStock12 = new javax.swing.JLabel();
        groceryLabel4 = new javax.swing.JLabel();
        groceryPrice4 = new javax.swing.JLabel();
        groceryStock4 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        newProductsAddToCart61 = new javax.swing.JLabel();
        vegetablesStock13 = new javax.swing.JLabel();
        groceryLabel8 = new javax.swing.JLabel();
        groceryPrice8 = new javax.swing.JLabel();
        groceryStock8 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        newProductsAddToCart62 = new javax.swing.JLabel();
        vegetablesStock14 = new javax.swing.JLabel();
        groceryLabel7 = new javax.swing.JLabel();
        groceryPrice7 = new javax.swing.JLabel();
        groceryStock7 = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        newProductsAddToCart63 = new javax.swing.JLabel();
        vegetablesStock15 = new javax.swing.JLabel();
        groceryLabel6 = new javax.swing.JLabel();
        groceryPrice6 = new javax.swing.JLabel();
        groceryStock6 = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        newProductsAddToCart64 = new javax.swing.JLabel();
        vegetablesStock16 = new javax.swing.JLabel();
        groceryLabel5 = new javax.swing.JLabel();
        groceryPrice5 = new javax.swing.JLabel();
        groceryStock5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        grocerySlot1 = new javax.swing.JLabel();
        grocerySlot2 = new javax.swing.JLabel();
        grocerySlot3 = new javax.swing.JLabel();
        grocerySlot4 = new javax.swing.JLabel();
        grocerySlot5 = new javax.swing.JLabel();
        grocerySlot6 = new javax.swing.JLabel();
        grocerySlot7 = new javax.swing.JLabel();
        grocerySlot8 = new javax.swing.JLabel();
        snacksPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel84 = new javax.swing.JPanel();
        snacksPrice1 = new javax.swing.JLabel();
        snacksLabel1 = new javax.swing.JLabel();
        snacksStock1 = new javax.swing.JLabel();
        snacksAddToCart1 = new javax.swing.JLabel();
        jPanel85 = new javax.swing.JPanel();
        snacksLabel2 = new javax.swing.JLabel();
        snacksPrice2 = new javax.swing.JLabel();
        snacksStock2 = new javax.swing.JLabel();
        snacksAddToCart2 = new javax.swing.JLabel();
        jPanel86 = new javax.swing.JPanel();
        snacksLabel3 = new javax.swing.JLabel();
        snacksPrice3 = new javax.swing.JLabel();
        snacksStock3 = new javax.swing.JLabel();
        snacksAddToCart3 = new javax.swing.JLabel();
        jPanel87 = new javax.swing.JPanel();
        snacksLabel4 = new javax.swing.JLabel();
        snacksPrice4 = new javax.swing.JLabel();
        snacksStock4 = new javax.swing.JLabel();
        snacksAddToCart4 = new javax.swing.JLabel();
        jPanel88 = new javax.swing.JPanel();
        snacksLabel8 = new javax.swing.JLabel();
        snacksPrice8 = new javax.swing.JLabel();
        snacksStock8 = new javax.swing.JLabel();
        snacksAddToCart8 = new javax.swing.JLabel();
        jPanel89 = new javax.swing.JPanel();
        snacksLabel7 = new javax.swing.JLabel();
        snacksPrice7 = new javax.swing.JLabel();
        snacksStock7 = new javax.swing.JLabel();
        snacksAddToCart7 = new javax.swing.JLabel();
        jPanel90 = new javax.swing.JPanel();
        snacksLabel6 = new javax.swing.JLabel();
        snacksPrice6 = new javax.swing.JLabel();
        snacksStock6 = new javax.swing.JLabel();
        snacksAddToCart6 = new javax.swing.JLabel();
        jPanel91 = new javax.swing.JPanel();
        snacksLabel5 = new javax.swing.JLabel();
        snacksPrice5 = new javax.swing.JLabel();
        snacksStock5 = new javax.swing.JLabel();
        snacksAddToCart5 = new javax.swing.JLabel();
        snacksSlot1 = new javax.swing.JLabel();
        snacksSlot2 = new javax.swing.JLabel();
        snacksSlot3 = new javax.swing.JLabel();
        snacksSlot4 = new javax.swing.JLabel();
        snacksSlot5 = new javax.swing.JLabel();
        snacksSlot6 = new javax.swing.JLabel();
        snacksSlot7 = new javax.swing.JLabel();
        snacksSlot8 = new javax.swing.JLabel();
        dessertsPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel68 = new javax.swing.JPanel();
        dessertsLabel1 = new javax.swing.JLabel();
        dessertsPrice1 = new javax.swing.JLabel();
        dessertsStock1 = new javax.swing.JLabel();
        dessertsAddToCart1 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        dessertsLabel2 = new javax.swing.JLabel();
        dessertsPrice2 = new javax.swing.JLabel();
        dessertsStock2 = new javax.swing.JLabel();
        dessertsAddToCart2 = new javax.swing.JLabel();
        jPanel70 = new javax.swing.JPanel();
        groceryStock11 = new javax.swing.JLabel();
        dessertsLabel3 = new javax.swing.JLabel();
        dessertsPrice3 = new javax.swing.JLabel();
        dessertsStock3 = new javax.swing.JLabel();
        dessertsAddToCart3 = new javax.swing.JLabel();
        jPanel71 = new javax.swing.JPanel();
        groceryStock12 = new javax.swing.JLabel();
        dessertsLabel4 = new javax.swing.JLabel();
        dessertsPrice4 = new javax.swing.JLabel();
        dessertsStock4 = new javax.swing.JLabel();
        dessertsAddToCart4 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        groceryStock13 = new javax.swing.JLabel();
        dessertsLabel8 = new javax.swing.JLabel();
        dessertsPrice8 = new javax.swing.JLabel();
        dessertsStock8 = new javax.swing.JLabel();
        dessertsAddToCart8 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        groceryStock14 = new javax.swing.JLabel();
        dessertsLabel7 = new javax.swing.JLabel();
        dessertsPrice7 = new javax.swing.JLabel();
        dessertsStock7 = new javax.swing.JLabel();
        dessertsAddToCart7 = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        groceryStock15 = new javax.swing.JLabel();
        dessertsLabel6 = new javax.swing.JLabel();
        dessertsPrice6 = new javax.swing.JLabel();
        dessertsStock6 = new javax.swing.JLabel();
        dessertsAddToCart6 = new javax.swing.JLabel();
        jPanel75 = new javax.swing.JPanel();
        groceryStock16 = new javax.swing.JLabel();
        dessertsLabel5 = new javax.swing.JLabel();
        dessertsPrice5 = new javax.swing.JLabel();
        dessertsStock5 = new javax.swing.JLabel();
        dessertsAddToCart5 = new javax.swing.JLabel();
        dessertsSlot1 = new javax.swing.JLabel();
        dessertsSlot2 = new javax.swing.JLabel();
        dessertsSlot3 = new javax.swing.JLabel();
        dessertsSlot4 = new javax.swing.JLabel();
        dessertsSlot5 = new javax.swing.JLabel();
        dessertsSlot6 = new javax.swing.JLabel();
        dessertsSlot7 = new javax.swing.JLabel();
        dessertsSlot8 = new javax.swing.JLabel();
        winesPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel76 = new javax.swing.JPanel();
        winesLabel1 = new javax.swing.JLabel();
        winesPrice1 = new javax.swing.JLabel();
        winesStock1 = new javax.swing.JLabel();
        winesAddToCart1 = new javax.swing.JLabel();
        jPanel77 = new javax.swing.JPanel();
        winesLabel2 = new javax.swing.JLabel();
        winesPrice2 = new javax.swing.JLabel();
        winesStock2 = new javax.swing.JLabel();
        winesAddToCart2 = new javax.swing.JLabel();
        jPanel78 = new javax.swing.JPanel();
        winesLabel3 = new javax.swing.JLabel();
        winesPrice3 = new javax.swing.JLabel();
        winesStock3 = new javax.swing.JLabel();
        winesAddToCart3 = new javax.swing.JLabel();
        jPanel79 = new javax.swing.JPanel();
        winesLabel4 = new javax.swing.JLabel();
        winesPrice4 = new javax.swing.JLabel();
        winesStock4 = new javax.swing.JLabel();
        winesAddToCart4 = new javax.swing.JLabel();
        jPanel80 = new javax.swing.JPanel();
        winesLabel8 = new javax.swing.JLabel();
        winesPrice8 = new javax.swing.JLabel();
        winesStock8 = new javax.swing.JLabel();
        winesAddToCart8 = new javax.swing.JLabel();
        jPanel81 = new javax.swing.JPanel();
        winesLabel7 = new javax.swing.JLabel();
        winesPrice7 = new javax.swing.JLabel();
        winesStock7 = new javax.swing.JLabel();
        winesAddToCart7 = new javax.swing.JLabel();
        jPanel82 = new javax.swing.JPanel();
        winesLabel6 = new javax.swing.JLabel();
        winesPrice6 = new javax.swing.JLabel();
        winesStock6 = new javax.swing.JLabel();
        winesAddToCart6 = new javax.swing.JLabel();
        jPanel83 = new javax.swing.JPanel();
        winesLabel5 = new javax.swing.JLabel();
        winesPrice5 = new javax.swing.JLabel();
        winesStock5 = new javax.swing.JLabel();
        winesAddToCart5 = new javax.swing.JLabel();
        winesSlot1 = new javax.swing.JLabel();
        winesSlot2 = new javax.swing.JLabel();
        winesSlot3 = new javax.swing.JLabel();
        winesSlot4 = new javax.swing.JLabel();
        winesSlot5 = new javax.swing.JLabel();
        winesSlot6 = new javax.swing.JLabel();
        winesSlot7 = new javax.swing.JLabel();
        winesSlot8 = new javax.swing.JLabel();
        seaFoodsPanel = new javax.swing.JPanel();
        seafoodsTitle = new javax.swing.JLabel();
        seafoodsSlot1 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        seafoodsLabel1 = new javax.swing.JLabel();
        seafoodsPrice1 = new javax.swing.JLabel();
        seafoodsStock1 = new javax.swing.JLabel();
        seafoodsAddToCart1 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        seafoodsLabel2 = new javax.swing.JLabel();
        seafoodsPrice2 = new javax.swing.JLabel();
        seafoodsStock2 = new javax.swing.JLabel();
        seafoodsAddToCart2 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        butcheryStock10 = new javax.swing.JLabel();
        seafoodsLabel3 = new javax.swing.JLabel();
        seafoodsPrice3 = new javax.swing.JLabel();
        seafoodsStock3 = new javax.swing.JLabel();
        seafoodsAddToCart3 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        butcheryStock11 = new javax.swing.JLabel();
        seafoodsLabel4 = new javax.swing.JLabel();
        seafoodsPrice4 = new javax.swing.JLabel();
        seafoodsStock4 = new javax.swing.JLabel();
        seafoodsAddToCart4 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        butcheryStock12 = new javax.swing.JLabel();
        seafoodsLabel8 = new javax.swing.JLabel();
        seafoodsPrice8 = new javax.swing.JLabel();
        seafoodsStock8 = new javax.swing.JLabel();
        seafoodsAddToCart8 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        bakeryStock9 = new javax.swing.JLabel();
        seafoodsLabel7 = new javax.swing.JLabel();
        seafoodsPrice7 = new javax.swing.JLabel();
        seafoodsStock7 = new javax.swing.JLabel();
        seafoodsAddToCart7 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        butcheryStock13 = new javax.swing.JLabel();
        seafoodsLabel6 = new javax.swing.JLabel();
        seafoodsPrice6 = new javax.swing.JLabel();
        seafoodsStock6 = new javax.swing.JLabel();
        seafoodsAddToCart6 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        butcheryStock14 = new javax.swing.JLabel();
        seafoodsLabel5 = new javax.swing.JLabel();
        seafoodsPrice5 = new javax.swing.JLabel();
        seafoodsStock5 = new javax.swing.JLabel();
        seafoodsAddToCart5 = new javax.swing.JLabel();
        seafoodsSlot2 = new javax.swing.JLabel();
        seafoodsSlot3 = new javax.swing.JLabel();
        seafoodsSlot4 = new javax.swing.JLabel();
        seafoodsSlot5 = new javax.swing.JLabel();
        seafoodsSlot6 = new javax.swing.JLabel();
        seafoodsSlot7 = new javax.swing.JLabel();
        seafoodsSlot8 = new javax.swing.JLabel();
        cartPanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        paymentOptionsPanel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        privacyPolicyPanel = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        faqsPanel = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        aboutUsPanel = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        accountPanel = new javax.swing.JPanel();
        accountContainerPanel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        maleGenderButton = new javax.swing.JRadioButton();
        otherGenderButton = new javax.swing.JRadioButton();
        jLabel27 = new javax.swing.JLabel();
        femaleGenderButton = new javax.swing.JRadioButton();
        selectImageButton = new javax.swing.JButton();
        fullNameHolder = new javax.swing.JTextField();
        emailHolder = new javax.swing.JTextField();
        logoutButton = new javax.swing.JButton();
        imageProfileHolder = new javax.swing.JLabel();
        addAddressLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        yearChooser = new javax.swing.JComboBox<>();
        dateChooser = new javax.swing.JComboBox<>();
        monthChooser = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        addressReader = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        phoneNumberHolder = new javax.swing.JTextField();
        jPanel92 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        paymentOptionsLabel = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        aboutUsLabel = new javax.swing.JLabel();
        FAQsLabel = new javax.swing.JLabel();
        privacyPolicyLabel = new javax.swing.JLabel();

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

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(243, 243, 243));

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

        jPanel6.setBackground(new java.awt.Color(251, 239, 215));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gotoLoginImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/login icon - test.png"))); // NOI18N
        gotoLoginImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gotoLoginImageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gotoLoginImageMouseExited(evt);
            }
        });
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
        gotoRegisterImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gotoRegisterImageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gotoRegisterImageMouseExited(evt);
            }
        });
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
        myCartImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        myCartImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                myCartImageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                myCartImageMouseExited(evt);
            }
        });
        jPanel6.add(myCartImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 30, -1, 37));

        myCartButton.setBackground(new java.awt.Color(25, 145, 77));
        myCartButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        myCartButton.setForeground(new java.awt.Color(153, 153, 153));
        myCartButton.setText("MY CART");
        jPanel6.add(myCartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 70, -1, -1));

        gotoLandingPanelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/dashboard logo.png"))); // NOI18N
        jPanel6.add(gotoLandingPanelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 70));

        sidebarPanel.setBackground(new java.awt.Color(255, 255, 254));

        bakeryButton.setBackground(new java.awt.Color(255, 255, 254));
        bakeryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bakery icon.png"))); // NOI18N
        bakeryButton.setText("Bakery");
        bakeryButton.setBorder(null);
        bakeryButton.setFocusable(false);
        bakeryButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        bakeryButton.setIconTextGap(14);
        bakeryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bakeryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bakeryButtonMouseExited(evt);
            }
        });
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
        butcheryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butcheryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butcheryButtonMouseExited(evt);
            }
        });
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
        seafoodsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                seafoodsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                seafoodsButtonMouseExited(evt);
            }
        });
        seafoodsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seafoodsButtonActionPerformed(evt);
            }
        });

        readyMealsButton.setBackground(new java.awt.Color(255, 255, 254));
        readyMealsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ready meals icon.png"))); // NOI18N
        readyMealsButton.setText("Ready Meals");
        readyMealsButton.setBorder(null);
        readyMealsButton.setFocusable(false);
        readyMealsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsButton.setIconTextGap(14);
        readyMealsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                readyMealsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                readyMealsButtonMouseExited(evt);
            }
        });
        readyMealsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readyMealsButtonActionPerformed(evt);
            }
        });

        vegetableButton.setBackground(new java.awt.Color(255, 255, 254));
        vegetableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vegetables icon.png"))); // NOI18N
        vegetableButton.setText("Vegetables");
        vegetableButton.setBorder(null);
        vegetableButton.setFocusable(false);
        vegetableButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetableButton.setIconTextGap(14);
        vegetableButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vegetableButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vegetableButtonMouseExited(evt);
            }
        });
        vegetableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vegetableButtonActionPerformed(evt);
            }
        });

        fruitsButton.setBackground(new java.awt.Color(255, 255, 254));
        fruitsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fruits icon.png"))); // NOI18N
        fruitsButton.setText("Fruits");
        fruitsButton.setBorder(null);
        fruitsButton.setFocusable(false);
        fruitsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsButton.setIconTextGap(14);
        fruitsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fruitsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fruitsButtonMouseExited(evt);
            }
        });
        fruitsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fruitsButtonActionPerformed(evt);
            }
        });

        snacksButton.setBackground(new java.awt.Color(255, 255, 254));
        snacksButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/snacks icon.png"))); // NOI18N
        snacksButton.setText("Snacks");
        snacksButton.setBorder(null);
        snacksButton.setFocusable(false);
        snacksButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksButton.setIconTextGap(14);
        snacksButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                snacksButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                snacksButtonMouseExited(evt);
            }
        });
        snacksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snacksButtonActionPerformed(evt);
            }
        });

        iceCreamButton.setBackground(new java.awt.Color(255, 255, 254));
        iceCreamButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/desserts icon.png"))); // NOI18N
        iceCreamButton.setText("Ice Cream");
        iceCreamButton.setBorder(null);
        iceCreamButton.setFocusable(false);
        iceCreamButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        iceCreamButton.setIconTextGap(14);
        iceCreamButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iceCreamButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                iceCreamButtonMouseExited(evt);
            }
        });
        iceCreamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iceCreamButtonActionPerformed(evt);
            }
        });

        beveragesButton.setBackground(new java.awt.Color(255, 255, 254));
        beveragesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/wine icon.png"))); // NOI18N
        beveragesButton.setText("Beverages");
        beveragesButton.setBorder(null);
        beveragesButton.setFocusable(false);
        beveragesButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        beveragesButton.setIconTextGap(14);
        beveragesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                beveragesButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                beveragesButtonMouseExited(evt);
            }
        });
        beveragesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beveragesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
        sidebarPanel.setLayout(sidebarPanelLayout);
        sidebarPanelLayout.setHorizontalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seafoodsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(readyMealsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(butcheryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bakeryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vegetableButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fruitsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(snacksButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iceCreamButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(beveragesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sidebarPanelLayout.setVerticalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(beveragesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bakeryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butcheryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seafoodsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(readyMealsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vegetableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fruitsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(snacksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iceCreamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.setBackground(new java.awt.Color(102, 102, 255));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        landingPanel.setBackground(new java.awt.Color(243, 243, 243));
        landingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        shopNowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shop now icon.png"))); // NOI18N
        shopNowButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                shopNowButtonMouseEntered(evt);
            }
        });
        landingPanel.add(shopNowButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        bakeryLandingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bakery landing icon.png"))); // NOI18N
        bakeryLandingIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bakeryLandingIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bakeryLandingIconMouseClicked(evt);
            }
        });
        landingPanel.add(bakeryLandingIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        butcheryLandingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/butchery landing icon.png"))); // NOI18N
        butcheryLandingIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butcheryLandingIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butcheryLandingIconMouseClicked(evt);
            }
        });
        landingPanel.add(butcheryLandingIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, -1, 110));

        seafoodsLandingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seafoods landing icon.png"))); // NOI18N
        seafoodsLandingIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seafoodsLandingIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seafoodsLandingIconMouseClicked(evt);
            }
        });
        landingPanel.add(seafoodsLandingIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, -1, 110));

        readyMealsLandingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ready meals landing icon.png"))); // NOI18N
        readyMealsLandingIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        readyMealsLandingIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                readyMealsLandingIconMouseClicked(evt);
            }
        });
        landingPanel.add(readyMealsLandingIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, -1, -1));

        vegetablesLandingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vegetables landing icon.png"))); // NOI18N
        vegetablesLandingIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vegetablesLandingIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vegetablesLandingIconMouseClicked(evt);
            }
        });
        landingPanel.add(vegetablesLandingIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, -1, -1));

        fruitsLandingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fruits landing icon.png"))); // NOI18N
        fruitsLandingIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fruitsLandingIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fruitsLandingIconMouseClicked(evt);
            }
        });
        landingPanel.add(fruitsLandingIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, -1, -1));

        snakcsLandingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/snacks landing icon.png"))); // NOI18N
        snakcsLandingIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        snakcsLandingIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                snakcsLandingIconMouseClicked(evt);
            }
        });
        landingPanel.add(snakcsLandingIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 430, -1, -1));

        dessertsLandingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/desserts landing icon.png"))); // NOI18N
        dessertsLandingIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dessertsLandingIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dessertsLandingIconMouseClicked(evt);
            }
        });
        landingPanel.add(dessertsLandingIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 430, -1, -1));

        newProductsLandingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new products landing icon.png"))); // NOI18N
        newProductsLandingIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newProductsLandingIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newProductsLandingIconMouseClicked(evt);
            }
        });
        landingPanel.add(newProductsLandingIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 430, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new (2).png"))); // NOI18N
        jLabel1.setText("jLabel1");
        landingPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLayeredPane1.add(landingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 553));

        newProductsPanel.setBackground(new java.awt.Color(238, 238, 238));
        newProductsPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        newProductsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(243, 243, 243));
        jLabel2.setText("new products");
        newProductsPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        newProductsSlot1.setBackground(new java.awt.Color(255, 255, 255));
        newProductsPanel.add(newProductsSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 150, 120));

        newProductsSlot3.setBackground(new java.awt.Color(255, 255, 255));
        newProductsPanel.add(newProductsSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 150, 120));

        newProductsSlot4.setBackground(new java.awt.Color(255, 255, 255));
        newProductsPanel.add(newProductsSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 150, 120));

        newProductsSlot2.setBackground(new java.awt.Color(255, 255, 255));
        newProductsPanel.add(newProductsSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 150, 120));

        newProductsSlot6.setBackground(new java.awt.Color(255, 255, 255));
        newProductsPanel.add(newProductsSlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 150, 120));

        newProductsSlot5.setBackground(new java.awt.Color(255, 255, 255));
        newProductsPanel.add(newProductsSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 150, 120));

        newProductsSlot7.setBackground(new java.awt.Color(255, 255, 255));
        newProductsPanel.add(newProductsSlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 150, 120));

        newProductsSlot8.setBackground(new java.awt.Color(255, 255, 255));
        newProductsPanel.add(newProductsSlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 310, 150, 120));

        newProductsLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        newProductsLabel4.setForeground(new java.awt.Color(111, 65, 44));
        newProductsLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsLabel4.setText("Product Name");
        newProductsPanel.add(newProductsLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 180, 150, -1));

        newProductsPrice4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newProductsPrice4.setForeground(new java.awt.Color(207, 127, 52));
        newProductsPrice4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsPrice4.setText("Product Price");
        newProductsPanel.add(newProductsPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 200, 120, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newProductsAddToCart4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        newProductsAddToCart4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(newProductsAddToCart4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        jPanel1.add(newProductsStockLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        newProductsPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 150, 90));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newProductsLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        newProductsLabel8.setForeground(new java.awt.Color(111, 65, 44));
        newProductsLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsLabel8.setText("Product Name");
        jPanel4.add(newProductsLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        newProductsPrice8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newProductsPrice8.setForeground(new java.awt.Color(207, 127, 52));
        newProductsPrice8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsPrice8.setText("Product Price");
        jPanel4.add(newProductsPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, -1));

        newProductsAddToCart8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        newProductsAddToCart8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(newProductsAddToCart8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        jPanel4.add(newProductsStockLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        newProductsPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 430, 150, 90));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newProductsLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        newProductsLabel2.setForeground(new java.awt.Color(111, 65, 44));
        newProductsLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsLabel2.setText("Product Name");
        jPanel5.add(newProductsLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        newProductsPrice2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newProductsPrice2.setForeground(new java.awt.Color(207, 127, 52));
        newProductsPrice2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsPrice2.setText("Product Price");
        jPanel5.add(newProductsPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        newProductsAddToCart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        newProductsAddToCart2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(newProductsAddToCart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        jPanel5.add(newProductsStockLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        newProductsPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 150, 90));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newProductsLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        newProductsLabel3.setForeground(new java.awt.Color(111, 65, 44));
        newProductsLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsLabel3.setText("Product Name");
        jPanel7.add(newProductsLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        newProductsPrice3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newProductsPrice3.setForeground(new java.awt.Color(207, 127, 52));
        newProductsPrice3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsPrice3.setText("Product Price");
        jPanel7.add(newProductsPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        newProductsAddToCart3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        newProductsAddToCart3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel7.add(newProductsAddToCart3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        jPanel7.add(newProductsStockLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        newProductsPanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 150, 90));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newProductsLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        newProductsLabel1.setForeground(new java.awt.Color(111, 65, 44));
        newProductsLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsLabel1.setText("Product Name");
        jPanel8.add(newProductsLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        newProductsPrice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newProductsPrice1.setForeground(new java.awt.Color(207, 127, 52));
        newProductsPrice1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsPrice1.setText("Product Price");
        jPanel8.add(newProductsPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));
        jPanel8.add(newProductsStockLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        newProductsAddToCart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        newProductsAddToCart1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel8.add(newProductsAddToCart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        newProductsPanel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 150, 90));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newProductsLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        newProductsLabel5.setForeground(new java.awt.Color(111, 65, 44));
        newProductsLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsLabel5.setText("Product Name");
        jPanel9.add(newProductsLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        newProductsPrice5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newProductsPrice5.setForeground(new java.awt.Color(207, 127, 52));
        newProductsPrice5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsPrice5.setText("Product Price");
        jPanel9.add(newProductsPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        newProductsAddToCart5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        newProductsAddToCart5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel9.add(newProductsAddToCart5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        jPanel9.add(newProductsStockLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        newProductsPanel.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 150, 90));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newProductsLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        newProductsLabel6.setForeground(new java.awt.Color(111, 65, 44));
        newProductsLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsLabel6.setText("Product Name");
        jPanel10.add(newProductsLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        newProductsPrice6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newProductsPrice6.setForeground(new java.awt.Color(207, 127, 52));
        newProductsPrice6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsPrice6.setText("Product Price");
        jPanel10.add(newProductsPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        newProductsAddToCart6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        newProductsAddToCart6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel10.add(newProductsAddToCart6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        jPanel10.add(newProductsStockLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        newProductsPanel.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 150, 90));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newProductsLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        newProductsLabel7.setForeground(new java.awt.Color(111, 65, 44));
        newProductsLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsLabel7.setText("Product Name");
        jPanel11.add(newProductsLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        newProductsPrice7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newProductsPrice7.setForeground(new java.awt.Color(207, 127, 52));
        newProductsPrice7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProductsPrice7.setText("Product Price");
        jPanel11.add(newProductsPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        newProductsAddToCart7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        newProductsAddToCart7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel11.add(newProductsAddToCart7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        jPanel11.add(newProductsStockLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        newProductsPanel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 150, 90));

        jLayeredPane1.add(newProductsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 538));

        bakeryPanel.setBackground(new java.awt.Color(238, 238, 238));
        bakeryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(243, 243, 243));
        jLabel3.setText("bakery");
        bakeryPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bakeryLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bakeryLabel1.setForeground(new java.awt.Color(111, 65, 44));
        bakeryLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryLabel1.setText("Product Name");
        jPanel12.add(bakeryLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        bakeryPrice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bakeryPrice1.setForeground(new java.awt.Color(207, 127, 52));
        bakeryPrice1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryPrice1.setText("Product Price");
        jPanel12.add(bakeryPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));
        jPanel12.add(bakeryStock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        bakeryAddToCart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        bakeryAddToCart1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel12.add(bakeryAddToCart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        bakeryPanel.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 150, 90));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel13.add(bakeryStock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        bakeryPrice2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bakeryPrice2.setForeground(new java.awt.Color(207, 127, 52));
        bakeryPrice2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryPrice2.setText("Product Price");
        jPanel13.add(bakeryPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        bakeryLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bakeryLabel2.setForeground(new java.awt.Color(111, 65, 44));
        bakeryLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryLabel2.setText("Product Name");
        jPanel13.add(bakeryLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        bakeryAddToCart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        bakeryAddToCart2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel13.add(bakeryAddToCart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        bakeryPanel.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 150, 90));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel14.add(bakeryStock3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        bakeryPrice3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bakeryPrice3.setForeground(new java.awt.Color(207, 127, 52));
        bakeryPrice3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryPrice3.setText("Product Price");
        jPanel14.add(bakeryPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        bakeryLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bakeryLabel3.setForeground(new java.awt.Color(111, 65, 44));
        bakeryLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryLabel3.setText("Product Name");
        jPanel14.add(bakeryLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        bakeryAddToCart3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        bakeryAddToCart3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel14.add(bakeryAddToCart3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        bakeryPanel.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 150, 90));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel15.add(bakeryStock4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        bakeryPrice4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bakeryPrice4.setForeground(new java.awt.Color(207, 127, 52));
        bakeryPrice4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryPrice4.setText("Product Price");
        jPanel15.add(bakeryPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        bakeryLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bakeryLabel4.setForeground(new java.awt.Color(111, 65, 44));
        bakeryLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryLabel4.setText("Product Name");
        jPanel15.add(bakeryLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        bakeryAddToCart4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        bakeryAddToCart4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel15.add(bakeryAddToCart4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        bakeryPanel.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 150, 90));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel16.add(bakeryStock5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        bakeryPrice5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bakeryPrice5.setForeground(new java.awt.Color(207, 127, 52));
        bakeryPrice5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryPrice5.setText("Product Price");
        jPanel16.add(bakeryPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        bakeryLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bakeryLabel5.setForeground(new java.awt.Color(111, 65, 44));
        bakeryLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryLabel5.setText("Product Name");
        jPanel16.add(bakeryLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        bakeryAddToCart5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        bakeryAddToCart5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel16.add(bakeryAddToCart5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        bakeryPanel.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 150, 90));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel17.add(bakeryStock6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        bakeryPrice6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bakeryPrice6.setForeground(new java.awt.Color(207, 127, 52));
        bakeryPrice6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryPrice6.setText("Product Price");
        jPanel17.add(bakeryPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        bakeryLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bakeryLabel6.setForeground(new java.awt.Color(111, 65, 44));
        bakeryLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryLabel6.setText("Product Name");
        jPanel17.add(bakeryLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        bakeryAddToCart6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        bakeryAddToCart6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel17.add(bakeryAddToCart6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        bakeryPanel.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 150, 90));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel18.add(bakeryStock7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        bakeryPrice7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bakeryPrice7.setForeground(new java.awt.Color(207, 127, 52));
        bakeryPrice7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryPrice7.setText("Product Price");
        jPanel18.add(bakeryPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        bakeryLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bakeryLabel7.setForeground(new java.awt.Color(111, 65, 44));
        bakeryLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryLabel7.setText("Product Name");
        jPanel18.add(bakeryLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        bakeryAddToCart7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        bakeryAddToCart7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel18.add(bakeryAddToCart7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        bakeryPanel.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 150, 90));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel19.add(bakeryStock8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        bakeryPrice8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bakeryPrice8.setForeground(new java.awt.Color(207, 127, 52));
        bakeryPrice8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryPrice8.setText("Product Price");
        jPanel19.add(bakeryPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        bakeryLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bakeryLabel8.setForeground(new java.awt.Color(111, 65, 44));
        bakeryLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bakeryLabel8.setText("Product Name");
        jPanel19.add(bakeryLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        bakeryAddToCart8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        bakeryAddToCart8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel19.add(bakeryAddToCart8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        bakeryPanel.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 430, 150, 90));

        bakerySlot1.setBackground(new java.awt.Color(255, 255, 255));
        bakeryPanel.add(bakerySlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 150, 120));

        bakerySlot2.setBackground(new java.awt.Color(255, 255, 255));
        bakeryPanel.add(bakerySlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 150, 120));

        bakerySlot3.setBackground(new java.awt.Color(255, 255, 255));
        bakeryPanel.add(bakerySlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 150, 120));

        bakerySlot4.setBackground(new java.awt.Color(255, 255, 255));
        bakeryPanel.add(bakerySlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 150, 120));

        bakerySlot5.setBackground(new java.awt.Color(255, 255, 255));
        bakeryPanel.add(bakerySlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 150, 120));

        bakerySlot6.setBackground(new java.awt.Color(255, 255, 255));
        bakeryPanel.add(bakerySlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 150, 120));

        bakerySlot7.setBackground(new java.awt.Color(255, 255, 255));
        bakeryPanel.add(bakerySlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 150, 120));

        bakerySlot8.setBackground(new java.awt.Color(255, 255, 255));
        bakeryPanel.add(bakerySlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 310, 150, 120));

        jLayeredPane1.add(bakeryPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 545));

        butcheryPanel.setBackground(new java.awt.Color(238, 238, 238));
        butcheryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butcherySlot2.setBackground(new java.awt.Color(255, 255, 255));
        butcheryPanel.add(butcherySlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 150, 120));

        butcherySlot3.setBackground(new java.awt.Color(255, 255, 255));
        butcheryPanel.add(butcherySlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 150, 120));

        butcherySlot4.setBackground(new java.awt.Color(255, 255, 255));
        butcheryPanel.add(butcherySlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 150, 120));

        jLabel4.setBackground(new java.awt.Color(243, 243, 243));
        jLabel4.setText("butchery");
        butcheryPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        butcherySlot1.setBackground(new java.awt.Color(255, 255, 255));
        butcheryPanel.add(butcherySlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 150, 120));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butcheryLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butcheryLabel1.setForeground(new java.awt.Color(111, 65, 44));
        butcheryLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryLabel1.setText("Product Name");
        jPanel20.add(butcheryLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));
        jPanel20.add(butcheryStock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        butcheryAddToCart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        butcheryAddToCart1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel20.add(butcheryAddToCart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        butcheryPrice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        butcheryPrice1.setForeground(new java.awt.Color(207, 127, 52));
        butcheryPrice1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryPrice1.setText("Product Price");
        jPanel20.add(butcheryPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        butcheryPanel.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 150, 90));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel21.add(butcheryStock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        butcheryLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butcheryLabel2.setForeground(new java.awt.Color(111, 65, 44));
        butcheryLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryLabel2.setText("Product Name");
        jPanel21.add(butcheryLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        butcheryPrice2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        butcheryPrice2.setForeground(new java.awt.Color(207, 127, 52));
        butcheryPrice2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryPrice2.setText("Product Price");
        jPanel21.add(butcheryPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        butcheryAddToCart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        butcheryAddToCart2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel21.add(butcheryAddToCart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        butcheryPanel.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 150, 90));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel22.add(butcheryStock3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        butcheryLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butcheryLabel3.setForeground(new java.awt.Color(111, 65, 44));
        butcheryLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryLabel3.setText("Product Name");
        jPanel22.add(butcheryLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 20));

        butcheryPrice3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        butcheryPrice3.setForeground(new java.awt.Color(207, 127, 52));
        butcheryPrice3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryPrice3.setText("Product Price");
        jPanel22.add(butcheryPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        butcheryAddToCart3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        butcheryAddToCart3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel22.add(butcheryAddToCart3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        butcheryPanel.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 150, 90));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel23.add(butcheryStock4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        butcheryLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butcheryLabel4.setForeground(new java.awt.Color(111, 65, 44));
        butcheryLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryLabel4.setText("Product Name");
        jPanel23.add(butcheryLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        butcheryPrice4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        butcheryPrice4.setForeground(new java.awt.Color(207, 127, 52));
        butcheryPrice4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryPrice4.setText("Product Price");
        jPanel23.add(butcheryPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        butcheryAddToCart4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        butcheryAddToCart4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel23.add(butcheryAddToCart4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        butcheryPanel.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 150, 90));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel24.add(butcheryStock5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        butcheryLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butcheryLabel5.setForeground(new java.awt.Color(111, 65, 44));
        butcheryLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryLabel5.setText("Product Name");
        jPanel24.add(butcheryLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        butcheryPrice5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        butcheryPrice5.setForeground(new java.awt.Color(207, 127, 52));
        butcheryPrice5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryPrice5.setText("Product Price");
        jPanel24.add(butcheryPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        butcheryAddToCart5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        butcheryAddToCart5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel24.add(butcheryAddToCart5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        butcheryPanel.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 150, 90));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel25.add(butcheryStock6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        butcheryLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butcheryLabel6.setForeground(new java.awt.Color(111, 65, 44));
        butcheryLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryLabel6.setText("Product Name");
        jPanel25.add(butcheryLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        butcheryPrice6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        butcheryPrice6.setForeground(new java.awt.Color(207, 127, 52));
        butcheryPrice6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryPrice6.setText("Product Price");
        jPanel25.add(butcheryPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        butcheryAddToCart6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        butcheryAddToCart6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel25.add(butcheryAddToCart6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        butcheryPanel.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 150, 90));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel26.add(butcheryStock7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        butcheryLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butcheryLabel7.setForeground(new java.awt.Color(111, 65, 44));
        butcheryLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryLabel7.setText("Product Name");
        jPanel26.add(butcheryLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        butcheryPrice7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        butcheryPrice7.setForeground(new java.awt.Color(207, 127, 52));
        butcheryPrice7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryPrice7.setText("Product Price");
        jPanel26.add(butcheryPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        butcheryAddToCart7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        butcheryAddToCart7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel26.add(butcheryAddToCart7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        butcheryPanel.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 150, 90));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel27.add(butcheryStock8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        butcheryLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butcheryLabel8.setForeground(new java.awt.Color(111, 65, 44));
        butcheryLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryLabel8.setText("Product Name");
        jPanel27.add(butcheryLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        butcheryPrice8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        butcheryPrice8.setForeground(new java.awt.Color(207, 127, 52));
        butcheryPrice8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butcheryPrice8.setText("Product Price");
        jPanel27.add(butcheryPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, 20));

        butcheryAddToCart8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        butcheryAddToCart8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel27.add(butcheryAddToCart8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        butcheryPanel.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 430, 150, 90));

        butcherySlot5.setBackground(new java.awt.Color(255, 255, 255));
        butcheryPanel.add(butcherySlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 150, 120));

        butcherySlot6.setBackground(new java.awt.Color(255, 255, 255));
        butcheryPanel.add(butcherySlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 150, 120));

        butcherySlot7.setBackground(new java.awt.Color(255, 255, 255));
        butcheryPanel.add(butcherySlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 150, 120));

        butcherySlot8.setBackground(new java.awt.Color(255, 255, 255));
        butcheryPanel.add(butcherySlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 310, 150, 120));

        jLayeredPane1.add(butcheryPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, -1));

        readyMealsPanel.setBackground(new java.awt.Color(238, 238, 238));
        readyMealsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(243, 243, 243));
        jLabel6.setText("ready meals");
        readyMealsPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel28.add(readyMealsStock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        readyMealsLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        readyMealsLabel1.setForeground(new java.awt.Color(111, 65, 44));
        readyMealsLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsLabel1.setText("Product Name");
        jPanel28.add(readyMealsLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        readyMealsPrice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        readyMealsPrice1.setForeground(new java.awt.Color(207, 127, 52));
        readyMealsPrice1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsPrice1.setText("Product Price");
        jPanel28.add(readyMealsPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));

        readyMealsAddToCart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        readyMealsAddToCart1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel28.add(readyMealsAddToCart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        readyMealsPanel.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 150, 90));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        readyMealsLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        readyMealsLabel2.setForeground(new java.awt.Color(111, 65, 44));
        readyMealsLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsLabel2.setText("Product Name");
        jPanel29.add(readyMealsLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        readyMealsPrice2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        readyMealsPrice2.setForeground(new java.awt.Color(207, 127, 52));
        readyMealsPrice2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsPrice2.setText("Product Price");
        jPanel29.add(readyMealsPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));
        jPanel29.add(readyMealsStock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        readyMealsAddToCart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        readyMealsAddToCart2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel29.add(readyMealsAddToCart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        readyMealsPanel.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 150, 90));

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        readyMealsLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        readyMealsLabel3.setForeground(new java.awt.Color(111, 65, 44));
        readyMealsLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsLabel3.setText("Product Name");
        jPanel30.add(readyMealsLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        readyMealsPrice3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        readyMealsPrice3.setForeground(new java.awt.Color(207, 127, 52));
        readyMealsPrice3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsPrice3.setText("Product Price");
        jPanel30.add(readyMealsPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));
        jPanel30.add(readyMealsStock3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        readyMealsAddToCart3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        readyMealsAddToCart3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel30.add(readyMealsAddToCart3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        readyMealsPanel.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 150, 90));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        readyMealsLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        readyMealsLabel4.setForeground(new java.awt.Color(111, 65, 44));
        readyMealsLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsLabel4.setText("Product Name");
        jPanel31.add(readyMealsLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        readyMealsPrice4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        readyMealsPrice4.setForeground(new java.awt.Color(207, 127, 52));
        readyMealsPrice4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsPrice4.setText("Product Price");
        jPanel31.add(readyMealsPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));
        jPanel31.add(readyMealsStock4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        readyMealsAddToCart4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        readyMealsAddToCart4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel31.add(readyMealsAddToCart4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        readyMealsPanel.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 150, 90));

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        readyMealsLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        readyMealsLabel8.setForeground(new java.awt.Color(111, 65, 44));
        readyMealsLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsLabel8.setText("Product Name");
        jPanel32.add(readyMealsLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        readyMealsPrice8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        readyMealsPrice8.setForeground(new java.awt.Color(207, 127, 52));
        readyMealsPrice8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsPrice8.setText("Product Price");
        jPanel32.add(readyMealsPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));
        jPanel32.add(readyMealsStock8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        readyMealsAddToCart8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        readyMealsAddToCart8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel32.add(readyMealsAddToCart8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        readyMealsPanel.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 430, 150, 90));

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        readyMealsLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        readyMealsLabel7.setForeground(new java.awt.Color(111, 65, 44));
        readyMealsLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsLabel7.setText("Product Name");
        jPanel33.add(readyMealsLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        readyMealsPrice7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        readyMealsPrice7.setForeground(new java.awt.Color(207, 127, 52));
        readyMealsPrice7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsPrice7.setText("Product Price");
        jPanel33.add(readyMealsPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));
        jPanel33.add(readyMealsStock7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        readyMealsAddToCart7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        readyMealsAddToCart7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel33.add(readyMealsAddToCart7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        readyMealsPanel.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 150, 90));

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        readyMealsLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        readyMealsLabel6.setForeground(new java.awt.Color(111, 65, 44));
        readyMealsLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsLabel6.setText("Product Name");
        jPanel34.add(readyMealsLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        readyMealsPrice6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        readyMealsPrice6.setForeground(new java.awt.Color(207, 127, 52));
        readyMealsPrice6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsPrice6.setText("Product Price");
        jPanel34.add(readyMealsPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));
        jPanel34.add(readyMealsStock6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        readyMealsAddToCart6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        readyMealsAddToCart6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel34.add(readyMealsAddToCart6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        readyMealsPanel.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 150, 90));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        readyMealsLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        readyMealsLabel5.setForeground(new java.awt.Color(111, 65, 44));
        readyMealsLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsLabel5.setText("Product Name");
        jPanel35.add(readyMealsLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        readyMealsPrice5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        readyMealsPrice5.setForeground(new java.awt.Color(207, 127, 52));
        readyMealsPrice5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        readyMealsPrice5.setText("Product Price");
        jPanel35.add(readyMealsPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));
        jPanel35.add(readyMealsStock5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        readyMealsAddToCart5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        readyMealsAddToCart5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel35.add(readyMealsAddToCart5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        readyMealsPanel.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 150, 90));

        readyMealsSlot1.setBackground(new java.awt.Color(255, 255, 255));
        readyMealsPanel.add(readyMealsSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 150, 120));

        readyMealsSlot2.setBackground(new java.awt.Color(255, 255, 255));
        readyMealsPanel.add(readyMealsSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 150, 120));

        readyMealsSlot3.setBackground(new java.awt.Color(255, 255, 255));
        readyMealsPanel.add(readyMealsSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 150, 120));

        readyMealsSlot4.setBackground(new java.awt.Color(255, 255, 255));
        readyMealsPanel.add(readyMealsSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 150, 120));

        readyMealsSlot5.setBackground(new java.awt.Color(255, 255, 255));
        readyMealsPanel.add(readyMealsSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 150, 120));

        readyMealsSlot6.setBackground(new java.awt.Color(255, 255, 255));
        readyMealsPanel.add(readyMealsSlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 150, 120));

        readyMealsSlot7.setBackground(new java.awt.Color(255, 255, 255));
        readyMealsPanel.add(readyMealsSlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 150, 120));

        readyMealsSlot8.setBackground(new java.awt.Color(255, 255, 255));
        readyMealsPanel.add(readyMealsSlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 310, 150, 120));

        jLayeredPane1.add(readyMealsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1256, -1));

        vegetablesPanel.setBackground(new java.awt.Color(238, 238, 238));
        vegetablesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(243, 243, 243));
        jLabel7.setText("vegetables");
        vegetablesPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vegetablesLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vegetablesLabel1.setForeground(new java.awt.Color(111, 65, 44));
        vegetablesLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetablesLabel1.setText("Product Name");
        jPanel44.add(vegetablesLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        vegetablesPrice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        vegetablesPrice1.setForeground(new java.awt.Color(207, 127, 52));
        vegetablesPrice1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetablesPrice1.setText("Product Price");
        jPanel44.add(vegetablesPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel44.add(vegetablesStock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        vegetablesAddToCart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        vegetablesAddToCart1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel44.add(vegetablesAddToCart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        vegetablesPanel.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 150, 90));

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vegetablesLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vegetablesLabel2.setForeground(new java.awt.Color(111, 65, 44));
        vegetablesLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetablesLabel2.setText("Product Name");
        jPanel45.add(vegetablesLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        vegetablesPrice2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        vegetablesPrice2.setForeground(new java.awt.Color(207, 127, 52));
        vegetablesPrice2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetablesPrice2.setText("Product Price");
        jPanel45.add(vegetablesPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel45.add(vegetablesStock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        vegetablesAddToCart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        vegetablesAddToCart2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel45.add(vegetablesAddToCart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        vegetablesPanel.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 150, 90));

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vegetablesLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vegetablesLabel3.setForeground(new java.awt.Color(111, 65, 44));
        vegetablesLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetablesLabel3.setText("Product Name");
        jPanel46.add(vegetablesLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        vegetablesPrice3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        vegetablesPrice3.setForeground(new java.awt.Color(207, 127, 52));
        vegetablesPrice3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetablesPrice3.setText("Product Price");
        jPanel46.add(vegetablesPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel46.add(vegetablesStock3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        vegetablesAddToCart3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        vegetablesAddToCart3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel46.add(vegetablesAddToCart3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        vegetablesPanel.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 150, 90));

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vegetablesLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vegetablesLabel4.setForeground(new java.awt.Color(111, 65, 44));
        vegetablesLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetablesLabel4.setText("Product Name");
        jPanel47.add(vegetablesLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        vegetablesPrice4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        vegetablesPrice4.setForeground(new java.awt.Color(207, 127, 52));
        vegetablesPrice4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetablesPrice4.setText("Product Price");
        jPanel47.add(vegetablesPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel47.add(vegetablesStock4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        vegetablesAddToCart4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        vegetablesAddToCart4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel47.add(vegetablesAddToCart4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        vegetablesPanel.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 150, 90));

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vegetablesLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vegetablesLabel8.setForeground(new java.awt.Color(111, 65, 44));
        vegetablesLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetablesLabel8.setText("Product Name");
        jPanel48.add(vegetablesLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        vegetablesPrice8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        vegetablesPrice8.setForeground(new java.awt.Color(207, 127, 52));
        vegetablesPrice8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetablesPrice8.setText("Product Price");
        jPanel48.add(vegetablesPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel48.add(vegetablesStock8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        vegetablesAddToCart8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        vegetablesAddToCart8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel48.add(vegetablesAddToCart8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        vegetablesPanel.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 430, 150, 90));

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vegetablesLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vegetablesLabel7.setForeground(new java.awt.Color(111, 65, 44));
        vegetablesLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetablesLabel7.setText("Product Name");
        jPanel49.add(vegetablesLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        vegetablesPrice7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        vegetablesPrice7.setForeground(new java.awt.Color(207, 127, 52));
        vegetablesPrice7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetablesPrice7.setText("Product Price");
        jPanel49.add(vegetablesPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel49.add(vegetablesStock7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        vegetablesAddToCart7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        vegetablesAddToCart7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel49.add(vegetablesAddToCart7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        vegetablesPanel.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 150, 90));

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vegetablesLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vegetablesLabel6.setForeground(new java.awt.Color(111, 65, 44));
        vegetablesLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetablesLabel6.setText("Product Name");
        jPanel50.add(vegetablesLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        vegetablesPrice6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        vegetablesPrice6.setForeground(new java.awt.Color(207, 127, 52));
        vegetablesPrice6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetablesPrice6.setText("Product Price");
        jPanel50.add(vegetablesPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel50.add(vegetablesStock6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        vegetablesAddToCart6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        vegetablesAddToCart6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel50.add(vegetablesAddToCart6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        vegetablesPanel.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 150, 90));

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vegetablesLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vegetablesLabel5.setForeground(new java.awt.Color(111, 65, 44));
        vegetablesLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetablesLabel5.setText("Product Name");
        jPanel51.add(vegetablesLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        vegetablesPrice5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        vegetablesPrice5.setForeground(new java.awt.Color(207, 127, 52));
        vegetablesPrice5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vegetablesPrice5.setText("Product Price");
        jPanel51.add(vegetablesPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel51.add(vegetablesStock5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        vegetablesAddToCart5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        vegetablesAddToCart5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel51.add(vegetablesAddToCart5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        vegetablesPanel.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 150, 90));

        vegetablesSlot1.setBackground(new java.awt.Color(255, 255, 255));
        vegetablesPanel.add(vegetablesSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 150, 120));

        vegetablesSlot2.setBackground(new java.awt.Color(255, 255, 255));
        vegetablesPanel.add(vegetablesSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 150, 120));

        vegetablesSlot3.setBackground(new java.awt.Color(255, 255, 255));
        vegetablesPanel.add(vegetablesSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 150, 120));

        vegetablesSlot4.setBackground(new java.awt.Color(255, 255, 255));
        vegetablesPanel.add(vegetablesSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 150, 120));

        vegetablesSlot5.setBackground(new java.awt.Color(255, 255, 255));
        vegetablesPanel.add(vegetablesSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 150, 120));

        vegetablesSlot6.setBackground(new java.awt.Color(255, 255, 255));
        vegetablesPanel.add(vegetablesSlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 150, 120));

        vegetablesSlot7.setBackground(new java.awt.Color(255, 255, 255));
        vegetablesPanel.add(vegetablesSlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 150, 120));

        vegetablesSlot8.setBackground(new java.awt.Color(255, 255, 255));
        vegetablesPanel.add(vegetablesSlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 310, 150, 120));

        jLayeredPane1.add(vegetablesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, -1));

        fruitsPanel.setBackground(new java.awt.Color(238, 238, 238));
        fruitsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(243, 243, 243));
        jLabel8.setText("fruits");
        fruitsPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fruitsPrice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fruitsPrice1.setForeground(new java.awt.Color(207, 127, 52));
        fruitsPrice1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsPrice1.setText("Product Price");
        jPanel52.add(fruitsPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel52.add(fruitsStock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        fruitsLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fruitsLabel1.setForeground(new java.awt.Color(111, 65, 44));
        fruitsLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsLabel1.setText("Product Name");
        jPanel52.add(fruitsLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        fruitsAddToCart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        fruitsAddToCart1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel52.add(fruitsAddToCart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        fruitsPanel.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 150, 90));

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fruitsLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fruitsLabel2.setForeground(new java.awt.Color(111, 65, 44));
        fruitsLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsLabel2.setText("Product Name");
        jPanel53.add(fruitsLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        fruitsPrice2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fruitsPrice2.setForeground(new java.awt.Color(207, 127, 52));
        fruitsPrice2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsPrice2.setText("Product Price");
        jPanel53.add(fruitsPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel53.add(fruitsStock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        fruitsAddToCart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        fruitsAddToCart2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel53.add(fruitsAddToCart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        fruitsPanel.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 150, 90));

        jPanel54.setBackground(new java.awt.Color(255, 255, 255));
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fruitsLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fruitsLabel3.setForeground(new java.awt.Color(111, 65, 44));
        fruitsLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsLabel3.setText("Product Name");
        jPanel54.add(fruitsLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        fruitsPrice3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fruitsPrice3.setForeground(new java.awt.Color(207, 127, 52));
        fruitsPrice3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsPrice3.setText("Product Price");
        jPanel54.add(fruitsPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel54.add(fruitsStock3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        fruitsAddToCart3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        fruitsAddToCart3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel54.add(fruitsAddToCart3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        fruitsPanel.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 150, 90));

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));
        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fruitsLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fruitsLabel4.setForeground(new java.awt.Color(111, 65, 44));
        fruitsLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsLabel4.setText("Product Name");
        jPanel55.add(fruitsLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        fruitsPrice4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fruitsPrice4.setForeground(new java.awt.Color(207, 127, 52));
        fruitsPrice4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsPrice4.setText("Product Price");
        jPanel55.add(fruitsPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel55.add(fruitsStock4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        fruitsAddToCart4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        fruitsAddToCart4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel55.add(fruitsAddToCart4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        fruitsPanel.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 150, 90));

        jPanel56.setBackground(new java.awt.Color(255, 255, 255));
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fruitsLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fruitsLabel8.setForeground(new java.awt.Color(111, 65, 44));
        fruitsLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsLabel8.setText("Product Name");
        jPanel56.add(fruitsLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        fruitsPrice8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fruitsPrice8.setForeground(new java.awt.Color(207, 127, 52));
        fruitsPrice8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsPrice8.setText("Product Price");
        jPanel56.add(fruitsPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel56.add(fruitsStock8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        fruitsAddToCart8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        fruitsAddToCart8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel56.add(fruitsAddToCart8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        fruitsPanel.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 430, 150, 90));

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));
        jPanel57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fruitsLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fruitsLabel7.setForeground(new java.awt.Color(111, 65, 44));
        fruitsLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsLabel7.setText("Product Name");
        jPanel57.add(fruitsLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        fruitsPrice7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fruitsPrice7.setForeground(new java.awt.Color(207, 127, 52));
        fruitsPrice7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsPrice7.setText("Product Price");
        jPanel57.add(fruitsPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel57.add(fruitsStock7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        fruitsAddToCart7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        fruitsAddToCart7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel57.add(fruitsAddToCart7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        fruitsPanel.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 150, 90));

        jPanel58.setBackground(new java.awt.Color(255, 255, 255));
        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fruitsLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fruitsLabel6.setForeground(new java.awt.Color(111, 65, 44));
        fruitsLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsLabel6.setText("Product Name");
        jPanel58.add(fruitsLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        fruitsPrice6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fruitsPrice6.setForeground(new java.awt.Color(207, 127, 52));
        fruitsPrice6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsPrice6.setText("Product Price");
        jPanel58.add(fruitsPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel58.add(fruitsStock6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        fruitsAddToCart6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        fruitsAddToCart6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel58.add(fruitsAddToCart6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        fruitsPanel.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 150, 90));

        jPanel59.setBackground(new java.awt.Color(255, 255, 255));
        jPanel59.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fruitsLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fruitsLabel5.setForeground(new java.awt.Color(111, 65, 44));
        fruitsLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsLabel5.setText("Product Name");
        jPanel59.add(fruitsLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        fruitsPrice5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fruitsPrice5.setForeground(new java.awt.Color(207, 127, 52));
        fruitsPrice5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fruitsPrice5.setText("Product Price");
        jPanel59.add(fruitsPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel59.add(fruitsStock5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        fruitsAddToCart5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        fruitsAddToCart5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel59.add(fruitsAddToCart5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        fruitsPanel.add(jPanel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 150, 90));

        fruitsSlot1.setBackground(new java.awt.Color(255, 255, 255));
        fruitsPanel.add(fruitsSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 150, 120));

        vegetablesSlot13.setBackground(new java.awt.Color(255, 255, 255));
        fruitsPanel.add(vegetablesSlot13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 150, 120));

        fruitsSlot2.setBackground(new java.awt.Color(255, 255, 255));
        fruitsPanel.add(fruitsSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 150, 120));

        fruitsSlot3.setBackground(new java.awt.Color(255, 255, 255));
        fruitsPanel.add(fruitsSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 150, 120));

        fruitsSlot4.setBackground(new java.awt.Color(255, 255, 255));
        fruitsPanel.add(fruitsSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 150, 120));

        fruitsSlot5.setBackground(new java.awt.Color(255, 255, 255));
        fruitsPanel.add(fruitsSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 150, 120));

        fruitsSlot6.setBackground(new java.awt.Color(255, 255, 255));
        fruitsPanel.add(fruitsSlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 150, 120));

        fruitsSlot7.setBackground(new java.awt.Color(255, 255, 255));
        fruitsPanel.add(fruitsSlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 150, 120));

        fruitsSlot8.setBackground(new java.awt.Color(255, 255, 255));
        fruitsPanel.add(fruitsSlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 310, 150, 120));

        jLayeredPane1.add(fruitsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1256, -1));

        groceryPanel.setBackground(new java.awt.Color(238, 238, 238));
        groceryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel60.setBackground(new java.awt.Color(255, 255, 255));
        jPanel60.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newProductsAddToCart57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        newProductsAddToCart57.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel60.add(newProductsAddToCart57, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        groceryLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        groceryLabel1.setForeground(new java.awt.Color(111, 65, 44));
        groceryLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groceryLabel1.setText("Product Name");
        jPanel60.add(groceryLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        groceryPrice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        groceryPrice1.setForeground(new java.awt.Color(207, 127, 52));
        groceryPrice1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groceryPrice1.setText("Product Price");
        jPanel60.add(groceryPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel60.add(groceryStock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        groceryPanel.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 150, 90));

        jPanel61.setBackground(new java.awt.Color(255, 255, 255));
        jPanel61.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newProductsAddToCart58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        newProductsAddToCart58.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel61.add(newProductsAddToCart58, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        groceryLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        groceryLabel2.setForeground(new java.awt.Color(111, 65, 44));
        groceryLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groceryLabel2.setText("Product Name");
        jPanel61.add(groceryLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        groceryPrice2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        groceryPrice2.setForeground(new java.awt.Color(207, 127, 52));
        groceryPrice2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groceryPrice2.setText("Product Price");
        jPanel61.add(groceryPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel61.add(groceryStock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        groceryPanel.add(jPanel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 150, 90));

        jPanel62.setBackground(new java.awt.Color(255, 255, 255));
        jPanel62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newProductsAddToCart59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        newProductsAddToCart59.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel62.add(newProductsAddToCart59, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        jPanel62.add(vegetablesStock11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        groceryLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        groceryLabel3.setForeground(new java.awt.Color(111, 65, 44));
        groceryLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groceryLabel3.setText("Product Name");
        jPanel62.add(groceryLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        groceryPrice3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        groceryPrice3.setForeground(new java.awt.Color(207, 127, 52));
        groceryPrice3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groceryPrice3.setText("Product Price");
        jPanel62.add(groceryPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel62.add(groceryStock3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        groceryPanel.add(jPanel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 150, 90));

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));
        jPanel63.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newProductsAddToCart60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        newProductsAddToCart60.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel63.add(newProductsAddToCart60, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        jPanel63.add(vegetablesStock12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        groceryLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        groceryLabel4.setForeground(new java.awt.Color(111, 65, 44));
        groceryLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groceryLabel4.setText("Product Name");
        jPanel63.add(groceryLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        groceryPrice4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        groceryPrice4.setForeground(new java.awt.Color(207, 127, 52));
        groceryPrice4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groceryPrice4.setText("Product Price");
        jPanel63.add(groceryPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel63.add(groceryStock4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        groceryPanel.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 150, 90));

        jPanel64.setBackground(new java.awt.Color(255, 255, 255));
        jPanel64.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newProductsAddToCart61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        newProductsAddToCart61.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel64.add(newProductsAddToCart61, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        jPanel64.add(vegetablesStock13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        groceryLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        groceryLabel8.setForeground(new java.awt.Color(111, 65, 44));
        groceryLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groceryLabel8.setText("Product Name");
        jPanel64.add(groceryLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        groceryPrice8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        groceryPrice8.setForeground(new java.awt.Color(207, 127, 52));
        groceryPrice8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groceryPrice8.setText("Product Price");
        jPanel64.add(groceryPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel64.add(groceryStock8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        groceryPanel.add(jPanel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 430, 150, 90));

        jPanel65.setBackground(new java.awt.Color(255, 255, 255));
        jPanel65.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newProductsAddToCart62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        newProductsAddToCart62.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel65.add(newProductsAddToCart62, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        jPanel65.add(vegetablesStock14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        groceryLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        groceryLabel7.setForeground(new java.awt.Color(111, 65, 44));
        groceryLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groceryLabel7.setText("Product Name");
        jPanel65.add(groceryLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        groceryPrice7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        groceryPrice7.setForeground(new java.awt.Color(207, 127, 52));
        groceryPrice7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groceryPrice7.setText("Product Price");
        jPanel65.add(groceryPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel65.add(groceryStock7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        groceryPanel.add(jPanel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 150, 90));

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));
        jPanel66.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newProductsAddToCart63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        newProductsAddToCart63.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel66.add(newProductsAddToCart63, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        jPanel66.add(vegetablesStock15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        groceryLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        groceryLabel6.setForeground(new java.awt.Color(111, 65, 44));
        groceryLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groceryLabel6.setText("Product Name");
        jPanel66.add(groceryLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        groceryPrice6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        groceryPrice6.setForeground(new java.awt.Color(207, 127, 52));
        groceryPrice6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groceryPrice6.setText("Product Price");
        jPanel66.add(groceryPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel66.add(groceryStock6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        groceryPanel.add(jPanel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 150, 90));

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));
        jPanel67.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newProductsAddToCart64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        newProductsAddToCart64.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel67.add(newProductsAddToCart64, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        jPanel67.add(vegetablesStock16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        groceryLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        groceryLabel5.setForeground(new java.awt.Color(111, 65, 44));
        groceryLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groceryLabel5.setText("Product Name");
        jPanel67.add(groceryLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        groceryPrice5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        groceryPrice5.setForeground(new java.awt.Color(207, 127, 52));
        groceryPrice5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groceryPrice5.setText("Product Price");
        jPanel67.add(groceryPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel67.add(groceryStock5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        groceryPanel.add(jPanel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 150, 90));

        jLabel13.setBackground(new java.awt.Color(243, 243, 243));
        jLabel13.setText("Grocery");
        groceryPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        grocerySlot1.setBackground(new java.awt.Color(255, 255, 255));
        groceryPanel.add(grocerySlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 150, 120));

        grocerySlot2.setBackground(new java.awt.Color(255, 255, 255));
        groceryPanel.add(grocerySlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 150, 120));

        grocerySlot3.setBackground(new java.awt.Color(255, 255, 255));
        groceryPanel.add(grocerySlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 150, 120));

        grocerySlot4.setBackground(new java.awt.Color(255, 255, 255));
        groceryPanel.add(grocerySlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 150, 120));

        grocerySlot5.setBackground(new java.awt.Color(255, 255, 255));
        groceryPanel.add(grocerySlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 150, 120));

        grocerySlot6.setBackground(new java.awt.Color(255, 255, 255));
        groceryPanel.add(grocerySlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 150, 120));

        grocerySlot7.setBackground(new java.awt.Color(255, 255, 255));
        groceryPanel.add(grocerySlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 150, 120));

        grocerySlot8.setBackground(new java.awt.Color(255, 255, 255));
        groceryPanel.add(grocerySlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 310, 150, 120));

        jLayeredPane1.add(groceryPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1256, -1));

        snacksPanel.setBackground(new java.awt.Color(238, 238, 238));
        snacksPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(243, 243, 243));
        jLabel10.setText("snacks");
        snacksPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jPanel84.setBackground(new java.awt.Color(255, 255, 255));
        jPanel84.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        snacksPrice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        snacksPrice1.setForeground(new java.awt.Color(207, 127, 52));
        snacksPrice1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksPrice1.setText("Product Price");
        jPanel84.add(snacksPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));

        snacksLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        snacksLabel1.setForeground(new java.awt.Color(111, 65, 44));
        snacksLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksLabel1.setText("Product Name");
        jPanel84.add(snacksLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));
        jPanel84.add(snacksStock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        snacksAddToCart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        snacksAddToCart1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel84.add(snacksAddToCart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        snacksPanel.add(jPanel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 150, 90));

        jPanel85.setBackground(new java.awt.Color(255, 255, 255));
        jPanel85.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        snacksLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        snacksLabel2.setForeground(new java.awt.Color(111, 65, 44));
        snacksLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksLabel2.setText("Product Name");
        jPanel85.add(snacksLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        snacksPrice2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        snacksPrice2.setForeground(new java.awt.Color(207, 127, 52));
        snacksPrice2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksPrice2.setText("Product Price");
        jPanel85.add(snacksPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel85.add(snacksStock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        snacksAddToCart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        snacksAddToCart2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel85.add(snacksAddToCart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        snacksPanel.add(jPanel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 150, 90));

        jPanel86.setBackground(new java.awt.Color(255, 255, 255));
        jPanel86.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        snacksLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        snacksLabel3.setForeground(new java.awt.Color(111, 65, 44));
        snacksLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksLabel3.setText("Product Name");
        jPanel86.add(snacksLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        snacksPrice3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        snacksPrice3.setForeground(new java.awt.Color(207, 127, 52));
        snacksPrice3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksPrice3.setText("Product Price");
        jPanel86.add(snacksPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel86.add(snacksStock3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        snacksAddToCart3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        snacksAddToCart3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel86.add(snacksAddToCart3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        snacksPanel.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 150, 90));

        jPanel87.setBackground(new java.awt.Color(255, 255, 255));
        jPanel87.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        snacksLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        snacksLabel4.setForeground(new java.awt.Color(111, 65, 44));
        snacksLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksLabel4.setText("Product Name");
        jPanel87.add(snacksLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        snacksPrice4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        snacksPrice4.setForeground(new java.awt.Color(207, 127, 52));
        snacksPrice4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksPrice4.setText("Product Price");
        jPanel87.add(snacksPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel87.add(snacksStock4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        snacksAddToCart4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        snacksAddToCart4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel87.add(snacksAddToCart4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        snacksPanel.add(jPanel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 150, 90));

        jPanel88.setBackground(new java.awt.Color(255, 255, 255));
        jPanel88.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        snacksLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        snacksLabel8.setForeground(new java.awt.Color(111, 65, 44));
        snacksLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksLabel8.setText("Product Name");
        jPanel88.add(snacksLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        snacksPrice8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        snacksPrice8.setForeground(new java.awt.Color(207, 127, 52));
        snacksPrice8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksPrice8.setText("Product Price");
        jPanel88.add(snacksPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel88.add(snacksStock8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        snacksAddToCart8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        snacksAddToCart8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel88.add(snacksAddToCart8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        snacksPanel.add(jPanel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 430, 150, 90));

        jPanel89.setBackground(new java.awt.Color(255, 255, 255));
        jPanel89.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        snacksLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        snacksLabel7.setForeground(new java.awt.Color(111, 65, 44));
        snacksLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksLabel7.setText("Product Name");
        jPanel89.add(snacksLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        snacksPrice7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        snacksPrice7.setForeground(new java.awt.Color(207, 127, 52));
        snacksPrice7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksPrice7.setText("Product Price");
        jPanel89.add(snacksPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel89.add(snacksStock7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        snacksAddToCart7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        snacksAddToCart7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel89.add(snacksAddToCart7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        snacksPanel.add(jPanel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 150, 90));

        jPanel90.setBackground(new java.awt.Color(255, 255, 255));
        jPanel90.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        snacksLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        snacksLabel6.setForeground(new java.awt.Color(111, 65, 44));
        snacksLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksLabel6.setText("Product Name");
        jPanel90.add(snacksLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        snacksPrice6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        snacksPrice6.setForeground(new java.awt.Color(207, 127, 52));
        snacksPrice6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksPrice6.setText("Product Price");
        jPanel90.add(snacksPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel90.add(snacksStock6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        snacksAddToCart6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        snacksAddToCart6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel90.add(snacksAddToCart6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        snacksPanel.add(jPanel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 150, 90));

        jPanel91.setBackground(new java.awt.Color(255, 255, 255));
        jPanel91.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        snacksLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        snacksLabel5.setForeground(new java.awt.Color(111, 65, 44));
        snacksLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksLabel5.setText("Product Name");
        jPanel91.add(snacksLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        snacksPrice5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        snacksPrice5.setForeground(new java.awt.Color(207, 127, 52));
        snacksPrice5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snacksPrice5.setText("Product Price");
        jPanel91.add(snacksPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel91.add(snacksStock5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        snacksAddToCart5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        snacksAddToCart5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel91.add(snacksAddToCart5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        snacksPanel.add(jPanel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 150, 90));

        snacksSlot1.setBackground(new java.awt.Color(255, 255, 255));
        snacksPanel.add(snacksSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 150, 120));

        snacksSlot2.setBackground(new java.awt.Color(255, 255, 255));
        snacksPanel.add(snacksSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 150, 120));

        snacksSlot3.setBackground(new java.awt.Color(255, 255, 255));
        snacksPanel.add(snacksSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 150, 120));

        snacksSlot4.setBackground(new java.awt.Color(255, 255, 255));
        snacksPanel.add(snacksSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 150, 120));

        snacksSlot5.setBackground(new java.awt.Color(255, 255, 255));
        snacksPanel.add(snacksSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 150, 120));

        snacksSlot6.setBackground(new java.awt.Color(255, 255, 255));
        snacksPanel.add(snacksSlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 150, 120));

        snacksSlot7.setBackground(new java.awt.Color(255, 255, 255));
        snacksPanel.add(snacksSlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 150, 120));

        snacksSlot8.setBackground(new java.awt.Color(255, 255, 255));
        snacksPanel.add(snacksSlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 310, 150, 120));

        jLayeredPane1.add(snacksPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1256, -1));

        dessertsPanel.setBackground(new java.awt.Color(238, 238, 238));
        dessertsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(243, 243, 243));
        jLabel11.setText("desserts");
        dessertsPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        jPanel68.setBackground(new java.awt.Color(255, 255, 255));
        jPanel68.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dessertsLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dessertsLabel1.setForeground(new java.awt.Color(111, 65, 44));
        dessertsLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dessertsLabel1.setText("Product Name");
        jPanel68.add(dessertsLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        dessertsPrice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dessertsPrice1.setForeground(new java.awt.Color(207, 127, 52));
        dessertsPrice1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dessertsPrice1.setText("Product Price");
        jPanel68.add(dessertsPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel68.add(dessertsStock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        dessertsAddToCart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        dessertsAddToCart1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel68.add(dessertsAddToCart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        dessertsPanel.add(jPanel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 150, 90));

        jPanel69.setBackground(new java.awt.Color(255, 255, 255));
        jPanel69.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dessertsLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dessertsLabel2.setForeground(new java.awt.Color(111, 65, 44));
        dessertsLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dessertsLabel2.setText("Product Name");
        jPanel69.add(dessertsLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        dessertsPrice2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dessertsPrice2.setForeground(new java.awt.Color(207, 127, 52));
        dessertsPrice2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dessertsPrice2.setText("Product Price");
        jPanel69.add(dessertsPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel69.add(dessertsStock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        dessertsAddToCart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        dessertsAddToCart2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel69.add(dessertsAddToCart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        dessertsPanel.add(jPanel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 150, 90));

        jPanel70.setBackground(new java.awt.Color(255, 255, 255));
        jPanel70.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel70.add(groceryStock11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        dessertsLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dessertsLabel3.setForeground(new java.awt.Color(111, 65, 44));
        dessertsLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dessertsLabel3.setText("Product Name");
        jPanel70.add(dessertsLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 20));

        dessertsPrice3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dessertsPrice3.setForeground(new java.awt.Color(207, 127, 52));
        dessertsPrice3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dessertsPrice3.setText("Product Price");
        jPanel70.add(dessertsPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel70.add(dessertsStock3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        dessertsAddToCart3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        dessertsAddToCart3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel70.add(dessertsAddToCart3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        dessertsPanel.add(jPanel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 150, 90));

        jPanel71.setBackground(new java.awt.Color(255, 255, 255));
        jPanel71.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel71.add(groceryStock12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        dessertsLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dessertsLabel4.setForeground(new java.awt.Color(111, 65, 44));
        dessertsLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dessertsLabel4.setText("Product Name");
        jPanel71.add(dessertsLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 20));

        dessertsPrice4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dessertsPrice4.setForeground(new java.awt.Color(207, 127, 52));
        dessertsPrice4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dessertsPrice4.setText("Product Price");
        jPanel71.add(dessertsPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel71.add(dessertsStock4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        dessertsAddToCart4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        dessertsAddToCart4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel71.add(dessertsAddToCart4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        dessertsPanel.add(jPanel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 150, 90));

        jPanel72.setBackground(new java.awt.Color(255, 255, 255));
        jPanel72.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel72.add(groceryStock13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        dessertsLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dessertsLabel8.setForeground(new java.awt.Color(111, 65, 44));
        dessertsLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dessertsLabel8.setText("Product Name");
        jPanel72.add(dessertsLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 20));

        dessertsPrice8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dessertsPrice8.setForeground(new java.awt.Color(207, 127, 52));
        dessertsPrice8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dessertsPrice8.setText("Product Price");
        jPanel72.add(dessertsPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel72.add(dessertsStock8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        dessertsAddToCart8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        dessertsAddToCart8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel72.add(dessertsAddToCart8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        dessertsPanel.add(jPanel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 430, 150, 90));

        jPanel73.setBackground(new java.awt.Color(255, 255, 255));
        jPanel73.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel73.add(groceryStock14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        dessertsLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dessertsLabel7.setForeground(new java.awt.Color(111, 65, 44));
        dessertsLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dessertsLabel7.setText("Product Name");
        jPanel73.add(dessertsLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 20));

        dessertsPrice7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dessertsPrice7.setForeground(new java.awt.Color(207, 127, 52));
        dessertsPrice7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dessertsPrice7.setText("Product Price");
        jPanel73.add(dessertsPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel73.add(dessertsStock7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        dessertsAddToCart7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        dessertsAddToCart7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel73.add(dessertsAddToCart7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        dessertsPanel.add(jPanel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 150, 90));

        jPanel74.setBackground(new java.awt.Color(255, 255, 255));
        jPanel74.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel74.add(groceryStock15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        dessertsLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dessertsLabel6.setForeground(new java.awt.Color(111, 65, 44));
        dessertsLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dessertsLabel6.setText("Product Name");
        jPanel74.add(dessertsLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 20));

        dessertsPrice6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dessertsPrice6.setForeground(new java.awt.Color(207, 127, 52));
        dessertsPrice6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dessertsPrice6.setText("Product Price");
        jPanel74.add(dessertsPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel74.add(dessertsStock6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        dessertsAddToCart6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        dessertsAddToCart6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel74.add(dessertsAddToCart6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        dessertsPanel.add(jPanel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 150, 90));

        jPanel75.setBackground(new java.awt.Color(255, 255, 255));
        jPanel75.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel75.add(groceryStock16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        dessertsLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dessertsLabel5.setForeground(new java.awt.Color(111, 65, 44));
        dessertsLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dessertsLabel5.setText("Product Name");
        jPanel75.add(dessertsLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 20));

        dessertsPrice5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dessertsPrice5.setForeground(new java.awt.Color(207, 127, 52));
        dessertsPrice5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dessertsPrice5.setText("Product Price");
        jPanel75.add(dessertsPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel75.add(dessertsStock5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        dessertsAddToCart5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        dessertsAddToCart5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel75.add(dessertsAddToCart5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        dessertsPanel.add(jPanel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 150, 90));

        dessertsSlot1.setBackground(new java.awt.Color(255, 255, 255));
        dessertsPanel.add(dessertsSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 150, 120));

        dessertsSlot2.setBackground(new java.awt.Color(255, 255, 255));
        dessertsPanel.add(dessertsSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 150, 120));

        dessertsSlot3.setBackground(new java.awt.Color(255, 255, 255));
        dessertsPanel.add(dessertsSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 150, 120));

        dessertsSlot4.setBackground(new java.awt.Color(255, 255, 255));
        dessertsPanel.add(dessertsSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 150, 120));

        dessertsSlot5.setBackground(new java.awt.Color(255, 255, 255));
        dessertsPanel.add(dessertsSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 150, 120));

        dessertsSlot6.setBackground(new java.awt.Color(255, 255, 255));
        dessertsPanel.add(dessertsSlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 150, 120));

        dessertsSlot7.setBackground(new java.awt.Color(255, 255, 255));
        dessertsPanel.add(dessertsSlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 150, 120));

        dessertsSlot8.setBackground(new java.awt.Color(255, 255, 255));
        dessertsPanel.add(dessertsSlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 310, 150, 120));

        jLayeredPane1.add(dessertsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1256, -1));

        winesPanel.setBackground(new java.awt.Color(238, 238, 238));
        winesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setText("Beverages");
        winesPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jPanel76.setBackground(new java.awt.Color(255, 255, 255));
        jPanel76.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        winesLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        winesLabel1.setForeground(new java.awt.Color(111, 65, 44));
        winesLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winesLabel1.setText("Product Name");
        jPanel76.add(winesLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        winesPrice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        winesPrice1.setForeground(new java.awt.Color(207, 127, 52));
        winesPrice1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winesPrice1.setText("Product Price");
        jPanel76.add(winesPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel76.add(winesStock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        winesAddToCart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        winesAddToCart1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel76.add(winesAddToCart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        winesPanel.add(jPanel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 150, 90));

        jPanel77.setBackground(new java.awt.Color(255, 255, 255));
        jPanel77.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        winesLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        winesLabel2.setForeground(new java.awt.Color(111, 65, 44));
        winesLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winesLabel2.setText("Product Name");
        jPanel77.add(winesLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        winesPrice2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        winesPrice2.setForeground(new java.awt.Color(207, 127, 52));
        winesPrice2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winesPrice2.setText("Product Price");
        jPanel77.add(winesPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel77.add(winesStock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        winesAddToCart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        winesAddToCart2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel77.add(winesAddToCart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        winesPanel.add(jPanel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 150, 90));

        jPanel78.setBackground(new java.awt.Color(255, 255, 255));
        jPanel78.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        winesLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        winesLabel3.setForeground(new java.awt.Color(111, 65, 44));
        winesLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winesLabel3.setText("Product Name");
        jPanel78.add(winesLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        winesPrice3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        winesPrice3.setForeground(new java.awt.Color(207, 127, 52));
        winesPrice3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winesPrice3.setText("Product Price");
        jPanel78.add(winesPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel78.add(winesStock3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        winesAddToCart3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        winesAddToCart3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel78.add(winesAddToCart3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        winesPanel.add(jPanel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 150, 90));

        jPanel79.setBackground(new java.awt.Color(255, 255, 255));
        jPanel79.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        winesLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        winesLabel4.setForeground(new java.awt.Color(111, 65, 44));
        winesLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winesLabel4.setText("Product Name");
        jPanel79.add(winesLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        winesPrice4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        winesPrice4.setForeground(new java.awt.Color(207, 127, 52));
        winesPrice4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winesPrice4.setText("Product Price");
        jPanel79.add(winesPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel79.add(winesStock4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        winesAddToCart4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        winesAddToCart4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel79.add(winesAddToCart4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        winesPanel.add(jPanel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 150, 90));

        jPanel80.setBackground(new java.awt.Color(255, 255, 255));
        jPanel80.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        winesLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        winesLabel8.setForeground(new java.awt.Color(111, 65, 44));
        winesLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winesLabel8.setText("Product Name");
        jPanel80.add(winesLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        winesPrice8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        winesPrice8.setForeground(new java.awt.Color(207, 127, 52));
        winesPrice8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winesPrice8.setText("Product Price");
        jPanel80.add(winesPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel80.add(winesStock8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        winesAddToCart8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        winesAddToCart8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel80.add(winesAddToCart8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        winesPanel.add(jPanel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 430, 150, 90));

        jPanel81.setBackground(new java.awt.Color(255, 255, 255));
        jPanel81.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        winesLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        winesLabel7.setForeground(new java.awt.Color(111, 65, 44));
        winesLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winesLabel7.setText("Product Name");
        jPanel81.add(winesLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        winesPrice7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        winesPrice7.setForeground(new java.awt.Color(207, 127, 52));
        winesPrice7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winesPrice7.setText("Product Price");
        jPanel81.add(winesPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel81.add(winesStock7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        winesAddToCart7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        winesAddToCart7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel81.add(winesAddToCart7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        winesPanel.add(jPanel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 150, 90));

        jPanel82.setBackground(new java.awt.Color(255, 255, 255));
        jPanel82.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        winesLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        winesLabel6.setForeground(new java.awt.Color(111, 65, 44));
        winesLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winesLabel6.setText("Product Name");
        jPanel82.add(winesLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        winesPrice6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        winesPrice6.setForeground(new java.awt.Color(207, 127, 52));
        winesPrice6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winesPrice6.setText("Product Price");
        jPanel82.add(winesPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel82.add(winesStock6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        winesAddToCart6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        winesAddToCart6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel82.add(winesAddToCart6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        winesPanel.add(jPanel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 150, 90));

        jPanel83.setBackground(new java.awt.Color(255, 255, 255));
        jPanel83.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        winesLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        winesLabel5.setForeground(new java.awt.Color(111, 65, 44));
        winesLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winesLabel5.setText("Product Name");
        jPanel83.add(winesLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        winesPrice5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        winesPrice5.setForeground(new java.awt.Color(207, 127, 52));
        winesPrice5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winesPrice5.setText("Product Price");
        jPanel83.add(winesPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));
        jPanel83.add(winesStock5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        winesAddToCart5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        winesAddToCart5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel83.add(winesAddToCart5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        winesPanel.add(jPanel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 150, 90));

        winesSlot1.setBackground(new java.awt.Color(255, 255, 255));
        winesPanel.add(winesSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 150, 120));

        winesSlot2.setBackground(new java.awt.Color(255, 255, 255));
        winesPanel.add(winesSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 150, 120));

        winesSlot3.setBackground(new java.awt.Color(255, 255, 255));
        winesPanel.add(winesSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 150, 120));

        winesSlot4.setBackground(new java.awt.Color(255, 255, 255));
        winesPanel.add(winesSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 150, 120));

        winesSlot5.setBackground(new java.awt.Color(255, 255, 255));
        winesPanel.add(winesSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 150, 120));

        winesSlot6.setBackground(new java.awt.Color(255, 255, 255));
        winesPanel.add(winesSlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 150, 120));

        winesSlot7.setBackground(new java.awt.Color(255, 255, 255));
        winesPanel.add(winesSlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 150, 120));

        winesSlot8.setBackground(new java.awt.Color(255, 255, 255));
        winesPanel.add(winesSlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 310, 150, 120));

        jLayeredPane1.add(winesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1256, -1));

        seaFoodsPanel.setBackground(new java.awt.Color(238, 238, 238));
        seaFoodsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seafoodsTitle.setText("Seafoods");
        seaFoodsPanel.add(seafoodsTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        seafoodsSlot1.setBackground(new java.awt.Color(255, 255, 255));
        seaFoodsPanel.add(seafoodsSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 150, 120));

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seafoodsLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        seafoodsLabel1.setForeground(new java.awt.Color(111, 65, 44));
        seafoodsLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsLabel1.setText("Product Name");
        jPanel36.add(seafoodsLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, -1));

        seafoodsPrice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        seafoodsPrice1.setForeground(new java.awt.Color(207, 127, 52));
        seafoodsPrice1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsPrice1.setText("Product Price");
        jPanel36.add(seafoodsPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 140, -1));
        jPanel36.add(seafoodsStock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        seafoodsAddToCart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        seafoodsAddToCart1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel36.add(seafoodsAddToCart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        seaFoodsPanel.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 150, 90));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seafoodsLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        seafoodsLabel2.setForeground(new java.awt.Color(111, 65, 44));
        seafoodsLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsLabel2.setText("Product Name");
        jPanel37.add(seafoodsLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        seafoodsPrice2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        seafoodsPrice2.setForeground(new java.awt.Color(207, 127, 52));
        seafoodsPrice2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsPrice2.setText("Product Price");
        jPanel37.add(seafoodsPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));
        jPanel37.add(seafoodsStock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        seafoodsAddToCart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        seafoodsAddToCart2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel37.add(seafoodsAddToCart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        seaFoodsPanel.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 150, 90));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel38.add(butcheryStock10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        seafoodsLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        seafoodsLabel3.setForeground(new java.awt.Color(111, 65, 44));
        seafoodsLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsLabel3.setText("Product Name");
        jPanel38.add(seafoodsLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        seafoodsPrice3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        seafoodsPrice3.setForeground(new java.awt.Color(207, 127, 52));
        seafoodsPrice3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsPrice3.setText("Product Price");
        jPanel38.add(seafoodsPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));
        jPanel38.add(seafoodsStock3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        seafoodsAddToCart3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        seafoodsAddToCart3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel38.add(seafoodsAddToCart3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        seaFoodsPanel.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 150, 90));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel39.add(butcheryStock11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        seafoodsLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        seafoodsLabel4.setForeground(new java.awt.Color(111, 65, 44));
        seafoodsLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsLabel4.setText("Product Name");
        jPanel39.add(seafoodsLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        seafoodsPrice4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        seafoodsPrice4.setForeground(new java.awt.Color(207, 127, 52));
        seafoodsPrice4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsPrice4.setText("Product Price");
        jPanel39.add(seafoodsPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));
        jPanel39.add(seafoodsStock4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        seafoodsAddToCart4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        seafoodsAddToCart4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel39.add(seafoodsAddToCart4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        seaFoodsPanel.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 150, 90));

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel40.add(butcheryStock12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        seafoodsLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        seafoodsLabel8.setForeground(new java.awt.Color(111, 65, 44));
        seafoodsLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsLabel8.setText("Product Name");
        jPanel40.add(seafoodsLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        seafoodsPrice8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        seafoodsPrice8.setForeground(new java.awt.Color(207, 127, 52));
        seafoodsPrice8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsPrice8.setText("Product Price");
        jPanel40.add(seafoodsPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));
        jPanel40.add(seafoodsStock8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        seafoodsAddToCart8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        seafoodsAddToCart8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel40.add(seafoodsAddToCart8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        seaFoodsPanel.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 430, 150, 90));

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel41.add(bakeryStock9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        seafoodsLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        seafoodsLabel7.setForeground(new java.awt.Color(111, 65, 44));
        seafoodsLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsLabel7.setText("Product Name");
        jPanel41.add(seafoodsLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        seafoodsPrice7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        seafoodsPrice7.setForeground(new java.awt.Color(207, 127, 52));
        seafoodsPrice7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsPrice7.setText("Product Price");
        jPanel41.add(seafoodsPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));
        jPanel41.add(seafoodsStock7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        seafoodsAddToCart7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        seafoodsAddToCart7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel41.add(seafoodsAddToCart7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        seaFoodsPanel.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 150, 90));

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel42.add(butcheryStock13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        seafoodsLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        seafoodsLabel6.setForeground(new java.awt.Color(111, 65, 44));
        seafoodsLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsLabel6.setText("Product Name");
        jPanel42.add(seafoodsLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        seafoodsPrice6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        seafoodsPrice6.setForeground(new java.awt.Color(207, 127, 52));
        seafoodsPrice6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsPrice6.setText("Product Price");
        jPanel42.add(seafoodsPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));
        jPanel42.add(seafoodsStock6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        seafoodsAddToCart6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        seafoodsAddToCart6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel42.add(seafoodsAddToCart6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        seaFoodsPanel.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 150, 90));

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel43.add(butcheryStock14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        seafoodsLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        seafoodsLabel5.setForeground(new java.awt.Color(111, 65, 44));
        seafoodsLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsLabel5.setText("Product Name");
        jPanel43.add(seafoodsLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        seafoodsPrice5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        seafoodsPrice5.setForeground(new java.awt.Color(207, 127, 52));
        seafoodsPrice5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seafoodsPrice5.setText("Product Price");
        jPanel43.add(seafoodsPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));
        jPanel43.add(seafoodsStock5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, 20));

        seafoodsAddToCart5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart icon.png"))); // NOI18N
        seafoodsAddToCart5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel43.add(seafoodsAddToCart5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        seaFoodsPanel.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 150, 90));

        seafoodsSlot2.setBackground(new java.awt.Color(255, 255, 255));
        seaFoodsPanel.add(seafoodsSlot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 150, 120));

        seafoodsSlot3.setBackground(new java.awt.Color(255, 255, 255));
        seaFoodsPanel.add(seafoodsSlot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 150, 120));

        seafoodsSlot4.setBackground(new java.awt.Color(255, 255, 255));
        seaFoodsPanel.add(seafoodsSlot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 150, 120));

        seafoodsSlot5.setBackground(new java.awt.Color(255, 255, 255));
        seaFoodsPanel.add(seafoodsSlot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 150, 120));

        seafoodsSlot6.setBackground(new java.awt.Color(255, 255, 255));
        seaFoodsPanel.add(seafoodsSlot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 150, 120));

        seafoodsSlot7.setBackground(new java.awt.Color(255, 255, 255));
        seaFoodsPanel.add(seafoodsSlot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 150, 120));

        seafoodsSlot8.setBackground(new java.awt.Color(255, 255, 255));
        seaFoodsPanel.add(seafoodsSlot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 310, 150, 120));

        jLayeredPane1.add(seaFoodsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, -1, 1250, 550));

        cartPanel.setBackground(new java.awt.Color(243, 243, 243));
        cartPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setText("YOU ARE NOW IN CART PANEL");
        cartPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLayeredPane1.add(cartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 553));

        paymentOptionsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/payment supported icon.png"))); // NOI18N
        paymentOptionsPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1260, -1));

        jLayeredPane1.add(paymentOptionsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1260, 550));

        jLabel23.setText("Privacy and Policy Panel");

        javax.swing.GroupLayout privacyPolicyPanelLayout = new javax.swing.GroupLayout(privacyPolicyPanel);
        privacyPolicyPanel.setLayout(privacyPolicyPanelLayout);
        privacyPolicyPanelLayout.setHorizontalGroup(
            privacyPolicyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(privacyPolicyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap(1126, Short.MAX_VALUE))
        );
        privacyPolicyPanelLayout.setVerticalGroup(
            privacyPolicyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(privacyPolicyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap(518, Short.MAX_VALUE))
        );

        jLayeredPane1.add(privacyPolicyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 540));

        jLabel24.setText("HOLLA");

        javax.swing.GroupLayout faqsPanelLayout = new javax.swing.GroupLayout(faqsPanel);
        faqsPanel.setLayout(faqsPanelLayout);
        faqsPanelLayout.setHorizontalGroup(
            faqsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(faqsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addContainerGap(1096, Short.MAX_VALUE))
        );
        faqsPanelLayout.setVerticalGroup(
            faqsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(faqsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addContainerGap(528, Short.MAX_VALUE))
        );

        jLayeredPane1.add(faqsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 550));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cozy crate developers.png"))); // NOI18N

        javax.swing.GroupLayout aboutUsPanelLayout = new javax.swing.GroupLayout(aboutUsPanel);
        aboutUsPanel.setLayout(aboutUsPanelLayout);
        aboutUsPanelLayout.setHorizontalGroup(
            aboutUsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutUsPanelLayout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(19, 19, 19))
        );
        aboutUsPanelLayout.setVerticalGroup(
            aboutUsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutUsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(40, 40, 40))
        );

        jLayeredPane1.add(aboutUsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 550));

        accountPanel.setBackground(new java.awt.Color(243, 243, 243));
        accountPanel.setForeground(new java.awt.Color(102, 102, 102));
        accountPanel.setOpaque(false);
        accountPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accountContainerPanel.setBackground(new java.awt.Color(243, 243, 243));
        accountContainerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(48, 48, 48));
        jLabel19.setText("MY PROFILE");
        accountContainerPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 50));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Email");
        accountContainerPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel25.setText("Manage your very cozy account");
        accountContainerPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Date of Birth");
        accountContainerPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, -1, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Full Name");
        accountContainerPanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Full Name");
        accountContainerPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Gender");
        accountContainerPanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, 30));

        maleGenderButton.setBackground(new java.awt.Color(243, 243, 243));
        buttonGroup1.add(maleGenderButton);
        maleGenderButton.setText("Male");
        maleGenderButton.setBorder(null);
        maleGenderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maleGenderButton.setFocusable(false);
        maleGenderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleGenderButtonActionPerformed(evt);
            }
        });
        accountContainerPanel.add(maleGenderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 50, 20));

        otherGenderButton.setBackground(new java.awt.Color(243, 243, 243));
        buttonGroup1.add(otherGenderButton);
        otherGenderButton.setText("Other");
        otherGenderButton.setBorder(null);
        otherGenderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        otherGenderButton.setFocusable(false);
        otherGenderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherGenderButtonActionPerformed(evt);
            }
        });
        accountContainerPanel.add(otherGenderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 60, 20));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Phone Number");
        accountContainerPanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        femaleGenderButton.setBackground(new java.awt.Color(243, 243, 243));
        buttonGroup1.add(femaleGenderButton);
        femaleGenderButton.setText("Female");
        femaleGenderButton.setBorder(null);
        femaleGenderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        femaleGenderButton.setFocusable(false);
        femaleGenderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleGenderButtonActionPerformed(evt);
            }
        });
        accountContainerPanel.add(femaleGenderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 60, 20));

        selectImageButton.setBackground(new java.awt.Color(243, 243, 243));
        selectImageButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectImageButton.setForeground(new java.awt.Color(51, 51, 51));
        selectImageButton.setText("Select Image");
        selectImageButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectImageButton.setFocusable(false);
        selectImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectImageButtonActionPerformed(evt);
            }
        });
        accountContainerPanel.add(selectImageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, 150, 40));

        fullNameHolder.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        accountContainerPanel.add(fullNameHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 340, 40));

        emailHolder.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        emailHolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailHolderActionPerformed(evt);
            }
        });
        accountContainerPanel.add(emailHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 340, 40));

        logoutButton.setBackground(new java.awt.Color(159, 133, 85));
        logoutButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Log out");
        logoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        accountContainerPanel.add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 500, 106, 38));

        imageProfileHolder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        accountContainerPanel.add(imageProfileHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 110, 150, 140));

        addAddressLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addAddressLabel.setForeground(new java.awt.Color(51, 51, 255));
        addAddressLabel.setText("Add+");
        addAddressLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addAddressLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addAddressLabelMouseClicked(evt);
            }
        });
        accountContainerPanel.add(addAddressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, -1, 30));

        saveButton.setBackground(new java.awt.Color(159, 133, 85));
        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save");
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveButton.setFocusable(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        accountContainerPanel.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, 106, 38));

        yearChooser.setBackground(new java.awt.Color(255, 255, 254));
        yearChooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year", "2025", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900" }));
        yearChooser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yearChooser.setFocusable(false);
        yearChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearChooserActionPerformed(evt);
            }
        });
        accountContainerPanel.add(yearChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 110, 40));

        dateChooser.setBackground(new java.awt.Color(255, 255, 254));
        dateChooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Date", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));
        dateChooser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dateChooser.setFocusable(false);
        dateChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateChooserActionPerformed(evt);
            }
        });
        accountContainerPanel.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 110, 40));

        monthChooser.setBackground(new java.awt.Color(255, 255, 254));
        monthChooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", " " }));
        monthChooser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        monthChooser.setFocusable(false);
        monthChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthChooserActionPerformed(evt);
            }
        });
        accountContainerPanel.add(monthChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 110, 40));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/line seperator 1.png"))); // NOI18N
        accountContainerPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, -1, -1));
        accountContainerPanel.add(addressReader, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 540, 20));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Address");
        accountContainerPanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, -1));

        phoneNumberHolder.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        phoneNumberHolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberHolderActionPerformed(evt);
            }
        });
        accountContainerPanel.add(phoneNumberHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 340, 40));

        accountPanel.add(accountContainerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 550));

        jLayeredPane1.add(accountPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 553));

        jPanel92.setBackground(new java.awt.Color(228, 166, 107));
        jPanel92.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/facebook icon.png"))); // NOI18N
        jPanel92.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 50, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pinterest icon.png"))); // NOI18N
        jPanel92.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 50, -1, 50));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/instagram icon.png"))); // NOI18N
        jPanel92.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 50, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/follow us on icon.png"))); // NOI18N
        jPanel92.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 10, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/motto icon.png"))); // NOI18N
        jPanel92.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 470, 70));

        paymentOptionsLabel.setBackground(new java.awt.Color(185, 85, 0));
        paymentOptionsLabel.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        paymentOptionsLabel.setForeground(new java.awt.Color(101, 13, 2));
        paymentOptionsLabel.setText("We Accept");
        paymentOptionsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paymentOptionsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paymentOptionsMouseExited(evt);
            }
        });
        jPanel92.add(paymentOptionsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("@Group4FinalProject - All rights reserved");
        jPanel92.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, -1, -1));

        aboutUsLabel.setBackground(new java.awt.Color(185, 85, 0));
        aboutUsLabel.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        aboutUsLabel.setForeground(new java.awt.Color(101, 13, 2));
        aboutUsLabel.setText("Developers");
        aboutUsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aboutUsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutUsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutUsMouseExited(evt);
            }
        });
        jPanel92.add(aboutUsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));

        FAQsLabel.setBackground(new java.awt.Color(185, 85, 0));
        FAQsLabel.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        FAQsLabel.setForeground(new java.awt.Color(101, 13, 2));
        FAQsLabel.setText("Delivery Partners");
        FAQsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FAQsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FAQsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FAQsMouseExited(evt);
            }
        });
        jPanel92.add(FAQsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, -1, -1));

        privacyPolicyLabel.setBackground(new java.awt.Color(185, 85, 0));
        privacyPolicyLabel.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        privacyPolicyLabel.setForeground(new java.awt.Color(101, 13, 2));
        privacyPolicyLabel.setText("Privacy & Policy");
        privacyPolicyLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        privacyPolicyLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                privacyPolicyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                privacyPolicyMouseExited(evt);
            }
        });
        jPanel92.add(privacyPolicyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel92, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sidebarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel92, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private JButton selectedButton = null;
    private boolean isClicked = false;

    public void resetAllButtons() {
        JButton[] buttons = {
            bakeryButton,
            butcheryButton,
            seafoodsButton,
            readyMealsButton,
            vegetableButton,
            fruitsButton,
            snacksButton,
            iceCreamButton,
            beveragesButton
        // add all your sidebar buttons here
        };

        for (JButton btn : buttons) {
            btn.setBackground(Color.WHITE);
            btn.setForeground(Color.BLACK);
            btn.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); // default border
        }

        selectedButton = null; // remove any selected state
    }

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

    private void readyMealsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readyMealsButtonActionPerformed
        selectButton(readyMealsButton);
        addLeftGreenColor(readyMealsButton);
        hideAllPanels();
        readyMealsPanel.setVisible(true);
    }//GEN-LAST:event_readyMealsButtonActionPerformed

    private void vegetableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vegetableButtonActionPerformed
        selectButton(vegetableButton);
        addLeftGreenColor(vegetableButton);
        hideAllPanels();
        vegetablesPanel.setVisible(true);
    }//GEN-LAST:event_vegetableButtonActionPerformed

    private void fruitsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fruitsButtonActionPerformed
        selectButton(fruitsButton);
        addLeftGreenColor(fruitsButton);
        hideAllPanels();
        fruitsPanel.setVisible(true);
    }//GEN-LAST:event_fruitsButtonActionPerformed

    private void snacksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snacksButtonActionPerformed
        selectButton(snacksButton);
        addLeftGreenColor(snacksButton);
        hideAllPanels();
        snacksPanel.setVisible(true);
    }//GEN-LAST:event_snacksButtonActionPerformed

    private void iceCreamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iceCreamButtonActionPerformed
        selectButton(iceCreamButton);
        addLeftGreenColor(iceCreamButton);
        hideAllPanels();
        dessertsPanel.setVisible(true);
    }//GEN-LAST:event_iceCreamButtonActionPerformed

    private void beveragesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beveragesButtonActionPerformed
        selectButton(beveragesButton);
        addLeftGreenColor(beveragesButton);
        hideAllPanels();
        winesPanel.setVisible(true);
    }//GEN-LAST:event_beveragesButtonActionPerformed

    private void aboutUsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsMouseEntered
        aboutUsLabel.setForeground(new Color(255, 255, 255));
        aboutUsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_aboutUsMouseEntered

    private void aboutUsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsMouseExited
        aboutUsLabel.setForeground(new Color(101, 13, 2));
    }//GEN-LAST:event_aboutUsMouseExited

    private void FAQsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FAQsMouseEntered
        FAQsLabel.setForeground(new Color(255, 255, 255));
        FAQsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_FAQsMouseEntered

    private void FAQsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FAQsMouseExited
        FAQsLabel.setForeground(new Color(101, 13, 2));
    }//GEN-LAST:event_FAQsMouseExited

    private void privacyPolicyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_privacyPolicyMouseEntered
        privacyPolicyLabel.setForeground(new Color(255, 255, 255));
        privacyPolicyLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_privacyPolicyMouseEntered

    private void privacyPolicyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_privacyPolicyMouseExited
        privacyPolicyLabel.setForeground(new Color(101, 13, 2));
    }//GEN-LAST:event_privacyPolicyMouseExited

    private void paymentOptionsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentOptionsMouseEntered
        paymentOptionsLabel.setForeground(new Color(255, 255, 255));
        paymentOptionsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_paymentOptionsMouseEntered

    private void paymentOptionsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentOptionsMouseExited
        paymentOptionsLabel.setForeground(new Color(101, 13, 2));
    }//GEN-LAST:event_paymentOptionsMouseExited

    private void bakeryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bakeryButtonMouseEntered
        bakeryButton.setBackground(new Color(242, 242, 243));
        bakeryButton.setForeground(new Color(110, 66, 39));
        bakeryButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_bakeryButtonMouseEntered

    private void bakeryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bakeryButtonMouseExited
        if (selectedButton != bakeryButton) {
            // Only reset if this button is NOT the selected one
            bakeryButton.setBackground(Color.WHITE);
            bakeryButton.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_bakeryButtonMouseExited
    //////
    private void butcheryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcheryButtonMouseEntered
            butcheryButton.setBackground(new Color(242, 242, 243));
            butcheryButton.setForeground(new Color(110, 66, 39));
            butcheryButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_butcheryButtonMouseEntered

    private void butcheryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcheryButtonMouseExited
        if (selectedButton != butcheryButton) {
            // Only reset if this button is NOT the selected one
            butcheryButton.setBackground(Color.WHITE);
            butcheryButton.setForeground(Color.BLACK);
        }    }//GEN-LAST:event_butcheryButtonMouseExited

    private void seafoodsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seafoodsButtonMouseEntered
        seafoodsButton.setBackground(new Color(242, 242, 243));
        seafoodsButton.setForeground(new Color(110, 66, 39));
        seafoodsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_seafoodsButtonMouseEntered

    private void seafoodsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seafoodsButtonMouseExited
        if (selectedButton != seafoodsButton) {
            // Only reset if this button is NOT the selected one
            seafoodsButton.setBackground(Color.WHITE);
            seafoodsButton.setForeground(Color.BLACK);
        }    }//GEN-LAST:event_seafoodsButtonMouseExited

    private void readyMealsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readyMealsButtonMouseEntered
        readyMealsButton.setBackground(new Color(242, 242, 243));
        readyMealsButton.setForeground(new Color(110, 66, 39));
        readyMealsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));    }//GEN-LAST:event_readyMealsButtonMouseEntered

    private void readyMealsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readyMealsButtonMouseExited
        if (selectedButton != readyMealsButton) {
            // Only reset if this button is NOT the selected one
            readyMealsButton.setBackground(Color.WHITE);
            readyMealsButton.setForeground(Color.BLACK);
        }    }//GEN-LAST:event_readyMealsButtonMouseExited

    private void vegetableButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vegetableButtonMouseEntered
        vegetableButton.setBackground(new Color(242, 242, 243));
        vegetableButton.setForeground(new Color(110, 66, 39));
        vegetableButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));    }//GEN-LAST:event_vegetableButtonMouseEntered

    private void vegetableButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vegetableButtonMouseExited
        if (selectedButton != vegetableButton) {
            // Only reset if this button is NOT the selected one
            vegetableButton.setBackground(Color.WHITE);
            vegetableButton.setForeground(Color.BLACK);
        }    }//GEN-LAST:event_vegetableButtonMouseExited

    private void fruitsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fruitsButtonMouseEntered
        fruitsButton.setBackground(new Color(242, 242, 243));
        fruitsButton.setForeground(new Color(110, 66, 39));
        fruitsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));    }//GEN-LAST:event_fruitsButtonMouseEntered

    private void fruitsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fruitsButtonMouseExited
        if (selectedButton != fruitsButton) {
            // Only reset if this button is NOT the selected one
            fruitsButton.setBackground(Color.WHITE);
            fruitsButton.setForeground(Color.BLACK);
        }    }//GEN-LAST:event_fruitsButtonMouseExited

    private void snacksButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_snacksButtonMouseEntered
        snacksButton.setBackground(new Color(242, 242, 243));
        snacksButton.setForeground(new Color(110, 66, 39));
        snacksButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));    }//GEN-LAST:event_snacksButtonMouseEntered

    private void snacksButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_snacksButtonMouseExited
        if (selectedButton != snacksButton) {
            // Only reset if this button is NOT the selected one
            snacksButton.setBackground(Color.WHITE);
            snacksButton.setForeground(Color.BLACK);
        }    }//GEN-LAST:event_snacksButtonMouseExited

    private void iceCreamButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iceCreamButtonMouseEntered
        iceCreamButton.setBackground(new Color(242, 242, 243));
        iceCreamButton.setForeground(new Color(110, 66, 39));
        iceCreamButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));    }//GEN-LAST:event_iceCreamButtonMouseEntered

    private void iceCreamButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iceCreamButtonMouseExited
        if (selectedButton != iceCreamButton) {
            // Only reset if this button is NOT the selected one
            iceCreamButton.setBackground(Color.WHITE);
            iceCreamButton.setForeground(Color.BLACK);
        }    }//GEN-LAST:event_iceCreamButtonMouseExited

    private void beveragesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beveragesButtonMouseEntered
        beveragesButton.setBackground(new Color(242, 242, 243));
        beveragesButton.setForeground(new Color(110, 66, 39));
        beveragesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));    }//GEN-LAST:event_beveragesButtonMouseEntered

    private void beveragesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beveragesButtonMouseExited
        if (selectedButton != beveragesButton) {
            // Only reset if this button is NOT the selected one
            beveragesButton.setBackground(Color.WHITE);
            beveragesButton.setForeground(Color.BLACK);
        }    }//GEN-LAST:event_beveragesButtonMouseExited

    private void shopNowButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shopNowButtonMouseEntered
        shopNowButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_shopNowButtonMouseEntered

    private void gotoLoginImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gotoLoginImageMouseEntered
        gotoLoginButton.setForeground(new Color(101, 13, 2));
    }//GEN-LAST:event_gotoLoginImageMouseEntered

    private void gotoLoginImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gotoLoginImageMouseExited
        gotoLoginButton.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_gotoLoginImageMouseExited

    private void gotoRegisterImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gotoRegisterImageMouseEntered
        gotoRegisterButton.setForeground(new Color(101, 13, 2));
    }//GEN-LAST:event_gotoRegisterImageMouseEntered

    private void gotoRegisterImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gotoRegisterImageMouseExited
        gotoRegisterButton.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_gotoRegisterImageMouseExited

    private void myCartImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myCartImageMouseEntered
        myCartButton.setForeground(new Color(101, 13, 2));
    }//GEN-LAST:event_myCartImageMouseEntered

    private void myCartImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myCartImageMouseExited
        myCartButton.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_myCartImageMouseExited

    private void otherGenderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherGenderButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otherGenderButtonActionPerformed

    private void maleGenderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleGenderButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleGenderButtonActionPerformed

    private void femaleGenderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleGenderButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleGenderButtonActionPerformed

    private void emailHolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailHolderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailHolderActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        String email = emailHolder.getText(); // or keep track of logged-in email
        dbManager.logoutUser(email);         // sets is_logged_in = 0 in DB

        // Close current DashboardFrame
        this.dispose();

        // Show LoginFrame again
        TestLoginFrame login = new TestLoginFrame();
        login.setVisible(true);

    }//GEN-LAST:event_logoutButtonActionPerformed

    private File selectedFile;

    private void selectImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectImageButtonActionPerformed

        String email = emailHolder.getText().trim();
        JFileChooser imgSelector = new JFileChooser();
        imgSelector.setDialogTitle("Select Product Image");

        imgSelector.setAcceptAllFileFilterUsed(false);
        imgSelector.addChoosableFileFilter(
                new javax.swing.filechooser.FileNameExtensionFilter("Image Files (.png, .jpg)", "png", "jpg")
        );

        int result = imgSelector.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = imgSelector.getSelectedFile();
            String fileName = selectedFile.getName().toLowerCase();

            if (!fileName.endsWith(".png") && !fileName.endsWith(".jpg")) {
                JOptionPane.showMessageDialog(this, "Only PNG and JPG images are allowed");
                return;
            }

            // 1️⃣ Show preview immediately
            ImageIcon previewIcon = new ImageIcon(
                    new ImageIcon(selectedFile.getAbsolutePath())
                            .getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)
            );
            imageProfileHolder.setIcon(previewIcon);

            try {
                // 2️⃣ Ensure folder exists
                File imagesDir = new File("profile images");
                if (!imagesDir.exists()) {
                    imagesDir.mkdir();
                }

                // 3️⃣ Copy file to "profile images" folder
                File destFile = new File(imagesDir, selectedFile.getName());
                Files.copy(selectedFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // 4️⃣ Save the **absolute path** in DB
                dbManager.setProfileImage(destFile.getAbsolutePath(), email);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving image: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_selectImageButtonActionPerformed

    private void dateChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateChooserActionPerformed
        if (dateChooser.getSelectedIndex() == 0) {
            dateChooser.setForeground(Color.GRAY);
        } else {
            dateChooser.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_dateChooserActionPerformed

    private void monthChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthChooserActionPerformed
        if (monthChooser.getSelectedIndex() == 0) {
            monthChooser.setForeground(Color.GRAY);
        } else {
            monthChooser.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_monthChooserActionPerformed

    private void yearChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearChooserActionPerformed
        if (yearChooser.getSelectedIndex() == 0) {
            yearChooser.setForeground(Color.GRAY);
        } else {
            yearChooser.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_yearChooserActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String fullName = fullNameHolder.getText().toString().trim();
        String email = emailHolder.getText().toString().trim();
        String phoneNumber = phoneNumberHolder.getText().toString().trim();

        String day = dateChooser.getSelectedItem().toString();
        String month = monthChooser.getSelectedItem().toString();
        String year = yearChooser.getSelectedItem().toString();

        if (maleGenderButton.isSelected()) {
            dbManager.setGender("m", email);
        } else if (femaleGenderButton.isSelected()) {
            dbManager.setGender("f", email);
        } else if (otherGenderButton.isSelected()) {
            dbManager.setGender("o", email);
        }

        String monthNumber = switch (month) {
            case "January" ->
                "01";
            case "February" ->
                "02";
            case "March" ->
                "03";
            case "April" ->
                "04";
            case "May" ->
                "05";
            case "June" ->
                "06";
            case "July" ->
                "07";
            case "August" ->
                "08";
            case "September" ->
                "09";
            case "October" ->
                "10";
            case "November" ->
                "11";
            case "December" ->
                "12";
            default ->
                "01";
        };

        if (day.length() == 1) {
            day = "0" + day;
        }

        String birthdate = year + "-" + monthNumber + "-" + day;
        dbManager.insertBirthdate(birthdate, email);
        dbManager.insertPhoneNumber(phoneNumber, email);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void addAddressLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAddressLabelMouseClicked
        AddressDialog s = new AddressDialog(this, true, checkoutFrame);
        s.setVisible(true);
    }//GEN-LAST:event_addAddressLabelMouseClicked

    private void bakeryLandingIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bakeryLandingIconMouseClicked
        hideAllPanels();
        bakeryPanel.setVisible(true);
    }//GEN-LAST:event_bakeryLandingIconMouseClicked

    private void butcheryLandingIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcheryLandingIconMouseClicked
        hideAllPanels();
        butcheryPanel.setVisible(true);
    }//GEN-LAST:event_butcheryLandingIconMouseClicked

    private void seafoodsLandingIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seafoodsLandingIconMouseClicked
        hideAllPanels();
        seaFoodsPanel.setVisible(true);
    }//GEN-LAST:event_seafoodsLandingIconMouseClicked

    private void readyMealsLandingIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readyMealsLandingIconMouseClicked
        hideAllPanels();
        readyMealsPanel.setVisible(true);
    }//GEN-LAST:event_readyMealsLandingIconMouseClicked

    private void vegetablesLandingIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vegetablesLandingIconMouseClicked
        hideAllPanels();
        vegetablesPanel.setVisible(true);
    }//GEN-LAST:event_vegetablesLandingIconMouseClicked

    private void fruitsLandingIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fruitsLandingIconMouseClicked
        hideAllPanels();
        fruitsPanel.setVisible(true);
    }//GEN-LAST:event_fruitsLandingIconMouseClicked

    private void snakcsLandingIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_snakcsLandingIconMouseClicked
        hideAllPanels();
        snacksPanel.setVisible(true);
    }//GEN-LAST:event_snakcsLandingIconMouseClicked

    private void dessertsLandingIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dessertsLandingIconMouseClicked
        hideAllPanels();
        dessertsPanel.setVisible(true);
    }//GEN-LAST:event_dessertsLandingIconMouseClicked

    private void phoneNumberHolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberHolderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberHolderActionPerformed

    private void newProductsLandingIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newProductsLandingIconMouseClicked
        hideAllPanels();
        newProductsPanel.setVisible(true);
    }//GEN-LAST:event_newProductsLandingIconMouseClicked

    public void selectButton(JButton btn) {
        if (selectedButton != null) {
            selectedButton.setBackground(Color.WHITE);
            selectedButton.setForeground(Color.black);
            selectedButton.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, new Color(255, 255, 254)));
            selectedButton.setBorder(BorderFactory.createCompoundBorder(null, BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        }

        btn.setBackground(new Color(242, 242, 243));
        btn.setForeground(new Color(110, 66, 39));
        selectedButton = btn;
    }

    private void addLeftGreenColor(JButton btn) {
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 3, 0, 0, new Color(228, 166, 107)),
                BorderFactory.createEmptyBorder(0, 20, 0, 0)
        ));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FAQsLabel;
    private javax.swing.JLabel aboutUsLabel;
    private javax.swing.JPanel aboutUsPanel;
    private javax.swing.JPanel accountContainerPanel;
    private static javax.swing.JPanel accountPanel;
    private javax.swing.JLabel addAddressLabel;
    public static javax.swing.JLabel addressReader;
    private javax.swing.JLabel bakeryAddToCart1;
    private javax.swing.JLabel bakeryAddToCart2;
    private javax.swing.JLabel bakeryAddToCart3;
    private javax.swing.JLabel bakeryAddToCart4;
    private javax.swing.JLabel bakeryAddToCart5;
    private javax.swing.JLabel bakeryAddToCart6;
    private javax.swing.JLabel bakeryAddToCart7;
    private javax.swing.JLabel bakeryAddToCart8;
    private javax.swing.JButton bakeryButton;
    public static javax.swing.JLabel bakeryLabel1;
    public static javax.swing.JLabel bakeryLabel2;
    public static javax.swing.JLabel bakeryLabel3;
    public static javax.swing.JLabel bakeryLabel4;
    public static javax.swing.JLabel bakeryLabel5;
    public static javax.swing.JLabel bakeryLabel6;
    public static javax.swing.JLabel bakeryLabel7;
    public static javax.swing.JLabel bakeryLabel8;
    private javax.swing.JLabel bakeryLandingIcon;
    private javax.swing.JPanel bakeryPanel;
    public static javax.swing.JLabel bakeryPrice1;
    public static javax.swing.JLabel bakeryPrice2;
    public static javax.swing.JLabel bakeryPrice3;
    public static javax.swing.JLabel bakeryPrice4;
    public static javax.swing.JLabel bakeryPrice5;
    public static javax.swing.JLabel bakeryPrice6;
    public static javax.swing.JLabel bakeryPrice7;
    public static javax.swing.JLabel bakeryPrice8;
    public static javax.swing.JLabel bakerySlot1;
    public static javax.swing.JLabel bakerySlot2;
    public static javax.swing.JLabel bakerySlot3;
    public static javax.swing.JLabel bakerySlot4;
    public static javax.swing.JLabel bakerySlot5;
    public static javax.swing.JLabel bakerySlot6;
    public static javax.swing.JLabel bakerySlot7;
    public static javax.swing.JLabel bakerySlot8;
    private javax.swing.JLabel bakeryStock1;
    private javax.swing.JLabel bakeryStock2;
    private javax.swing.JLabel bakeryStock3;
    private javax.swing.JLabel bakeryStock4;
    private javax.swing.JLabel bakeryStock5;
    private javax.swing.JLabel bakeryStock6;
    private javax.swing.JLabel bakeryStock7;
    private javax.swing.JLabel bakeryStock8;
    private javax.swing.JLabel bakeryStock9;
    private javax.swing.JButton beveragesButton;
    private javax.swing.JLabel butcheryAddToCart1;
    private javax.swing.JLabel butcheryAddToCart2;
    private javax.swing.JLabel butcheryAddToCart3;
    private javax.swing.JLabel butcheryAddToCart4;
    private javax.swing.JLabel butcheryAddToCart5;
    private javax.swing.JLabel butcheryAddToCart6;
    private javax.swing.JLabel butcheryAddToCart7;
    private javax.swing.JLabel butcheryAddToCart8;
    private javax.swing.JButton butcheryButton;
    public static javax.swing.JLabel butcheryLabel1;
    public static javax.swing.JLabel butcheryLabel2;
    public static javax.swing.JLabel butcheryLabel3;
    public static javax.swing.JLabel butcheryLabel4;
    public static javax.swing.JLabel butcheryLabel5;
    public static javax.swing.JLabel butcheryLabel6;
    public static javax.swing.JLabel butcheryLabel7;
    public static javax.swing.JLabel butcheryLabel8;
    private javax.swing.JLabel butcheryLandingIcon;
    private javax.swing.JPanel butcheryPanel;
    public static javax.swing.JLabel butcheryPrice1;
    public static javax.swing.JLabel butcheryPrice2;
    public static javax.swing.JLabel butcheryPrice3;
    public static javax.swing.JLabel butcheryPrice4;
    public static javax.swing.JLabel butcheryPrice5;
    public static javax.swing.JLabel butcheryPrice6;
    public static javax.swing.JLabel butcheryPrice7;
    public static javax.swing.JLabel butcheryPrice8;
    public static javax.swing.JLabel butcherySlot1;
    public static javax.swing.JLabel butcherySlot2;
    public static javax.swing.JLabel butcherySlot3;
    public static javax.swing.JLabel butcherySlot4;
    public static javax.swing.JLabel butcherySlot5;
    public static javax.swing.JLabel butcherySlot6;
    public static javax.swing.JLabel butcherySlot7;
    public static javax.swing.JLabel butcherySlot8;
    private javax.swing.JLabel butcheryStock1;
    private javax.swing.JLabel butcheryStock10;
    private javax.swing.JLabel butcheryStock11;
    private javax.swing.JLabel butcheryStock12;
    private javax.swing.JLabel butcheryStock13;
    private javax.swing.JLabel butcheryStock14;
    private javax.swing.JLabel butcheryStock2;
    private javax.swing.JLabel butcheryStock3;
    private javax.swing.JLabel butcheryStock4;
    private javax.swing.JLabel butcheryStock5;
    private javax.swing.JLabel butcheryStock6;
    private javax.swing.JLabel butcheryStock7;
    private javax.swing.JLabel butcheryStock8;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel cartPanel;
    private javax.swing.JComboBox<String> dateChooser;
    private javax.swing.JLabel dessertsAddToCart1;
    private javax.swing.JLabel dessertsAddToCart2;
    private javax.swing.JLabel dessertsAddToCart3;
    private javax.swing.JLabel dessertsAddToCart4;
    private javax.swing.JLabel dessertsAddToCart5;
    private javax.swing.JLabel dessertsAddToCart6;
    private javax.swing.JLabel dessertsAddToCart7;
    private javax.swing.JLabel dessertsAddToCart8;
    public static javax.swing.JLabel dessertsLabel1;
    public static javax.swing.JLabel dessertsLabel2;
    public static javax.swing.JLabel dessertsLabel3;
    public static javax.swing.JLabel dessertsLabel4;
    public static javax.swing.JLabel dessertsLabel5;
    public static javax.swing.JLabel dessertsLabel6;
    public static javax.swing.JLabel dessertsLabel7;
    public static javax.swing.JLabel dessertsLabel8;
    private javax.swing.JLabel dessertsLandingIcon;
    private javax.swing.JPanel dessertsPanel;
    public static javax.swing.JLabel dessertsPrice1;
    public static javax.swing.JLabel dessertsPrice2;
    public static javax.swing.JLabel dessertsPrice3;
    public static javax.swing.JLabel dessertsPrice4;
    public static javax.swing.JLabel dessertsPrice5;
    public static javax.swing.JLabel dessertsPrice6;
    public static javax.swing.JLabel dessertsPrice7;
    public static javax.swing.JLabel dessertsPrice8;
    public static javax.swing.JLabel dessertsSlot1;
    public static javax.swing.JLabel dessertsSlot2;
    public static javax.swing.JLabel dessertsSlot3;
    public static javax.swing.JLabel dessertsSlot4;
    public static javax.swing.JLabel dessertsSlot5;
    public static javax.swing.JLabel dessertsSlot6;
    public static javax.swing.JLabel dessertsSlot7;
    public static javax.swing.JLabel dessertsSlot8;
    private javax.swing.JLabel dessertsStock1;
    private javax.swing.JLabel dessertsStock2;
    private javax.swing.JLabel dessertsStock3;
    private javax.swing.JLabel dessertsStock4;
    private javax.swing.JLabel dessertsStock5;
    private javax.swing.JLabel dessertsStock6;
    private javax.swing.JLabel dessertsStock7;
    private javax.swing.JLabel dessertsStock8;
    public static javax.swing.JTextField emailHolder;
    private javax.swing.JPanel faqsPanel;
    private javax.swing.JRadioButton femaleGenderButton;
    private javax.swing.JLabel fruitsAddToCart1;
    private javax.swing.JLabel fruitsAddToCart2;
    private javax.swing.JLabel fruitsAddToCart3;
    private javax.swing.JLabel fruitsAddToCart4;
    private javax.swing.JLabel fruitsAddToCart5;
    private javax.swing.JLabel fruitsAddToCart6;
    private javax.swing.JLabel fruitsAddToCart7;
    private javax.swing.JLabel fruitsAddToCart8;
    private javax.swing.JButton fruitsButton;
    public static javax.swing.JLabel fruitsLabel1;
    public static javax.swing.JLabel fruitsLabel2;
    public static javax.swing.JLabel fruitsLabel3;
    public static javax.swing.JLabel fruitsLabel4;
    public static javax.swing.JLabel fruitsLabel5;
    public static javax.swing.JLabel fruitsLabel6;
    public static javax.swing.JLabel fruitsLabel7;
    public static javax.swing.JLabel fruitsLabel8;
    private javax.swing.JLabel fruitsLandingIcon;
    private javax.swing.JPanel fruitsPanel;
    public static javax.swing.JLabel fruitsPrice1;
    public static javax.swing.JLabel fruitsPrice2;
    public static javax.swing.JLabel fruitsPrice3;
    public static javax.swing.JLabel fruitsPrice4;
    public static javax.swing.JLabel fruitsPrice5;
    public static javax.swing.JLabel fruitsPrice6;
    public static javax.swing.JLabel fruitsPrice7;
    public static javax.swing.JLabel fruitsPrice8;
    public static javax.swing.JLabel fruitsSlot1;
    public static javax.swing.JLabel fruitsSlot2;
    public static javax.swing.JLabel fruitsSlot3;
    public static javax.swing.JLabel fruitsSlot4;
    public static javax.swing.JLabel fruitsSlot5;
    public static javax.swing.JLabel fruitsSlot6;
    public static javax.swing.JLabel fruitsSlot7;
    public static javax.swing.JLabel fruitsSlot8;
    private javax.swing.JLabel fruitsStock1;
    private javax.swing.JLabel fruitsStock2;
    private javax.swing.JLabel fruitsStock3;
    private javax.swing.JLabel fruitsStock4;
    private javax.swing.JLabel fruitsStock5;
    private javax.swing.JLabel fruitsStock6;
    private javax.swing.JLabel fruitsStock7;
    private javax.swing.JLabel fruitsStock8;
    private javax.swing.JTextField fullNameHolder;
    private javax.swing.JLabel gotoLandingPanelLogo;
    private javax.swing.JLabel gotoLoginButton;
    public javax.swing.JLabel gotoLoginImage;
    private javax.swing.JLabel gotoRegisterButton;
    private javax.swing.JLabel gotoRegisterImage;
    public static javax.swing.JLabel groceryLabel1;
    public static javax.swing.JLabel groceryLabel2;
    public static javax.swing.JLabel groceryLabel3;
    public static javax.swing.JLabel groceryLabel4;
    public static javax.swing.JLabel groceryLabel5;
    public static javax.swing.JLabel groceryLabel6;
    public static javax.swing.JLabel groceryLabel7;
    public static javax.swing.JLabel groceryLabel8;
    private javax.swing.JPanel groceryPanel;
    public static javax.swing.JLabel groceryPrice1;
    public static javax.swing.JLabel groceryPrice2;
    public static javax.swing.JLabel groceryPrice3;
    public static javax.swing.JLabel groceryPrice4;
    public static javax.swing.JLabel groceryPrice5;
    public static javax.swing.JLabel groceryPrice6;
    public static javax.swing.JLabel groceryPrice7;
    public static javax.swing.JLabel groceryPrice8;
    public static javax.swing.JLabel grocerySlot1;
    public static javax.swing.JLabel grocerySlot2;
    public static javax.swing.JLabel grocerySlot3;
    public static javax.swing.JLabel grocerySlot4;
    public static javax.swing.JLabel grocerySlot5;
    public static javax.swing.JLabel grocerySlot6;
    public static javax.swing.JLabel grocerySlot7;
    public static javax.swing.JLabel grocerySlot8;
    private javax.swing.JLabel groceryStock1;
    private javax.swing.JLabel groceryStock11;
    private javax.swing.JLabel groceryStock12;
    private javax.swing.JLabel groceryStock13;
    private javax.swing.JLabel groceryStock14;
    private javax.swing.JLabel groceryStock15;
    private javax.swing.JLabel groceryStock16;
    private javax.swing.JLabel groceryStock2;
    private javax.swing.JLabel groceryStock3;
    private javax.swing.JLabel groceryStock4;
    private javax.swing.JLabel groceryStock5;
    private javax.swing.JLabel groceryStock6;
    private javax.swing.JLabel groceryStock7;
    private javax.swing.JLabel groceryStock8;
    private javax.swing.JButton iceCreamButton;
    private javax.swing.JLabel imageProfileHolder;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel landingPanel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JRadioButton maleGenderButton;
    private javax.swing.JComboBox<String> monthChooser;
    private javax.swing.JLabel myCartButton;
    private javax.swing.JLabel myCartImage;
    private javax.swing.JLabel newProductsAddToCart1;
    private javax.swing.JLabel newProductsAddToCart2;
    private javax.swing.JLabel newProductsAddToCart3;
    private javax.swing.JLabel newProductsAddToCart4;
    private javax.swing.JLabel newProductsAddToCart5;
    private javax.swing.JLabel newProductsAddToCart57;
    private javax.swing.JLabel newProductsAddToCart58;
    private javax.swing.JLabel newProductsAddToCart59;
    private javax.swing.JLabel newProductsAddToCart6;
    private javax.swing.JLabel newProductsAddToCart60;
    private javax.swing.JLabel newProductsAddToCart61;
    private javax.swing.JLabel newProductsAddToCart62;
    private javax.swing.JLabel newProductsAddToCart63;
    private javax.swing.JLabel newProductsAddToCart64;
    private javax.swing.JLabel newProductsAddToCart7;
    private javax.swing.JLabel newProductsAddToCart8;
    public static javax.swing.JLabel newProductsLabel1;
    public static javax.swing.JLabel newProductsLabel2;
    public static javax.swing.JLabel newProductsLabel3;
    public static javax.swing.JLabel newProductsLabel4;
    public static javax.swing.JLabel newProductsLabel5;
    public static javax.swing.JLabel newProductsLabel6;
    public static javax.swing.JLabel newProductsLabel7;
    public static javax.swing.JLabel newProductsLabel8;
    private javax.swing.JLabel newProductsLandingIcon;
    private javax.swing.JPanel newProductsPanel;
    public static javax.swing.JLabel newProductsPrice1;
    public static javax.swing.JLabel newProductsPrice2;
    public static javax.swing.JLabel newProductsPrice3;
    public static javax.swing.JLabel newProductsPrice4;
    public static javax.swing.JLabel newProductsPrice5;
    public static javax.swing.JLabel newProductsPrice6;
    public static javax.swing.JLabel newProductsPrice7;
    public static javax.swing.JLabel newProductsPrice8;
    public static javax.swing.JLabel newProductsSlot1;
    public static javax.swing.JLabel newProductsSlot2;
    public static javax.swing.JLabel newProductsSlot3;
    public static javax.swing.JLabel newProductsSlot4;
    public static javax.swing.JLabel newProductsSlot5;
    public static javax.swing.JLabel newProductsSlot6;
    public static javax.swing.JLabel newProductsSlot7;
    public static javax.swing.JLabel newProductsSlot8;
    private javax.swing.JLabel newProductsStockLabel1;
    private javax.swing.JLabel newProductsStockLabel2;
    private javax.swing.JLabel newProductsStockLabel3;
    private javax.swing.JLabel newProductsStockLabel4;
    private javax.swing.JLabel newProductsStockLabel5;
    private javax.swing.JLabel newProductsStockLabel6;
    private javax.swing.JLabel newProductsStockLabel7;
    private javax.swing.JLabel newProductsStockLabel8;
    private javax.swing.JRadioButton otherGenderButton;
    private javax.swing.JLabel paymentOptionsLabel;
    private javax.swing.JPanel paymentOptionsPanel;
    public static javax.swing.JTextField phoneNumberHolder;
    private javax.swing.JLabel privacyPolicyLabel;
    private javax.swing.JPanel privacyPolicyPanel;
    private javax.swing.JLabel readyMealsAddToCart1;
    private javax.swing.JLabel readyMealsAddToCart2;
    private javax.swing.JLabel readyMealsAddToCart3;
    private javax.swing.JLabel readyMealsAddToCart4;
    private javax.swing.JLabel readyMealsAddToCart5;
    private javax.swing.JLabel readyMealsAddToCart6;
    private javax.swing.JLabel readyMealsAddToCart7;
    private javax.swing.JLabel readyMealsAddToCart8;
    private javax.swing.JButton readyMealsButton;
    public static javax.swing.JLabel readyMealsLabel1;
    public static javax.swing.JLabel readyMealsLabel2;
    public static javax.swing.JLabel readyMealsLabel3;
    public static javax.swing.JLabel readyMealsLabel4;
    public static javax.swing.JLabel readyMealsLabel5;
    public static javax.swing.JLabel readyMealsLabel6;
    public static javax.swing.JLabel readyMealsLabel7;
    public static javax.swing.JLabel readyMealsLabel8;
    private javax.swing.JLabel readyMealsLandingIcon;
    private javax.swing.JPanel readyMealsPanel;
    public static javax.swing.JLabel readyMealsPrice1;
    public static javax.swing.JLabel readyMealsPrice2;
    public static javax.swing.JLabel readyMealsPrice3;
    public static javax.swing.JLabel readyMealsPrice4;
    public static javax.swing.JLabel readyMealsPrice5;
    public static javax.swing.JLabel readyMealsPrice6;
    public static javax.swing.JLabel readyMealsPrice7;
    public static javax.swing.JLabel readyMealsPrice8;
    public static javax.swing.JLabel readyMealsSlot1;
    public static javax.swing.JLabel readyMealsSlot2;
    public static javax.swing.JLabel readyMealsSlot3;
    public static javax.swing.JLabel readyMealsSlot4;
    public static javax.swing.JLabel readyMealsSlot5;
    public static javax.swing.JLabel readyMealsSlot6;
    public static javax.swing.JLabel readyMealsSlot7;
    public static javax.swing.JLabel readyMealsSlot8;
    private javax.swing.JLabel readyMealsStock1;
    private javax.swing.JLabel readyMealsStock2;
    private javax.swing.JLabel readyMealsStock3;
    private javax.swing.JLabel readyMealsStock4;
    private javax.swing.JLabel readyMealsStock5;
    private javax.swing.JLabel readyMealsStock6;
    private javax.swing.JLabel readyMealsStock7;
    private javax.swing.JLabel readyMealsStock8;
    private javax.swing.JButton saveButton;
    private javax.swing.JPanel seaFoodsPanel;
    private javax.swing.JLabel seafoodsAddToCart1;
    private javax.swing.JLabel seafoodsAddToCart2;
    private javax.swing.JLabel seafoodsAddToCart3;
    private javax.swing.JLabel seafoodsAddToCart4;
    private javax.swing.JLabel seafoodsAddToCart5;
    private javax.swing.JLabel seafoodsAddToCart6;
    private javax.swing.JLabel seafoodsAddToCart7;
    private javax.swing.JLabel seafoodsAddToCart8;
    private javax.swing.JButton seafoodsButton;
    public static javax.swing.JLabel seafoodsLabel1;
    public static javax.swing.JLabel seafoodsLabel2;
    public static javax.swing.JLabel seafoodsLabel3;
    public static javax.swing.JLabel seafoodsLabel4;
    public static javax.swing.JLabel seafoodsLabel5;
    public static javax.swing.JLabel seafoodsLabel6;
    public static javax.swing.JLabel seafoodsLabel7;
    public static javax.swing.JLabel seafoodsLabel8;
    private javax.swing.JLabel seafoodsLandingIcon;
    public static javax.swing.JLabel seafoodsPrice1;
    public static javax.swing.JLabel seafoodsPrice2;
    public static javax.swing.JLabel seafoodsPrice3;
    public static javax.swing.JLabel seafoodsPrice4;
    public static javax.swing.JLabel seafoodsPrice5;
    public static javax.swing.JLabel seafoodsPrice6;
    public static javax.swing.JLabel seafoodsPrice7;
    public static javax.swing.JLabel seafoodsPrice8;
    public static javax.swing.JLabel seafoodsSlot1;
    public static javax.swing.JLabel seafoodsSlot2;
    public static javax.swing.JLabel seafoodsSlot3;
    public static javax.swing.JLabel seafoodsSlot4;
    public static javax.swing.JLabel seafoodsSlot5;
    public static javax.swing.JLabel seafoodsSlot6;
    public static javax.swing.JLabel seafoodsSlot7;
    public static javax.swing.JLabel seafoodsSlot8;
    private javax.swing.JLabel seafoodsStock1;
    private javax.swing.JLabel seafoodsStock2;
    private javax.swing.JLabel seafoodsStock3;
    private javax.swing.JLabel seafoodsStock4;
    private javax.swing.JLabel seafoodsStock5;
    private javax.swing.JLabel seafoodsStock6;
    private javax.swing.JLabel seafoodsStock7;
    private javax.swing.JLabel seafoodsStock8;
    private javax.swing.JLabel seafoodsTitle;
    private javax.swing.JButton selectImageButton;
    private javax.swing.JLabel shopNowButton;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JLabel snacksAddToCart1;
    private javax.swing.JLabel snacksAddToCart2;
    private javax.swing.JLabel snacksAddToCart3;
    private javax.swing.JLabel snacksAddToCart4;
    private javax.swing.JLabel snacksAddToCart5;
    private javax.swing.JLabel snacksAddToCart6;
    private javax.swing.JLabel snacksAddToCart7;
    private javax.swing.JLabel snacksAddToCart8;
    private javax.swing.JButton snacksButton;
    public static javax.swing.JLabel snacksLabel1;
    public static javax.swing.JLabel snacksLabel2;
    public static javax.swing.JLabel snacksLabel3;
    public static javax.swing.JLabel snacksLabel4;
    public static javax.swing.JLabel snacksLabel5;
    public static javax.swing.JLabel snacksLabel6;
    public static javax.swing.JLabel snacksLabel7;
    public static javax.swing.JLabel snacksLabel8;
    private javax.swing.JPanel snacksPanel;
    public static javax.swing.JLabel snacksPrice1;
    public static javax.swing.JLabel snacksPrice2;
    public static javax.swing.JLabel snacksPrice3;
    public static javax.swing.JLabel snacksPrice4;
    public static javax.swing.JLabel snacksPrice5;
    public static javax.swing.JLabel snacksPrice6;
    public static javax.swing.JLabel snacksPrice7;
    public static javax.swing.JLabel snacksPrice8;
    public static javax.swing.JLabel snacksSlot1;
    public static javax.swing.JLabel snacksSlot2;
    public static javax.swing.JLabel snacksSlot3;
    public static javax.swing.JLabel snacksSlot4;
    public static javax.swing.JLabel snacksSlot5;
    public static javax.swing.JLabel snacksSlot6;
    public static javax.swing.JLabel snacksSlot7;
    public static javax.swing.JLabel snacksSlot8;
    private javax.swing.JLabel snacksStock1;
    private javax.swing.JLabel snacksStock2;
    private javax.swing.JLabel snacksStock3;
    private javax.swing.JLabel snacksStock4;
    private javax.swing.JLabel snacksStock5;
    private javax.swing.JLabel snacksStock6;
    private javax.swing.JLabel snacksStock7;
    private javax.swing.JLabel snacksStock8;
    private javax.swing.JLabel snakcsLandingIcon;
    private javax.swing.JButton vegetableButton;
    private javax.swing.JLabel vegetablesAddToCart1;
    private javax.swing.JLabel vegetablesAddToCart2;
    private javax.swing.JLabel vegetablesAddToCart3;
    private javax.swing.JLabel vegetablesAddToCart4;
    private javax.swing.JLabel vegetablesAddToCart5;
    private javax.swing.JLabel vegetablesAddToCart6;
    private javax.swing.JLabel vegetablesAddToCart7;
    private javax.swing.JLabel vegetablesAddToCart8;
    public static javax.swing.JLabel vegetablesLabel1;
    public static javax.swing.JLabel vegetablesLabel2;
    public static javax.swing.JLabel vegetablesLabel3;
    public static javax.swing.JLabel vegetablesLabel4;
    public static javax.swing.JLabel vegetablesLabel5;
    public static javax.swing.JLabel vegetablesLabel6;
    public static javax.swing.JLabel vegetablesLabel7;
    public static javax.swing.JLabel vegetablesLabel8;
    private javax.swing.JLabel vegetablesLandingIcon;
    private javax.swing.JPanel vegetablesPanel;
    public static javax.swing.JLabel vegetablesPrice1;
    public static javax.swing.JLabel vegetablesPrice2;
    public static javax.swing.JLabel vegetablesPrice3;
    public static javax.swing.JLabel vegetablesPrice4;
    public static javax.swing.JLabel vegetablesPrice5;
    public static javax.swing.JLabel vegetablesPrice6;
    public static javax.swing.JLabel vegetablesPrice7;
    public static javax.swing.JLabel vegetablesPrice8;
    public static javax.swing.JLabel vegetablesSlot1;
    public static javax.swing.JLabel vegetablesSlot13;
    public static javax.swing.JLabel vegetablesSlot2;
    public static javax.swing.JLabel vegetablesSlot3;
    public static javax.swing.JLabel vegetablesSlot4;
    public static javax.swing.JLabel vegetablesSlot5;
    public static javax.swing.JLabel vegetablesSlot6;
    public static javax.swing.JLabel vegetablesSlot7;
    public static javax.swing.JLabel vegetablesSlot8;
    private javax.swing.JLabel vegetablesStock1;
    private javax.swing.JLabel vegetablesStock11;
    private javax.swing.JLabel vegetablesStock12;
    private javax.swing.JLabel vegetablesStock13;
    private javax.swing.JLabel vegetablesStock14;
    private javax.swing.JLabel vegetablesStock15;
    private javax.swing.JLabel vegetablesStock16;
    private javax.swing.JLabel vegetablesStock2;
    private javax.swing.JLabel vegetablesStock3;
    private javax.swing.JLabel vegetablesStock4;
    private javax.swing.JLabel vegetablesStock5;
    private javax.swing.JLabel vegetablesStock6;
    private javax.swing.JLabel vegetablesStock7;
    private javax.swing.JLabel vegetablesStock8;
    private javax.swing.JLabel winesAddToCart1;
    private javax.swing.JLabel winesAddToCart2;
    private javax.swing.JLabel winesAddToCart3;
    private javax.swing.JLabel winesAddToCart4;
    private javax.swing.JLabel winesAddToCart5;
    private javax.swing.JLabel winesAddToCart6;
    private javax.swing.JLabel winesAddToCart7;
    private javax.swing.JLabel winesAddToCart8;
    public static javax.swing.JLabel winesLabel1;
    public static javax.swing.JLabel winesLabel2;
    public static javax.swing.JLabel winesLabel3;
    public static javax.swing.JLabel winesLabel4;
    public static javax.swing.JLabel winesLabel5;
    public static javax.swing.JLabel winesLabel6;
    public static javax.swing.JLabel winesLabel7;
    public static javax.swing.JLabel winesLabel8;
    private javax.swing.JPanel winesPanel;
    public static javax.swing.JLabel winesPrice1;
    public static javax.swing.JLabel winesPrice2;
    public static javax.swing.JLabel winesPrice3;
    public static javax.swing.JLabel winesPrice4;
    public static javax.swing.JLabel winesPrice5;
    public static javax.swing.JLabel winesPrice6;
    public static javax.swing.JLabel winesPrice7;
    public static javax.swing.JLabel winesPrice8;
    public static javax.swing.JLabel winesSlot1;
    public static javax.swing.JLabel winesSlot2;
    public static javax.swing.JLabel winesSlot3;
    public static javax.swing.JLabel winesSlot4;
    public static javax.swing.JLabel winesSlot5;
    public static javax.swing.JLabel winesSlot6;
    public static javax.swing.JLabel winesSlot7;
    public static javax.swing.JLabel winesSlot8;
    private javax.swing.JLabel winesStock1;
    private javax.swing.JLabel winesStock2;
    private javax.swing.JLabel winesStock3;
    private javax.swing.JLabel winesStock4;
    private javax.swing.JLabel winesStock5;
    private javax.swing.JLabel winesStock6;
    private javax.swing.JLabel winesStock7;
    private javax.swing.JLabel winesStock8;
    private javax.swing.JComboBox<String> yearChooser;
    // End of variables declaration//GEN-END:variables

}
