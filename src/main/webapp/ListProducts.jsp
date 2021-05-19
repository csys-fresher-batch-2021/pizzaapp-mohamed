<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.sikkandar.service.*"%>
<%@page import="java.util.List"%>
<%@page import="in.sikkandar.model.Product"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>List Pizza Types</h3>
		<table class="table table-bordered">
			<caption>Available PizzaTypes</caption>
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Pizza Name</th>
					<th scope="col">Price</th>
					<th scope="col">Options</th>
				</tr>
			</thead>
			<tbody>
				<!--  Scriptlets ( Java Code ) -->
				<!--  %= Expression - variable value -->
				<!--  Dynamic  -->
				<%
				List<Product> products = ProductService.getProducts();
				int i = 0;
				for (Product product : products) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=product.getName()%></td>
					<td><%=product.getprice()%></td>
					<td><a
						href="DeleteProductServlet?productName=<%=product.getName()%>"
						class="btn btn-danger">Delete</a>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>
</body>
</html>