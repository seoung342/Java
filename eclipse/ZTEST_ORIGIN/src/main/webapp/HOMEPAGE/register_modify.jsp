<%@page import="java.util.List"%>
<%@page import="home.Account"%>
<%@page import="home.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String delete = request.getParameter("delete");
	if(delete != null){
		AccountDAO dao = new AccountDAO();
		dao.deleteAccount(delete);
	}
	
	AccountDAO dao = new AccountDAO();
	List<Account> list = dao.selectAllAccount();
	
	request.setAttribute("accountList", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 관리</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
<%-- <script src="https://kit.fontawesome.com/c47106c6a7.js" crossorigin="anonymous"></script> --%>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/ie.js"></script>
   <link rel="stylesheet" href="css/register_modify.css">
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
			        <th class="num">번호</th>
			        <th class="id">아이디</th>
			        <th class="pw">비밀번호</th>
			        <th class="name">이름</th>
			        <th class="tel">전화번호</th>
			        <th class="check">삭제</th>
			    </tr>
				<c:forEach var="dto" items="${accountList}">
                    <tr>
                        <td>${dto.num}</td>
                        <td>${dto.id}</td>
                        <td>${dto.pw}</td>
                        <td>${dto.name}</td>
                        <td>${dto.tel}</td>
                        <c:if test="${dto.num != 1}">
                            <td>
                                <button type="button" onclick="location.href='?delete=${dto.num}'">삭제</button>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
			</table>
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