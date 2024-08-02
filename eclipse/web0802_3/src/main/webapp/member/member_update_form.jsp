<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String id = (String)session.getAttribute("userId");
	String pw = (String)session.getAttribute("userPw");
	String name = (String)session.getAttribute("userName");
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getMemberOne(id, pw);
	
	
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
</head>
<body>
    <form action="member_update.jsp" method="post">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type="text" name="id" readonly
                           value="<%=dto.getId()%>"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="pw" 
                           value="<%=dto.getPw()%>"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="name" 
                           value="<%=dto.getName()%>"></td>
            </tr>
        </table>    
        <input type="submit" value="저장"> 
    </form>
</body>
</html>