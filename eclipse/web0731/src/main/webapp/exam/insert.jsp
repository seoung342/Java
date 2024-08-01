<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
LocalDateTime now1 = LocalDateTime.now();

String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");
String regtime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(now1);

BoardDAO dao = new BoardDAO();
BoardDTO dto = new BoardDTO(0,writer,title,content,regtime,0);
dao.insertBoard(dto);

response.sendRedirect("list.jsp"); // 리다이렉트
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>입력 성공!</h1>
</body>
</html>