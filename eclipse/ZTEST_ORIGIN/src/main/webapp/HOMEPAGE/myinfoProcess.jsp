<%@page import="home.Account"%>
<%@page import="home.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String tel = request.getParameter("tel");

AccountDAO dao = new AccountDAO();
Account dto = new Account(0, id, pw, name, tel);
dao.updateAccount(dto);

if(String.valueOf(dto.getId()) != null){
	session.setAttribute("num", dto.getNum());
	session.setAttribute("id", id);
    session.setAttribute("pw", pw);
    session.setAttribute("name", dto.getName());
    session.setAttribute("tel", dto.getTel());
	out.println("<script tpye = 'text/javascript'>");
	out.println("alert('내 정보를 수정했습니다.')");
	out.println("window.location.href = 'main.jsp';");
	out.println("</script>");
}else{
	out.println("<script tpye = 'text/javascript'>");
	out.println("alert('내 정보 수정을 실패했습니다.')");
	out.println("window.location.href = 'myinfo.jsp';");
	out.println("</script>");
}
%>