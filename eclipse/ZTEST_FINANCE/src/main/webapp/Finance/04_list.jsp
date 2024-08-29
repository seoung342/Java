<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/Finance/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Finance/css/04_list"/>
<title>목록</title>
<style>
body .div_list{
	padding: 100px;
	border: 1px solid red;
}

</style>
</head>
<body>
	<c:forEach var="list" items="${list}">
		
		<div class ="div_list">${list.hiredate }</div>
	</c:forEach>
</body>
</html>