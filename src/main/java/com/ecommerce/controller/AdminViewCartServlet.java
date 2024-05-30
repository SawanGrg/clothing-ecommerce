package com.ecommerce.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.ecommerce.model.AdminCarts;
import com.ecommerce.model.CartCRUD;
import com.ecommerce.model.Carts;

@WebServlet("/AdminViewCarts")
public class AdminViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminViewCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    CartCRUD cartCRUD = new CartCRUD();
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		//session for admin viewing the carts of all users
		List<AdminCarts> cartsAL = cartCRUD.viewUsersCart();
		session.setAttribute("adminViewCarts", cartsAL);
		
		response.sendRedirect(request.getContextPath()+"/view/adminViewCarts.jsp");
		
	}

}