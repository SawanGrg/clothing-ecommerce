<%@page import="com.ecommerce.model.CategoryDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.ecommerce.model.*"%>
<%@page import="com.ecommerce.controller.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%String product = request.getParameter("id");
int id = Integer.parseInt(product);
%>
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
	
	
		<div class="modify">
		
		
		
		
		<p><a href="viewProductAdmin.jsp" class="back"><i class="fas fa-arrow-left" style="font-size: 26px; margin-right:5px; color:white;"></i>Go Back</a></p>
		<h1>Edit the Product Details</h1>
		<br />
		<hr style="margin-left:30px; width:1000px;" />
		<br /><br />
		<%List<GetProductDetailsAdmin> details = new UpdateProduct().getProductDetails(id); 
		for(GetProductDetailsAdmin detail : details){
			%>
		
		
		<form action="../UpdateProductServlet" method="post" enctype="multipart/form-data">
			  <div class="form" style="margin-left:20px;">
        <div class="column-1">
          <div class="input-details">
            <p>Name</p>
            <input placeholder="Name" name="productName" id="Product_name"
               required value=<%=detail.getProductName() %>></input>
          </div>
          <div class="input-details">
            <p>Price</p>
            <input placeholder="Price" name="productPrice" value=<%=detail.getPrice() %>></input>
          </div>
          <div class="input-details">
            <p>Stock</p>
            <input placeholder="Stock" name="productStock" value=<%=detail.getStock() %>></input>
          </div>
          <button class="add" type="submit">Update Details</button>
        </div>
        <div class="column-1">
          <div class="input-details">
            <p>Brand</p>
            <input placeholder="Brand" name="productBrand" value=<%=detail.getProductBrand() %>></input>
          </div>
          <input placeholder="Brand" name="productId" value=<%= id %> hidden></input>
          <div class="input-details">
          <%List<CategoryDetails> categoryDetails = (List<CategoryDetails>)session.getAttribute("categoryAL");%>
            <p>Category</p>
           
  <select id="categoryId" class="category-add" name="categoryId" required>
    <option value=<%=detail.getCategoryName() %>><%=detail.getCategoryName() %></option>
    <% for(CategoryDetails cd : categoryDetails){ %>
        <option value="<%= cd.getCategoryId() %>">
        <%= cd.getCategoryName() %>
        </option>
    <% } %>
  </select>
            
          </div>
         
           
          
        </div>
        <div class="column-1">
          
          <div class="input-details">
            <div id="dropzone" ondragover="handleDragOver(event)" ondrop="handleDrop(event)">
    <p>Current image</p>
  </div>
  <img src="<%=request.getContextPath()%>/view/images/<%=detail.getImage()%>"/>
   <p>Upload new image</p>
  <input type="file"   name="productImage" style="height:40px; margin-left:30px;" id="fileInput" value=<%=detail.getImage() %>>
          </div>
          </div>
      </div>
      </form><%}%>
		</div>	
		
		
	
	</section>
	
</body>
<script src="https://kit.fontawesome.com/a076d05399.js" ></script>

</html>