<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.admin.product.*,java.util.*"
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Products</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>

<div class="container mt-5">
    <div class="card shadow-lg p-4">
        <h3 class="text-primary text-center">Product List</h3>
        <%
        AdminBean ab = (AdminBean) session.getAttribute("abean");
        ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("alist");
        %>
        <p class="text-center">Page belongs to Admin: <strong><%= ab.getFirstName() %></strong></p>

        <% if (al.size() == 0) { %>
            <p class="text-danger text-center">No products available...</p>
        <% } else { %>
            <table class="table table-bordered mt-3">
                <thead class="table-dark">
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    for (ProductBean pb : al) { 
                    %>
                    <tr>
                        <td><%= pb.getCode() %></td>
                        <td><%= pb.getName() %></td>
                        <td><%= pb.getPrice() %></td>
                        <td><%= pb.getQty() %></td>
                        <td>
                            <a href='edit?pcode=<%= pb.getCode() %>' class="btn btn-warning btn-sm">Edit</a>
                            <a href='delete?pcode=<%= pb.getCode() %>' class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        <% } %>

        <div class="mt-3 text-center">
            <a href="product.html" class="btn btn-primary">Add Product</a>
            <a href="logout" class="btn btn-danger">Logout</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
