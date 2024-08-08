<%@page import="home.ContentDTO"%>
<%@page import="home.ContentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");

ContentDAO dao = new ContentDAO();
ContentDTO dto = new ContentDTO(0,writer,title,content,"0",0);
dao.insertContent(dto);

response.sendRedirect("content.jsp"); // 리다이렉트
%>