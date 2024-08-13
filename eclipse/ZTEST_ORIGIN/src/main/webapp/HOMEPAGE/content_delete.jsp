<%@page import="home.ContentDAO"%>
<%@page import="home.Content"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));

	ContentDAO dao = new ContentDAO();
	dao.deleteContent(num);
	
	response.sendRedirect("content.jsp"); // 리다이렉트
%>