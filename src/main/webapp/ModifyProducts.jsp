<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>MODIFY PRODUCT</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h3 class="card-title mt-3 text-center">MODIFY PRODUCT</h3>
				<p><jsp:include page="Message.jsp"></jsp:include></p>
				<form action="addproduct.jsp">
					<div class="form-group">
						<button class="btn btn-primary btn-block" type="submit">Add
							Product</button>
					</div>
				</form>

				<form action="DeleteProduct.jsp">
					<div class="form-group">
						<button class="btn btn-danger btn-block" type="submit">Delete
							Product</button>
					</div>
				</form>

				<form action="AdminView.jsp">
					<div class="form-group">
						<button class="btn btn-secondary btn-block" type="submit">View
							Order</button>
					</div>
				</form>

				<form action="UserList.jsp">
					<div class="form-group">
						<button class="btn btn-secondary btn-block" type="submit">User
							List</button>
					</div>
				</form>
			</article>
		</div>
	</main>
</body>
</html>