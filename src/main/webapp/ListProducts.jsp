<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.sikkandar.service.*"%>
<%@page import="java.util.List"%>
<%@page import="in.sikkandar.model.Product"%>
<%@page import="in.sikkandar.dao.ProductDao"%>

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
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<%
		String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
		%>
		<h3>List Pizza Types</h3>
		<p><jsp:include page="Message.jsp"></jsp:include></p>
		<table class="table table-bordered" id="list">
			<caption>Available PizzaTypes</caption>
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<%
					if (loggedInUsername == null) {
					%>
					<th scope="col">ID</th>
					<%
					}
					%>
					<th scope="col">Pizza Name</th>
					<th scope="col">Price</th>
				</tr>
			</thead>
			<tbody>
				<!--  Scriptlets ( Java Code ) -->
				<!--  %= Expression - variable value -->
				<!--  Dynamic  -->
				<%
				List<Product> products = ProductDao.getProduct();
				//List<Product> products = ProductService.getProducts();
				int i = 0;
				for (Product product : products) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<%
					if (loggedInUsername == null) {
					%>
					<td><%=product.getId()%></td>
					<%
					}
					%>
					<td><%=product.getName()%></td>
					<td><%=product.getPrice()%></td>

				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>
</body>
</html>
