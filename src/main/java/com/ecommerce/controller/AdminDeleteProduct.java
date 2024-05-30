package com.ecommerce.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.ecommerce.model.AdminViewProduct;
import com.ecommerce.model.CartCRUD;
import com.ecommerce.model.CartProductView;
import com.ecommerce.model.Carts;
import com.ecommerce.model.DeleteProduct;
import com.ecommerce.model.GetProductDetails;
import com.ecommerce.model.GetProductDetailsAdmin;
import com.ecommerce.model.UserCRUD;

@WebServlet("/AdminDeleteProduct")
public class AdminDeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteProduct() {
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
		System.out.println(productId+"chitua");
		int id = Integer.parseInt(productId);
		DeleteProduct delete = new DeleteProduct();
		delete.deleteProduct(id);
		
		List<GetProductDetailsAdmin> productAL = new AdminViewProduct().extractDetails();
		session.setAttribute("AdminViewProduct", productAL);
		
		response.sendRedirect(request.getContextPath()+("/view/viewProductAdmin.jsp"));

	}

}
