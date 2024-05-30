<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ecommerce.controller.UserServletCRUD" %>
<%@ page import="com.ecommerce.model.UsersDetails" %>
<%@ page import= "com.ecommerce.model.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="index.css" />
 <link href="https://cdn.jsdelivr.net/npm/font-awesome@5.15.3/css/fontawesome.min.css" rel="stylesheet">

</head>
<body >

 <div class="edit-profile">
 	<p><a href="homepage.jsp" class="back"><i class="fas fa-arrow-left" style="font-size: 26px; margin-right:5px; color:white;"></i>Go Back</a></p>
      <div class="col-1">

        <h1>Edit Profile</h1>
        <button class="active-btn" >Profile</button>
         
     
      </div>
     
      <div class="col-2">
       <div class="acc-info">
                <h4>Update Profile</h4>
                <hr />
                <p>First enter your email and password to change your password</p>
               
              </div>
        <form method="post" action="../UserServletCRUD" enctype="multipart/form-data">
        <%
			List<UsersDetails> userDetails = (List<UsersDetails>)session.getAttribute("list");
		        if (userDetails != null) {
		            for(UsersDetails user : userDetails){
    	%>

              <div class="form">
               
                <div style="display: flex; flex-direction: column; gap: 20px;">
                  <div class="input-details">
                    <p>Email</p>
                    <input value="<%= user.getUserEmail() %>" name= "userEmail" id = "userEmail">
                    
                  </div>
                  <hr />
                  <div class="input-details">
                    <p>Username</p>
                    <input value ="<%=user.getUserName() %>" name= "userName" id = "userName"/>
                    
                  </div>
                  <div class="input-details">
                    <p>Address</p>
                    <input value="<%=user.getUserAddress() %>" name= "userAddress" id = "userAddress">
                   
                  </div>
                  <div class="input-details">
                    <p>Newpassword</p>
                    <input  type="password" name="userNewPassword" id="userNewPassword" />
                    
                  </div>
                   <button type="submit" style="cursor: pointer;" class="update-profile">Update profile</button>
                  
                </div>
               
                <div style="display: flex; flex-direction: column; gap: 20px;">
                  <div class="input-details">
                    <p>Password</p>
                    <input placeholder="Password" name="userOldPassword" id="userOldPassword" required/>
                  </div>
                  <hr />
                  <div class="input-details">
                    <p>Contact</p>
                  <input value="<%=user.getUsercontact() %>" name= "userContact" id = "userContact"/>
                  </div>
                  
                  <div class="top-col">
                <div style="display: flex; flex-direction: column; align-items: center; justify-content: center; gap: 10px;">
                  <h3>Upload a profile picture</h3>
                  <p for="userImage">
                    Show people who you are! Recommended size: 400x400px. JPG, PNG or
                    GIF.
                    <%=user.getUserImage() %>
                  </p>
                
                  <input type="file" id="userImage" name="userImage" >
                </div>
                <%	}
} %>
                
              </div>
                </div>
                
              </div>
              
             
        </form>
        
      </div>
     
    </div>
	


</body>
<script src="https://kit.fontawesome.com/a076d05399.js" ></script>

</html>