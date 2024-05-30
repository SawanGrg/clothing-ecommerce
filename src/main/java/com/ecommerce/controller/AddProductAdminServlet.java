package com.ecommerce.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.ecommerce.model.AddProductsAdmin;
import com.ecommerce.model.GetProductDetails;

/**
 * Servlet implementation class AddProductAdminServlet
 */
@MultipartConfig
@WebServlet("/AddProductAdminServlet")

public class AddProductAdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	int result = 0;

	public AddProductAdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

//		String productId = request.getParameter("productId");
		
		String productName = request.getParameter("productName");
		
		int category = Integer.parseInt(request.getParameter("categoryId"));
		
		String productBrand = request.getParameter("productBrand");
		
		float price = Float.parseFloat(request.getParameter("productPrice"));
		
		int stock = Integer.parseInt(request.getParameter("productStock"));
		
		Part image = request.getPart("productImage");
		
		String imageName = image.getSubmittedFileName();

		String uploadPath = "D:\\Workplaceforeclipse\\CourseWork\\src\\main\\webapp\\view\\images\\" + imageName;
		
		
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


		GetProductDetails pd = new GetProductDetails(productName, price, stock, imageName, category, productBrand);

		AddProductsAdmin addProductByAdmin = new AddProductsAdmin();

		try {
			 result = addProductByAdmin.addProduct(pd);
			 
			 System.out.println("success");
			 
			    // redirect to the same page
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/view/addProducts.jsp");
			 dispatcher.forward(request, response);

		} catch (ClassNotFoundException e) {

			System.out.println("failed");
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
