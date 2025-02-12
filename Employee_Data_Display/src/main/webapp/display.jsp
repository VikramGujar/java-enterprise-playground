<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	String department = request.getParameter("dep");
	String salary = request.getParameter("sal");
	String mail = request.getParameter("mail");
	long phone = Long.parseLong(request.getParameter("phone"));
	
	out.println("Emp ID : "+id+"<br>");
	out.println("Emp Name : "+name+"<br>");
	out.println("Emp Deparment : "+department+"<br>");
	out.println("Emp Salary : "+salary+"<br>");
	out.println("Emp Mail : "+mail+"<br>");
	out.println("Emp Phone : "+phone+"<br>");
	

%>
</body>
</html>