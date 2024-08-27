<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/Finance/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Finance/css/01_main.css"/>
<title>목록</title>
</head>
<body>
	<c:forEach var="list" items="${list}">
		
		<div>${list.hiredate }</div>
	</c:forEach>
</body>
</html>