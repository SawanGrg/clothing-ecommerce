package com.ecommerce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.databaseconnection.DatabaseConnection;

public class UpdateProduct {

	private DatabaseConnection dc;
	private Connection con;
	private List<GetProductDetailsAdmin> productDetails;
	GetProductDetailsAdmin details;
	private int result;

	public UpdateProduct() {
		this.dc = new DatabaseConnection();
		this.con = dc.getConnection();
		this.productDetails = new ArrayList<>();
	}

	public List<GetProductDetailsAdmin> getProductDetails(int id) {
		String query = "SELECT p.productId, p.productName, p.productPrice, p.productImage, p.productBrand, p.productStock, c.categoryName FROM products p join category c on c.categoryId=p.categoryId where p.productId = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				productDetails.add(new GetProductDetailsAdmin(rs.getInt("productId"), rs.getString("productName"),
						rs.getFloat("productPrice"), rs.getInt("productStock"), rs.getString("productImage"),
						rs.getString("categoryName"), rs.getString("productBrand")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productDetails;
	}

	public int updateProduct(GetProductDetails details) throws ClassNotFoundException {

		this.result = 0;

		try {

			String query = "UPDATE products SET productName = ?, productStock = ?, productPrice = ?, productBrand = ?, productImage = ?, categoryId = ? WHERE productId = ?";

			PreparedStatement ps = con.prepareStatement(query);

			

			ps.setString(1, details.getProductName());
			ps.setInt(2, details.getStock());
			ps.setFloat(3, details.getPrice());
			ps.setString(4, details.getProductBrand());
			ps.setString(5, details.getImage());
			ps.setInt(6, details.getCategory());
			ps.setInt(7, details.getProductId());

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

}
