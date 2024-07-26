<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	Connection con = null;
	Statement stmt = null;
	Class.forName("com.mysql.cj.jdbc.Driver");
	String URL = "jdbc:mysql://localhost:3307/spring5fs";
	String sql = "select * from score";
	con = DriverManager.getConnection(URL,"root","mysql");
	stmt = con.prepareStatement(sql);
	ResultSet rs = stmt.executeQuery(sql);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td>번호</td><td>이름</td><td>국어</td><td>영어</td><td>수학</td><td>총점</td><td>평균</td>
	</tr>
<%
	while(rs.next()){
		String num = rs.getString("num");
		String name = rs.getString("name");
		String kor = rs.getString("kor");
		String eng = rs.getString("eng");
		String math = rs.getString("math");
		int total = Integer.parseInt(kor) + Integer.parseInt(eng) + Integer.parseInt(math);
		double avg = (double) total / 3;
%>
	<tr>
		<td><%=num %></td><td><%=name %></td><td><%=kor %></td><td><%=eng %></td><td><%=math %></td><td><%=total %></td><td><%=avg %></td>
	</tr>	
<%
}
%>
</table>

</body>
</html>