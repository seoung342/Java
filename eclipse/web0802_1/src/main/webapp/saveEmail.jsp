<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookies cookies = new Cookies(request);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일을 쿠키에 저장하려는 폼</title>
</head>
<body>
<form action = "saveEmailResult.jsp" method = "post">
	<label for = "email">Email : </label>
	<input type = "email" id = "email" name = "email" value = "<%= cookies.getValue("Email") %>" required>
	<input type = "submit" value = "Submit">
</form><br>
<a href="saveEmailCheck.jsp">이메일 확인하기</a>
</body>
</html>