<%--
  Created by IntelliJ IDEA.
  User: Faceless
  Date: 1/15/2021
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Management</title>
</head>
<body>
    <c:if test="${message!=null}">
        <p>${message}</p>
    </c:if>
    <fieldset>
        <form method="post">
            <legend>ADD NEW PRODUCT</legend>
            <h3>Name</h3><br>
            <input type="text" name="nameProduct" placeholder="Name"><br>
            <h3>Price</h3><br>
            <input type="number" name="price" placeholder="Price"><br>
            <h3>Quantity</h3><br>
            <input type="number" name="quantity" placeholder="Quantity"><br>
            <h3>Color</h3><br>
            <input type="text" name="color" placeholder="Color"><br>
            <h3>Description</h3>
            <input type="text" name="description" placeholder="Description"><br>
            <select name="categoryId">
                <c:forEach items="${categoryList}" var="category">
                    <option value="${category.getId()}">${category.getCategoryDevice()}</option>
                </c:forEach>
            </select><br>
            <input type="submit">
        </form>
    </fieldset>
    <a href="/products"><input type="submit" value="Back"></a>
</body>
</html>
