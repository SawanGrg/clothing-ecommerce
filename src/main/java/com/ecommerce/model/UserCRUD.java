package com.ecommerce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import com.ecommerce.databaseconnection.*;

public class UserCRUD {

	private DatabaseConnection dcon;
	private Connection con;

	String update_user = "update users set userName = ?, userEmail = ?, userPassword = ?, userContact = ?,userAddress = ? where userId = ?; ";

	public UserCRUD() {
		this.dcon = new DatabaseConnection();
		this.con = dcon.getConnection();
	}

	// update the user
	public boolean updateUser(UsersDetails userDetails) throws SQLException {

		boolean status = false;

		PreparedStatement ps = this.con.prepareStatement(update_user);
		try {

			ps.setString(1, userDetails.getUserName());
			ps.setString(2, userDetails.getUserEmail());
			ps.setString(3, userDetails.getUserPassword());
			ps.setString(4, userDetails.getUsercontact());
			ps.setString(5, userDetails.getUserAddress());

			System.out.println("hello before");

			ps.setInt(6, userDetails.getUserId());

			System.out.println("hello after");

			System.out.println(userDetails.getUserName());
			System.out.println(userDetails.getUserEmail());
			System.out.println(userDetails.getUserPassword());
			System.out.println(userDetails.getUsercontact());
			System.out.println(userDetails.getUserAddress());
			System.out.println(userDetails.getUserId());

			status = ps.executeUpdate() > 0;

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("error came in update users");
		}

		return status;
	}

	// take out user id from certain user with user name and password for session management
		public Integer checkUserId(String userName, String password) {

			Integer id = null;
			String query = "select userId from users where userName = ? and userPassword = ?";

			try {
				PreparedStatement ps = con.prepareStatement(query);

				EncryptDecrypt1 ed = new EncryptDecrypt1();
				String encryptedPassword = ed.encrypt(password);

				ps.setString(1, userName);
				ps.setString(2, encryptedPassword);

				System.out.println(userName);
//				System.out.println(password);

				ResultSet rs = ps.executeQuery();

				System.out.println(password);

				if (rs.next()) {

					id = rs.getInt("userId");

					System.out.println(id);

				}

			} catch (SQLException e) {

				e.printStackTrace();
				System.out.println("error came in while taking out user id for updating users");

			}
			return id;

		}

	// take out user id from certain user with user name and password for updating
	// user details
	public Integer checkUserIdByUserEmail(String userEmail, String password) {

		Integer id = null;

		String query = "select userId from users where userEmail = ?";

		try {

			PreparedStatement ps = this.con.prepareStatement(query);

			ps.setString(1, userEmail);
//				ps.setString(2, password);

			System.out.println(userEmail);
//				System.out.println(password);

			ResultSet rs = ps.executeQuery();

			System.out.println(password);

			if (rs.next()) {

				id = rs.getInt("userId");

				System.out.println(id);

			}

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("error came in while taking out user id for updating users");

		}
		return id;

	}

	// fetching data from database to display input jsp page
	public List<UsersDetails> getUserDetails(int userId) {

		List<UsersDetails> userAL = new ArrayList<UsersDetails>();

		String query = "select * from users where userId = " + userId;
		try {

			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				UsersDetails user = new UsersDetails();

				user.setUserEmail(rs.getString("userEmail"));
				user.setUserName(rs.getString("userName"));
				user.setUserAddress(rs.getString("userAddress"));
				user.setUsercontact(rs.getString("userContact"));

				userAL.add(user);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userAL;

	}

	// for add to cart button we fetch data from database to display items
	public List<GetProductDetails> getProductDetails() throws ClassNotFoundException {

		List<GetProductDetails> productAL = new ArrayList<>();

		String query = "select * from products";
		
		PreparedStatement ps;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ps = this.con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				GetProductDetails productDetail = new GetProductDetails();

				productDetail.setProductId(rs.getInt("productId"));
				productDetail.setProductName(rs.getString("productName"));
				productDetail.setPrice(rs.getFloat("productPrice"));
				productDetail.setStock(rs.getInt("productStock"));
				productDetail.setImage(rs.getString("productImage"));

				productAL.add(productDetail);

			}
		} catch (SQLException e) {

			System.out.print("error came while displaying add to cart button ");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productAL;
	}

}
