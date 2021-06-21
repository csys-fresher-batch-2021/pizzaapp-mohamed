<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Delete Product</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h3 class="card-title mt-3 text-center">DELETE PRODUCT</h3>
				<p class="text-center"><jsp:include page="Message.jsp"></jsp:include></p>
				<form action="DeleteProductServlet">
					<label>Product Id</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-minus"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="productId" class="form-control"
							placeholder="Enter product id" autocomplete="off" type="number"
							required>
					</div>

					<label>ProductName</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-minus"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="productName" class="form-control"
							placeholder="Enter product name" autocomplete="off" type="text"
							required>
					</div>
					<div class="form-group">
						<button class="btn btn-primary btn-block" type="submit">Delete</button>
					</div>
					<div class="form-group">
						<button class="btn btn-danger btn-block" type="reset">Reset</button>
					</div>
				</form>
			</article>
		</div>

	</main>

</body>
</html>