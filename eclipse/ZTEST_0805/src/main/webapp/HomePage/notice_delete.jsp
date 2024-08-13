<%@page import="home.NoticeDTO"%>
<%@page import="home.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int num = Integer.parseInt(request.getParameter("num"));

	NoticeDAO dao = new NoticeDAO();
	NoticeDTO dto = new NoticeDTO(num,"","","","",0);
	dao.getDelete(dto);
	
	response.sendRedirect("notice.jsp"); // 리다이렉트
%>