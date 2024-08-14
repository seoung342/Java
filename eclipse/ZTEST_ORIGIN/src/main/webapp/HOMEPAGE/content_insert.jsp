<%@page import="home.Content"%>
<%@page import="home.ContentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");
String user_id = request.getParameter("user_id");

ContentDAO dao = new ContentDAO();
Content dto = new Content(0,writer,title,content,"0",0,user_id);
dao.insertContent(dto);

response.sendRedirect("content.jsp"); // 리다이렉트
%>