package com.ecommerce.model;

public class CartDetails {
	private int cartId;
	private int quantity;
	private float totalAmount;
	private int productId;
	private int userId;

	public CartDetails() {

	}

	public CartDetails(int cartId, int quantity, float totalAmount, int productId, int userId) {
		
		this.cartId = cartId;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.productId = productId;
		this.userId = userId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
