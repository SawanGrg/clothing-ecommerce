package com.ecommerce.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseConnection {

	public Connection getConnection() {
		Connection conn = null;

		try {
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DatabaseCredentials.getDbName(), DatabaseCredentials.getDbUsername(),DatabaseCredentials.getDbPassword());
			if(conn!=null) {
				System.out.println("Got the data");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	
	
	

}
