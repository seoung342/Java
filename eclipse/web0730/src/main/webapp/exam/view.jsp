<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//데이터베이스 연결 
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");

//임시 저장 변수들
String numTmp = "";
String writerTmp = "";
String titleTmp = "";
String contentTmp = "";
String regtimeTmp = "";
String hitsTmp = "";
String sqlTmp = "";
int count = 0;
//매개 변수들
request.setCharacterEncoding("UTF-8");		// 한글 처리
String num = request.getParameter("num");
String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");
String update = request.getParameter("update");




if( num != null){
	sqlTmp = "select * from board where num = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, num);
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
		numTmp = rs.getString("num");
		titleTmp = rs.getString("title");
		writerTmp = rs.getString("writer");
		regtimeTmp = rs.getString("regtime");
		hitsTmp = rs.getString("hits");
		contentTmp = rs.getString("content");
	}
	count = Integer.parseInt(hitsTmp)+1;
	
	sqlTmp = "update board set hits = ? where num = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setInt(1, count);
	pstmt.setString(2, String.valueOf(numTmp));
	pstmt.executeUpdate();
}
if ( update != null){
	sqlTmp = "update board set writer = ?, title = ?, content = ?, regtime = now() where num = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, writer);
	pstmt.setString(2, title);
	pstmt.setString(3, content);
	pstmt.setString(4, num);
	pstmt.executeUpdate();
}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        td    { text-align:left; border:1px solid gray; }
    </style>
</head>
<body>
<form>
<table>
    <tr>
        <th>제목</th>
        <td><%= titleTmp %></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><%= writerTmp %></td>
    </tr>
    <tr>
        <th>작성일시</th>
        <td><%= regtimeTmp %></td>
    </tr>
    <tr>
        <th>조회수</th>
        <td><%= count %></td>
    </tr>
    <tr>
        <th>내용</th>
        <td><%= contentTmp %></td>
    </tr>
</table>
</form>
<br>
<input type="button" value="목록보기" onclick="location.href='list.jsp'">
<input type="button" value="수정"
       onclick="location.href='update.jsp?update=<%=numTmp%>'">
<input type="button" value="삭제"
       onclick="location.href='list.jsp?delete=<%= numTmp%>'">

</body>
</html>
