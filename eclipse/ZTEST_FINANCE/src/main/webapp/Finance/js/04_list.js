$(document).ready(function() {
	$(".div_list").click(function() {
		var hiredate = $(this).data("hiredate");
		var resultId = "result-content-" + hiredate;
		console.log(hiredate);
		$.ajax({
			url: "/ZTEST_FINANCE/list",
			type: "POST",
			data: {
				action: "listByHiredate",
				hiredate: hiredate
			},
			success: function(response) {
				// 응답이 JSON 문자열이라고 가정합니다
				var jsonResponse = JSON.parse(response);

				// JSON 데이터를 HTML 테이블로 변환합니다
				var html = '<table><thead><tr>';

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

				html += '</tbody></table>';

				// 특정 div에 결과 HTML을 삽입합니다
				$("#" + resultId).html(html);
				console.log(jsonResponse);
			},
			error: function(xhr, status, error) {
				console.error("AJAX 요청 실패: " + status + ", " + error);
			}
		});

	});
});