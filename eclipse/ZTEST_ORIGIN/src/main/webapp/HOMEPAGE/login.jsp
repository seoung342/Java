<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login.css">
<title>Login Page</title>
</head>
<body>
	<div class="login-container">
		<h2>Login</h2>
		<form action="loginProcess.jsp" method="get">
			<input type="text" name="id" placeholder="ID" required> <input
				type="password" name="pw" placeholder="Password" required>
			<button type="submit">Login</button>
		</form>
	</div>
</body>
</html>