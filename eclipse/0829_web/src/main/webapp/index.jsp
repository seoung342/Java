<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(URL, "root", "mysql");
} catch (ClassNotFoundException | SQLException e) {
	e.printStackTrace();
}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 100%;
	border-collapse: collapse; /* 테두리 합침 */
	margin: 20px 0; /* 위와 아래 여백 */
	background-color: #fff; /* 배경색 흰색 */
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* 그림자 */
}

th, td {
	padding: 10px; /* 셀 안쪽 여백 */
	text-align: left; /* 좌측 정렬 */
	border-bottom: 1px solid #ddd; /* 하단 테두리 */
}

th {
	background-color: #f4f4f4; /* 헤더 배경색 */
	color: #333; /* 헤더 글자색 */
	font-weight: bold; /* 헤더 글자 두께 */
}

tr:hover {
	background-color: #f9f9f9; /* 마우스 오버 시 배경색 */
}
</style>
</head>
<body>
<table>
		<tr>
			<td>JSON</td>
		</tr>
		<tr>
			<%
			String sql = "select json_object('empno',empno,'ename',ename,'job',job,'sal',sal) as json from emp;";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			StringBuilder arrayBuilder = new StringBuilder();
			while (rs.next()) {
				 String json = rs.getString("json");
				 arrayBuilder.append(json).append(",");
			%>
			<td><%=json%></td>
		</tr>
		<%
		}
			if (arrayBuilder.length() > 0) {
		        arrayBuilder.setLength(arrayBuilder.length() - 1);
		    }
			String array = "'" + arrayBuilder.toString() + "'";
		    %>
		    <tr>
        <td><%= array %></td>
    </tr>
	</table>
</body>
</html>