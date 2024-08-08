<%@page import="home.NoticeDTO"%>
<%@page import="java.util.List"%>
<%@page import="home.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	NoticeDAO dao = new NoticeDAO();
	List<NoticeDTO> list = dao.getNoticeList();

%>

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
    <style>
        
        table {
    width: 100%;
    border-collapse: collapse; /* 테두리 합침 */
    margin: 20px 0; /* 위와 아래 여백 */
    background-color: #fff; /* 배경색 흰색 */
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* 그림자 */
}

th, td {
    padding: 10px; /* 셀 안쪽 여백 */
    text-align: center; /* 중앙 정렬 */
    border-bottom: 1px solid #ddd; /* 하단 테두리 */
}

th {
    background-color: #f4f4f4; /* 헤더 배경색 */
    color: #333; /* 헤더 글자색 */
    font-weight: bold; /* 헤더 글자 두께 */
}

tr:hover {
    background-color: #f9f9f9; /* 마우스 오버 시 배경색 */
}

a {
    color: #007bff; /* 링크 색상 */
    text-decoration: none; /* 링크 밑줄 제거 */
    transition: color 0.3s; /* 색상 변화 애니메이션 */
}

a:hover {
    color: #0056b3; /* 링크 마우스 오버 색상 */
}

input[type="button"] {
    background-color: #007bff; /* 버튼 배경색 */
    color: #fff; /* 버튼 글자색 */
    border: none; /* 버튼 테두리 제거 */
    padding: 10px 20px; /* 버튼 패딩 */
    border-radius: 5px; /* 버튼 둥근 모서리 */
    cursor: pointer; /* 커서 포인터 */
    font-size: 16px; /* 버튼 글자 크기 */
    transition: background-color 0.3s; /* 배경색 변화 애니메이션 */
}

input[type="button"]:hover {
    background-color: #0056b3; /* 버튼 마우스 오버 배경색 */
}
        
        
        
    </style>
</head>
<body>
    <header>
        <div class="inner">
            <h1><a href="main.jsp">Stock Quotes</a></h1>

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
    
        <table>
		    <tr>
		        <th class="num"    >번호    </th>
		        <th class="title"  >제목    </th>
		        <th class="writer" >작성자  </th>
		        <th class="regtime">작성일시</th>
		        <th                >조회수  </th>
		    </tr>
<%
for(NoticeDTO dto : list) {
%>
		    <tr>
		        <td><%=dto.getNum() %></td>
		        <td style="text-align:left;">
		            <a href="notice_view.jsp?num=<%=dto.getNum() %>"><%=dto.getTitle() %></a>
		        </td>
		        <td><%=dto.getWriter() %></td>
		        <td><%=dto.getRegtime() %></td>
		        <td><%=dto.getHits() %></td>
		    </tr>
<%
}
%>
			</table>
			<c:if test="${ id != null && id eq 'root'}">
				<input type="button" value="글쓰기" onclick="location.href='notice_write.jsp'">
			</c:if>
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