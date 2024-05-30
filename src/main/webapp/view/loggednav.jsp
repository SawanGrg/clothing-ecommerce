<% String user = (String)session.getAttribute("userSession"); %>
<%@ page
language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <link
      href="https://cdn.jsdelivr.net/npm/font-awesome@5.15.3/css/fontawesome.min.css"
      rel="stylesheet"
    />
    
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="index.css" />
  </head>
  <body>
    <nav class="navbar">
      <div class="navbar-brand">
        <a href="homepage.jsp" class="logo"
          ><img
            src="<%= request.getContextPath() %>/view/images/ClothHuntLogo.png"
        /></a>
      </div>
      <div class="navbar-search">
       <form action="<%=request.getContextPath() %>/SearchProductsServlet" method="post">
				<input name="search" type="text" placeholder="Search..."> 
				<select
					id="cars" name="filter">
					<option value="all" name="all">Search By</option>
					<option value="brand" name="brand">Brand</option>
					<option value="price" name="price">Price</option>
					<option value="category" name="category">Category</option>
				</select>
				<button type="submit">
					<i class="fas fa-search" style="font-size:16px"></i>
				</button>
				<br>
				
			</form>
      </div>
      <div class="navbar-links">
        <a href="homepage.jsp">Home</a>
        <a href="products.jsp">Products</a>
      </div>
      <a href="cart.jsp" style="text-decoration: none; color: black">
        <i class="fas fa-shopping-cart" style="font-size: 26px"></i>
      </a>
      <div class="profile-user">
        <img
          alt="profile-pic"
          class="profile-pic"
          src="<%= request.getContextPath() %>/view/images/product.jpg"
        />
        <h1><%= user %></h1>
        <div class="hidden-content">
          <div
            style="
              display: flex;
              flex-direction: row;
              align-items: center;
              justify-content: flex-start;
              padding-left: 10px;
              gap: 15px;
            "
          >
            <i class="fas fa-solid fa-user" style="font-size: 26px"></i>My
            Profile
          </div>
          <hr />
          <a
            href="editprofile.jsp"
            style="
              display: flex;
              flex-direction: row;
              align-items: center;
              justify-content: flex-start;
              padding-left: 10px;
              gap: 15px;
            "
            ><i class="fas fa-cog" style="font-size: 26px"></i>Edit Profile</a
          >
          <form action="../UserPurchaseHistory" method="post">
          <button type="submit" style="
              display: flex;
              flex-direction: row;
              align-items: center;
              justify-content: flex-start;
              padding-left: 10px;
              height:50px;
              width:200px;
              border:none;
              background-color:rgba(255, 255, 255, 0.1);
              gap: 15px;
              cursor:pointer;
            ">
          <i class="fas fa-cog" style="font-size: 26px"></i>View Order History
          
          </button>
          </form>
          <br />
          
          <a
          href="logout.jsp"
            style="
              display: flex;
              flex-direction: row;
              align-items: center;
              justify-content: flex-start;
              padding-left: 10px;
              gap: 15px;
            "
            ><i class="fas fa-sign-out-alt" style="font-size: 26px"></i>Log
            out</a
          >
        </div>
      </div>
    </nav>
  </body>
  <script src="https://kit.fontawesome.com/a076d05399.js"></script>
  
</html>
