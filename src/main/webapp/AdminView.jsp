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
#bill {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#bill td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#bill tr:nth-child(even) {
	background-color: #f2f2f2;
}

#bill tr:hover {
	background-color: #ddd;
}

#bill th {
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
		<h3>BILL GENRATION</h3>
		<p class="text-center"><jsp:include page="Message.jsp"></jsp:include></p>
		<table class="table table-bordered" id="bill">
			<caption>DISPLAY BILL</caption>
			<thead>
				<tr>
					<th scope="col">OrderId</th>
					<th scope="col">UserName</th>
					<th scope="col">ProductId</th>
					<th scope="col">OrderDate</th>
					<th scope="col">OrderTime</th> 
					<th scope="col">PizzaName</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">GST Amount</th>
					<th scope="col">TotalPrice</th>
					<th scope="col">DeliveryTime</th>

					<!-- <th scope="col">DeliveryTime</th> -->

				</tr>
			</thead>
			<tbody>
				<!--  Scriptlets ( Java Code ) -->
				<!--  %= Expression - variable value -->
				<!--  Dynamic  -->
				<%
				List<Order> orders = OrderDao.getAdminBillList();
				int i = 0;
				for (Order order : orders) {
					i++;
					String orderedDate = order.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
					String orderedTime = order.getTime().format(DateTimeFormatter.ofPattern("HH:mm"));
					String deliveryTime = order.getDeliveryTime().format(DateTimeFormatter.ofPattern("HH:mm")); 
				%>

				<tr>
					<td><%=i%></td>
					<td><%=order.getUser().getName()%></td>
					<td><%=order.getProduct().getId()%></td>
					<td><%=order.getDate()%></td>
					<td><%=order.getTime()%></td>
					<td><%=order.getPizzaName()%></td>
					<td><%=order.getQuantity()%></td>
					<td><%=order.getPrice()%></td>
					<td><%=order.getGstAmount()%></td>
					<td><%=order.getTotalAmount()%></td>
					<td><%=order.getDeliveryTime()%></td>
				</tr>
				<%
				}
				%>


			</tbody>
		</table>
	</main>
</body>
</html>
