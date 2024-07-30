<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
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

//현재 시간
LocalDateTime now1 = LocalDateTime.now();

//임시 저장 변수들
int numTmp;
String writerTmp = "";
String titleTmp = "";
String contentTmp = "";
String regtimeTmp = "";
int hitsTmp;
String sqlTmp = "";

//매개 변수들
request.setCharacterEncoding("UTF-8");		// 한글 처리
String num = request.getParameter("num");
String title = request.getParameter("title");	// 제목
String writer = request.getParameter("writer");	// 글쓴이
String content = request.getParameter("content");	// 내용
String regtime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(now1);	// 날짜
String delete = request.getParameter("delete"); // 삭제

if(writer != null){
	sqlTmp = "insert into board(writer, title, content, regtime, hits) values (?,?,?,?,?)";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, writer);
	pstmt.setString(2, title);
	pstmt.setString(3, content);
	pstmt.setString(4, regtime);
	pstmt.setString(5, "0");
	pstmt.executeUpdate();
}

if( delete != null ){
	sqlTmp = "delete from board where num = ?";
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
        table     { width:680px; text-align:center; }
        th        { background-color:cyan; }
        
        .num      { width: 80px; }
        .title    { width:230px; }
        .writer   { width:100px; }
        .regtime  { width:180px; }
                
        a:link    { text-decoration:none; color:blue; }
        a:visited { text-decoration:none; color:gray; }
        a:hover   { text-decoration:none; color:red;  }
    </style>
</head>
<body>

<table>
    <tr>
        <th class="num"    >번호    </th>
        <th class="title"  >제목    </th>
        <th class="writer" >작성자  </th>
        <th class="regtime">작성일시</th>
        <th                >조회수  </th>
    </tr>
<%
sqlTmp = "select * from board";
pstmt = conn.prepareStatement(sqlTmp);
ResultSet rs = pstmt.executeQuery();

while(rs.next()) {
	numTmp = rs.getInt("num");
	writerTmp = rs.getString("writer");
	titleTmp = rs.getString("title");
	contentTmp = rs.getString("content");
	regtimeTmp = rs.getString("regtime");
	hitsTmp = rs.getInt("hits");
%>
    <tr>
        <td><%=numTmp %></td>
        <td style="text-align:left;">
            <a href="view.jsp?num=<%=numTmp%>"><%=titleTmp %></a>
        </td>
        <td><%=writerTmp %></td>
        <td><%= regtimeTmp %></td>
        <td><%= hitsTmp %></td>
    </tr>
<%
}
%>
</table>

<br>
<input type="button" value="글쓰기" onclick="location.href='write.jsp'">

</body>
</html>