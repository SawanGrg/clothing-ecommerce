<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.Class"%>
<%@page import="com.ecommerce.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String userName = (String)session.getAttribute("userSession"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cart</title>
		<link href="https://cdn.jsdelivr.net/npm/font-awesome@5.15.3/css/fontawesome.min.css" rel="stylesheet">
        <!-- importing icons and fonts -->
        <link rel="stylesheet" href="https://fonts.google.com/?query=gothic+a1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="index.css" />
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
     <section style="min-height:100vh;">
        <div class="cart-container">
            <table class="cart-items">
	<tr>
		<th>Product Name</th>
		<th>Product Quantity</th>
		<th>Product Price</th>
		<th> customize</th>
	</tr>
	<%
	List<CartProductView> cartDetails = (List<CartProductView>)session.getAttribute("cartAL");

	for(CartProductView cpv : cartDetails){
		%>
		<tr >
			<td ><%=cpv.getProductName() %></td>
			<td ><%=cpv.getProductQuantity() %></td>
			<td ><%=cpv.getProductPrice() %></td>
			<td style="display:flex; flex-direction:row; align-items:center; justify-content:center; gap:20px; border:none;"> 
			
			<form action="../CheckOutServlet" method="post">

			<input type="hidden" name="action" value="checkout Cart">
			<input type="hidden" name = "cartId" value= "<%=cpv.getCartId() %>"> 
			<input type="hidden" name = "product price" value= "<%= cpv.getProductPrice() %>"> 
			<button type="submit" style="cursor:pointer;"><i class="fas fa-shopping-bag" style="font-size: 30px; color: green;"></i></button>
			</form> 
			<form action = "../DeleteCartServlet" method="post">
			<input type="hidden" name="action" value="delete Cart">
			<input type="hidden" name = "cartId" value= "<%=cpv.getCartId() %>"> 
			<input type="hidden" name = "product price" value= "<%= cpv.getProductPrice() %>"> 
			<button type="submit" style="cursor:pointer;"><i class="fas fa-trash" style="font-size: 30px; color: red;"></i></button>
			</form>
			</td>
		</tr>
	<% 
	}
	%>
</table>

          
        </div>
     
     </section>

        <%@ include file="footer.html"%> 
        <!-- scripts -->
        
           <script src="https://kit.fontawesome.com/a076d05399.js" ></script>
    </body>
</html>