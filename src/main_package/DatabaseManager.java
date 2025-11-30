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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.mindrot.jbcrypt.BCrypt;

public class DatabaseManager {

    static String URL = "jdbc:sqlite:inventory.db";

    public String getNameByEmail(String email) {
        String name = null;
        String sql = "SELECT full_name FROM users WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                name = rs.getString("full_name");
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return name;
    }
    
    public void saveCheckout(String userEmail, Product product, int quantity, float deliveryFee, String transactionNumber){
        
        String sql = "INSERT INTO checkout (transaction_number, user_email, product_name, quantity, delivery_fee, total, image_path VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
   
    try(Connection conn = DriverManager.getConnection(URL);
        PreparedStatement pstmt = conn.prepareStatement(sql)
            ){
        pstmt.setString(1, transactionNumber);
        pstmt.setString(2, userEmail);
        pstmt.setString(3, product.getName());
        pstmt.setInt(4, quantity);
        pstmt.setFloat(5, product.getPrice());
        pstmt.setFloat(6, deliveryFee);
        pstmt.setFloat(7, product.getPrice() * quantity + deliveryFee);
        pstmt.setString(8, product.getImagePath()); 
    }catch(SQLException e){
        
    }
    
    
    }

    public String getImagePath(int productId) {
        String sql = "SELECT image_path FROM products WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("image_path");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // fallback if not found
    }

