<% String userName = (String)session.getAttribute("userSession");
%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.Class"%>
<%@ page import="com.ecommerce.controller.UserServletCRUD"%>
<%@ page import="com.ecommerce.model.*"%>
<%@ page import="com.ecommerce.model.CartCRUD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="index.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <script src="index.js"></script>
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:wght@500&family=Ubuntu:wght@300&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>
  
  <!-- back to top button -->
  <button class="scroll-top">
  <div class="arrow up"></div>
</button>
	
<!-- 	conditional rendering of the nav bar-->
	
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
	
<!-- 	main body of the home page -->
	
    <section class="home-page">
   
    
      <div class="row">
        <div class="col-2">
          <h1>Update Outfit<br />Increase Lifestyle!!</h1>
          <p>Looking for good clothes??</p>
          <a href="products.jsp" class="btm"> Explore Now</a>
        </div>
        <div class="col-2">
          <img src="<%= request.getContextPath() %>/view/images/sideimg.jpg"/>
        </div>
      </div>

    <!--Basic structure of slider-->
      <br />
   	 	 <div>
   		 	 
   		 	  <h2 class="title">Most Selling products</h2>
        <div class="row">
   		 	 
   		<%
		UserCRUD userCRUD = new UserCRUD();
		List<GetProductDetails> productAL = userCRUD.getProductDetails();
		session.setAttribute("productAL", productAL);


		List<GetProductDetails> productDetails = (List<GetProductDetails>) session.getAttribute("productAL");
		if (productDetails != null) {
		    int counter = 0; // initialize counter variable
		    for (GetProductDetails pd : productDetails) {
		        if (counter < 4) { // check if counter is less than 4
		            %>
		            <div class="col-4">
		            <img src="<%=request.getContextPath()%>/view/images/<%=pd.getImage()%>" />
            		<h4><%= pd.getProductName() %></h4>
            		<p>Rs<%= pd.getPrice() %></p>
            		</div>
		           
		            <%
		            counter++; // increment counter variable
		        } else {
		            break; // exit the loop after displaying 4 products
		        }
		    }
		}
   		 %>
   		</div>
   </div>

		<!-- Slider div -->
		
 <div class="slideshow-container">

          <!-- Full-width images with number and caption text -->
          <div class="mySlides fade">
           
            <img src="<%= request.getContextPath() %>/view/images/sideimg.jpg" />
            <div class="text">Oneaplus</div>
          </div>
          <div class="mySlides fade">
           
             <img src="<%= request.getContextPath() %>/view/images/LV.jpg" />
            <div class="text">Buy mobiles at best offers</div>
          </div>
        
          <div class="mySlides fade">
            
            <img src="<%= request.getContextPath() %>/view/images/nike.jpg" />
            <div class="text"></div>
          </div>
          <div class="mySlides fade">
            
             <img src="<%= request.getContextPath() %>/view/images/product.jpg" />
            <div class="text">Want mobile to play freefire?</div>
          </div>
          <div class="mySlides fade">
           
            <img src="<%= request.getContextPath() %>/view/images/sideimg.jpg" />
            <div class="text">Do you like Redmi mobiles??</div>
          </div>
          <div class="mySlides fade">
            
           <img src="<%= request.getContextPath() %>/view/images/sideimg.jpg" />
            <div class="text">Get your Mobie to play pubg now!!</div>
          </div>
        
        
          <!-- Next and previous buttons -->
          <a class="prev" onclick="plusSlides(-1)"><</a>
          <a class="next" onclick="plusSlides(1)">></a>
        </div>

		

 
   
   		 <h2 class="title">Our Brands</h2>
   		 <div class="brands">
   		 	<div class="brands-col">
   		 		<img src="<%= request.getContextPath() %>/view/images/addidaslogo.jpg" />
   		 		<img src="<%= request.getContextPath() %>/view/images/kk.jpg" />
   		 		<img src="<%= request.getContextPath() %>/view/images/northfacelogo.jpg" />
   		 	</div>
   		 	<div class="brands-col">
   		 		<img src="<%= request.getContextPath() %>/view/images/nikelogo.jpg" />
   		 		<img src="<%= request.getContextPath() %>/view/images/LV.jpg" />
   		 		<img src="<%= request.getContextPath() %>/view/images/gucci.jpg" />
   		 	</div>
   		 	 </div>
   		 	 
   	

    </section>
   
    <%@ include file="footer.html" %>
     <script>
        let slideIndex = 1;
        showSlides(slideIndex);
        
        function plusSlides(n) {
          showSlides(slideIndex += n);
        }
        
        function currentSlide(n) {
          showSlides(slideIndex = n);
        }
        
        function showSlides(n) {
          let i;
          let slides = document.getElementsByClassName("mySlides");
          let dots = document.getElementsByClassName("dot");
          if (n > slides.length) {slideIndex = 1}    
          if (n < 1) {slideIndex = slides.length}
          for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";  
          }
          for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
          }
          slides[slideIndex-1].style.display = "block";  
          dots[slideIndex-1].className += " active";
        }
        </script>
  </body>
 
</html>
