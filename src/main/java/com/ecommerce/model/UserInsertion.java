package com.ecommerce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ecommerce.databaseconnection.*;

public class UserInsertion {

	private DatabaseConnection dcon;
	private Connection conn;

	public UserInsertion() {
		this.dcon = new DatabaseConnection();
		
	}

	public int userInputting(UsersDetails userDetails) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.conn = this.dcon.getConnection();
		int result = 0;

		String query = "INSERT INTO users (userFirstName, userLastName, userName, UserEmail, userPassword, userContact, userAddress, UserImage, UserGender, role) VALUES (?,?,?,?,?,?,?,?,?,?)";

		try {
			EncryptDecrypt1 ed = new EncryptDecrypt1();
			String encryptedPassword = ed.encrypt(userDetails.getUserPassword());

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, userDetails.getUserFirstName());
			ps.setString(2, userDetails.getUserLastName());
			ps.setString(3, userDetails.getUserName());
			ps.setString(4, userDetails.getUserEmail());
			ps.setString(5, encryptedPassword);
			ps.setString(6, userDetails.getUsercontact());
			ps.setString(7, userDetails.getUserAddress());
			
			ps.setString(8, userDetails.getUserImage());
			
			ps.setString(9, userDetails.getUserGender());

			ps.setString(10, (userDetails.getUserRole()));

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error came in insertion");
		}

		return result;
	}
}
