<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script><!-- chart.js를 사용하기 위햇서 필요 -->
<%@ include file="/Finance/common/header.jsp" %>
<title>차트</title>
</head>
<body>
	<script src="${pageContext.request.contextPath}/Finance/js/chart.js"></script>
	<div id="finance-data" data-json="<c:out value='${finance}'/>"></div>
	<canvas id="myChart" width="400" height="200"></canvas>
</body>
</html>