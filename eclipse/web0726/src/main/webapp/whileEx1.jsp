<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String sentence = request.getParameter("sentence");
String count = request.getParameter("count");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	int i = 0;
	while(i < Integer.parseInt(count)){
%>
		<h2><%= sentence%></h2>
		
<%
	i++;
	}
%>
</body>
</html>