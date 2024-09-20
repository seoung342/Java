<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Finance/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>지불 금액 계산</title>
    <style>
        #container {
            margin: 50px auto; /* 중앙 정렬 */
            max-width: 800px; /* 최대 너비 설정 */
            border-radius: 8px; /* 모서리 둥글게 */
            padding: 20px; /* 안쪽 여백 */
        }

        table {
            width: 100%;
            border-collapse: collapse; /* 테두리 합침 */
            margin: 0; /* 마진 제거 */
        }

        th,
        td {
            padding: 12px; /* 셀 안쪽 여백 */
            text-align: center; /* 중앙 정렬 */
            border-bottom: 1px solid #ddd; /* 하단 테두리 */
        }

        th {
            background-color: #f8f9fa; /* 헤더 배경색 */
            color: #333; /* 헤더 글자색 */
            font-weight: bold; /* 헤더 글자 두께 */
        }

        tr:hover {
            background-color: #f1f1f1; /* 마우스 오버 시 배경색 */
        }

        input[type="date"] {
            width: 100%;
            box-sizing: border-box;
            padding: 10px; /* 입력창 안쪽 여백 */
            border: 1px solid #ced4da; /* 입력창 테두리 색상 */
            border-radius: 4px; /* 입력창 테두리 둥글게 */
            background-color: #fff; /* 입력창 배경색 흰색 */
            font-size: 16px; /* 폰트 크기 */
        }

        #duration {
            font-weight: bold;
            color: #007bff; /* 강조 색상 */
        }
    </style>
</head>
<body>
    <div id="container">
        <table>
            <thead>
                <tr>
                    <th>시작 날짜</th>
                    <th>종료 날짜</th>
                    <th>기간</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input id="start" type="date" name="start" /></td>
                    <td><input id="end" type="date" name="end" /></td>
                    <td id="duration">기간이 표시됩니다.</td>
                </tr>
            </tbody>
        </table>
    </div>
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            const startInput = document.getElementById("start");
            const endInput = document.getElementById("end");
            const durationCell = document.getElementById("duration");

            function updateDates() {
                const startDate = startInput.value;
                const endDate = endInput.value;

                console.log("시작 날짜:", startDate);
                console.log("종료 날짜:", endDate);

                if (startDate && endDate) {
                    const start = new Date(startDate);
                    const end = new Date(endDate);
                    if (end < start) {
                        durationCell.textContent = "종료 날짜가 시작 날짜보다 이전입니다.";
                        return;
                    }
                    const duration = Math.floor((end - start) / (1000 * 60 * 60 * 24)) + 1; // 기간을 일수로 계산
                    console.log(duration);
                    durationCell.textContent = `${duration} 일`;
                } else {
                    durationCell.textContent = "기간이 표시됩니다.";
                }
            }

            startInput.addEventListener("change", updateDates);
            endInput.addEventListener("change", updateDates);
        });
    </script>
</body>
</html>