package main_package;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.mindrot.jbcrypt.BCrypt;

public class DatabaseManager {

    static String URL = "jdbc:sqlite:inventory.db";

    public void insertAll(String name, String category, int price, int quantity) {

        String sql = "INSERT INTO items (name, category, price, quantity) VALUES (?, ?, ?, ?) ";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, category);
            stmt.setInt(3, price);
            stmt.setInt(4, quantity);

            stmt.executeUpdate();
            System.out.println("Product inserted succesfully!");
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void rememberUser(String email) {

        String updateSql = "UPDATE users SET is_logged_in = 1 WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL);PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

            // Remember this user
            updateStmt.setString(1, email);
            updateStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void unrememberUser(){
        String updateSql = "UPDATE users SET is_logged_in = 0";
        
         try (Connection conn = DriverManager.getConnection(URL);PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

            updateStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         
    }
    
    public String getRememberedUser() {
    String sql = "SELECT email FROM users WHERE is_logged_in = 1 LIMIT 1";

    try (Connection conn = DriverManager.getConnection(URL);
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        if (rs.next()) {
            return rs.getString("email"); // user to auto-login
        }

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    return null; 
}
    
    public void logoutUser(String email) {
    String sql = "UPDATE users SET is_logged_in = 0 WHERE email = ?";

    try (Connection conn = DriverManager.getConnection(URL);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, email);
        stmt.executeUpdate();

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
    
    

    public void insertUserInfo(String fullName, String email, String password) {

        String sql = "INSERT INTO users (full_name, email, password) VAlUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fullName);
            pstmt.setString(2, email);
            String hashedPass = BCrypt.hashpw(password, BCrypt.gensalt());
            pstmt.setString(3, hashedPass);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean checkEmailExist(String email, JLabel label) {

        String sql = "SELECT * FROM users WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean readEmailPass(String email, String password) {

        String sql = "SELECT password FROM users WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("password");

                if (BCrypt.checkpw(password, storedHash)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public String retrieveUsername(String email) {
        String sql = "SELECT full_name FROM users WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("full_name");
            } else {
                System.out.println("No name found");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String retrieveEmail(String email) {
        String sql = "SELECT email FROM users WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("email");
            } else {
                System.out.println("No name found");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void subtractQnty(int quantityToSubtract, int id) {
        String sql = "UPDATE items SET quantity = quantity - ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, quantityToSubtract);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Quantity updated!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public void addQnty(int quantityToAdd, int id) {
        String sql = "UPDATE items SET quantity = quantity + ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, quantityToAdd);
            pstmt.setInt(2, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Quantity updated!");
            }
        } catch (SQLException e) {
            System.out.println("Error!");
        }
    }

    public void addOne(int id) {
        String sql = "UPDATE items SET quantity = quantity + 1 WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Items updated!");
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void subtractOne(int id) {
        String sql = "UPDATE items SET quantity = quantity - 1 WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Items updated!");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void update(int quantity, int id) {
        String sql = "UPDATE items SET quantity = quantity + ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Items updated!");
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void display() {

        String query = "SELECT * FROM items";

        try {
            Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int qnty = rs.getInt("quantity");

                System.out.println("ID: " + id + " | Name: " + name + " | Price: " + price + " | Quantity: " + qnty);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private String id;

    public void displayQuantity(int id) {

        String query = "SELECT quantity FROM items WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int qnty = rs.getInt(URL);
                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
        }
    }

    public static void addAll(String name, int category, float price, int quantity, String imagePath) {
        String query = "INSERT into products (name, category, price, quantity, image_path) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement ptsmt = conn.prepareStatement(query)) {
            ptsmt.setString(1, name);
            ptsmt.setInt(2, category);
            ptsmt.setFloat(3, price);
            ptsmt.setInt(4, quantity);
            ptsmt.setString(5, imagePath);
            ptsmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadProductsFromDB() {
        for (int i = 0; i < DashboardFrame.categoryCounters.length; i++) {
            DashboardFrame.categoryCounters[i] = 0;
        }

        try (Connection conn = DriverManager.getConnection(URL); Statement stmt = conn.createStatement()) {

            String query = "SELECT name, category, price, quantity, image_path FROM products ORDER BY category, id";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                int category = rs.getInt("category");
                String price = String.valueOf(rs.getFloat("price"));
                String imagePath = rs.getString("image_path");

                ImageIcon origIcon = new ImageIcon(imagePath);
                Image scaledImg = origIcon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImg);

                DashboardFrame.addProductToCategory(category, icon, name, price);

            }

        } catch (SQLException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
    }

    public void displayItemByName(String productName, JLabel slotLabel, JLabel nameLabel, JLabel priceLabel) {
        String query = "SELECT name, price, image_path FROM products WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, productName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String imagePath = rs.getString("image_path");

                // Set cart labels
                nameLabel.setText(name);
                priceLabel.setText("P" + price);

                // Load and scale image for the slot
                ImageIcon icon = new ImageIcon(imagePath);
                Image img = icon.getImage().getScaledInstance(
                        slotLabel.getWidth(),
                        slotLabel.getHeight(),
                        Image.SCALE_SMOOTH
                );
                slotLabel.setIcon(new ImageIcon(img));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
