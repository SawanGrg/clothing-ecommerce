package com.ecommerce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.dbConfig.DatabaseConnection;

public class AddProductsAdmin {

	private DatabaseConnection connection;
	private Connection con;

	private int result;

	public AddProductsAdmin() {
		this.connection = new DatabaseConnection();
		this.con = connection.getConnect();
	}

	public int addProduct(GetProductDetails details) throws ClassNotFoundException {

		this.result = 0;

		try {

			String query = "insert into products (productName, productStock, productPrice, productBrand, productImage, categoryId) values(?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

//			ps.setString(1, details.getProductId());

			ps.setString(1, details.getProductName());
			ps.setInt(2, details.getStock());
			ps.setFloat(3, details.getPrice());
			ps.setString(4, details.getProductBrand());
			ps.setString(5, details.getImage());
			ps.setInt(6, details.getCategory());

			System.out.println(details.getProductName());
			System.out.println(details.getStock());
			System.out.println(details.getPrice());
			System.out.println(details.getProductBrand());
			System.out.println(details.getImage());
			System.out.println(details.getCategory());

			result = ps.executeUpdate();

			System.out.println("testing after execute");

		} catch (SQLException e) {

			System.out.println("error came in sql insertion");
			e.printStackTrace();
		}
		return result;

	}

	public int addCategory(CategoryDetails categoryDetails) throws ClassNotFoundException {

		int check = 0;

		try {

			String query1 = "insert into category (categoryName) values (?)";

			PreparedStatement ps = con.prepareStatement(query1);

			System.out.println("checking error " + categoryDetails.getCategoryName());
			ps.setString(1, categoryDetails.getCategoryName());

			result = ps.executeUpdate();

		} catch (SQLException e) {

			System.out.println("error came in sql insertion");
			e.printStackTrace();
		}
		return check;
	}

	//an list method to take out the category table details
	public List<CategoryDetails> getCategoryDetails(){
		
		List<CategoryDetails> categoryAL = new ArrayList<CategoryDetails>();
		
		String query = "select * from category";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				CategoryDetails categoryDetails = new CategoryDetails();
				
				categoryDetails.setCategoryId(rs.getInt("categoryId"));
				categoryDetails.setCategoryName(rs.getString("categoryName"));
				
				categoryAL.add(categoryDetails);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return categoryAL;
	}
	
}