package com.ecommerce.controller;


import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.ecommerce.model.AddProductsAdmin;
import com.ecommerce.model.AdminViewProduct;
import com.ecommerce.model.CartCRUD;
import com.ecommerce.model.CartProductView;
import com.ecommerce.model.CategoryDetails;
import com.ecommerce.model.CheckUserLogin;
import com.ecommerce.model.GetProductDetails;
import com.ecommerce.model.GetProductDetailsAdmin;
import com.ecommerce.model.UserCRUD;
import com.ecommerce.model.UsersDetails;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("user ko :"+username);
		System.out.println("user ko :"+password);

		
		UserCRUD userCRUD = new UserCRUD();
		AddProductsAdmin addProductsAdmin = new AddProductsAdmin();
		
		
		CheckUserLogin checkUserLogin = null;
		try {
			checkUserLogin = new CheckUserLogin();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		int sessionTimeout = 15 * 60; // 15 minutes in seconds
	    session.setMaxInactiveInterval(sessionTimeout);

	    try {

			if (checkUserLogin.checkingUser(username, password)) {
				
				System.out.println("user ko testing :1:"+username);
				
				int role = checkUserLogin.checkRole(username, password);
				
				System.out.println("user ko testing 2"+username);

				System.out.println("user ko :"+username);
				System.out.println("user ko :"+password);
				
				if (role == 1) {
					
					GetProductDetailsAdmin getProductDetailsAdmin = new GetProductDetailsAdmin();
					
					session.setAttribute("adminSession", username);
					session.setAttribute("adminId", userCRUD.checkUserId(username, password));
					
					// a session list to display category details to add in products table in db
					List<CategoryDetails> categoryAL = addProductsAdmin.getCategoryDetails();
					session.setAttribute("categoryAL", categoryAL);
					
					//admin viewing the page
					List<GetProductDetailsAdmin> productAL = new AdminViewProduct().extractDetails();
					session.setAttribute("AdminViewProduct", productAL);
					
					
					System.out.println("testing admin id");
					System.out.println(session.getAttribute("adminId"));
					
					response.sendRedirect( request.getContextPath()+"/view/admin.jsp");
				} else {
					session.setAttribute("userSession", username);
					session.setAttribute("userId", userCRUD.checkUserId(username, password));
					session.getAttribute("userId");
					
					System.out.println("testing user id");
					System.out.println("user has a unique user id :"+session.getAttribute("userId"));
					
					// for user update part session 
					
					int userId = (int)session.getAttribute("userId");
					
					List<UsersDetails> list = userCRUD.getUserDetails(userId);
					session.setAttribute("list", list);
					
					// for add to cart part session updating the product details fro viewing also 
					
					List<GetProductDetails> productAL = userCRUD.getProductDetails(); 
					session.setAttribute("productAL", productAL);
					
					//view your carts user side
					
					CartCRUD cartCRUD = new CartCRUD();
					
					List<CartProductView>cartAL = cartCRUD.getCartsDetails(userId);
					session.setAttribute("cartAL", cartAL);
					
					response.sendRedirect(request.getContextPath()+"/view/homepage.jsp");
					
				}
			} else {
				
				session.setAttribute("incorrectPassword", "something went wrong with username or password");
				System.out.println("error came in login servlet");

				response.sendRedirect(request.getContextPath()+"/view/Login.jsp");
				
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}