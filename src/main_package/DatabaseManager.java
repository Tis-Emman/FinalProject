package main_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;
import javax.swing.JLabel;

import org.mindrot.jbcrypt.BCrypt;

public class DatabaseManager {
    
    static String URL = "jdbc:sqlite:inventory.db";
    
    public void insertAll(String name, String category, int price, int quantity){
        
        String sql = "INSERT INTO items (name, category, price, quantity) VALUES (?, ?, ?, ?) ";
        
        try(Connection conn = DriverManager.getConnection(URL);
                PreparedStatement stmt = conn.prepareStatement(sql)
                ){
            stmt.setString(1, name);
            stmt.setString(2, category);
            stmt.setInt(3, price);
            stmt.setInt(4, quantity);
            
            stmt.executeUpdate();
            System.out.println("Product inserted succesfully!");
        } catch (SQLException e){
            System.out.println("ERROR: " + e.getMessage());
        }  
    }
    
    public void insertUserInfo(String fullName, String email, String password){
        
        String sql = "INSERT INTO users (full_name, email, password) VAlUES (?, ?, ?)";
        
        try(Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)
                ){
            pstmt.setString(1, fullName);
            pstmt.setString(2, email);
            String hashedPass = BCrypt.hashpw(password, BCrypt.gensalt());
            pstmt.setString(3, hashedPass);
            
            pstmt.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public boolean checkEmailExist(String email, JLabel label){
        
        String sql = "SELECT * FROM users WHERE email = ?";
        
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql)
                ){
                
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            
            return rs.next();
            
            }catch(SQLException e){
                System.out.println("Error: " + e.getMessage());
                return false;
            }
    }
    
    public boolean readEmailPass(String email, String password){
        
        String sql = "SELECT password FROM users WHERE email = ?";
        
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql)
                ){
            
            pstmt.setString(1, email);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                String storedHash = rs.getString("password");
                
                
                if(BCrypt.checkpw(password, storedHash)){
                    return true;
                }else{
                    return false;
                }
            } else{
                return false;
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    /*
    public void insertName(String name){

        String sql = "INSERT INTO items (name) VALUES (?) ";
        
        try(Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)
                ){
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println(name + " inserted into items!");
            
        }catch(SQLException e){
            System.out.println("Error! " + e.getMessage());
        }
    }

*/
    
    public void subtractQnty(int quantityToSubtract, int id){
        String sql = "UPDATE items SET quantity = quantity - ? WHERE id = ?";
        
        try(Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)
                ){
            
            pstmt.setInt(1, quantityToSubtract);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            
            if(rows > 0){
                System.out.println("Quantity updated!");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void addQnty(int quantityToAdd, int id){
        String sql = "UPDATE items SET quantity = quantity + ? WHERE id = ?";
        
        try(Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)
                ){
            pstmt.setInt(1, quantityToAdd);
            pstmt.setInt(2, id);
            
            int rows = pstmt.executeUpdate();
            
            if(rows > 0){
                System.out.println("Quantity updated!");
            }
            
        }catch(SQLException e){
            System.out.println("Error!");
        }
    }
    
    public void addOne(int id){
        String sql = "UPDATE items SET quantity = quantity + 1 WHERE id = ?";
        try(Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setInt(1, id);
            
            int rows = pstmt.executeUpdate();
            
            if(rows > 0){
                System.out.println("Items updated!");
            }
        }
        
        catch(SQLException e){
            System.out.println("Error "  + e.getMessage());
        }  
    }
    
    public void subtractOne(int id){
        String sql = "UPDATE items SET quantity = quantity - 1 WHERE id = ?";
        
        try(Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)
                ){
            pstmt.setInt(1, id);
            
            int rows = pstmt.executeUpdate();
            
            if(rows > 0){
                System.out.println("Items updated!");
            }
            
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void update(int quantity, int id){
        String sql = "UPDATE items SET quantity = quantity + ? WHERE id = ?";
        try(Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, id);
            
            int rows = pstmt.executeUpdate();
            
            if(rows > 0){
                System.out.println("Items updated!");
            }
        }
        
        catch(SQLException e){
            System.out.println("Error "  + e.getMessage());
        }
    }
    
    public void display(){
        
        String query = "SELECT * FROM items";
        
        try{
            Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int qnty = rs.getInt("quantity");
                
                System.out.println("ID: " + id + " | Name: " + name + " | Price: " + price + " | Quantity: " + qnty);
            }
            
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private String id;
    
    
   public void displayQuantity(int id){
       
       String query = "SELECT quantity FROM items WHERE id = ?";
       
       try(Connection conn = DriverManager.getConnection(URL);
           PreparedStatement pstmt = conn.prepareStatement(query)
               ){
           
           pstmt.setInt(1, id);
           ResultSet rs = pstmt.executeQuery();
           while(rs.next()){
               int qnty = rs.getInt(URL);
               pstmt.executeUpdate();
           }
           
       }catch(SQLException e){
           
       }
   }

    
}
