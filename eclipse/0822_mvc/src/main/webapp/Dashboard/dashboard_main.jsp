<%@ page import="java.sql.SQLException, java.sql.DriverManager, java.sql.ResultSet, java.sql.PreparedStatement, java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Line Chart with Chart.js</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <canvas id="myChart" width="400" height="200"></canvas>
    <script>
        // JSP 코드에서 데이터베이스 조회 및 JSON 변환
        <%
            String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE"; // 데이터베이스 URL
            String jdbcUsername = "scott"; // 사용자명
            String jdbcPassword = "tiger"; // 비밀번호

            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                // JDBC 드라이버 로드
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

                // SQL 쿼리 실행
                String sql = "SELECT t.hiredate, " +
                             "SUM(CASE WHEN t.country_type LIKE '미국%' THEN t.purchase_total * e.us_exchange " +
                             "          WHEN t.country_type LIKE '일본%' THEN (t.purchase_total * e.jp_exchange) / 100 " +
                             "          ELSE 0 END) AS total_purchase_total, " +
                             "SUM(CASE WHEN t.country_type LIKE '미국%' THEN t.now_total * e.us_exchange " +
                             "          WHEN t.country_type LIKE '일본%' THEN (t.now_total * e.jp_exchange) / 100 " +
                             "          ELSE 0 END) AS total_now_total " +
                             "FROM test_stock_info t " +
                             "JOIN exchange_rate e ON t.hiredate = e.hiredate " +
                             "GROUP BY t.hiredate " +
                             "ORDER BY t.hiredate";
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();

                // JSON 변환
                StringBuilder json = new StringBuilder("[");
                while (resultSet.next()) {
                    String hiredate = resultSet.getString("hiredate");
                    double totalNowTotal = resultSet.getDouble("total_now_total");
                    if (json.length() > 1) {
                        json.append(",");
                    }
                    json.append("['").append(hiredate).append("', ").append(totalNowTotal).append("]");
                }
                json.append("]");

                // JSON 데이터 출력
                out.print("var chartData = " + json.toString() + ";");
            } catch (Exception e) {
                e.printStackTrace();
                out.print("var chartData = [];"); // 오류 발생 시 빈 배열 반환
            } finally {
                // 자원 정리
                if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (statement != null) try { statement.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (connection != null) try { connection.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        %>

        // Chart.js로 데이터 시각화
        window.onload = function() {
            var labels = [];
            var values = [];

            // JSON 데이터에서 labels와 values 추출
            for (var i = 0; i < chartData.length; i++) {
                labels.push(chartData[i][0]);
                values.push(chartData[i][1]);
            }

            var ctx = document.getElementById('myChart').getContext('2d');
            new Chart(ctx, {
                type: 'line',
                data: {
                    labels: labels,
                    datasets: [{
                        label: 'Total Now Price',
                        data: values,
                        borderColor: 'rgba(75, 192, 192, 1)',
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        x: {
                            beginAtZero: true
                        },
                        y: {
                            beginAtZero: false,
                            min: 10000000  // Y축의 최소값을 10,000,000으로 설정
                        }
                    }
                }
            });
        };
    </script>
</body>
</html>