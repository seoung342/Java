<%@page import="board.AccountDTO"%>
<%@page import="java.util.List"%>
<%@page import="board.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Process</title>
</head>
<body>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	AccountDAO dao = new AccountDAO();
	boolean flag = dao.getCheck(username, password);
	
	if (flag) {
       out.println("<h2>Login 성공! Welcome, " + username + ".</h2>");
       // 로그인 성공, 쿠키 설정
       Cookie loginCookie = new Cookie("username", username);
       loginCookie.setMaxAge(60 * 60); // 1시간
       response.addCookie(loginCookie);
       out.println("<script tpye = 'text/javascript'>");
       out.println("alert('환영합니다, " + username + "!')");
       out.println("window.location.href = 'index.jsp';");
       out.println("</script>");
    } else {
   	out.println("<script tpye = 'text/javascript'>");
       out.println("alert('로그인 실패')");
       out.println("window.location.href = 'index.jsp';");
       out.println("</script>");
    }

%>
</body>
</html>