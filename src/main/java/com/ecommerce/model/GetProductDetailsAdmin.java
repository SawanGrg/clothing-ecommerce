package com.ecommerce.model;

public class GetProductDetailsAdmin {
	
		private int productId;
		private String productName;
		private float price;
		private int stock;
		private String image;
		private String productBrand;
		private String categoryName;
		

		public GetProductDetailsAdmin() {
			
		}
		
		
		public GetProductDetailsAdmin(int productId, String productName, float price, int stock, String image,
				String categoryName, String productBrand) {	
			this.productId = productId;
			this.productName = productName;
			this.price = price;
			this.stock = stock;
			this.image = image;
			this.categoryName = categoryName;
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

		public String getProductBrand() {
			return productBrand;
		}

		public void setProductBrand(String productBrand) {
			this.productBrand = productBrand;
		}
		
		public String getCategoryName() {
			return categoryName;
		}
		
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName; 
		}

	
}
