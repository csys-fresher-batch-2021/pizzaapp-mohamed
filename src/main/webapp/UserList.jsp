<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.sikkandar.service.*"%>
<%@page import="java.util.List"%>
<%@page import="in.sikkandar.model.User"%>
<%@page import="in.sikkandar.dao.UserDao"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
#list {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#list td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#list tr:nth-child(even) {
	background-color: #f2f2f2;
}

#list tr:hover {
	background-color: #ddd;
}

#list th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}
</style>
<meta charset="ISO-8859-1">
<title>ALL USER LIST</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>ALL USER LIST</h3>
		<p><jsp:include page="Message.jsp"></jsp:include></p>
		<table class="table table-bordered" id="list">
			<thead>
				<tr>
					<th scope="col">UserId</th>
					<th scope="col">UserName</th>
					<th scope="col">UserEmail</th>
					<th scope="col">UserMobile</th>
					<th scope="col">Address</th>
					<th scope="col">Password</th>
					<th scope="col">Confirm Password</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<User> list = UserDao.getUser();
				//List<Product> products = ProductService.getProducts();
				int i = 0;
				for (User lists : list) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=lists.getName()%></td>
					<td><%=lists.getEmail()%></td>
					<td><%=lists.getMobile()%></td>
					<td><%=lists.getAddress()%></td>
					<td><%=lists.getPassword()%></td>
					<td><%=lists.getConfrimPassword()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>
</body>
</html>
