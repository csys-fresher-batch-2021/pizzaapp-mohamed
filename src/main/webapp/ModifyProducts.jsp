<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
<form action="addproduct.jsp">
<br/><button class="btn btn-primary" > Add Product</button>
		
		</form>
		<br/>
		<form action="DeleteProduct.jsp">
<button class="btn btn-danger" > Delete Product</button>
		
		</form>
		</main>
</body>
</html>