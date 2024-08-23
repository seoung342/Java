<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Finance/css/login.css"><!-- 절대 경로 -->
<title>Login Page</title>
</head>
<body>
	<div class="login-container">
		<h2>Login</h2>
		<form method="post" action="login" >
			<input type="hidden" name="action" value="login">
			<input type="text" name="id" placeholder="ID" required> <input
				type="password" name="pw" placeholder="Password" required>
			<button type="submit">Login</button>
		</form>
	</div>
</body>
</html>