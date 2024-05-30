package com.ecommerce.model;

public class Carts {

	private int cartId;
	private int quantity;
	private float totalPrice;
	private int productId;
	private int userId;
	public int checkout;

	public Carts() {

	}

	public Carts(int cartId, int quantity, float totalPrice, int productId, int userId, int checkout) {
		
		this.cartId = cartId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.productId = productId;
		this.userId = userId;
		this.checkout = checkout;
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

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
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
	public int getCheckout() {
		return checkout;
	}

	public void setCheckout(int checkout) {
		this.checkout = checkout;
	}

}
