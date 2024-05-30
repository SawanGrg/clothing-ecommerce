package com.ecommerce.dbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ecommerce.dbConfig.*;

public class DatabaseConnection {
	
	//starting a connection
	public Connection getConnect() {
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ DatabaseCredentials.getDbName() ,DatabaseCredentials.getUserName(),DatabaseCredentials.getUserPassword());
			if (con!=null) {
				System.out.println("connection successfull");
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	return con;
	}
	


}
