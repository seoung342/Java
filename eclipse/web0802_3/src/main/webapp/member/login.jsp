<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>   

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getMemberOne(id, pw);
	
	boolean flag = dao.getCheck(id, pw);
	if(flag){
		session.setAttribute("userId", id);
	    session.setAttribute("userPw", pw);
	    session.setAttribute("userName", dto.getName());
	    response.sendRedirect("login_main.jsp");
	}
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<script>
    alert('아이디 또는 비밀번호가 틀립니다!');
    history.back();
</script>
 
</body>
</html>
