<%@page import="home.NoticeDTO"%>
<%@page import="home.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("UTF-8");

String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");
int num = Integer.parseInt(request.getParameter("num"));
int hits = Integer.parseInt(request.getParameter("hits"));

NoticeDAO dao = new NoticeDAO();
NoticeDTO dto = new NoticeDTO(num,writer,title,content,"0",hits);
dao.getUpdate(dto);

response.sendRedirect("notice.jsp"); // 리다이렉트
%>