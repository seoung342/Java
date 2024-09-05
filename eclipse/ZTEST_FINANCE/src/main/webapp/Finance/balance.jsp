<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/Finance/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>분배</title>
<style>
#container {
	margin: 50px;
}

table {
	width: 100%;
	border-collapse: collapse; /* 테두리 합침 */
	margin: 20px 0; /* 위와 아래 여백 */
	background-color: #fff; /* 배경색 흰색 */
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* 그림자 */
}

th, td {
	padding: 10px; /* 셀 안쪽 여백 */
	text-align: left; /* 좌측 정렬 */
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

/* input 요소 스타일 추가 */
input[type="text"] {
	width: 100%; /* 셀 너비에 맞게 입력창 크기 조정 */
	box-sizing: border-box; /* 테두리와 패딩을 포함한 전체 너비 조정 */
	padding: 5px; /* 입력창 안쪽 여백 */
	border: 1px solid #ccc; /* 입력창 테두리 색상 */
	border-radius: 4px; /* 입력창 테두리 둥글게 */
}

/* 버튼 스타일 추가 */
button {
	width: 100%; /* 버튼을 td의 전체 너비로 설정 */
	padding: 10px; /* 버튼 안쪽 여백 */
	background-color: transparent; /* 배경색 제거 */
	color: #000; /* 글자색 검정색 */
	border: none; /* 테두리 제거 */
	border-radius: 4px; /* 버튼 테두리 둥글게 */
	cursor: pointer; /* 마우스 커서 포인터로 변경 */
	font-size: 16px; /* 글자 크기 */
	text-align: center; /* 버튼 텍스트 가운데 정렬 */
	transition: background-color 0.3s ease, color 0.3s ease;
	/* 배경색 및 글자색 변경 시 애니메이션 */
}
</style>
</head>
<body>
	<div id="container">
		<table id="dataTable">
			<thead>
				<tr>
					<th>Ticker</th>
					<th>price</th>
					<th>amount</th>
					<th>total</th>
					<th>Percent</th>
					<th>팔아야되는 개수</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="6" style="text-align: center;">
						<button type="button" id="addRow">추가하기</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<script>
                // 총계에 따라 퍼센트를 계산하는 함수
                function calculatePercent() {
                    var totals = Array.from(document.querySelectorAll('.total')).map(input => parseFloat(input.value) || 0);
                    var totalSum = totals.reduce((acc, total) => acc + total, 0);
        
                    var percentInputs = document.querySelectorAll('.percent');
                    for (var i = 0; i < percentInputs.length; i++) {
                        var total = totals[i];
                        var percent = (totalSum > 0) ? (total / totalSum * 100).toFixed(2) + '%' : '0%';
                        percentInputs[i].value = percent;
                    }
                }
                
                // 가격과 개수를 곱해서 총 가격을 구한다.
                function calculateSum() {
                    var prices = Array.from(document.querySelectorAll('.price')).map(input => parseFloat(input.value) || 0);
                    var amounts = Array.from(document.querySelectorAll('.amount')).map(input => parseFloat(input.value) || 0);
                    
                    var totalInputs = document.querySelectorAll('.total');
                    for (var i = 0; i < totalInputs.length; i++) {
                        var price = prices[i];
                        var amount = amounts[i];
                        var total = price * amount;
                        totalInputs[i].value = total;
                    }
                    
                    calculatePercent(); // 총계가 업데이트된 후 퍼센트 계산 호출
                }
            
                document.getElementById('addRow').addEventListener('click', function() {
                    var tableBody = document.querySelector('#dataTable tbody');
                    var newRow = tableBody.insertRow(tableBody.rows.length - 1); // 버튼 바로 위에 새로운 행 추가
        
                    for (var i = 0; i < 6; i++) {
                        var newCell = newRow.insertCell();
                        var input = document.createElement('input');
                        if (i === 1) {
                            input.type = 'number';
                            input.className = 'price';
                            input.addEventListener('input', calculateSum); // 가격 입력 시 총계 계산
                        } else if (i === 2) {
                            input.type = 'number';
                            input.className = 'amount';
                            input.addEventListener('input', calculateSum); // 개수 입력 시 총계 계산
                        } else if (i === 3) {
                            input.type = 'number';
                            input.className = 'total';
                            input.readOnly = true;
                        } else if (i === 4) {
                            input.type = 'text';
                            input.className = 'percent';
                            input.readOnly = true;
                        } else {
                            input.type = 'text';
                            input.className = 'ticker';
                        }
                        input.style.width = '100%';
                        input.style.boxSizing = 'border-box';
                        input.style.padding = '5px';
                        input.style.border = '1px solid #ccc';
                        input.style.borderRadius = '4px';
                        newCell.appendChild(input);
                    }
                });
    </script>
	</body>
</html>