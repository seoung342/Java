<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath}/HOMEPAGE/css/style.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="${pageContext.request.contextPath}/HOMEPAGE/js/ie.js"></script>
</head>
<body>
	<header>
		<div class="inner">
			<h1>
				<a href="main">Stock Quotes</a>
			</h1>

			<ul id="gnb">
				<li><a href="notice">공지사항</a></li>
				<li><a href="content">게시판</a></li>
				<li><a href="fileStorage">자료실</a></li>
				<li><a href="location">LOCATION</a></li>
				<c:if test="${id != null && id eq 'root'}">
					<li><a href="register_modify">회원 관리</a></li>
					<li><a href="finance">내 주식 상황</a></li>
				</c:if>
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
	<script>
	window.onload = function() {
		
	    // JSP에서 JSON 데이터 가져오기
	    var financeData = `<%= (String) request.getAttribute("finance") %>`;
	    
	    // JSON 데이터 파싱
	    var data = JSON.parse(financeData);

	    var labels = [];
	    var purchaseTotals = [];
	    var nowTotals = [];

	    // 필요한 필드만 추출하기
	    data.forEach(function(item) {
	        // 항목이 필요한 필드를 포함하는지 확인
	        if (item.hiredate && item.purchase_total !== undefined && item.now_total !== undefined) {
	            labels.push(item.hiredate);
	            purchaseTotals.push(item.purchase_total || 0);  // purchase_total이 null이나 undefined일 경우 0 사용
	            nowTotals.push(item.now_total || 0);            // now_total이 null이나 undefined일 경우 0 사용
	        }
	    });

	    // 차트 생성
	    var ctx = document.getElementById('myChart').getContext('2d');
	    new Chart(ctx, {
	        type: 'line', // 라인 차트
	        data: {
	            labels: labels,
	            datasets: [
	                {
	                    label: 'Purchase Total',
	                    data: purchaseTotals,
	                    borderColor: 'rgba(75, 192, 192, 1)',
	                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
	                    borderWidth: 1,
	                    tension: 0.1 // 선 곡률 조정
	                },
	                {
	                    label: 'Now Total',
	                    data: nowTotals,
	                    borderColor: 'rgba(153, 102, 255, 1)',
	                    backgroundColor: 'rgba(153, 102, 255, 0.2)',
	                    borderWidth: 1,
	                    tension: 0.1 // 선 곡률 조정
	                }
	            ]
	        },
	        options: {
	            responsive: true,
	            plugins: {
	                legend: {
	                    display: true,
	                    position: 'top'
	                },
	                tooltip: {
	                    callbacks: {
	                        label: function(tooltipItem) {
	                            return `${tooltipItem.dataset.label}: ${tooltipItem.raw.toFixed(2)}`;
	                        }
	                    }
	                }
	            },
	            scales: {
	                x: {
	                    beginAtZero: true,
	                    title: {
	                        display: true,
	                        text: 'Hire Date'
	                    }
	                },
	                y: {
	                    beginAtZero: false,
	                    title: {
	                        display: true,
	                        text: 'Value'
	                    }
	                }
	            }
	        }
	    });
	};
	</script>
	
	<canvas id="myChart" width="400" height="200"></canvas>
    <br><br><br>
    
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