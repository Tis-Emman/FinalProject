/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_package;

/**
 *
 * @author user
 */
public class Product {
    
    private String name;
    private float price;
    private String imagePath;
    private int stock;
    
    
    public Product(String name, float price, String imagePath, int stock){
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
        this.stock = stock;
    }
    
    public String getName(){
        return name;
    }
    
    public float getPrice() {
        return price;
    }
    
    public String getImagePath(){
        return imagePath;
    }
    
    public int getStock(){
        return stock;
    }
}
