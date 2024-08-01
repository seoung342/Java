<%@page import="board.AccountDTO"%>
<%@page import="board.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Process</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");

String name = request.getParameter("name");
String ssn = request.getParameter("ssn");
String tel = request.getParameter("tel");

AccountDAO dao = new AccountDAO();
AccountDTO dto = new AccountDTO(0, name, ssn, tel, 0);
dao.insertAccount(dto);

System.out.println(String.valueOf(dto.getId()));
if(String.valueOf(dto.getId()) != null){
	out.println("<script tpye = 'text/javascript'>");
	out.println("alert('회원가입 성공, 로그인하세요')");
	out.println("window.location.href = 'index.jsp';");
	out.println("</script>");
}else{
	out.println("<script tpye = 'text/javascript'>");
	out.println("alert('회원가입 실패')");
	out.println("window.location.href = 'index.jsp';");
	out.println("</script>");
}
%>

</body>
</html>