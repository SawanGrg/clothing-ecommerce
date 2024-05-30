<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.Class"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<% String userName = (String)session.getAttribute("userSession");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/font-awesome@5.15.3/css/fontawesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath() %>/view/index.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@500&family=Ubuntu:wght@300&display=swap"
	rel="stylesheet">
</head>
<body>
	<%
		if(userName==null) {
	%>
	 <%@ include file="nav.jsp" %>
	 <%
		}else{
	 %>
	 <%@ include file="loggednav.jsp" %>
	 <%
	 }%>


	<section>
		
			<h2 class="title">Our products</h2>
			<div class="container">
 			 <div class="row">
			<%		
			List<Object> details =( ArrayList<Object>) session.getAttribute("searchResults");
			 double rating = (int)(Math.random() * 6); // generate random rating between 0 and 5
			int a = details.size();
			if(a!=0){
			for (int i = 0; i < details.size(); i += 4) {
				String image = (String) details.get(i);
				String productName = (String) details.get(i + 1);
				float price = (float) details.get(i + 2);
				int stock =(int)details.get(i+3);
				
				
			%>
			
				<div class="col-4">
					<img src="<%=request.getContextPath()%>/view/images/<%=image%>">
					<h4><%=productName%></h4>
					<div class="rating">
					<%
					
					 for (int j = 0; j < 5; j++) {
						    if (i == 0 || i == 4) {
						        // display half or blank star at the end positions
						        if (j < rating) {
						            // display full star
						            %>
						             
						            <i class="fas fa-star"></i>
						            <% 
						        } else if (j == rating && (rating % 1) != 0) {
						            // display half star
						            %>
						            <i class="fas fa-star-half-alt"></i>
						            <% 
						        } else {
						            // display blank star
						            %>
						            <i class="far fa-star"></i>
						            
						            <% 
						        }
						    } else {
						        // display full star for other positions
						        if (j < rating) {
						            // display full star
						            %>
						            <i class="fas fa-star"></i>
						            <% 
						        } else {
						            // display blank star
						            %>
						            <i class="far fa-star"></i>
						            <% 
						        }
						    }
						}
					
					%>
					</div>
					<p><%=price%></p>
					
					
					
				</div>
			
			<%
			}
			}else{
				out.println("product not found");
			}
			%>
			</div>
			
		</div>
		
	</section>
	<%@ include file="footer.html"%>
</body>
</html>