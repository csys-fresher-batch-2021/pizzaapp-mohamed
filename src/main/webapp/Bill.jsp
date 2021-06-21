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
<title>BILL GENRATION</title>
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
					<th scope="col">PizzaName</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">GST Amount</th>
					<th scope="col">TotalPrice</th>
					<th scope="col">DeliveryTime</th>
					<th scope="col">Option</th>
				</tr>
			</thead>
			<tbody>
				<!--  Scriptlets ( Java Code ) -->
				<!--  %= Expression - variable value -->
				<!--  Dynamic  -->
				<%
				String productName = request.getParameter("productName");
				Integer quantity = Integer.parseInt(request.getParameter("quantity"));
				float price = Float.parseFloat(request.getParameter("price"));
				double gstAmount = Float.parseFloat(request.getParameter("gstAmount"));
				float totalAmount = Float.parseFloat(request.getParameter("totalPrice"));
				String deliveryTime = request.getParameter("deliveryTime");

				//String orderedDate = order.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				//String orderedTime = order.getTime().format(DateTimeFormatter.ofPattern("HH:mm"));
				//String deliveryTime = deliveryTime.format(DateTimeFormatter.ofPattern("HH:mm"));
				%>

				<tr>
					<td><%=productName%></td>
					<td><%=quantity%></td>
					<td><%=price%></td>
					<td><%=gstAmount%></td>
					<td><%=totalAmount%></td>
					<td><%=deliveryTime%></td>
					<td><a
						href="ConfirmOrderServlet?productName=<%=productName%>&quantity=<%=quantity%>&price=<%=price%>&gstAmount=<%=gstAmount%>&totalAmount=<%=totalAmount%>">
							<button class="btn btn-primary">Confirm Order</button>
					</a></td>


				</tr>


			</tbody>
		</table>
		<div class="text-center"></div>
	</main>

</body>
</html>