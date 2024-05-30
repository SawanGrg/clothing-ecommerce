package com.ecommerce.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.model.*;

/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/FilterProducts")
public class FilterProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterProducts() {
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
		
		
		
		if(filter.equals("brand")) {
			
			FilterResults rr = new FilterResults();
			

				request.getSession().setAttribute("searchResults",rr.getSearchByBrand(filter));
				response.sendRedirect(request.getContextPath() +"/view/searchProducts.jsp");
			
		}
		
		
		
		else if(filter.equals("priceASC")) {
			
			FilterResults rr = new FilterResults();
			
				
			
				request.getSession().setAttribute("searchResults",rr.getSearchByPriceASC(filter) );
				response.sendRedirect(request.getContextPath() +"/view/searchProducts.jsp");
			
		}
		
else if(filter.equals("priceDESC")) {
			
			FilterResults rr = new FilterResults();
			
				
			
				request.getSession().setAttribute("searchResults",rr.getSearchByPriceDESC(filter) );
				response.sendRedirect(request.getContextPath() +"/view/searchProducts.jsp");
			
		}
		else if(filter.equals("category")) {
			

			FilterResults rr = new FilterResults();
			
			
				
				
				
				
		
			
				request.getSession().setAttribute("searchResults",rr.getSearchByCategory(filter) );
			response.sendRedirect(request.getContextPath() +"/view/searchProducts.jsp");
		
			
			
		}
		
		doGet(request, response);
	}

}