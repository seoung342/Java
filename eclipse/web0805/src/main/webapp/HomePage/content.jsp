<%@page import="home.ContentDTO"%>
<%@page import="java.util.List"%>
<%@page import="home.ContentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String id = (String)session.getAttribute("id");
	String pw = (String)session.getAttribute("pw");
	String name = (String)session.getAttribute("name");
	String tel = (String)session.getAttribute("tel");
	
	ContentDAO dao = new ContentDAO();
	List<ContentDTO> list = dao.getContentList();

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
        table     { width:680px; text-align:center; }
        th        { background-color:cyan; }
        
        .num      { width: 80px; }
        .title    { width:230px; }
        .writer   { width:100px; }
        .regtime  { width:180px; }
                
        a:link    { text-decoration:none; color:blue; }
        a:visited { text-decoration:none; color:gray; }
        a:hover   { text-decoration:none; color:red;  }
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
		        <th class="num"    >번호    </th>
		        <th class="title"  >제목    </th>
		        <th class="writer" >작성자  </th>
		        <th class="regtime">작성일시</th>
		        <th                >조회수  </th>
		    </tr>
<%
for(ContentDTO dto : list) {
%>
		    <tr>
		        <td><%=dto.getNum() %></td>
		        <td style="text-align:left;">
		            <a href="content_view.jsp?num=<%=dto.getNum() %>"><%=dto.getTitle() %></a>
		        </td>
		        <td><%=dto.getWriter() %></td>
		        <td><%=dto.getRegtime() %></td>
		        <td><%=dto.getHits() %></td>
		    </tr>
<%
}
%>
			</table>
			<%
				if( id != null){
			%>
			<input type="button" value="글쓰기" onclick="location.href='content_write.jsp'">
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