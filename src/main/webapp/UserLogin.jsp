<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>
	<div class="card bg-light">
		<article class="card-body mx-auto" style="max-width: 400px;">
			<h3 class="card-title mt-3 text-center">USER LOGIN</h3>
			<p class="text-center"><jsp:include page="Message.jsp"></jsp:include></p>
			<form action="UserloginServlet" method="post">
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <em class="fa fa-user"
							style="font-size: 24px"></em>
						</span>
					</div>
					<input name="username" class="form-control"
						placeholder="Enter User Name" autocomplete="off" type="text"
						required>
				</div>
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <em class="fa fa-lock"
							style="font-size: 24px"></em>
						</span>
					</div>
					<input name="password" class="form-control"
						placeholder="Enter Password" autocomplete="off" type="password"
						required>
				</div>
				<div class="form-group">
					<button class="btn btn-primary btn-block" type="submit">Submit</button>
					</br>
					<button class="btn btn-danger btn-block" type="reset">Reset</button>
				</div>
				<a href="UserRegistration.jsp">NEW USER REGISTRATION</a>
			</form>
		</article>
	</div>

</body>
</html>
