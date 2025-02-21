<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="com.admin.product.AdminBean"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Login Successful</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>

<div class="container mt-5">
    <div class="card shadow-lg p-4 text-center">
        <h3 class="text-success">Admin Dashboard</h3>
        <div class="mt-3">
            <%
                AdminBean ab = (AdminBean) session.getAttribute("abean");
                out.println("<h5>Welcome, " + ab.getFirstName() + "</h5>");
            %>
        </div>
        <div class="mt-4">
            <a href="product.html" class="btn btn-primary m-2">Add Product</a>
            <a href="view" class="btn btn-warning m-2">View All Products</a>
            <a href="logout" class="btn btn-danger m-2">Log Out</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
