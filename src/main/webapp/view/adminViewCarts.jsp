<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ecommerce.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/font-awesome@5.15.3/css/fontawesome.min.css" rel="stylesheet">
<title>ADMIN VIEW CARTS</title>
<link rel="stylesheet" href="index.css" />
</head>
<body>
<section class="dashboard">
<p><a href="admin.jsp" class="back"><i class="fas fa-arrow-left" style="font-size: 26px; margin-right:5px; color:white;"></i>Go Back</a></p>

   <div class="right" style="margin-top:100px; margin-left:100px;">
   <h3>Purchase History of Clients</h3>
		<hr />
   <table class="view-table">
     
        <thead>
            <tr>
                <th>Client Id</th>
                <th>User Name</th>
                <th>Product Name</th>
                <th>Total Price</th>
                <th>Quantity</th>
                <th>Product Status</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<AdminCarts> viewCarts = (List<AdminCarts>) session.getAttribute("adminViewCarts");
                for (AdminCarts cart : viewCarts) {
            %>
            <tr>
                <td><%=cart.getCartId() %></td>
                <td><%=cart.getUserName() %></td>
                <td><%=cart.getProductName()%></td>
                <td><%=cart.getTotalPrice() %></td>
                <td><%=cart.getQuantity() %></td>
                <td>
                    <% if (cart.getCheckout() == 0) { %>
                        Not purchased
                    <% } else { %>
                        Purchased
                    <% } %>
                </td>
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