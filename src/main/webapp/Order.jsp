<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Order Sheet</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>
	<div class="card bg-light">
		<article class="card-body mx-auto" style="max-width: 400px;">
			<h3 class="card-title mt-3 text-center">ORDER SHEET</h3>
			<p class="text-center"><jsp:include page="Message.jsp"></jsp:include></p>
			<form action="OrderSheetServlet" method="post">

				<label>Pizza type</label>
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> </span>
					</div>
					<input name="pizzaType" class="form-control"
						placeholder="Enter pizzaname " autocomplete="off" type="text"
						required>
				</div>

				<label>Quantity</label>
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> </span>
					</div>
					<input name="quantity" class="form-control"
						placeholder="Enter quantity" autocomplete="off" type="number"
						required>
				</div>

				<div class="form-group">
					<button class="btn btn-primary btn-block" type="submit">Order</button>
					</br>
					<button class="btn btn-danger btn-block" type="reset">Reset</button>
				</div>
			</form>
		</article>
	</div>

</body>
</html>