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
import com.ecommerce.model.UserCRUD;
import com.ecommerce.model.UserCarts;

@WebServlet("/UserPurchaseHistory")
public class UserPurchaseHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserPurchaseHistory() {
        super();
      
    }

    UserCRUD userCarts = new UserCRUD();
    CartCRUD cartCRUD = new CartCRUD();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Setting http session
		HttpSession session = request.getSession();
		
		int userId = (int)session.getAttribute("userId");
		
		System.out.println(" before user id for looking at purchase history is:" + userId);
		
		List<UserCarts> cartAL = cartCRUD.getPurchaseHistory(userId);
		session.setAttribute("userPurchaseHistory", cartAL);
		
		System.out.println(" after user id for looking at purchase history is:" + userId);
		
		response.sendRedirect(request.getContextPath()+"/view/userPurchaseHistory.jsp");
	}

}