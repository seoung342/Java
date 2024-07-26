<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Connection con = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
String URL = "jdbc:mysql://localhost:3307/spring5fs";
String sql = "Select * from dept where loc = ?";
con = DriverManager.getConnection(URL,"root","mysql");
pstmt = con.prepareStatement(sql);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dept 테이블 검색</title>
</head>
<body>
<form>
지역 : <input type = "text" name = "loc">
<input type = "submit" value = "검색">
</form><br><br>
<%
	pstmt.setString(1, request.getParameter("loc"));
	ResultSet rs = pstmt.executeQuery();
%>
<table border="1">
	<tr><td colspan="5" align="center">dept 정보</td></tr>
<%
	while(rs.next()){
		String deptno = rs.getString("deptno");
		String dname = rs.getString("dname");
		String loc = rs.getString("loc");
%>
	<tr><td><%=deptno %></td><td><%= dname %></td><td><%= loc %></td></tr>
<%
	}
%>
</table>
</body>
</html>