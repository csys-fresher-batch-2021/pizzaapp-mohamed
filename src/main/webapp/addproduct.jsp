<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Product</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Product</h3>
		<!-- <form action="addproduct_action.jsp">-->
		<form action="AddProductServlet">
			<label for="productName">Product Name</label> <input type="text"
				name="productName" placeholder="Product Name" required autofocus />
			<br />
			<button type="submit">Submit</button>

         
		</form>
	</main>
</body>
</html>