<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = new MemberDTO(id,pw,name);
	boolean flag = dao.getCheck(id, pw);
	
	if(flag){
		out.println("<script tpye = 'text/javascript'>");
		out.println("alert('이미 있는 회원입니다.')");
		out.println("history.back()");
		out.println("</script>");
	}else{
		dao.insertMember(dto);
		out.println("<script tpye = 'text/javascript'>");
		out.println("alert('가입이 완료됬습니다.')");
		out.println("window.close()");
		out.println("</script>");
	}
	
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
</body>
</html>