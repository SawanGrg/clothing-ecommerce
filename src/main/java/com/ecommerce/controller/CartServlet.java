package com.ecommerce.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.ecommerce.model.CartCRUD;
import com.ecommerce.model.CartProductView;
import com.ecommerce.model.Carts;
import com.ecommerce.model.GetProductDetails;
import com.ecommerce.model.UserCRUD;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserCRUD userCRUD = new UserCRUD();
	CartCRUD cartCRUD = new CartCRUD();

	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String checkUserSession = (String) session.getAttribute("userSession");

		System.out.println("hello testing session in add to cart by user");
		System.out.println(checkUserSession);

		if (checkUserSession == null) {

			response.sendRedirect(request.getContextPath() + "/view/Login.jsp");
			
		} else {
			
			int userId = (int)session.getAttribute("userId");
			
			int productId = Integer.parseInt(request.getParameter("productId"));
			
			//yo quantity should be minus and insert into product table
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			
			float totalPrice = Float.parseFloat(request.getParameter("totalPrice"));
			
			//default one click one item in carts table
			int cartQuantity = 1;
			
			System.out.println("quantity is :"+ quantity);
			//updating the quantity in products table in db
			int updatedStock = quantity - cartQuantity;
			
			// set gardini 
			Carts carts = new Carts();
			
			carts.setUserId(userId);
			carts.setProductId(productId);
			carts.setQuantity(cartQuantity);
			carts.setTotalPrice(totalPrice);
			
			System.out.println(userId);
			System.out.println(productId);
			System.out.println(quantity);
			System.out.println(totalPrice);
			
			//try and catch for updating the quantity in products table in db
			cartCRUD.updateStock(updatedStock, productId);
			
			
			//try and catch for add to carts going to model for insertion in db
			try {
				cartCRUD.insertOrder(carts);
				
				//declaration and session of list 
				UserCRUD userCRUD = new UserCRUD();
				List<GetProductDetails> productAL = userCRUD.getProductDetails(); 
				session.setAttribute("productAL", productAL);
				
				//view your carts user side
				
				CartCRUD cartCRUD = new CartCRUD();
				
				List<CartProductView>cartAL = cartCRUD.getCartsDetails(userId);
				session.setAttribute("cartAL", cartAL);
				
				response.sendRedirect(request.getContextPath()+"/view/products.jsp");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
