<%@page import="board.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BoardDAO dao = new BoardDAO();
List<BoardDTO> list = dao.getBoardList();

Cookie[] cookies = request.getCookies();
String username = null;
boolean flag = false;

if(cookies != null){
	for (Cookie cookie : cookies){
		if(cookie.getName().equals("username")){
			username = cookie.getValue();
			flag = true;
			break;
		}
	}
}
if(flag){
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
<title>홈 화면</title>
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
for(BoardDTO dto : list) {
%>
    <tr>
        <td><%=dto.getNum() %></td>
        <td style="text-align:left;">
            <a href="view.jsp?num=<%=dto.getNum() %>"><%=dto.getTitle() %></a>
        </td>
        <td><%=dto.getWriter() %></td>
        <td><%=dto.getRegtime() %></td>
        <td><%=dto.getHits() %></td>
    </tr>
<%
}
%>
</table>

<br>
<input type="button" value="글쓰기" onclick="location.href='write.jsp'">

</body>
</html>
<%
}else{
	out.println("<script tpye = 'text/javascript'>");
    out.println("alert('로그인을 하세요')");
    out.println("window.location.href = 'index.jsp';");
    out.println("</script>");
}
%>