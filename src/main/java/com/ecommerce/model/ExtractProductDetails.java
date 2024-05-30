package com.ecommerce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.databaseconnection.*;

public class ExtractProductDetails {
	
	private DatabaseConnection connection;
	private Connection con;
	
	private String query;
	
	private List<Object> details;

	public ExtractProductDetails() {
		this.connection = new DatabaseConnection();
		this.con = connection.getConnection();
	}

	public List<Object> extractDetails() {
		
		details = new ArrayList<>();
		
		try {
			
			query = "select * from products";
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {

				details.add(rs.getString("productImage"));
				details.add(rs.getString("productName"));
				details.add(rs.getInt("productPrice"));

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(details);
		return details;
	}
	
	public List<Object> extractDetailsByCategoryName(int categoryId) {
		
		details = new ArrayList<>();
		
		try {
			
			query = "select * from products where categoryId = "+ categoryId;
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {

				details.add(rs.getString("productImage"));
				details.add(rs.getString("productName"));
				details.add(rs.getInt("productPrice"));

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(details);
		
		return details;
	}

}