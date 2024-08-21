<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/ZTEST_ORIGIN/HOMEPAGE/css/myinfo.css">
    <title>정보 수정</title>
</head>
<body>
    <div class="container">
        <h2>내 정보 수정</h2>
        <form action="myinfo" method="post">
        	<input type="hidden" name="action" value="myinfoProcess">
            <label for="id">ID</label>
            <input type="text" id="id" name="id" value = "${id }" required>
            <label for="pw">PassWord</label>
            <input type="text" id="pw" name="pw" value = "${pw }" required>
            <label for="name">이름</label>
            <input type="text" id="name" name="name" value = "${name }" required>
            <label for="tel">전화번호</label>
            <input type="text" id="tel" name="tel" value = "${tel }" required>
            <input type="submit" value="정보 수정">
            <input type="reset" value="취소" onclick="history.back()">
        </form>
    </div>
</body>
</html>