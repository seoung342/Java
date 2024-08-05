<%@page import="home.ContentDAO"%>
<%@page import="home.ContentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String id = (String)session.getAttribute("id");
	String pw = (String)session.getAttribute("pw");
	String name = (String)session.getAttribute("name");
	String tel = (String)session.getAttribute("tel");
	
	int num = Integer.parseInt(request.getParameter("num"));
	ContentDAO dao = new ContentDAO();
	ContentDTO dto = dao.getOne(num);
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
        td    { text-align:left; border:1px solid gray; }
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
		    <table>
			    <tr>
			        <th>제목</th>
			        <td><%= dto.getTitle()%></td>
			    </tr>
			    <tr>
			        <th>작성자</th>
			        <td><%=dto.getWriter() %></td>
			    </tr>
			    <tr>
			        <th>작성일시</th>
			        <td><%=dto.getRegtime() %></td>
			    </tr>
			    <tr>
			        <th>조회수</th>
			        <td><%=dto.getHits() %></td>
			    </tr>
			    <tr>
			        <th>내용</th>
			        <td><%=dto.getContent() %></td>
			    </tr>
			</table>
			<br>
			<input type="button" value="이전 페이지" onclick="location.href='content.jsp'">
			<%
			if ( id != null && name.equals(dto.getWriter())){
			%>
			<input type="button" value="수정"
       			onclick="location.href='content_fix.jsp?num=<%=dto.getNum()%>'">
			<input type="button" value="삭제"
      			 onclick="location.href='content_delete.jsp?num=<%=dto.getNum()%>'">
      		<%
      		}else if ( id != null && id.equals("root")){
      		%>
			<input type="button" value="삭제"
      			 onclick="location.href='content_delete.jsp?num=<%=dto.getNum()%>'">
      		<%
      		}
      		%>
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