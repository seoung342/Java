<%@page import="home.ContentDAO"%>
<%@page import="home.ContentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int num = Integer.parseInt(request.getParameter("num"));

	ContentDAO dao = new ContentDAO();
	ContentDTO dto = new ContentDTO(num,"","","","",0);
	dao.getDelete(dto);
	
	response.sendRedirect("content.jsp"); // 리다이렉트
%>