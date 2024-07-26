<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배경색깔 바꾸기</title>
</head>
<body>
<h1>If-else Example</h1>
<form action="colorResult.jsp" method = "post">
이름 : <input name = "name"><br>
좋아하는 색깔 : <select name = "color">
			<option value ="blue">파란색</option>
			<option value ="red">빨간색</option> 
			<option value ="yellow">노란색</option>
			</select><br>
<input type="submit" value ="보내기">
</form>
</body>
</html>