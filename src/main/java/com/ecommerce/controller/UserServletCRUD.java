package com.ecommerce.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import com.ecommerce.model.EncryptDecrypt1;
import com.ecommerce.model.UserCRUD;
import com.ecommerce.model.UsersDetails;


@WebServlet("/UserServletCRUD")
@MultipartConfig
public class UserServletCRUD extends HttpServlet {
	
	UserCRUD userCRUD = new UserCRUD();
	
	private static final long serialVersionUID = 1L;
       

    public UserServletCRUD() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doGet(request, response);

				UserCRUD userCRUD = new UserCRUD();

				HttpSession session = request.getSession();
				
				String email = request.getParameter("userEmail");
				String oldPassword = request.getParameter("userOldPassword");
				String newPassword = request.getParameter("userNewPassword");
				String userName = request.getParameter("userName");
				String contact = request.getParameter("userContact");
				String address = request.getParameter("userAddress");

				Part image = request.getPart("userImage");


				System.out.println("test 1");
				System.out.println(email);
				System.out.println(oldPassword);
				System.out.println(newPassword);
				System.out.println(userName);
				System.out.println(contact);
				System.out.println(address);			

			    System.out.println("test 2");
			    System.out.println("test 3");
				
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

				EncryptDecrypt1 ed = new EncryptDecrypt1();

				String encryptedPassword = ed.encrypt(newPassword);

				userDetails.setUserEmail(email);
				userDetails.setUserPassword(encryptedPassword);
				userDetails.setUserName(userName);
				userDetails.setUsercontact(contact);
				userDetails.setUserAddress(address);
				userDetails.setUserImage(imageName);

				userDetails.setUserId(userCRUD.checkUserIdByUserEmail(email, oldPassword));

				try {

					userCRUD.updateUser(userDetails);
					
					int userId = (int)session.getAttribute("userId");
					List<UsersDetails> list = userCRUD.getUserDetails(userId);
					session.setAttribute("list", list);
					
					response.sendRedirect(request.getContextPath() + "/view/homepage.jsp");

				} catch (SQLException e) {

					e.printStackTrace();

					System.out.println("error came in setting the variables0");
				}
	}

}
