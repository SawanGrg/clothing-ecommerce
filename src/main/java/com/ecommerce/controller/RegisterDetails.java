package com.ecommerce.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.ecommerce.model.*;

/**
 * Servlet implementation class searchServlet
 */
public class RegisterDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDetails() {
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
		String filter = request.getParameter("filter");
		System.out.println(filter);
		
		if(filter.equals("all")) {
			String searchInput = request.getParameter("search");
			System.out.println(searchInput);
			SaveUserDetails sr = new SaveUserDetails();
			if(searchInput==null|| searchInput.trim().isEmpty()) {
				request.setAttribute("message", "search filed empty");
				RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
				rd.forward(request, response);
			}
			else{
			request.setAttribute("searchResults",sr.getSearchByAll(filter,searchInput) );
			RequestDispatcher rd = request.getRequestDispatcher("searchProducts.jsp");
			rd.forward(request, response);
			}
		
		}
		else if(filter.equals("brand")) {
			String searchInput = request.getParameter("search");
			System.out.println(searchInput);
			SaveUserDetails sr = new SaveUserDetails();
			if(searchInput==null|| searchInput.trim().isEmpty()) {
				request.setAttribute("message", "search filed empty");
				RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
				rd.forward(request, response);
			}
			else {
			request.setAttribute("searchResults",sr.getSearchByBrand(filter,searchInput) );
			RequestDispatcher rd = request.getRequestDispatcher("searchProducts.jsp");
			rd.forward(request, response);}
		}
		else if(filter.equals("price")) {
			String searchInput = request.getParameter("search");
			System.out.println(searchInput);
			SaveUserDetails sr = new SaveUserDetails();
			if(searchInput==null|| searchInput.trim().isEmpty()) {
				request.setAttribute("message", "search filed empty");
				RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
				rd.forward(request, response);
			}
			else {
			request.setAttribute("searchResults",sr.getSearchByPrice(filter,searchInput) );
			RequestDispatcher rd = request.getRequestDispatcher("searchProducts.jsp");
			rd.forward(request, response);
			}
		}
		else if(filter.equals("category")) {
			String searchInput = request.getParameter("search");
			System.out.println(searchInput);
			SaveUserDetails sr = new SaveUserDetails();
			if(searchInput==null|| searchInput.trim().isEmpty()) {
				request.setAttribute("message", "search filed empty");
				RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
				rd.forward(request, response);
				
			}else {
			request.setAttribute("searchResults",sr.getSearchByCategory(filter,searchInput) );
			RequestDispatcher rd = request.getRequestDispatcher("searchProducts.jsp");
			rd.forward(request, response);
			}
		}
		
		doGet(request, response);
	}

}