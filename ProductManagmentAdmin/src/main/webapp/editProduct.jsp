<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.admin.product.*"
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>

<div class="container mt-5">
    <div class="card shadow-lg p-4">
        <h3 class="text-primary text-center">Edit Product</h3>

        <%
        AdminBean ab = (AdminBean) session.getAttribute("abean");
        ProductBean pb = (ProductBean) request.getAttribute("pbean");
        %>
        <p class="text-center">Page belongs to Admin: <strong><%= ab.getFirstName() %></strong></p>

        <form action="update" method="post" class="mt-4">
            <input type="hidden" name="pcode" value="<%= pb.getCode() %>">

            <div class="mb-3">
                <label class="form-label">Product Price</label>
                <input type="text" name="price" class="form-control" value="<%= pb.getPrice() %>">
            </div>

            <div class="mb-3">
                <label class="form-label">Product Quantity</label>
                <input type="text" name="qty" class="form-control" value="<%= pb.getQty() %>">
            </div>

            <div class="text-center">
                <input type="submit" class="btn btn-success" value="Update Product">
            </div>
        </form>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
