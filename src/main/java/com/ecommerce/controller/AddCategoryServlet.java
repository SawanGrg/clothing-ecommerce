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
import com.ecommerce.model.CategoryDetails;

@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	int category = 0;

	public AddCategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		HttpSession session = request.getSession();
		
		String categoryName = request.getParameter("categoryName");
		
		// for adding product in model class called category details for setter
		CategoryDetails categoryDetails = new CategoryDetails();
		
		categoryDetails.setCategoryName(categoryName);

		AddProductsAdmin addProductAdmin = new AddProductsAdmin();
		
		// try for category name
		
		try {

			System.out.println(categoryName);
			
			category = addProductAdmin.addCategory(categoryDetails);
			
			System.out.println(categoryName);
			System.out.println("name of category is :" + categoryName);
			System.out.println("success while inserting category");
			
		    AddProductsAdmin addProductsAdmin = new AddProductsAdmin();
		    
		    // a session list to display category details to add in products table in db
		    List<CategoryDetails> categoryAL = addProductsAdmin.getCategoryDetails();
//		    request.getSession().setAttribute("categoryAL", categoryAL);
		    session.setAttribute("categoryAL", categoryAL);

			// redirect to the same page
			response.sendRedirect(request.getContextPath() + "/view/addcategory.html");
			
		} catch (ClassNotFoundException e) {

			System.out.println("failed while updating the category name");
			e.printStackTrace();
		}
	}

}
