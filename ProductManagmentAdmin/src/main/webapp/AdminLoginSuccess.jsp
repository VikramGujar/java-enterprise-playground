<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="com.admin.product.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminLoginSuccessfull</title>
</head>
<body>
	<%
	AdminBean ab = (AdminBean) session.getAttribute("abean");
	out.println("Welcome Admin : "+ab.getFirstName()+"<br>");
	%>
	<a href="product.html">AddProduct</a>
	<a href="view">ViewAllProduct</a>
	<a href="logout">LogOut</a>
	
</body>
</html>