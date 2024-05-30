package com.ecommerce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecommerce.databaseconnection.*;
import com.mysql.cj.jdbc.Driver;

import jakarta.servlet.http.HttpSession;

public class CheckUserLogin {

	private DatabaseConnection dcon;
	Connection con;

	public CheckUserLogin() throws ClassNotFoundException {
		this.dcon = new DatabaseConnection();
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.con = this.dcon.getConnection();
	}

	HttpSession session;

	//checking userpassword of this username
	public boolean checkingUser(String username, String password) throws ClassNotFoundException {

		String query = "SELECT userPassword FROM users WHERE userName=?";
		boolean result = false;

		try {
			PreparedStatement ps = this.con.prepareStatement(query);

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

//				System.out.println("test3");
				EncryptDecrypt1 ed = new EncryptDecrypt1();
				String decryptedPassword = ed.decrypt(rs.getString("userPassword"));
				if (password.equals(decryptedPassword)) {

					result = true;

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int checkRole(String username, String password) {

		int status = 0; // Initialize to default value

		String checker = "SELECT role FROM users WHERE userName = ? AND userPassword = ?";

		try {
			EncryptDecrypt1 ed = new EncryptDecrypt1();

			String encryptedPassword = ed.encrypt(password);
			
			PreparedStatement checking = this.con.prepareStatement(checker);

			checking.setString(1, username);
			checking.setString(2, encryptedPassword);

			ResultSet rs = checking.executeQuery();

			while (rs.next()) {

//				System.out.println("test3");

				String role = rs.getString("role");

				if (role == null) {

					status = 2; // Set status to regular user

				} else {
					status = 1;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

}
