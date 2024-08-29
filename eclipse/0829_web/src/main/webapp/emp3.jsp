<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(URL, "root", "mysql");
} catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace();
}
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button onclick="createPost()">Create</button>
<script>
let arr = null;
let json = null;

<%
String sql = "select json_object('empno',empno,'ename',ename,'job',job,'sal',sal) as json from emp;";
pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
StringBuilder arrayBuilder = new StringBuilder();
arrayBuilder.append("[");
while(rs.next()){
    String json = rs.getString("json");
    arrayBuilder.append(json).append(",");
}
if (arrayBuilder.length() > 1) {
    arrayBuilder.setLength(arrayBuilder.length() - 1); // 마지막 ',' 제거
}
arrayBuilder.append("]");
String array = arrayBuilder.toString();
%>
arr = JSON.parse('<%= array %>');

const apiUrl = "http://localhost:3000/emp";
function createPost() {
    const postParams = arr;
    fetch(apiUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(postParams),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Post created:", data);
      })
      .catch((error) => console.error("Error:", error));
}
</script>
</body>
</html>