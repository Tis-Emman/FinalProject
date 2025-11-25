package main_package;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class TestLoginFrame extends javax.swing.JFrame {

    private static DashboardFrame dashboardFrame;
    DatabaseManager dbManager = new DatabaseManager();
    LoginFrame signIn = new LoginFrame(dashboardFrame);
    Listener listener = new Listener();

    public TestLoginFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(TestLoginFrame.EXIT_ON_CLOSE);
        gotoRegisterButton.setBackground(new Color(252, 239, 216));
        registerPanel.setVisible(false);
        togglePasswordVisibility(loginPasswordTextField, eyeIcon);
        togglePasswordVisibility(signUpPasswordTextField, registerPasswordEye);
        togglePasswordVisibility(passConfirmationField, registerConfirmationPasswordEye);
        
        

        
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        gotoRegisterButton = new javax.swing.JButton();
        gotoLoginButton = new javax.swing.JButton();
        gotoDashboardLogo = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        registerPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        fullNameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();
        passwordWarningLabel = new javax.swing.JLabel();
        emailWarningLabel = new javax.swing.JLabel();
        registerWarningLabel = new javax.swing.JLabel();
        confirmationPassLabel = new javax.swing.JLabel();
        passConfirmationField = new javax.swing.JPasswordField();
        signUpPasswordTextField = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        registerPasswordEye = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        registerConfirmationPasswordEye = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginEmailTextField = new javax.swing.JTextField();
        rememberMe = new javax.swing.JCheckBox();
        loginButton = new javax.swing.JButton();
        loginWarningLabel = new javax.swing.JLabel();
        loginPasswordTextField = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        iconPlatforms = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        eyeIcon = new javax.swing.JLabel();
        iconPlatformsWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(252, 239, 216));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(159, 133, 85));

        jLabel10.setFont(new java.awt.Font("MS UI Gothic", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Welcome");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 70));

        gotoRegisterButton.setBackground(new java.awt.Color(252, 239, 216));
        gotoRegisterButton.setFont(new java.awt.Font("MS UI Gothic", 1, 18)); // NOI18N
        gotoRegisterButton.setForeground(new java.awt.Color(30, 30, 30));
        gotoRegisterButton.setText("Register");
        gotoRegisterButton.setBorder(null);
        gotoRegisterButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gotoRegisterButton.setFocusable(false);
        gotoRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gotoRegisterButtonActionPerformed(evt);
            }
        });
        jPanel1.add(gotoRegisterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 250, 50));

        gotoLoginButton.setBackground(new java.awt.Color(137, 102, 38));
        gotoLoginButton.setFont(new java.awt.Font("MS UI Gothic", 1, 18)); // NOI18N
        gotoLoginButton.setForeground(new java.awt.Color(30, 30, 30));
        gotoLoginButton.setText("Login");
        gotoLoginButton.setBorder(null);
        gotoLoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gotoLoginButton.setFocusable(false);
        gotoLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gotoLoginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(gotoLoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 250, 50));

        gotoDashboardLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo - loginXregister.png"))); // NOI18N
        jPanel1.add(gotoDashboardLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 270, 350));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 730));

        registerPanel.setBackground(new java.awt.Color(182, 145, 77));
        registerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("MS UI Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("Full Name");
        registerPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        fullNameTextField.setBackground(new java.awt.Color(211, 189, 148));
        fullNameTextField.setBorder(null);
        fullNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullNameTextFieldActionPerformed(evt);
            }
        });
        registerPanel.add(fullNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 330, 40));

        jLabel5.setFont(new java.awt.Font("MS UI Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 30, 30));
        jLabel5.setText("Email");
        registerPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        emailTextField.setBackground(new java.awt.Color(211, 189, 148));
        emailTextField.setBorder(null);
        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });
        registerPanel.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 330, 40));

        jLabel6.setFont(new java.awt.Font("MS UI Gothic", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("REGISTER");
        registerPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 530, 40));

        jLabel7.setFont(new java.awt.Font("MS UI Gothic", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setText("Password");
        registerPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, -1, -1));

        jLabel8.setFont(new java.awt.Font("MS UI Gothic", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 30, 30));
        jLabel8.setText("Confirm Password");
        registerPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, -1, -1));

        signUpButton.setBackground(new java.awt.Color(137, 102, 38));
        signUpButton.setFont(new java.awt.Font("MS UI Gothic", 1, 18)); // NOI18N
        signUpButton.setForeground(new java.awt.Color(30, 30, 30));
        signUpButton.setText("Register");
        signUpButton.setBorder(null);
        signUpButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUpButton.setFocusable(false);
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });
        registerPanel.add(signUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, 370, 50));

        passwordWarningLabel.setForeground(new java.awt.Color(252, 239, 216));
        registerPanel.add(passwordWarningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 360, 20));

        emailWarningLabel.setForeground(new java.awt.Color(252, 239, 216));
        registerPanel.add(emailWarningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 360, 20));

        registerWarningLabel.setForeground(new java.awt.Color(252, 239, 216));
        registerWarningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerPanel.add(registerWarningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 650, 360, 20));

        confirmationPassLabel.setForeground(new java.awt.Color(252, 239, 216));
        registerPanel.add(confirmationPassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, 360, 20));

        passConfirmationField.setBackground(new java.awt.Color(211, 189, 148));
        passConfirmationField.setBorder(null);
        passConfirmationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passConfirmationFieldActionPerformed(evt);
            }
        });
        registerPanel.add(passConfirmationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 280, 40));

        signUpPasswordTextField.setBackground(new java.awt.Color(211, 189, 148));
        signUpPasswordTextField.setBorder(null);
        signUpPasswordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpPasswordTextFieldActionPerformed(evt);
            }
        });
        registerPanel.add(signUpPasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 280, 40));

        jPanel6.setBackground(new java.awt.Color(211, 189, 148));

        registerPasswordEye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerPasswordEye)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerPasswordEye, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        registerPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 50, 40));

        jPanel8.setBackground(new java.awt.Color(211, 189, 148));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/full name register icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        registerPanel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 40, 40));

        jPanel9.setBackground(new java.awt.Color(211, 189, 148));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/email icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        registerPanel.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 40, 40));

        jPanel10.setBackground(new java.awt.Color(211, 189, 148));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/password icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        registerPanel.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 40, 40));

        jPanel11.setBackground(new java.awt.Color(211, 189, 148));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/password confirmation icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        registerPanel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 40, 40));

        jPanel12.setBackground(new java.awt.Color(211, 189, 148));

        registerConfirmationPasswordEye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open.png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerConfirmationPasswordEye)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerConfirmationPasswordEye, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        registerPanel.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, 50, 40));

        loginPanel.setBackground(new java.awt.Color(182, 145, 77));
        loginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("MS UI Gothic", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 30, 30));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");
        loginPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 520, 50));

        jLabel2.setFont(new java.awt.Font("MS UI Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 30, 30));
        jLabel2.setText("Password");
        loginPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        jLabel3.setFont(new java.awt.Font("MS UI Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 30, 30));
        jLabel3.setText("Email");
        loginPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        loginEmailTextField.setBackground(new java.awt.Color(211, 189, 148));
        loginEmailTextField.setBorder(null);
        loginEmailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginEmailTextFieldActionPerformed(evt);
            }
        });
        loginPanel.add(loginEmailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 320, 40));

        rememberMe.setBackground(new java.awt.Color(182, 145, 77));
        rememberMe.setFont(new java.awt.Font("MS UI Gothic", 1, 14)); // NOI18N
        rememberMe.setForeground(new java.awt.Color(30, 30, 30));
        rememberMe.setText("Remember Me");
        rememberMe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rememberMe.setFocusable(false);
        rememberMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rememberMeActionPerformed(evt);
            }
        });
        loginPanel.add(rememberMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        loginButton.setBackground(new java.awt.Color(137, 102, 38));
        loginButton.setFont(new java.awt.Font("MS UI Gothic", 1, 18)); // NOI18N
        loginButton.setForeground(new java.awt.Color(30, 30, 30));
        loginButton.setText("Login");
        loginButton.setBorder(null);
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.setFocusable(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginPanel.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 370, 50));

        loginWarningLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        loginWarningLabel.setForeground(new java.awt.Color(252, 239, 216));
        loginWarningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginPanel.add(loginWarningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 360, 20));

        loginPasswordTextField.setBackground(new java.awt.Color(211, 189, 148));
        loginPasswordTextField.setBorder(null);
        loginPasswordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginPasswordTextFieldActionPerformed(evt);
            }
        });
        loginPanel.add(loginPasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 270, 40));

        jLabel9.setFont(new java.awt.Font("MS UI Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 30, 30));
        jLabel9.setText("Forgot Password?");
        loginPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, -1, 20));

        iconPlatforms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/login icons.png"))); // NOI18N
        loginPanel.add(iconPlatforms, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("or choose to login with");
        loginPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 520, -1));

        jPanel3.setBackground(new java.awt.Color(211, 189, 148));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/email icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        loginPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 50, 40));

        jPanel4.setBackground(new java.awt.Color(211, 189, 148));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/password icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        loginPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, 40));

        jPanel5.setBackground(new java.awt.Color(211, 189, 148));

        eyeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eyeIcon)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eyeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        loginPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 50, 40));

        iconPlatformsWarning.setForeground(new java.awt.Color(252, 239, 216));
        iconPlatformsWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginPanel.add(iconPlatformsWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 640, 230, 20));

        jLayeredPane1.setLayer(registerPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(loginPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(registerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(registerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 520, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rememberMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rememberMeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rememberMeActionPerformed

    private void togglePasswordVisibility(JPasswordField passwordField, JLabel eyeLabel) {
        eyeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            private boolean isVisible = false;

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                isVisible = !isVisible;

                if (isVisible) {
                    passwordField.setEchoChar((char) 0);
                    eyeLabel.setIcon(new ImageIcon(getClass().getResource("/icons/closed.png"))); // open eye
                } else {
                    passwordField.setEchoChar('•');
                    eyeLabel.setIcon(new ImageIcon(getClass().getResource("/icons/open.png"))); // closed eye
                }
            }
        });
    }

    private JButton selectedButton = null;

    private void gotoRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotoRegisterButtonActionPerformed
        registerPanel.setVisible(true);
        loginPanel.setVisible(false);

        gotoLoginButton.setBackground(new Color(252, 239, 216));
        selectButton(gotoRegisterButton);

    }//GEN-LAST:event_gotoRegisterButtonActionPerformed

    public void selectButton(JButton btn) {
        if (selectedButton != null) {
            selectedButton.setBackground(new Color(252, 239, 216));
        }

        btn.setBackground(new Color(137, 102, 38));
        selectedButton = btn;
    }

    private void gotoLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotoLoginButtonActionPerformed
        loginPanel.setVisible(true);
        registerPanel.setVisible(false);

        selectButton(gotoLoginButton);

    }//GEN-LAST:event_gotoLoginButtonActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        String fullName = fullNameTextField.getText().trim();
        String email = emailTextField.getText().trim();
        String password = new String(signUpPasswordTextField.getPassword());
        String confirmationPass = new String(passConfirmationField.getPassword());

        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            registerWarningLabel.setText("Please fill out all the forms!");
        } else if (dbManager.checkEmailExist(email, passwordWarningLabel)) {
            passwordWarningLabel.setText("Email is already registered!");
        } else if (password.length() <= 8) {
            passwordWarningLabel.setText("Password must be greater than 8 characters!");
            emailWarningLabel.setText("");
            registerWarningLabel.setText("");
        } else if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            emailWarningLabel.setText("Email is not valid!");
            registerWarningLabel.setText("");
            passwordWarningLabel.setText("");
        } else if (!password.equals(confirmationPass)) {
            confirmationPassLabel.setText("Password do not match!");
        } else {

            registerPanel.setVisible(false);
            loginPanel.setVisible(true);
            gotoRegisterButton.setBackground(new Color(252, 239, 216));
            gotoLoginButton.setBackground(new Color(137, 102, 38));
            emailWarningLabel.setText("");
            registerWarningLabel.setText("");
            passwordWarningLabel.setText("");
            confirmationPassLabel.setText("");
            dbManager.insertUserInfo(fullName, email, password);
            JOptionPane.showMessageDialog(rootPane, "Sign up successfull!");

            fullNameTextField.setText("");
            emailTextField.setText("");
            signUpPasswordTextField.setText("");
            passConfirmationField.setText("");

            //  DashboardFrame dbFrame = new DashboardFrame(true, email);
            // dbFrame.setVisible(true);
            // dashboardFrame.gotoLoginImage.setVisible(false);

    }//GEN-LAST:event_signUpButtonActionPerformed
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String email = loginEmailTextField.getText().trim();
        String password = new String(loginPasswordTextField.getPassword());

        if (dbManager.readEmailPass(email, password)) {
            JOptionPane.showMessageDialog(rootPane, "Successfully logged in!");

            DashboardFrame dbFrame = new DashboardFrame(true, email);
            
            
            if(rememberMe.isSelected()){
                dbManager.rememberUser(email);
            } else{
                dbManager.unrememberUser();
            }

            // System.out.println(getEmail());
            dbFrame.setVisible(true);

            this.dispose();

        } else if (email.isEmpty() || password.isEmpty()) {
            loginWarningLabel.setText("Please, fill out all the fields");
        } else {
            loginWarningLabel.setText("User not registered!");
        }

        if (email.equalsIgnoreCase("admin") && password.equals("admin")) {
            AdminPage aP = new AdminPage();
            aP.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void loginEmailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginEmailTextFieldActionPerformed
       loginPasswordTextField.requestFocusInWindow();
    }//GEN-LAST:event_loginEmailTextFieldActionPerformed

    private void loginPasswordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginPasswordTextFieldActionPerformed
      loginButton.doClick();
    }//GEN-LAST:event_loginPasswordTextFieldActionPerformed

    private void fullNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullNameTextFieldActionPerformed
        fullNameTextField.transferFocus();
    }//GEN-LAST:event_fullNameTextFieldActionPerformed

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
      emailTextField.transferFocus();
    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void signUpPasswordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpPasswordTextFieldActionPerformed
      signUpPasswordTextField.transferFocus();
    }//GEN-LAST:event_signUpPasswordTextFieldActionPerformed

    private void passConfirmationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passConfirmationFieldActionPerformed
      signUpButton.doClick();
    }//GEN-LAST:event_passConfirmationFieldActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel confirmationPassLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel emailWarningLabel;
    private javax.swing.JLabel eyeIcon;
    private javax.swing.JTextField fullNameTextField;
    private javax.swing.JLabel gotoDashboardLogo;
    public static javax.swing.JButton gotoLoginButton;
    public static javax.swing.JButton gotoRegisterButton;
    private javax.swing.JLabel iconPlatforms;
    private javax.swing.JLabel iconPlatformsWarning;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField loginEmailTextField;
    public static javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField loginPasswordTextField;
    private javax.swing.JLabel loginWarningLabel;
    private javax.swing.JPasswordField passConfirmationField;
    private javax.swing.JLabel passwordWarningLabel;
    private javax.swing.JLabel registerConfirmationPasswordEye;
    public static javax.swing.JPanel registerPanel;
    private javax.swing.JLabel registerPasswordEye;
    private javax.swing.JLabel registerWarningLabel;
    private javax.swing.JCheckBox rememberMe;
    private javax.swing.JButton signUpButton;
    private javax.swing.JPasswordField signUpPasswordTextField;
    // End of variables declaration//GEN-END:variables
}
