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
@WebServlet("/SearchProductsServlet")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductServlet() {
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
			SearchResults sr = new SearchResults();
			if(searchInput==null|| searchInput.trim().isEmpty()) {
				request.getSession().setAttribute("message", "search filed empty");
				response.sendRedirect(request.getContextPath() +"/view/homepage.jsp");
			}
			else{
				request.getSession().setAttribute("searchResults",sr.getSearchByAll(filter,searchInput) );
				response.sendRedirect(request.getContextPath() +"/view/searchProducts.jsp");
			}
		
		}
		else if(filter.equals("brand")) {
			String searchInput = request.getParameter("search");
			System.out.println(searchInput);
			SearchResults sr = new SearchResults();
			if(searchInput==null|| searchInput.trim().isEmpty()) {
				request.getSession().setAttribute("message", "search filed empty");
				response.sendRedirect(request.getContextPath() +"/view/homepage.jsp");
			}
			else {
				request.getSession().setAttribute("searchResults",sr.getSearchByBrand(filter,searchInput) );
				response.sendRedirect(request.getContextPath() +"/view/searchProducts.jsp");
			}
		}
		else if(filter.equals("price")) {
			String searchInput = request.getParameter("search");
			System.out.println(searchInput);
			SearchResults sr = new SearchResults();
			if(searchInput==null|| searchInput.trim().isEmpty()) {
				request.getSession().setAttribute("message", "search filed empty");
				response.sendRedirect(request.getContextPath() +"/view/homepage.jsp");
			}
			else {
				request.getSession().setAttribute("searchResults",sr.getSearchByPrice(filter,searchInput) );
				response.sendRedirect(request.getContextPath() +"/view/searchProducts.jsp");
			}
		}
		else if(filter.equals("category")) {
			String searchInput = request.getParameter("search");
			System.out.println(searchInput);
			SearchResults sr = new SearchResults();
			if(searchInput==null|| searchInput.trim().isEmpty()) {
			
				request.getSession().setAttribute("message", "search filed empty");
				response.sendRedirect(request.getContextPath() +"/view/homepage.jsp");
				
				
				
			}else {
			
				request.getSession().setAttribute("searchResults",sr.getSearchByCategory(filter,searchInput) );
			response.sendRedirect(request.getContextPath() +"/view/searchProducts.jsp");
		
			
			}
		}
		
		doGet(request, response);
	}

}