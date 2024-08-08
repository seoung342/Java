<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ page import="java.sql.*, java.util.*"
%><html>
<head>
<title>JSP Oracle, JDBC 예제</title>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="Pragma" content="no-cache"/>
</head>
<body>
<%
    Connection conn = null;

	String sql = "Select * from dept";
	PreparedStatement pstmt = null;
	String DB_HOST = "jdbc:oracle:thin:@172.17.0.1:1521:xe"; // 아이피, 포트, 서비스(SID) 정보를 수정
    String DB_USER = "scott"; // 아이디(유저) - 11g 이상시 대소문자 구분 확인
    String DB_PASS = "tiger"; // 패스워 - 11g 이상시 대소문자 구분 확인
    
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASS);
    pstmt = conn.prepareStatement(sql);
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