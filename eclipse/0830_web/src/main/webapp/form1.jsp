<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="empJsonserver1.jsp">
	empno : <input type="text" name="empno"><br>
	ename : <input type="text" name="ename"><br>
	job : <input type="text" name="job"><br>
	mgr : <input type="text" name="mgr"><br>
	hiredate : <input type="text" name="hiredate"><br>
	sal : <input type="text" name="sal"><br>
	comm : <input type="text" name="comm"><br>
	deptno : <input type="text" name="deptno"><br>
	<button type="submit" name="action" value="create">생성</button>
	<button type="submit" name="action" value="read">보기</button>
	<button type="submit" name="action" value="update">수정</button>
	<button type="submit" name="action" value="delete">삭제</button>
</form>
</body>
</html>