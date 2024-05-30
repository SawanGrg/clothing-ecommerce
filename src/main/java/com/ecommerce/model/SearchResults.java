package com.ecommerce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.databaseconnection.*;

public class SearchResults {

	private DatabaseConnection dc;
	private Connection con;
	private List<Object> searchResult;
	private PreparedStatement ps;
	private ResultSet rs;
	private String query;
	
	public SearchResults() {
		this.dc = new DatabaseConnection();
		this.con = dc.getConnection();
		this.ps = null;
		this.rs = null;
		this.query = null;
	}
	public List<Object> getSearchByAll(String filter, String searchInput){
		 searchResult = new ArrayList<>();
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			query = "select * from products where productName like ?";
			ps = con.prepareStatement(query);
			ps.setString(1, "%"+searchInput+"%");
			System.out.println("%"+searchInput+"%");
			rs = ps.executeQuery();
			
			if(rs.next()) {
				do {
					
					searchResult.add(rs.getString("productImage"));
					searchResult.add(rs.getString("productName"));
					searchResult.add(rs.getFloat("productPrice"));
					searchResult.add(rs.getInt("productStock"));
					
				}while(rs.next());
				}
			
			System.out.println(searchResult);
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 return searchResult;
	} 
	public List<Object> getSearchByBrand(String filter, String searchInput){
		 searchResult = new ArrayList<>();
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				query = "select * from products where productBrand like ?";
				ps = con.prepareStatement(query);
				ps.setString(1, "%"+searchInput+"%");
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
	public List<Object> getSearchByPrice(String filter, String searchInput){
		 searchResult = new ArrayList<>();
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				query = "select * from products where productPrice <= ?";
				ps = con.prepareStatement(query);
				ps.setDouble(1, Double.parseDouble(searchInput));

				
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

	public List<Object> getSearchByCategory(String filter, String searchInput){
		 searchResult = new ArrayList<>();
		 try {
			 System.out.println(searchInput);
				Class.forName("com.mysql.cj.jdbc.Driver");
				query = "SELECT products.* FROM products JOIN category ON products.categoryId = category.categoryId WHERE category.categoryName LIKE ?";
				ps = con.prepareStatement(query);
				ps.setString(1, "%"+searchInput+"%");
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