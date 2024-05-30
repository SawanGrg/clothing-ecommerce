package com.ecommerce.model;

public class UserCarts {

    private String productName;
    private int quantity;
    private float totalPrice;
    
    public UserCarts() {
    	
    }
    
    public UserCarts(String productName, int quantity, float totalPrice) {

        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;

    }
    
    // Getter and setter methods for productName
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    // Getter and setter methods for quantity
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    // Getter and setter methods for totalPrice
    public float getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

}