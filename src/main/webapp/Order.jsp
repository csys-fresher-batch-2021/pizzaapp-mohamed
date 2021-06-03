<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Order Sheet</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>
	<form action="OrderSheetServlet" method="post">
		<h3>ORDER SHEET</h3>
		<label>PizzaType</label><br /> <input type="text" name="pizzaType"
			placeholder="Enter PizzaType" title="Enter the name in correctly"
			required><br /> <br /> <label>Quantity</label><br /> <input
			type="number" name="quantity" placeholder="Enter Quantity"
			title="Enter the quantity one or more" required><br /> <br />
		<button class="btn btn-primary" type="submit">Order</button>
		<button class="btn btn-secondary" type="reset">Reset</button>

	</form>


</body>
</html>