<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="in.sikkandar.service.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String productName = request.getParameter("productName"); 
out.println(productName);

ProductService.addProduct(productName);
%>

</body>
</html>