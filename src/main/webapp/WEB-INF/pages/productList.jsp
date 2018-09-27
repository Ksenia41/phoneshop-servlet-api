<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="products" type="java.util.ArrayList" scope="request"/>
<jsp:include page="/WEB-INF/common/header.jsp"/>
<html>

<head>
    <style>
        <%@include file="/WEB-INF/style/productListStyles.css"%>
    </style>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/productListStyles.css">
    <title>ProductList</title>
</head>

<body>
<p>
    Product List
</p>
<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>Code</td>
        <td>Description</td>
        <td>Price</td>
        <td>Currency</td>
        <td>Stock</td>
    </tr>
    </thead>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.code}</td>
            <td><a href="./products/${product.id}">${product.description}</a></td>
            <td>${product.price}</td>
            <td>${product.currency}</td>
            <td>${product.stock}</td>
        </tr>
    </c:forEach>
    <form method="post">
        <input type="hidden" name="productSearch" value="productSearch">
        <input type="text" id="productSearch" name="productSearch"
               value="${researchParam != null ?  researchParam : ""}">
            <button type="submit" name="search" value="${cartItems.product.id}">Search</button>
    </form>
</table>
</body>
</html>

<jsp:include page="/WEB-INF/common/footer.jsp"/>

