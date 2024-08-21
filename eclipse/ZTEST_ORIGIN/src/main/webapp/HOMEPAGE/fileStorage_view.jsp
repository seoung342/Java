<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실</title>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="/ZTEST_ORIGIN/HOMEPAGE/css/style.css">
<script src="js/ie.js"></script>
</head>
<body>
	<header>
		<div class="inner">
			<h1>
				<a href="main">Stock Quotes</a>
			</h1>
			<ul id="gnb">
				<li><a href="notice">공지사항</a></li>
				<li><a href="content">게시판</a></li>
				<li><a href="fileStorage">자료실</a></li>
				<li><a href="location">LOCATION</a></li>
				<c:if test="${id != null && id eq 'root'}">
					<li><a href="register_modify">회원 관리</a></li>
				</c:if>
			</ul>
			<ul class="util">
				<c:choose>
					<c:when test="${id != null}">
						<li><a>${name}</a></li>
						<li><a href="myinfo">내 정보</a></li>
						<li><a href="logout">로그아웃</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="login">로그인</a></li>
						<li><a href="register">회원가입</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</header>
	<table>
		<tr>
			<th>제목</th>
			<td>${fileStorage.title}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${fileStorage.writer}</td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td>${fileStorage.ftime}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${fileStorage.hits}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${fileStorage.content}</td>
		</tr>
		<tr>
			<th>파일</th>
			<td>
				<a href="/ZTEST_ORIGIN/HOMEPAGE/fileStorage/${fileStorage.fname}">${fileStorage.fname}</a>
			</td>
		</tr>
	</table>
	<br>
	<input type="button" value="이전 페이지" onclick="location.href='fileStorage'">
	<c:choose>
		<c:when test="${id != null && name eq fileStorage.writer}">
			<form action="fileStorage" method="post">
				<input type="hidden" name="action" value="fileStorage_fix">
				<input type="hidden" name="num" value="${fileStorage.num}">
				<input type="submit" value="수정">
			</form>
			<form action="fileStorage" method="post">
				<input type="hidden" name="action" value="fileStorage_delete">
				<input type="hidden" name="num" value="${fileStorage.num}">
				<input type="submit" value="삭제">
			</form>
		</c:when>
		<c:when test="${id != null && id eq 'root'}">
			<form action="fileStorage" method="post">
				<input type="hidden" name="action" value="fileStorage_delete">
				<input type="hidden" name="num" value="${fileStorage.num}">
				<input type="submit" value="삭제">
			</form>
		</c:when>
	</c:choose>
	<footer>
		<div class="inner">
			<div class="upper">
				<h1>DCODELAB</h1>
				<ul>
					<li><a href="#">Policy</a></li>
					<li><a href="#">Terms</a></li>
					<li><a href="#">Family Site</a></li>
					<li><a href="#">Sitemap</a></li>
				</ul>
			</div>
			<div class="lower">
				<address>
					Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas,
					facere.<br> TEL : 031-111-1234 C.P : 010-1234-5678
				</address>
				<p>2020 DOCDELAB &copy; copyright all right reserved.</p>
			</div>
		</div>
	</footer>


</body>
</html>