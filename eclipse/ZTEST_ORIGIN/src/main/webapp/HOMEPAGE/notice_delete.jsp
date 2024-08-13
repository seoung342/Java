<%@page import="home.Notice"%>
<%@page import="home.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	NoticeDAO dao = new NoticeDAO();
	dao.deleteNotice(num);
	
	response.sendRedirect("notice.jsp"); // 리다이렉트
%>