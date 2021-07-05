<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.sikkandar.service.*"%>
<%@page import="java.util.List"%>
<%@page import="in.sikkandar.model.Order"%>
<%@page import="in.sikkandar.dao.OrderDao"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalTime"%>



<!DOCTYPE html>
<html lang="en">
<head>
<style>
#userTable {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#userTable td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#userTable tr:nth-child(even) {
	background-color: #f2f2f2;
}

#userTable tr:hover {
	background-color: #ddd;
}

#userTable th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}
</style>
<meta charset="ISO-8859-1">
<title>ALL ORDERS</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>ALL ORDERS</h3>
		<p class="text-center"><jsp:include page="Message.jsp"></jsp:include></p>
		<table class="table table-bordered" id="userTable">
			<thead>
				<tr>
					<th scope="col">OrderId</th>
					<th scope="col">UserName</th>
					<th scope="col">OrderDate</th>
					<th scope="col">OrderTime</th>
					<th scope="col">PizzaName</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">GST Amount</th>
					<th scope="col">TotalPrice</th>
					<th scope="col">DeliveryTime</th>
					<th scope="col">DeliveryDate</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
		
	</main>
	<script src="assets/js/AllOrders.js">
		
	</script>
</body>
</html>
