package main_package;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class TestLoginFrame extends javax.swing.JFrame {
     
private static DashboardFrame dashboardFrame;
DatabaseManager dbManager = new DatabaseManager();
LoginFrame signIn = new LoginFrame(dashboardFrame);

    public TestLoginFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(TestLoginFrame.EXIT_ON_CLOSE);   
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        gotoRegisterButton = new javax.swing.JButton();
        gotoLoginButton = new javax.swing.JButton();
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
        loginPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginEmailTextField = new javax.swing.JTextField();
        rememberMe = new javax.swing.JCheckBox();
        loginButton = new javax.swing.JButton();
        loginWarningLabel = new javax.swing.JLabel();
        loginPasswordTextField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
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

        gotoRegisterButton.setBackground(new java.awt.Color(102, 153, 255));
        gotoRegisterButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        gotoRegisterButton.setForeground(new java.awt.Color(255, 255, 255));
        gotoRegisterButton.setText("Register");
        gotoRegisterButton.setBorder(null);
        gotoRegisterButton.setFocusable(false);
        gotoRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gotoRegisterButtonActionPerformed(evt);
            }
        });
        jPanel1.add(gotoRegisterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 250, 50));

        gotoLoginButton.setBackground(new java.awt.Color(102, 153, 255));
        gotoLoginButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        gotoLoginButton.setForeground(new java.awt.Color(255, 255, 255));
        gotoLoginButton.setText("Login");
        gotoLoginButton.setBorder(null);
        gotoLoginButton.setFocusable(false);
        gotoLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gotoLoginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(gotoLoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 250, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 730));

        registerPanel.setBackground(new java.awt.Color(39, 38, 38));
        registerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Full Name");
        registerPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        fullNameTextField.setBorder(null);
        registerPanel.add(fullNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 360, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email");
        registerPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        emailTextField.setBorder(null);
        registerPanel.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 360, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("REGISTER");
        registerPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 530, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password");
        registerPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Confirm Password");
        registerPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, -1, -1));

        signUpButton.setBackground(new java.awt.Color(255, 153, 0));
        signUpButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signUpButton.setForeground(new java.awt.Color(255, 255, 255));
        signUpButton.setText("Register");
        signUpButton.setBorder(null);
        signUpButton.setFocusable(false);
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });
        registerPanel.add(signUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, 360, 40));

        passwordWarningLabel.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(passwordWarningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 360, 20));

        emailWarningLabel.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(emailWarningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 360, 20));

        registerWarningLabel.setForeground(new java.awt.Color(255, 0, 0));
        registerWarningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerPanel.add(registerWarningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 620, 360, 20));

        confirmationPassLabel.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(confirmationPassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 360, 20));

        passConfirmationField.setBorder(null);
        registerPanel.add(passConfirmationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 360, 40));

        signUpPasswordTextField.setBorder(null);
        registerPanel.add(signUpPasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 360, 40));

        loginPanel.setBackground(new java.awt.Color(39, 38, 38));
        loginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");
        loginPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        loginPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email");
        loginPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        loginEmailTextField.setBorder(null);
        loginPanel.add(loginEmailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 360, 40));

        rememberMe.setBackground(new java.awt.Color(39, 38, 38));
        rememberMe.setForeground(new java.awt.Color(255, 255, 255));
        rememberMe.setSelected(true);
        rememberMe.setText("Remember Me");
        rememberMe.setFocusable(false);
        rememberMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rememberMeActionPerformed(evt);
            }
        });
        loginPanel.add(rememberMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, -1, -1));

        loginButton.setBackground(new java.awt.Color(255, 153, 0));
        loginButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");
        loginButton.setBorder(null);
        loginButton.setFocusable(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginPanel.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 360, 40));

        loginWarningLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        loginWarningLabel.setForeground(new java.awt.Color(204, 0, 0));
        loginWarningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginPanel.add(loginWarningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 360, 20));

        loginPasswordTextField.setBorder(null);
        loginPanel.add(loginPasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 360, 40));

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

    private JButton selectedButton = null;
    
    private void gotoRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotoRegisterButtonActionPerformed
       registerPanel.setVisible(true);
       loginPanel.setVisible(false);
       
       selectButton(gotoRegisterButton);
       
    }//GEN-LAST:event_gotoRegisterButtonActionPerformed

     public void selectButton(JButton btn){
        if(selectedButton != null){
            selectedButton.setBackground(new Color(102,102,102));
        }
        
        btn.setBackground(new Color(102,153,255));
        selectedButton = btn;
    }
     
    private void gotoLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotoLoginButtonActionPerformed
      loginPanel.setVisible(true);
      registerPanel.setVisible(false);
      
       selectButton(gotoLoginButton);
      
    }//GEN-LAST:event_gotoLoginButtonActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
       String fullName = fullNameTextField.getText().trim();
       String email =  emailTextField.getText().trim();
       String password = new String(passConfirmationField.getPassword()); 
       String confirmationPass = new String(passConfirmationField.getPassword());
       
         if(fullName.isEmpty() || email.isEmpty() || password.isEmpty()){
          registerWarningLabel.setText("Please fill out all the forms!");
        }else if(dbManager.checkEmailExist(email, passwordWarningLabel)){
          passwordWarningLabel.setText("Email is already registered!");
        }else if(password.length() <= 8){
          passwordWarningLabel.setText("Password must be greater than 8 characters!");
          emailWarningLabel.setText("");
          registerWarningLabel.setText("");
        }else if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
          emailWarningLabel.setText("Email is not valid!");
          registerWarningLabel.setText("");
          passwordWarningLabel.setText("");
        } else if(!password.equals(confirmationPass)){
          confirmationPassLabel.setText("Password do not match!");
        }
         else {
                                
          emailWarningLabel.setText("");
          registerWarningLabel.setText("");
          passwordWarningLabel.setText("");
          confirmationPassLabel.setText("");
          dbManager.insertUserInfo(fullName, email, password);
          JOptionPane.showMessageDialog(rootPane, "Sign up successfull!");
          this.dispose();
          DashboardFrame dbFrame = new DashboardFrame(true, email);
          dbFrame.setVisible(true);
          dashboardFrame.gotoLoginImage.setVisible(false);
    }//GEN-LAST:event_signUpButtonActionPerformed
}

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
         String email = loginEmailTextField.getText().trim();
        String password = new String(loginPasswordTextField.getPassword());

        if(dbManager.readEmailPass(email, password)){
            JOptionPane.showMessageDialog(rootPane, "Successfully logged in!");

            DashboardFrame dbFrame = new DashboardFrame(true, email);

            // System.out.println(getEmail());
            
            dbFrame.setVisible(true);
            
            this.dispose();
            
            
        } else if(email.isEmpty() || password.isEmpty()){
            loginWarningLabel.setText("Please, fill out all the fields");
        } else {
           loginWarningLabel.setText("User not registered!");
        }
        
        if(email.equalsIgnoreCase("admin") && password.equals("admin")){
            AdminPage aP = new AdminPage();
            aP.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    
    
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
    private javax.swing.JTextField fullNameTextField;
    private javax.swing.JButton gotoLoginButton;
    private javax.swing.JButton gotoRegisterButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField loginEmailTextField;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField loginPasswordTextField;
    private javax.swing.JLabel loginWarningLabel;
    private javax.swing.JPasswordField passConfirmationField;
    private javax.swing.JLabel passwordWarningLabel;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JLabel registerWarningLabel;
    private javax.swing.JCheckBox rememberMe;
    private javax.swing.JButton signUpButton;
    private javax.swing.JPasswordField signUpPasswordTextField;
    // End of variables declaration//GEN-END:variables
}
