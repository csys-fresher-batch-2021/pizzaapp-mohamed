<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Product</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="AddProductServlet">
			<h3>ADD PRODUCT</h3>
			<p><jsp:include page="Message.jsp"></jsp:include></p>
			<label>product ID</label> <input type="number" name="id"
				placeholder="Enter Id" required autofocus /> <br /> <label>Product
				Name</label> <input type="text" name="name" placeholder="Enter PizzaName"
				required autofocus /><br /> <label>Product Price</label> <input
				type="number" name="price" placeholder="Enter price" required
				autofocus /> <br />
			<button class="btn btn-primary">Add</button>
			<button class="btn btn-danger" type="reset">Reset</button>
		</form>
	</main>
</body>
</html>