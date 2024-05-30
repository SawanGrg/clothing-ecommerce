<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.Class"%>
<%@ page import="com.ecommerce.controller.UserServletCRUD"%>
<%@ page import="com.ecommerce.model.*"%>
<%@ page import="com.ecommerce.model.CartCRUD"%>


<% String userName = (String)session.getAttribute("userSession");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" >
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
       
<link
	href="https://cdn.jsdelivr.net/npm/font-awesome@5.15.3/css/fontawesome.min.css"
	rel="stylesheet">
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
	 
<link rel="stylesheet" href="index.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
 <script src="index.js"></script>
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
	
	<section style="position:relative;">
	<br />
		<form action="<%=request.getContextPath() %>/FilterProducts" method="post">
				<div style="display:flex; flex-direction:row; gap:10px; position:absolute; left:20px; z-index:99999;">
				
				
				<select
					id="cars" name="filter">
					<option value="all" name="all">Sort By</option>
					<option value="brand" name="brand">Brand</option>
					<option value="priceASC" name="price">Price Low to High</option>
					<option value="category" name="category">Category</option>
					<option value="priceDESC" name="category">Price High to Low</option>
				</select>
				<button type="submit" class="sort">
					<h1>Sort</h1>
				</button>
				<br>
				</div>
			</form>
		<h2 class="title">Our products</h2>
		<div class="container">
  <div class="row">
    <%
		UserCRUD userCRUD = new UserCRUD();
		List<GetProductDetails> productAL = userCRUD.getProductDetails();
		session.setAttribute("productAL", productAL);


	List<GetProductDetails> productDetails = (List<GetProductDetails>) session.getAttribute("productAL");
	if (productDetails != null) {
		for (GetProductDetails pd : productDetails) {
			int counter = 0;

            double rating = (int)(Math.random() * 6); // generate random rating between 0 and 5
            %>
            <div class="col-4">
             <img src="<%=request.getContextPath()%>/view/images/<%=pd.getImage()%>" />
                
                <h4><%=pd.getProductName()%></h4>
                <%
			if (pd.getStock() <= 0) {
			%>
			<p style="color:red;">Out of stock*</p>
			<%
			} else {
			%>
			<p style="color: green;">
				Stock:
				<%=pd.getStock()%></p>
			<%
			}
			%>
                <div class="rating">
                   <%
for (int i = 0; i < 5; i++) {
    if (i == 0 || i == 4) {
        // display half or blank star at the end positions
        if (i < rating) {
            // display full star
            %>
             
            <i class="fas fa-star"></i>
            <% 
        } else if (i == rating && (rating % 1) != 0) {
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
        if (i < rating) {
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
                
                <p>Rs<%=pd.getPrice()%></p>
                
                
                <form action="../CartServlet" method="post">
                
<br />
                    <input type="hidden" name="action" value="addToCart">
                    <input type="hidden" name="productId" value="<%= pd.getProductId() %>">
                    <input type="hidden" name="quantity" value="<%= pd.getStock() %>">
                    <input type="hidden" name="totalPrice" value="<%= pd.getPrice() %>">
                    <button class="add-to-cart" type="submit" <%=pd.getStock()<=0 ? "disable" : "" %>>Add to Cart <i class="fas fa-shopping-cart" style="font-size: 24px"></i></button>
                </form>
            </div>
            <% 
            counter++;
        }
    }
    %>
  </div>
  

</div>
       <div class="page-btn">
                <span>1</span>
                <span>2</span>
                <span>3</span>
                <span>4</span>
                <span>&#8594;</span>

            </div>

	</section>
		<%@ include file="footer.html"%> 
</body>
 <script src="https://kit.fontawesome.com/a076d05399.js">
 
 
 </script>
 <script>
//Get references to the minus and plus buttons and the quantity input field
 const minusBtn = document.querySelector('.minus-btn');
 const plusBtn = document.querySelector('.plus-btn');
 const quantityInput = document.querySelector('.num');

 // Add event listeners to the minus and plus buttons
 minusBtn.addEventListener('click', () => {
   // Get the current value of the quantity input field and parse it as an integer
   let currentQuantity = parseInt(quantityInput.value);
   
   // If the current quantity is greater than 1, decrement it by 1 and update the input field
   if (currentQuantity > 1) {
     currentQuantity--;
     quantityInput.value = currentQuantity;
   }
 });

 plusBtn.addEventListener('click', () => {
   // Get the current value of the quantity input field and parse it as an integer
   let currentQuantity = parseInt(quantityInput.value);
   
   // Increment the current quantity by 1 and update the input field
   currentQuantity++;
   quantityInput.value = currentQuantity;
 });

           
  
 </script>
 
</html>