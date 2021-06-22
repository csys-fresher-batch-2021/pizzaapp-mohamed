<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Product</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h3 class="card-title mt-3 text-center">ADD PRODUCT</h3>
				<p class="text-center"><jsp:include page="Message.jsp"></jsp:include></p>
				<form action="AddProductServlet">
					<label>Product id:</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-plus"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="id" class="form-control"
							placeholder="Enter product id" autocomplete="off" type="number"
							required>
					</div>

					<label>Product name:</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-plus"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="name" class="form-control"
							placeholder="Enter product name" autocomplete="off" type="text"
							required>
					</div>

					<label>Product price:</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-plus"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="price" class="form-control"
							placeholder="Enter product price" autocomplete="off"
							type="number" required>
					</div>

					<div class="form-group">
						<button class="btn btn-primary btn-block" type="submit">Add</button>
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