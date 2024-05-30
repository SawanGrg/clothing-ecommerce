package com.ecommerce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.dbConfig.DatabaseConnection;

public class ExtractCartDetails {

private DatabaseConnection dc;
private Connection con;
private String query;
private  List<CartDetails> cartDetails;
	public ExtractCartDetails() {
	this.dc = new DatabaseConnection();
	this.con = dc.getConnect();
	this.cartDetails = new ArrayList<>();
}
	
	public List<CartDetails> getCartDetails(int Id) {
		query = "select * from carts where id = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, Id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartDetails details = new CartDetails();
				details.setCartId(rs.getInt("cartId"));
				details.setProductId(rs.getInt("productId"));
				details.setQuantity(rs.getInt("quantity"));
				details.setUserId(rs.getInt("userId"));
				details.setTotalAmount(rs.getFloat("totalAmount"));
			
				cartDetails.add(details);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartDetails;
		

		
	}

}
