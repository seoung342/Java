<%@page import="dept.DeptDTO"%>
<%@page import="java.util.List"%>
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
<title>List 불러오기 시험</title>
</head>
<body>
<table border="1">
	<tr><td colspan="5" align="center">dept 정보</td></tr>
<%
for (DeptDTO dto : list){
%>
	<tr><td><%=dto%></td></tr>
<%
	}
%>
</table>
</body>
</html>