<%@page import="home.NoticeDAO"%>
<%@page import="home.NoticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");

NoticeDAO dao = new NoticeDAO();
NoticeDTO dto = new NoticeDTO(0,writer,title,content,"0",0);
dao.insertNotice(dto);

response.sendRedirect("notice.jsp"); // 리다이렉트
%>