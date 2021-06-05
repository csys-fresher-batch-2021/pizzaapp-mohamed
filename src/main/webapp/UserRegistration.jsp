<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<%
		String errorMessage = request.getParameter("errorMessage");
		
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		
		String infoMessage = request.getParameter("infoMessage");
		if (infoMessage != null) {
			out.println("<font color='green'>" + infoMessage + "</font>");
		}
		%>
		<form action="UserRegistrationServlet" method="post">
			<h3>USER REGISTRATION</h3>
			<table>
			<Caption>USER REGISTRATION</Caption>
				<tr>
					<th scope="col">NAME</th>
					<td><input type="text" name="userName"
						placeholder="Enter user name" id="userId" required autofocus><br /></td>
				</tr>
				<tr>
					<th scope="col">EMAIL</th>
					<td><input type="email" name="email" placeholder="Enter Email"
						id="emailId" required><br /></td>
				</tr>
				<tr>
					<th scope="col">MOBILE NUMBER</th>
					<td><input type="number" name="mobile"
						placeholder="Enter mobile number" id="mobileId"
						title="Phone number start with 6-9 and remaing 9 digit with 0-9"
						required><br /></td>
				<tr>
					<th scope="col">ADDRESS</th>
					<td><input type="text" name="address"
						placeholder="Enter Address" id="addressId" required><br /></td>
				</tr>
				<tr>
					<th scope="col">PASSWORD</th>
					<td><input type="password" name="pass"
						placeholder="Enter Password" id="passId"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[@#$%^&+=])(?=.*[A-Z]).{8,}"
						title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
						required><br /></td>
				</tr>
				<tr>
					<th scope="col">RE-ENTER PASSWORD</th>
					<td><input type="password" name="reenterPass"
						placeholder="Re-Enter Password" id="passId"
						title="Please Check Password & Reenter Password Is Same" required><br /></td>
				</tr>
			</table>

			<button class="btn btn-danger">Register</button>
			<button class="btn btn-secondary" type="reset">Reset</button>

		</form>
	</main>
</body>
</html>