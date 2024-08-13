<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h1>상품 목록</h1>
    <a href="${pageContext.request.contextPath}/registProduct.jsp">상품 추가</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>상품명</th>
            <th>설명</th>
            <th>가격</th>
            <th>수량</th>
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
                    <a href="${pageContext.request.contextPath}/choise.jsp?id=${product.id}">선택</a>
                    <a href="${pageContext.request.contextPath}/selectOneForUpdate.jsp?id=${product.id}">수정</a>
                    <a href="${pageContext.request.contextPath}/delete.jsp?id=${product.id}">삭제</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>