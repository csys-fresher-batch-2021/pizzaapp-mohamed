<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Product</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>ADD PRODUCT</h3>

		<form action="AddProductServlet">
			<label for="productName">Product Name</label> <input type="text"
				name="productName" placeholder="Enter PizzaName" required autofocus /><br />
			<label for="productName">Price</label> <input type="number"
				name="price" placeholder="Enter price" required autofocus /> <br />
			<button type="submit">Submit</button>
		</form>

	</main>
</body>
</html>