<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%
// 데이터베이스 연결 
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");
// 임시 저장 변수들
String idTmp = "";
String nameTmp = "";
String ssnTmp = "";
String telTmp = "";
String balanceTmp = "";
String sqlTmp = "";
// 매개 변수들
request.setCharacterEncoding("UTF-8");		// 한글 처리
String find =request.getParameter("find");	// update시 넘어오는 매개변수
String delete = request.getParameter("delete"); // 삭제
String id = request.getParameter("id");	// null이면 insert나 update를 하지 말아야
String name = request.getParameter("name");
String ssn = request.getParameter("ssn");
String tel = request.getParameter("tel");
String balance = request.getParameter("balance");    

if (id != null) {
	sqlTmp = "select count(*) from account where id = ?"; //이미 있는 학번 조회(있으며 1을 가져옴)
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, id);
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	int cnt = rs.getInt(1); // 0:insert, 1:update
	if (cnt == 1) { // 정보 수정
		sqlTmp = "update account set name = ?, ssn = ?, tel = ?, balance = ? where id = ?";
		pstmt = conn.prepareStatement(sqlTmp);
		pstmt.setString(1, name);
		pstmt.setString(2, ssn);
		pstmt.setString(3, tel);
		pstmt.setString(4, balance);
		pstmt.setString(5, id);
		int ret = pstmt.executeUpdate();
	} else { //정보 입력
		sqlTmp = "insert into account(id, name, ssn, tel, balance) values (?,?,?,?,?)";
		pstmt = conn.prepareStatement(sqlTmp);
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, ssn);
		pstmt.setString(4, tel);
		pstmt.setString(5, balance);
		pstmt.executeUpdate();
	}
}
if (find != null) {
	sqlTmp = "select * from account where id = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, find);
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
		idTmp = rs.getString("id");
		nameTmp = rs.getString("name");
		ssnTmp = rs.getString("ssn");
		telTmp = rs.getString("tel");
		balanceTmp = rs.getString("balance");
	}
}

if (delete != null) {
	sqlTmp = "delete from account where id = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, delete);
	pstmt.executeUpdate();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <style>
        table { width: 700px; text-align: left; }
        th    { width: 50px; background-color: cyan; }
    </style>
<title>학생 점수 관리 프로그램</title>
</head>
<body>
<form>
	번호: <input type="text" name="id" value="<%=idTmp %>"><br>
	이름: <input type="text" name="name" value="<%=nameTmp %>"><br>
    주민번호: <input type="text" name="ssn" value="<%=ssnTmp %>"><br>
    전화번호: <input type="text" name="tel" value="<%=telTmp %>"><br>
    잔고: <input type="text" name="balance" value="<%=balanceTmp %>"><br>
    <input type="submit" value="입력/수정">
</form>
<table>
	<tr>
        <th>번호</th><th>이름</th><th>주민번호</th>
        <th>전화번호</th><th>잔고</th><th>삭제</th>
    </tr>
<%
sqlTmp = "select * from account";
pstmt = conn.prepareStatement(sqlTmp);
ResultSet rs = pstmt.executeQuery();

while(rs.next()) {
	idTmp = rs.getString("id");
	nameTmp = rs.getString("name");
	ssnTmp = rs.getString("ssn");
	telTmp = rs.getString("tel");
	balanceTmp = rs.getString("balance");
%>
	<tr>
		<td><a href="?find=<%= idTmp %>"><%= idTmp %></a></td><td><%= nameTmp %></td><td><%= ssnTmp %></td>
		<td><%= telTmp %></td><td><%= balanceTmp %>
		<td><button type="button" onclick="location.href='?delete=<%=idTmp%>' ">삭제</button></td>
	</tr>

<%
}
%>
</table>
</body>
</html>