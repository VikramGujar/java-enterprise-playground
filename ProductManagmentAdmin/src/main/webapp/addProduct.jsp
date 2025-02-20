<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.admin.product.AdminBean"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product added</title>
</head>
<body>
<%
	AdminBean ab = (AdminBean) session.getAttribute("abean");
	String msg = (String) request.getAttribute("msg");
	out.println("Page belongs to Admin : "+ab.getFirstName()+"<br>");
	out.println(msg);
%>

<a href="product.html">AddProduct</a>
<a href="view">ViweAllProduct</a>
<a href="logout">Logout</a>
	
</body>
</html>