<%@page import="home.ContentDAO"%>
<%@page import="home.Content"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<%-- <script src="https://kit.fontawesome.com/c47106c6a7.js" crossorigin="anonymous"></script> --%>
<link rel="stylesheet" href="/ZTEST_ORIGIN/HOMEPAGE/css/style.css">
<link rel="stylesheet" href="/ZTEST_ORIGIN/HOMEPAGE/css/table.css">
<link rel="stylesheet" href="/ZTEST_ORIGIN/HOMEPAGE/css/a.css">
<link rel="stylesheet" href="/ZTEST_ORIGIN/HOMEPAGE/css/input.css">
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
	<section>
		<div class="inner">
			<form method="post" action="content">
				<input type="hidden" name="num" value="${content.num }"> 
				<input type="hidden" name="hits" value="${content.hits }"> 
				<input type="hidden" name="writer" value="${content.writer }">
				<input type="hidden" name="writer" value="${content.user_id }">
				<input type="hidden" name="action" value="content_update">
				<table>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" maxlength="255"
							value="${content.title }"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td class="author-label"><label>${content.writer }</label></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="content" rows="10">${content.content }</textarea>
						</td>
					</tr>
				</table>

				<br> <input type="submit" value="저장"> <input
					type="button" value="취소" onclick="history.back()">
			</form>
		</div>
	</section>
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