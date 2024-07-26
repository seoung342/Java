<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String num = request.getParameter("num");
	String name = request.getParameter("name");
	String kor = request.getParameter("kor");
	String eng = request.getParameter("eng");
	String math = request.getParameter("math");
	
	Connection con = null;
	PreparedStatement pstmt = null;
	Class.forName("com.mysql.cj.jdbc.Driver");
	String URL = "jdbc:mysql://localhost:3307/spring5fs";
	String sql = "insert into score (num, name, kor, eng, math) values (?,?,?,?,?)";
	con = DriverManager.getConnection(URL,"root","mysql");
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, num);
	pstmt.setString(2, name);
	pstmt.setString(3, kor);
	pstmt.setString(4, eng);
	pstmt.setString(5, math);
	pstmt.executeUpdate();
%>
<form>
학번 : <%= num %><br>
이름 : <%= name %><br>
국어 : <%= kor %><br>
영어 : <%= eng %><br>
수학 : <%= math %><br>
</form>
</body>
</html>