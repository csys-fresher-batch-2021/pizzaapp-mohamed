<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.sikkandar.service.*"%>
<%@page import="java.util.List"%>
<%@page import="in.sikkandar.model.Order"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalTime"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>BILL GENRATION</h3>
		<table class="table table-bordered">
			<caption>DISPLAY BILL</caption>
			<thead>
				<tr>
					<th scope="col">OrderDate</th>
					<th scope="col">OrderTime</th>
					<th scope="col">PizzaName</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">TotalPrice</th>
					<th scope="col">TotalAmount+GST Amount</th>
					<th scope="col">DeliveryTime</th>

				</tr>
			</thead>
			<tbody>
				<!--  Scriptlets ( Java Code ) -->
				<!--  %= Expression - variable value -->
				<!--  Dynamic  -->
				<%
				List<Order> orders = OrderSheetService.getOrders();
				int i = 0;
				for (Order order : orders) {
					i++;
					String orderedDate = order.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
					String orderedTime = order.getTime().format(DateTimeFormatter.ofPattern("HH:mm"));
					String deliveryTime = order.getDeliveryTime().format(DateTimeFormatter.ofPattern("HH:mm"));
				%>

				<tr>
					<td><%=orderedDate%></td>
					<td><%=orderedTime%></td>
					<td><%=order.getPizzaName()%></td>
					<td><%=order.getQuantity()%></td>
					<td><%=order.getPrice()%></td>
					<td><%=order.getTotalAmount()%></td>
					<td><%=order.getGstAmount()%></td>
					<td><%=deliveryTime%></td>

				</tr>
				<%
				}
				%>


			</tbody>
		</table>
	</main>

</body>
</html>