package com.ecommerce.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.ecommerce.model.*;

@MultipartConfig
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	UserInsertion insertion = new UserInsertion();
	
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String firstName = request.getParameter("userFirstName");
	    String lastName = request.getParameter("userLastName");
	    
	    //unique garni 
	    String userName = request.getParameter("userName");
	    
	    
	    String userEmail = request.getParameter("userEmail");
	    String password = request.getParameter("userPassword");
	    String contact = request.getParameter("userContact");
	    String address = request.getParameter("userAddress");
//	    
//	    String image = request.getParameter("userImage");
	    
	    String gender = request.getParameter("userGender");
	    String checkBox = request.getParameter("verify");
	    
	    System.out.println(checkBox);
	    
	    
		Part image = request.getPart("userImage");
		
		String imageName = image.getSubmittedFileName();

		String uploadPath = "D:\\Apps\\CourseWork\\src\\main\\webapp\\Images\\" + imageName;
		
		try {
			
			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream input = image.getInputStream();

			byte[] data = new byte[input.available()];
			input.read(data);
			fos.write(data);
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    UsersDetails userDetails = new UsersDetails();

	    userDetails.setUserFirstName(firstName);
	    userDetails.setUserLastName(lastName);
	    userDetails.setUserName(userName);
	    userDetails.setUserEmail(userEmail);
	    userDetails.setUserPassword(password);
	    userDetails.setUsercontact(contact);
	    userDetails.setUserAddress(address);
	    userDetails.setUserImage(imageName);
	    userDetails.setUserGender(gender);
//	    userDetails.setUserRole(checkBox);
	    ExistingUser exists = new ExistingUser();
		String dbUsername = exists.getUsername(userDetails);
		System.out.println(dbUsername);
		if(dbUsername.equals(userDetails.getUserName())||!dbUsername.equals("hell")) {
		response.sendRedirect("register.jsp?name=username already exists");
		}
		else {
//			SaveUserDetails sd = new SaveUserDetails();
			try {
				insertion.userInputting(userDetails);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("Login.jsp");
		}
	    

	    response.sendRedirect(request.getContextPath()+"/view/Login.jsp");
	}

}