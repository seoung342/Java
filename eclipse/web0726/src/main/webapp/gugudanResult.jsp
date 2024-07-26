<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
int gugu = Integer.parseInt(request.getParameter("gugu"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
<table border="1">
	<tr>
	<td colspan="4" align="center"><%=gugu %>단</td>
	</tr>
<%
	for (int x = 1 ; x <= 9; x++) {
		%>
	<tr>
	<td><%=gugu %> X <%= x %> = <%= x * gugu %></td>
	</tr>
<%
}
%>
</table>
</body>
</html>