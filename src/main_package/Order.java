/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_package;

/**
 *
 * @author user
 */
public class Order {
    
    
    private Product product1;
    private int quantity1;
    private Product product2;
    private int quantity2;
    
    
    private String paymentMethod;
    
    private float deliveryFee;
    private float subtotal;
    private float grandTotal;
    private String shippingMethod;
    
    public Order(Product product1, int quantity1, Product product2, int quantity2,
            String paymentMethod, float deliveryFee, float subtotal, float grandTotal, String shippingMethod
            ){
        
        this.product1 = product1;
        this.quantity1 = quantity1;
        this.product2 = product2;
        this.quantity2 = quantity2;
        this.paymentMethod = paymentMethod;
        this.deliveryFee = deliveryFee;
        this.subtotal = subtotal;
        this.grandTotal = grandTotal;
        this.shippingMethod = shippingMethod;
    }
    
    public String getShippingMethod(){
        return shippingMethod;
    }
    
    public Product getProduct1(){
        return product1;
    }
    
    public int getQuantity1() {
        return quantity1;
    }
    
    public Product getProduct2() {
        return product2;
    }
    
    public int getQuantity2() {
        return quantity2;
    }
    
    public String getPaymentMethod(){
        return paymentMethod;
    }
    
    public float getDeliveryFee() {
        return deliveryFee;
    }
    
    public float getSubtotal() {
        return subtotal;
    }
    
    public float getGrandTotal(){
        return grandTotal;
    }
    
    
    
    
    
}
