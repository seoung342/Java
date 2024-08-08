<%@page import="java.util.List"%>
<%@page import="dept.DeptDTO"%>
<%@page import="dept.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DeptDAO dao = new DeptDAO();
	List<DeptDTO> list = dao.getDeptList();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
for( DeptDTO dto : list){
%>
<h2><%=dto %></h2>
<%
}
%>
</body>
</html>