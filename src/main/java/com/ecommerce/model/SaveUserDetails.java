package com.ecommerce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.databaseconnection.*;

public class SaveUserDetails {

	private DatabaseConnection dc;
	private Connection con;
	private List<Object> searchResult;
	private PreparedStatement ps;
	private ResultSet rs;
	private String query;
	
	public SaveUserDetails() {
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
			
				while(rs.next()) {
					searchResult.add(rs.getString("image"));
					searchResult.add(rs.getString("productName"));
					searchResult.add(rs.getInt("price"));
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
				
					while(rs.next()) {
						searchResult.add(rs.getString("image"));
						searchResult.add(rs.getString("productName"));
						searchResult.add(rs.getInt("price"));
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
				query = "select * from products where price like ?";
				ps = con.prepareStatement(query);
				ps.setString(1, "%"+searchInput+"%");
				rs = ps.executeQuery();
				
					while(rs.next()) {
						searchResult.add(rs.getString("image"));
						searchResult.add(rs.getString("productName"));
						searchResult.add(rs.getInt("price"));
					
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
	public List<Object> getSearchByCategory(String filter, String searchInput){
		 searchResult = new ArrayList<>();
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				query = "select * from products where category like ?";
				ps = con.prepareStatement(query);
				ps.setString(1, "%"+searchInput+"%");
				rs = ps.executeQuery();
				if(rs.next()) {
					while(rs.next()) {
						searchResult.add(rs.getString("image"));
						searchResult.add(rs.getString("productName"));
						searchResult.add(rs.getInt("price"));
					}
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
