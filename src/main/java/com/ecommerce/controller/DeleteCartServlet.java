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

@WebServlet("/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		System.out.println("cart id of deleting is :"+ cartId);
		
		CartCRUD cartCRUD = new CartCRUD();
		cartCRUD.deleteCart(cartId);
		
		//view your carts user side
		int userId = (int)session.getAttribute("userId");
		List<CartProductView>cartAL = cartCRUD.getCartsDetails(userId);
		session.setAttribute("cartAL", cartAL);
		
		response.sendRedirect(request.getContextPath()+"/view/cart.jsp");
	}

}