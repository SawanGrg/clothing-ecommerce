
<% String userName = (String)session.getAttribute("userSession");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/font-awesome@5.15.3/css/fontawesome.min.css" rel="stylesheet">


 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin</title>
<link rel="stylesheet" href="index.css" />
</head>
<body>
	<section class="dashboard">
		<div class="side-nav">
			<div class="top-wrapper">
				<h4>Dashboard</h4>
				
				<i class="fas fa-bars" style="font-size: 22px; color:white"></i>
			</div>
			<div class="top-wrapper-1">	
			
				<i class="fa fa-shopping-bag" style=" font-size: 20px; color: #fcfcfc;"></i>
				<h4><a href="addProducts.jsp" style="color: white; text-decoration: none;">Add Products</a></h4>				
			</div>	
			<div class="top-wrapper-1">	
				<i class="fa fa-trash" style="font-size: 20px; color: #fcfcfc;"></i>		
				<h4><a href="addcategory.html" style="color: white; text-decoration: none;">Add Category</a></h4>
			</div>
			<div class="top-wrapper-1">	
				<i class="far fa-file-alt" style="font-size: 20px; color: #fcfcfc;"></i>	
				<h4><a href="viewProductAdmin.jsp" style="color: white; text-decoration: none;">Products</a></h4>
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
		<h1>Hello <%=userName %> Welcome Back!</h1>
		<hr />
		<br /><br />
		<img src="<%= request.getContextPath() %>/view/images/graph.jpg" style="height:400px; width:950px;"/>
		</div>	
	</section>
	
</body>
<script src="https://kit.fontawesome.com/a076d05399.js" ></script>

</html>