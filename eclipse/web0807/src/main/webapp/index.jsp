<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	session.setAttribute("vv", "홍길동");
	String ss = (String)session.getAttribute("vv");
	request.setAttribute("kk","김하나");
%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${100+2 }<br>
${vv == '홍길동'}<br>
${vv }
<br>
<%=ss %>
<br>
${kk }
</body>
</html>