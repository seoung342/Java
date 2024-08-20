<%@page import="service.NoticeService"%>
<%@page import="home.Notice"%>
<%@page import="home.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
<%-- <script src="https://kit.fontawesome.com/c47106c6a7.js" crossorigin="anonymous"></script> --%>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/ie.js"></script>
     <link rel="stylesheet" href="css/table.css">
<link rel="stylesheet" href="css/a.css">
<link rel="stylesheet" href="css/input.css">
</head>
<body>
	<header>
        <div class="inner">
            <h1><a href="main.jsp">Stock Quotes</a></h1>

            <ul id="gnb">
                <li><a href="notice">공지사항</a></li>
                <li><a href="content">게시판</a></li>
                <li><a href="location.jsp">LOCATION</a></li>
            	<c:if test="${id != null && id eq 'root'}">
   					<li><a href="register_modify.jsp">회원 관리</a></li>
				</c:if>
         	</ul>
            <ul class="util">
			    <c:choose>
			        <c:when test="${id != null}">
			            <li><a>${name}</a></li>
			            <li><a href="myinfo.jsp">내 정보</a></li>
			            <li><a href="logout.jsp">로그아웃</a></li>
			        </c:when>
			        <c:otherwise>
			            <li><a href="login.jsp">로그인</a></li>
			            <li><a href="register.jsp">회원가입</a></li>
			        </c:otherwise>
			    </c:choose>
			</ul>
        </div>
    </header>
    <section>
        <div class="inner">
            <table>
                <tr>
                    <th>제목</th>
                    <td>${notice.title }</td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>${notice.writer }</td>
                </tr>
                <tr>
                    <th>작성일시</th>
                    <td>${notice.regtime }</td>
                </tr>
                <tr>
                    <th>조회수</th>
                    <td>${notice.hits }</td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>${notice.content }</td>
                </tr>
            </table>
            <br>
            <input type="button" value="이전 페이지" onclick="location.href='notice'">
            <c:if test="${id != null && name eq notice.writer }">
                <form action="notice" method="post">
                    <input type="hidden" name="action" value="fix">
                    <input type="hidden" name="num" value="${notice.num}">
                    <input type="submit" value="수정">
                </form>
                <form action="notice" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="num" value="${notice.num}">
                    <input type="submit" value="삭제">
                </form>
            </c:if>
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
	                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas, facere.<br>
	                TEL : 031-111-1234 C.P : 010-1234-5678
	            </address>
	            <p>
	                2020 DOCDELAB &copy; copyright all right reserved.
	            </p>
	        </div>
	    </div>
	</footer>


</body>
</html>