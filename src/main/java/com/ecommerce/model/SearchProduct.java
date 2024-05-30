package com.ecommerce.model;

import java.sql.Connection;

import com.ecommerce.databaseconnection.*;

public class SearchProduct {
	
	private DatabaseConnection dcon;
	Connection con;

	public SearchProduct() {
		this.dcon = new DatabaseConnection();
		con = this.dcon.getConnection();
	}

	public void getProductbyId(int productId){
		
	}
}
