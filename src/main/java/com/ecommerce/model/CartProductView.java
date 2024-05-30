package com.ecommerce.model;

public class CartProductView {

	private int cartId;
	private int productQuantity;
	private float totalPrice;
	private String productName;
	
	public CartProductView() {
		
	}

	public CartProductView(int cartId, int productQuantity, float totalPrice, String productName) {

		this.cartId = cartId;
		this.productQuantity = productQuantity;
		this.totalPrice = totalPrice;
		this.productName = productName;
	}

	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public float getProductPrice() {
		return totalPrice;
	}
	public void setProductPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
