package com.ecommerce.model;

public class GetProductDetails {

	private int productId;
	private String productName;
	private float price;
	private int stock;
	private String image;
	private int category;
	private String productBrand;

	public GetProductDetails() {
		
	}
	
	public GetProductDetails(int productId, String productName, float price, int stock, String image,
		int category, String productBrand) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
		this.image = image;
		this.category = category;
		this.productBrand = productBrand;
	}
	
	public GetProductDetails(String productName, float price, int stock, String image,
			int category, String productBrand) {	
		this.productName = productName;
		this.price = price;
		this.stock = stock;
		this.image = image;
		this.category = category;
		this.productBrand = productBrand;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

}