<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 정보들 보기</title>
</head>
<body>
<%
Cookie[] cookies = request.getCookies();
if(cookies != null && cookies.length > 0 ){
	for(int i = 0; i<cookies.length; i++){
		out.println(cookies[i].getName() + " : " + cookies[i].getValue());
	}
}
%>
</body>
</html>