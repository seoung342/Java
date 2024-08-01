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
int num = Integer.parseInt(request.getParameter("num"));
int hits = Integer.parseInt(request.getParameter("hits"));
String regtime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(now1);

BoardDAO dao = new BoardDAO();
BoardDTO dto = new BoardDTO(num,writer,title,content,regtime,hits);
dao.getUpdate(dto);

response.sendRedirect("list.jsp"); // 리다이렉트
%>
