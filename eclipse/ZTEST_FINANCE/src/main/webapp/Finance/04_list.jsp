<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/Finance/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet"
	href="${pageContext.request.contextPath}/Finance/css/04_list" />-->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>목록</title>
<style>
body .div_list {
	padding: 100px;
	border: 1px solid red;
}
</style>
</head>
<body>
	<c:forEach var="item" items="${list}">
		<div class="div_list" data-hiredate="${item.hiredate}">
		<label class = "label_hiredate" data-hiredate="${item.hiredate}">${item.hiredate }</label>
			<div class="result-content" id="result-content-${item.hiredate}"></div>
		</div>
	</c:forEach>
	<script>
		$(document).ready(function() {
			$(".label_hiredate").click(function() {
				var hiredate = $(this).data("hiredate");
				var resultId = "result-content-" + hiredate;
				var html = "";
				console.log(hiredate);
				$.ajax({
					url : "/ZTEST_FINANCE/list",
					type : "POST",
					data : {
						action : "listByHiredate",
						hiredate : hiredate
					},
					success: function(response) {
					// 응답이 JSON 문자열이라고 가정합니다
	                var jsonResponse = JSON.parse(response);

	                // JSON 데이터를 HTML 테이블로 변환합니다
	                html = '<table><thead><tr>';
	                
	                // 테이블 헤더를 추가합니다
	                Object.keys(jsonResponse[0]).forEach(function(key) {
	                    html += '<th>' + key.charAt(0).toUpperCase() + key.slice(1) + '</th>';
	                });
	                
	                html += '</tr></thead><tbody>';
	                
	                // 테이블 행을 추가합니다
	                jsonResponse.forEach(function(item) {
	                    html += '<tr>';
	                    Object.values(item).forEach(function(value) {
	                        html += '<td>' + value + '</td>';
	                    });
	                    html += '</tr>';
	                });
	                
	                html += '</tbody></table><button id="close">123</button>';
	                
	                // 특정 div에 결과 HTML을 삽입합니다
	                $("#" + resultId).html(html);
	                console.log(jsonResponse);
	            	},
					error : function(xhr, status, error) {
						console.error("AJAX 요청 실패: " + status + ", " + error);
					}
					});
				
				});
			// 이벤트 위임을 사용하여 동적으로 생성된 #close 버튼에 대한 클릭 이벤트를 처리합니다.
		    $(document).on("click", "#close", function() {
		        console.log("hello");
		    });
		});
	</script>
</body>
</html>