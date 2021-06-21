<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h3 class="card-title mt-3 text-center">USER REGISTRATION</h3>
				<p class="text-center"><jsp:include page="Message.jsp"></jsp:include></p>
				<form action="UserRegistrationServlet" method="post">

					<label>NAME</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-user"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="userName" class="form-control"
							placeholder="Enter User Name" autocomplete="off" type="text"
							required>
					</div>

					<label>EMAIL</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-envelope"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="email" class="form-control"
							placeholder="Enter Email" autocomplete="off" type="text"
							required>
					</div>

					<label>MOBILE NUMBER</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-mobile"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="mobile" class="form-control"
							placeholder="Enter mobile number" autocomplete="off" type="number"
							required>
					</div>

					<label>ADDRESS</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em
								class="fa fa-address-card" style="font-size: 24px"></em>
							</span>
						</div>
						<input name="address" class="form-control"
							placeholder="Enter address" autocomplete="off" type="text"
							required>
					</div>

					<label>PASSWORD</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-key"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="pass" class="form-control"
							placeholder="Enter password" autocomplete="off" type="password"
							required>
					</div>

					<label>RE-ENTER PASSWORD</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-key"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="reenterPass" class="form-control"
							placeholder="Enter reenter password" autocomplete="off" type="password"
							required>
					</div>

					<div class="form-group">
						<button class="btn btn-primary btn-block" type="submit">Register</button>
						</br>
						<button class="btn btn-danger btn-block" type="reset">Reset</button>
					</div>
				</form>
			</article>
		</div>
	</main>
</body>
</html>