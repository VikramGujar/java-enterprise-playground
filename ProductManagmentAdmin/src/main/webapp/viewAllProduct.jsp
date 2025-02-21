<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.admin.product.*,java.util.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Products</title>
</head>
<body>
<%
AdminBean ab = (AdminBean) session.getAttribute("abean");
ArrayList<ProductBean> al =
(ArrayList<ProductBean>) session.getAttribute("alist");
out.println("Page belong to Admin : "+ab.getFirstName()+"<br>");
if(al.size()==0)
{
	out.println("Products not available...<br>");
}else{
	Iterator<ProductBean> it = al.iterator();
	while(it.hasNext())
	{
		ProductBean pb = (ProductBean) it.next();
		out.println(pb.getCode()+"&nbsp"
				+pb.getName()+"&nbsp"
				+pb.getPrice()+"&nbsp"
				+pb.getQty()+"&nbsp"
				+"<a href='edit?pcode="+pb.getCode()+"'>Edit</a>"
				+"<a href='delete?pcode="+pb.getCode()+"'>Delete</a>"+"<br>");
	}
}
%>

<a href="product.html">AddProduct</a>
<a href="logout">Logout</a>

</body>
</html>