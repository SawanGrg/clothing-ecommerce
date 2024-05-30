package com.ecommerce.model;

public class AdminCarts {
	
    private int cartId;
    private String userName;
    private String productName;
    private int quantity;
    private float totalPrice;
    private int checkout;
    
    public AdminCarts() {
    	
    }
    
    public AdminCarts(int cartId, String userName, String productName, int quantity, float totalPrice, int checkout) {
        this.cartId = cartId;
        this.userName = userName;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.checkout = checkout;
    }

    // Getter and setter methods for cartId
    public int getCartId() {
        return cartId;
    }
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    
    // Getter and setter methods for userName
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
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
    
    // Getter and setter methods for checkout
    public int getCheckout() {
        return checkout;
    }
    public void setCheckout(int checkout) {
        this.checkout = checkout;
    }
}