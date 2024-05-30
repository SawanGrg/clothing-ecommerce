package com.ecommerce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.databaseconnection.*;

public class FilterResults {

	private DatabaseConnection dc;
	private Connection con;
	private List<Object> searchResult;
	private PreparedStatement ps;
	private ResultSet rs;
	private String query;
	
	public FilterResults() {
		this.dc = new DatabaseConnection();
		this.con = dc.getConnection();
		this.ps = null;
		this.rs = null;
		this.query = null;
	}

	public List<Object> getSearchByBrand(String filter){
		 searchResult = new ArrayList<>();
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				query = "	SELECT * FROM products ORDER BY productBrand ASC;";
				ps = con.prepareStatement(query);
				
				rs = ps.executeQuery();
				
				if(rs.next()) {
					do {
						
						searchResult.add(rs.getString("productImage"));
						searchResult.add(rs.getString("productName"));
						searchResult.add(rs.getFloat("productPrice"));
						searchResult.add(rs.getInt("productStock"));
					}while(rs.next());
					
					}
				

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return searchResult;
	}
	public List<Object> getSearchByPriceASC(String filter){
		 searchResult = new ArrayList<>();
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				query = "select * from products ORDER BY productPrice ASC; ";
				ps = con.prepareStatement(query);
				

				
				rs = ps.executeQuery();
				
				if(rs.next()) {
					do {
						
						searchResult.add(rs.getString("productImage"));
						searchResult.add(rs.getString("productName"));
						searchResult.add(rs.getFloat("productPrice"));
						searchResult.add(rs.getInt("productStock"));
						
					}while(rs.next());
					
					}
					
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return searchResult;
	}
	
	
	public List<Object> getSearchByPriceDESC(String filter){
		 searchResult = new ArrayList<>();
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				query = "select * from products ORDER BY productPrice DESC; ";
				ps = con.prepareStatement(query);
				

				
				rs = ps.executeQuery();
				
				if(rs.next()) {
					do {
						
						searchResult.add(rs.getString("productImage"));
						searchResult.add(rs.getString("productName"));
						searchResult.add(rs.getFloat("productPrice"));
						searchResult.add(rs.getInt("productStock"));
						
					}while(rs.next());
					
					}
					
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return searchResult;
	}
	
	public List<Object> getSearchByDefault(String filter){
		 searchResult = new ArrayList<>();
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				query = "select * from products ORDER BY productName ASC; ";
				ps = con.prepareStatement(query);
				

				
				rs = ps.executeQuery();
				
				if(rs.next()) {
					do {
						
						searchResult.add(rs.getString("productImage"));
						searchResult.add(rs.getString("productName"));
						searchResult.add(rs.getFloat("productPrice"));
						searchResult.add(rs.getInt("productStock"));
						
					}while(rs.next());
					
					}
					
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return searchResult;
	}

	public List<Object> getSearchByCategory(String filter){
		 searchResult = new ArrayList<>();
		 try {
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				query = "SELECT products.* FROM products JOIN category ON products.categoryId = category.categoryId ORDER BY categoryName ASC;";
				ps = con.prepareStatement(query);
				
				rs = ps.executeQuery();
				if(rs.next()) {
					do {
						
						searchResult.add(rs.getString("productImage"));
						searchResult.add(rs.getString("productName"));
						searchResult.add(rs.getFloat("productPrice"));
						searchResult.add(rs.getInt("productStock"));
						
					}while(rs.next());
				}	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return searchResult;
	}
}