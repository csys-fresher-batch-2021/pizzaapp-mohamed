<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="DeleteProductServlet">
			<h3>DELETE PRODUCT</h3>
			<label>Product Name</label> <input type="text"
				name="productName" placeholder="Enter PizzaName" required autofocus /><br />
			<label>Product Id</label> <input type="number"
				name="productId" placeholder="Enter Id" required autofocus /> <br />
			<button class="btn btn-primary">Delete</button>
		<button class="btn btn-danger" type="reset">Reset</button>
		</form>
	</main>

</body>
</html>