<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String str = (String) session.getAttribute("key1");
	List<String> list = (List<String>) session.getAttribute("key2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 정보 가져오기</title>
</head>
<body>
<%= str %><br>
<%= list %>
</body>
</html>