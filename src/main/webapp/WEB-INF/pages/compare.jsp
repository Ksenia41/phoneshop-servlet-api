<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/common/header.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setBundle basename="i18n.msg"/>
<fmt:setLocale value="en"/>
<html>
<head>
    <title>Compare</title>
</head>
<body>
<p>
    Welcome to compare page!
</p>
<form method="post">
    <table>
        <thead>
        <tr>
            <td>Parameter</td>
                <c:forEach var="compareItems" items="${compare.compareProducts}" varStatus="status">
                    <td>Product ${status.index + 1}</td>
                </c:forEach>
        </tr>
        </thead>
        <tr>
            <td>Id</td>
            <c:forEach var="compareItems" items="${compare.compareProducts}" varStatus="status">
                <td>${compareItems.id}</td>
            </c:forEach>
        </tr>
        <tr>
            <td>Code</td>
            <c:forEach var="compareItems" items="${compare.compareProducts}" varStatus="status">
                <td>${compareItems.code}</td>
            </c:forEach>
        </tr>
        <tr>
            <td>Description</td>
            <c:forEach var="compareItems" items="${compare.compareProducts}" varStatus="status">
                <td>${compareItems.description}</td>
            </c:forEach>
        </tr>
        <tr>
            <td>Price</td>
            <c:forEach var="compareItems" items="${compare.compareProducts}" varStatus="status">
                <td>${compareItems.price}</td>
            </c:forEach>
        </tr>
        <tr>
            <td>Currency</td>
            <c:forEach var="compareItems" items="${compare.compareProducts}" varStatus="status">
                <td>${compareItems.currency}</td>
            </c:forEach>
        </tr>
        <tr>
            <td>Stock</td>
            <c:forEach var="compareItems" items="${compare.compareProducts}" varStatus="status">
                <td>${compareItems.stock}</td>
            </c:forEach>
        </tr><tr>
        <td></td>
        <c:forEach var="compareItems" items="${compare.compareProducts}" varStatus="status">
            <td>
            <input type="text" name="quantity" id="quantity"
                   value="${empty param.addQuantity ?  param.addQuantity :1}"
                   style="text-align: right">
            <c:if test="${error}">
                <label for = "quantity">
                    <fmt:message key="${errorText}" />
                </label>
            </c:if>
                    <button type="submit" name="addToCart" value="${compareItems.id}">Add to cart</button>
                </td>

        </c:forEach>
    </tr>
    </table>
</body>
</html>
