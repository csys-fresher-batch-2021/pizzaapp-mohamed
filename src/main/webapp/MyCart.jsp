<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.sikkandar.service.*"%>
<%@page import="java.util.List"%>
<%@page import="in.sikkandar.model.CartDetails"%>
<%@page import="in.sikkandar.model.User"%>
<%@page import="in.sikkandar.model.Product"%>
<%@page import="in.sikkandar.dao.CartDetailsDao"%>

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
			<caption>CartDetails</caption>
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Pizza Name</th>
					<th scope="col">Price</th>
					<th scope="col">Buy</th>
					<th scope="col">DeleteCart</th>
				</tr>
			</thead>
			<tbody>
				<!--  Scriptlets ( Java Code ) -->
				<!--  %= Expression - variable value -->
				<!--  Dynamic  -->
				<%
				List<CartDetails> userCartList = (List<CartDetails>) request.getAttribute("CART_DETAILS");
				//List<Product> products = ProductService.getProducts();
				int i = 0;
				for (CartDetails carts : userCartList) {
					i++;
					Product product = carts.getProduct();
				%>
				<tr>
					<td><%=i%></td>
					<td><%=product.getName()%></td>
					<td><%=product.getPrice()%></td>
					<td><a href="Order.jsp?productName=<%=product.getName()%>"><button
								class="btn-btn-primary">BUY NOW</button></a></td>
					<td><a
						href="DeleteCartServlet?productName=<%=product.getName()%>"><button
								class="btn-btn-primary">REMOVE</button></a></td>
					<%
					}
					%>

				</tr>
			</tbody>
		</table>
	</main>
</body>
</html>
