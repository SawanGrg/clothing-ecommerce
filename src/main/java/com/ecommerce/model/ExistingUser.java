package com.ecommerce.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecommerce.databaseconnection.DatabaseConnection;
public class ExistingUser {
		private DatabaseConnection dc;
		private Connection con;
		private String query;
		private String dbusername;

		public ExistingUser() {

			this.dc = new DatabaseConnection();
			this.con = dc.getConnection();
		}

		public String getUsername(UsersDetails ud) {

			this.query = "select username from registerdetails where username = ?";
		    
		    try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1,ud.getUserName());

				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					dbusername = rs.getString("username");
					System.out.println(dbusername);
					return dbusername;
				} else {
					return "hell";

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

		}


}
