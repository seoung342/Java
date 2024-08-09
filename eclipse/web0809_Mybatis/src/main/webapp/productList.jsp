<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h1>Product List</h1>
    <a href="${pageContext.request.contextPath}/registProduct.jsp">Add New Product</a><br>
	<a href="${pageContext.request.contextPath}/products.jsp">물건 보기</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Stock</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.stock}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/products/${product.id}">View</a>
                    <a href="${pageContext.request.contextPath}/edit.jsp?update=${product.id}">선택</a>
                    <a href="${pageContext.request.contextPath}/delete.jsp?delete=${product.id}">삭제</a>
                </td>
            </tr>
        </c:forEach>
    </table><br><br>
   
    <c:if test="${not empty cart}">
        <h1>주문한 물건</h1>
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Stock</th>
            </tr>
            <c:forEach var="entry" items="${cart}">
                <tr>
                    <td>${entry.key}</td>
                    <td>${entry.value.description}</td>
                    <td>${entry.value.price}</td> 
                    <td>${entry.value.stock}</td>
                </tr>
            </c:forEach>
            <td colspan="4">총 가격 : ${total } </td>
        </table>
    </c:if>
</body>
</html>