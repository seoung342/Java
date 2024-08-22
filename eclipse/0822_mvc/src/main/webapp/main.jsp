<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>홈페이지</title>
	<link rel="icon" href="favicon.ico" type="image/x-icon">
	<%-- <script src="https://kit.fontawesome.com/c47106c6a7.js" crossorigin="anonymous"></script> --%>
	<link rel="stylesheet" href="css/style.css">
	<script src="js/ie.js"></script>
</head>
<body>
	<header>
		<div class="inner">
			<h1>
				<a href="main.jsp">Stock Quotes</a>
			</h1>
			<ul id="gnb">
				<li><a href="notice.jsp">공지사항</a></li>
				<li><a href="content.jsp">게시판</a></li>
				<li><a href="location.jsp">LOCATION</a></li>
				<c:if test="${id != null && id eq 'root'}">
					<li><a href="register_modify.jsp">회원 관리</a></li>
				</c:if>
			</ul>
			<ul class="util">
				<c:choose>
					<c:when test="${userLoggedIn}">
						<li><a>${customInfo.name }님</a></li>
						<li><a href="myinfo.jsp">내 정보</a></li>
						<li><a href="logout.jsp">로그아웃</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="loginForm">로그인</a></li>
						<li><a href="register.jsp">회원가입</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</header>
	<figure>
		<video src="img/visual.mp4" autoplay muted loop></video>
		<div class="inner">
			<h1>A Stock Quotes</h1>
			<p>
				Stock Wise Sayings Of Those Who Succeed With Stock<br> Let's
				continue to work hard today and tomorrow
			</p>
			<a href="#">view detail</a>
		</div>
	</figure>
	<section>
		<div class="inner">
			<h1>RECENT NEWS</h1>
			<div class="wrap">
				<article>
					<div class="pic">
						<img src="img/sellbuy.jpg" alt="1ë²ì§¸ ì½íì¸  ì´ë¯¸ì§">
					</div>
					<h2>
						<a href="#"> stay in the market, not to get out</a>
					</h2>
					<p>when the sentiment changes, it happens so quickly by the
						time you get bak into themarket, you've already missed out</p>
				</article>

				<article>
					<div class="pic">
						<img src="img/news2.jpg" alt="2ë²ì§¸ ì½íì¸  ì´ë¯¸ì§">
					</div>
					<h2>
						<a href="#">Mike Murdock</a>
					</h2>
					<p>The secret of your future is hidden in your daily routine</p>
				</article>

				<article>
					<div class="pic">
						<img src="img/Chales.jpg" alt="3ë²ì§¸ ì½íì¸  ì´ë¯¸ì§">
					</div>
					<h2>
						<a href="#">Chales Fulton Oursler</a>
					</h2>
					<p>Many of us crucify ourselves between two thieves - regret
						for the past and fear of the future.</p>
				</article>

				<article>
					<div class="pic">
						<img src="img/AlbertEinstein.jpg"
							alt="4ë²ì§¸ ì½íì¸  ì´ë¯¸ì§">
					</div>
					<h2>
						<a href="#">Albert Einstein</a>
					</h2>
					<p>Learn from yesterday, live for today, hope for tomorrow.</p>
				</article>
			</div>
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