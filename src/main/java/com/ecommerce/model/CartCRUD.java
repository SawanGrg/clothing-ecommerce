package com.ecommerce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.dbConfig.DatabaseConnection;

public class CartCRUD {

	private DatabaseConnection dcon;
	private Connection con;

	public CartCRUD() {
		this.dcon = new DatabaseConnection();
		this.con = this.dcon.getConnect();
	}

	// insert into carts details into carts database
	public int insertOrder(Carts carts) throws ClassNotFoundException {
		int result = 0;
		String query = "insert into carts(userId, productId, quantity, totalPrice) values(?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, carts.getUserId());
			ps.setInt(2, carts.getProductId());
			ps.setInt(3, carts.getQuantity());
			ps.setFloat(4, carts.getTotalPrice());

			result = ps.executeUpdate();
			System.out.println("came here in insert query and method");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	// update the productStock column of products table
	public int updateStock(int productStock, int productId) {
		int result = 0;
		String query = "update products set productStock = ? where productId = ? ";

		System.out.println("testing "+productStock);
		System.out.println("testing " +productId);
		
		try {

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, productStock);
			ps.setInt(2, productId);

			System.out.println(productStock);
			System.out.println(productId);
			System.out.println("came here on update stock method");

			result = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public List<CartProductView> getCartsDetails(int userId) {

		List<CartProductView> cartAL = new ArrayList<>();

	    String query = "SELECT c.*, p.productName FROM carts c " +
                "JOIN products p ON c.productId = p.productId " +
                "WHERE c.userId = "+ userId +" AND c.checkout IS NULL";
	    
		try {

			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
			int cartId = rs.getInt("cartId");
			String productName = rs.getString("productName");
			int quantity = rs.getInt("quantity");
			float totalPrice = rs.getFloat("totalPrice");
			
			CartProductView cartProductView = new CartProductView(cartId, quantity, totalPrice, productName);
			
			cartAL.add(cartProductView);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cartAL;
	}
	// deleting user cart from view cart page
		public void deleteCart(int cartId) {
			String query = "delete from carts where cartId = ?";

			try {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, cartId);
				ps.executeUpdate();

				System.out.println("Successfully deleted specific cart");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// checking out the users cart or product checking out
		public int checkout(int cartId) {
			int result = 0;

			String query = "update carts set checkout = 1 where cartId = ?";

			try {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, cartId);
				ps.execute();

				System.out.println("Successfully checkout specific cart");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return result;

		}
		// admin can viewing the user's all cart
		public List<AdminCarts> viewUsersCart() {
			List<AdminCarts> cartDetailsAL = new ArrayList<>();

			String query = "SELECT c.cartId, u.userName, p.productName, c.quantity, c.totalPrice, c.checkout "
					+ "FROM carts c " + "JOIN users u ON c.userId = u.userId "
					+ "JOIN products p ON c.productId = p.productId";

			try {
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					int cartId = rs.getInt("cartId");
					String userName = rs.getString("userName");
					String productName = rs.getString("productName");
					int quantity = rs.getInt("quantity");
					float totalPrice = rs.getFloat("totalPrice");
					int checkout = rs.getInt("checkout");

					AdminCarts carts = new AdminCarts(cartId, userName, productName, quantity, totalPrice, checkout);

					cartDetailsAL.add(carts);

					System.out.println("Successfully view by admin of all cart");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return cartDetailsAL;
		}

		// user viewing the purchased product or history details
		public List<UserCarts> getPurchaseHistory(int userId) {

			List<UserCarts> userCartsAL = new ArrayList<>();

			String query = "SELECT p.productName, c.quantity, c.totalPrice " 
		             + "FROM carts c "
		             + "JOIN users u ON c.userId = u.userId "
		             + "JOIN products p ON c.productId = p.productId "
		             + "WHERE u.userId = ? "
		             + "AND c.checkout IS NOT NULL";
			
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, userId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					
					String productName = rs.getString("productName");
					int quantity = rs.getInt("quantity");
					float totalPrice = rs.getFloat("totalPrice");

					UserCarts userCarts = new UserCarts(productName, quantity, totalPrice);

					userCartsAL.add(userCarts);
					System.out.println(userCartsAL);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return userCartsAL;
			
		}
//		public List<GetProductDetails> extractDetails(){
//			
//			List<GetProductDetails> displayAL = new ArrayList<GetProductDetails>();
//			String query = "select productImage from products";
//			
//			Prepared
//			
//			return displayAL;
//			
//		}

}
