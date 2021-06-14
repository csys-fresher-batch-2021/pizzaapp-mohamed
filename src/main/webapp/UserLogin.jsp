<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>
	<form action="UserloginServlet" method="post">
		<h3>User Login</h3>
		<label>UserName</label><br/>
		<input type="text" name="username" placeholder="Enter your Username" required><br/><br/> 
		<label>Password</label><br/>
		<input type="password" name="password" placeholder="Enter your password" required><br/><br/>
		<button class="btn btn-primary" type="submit">Submit</button>
		<button class="btn btn-secondary" type="reset">Reset</button>
		<br /> <br /> <a href="UserRegistration.jsp">NEW USER REGISTRATION</a>
	</form>

</body>
</html>
