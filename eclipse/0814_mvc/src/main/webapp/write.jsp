<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
    input[type="text"], textarea {
        width: 100%;
        box-sizing: border-box; /* Padding과 border를 포함하여 전체 너비를 조정합니다. */
    }
</style>
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<div class="container" style="padding-top: 50; margin-top:40px;">
		<form method="post" action="${action}">
			<table class="table table-bordered">
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" maxlength="255"
						value="${msg.title}"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer" maxlength="255"
						value="${msg.writer}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" rows="10">${msg.content}</textarea>
					</td>
				</tr>
			</table>

			<br> <input type="submit" value="저장"> <input
				type="button" value="취소" onclick="history.back()">
		</form>
	</div>
</body>
</html>