<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.Class"%>
<%@page import="com.ecommerce.controller.*" %>
<%@page import="com.ecommerce.model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
<link rel="stylesheet" href="index.css" />
<link href="https://cdn.jsdelivr.net/npm/font-awesome@5.15.3/css/fontawesome.min.css" rel="stylesheet">
<style type="text/css">
 i:hover{

	animation: invalid 2s 2;
}

@keyframes invalid{
	25%{
		rotate:20deg;
		
	}
		50%{
	rotate:-20deg;
		
	}
	
	75%{
		rotate:20deg;
	}
}
</style>
</head>
<body>
<section class="dashboard">

<div class="side-nav">
			<div class="top-wrapper">
				<h4>
					<a href="admin.jsp" style="color: white; text-decoration: none;">Dashboard</a>
				</h4>

				<i class="fas fa-bars" style="font-size: 22px; color: white"></i>
			</div>
			<div class="top-wrapper-1">

				<i class="fa fa-shopping-bag"
					style="font-size: 20px; color: white;"></i>
				<h4>
					<a href="addProducts.jsp"
						style="color: white; text-decoration: none;">Add Products</a>
				</h4>


			</div>


			<div class="top-wrapper-1">
				<i class="fa fa-trash" style="font-size: 20px; color: #fcfcfc;"></i>


				<h4>
					<a href="addcategory.html"
						style="color: white; text-decoration: none;">Add Category</a>
				</h4>
			</div>
			<div class="top-wrapper-1">
				<i class="far fa-file-alt" style="font-size: 20px; color: #4CAF50;"></i>
				<h4>
					<a href="viewProductAdmin.jsp"
						style="color: #4CAF50; text-decoration: none;">Products</a>
				</h4>
			</div>
			
			
			<div class="top-wrapper-1">	
			<form action ="../AdminViewCarts" method = "post">
			
		<button style="background-color:black; display:flex; flex-direction:row; gap:20px; justify-content:center; align-items:center; border:none; "type="submit">
	<i class="far fa-file-alt" style="font-size: 20px;   color: #fcfcfc;"></i>	
	<h4>View Order List</h4>
</button>

				</form>
			</div>
		</div>
		<div class="right">
		<h3>Products List</h3>
		<hr />
		<br />
		<%
    List<GetProductDetailsAdmin> productView = (List<GetProductDetailsAdmin>)session.getAttribute("AdminViewProduct");
    if (productView == null) {
        productView = new ArrayList<GetProductDetailsAdmin>();
    }
%>
<table class="view-table">
    <thead>
        <tr>
            <th>Product Id</th>
            <th>Product Name</th>
            <th>Stock</th>
            <th>Price</th>
            <th>Brand</th>
            <th>Image</th>
            <th>Category</th>
            <th>Delete </th>
            <th>Modify</th>
        </tr>
    </thead>
    
    <tbody>
        <% for(GetProductDetailsAdmin product : productView) { %>
        <tr>
            <td><%= product.getProductId() %></td>
            <td><%= product.getProductName() %></td>
            <td><%= product.getStock() %></td>
            <td><%= product.getPrice() %></td>
            <td><%= product.getProductBrand() %></td>

            <td><img src="<%=request.getContextPath()%>/view/images/<%=product.getImage()%>" style="width:100px; height:150px;"></td>
            <td><%= product.getCategoryName() %></td>
            <td> <form action="../AdminDeleteProduct" method="post">
            <input name = "id" type= "text" value="<%= product.getProductId() %>" hidden=""><button style="background-color:black; border:none; " type="submit"><i class="fa fa-trash" style="font-size: 30px; color: red;"></i></button></form></td>
      <td><a href="modifyProducts.jsp?id=<%= product.getProductId() %>"> <i class="fas fa-edit"  style="font-size: 30px; color: #50EBCB;"></i></a></td>
        </tr>
        <% } %>
    </tbody>
</table>
		</div>

</section>

</body>
<script src="https://kit.fontawesome.com/a076d05399.js" ></script>
</html>