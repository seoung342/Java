<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/register.css">
    <title>회원 가입</title>
</head>
<body>
    <div class="container">
        <h2>회원 가입</h2>
        <form action="registerProcess.jsp" method="get">
            <label for="id">ID</label>
            <input type="text" id="id" name="id" required>
            <label for="pw">PassWord</label>
            <input type="text" id="pw" name="pw" required>
            <label for="name">이름</label>
            <input type="text" id="name" name="name" required>
            <label for="tel">전화번호</label>
            <input type="text" id="tel" name="tel" required>
            <input type="submit" value="회원가입">
            <input type="reset" value="취소" onclick="history.back()">
        </form>
    </div>
</body>
</html>