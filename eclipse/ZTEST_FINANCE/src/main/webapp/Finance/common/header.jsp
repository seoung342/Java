<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 절대 경로 사용하기 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/Finance/css/header.css">
<header>
	<div class="inner">
		<h1>
			<a href="main">Finance</a>
		</h1>

		<ul id="gnb">
			<li><a href="list">목록</a>
				<ul class="submenu">
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
				</ul></li>
			<li><a href="finance_chart">차트</a>
				<ul class="submenu">
					<li>1</li>
					<li>2</li>
					<li>3</li>
				</ul></li>
			<li><a href="#">3</a>
			<ul class="submenu">
					<li>1</li>
					<li>2</li>
					<li>3</li>
				</ul></li>
			<li><a href="#">유용한 툴</a>
			<ul class="submenu">
					<li><a href="ratio">ratio</a></li>
					<li><a href="balance">balance</a></li>
					<li><a href="day_money">day_money</a></li>
				</ul></li>
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