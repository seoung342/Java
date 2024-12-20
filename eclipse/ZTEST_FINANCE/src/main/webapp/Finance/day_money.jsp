<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Finance/common/header.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>날짜 계산</title>
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
        margin: 20px 0; /* 위와 아래 여백 */
        background-color: #fff; /* 배경색 흰색 */
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* 그림자 */
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

      input[type="date"],
      input[type="number"] {
        width: 100%;
        box-sizing: border-box;
        padding: 10px; /* 입력창 안쪽 여백 */
        border: 1px solid #ced4da; /* 입력창 테두리 색상 */
        border-radius: 4px; /* 입력창 테두리 둥글게 */
        background-color: #fff; /* 입력창 배경색 흰색 */
        font-size: 16px; /* 폰트 크기 */
      }
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

      #duration,
      #day_money,
      #fix_date {
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
            <td><input id="start_date" type="date" name="start" /></td>
            <td><input id="end_date" type="date" name="end" /></td>
            <td id="duration">기간이 표시됩니다.</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div id="container">
      <table>
        <thead>
          <tr>
            <th>금액</th>
            <th>기간</th>
            <th>하루 금액</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><input id="money" type="number" name="money" /></td>
            <td id="fix_date">날짜를 입력하세요.</td>
            <td id="day_money">날짜와 금액을 입력하세요.</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div id="container">
      <table id="dataTable">
        <thead>
          <tr>
            <th>Ticker</th>
            <th>Price</th>
            <th>Amount</th>
            <th>Total</th>
            <th>Now_ratio</th>
            <!-- 맞춰야 하는 비율 -->
            <th>Tar_ratio</th>
            <!-- 기간동안 넣을 하루 금액 -->
            <th>Daily_money</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td colspan="7" style="text-align: center">
              <button type="button" id="addRow">추가하기</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <script>
      // 날짜 사이 기간, 하루 금액 구하는 방법
      document.addEventListener("DOMContentLoaded", function () {
        const startInput = document.getElementById("start_date");
        const endInput = document.getElementById("end_date");
        const moneyInput = document.getElementById("money");
        const durationCell = document.getElementById("duration");
        const fixDateCell = document.getElementById("fix_date");
        const dayMoneyCell = document.getElementById("day_money");

        let totalDays = 0;

        function updateDates() {
          const startDate = startInput.value;
          const endDate = endInput.value;
          totalDays = 0; // Reset totalDays for new calculations

          console.log("시작 날짜:", startDate);
          console.log("종료 날짜:", endDate);

          if (startDate && endDate) {
            const start = new Date(startDate);
            const end = new Date(endDate);
            if (end < start) {
              durationCell.textContent =
                "종료 날짜가 시작 날짜보다 이전입니다.";
              return;
            }

            for (
              let d = new Date(start);
              d <= end;
              d.setDate(d.getDate() + 1)
            ) {
              // 요일을 확인 (0: 일요일, 6: 토요일)
              if (d.getDay() !== 0 && d.getDay() !== 6) {
                totalDays++;
              }
            }
            durationCell.textContent = String(totalDays) + " 일";
            fixDateCell.textContent = String(totalDays) + " 일";
            updateMoney(); // 금액 계산 업데이트
          } else {
            durationCell.textContent = "기간이 표시됩니다.";
            fixDateCell.textContent = "날짜를 입력하세요.";
            dayMoneyCell.textContent = "날짜와 금액을 입력하세요.";
          }
        }

        function updateMoney() {
          const money = parseFloat(moneyInput.value);
          if (!isNaN(money) && totalDays > 0) {
            const resultMoney = (money / totalDays).toFixed(2);
            dayMoneyCell.textContent = "$" + resultMoney; // 하루 금액 표시
          } else {
            dayMoneyCell.textContent = "날짜와 금액을 입력하세요.";
          }
        }

        startInput.addEventListener("change", updateDates);
        endInput.addEventListener("change", updateDates);
        moneyInput.addEventListener("input", updateMoney);
      });
      // 총계에 따라 퍼센트를 계산하는 함수
      function calculatePercent() {
        var totals = Array.from(document.querySelectorAll(".total")).map(
          (input) => parseFloat(input.value) || 0
        );
        var totalSum = totals.reduce((acc, total) => acc + total, 0);

        var percentInputs = document.querySelectorAll(".now_ratio");
        for (var i = 0; i < percentInputs.length; i++) {
          var total = totals[i];
          var percent =
            totalSum > 0 ? ((total / totalSum) * 100).toFixed(2) + "%" : "0%";
          percentInputs[i].value = percent;
        }
      }

      // 가격과 개수를 곱해서 총 가격을 구한다.
      function calculateSum() {
        var prices = Array.from(document.querySelectorAll(".price")).map(
          (input) => parseFloat(input.value) || 0
        );
        var amounts = Array.from(document.querySelectorAll(".amount")).map(
          (input) => parseFloat(input.value) || 0
        );

        var totalInputs = document.querySelectorAll(".total");
        for (var i = 0; i < totalInputs.length; i++) {
          var price = prices[i];
          var amount = amounts[i];
          var total = price * amount;
          totalInputs[i].value = total;
        }

        calculatePercent(); // 총계가 업데이트된 후 퍼센트 계산 호출
        dailyMoney(); // 추가된 부분: daily_money 계산 호출
      }

      // 버튼을 눌러서 새로운 행을 추가
      document.getElementById("addRow").addEventListener("click", function () {
        var tableBody = document.querySelector("#dataTable tbody");
        var newRow = tableBody.insertRow(tableBody.rows.length - 1); // 버튼 바로 위에 새로운 행 추가

        for (var i = 0; i < 7; i++) {
          var newCell = newRow.insertCell();
          var input = document.createElement("input");
          input.style.width = "100%";
          input.style.boxSizing = "border-box";
          input.style.padding = "5px";
          input.style.border = "1px solid #ccc";
          input.style.borderRadius = "4px";

          if (i === 1) {
            input.type = "number";
            input.className = "price";
            input.addEventListener("input", function () {
              calculateSum();
              dailyMoney(); // 가격 입력 시 daily_money 업데이트
            }); // 가격 입력 시 총계 계산
          } else if (i === 2) {
            input.type = "number";
            input.className = "amount";
            input.addEventListener("input", function () {
              calculateSum();
              dailyMoney(); // 개수 입력 시 daily_money 업데이트
            }); // 개수 입력 시 총계 계산
          } else if (i === 3) {
            input.type = "number";
            input.className = "total";
            input.readOnly = true;
          } else if (i === 4) {
            input.type = "text";
            input.className = "now_ratio";
            input.readOnly = true;
          } else if (i === 5) {
            input.type = "text";
            input.className = "tar_ratio";
            input.addEventListener("input", dailyMoney); // tar_ratio 입력 시 daily_money 업데이트
          } else if (i === 6) {
            input.type = "text";
            input.className = "daily_money";
            input.readOnly = true;
          } else {
            input.type = "text";
            input.className = "ticker";
          }
          newCell.appendChild(input);
        }
      });

      // 기존 dailyMoney 함수는 그대로 유지
      function dailyMoney() {
        const days =
          parseInt(document.getElementById("fix_date").textContent) || 0; // 기간
        const moneyInput =
          parseFloat(document.getElementById("money").value) || 0; // 총 금액

        // 모든 total 값의 합을 계산
        var totalInputs = document.querySelectorAll(".total");
        var totalValues = Array.from(totalInputs).map(
          (input) => parseFloat(input.value) || 0
        );
        var totalSum = totalValues.reduce((acc, total) => acc + total, 0);

        // 모든 tar_ratio 값의 합을 계산
        var tarRatioInputs = document.querySelectorAll(".tar_ratio");
        var tarRatios = Array.from(tarRatioInputs).map(
          (input) => parseFloat(input.value) || 0
        );
        var tarSum = tarRatios.reduce((acc, tar) => acc + tar, 0);

        // 각 행에 대해 daily_money 계산
        var dailyMoneyInputs = document.querySelectorAll(".daily_money");
        tarRatios.forEach((tarRatio, index) => {
          // 비율에 따른 금액 계산
          var calculatedAmount = ((moneyInput + totalSum) / tarSum) * tarRatio;

          // 차액 계산
          var difference = calculatedAmount - totalValues[index];

          // 하루 금액 계산
          var dailyAmount = days > 0 ? (difference / days).toFixed(2) : 0;

          // daily_money 업데이트
          dailyMoneyInputs[index].value = dailyAmount;
        });
      }
    </script>
  </body>
</html>
