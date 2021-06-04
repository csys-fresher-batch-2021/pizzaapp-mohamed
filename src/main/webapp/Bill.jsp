<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="in.sikkandar.service.*"%>
<%@page import="java.util.List"%>
<%@page import="in.sikkandar.model.Order"%>


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
					<th scope="col">DeliveryDate</th>
					
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
				%>
				
				<tr>
					<td><%=order.getDate()%></td>
					<td><%=order.getTime()%></td>
					<td><%=order.getPizzaName()%></td>
					<td><%=order.getQuantity()%></td>
					<td><%=order.getPrice()%></td>
					<td><%=order.getTotalAmount()%></td>
					<td><%=order.getGstAmount()%></td>
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