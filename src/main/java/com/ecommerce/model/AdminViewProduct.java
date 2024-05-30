package com.ecommerce.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.databaseconnection.*;
public class AdminViewProduct {
	

	GetProductDetailsAdmin productDetails = new GetProductDetailsAdmin();
	
		private DatabaseConnection connection;
		private Connection con;
		
		private String query;
		
		private List<GetProductDetailsAdmin> details;

		public AdminViewProduct() {
			this.connection = new DatabaseConnection();
			this.con = connection.getConnection();
		}

		public List<GetProductDetailsAdmin> extractDetails() {
			
			details = new ArrayList<>();
			
			try {
				
				query = "SELECT p.productId, p.productName, p.productPrice, p.productImage, p.productBrand, p.productStock, c.categoryName FROM products p join category c on c.categoryId=p.categoryId";
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				PreparedStatement ps = con.prepareStatement(query);
				
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {

					details.add(new GetProductDetailsAdmin(rs.getInt("productId"),rs.getString("productName"),rs.getFloat("productPrice"),rs.getInt("productStock"),rs.getString("productImage"),rs.getString("categoryName"),rs.getString("productBrand")));
						
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(GetProductDetailsAdmin pd : details) {
				System.out.println(pd.getProductName());
			}
				
			return details;
		}
		
		

	}
	
	
	

