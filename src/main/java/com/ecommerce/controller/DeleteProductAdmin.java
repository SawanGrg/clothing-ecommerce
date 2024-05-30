package com.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import com.ecommerce.model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteProductAdmin
 */
@WebServlet("/DeleteProductAdmin")
public class DeleteProductAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String productId = (String)request.getParameter("id");
		int id = Integer.parseInt(productId);
		DeleteProduct delete = new DeleteProduct();
		delete.deleteProduct(id);
		
		List<GetProductDetailsAdmin> productAL = new AdminViewProduct().extractDetails();
		session.setAttribute("AdminViewProduct", productAL);
		
		response.sendRedirect(request.getContextPath()+("/view/viewProductAdmin.jsp"));

	}

}
