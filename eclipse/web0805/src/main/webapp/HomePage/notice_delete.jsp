<%@page import="home.Notice"%>
<%@page import="home.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
p

	int num = Integer.parseInt(request.getParameter("num"));

	NoticeDAO dao = new NoticeDAO();
	Notice dto = new Notice(num,"","","","",0);
	dao.getDelete(dto);
	
	response.sendRedirect("notice.jsp"); // 리다이렉트
%>