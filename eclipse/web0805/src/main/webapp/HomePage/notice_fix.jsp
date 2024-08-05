<%@page import="home.NoticeDTO"%>
<%@page import="home.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
	String pw = (String)session.getAttribute("pw");
	String name = (String)session.getAttribute("name");
	String tel = (String)session.getAttribute("tel");
	
	int num = Integer.parseInt(request.getParameter("num"));
	NoticeDAO dao = new NoticeDAO();
	NoticeDTO dto = dao.getOne(num);
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
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        input[type=text], textarea { width:100%; }
        label {
        	display: block;
            margin-bottom: 5px;
            text-align:left;}textarea { width:100%;}
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
            <%
            if ( id != null && id.equals("root")){
            %>
            	<li><a href="register_modify.jsp">회원 관리</a></li>
            <%
            }
            %>
            </ul>

            <ul class="util">
            <%
            if ( id != null){
            %>
            	<li><a><%=name %></a></li>
            	<li><a href="myinfo.jsp">내 정보</a>
            	<li><a href="logout.jsp">로그아웃</a></li>
            <%
            }else{
            %>
                <li><a href="login.jsp">로그인</a></li>
                <li><a href="register.jsp">회원가입</a></li>
            <%
            }
            %>
            </ul>
        </div>
    </header>
     <section>
        <div class="inner">
	<form method="post" action="notice_update.jsp">
		<input type="hidden" name="num" value="<%=dto.getNum()%>">
		<input type="hidden" name="hits" value="<%=dto.getHits() %>">
		<input type="hidden" name="writer" value="<%=dto.getWriter()%>">
	    <table>
	        <tr>
	            <th>제목</th>
	            <td><input type="text" name="title"  maxlength="80"
	                       value="<%=dto.getTitle()%>">
	            </td>
	        </tr>
	        <tr>
	            <th>작성자</th>
	            <td><label><%=dto.getWriter()%></label>
	            </td>
	        </tr>
	        <tr>
	            <th>내용</th>
	            <td><textarea name="content" rows="10"><%=dto.getContent() %></textarea>
	            </td>
	        </tr>
	    </table>
	
	    <br>
	    <input type="submit" value="저장">
	    <input type="button" value="취소" onclick="history.back()">
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