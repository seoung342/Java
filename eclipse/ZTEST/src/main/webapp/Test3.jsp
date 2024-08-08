<%@page import="java.time.LocalDateTime"%>
<%@page import="home.NoticeDTO"%>
<%@page import="home.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	LocalDateTime now = LocalDateTime.now();

	NoticeDAO dao = new NoticeDAO();
	NoticeDTO dto = new NoticeDTO("관리자","글1","내용1",now,"0");
	dao.insertNotice(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Test</title>
</head>
<body>
성공 했습니다.
</body>
</html>