    public void updateProduct(int id, String name, int category, float price, int quantity, String imagePath) {

        String sql = "UPDATE products SET name=?, category=?, price=?, quantity=?, image_path=? WHERE id=?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, category);
            ps.setFloat(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, imagePath);
            ps.setInt(6, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

            // Remember this user
            updateStmt.setString(1, email);
            updateStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void unrememberUser() {
        String updateSql = "UPDATE users SET is_logged_in = 0";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

            updateStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public String getRememberedUser() {
        String sql = "SELECT email FROM users WHERE is_logged_in = 1 LIMIT 1";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

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

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setGender(String gender, String email) {

        String sql = "UPDATE users SET gender = ? WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement ptsmt = conn.prepareStatement(sql)) {

            ptsmt.setString(1, gender);
            ptsmt.setString(2, email);
            ptsmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readGender(String email) {

        String sql = "SELECT gender FROM users WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement ptsmt = conn.prepareStatement(sql);) {

            ptsmt.setString(1, email);
            ResultSet rs = ptsmt.executeQuery();

            if (rs.next()) {
                return rs.getString("gender");
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void insertBirthdate(String birthdate, String email) {

        String sql = "UPDATE users SET birthdate = ? WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, birthdate);
            pstmt.setString(2, email);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertPhoneNumber(String phoneNumber , String email){
        
        String sql = "UPDATE users SET phone_number = ? WHERE email = ?";
        
        
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql)
                ){
            pstmt.setString(1, phoneNumber);
            pstmt.setString(2, email);
            
            pstmt.executeUpdate();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }

    public void updateAddress(String addressStreet, String barangay, String city, String province, String zip, String houseNumber, String email) {

        String sql = "UPDATE users SET address_street = ?, address_barangay = ?, address_city = ?, address_province = ?, address_zip = ?, address_house_number = ? WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, addressStreet);
            pstmt.setString(2, barangay);
            pstmt.setString(3, city);
            pstmt.setString(4, province);
            pstmt.setString(5, zip);
            pstmt.setString(6, houseNumber);
            pstmt.setString(7, email);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readFullAddress(String email) {
        String sql = "SELECT address_house_number, address_street, address_barangay, address_city, address_province, address_zip FROM users WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String houseNumber = rs.getString("address_house_number");
                String street = rs.getString("address_street");
                String barangay = rs.getString("address_barangay");
                String city = rs.getString("address_city");
                String province = rs.getString("address_province");
                String zip = rs.getString("address_zip");

                // Replace null with empty string
                houseNumber = houseNumber != null ? houseNumber.trim() : "";
                street = street != null ? street.trim() : "";
                barangay = barangay != null ? barangay.trim() : "";
                city = city != null ? city.trim() : "";
                province = province != null ? province.trim() : "";
                zip = zip != null ? zip.trim() : "";

                // Build address only from non-empty parts
                StringBuilder fullAddress = new StringBuilder();

                if (!houseNumber.isEmpty() || !street.isEmpty()) {
                    fullAddress.append("").append(houseNumber).append(" ").append(street);
                }

                if (!barangay.isEmpty()) {
                    if (fullAddress.length() > 0) {
                        fullAddress.append(", ");
                    }
                    fullAddress.append("Brgy. ").append(barangay);
                }

                if (!city.isEmpty()) {
                    if (fullAddress.length() > 0) {
                        fullAddress.append(", ");
                    }
                    fullAddress.append(city);
                }

                if (!province.isEmpty()) {
                    if (fullAddress.length() > 0) {
                        fullAddress.append(", ");
                    }
                    fullAddress.append(province);
                }

                if (!zip.isEmpty()) {
                    if (fullAddress.length() > 0) {
                        fullAddress.append(" ");
                    }
                    fullAddress.append(zip);
                }

                return fullAddress.toString();

            } else {
                return ""; // no record found
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "";
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
    
    public String retrievePhoneNumber(String email) {
        String sql = "SELECT phone_number FROM users WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("phone_number");
            } else {
                System.out.println("No name found");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String retrieveFullAddress(String email) {
        String fullAddress = ""; // default empty
        String sql = "SELECT address_house_number, address_street, address_barangay, address_city, address_province FROM users WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email); // set the email parameter

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String houseNumber = rs.getString("address_house_number");
                    String street = rs.getString("address_street");
                    String barangay = rs.getString("address_barangay");
                    String city = rs.getString("address_city");
                    String province = rs.getString("address_province");

                    fullAddress = houseNumber + ", " + street + ", " + barangay + ", " + city + ", " + province;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fullAddress;
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

    public String getProfileImage(String email) {
        String query = "SELECT profile_image FROM users WHERE email = ?";
        String imagePath = null;

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                imagePath = rs.getString("profile_image");
            }

        } catch (SQLException e) {
            System.out.println("Error fetching profile image: " + e.getMessage());
        }

        return imagePath;
    }

    public void setProfileImage(String imagePath, String email) {
        String query = "UPDATE users SET profile_image = ? WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, imagePath);
            pstmt.setString(2, email);

            pstmt.executeUpdate();

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

    private float unitPrice = 0;
    private int maxStock = 0;

    public void displayItemByName(String productName, JLabel slotLabel,
            JLabel nameLabel, JLabel priceLabel) {

        String query = "SELECT name, price, image_path, quantity FROM products WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, productName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                unitPrice = rs.getFloat("price");  // save globally
                maxStock = rs.getInt("quantity");  // limit quantity
                String imagePath = rs.getString("image_path");

                nameLabel.setText(name);
                priceLabel.setText("₱" + unitPrice);

                // Load and scale image
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

    public Product getProductByName(String productName) {

        String query = "SELECT name, price, image_path, quantity FROM products WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, productName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Product(
                        rs.getString("name"),
                        rs.getFloat("price"),
                        rs.getString("image_path"),
                        rs.getInt("quantity")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void loadProducts(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        String query = "SELECT id, name, category, price, quantity FROM products";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery();) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int category = rs.getInt("category");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");

                model.addRow(new Object[]{
                    id,
                    name,
                    category,
                    price,
                    quantity
                });
            }

            while (model.getRowCount() < 18) {
                model.addRow(new Object[]{
                    null, // id
                    "", // name
                    "", // category or maybe 0 if int
                    null, // price (IMPORTANT)
                    null // quantity (IMPORTANT)
                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Product deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Product not found or already deleted!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error deleting product: " + e.getMessage());
        }
    }

}
