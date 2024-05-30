package com.ecommerce.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.ecommerce.model.CartDetails;
import com.ecommerce.model.Carts;
import com.ecommerce.model.ExtractCartDetails;

/**
 * Servlet implementation class GetCartDetails
 */
public class GetCartDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public GetCartDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		HttpSession session =request.getSession();
//		int id = (int)session.getAttribute("userId");
		
		CartDetails cartDetails = new CartDetails();
		
		ExtractCartDetails extractCarts = new ExtractCartDetails();
		
		List<CartDetails> cartList = extractCarts.getCartDetails(2);
//		session.setAttribute("cartList", cartList);
		
		if (cartList != null) {
			for (CartDetails cd : cartList) {
				cd.getProductId();
				cd.getQuantity();
				cd.getTotalAmount();
				cd.getTotalAmount();		
				
				System.out.println(			cd.getProductId()+
				cd.getQuantity()+
				cd.getTotalAmount()+
				cd.getTotalAmount());
			}
			System.out.println("hi");
		
//		if() {
//			
//		}
		
		doGet(request, response);
	}
	}
	}
