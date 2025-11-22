/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_package;

/**
 *
 * @author user
 */
public class CartItem {
    
    String name;
    float price;
    String imagePath;
    int quantity;

    public CartItem(String name, float price, String imagePath, int quantity) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
        this.quantity = quantity;
    }

    // Get total price for this item
    public float getTotalPrice() {
        return price * quantity;
    }
    
}
