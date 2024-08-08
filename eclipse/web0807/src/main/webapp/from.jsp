<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("kk", 7);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>from 페이지</title>
</head>
<body>
<jsp:forward page="to.jsp"/>
</body>
</html>