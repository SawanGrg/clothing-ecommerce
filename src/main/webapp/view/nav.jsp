<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/font-awesome@5.15.3/css/fontawesome.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="index.css" />
</head>
<body>
	<nav class="navbar">
		<div class="navbar-brand">
			<a href="nav.jsp" class="logo"><img
				src="<%=request.getContextPath()%>/view/images/ClothHuntLogo.png" /></a>
		</div>
		<div class="navbar-search">
			<form action="../SearchProductsServlet" method="post">
				<input name="search" type="text" placeholder="Search..."> <select
					id="cars" name="filter">
					<option value="all" name="all">All</option>
					<option value="brand" name="brand">Brand</option>
					<option value="price" name="price">Price</option>
					<option value="category" name="category">Category</option>
				</select>
				<button type="submit">
					<i class="fas fa-search"></i>
				</button>
				<br>
			</form>
		</div>
		<div class="navbar-links">
			<a href="homepage.jsp">Home</a>
			
			<a href= "products.jsp">Products</a>
		</div>

		<div>
			<a href="Login.jsp"><button class="login-button">Login</button></a>
		</div>

	</nav>

</body>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

</html>