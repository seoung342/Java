<%@page import="home.AccountDTO"%>
<%@page import="home.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Process</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	AccountDAO dao = new AccountDAO();
	AccountDTO dto = dao.getAccountOne(id, pw);
	boolean flag = dao.getCheck(id, pw);
	
	if (flag) {
		session.setAttribute("num", dto.getNum());
		session.setAttribute("id", id);
	    session.setAttribute("pw", pw);
	    session.setAttribute("name", dto.getName());
	    session.setAttribute("tel", dto.getTel());
	    
        out.println("<script tpye = 'text/javascript'>");
        out.println("alert('환영합니다, " + dto.getName() + "!')");
        out.println("window.location.href = 'main.jsp';");
        out.println("</script>");
    } else {
		out.println("<script tpye = 'text/javascript'>");
        out.println("alert('로그인 실패')");
        out.println("window.location.href = 'login.jsp';");
        out.println("</script>");
    }
%>
</body>
</html>