<%@page import="java.util.List"%>
<% String user = (String)session.getAttribute("userSession"); %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ecommerce.model.UserCarts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/font-awesome@5.15.3/css/fontawesome.min.css" rel="stylesheet">
<title>Users purchased history</title>
<link rel="stylesheet" href="index.css" />
</head>
<body>
<section class="dashboard">
<p><a href="homepage.jsp" class="back"><i class="fas fa-arrow-left" style="font-size: 26px; margin-right:5px; color:white;"></i>Go Back</a></p>

   
  
<div class="right" style="margin-top:100px; margin-left:100px;">
 <h3>Hi, <%=user %> this is your purchase history.</h3>
		<hr />
 <table>
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Product Quantity</th>
            </tr>
        </thead>
        <tbody>
    <%
    List<UserCarts> details = (List<UserCarts>)session.getAttribute("userPurchaseHistory");
    for (UserCarts userCarts : details) {
    %>

            <tr>
                <td><%= userCarts.getProductName() %></td>
                <td><%= userCarts.getTotalPrice() %></td>
                <td><%= userCarts.getQuantity() %></td>
            </tr>
    <%
    }
    %>
        </tbody>
    </table>
</div>
   
</section>
</body>
<script src="https://kit.fontawesome.com/a076d05399.js" ></script>
</html>