<%--
  Created by IntelliJ IDEA.
  User: Faceless
  Date: 1/15/2021
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div style="float: left;width: 60%">
    <a href="/products?action=create">
        + Add New Product
    </a>
</div>
<div style="float: left;width: 30%">
    <form action="/products?action=search" method="post">
        <input type="text" name="search"  placeholder="Search">
        <input type="submit">
    </form>
</div>
<c:if test="${productList!=null}">
    <table border="1" cellpadding="5">
        <tr>
            <th>#</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${productList}" var="product">
            <tr>
                <td>${product.getId()}</td>
                <td>${product.getProductName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getQuantity()}</td>
                <td>${product.getColor()}</td>
                <td>${product.getCategory()}</td>
                <td>
                    <a href="/products?action=edit&id=${product.getId()}"><input type="submit" value="Edit"></a> |
                    <a href="/products?action=delete&id=${product.getId()}"><input type="submit" value="Delete"></a>
                </td>

            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
