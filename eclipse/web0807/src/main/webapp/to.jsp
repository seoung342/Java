<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>To.jsp 페이지</h1>
<c:forEach var="i" begin="1" end="9">
<li>
 ${kk } X ${i } = ${kk*i }
</li>
</c:forEach>
</body>
</html>