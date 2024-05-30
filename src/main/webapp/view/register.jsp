<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
    * {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

html,
body {
  height: 100%;
}


html {
  background: linear-gradient(to right bottom, #fbdb89, #f48982);
  background-repeat: no-repeat;
  background-size: cover;
  width: 100%;
  height: 100%;
  
  background-attachment: fixed;
}

body {
	padding-top:50px;

  font-family: sans-serif;
  line-height: 1.4;
  display: flex;
}

.container {
  width: 600px;
  margin: auto;
  padding: 36px 48px 48px 48px;
  background-color: #f2efee;

  border-radius: 11px;
  box-shadow: 0 2.4rem 4.8rem rgba(0, 0, 0, 0.15);
}

.login-title {
  padding: 15px;
  font-size: 28px;
  font-weight: 600;
  text-align: center;
}

.login-form {
  display: grid;
  grid-template-columns: 1fr;
  row-gap: 14px;
}

.login-form label {
  display: block;
  margin-bottom: 8px;
  margin-top: 8px;
}

.login-form input {
  border: 1px solid #ccc;	
  width: 100%;
  padding: 1.2rem;
  border-radius: 9px;
  border:2px solid #111;
  
}
input:invalid{
	border:2px solid #e70707;
	animation: invalid 0.3s 2;
}

@keyframes invalid{
	25%{
		translate:6px 0;
		
	}
		50%{
		translate:-6px 0;
		
	}
	
	75%{
		translate:6px 0;
	}
}



.btn--form {
  background-color: #f48982;
  color: #fdf2e9;
  align-self: end;
  padding: 8px;
}

.btn,
.btn:link,
.btn:visited {
  display: inline-block;
  text-decoration: none;
  font-size: 20px;
  font-weight: 600;
  border-radius: 9px;
  border: none;

  cursor: pointer;
  font-family: inherit;

  transition: all 0.3s;
}


button {
  outline: 1px solid #f48982;
}

.btn--form:hover {
  background-color: #fdf2e9;
  color: #f48982;
}

.Gender input{
	width: 50%;
}



    </style>
</head>
<body>
	<div class="container">
    <h2 class="login-title">Register</h2>
    <hr />

    <form class="login-form" method="post" action="../RegisterServlet" enctype="multipart/form-data">
    <div>
        <label for="name">First Name<span style="color:#e70707">* </span></label>
        <input
               id="name"
              pattern="[a-z]*"
               type="text"
               placeholder="First name"
               name="userFirstName"
               required
               />
      </div>
      <div>
        <label for="name">Last Name<span style="color:#e70707">* </span></label>
        <input
               id="name"
                pattern="[a-z]*"
               type="text"
               placeholder="Last name"
               name="userLastName"
               required
               />
      </div>
      
    <div>
        <label for="name">Email<span style="color:#e70707">* </span> </label>
        <input
               id="name"
               type="email"
               placeholder="Username"
               name="userEmail"
               required
               />
      </div>
      <div>
        <label for="name">Contact Number<span style="color:#e70707">* </span> </label>
        <input
               id="name"
               type="text"
               placeholder="Number"
               name="userContact"
               required
               />
      </div>
       <div>
        <label for="name">Address <span style="color:#e70707">* </span></label>
        <input
               id="name"
               type="text"
               placeholder="Address"
               name="userAddress"
               required
               />
      </div>
      <div class="Gender">
        <label>
  <input type="radio" name="userGender" value="male"> Male
</label>
<label>
  <input type="radio" name="userGender" value="female"> Female
</label>

                     </div>
      <div>
        <label for="name">UserName<span style="color:#e70707">* </span> </label>
        <input
               id="name"
               type="text"
               placeholder="Username"
               name="userName"
               required
               />
      <h3><%String message = request.getParameter("name"); %><%=message.equals(null)? "hidden" : ""%></h3>
      </div>

      

      <div>
        <label for="password">Password <span style="color:#e70707">* </span></label>
        <input
               id="password"
               type="password"
               placeholder="password"
               name="userPassword"
               required
               />
      </div>
      <label for="profile-pic">Profile Picture:</label>
		<input type="file" id="profile-pic" name="userImage" accept="image/*">

      <button class="btn btn--form" type="submit" value="Log in">
        Register
      </button>
      <div class="signup-link">
        Already have an account? <a href="Login.jsp">Login →</a>
      </div>
    </form>
</div>
</body>
</html>