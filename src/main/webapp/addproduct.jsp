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
			<label>Product Name</label> <input type="text"
				name="productName" placeholder="Enter PizzaName" required autofocus /><br />
			<label>Price</label> <input type="number"
				name="price" placeholder="Enter price" required autofocus /> <br />
			<button class="btn btn-primary">Add</button>
		<button class="btn btn-danger" type="reset">Reset</button>
		</form>
	</main>
</body>
</html>