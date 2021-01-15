<%--
  Created by IntelliJ IDEA.
  User: Faceless
  Date: 1/15/2021
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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

<a href="/products"><input type="submit" value="Back"></a>
</body>
</html>
