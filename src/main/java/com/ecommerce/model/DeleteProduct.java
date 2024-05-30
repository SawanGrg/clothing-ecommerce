package com.ecommerce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecommerce.databaseconnection.DatabaseConnection;

public class DeleteProduct {

	private DatabaseConnection dc;
	private Connection con;

	public DeleteProduct() {
		this.dc = new DatabaseConnection();
		this.con = dc.getConnection();

	}

	public void deleteProduct(int id) {
		String query = "Delete from carts where productId = ?";
		String query1 = "Delete from products where productId = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps = con.prepareStatement(query1);
			ps.setInt(1, id);
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
