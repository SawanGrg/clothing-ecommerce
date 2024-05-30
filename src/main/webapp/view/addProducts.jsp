<%@page import="com.ecommerce.model.CategoryDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/font-awesome@5.15.3/css/fontawesome.min.css"
	rel="stylesheet">


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
				<h4>
					<a href="admin.jsp" style="color: white; text-decoration: none;">Dashboard</a>
				</h4>

				<i class="fas fa-bars" style="font-size: 22px; color: white"></i>
			</div>
			<div class="top-wrapper-1">

				<i class="fa fa-shopping-bag"
					style="font-size: 20px; color: #4CAF50;"></i>
				<h4>
					<a href="addproduct.html"
						style="color: #4CAF50; text-decoration: none;">Add Products</a>
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
				<i class="far fa-file-alt" style="font-size: 20px; color: #fcfcfc;"></i>
				<h4>
					<a href="viewProductAdmin.jsp"
						style="color: white; text-decoration: none;">Products</a>
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
			<h1>Add the Products</h1>
			<hr />
			<br />
			<br />
			
			<!--  form to add the products  -->
			<form action="../AddProductAdminServlet" method="post"
				enctype="multipart/form-data">
				<div class="form">
					<div class="column-1">
						<div class="input-details">
							<p>Name</p>
							<input placeholder="Name" name="productName" id="Product_name"
								required></input>
						</div>
						<div class="input-details">
							<p>Price</p>
							<input placeholder="Price" name="productPrice"></input>
						</div>
						<div class="input-details">
							<p>Stock</p>
							<input placeholder="Stock" name="productStock"></input>
						</div>
						<button class="add" type="submit">Add Product</button>
					</div>
					<div class="column-1">
						<div class="input-details">
							<p>Brand</p>
							<input placeholder="Brand" name="productBrand"></input>
						</div>

						<div class="input-details">
							<%
							List<CategoryDetails> categoryDetails = (List<CategoryDetails>) session.getAttribute("categoryAL");
							%>
							<p>Category</p>

							<select id="categoryId" class="category-add" name="categoryId"
								required>
								<option value="">-- Select Category --</option>
								<%
								for (CategoryDetails cd : categoryDetails) {
								%>
								<option value="<%=cd.getCategoryId()%>">
									<%=cd.getCategoryName()%>
								</option>
								<%
								}
								%>
							</select>

						</div>
						<div class="input-details">
							<div id="dropzone" ondragover="handleDragOver(event)"
								ondrop="handleDrop(event)">
								<p>Select image</p>
							</div>
							<input type="file" name="productImage"
								style="height: 40px; margin-left: 30px;" id="fileInput">
						</div>

					</div>

				</div>
			</form>
		</div>
	</section>

</body>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

</html>