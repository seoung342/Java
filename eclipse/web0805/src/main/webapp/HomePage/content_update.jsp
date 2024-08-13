<%@page import="home.Content"%>
<%@page import="home.ContentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
p

request.setCharacterEncoding("UTF-8");

String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");
int num = Integer.parseInt(request.getParameter("num"));
int hits = Integer.parseInt(request.getParameter("hits"));

ContentDAO dao = new ContentDAO();
Content dto = new Content(num,writer,title,content,"0",hits);
dao.getUpdate(dto);

response.sendRedirect("content.jsp"); // 리다이렉트
%>