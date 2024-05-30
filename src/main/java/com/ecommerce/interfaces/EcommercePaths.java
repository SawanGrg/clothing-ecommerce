package com.ecommerce.interfaces;


import java.sql.SQLException;
import java.util.List;
import com.ecommerce.model.UsersDetails;

public interface EcommercePaths {
	
//----------------------------------------------------------------------------------------------------------//	
	//userCRUD
	
	UsersDetails selectUserById(int userId);
	
	List<UsersDetails> selectAllUsers();
	
	boolean deleteUser(int userId) throws SQLException;
	
	boolean updateUser(UsersDetails userDetails) throws SQLException;
	
	
	
//----------------------------------------------------------------------------------------------------------//	
	//paths to master branch
	String masterPath = "/CourseWork";
	
	
	
//----------------------------------------------------------------------------------------------------------//	
	//paths to controller
	
	
	String ControllerMainPath = "/ecommerce/controller";
	
	String ServletloginPath = ControllerMainPath + "/LoginServlet";
	
	
//----------------------------------------------------------------------------------------------------------//	
	//paths to views
	
    
    
    String viewFolder= masterPath + "/views";
    
    String registerFolder = viewFolder + "/register.html";
    
    String viewLoginPath = viewFolder + "/login.html";
    
    String errorPath = viewFolder + "/errorPage.jsp";

}
