<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String color = request.getParameter("color");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	body {background-color: <%= color %>}
</style>
<body>
내 이름은 <%= name %> 입니다.<br>
좋아하는 색은 <%= color %> 입니다.

</body>
</html>