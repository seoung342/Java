<%@page import="home.Account"%>
<%@page import="home.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String tel = request.getParameter("tel");

AccountDAO dao = new AccountDAO();
Account dto = new Account(0, id, pw, name, tel);
boolean flag = dao.selectAccountCheck(id);

if(flag){
	out.println("<script tpye = 'text/javascript'>");
	out.println("alert('회원가입 실패 아이디 중복')");
	out.println("window.location.href = 'register.jsp';");
	out.println("</script>");
}else{
	dao.insertAccount(dto);
	out.println("<script tpye = 'text/javascript'>");
	out.println("alert('회원가입 성공, 로그인하세요')");
	out.println("window.location.href = 'main.jsp';");
	out.println("</script>");
}
%>