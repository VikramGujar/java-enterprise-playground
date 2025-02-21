<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.admin.product.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Updated product</title>
</head>
<body>
<%
AdminBean ab = (AdminBean) session.getAttribute("abean");
String msg = (String) request.getAttribute("msg");
out.println("Page Belong to Admin :"+ab.getFirstName());
out.println(msg);
%>

<a href="product.html">AddProduct</a>
<a href="view">ViewAllProduct</a>
<a href="logout">LogOut</a>

</body>
</html>