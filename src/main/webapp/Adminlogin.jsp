<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>AdminLogin</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="AdminLoginServlet" method="post">
		<h3>ADMIN LOGIN</h3>
			<table>
				<caption>ADMIN LOGIN</caption>
				<tr>
					<th scope="col">USER NAME</th>
					<td><input type="text" name="userName"
						placeholder="Enter user name" id="userId" required autofocus></td>
				</tr>

				<tr>
					<th scope="col">PASSWORD</th>
					<td><input type="password" name="passWord"
						placeholder="Enter password" id="passId" required></td>
				</tr>
			</table>
			<button class="btn btn-primary" type="submit">Submit</button>
			<button class="btn btn-danger" type="reset">Reset</button>
			<br />

		</form>
	</main>
</body>
</html>