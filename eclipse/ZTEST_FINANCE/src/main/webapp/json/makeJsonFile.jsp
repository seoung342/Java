<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.sql.*, org.json.JSONObject, org.json.JSONArray" %>
<%
    // Oracle DB 연결 정보
    String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe"; // URL, 포트, SID에 맞게 수정
    String dbUser = "scott";
    String dbPassword = "tiger";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        // 1. DB 연결
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

        // 2. SQL 쿼리 실행
        String sql = "SELECT * FROM test_stock_info"; // 적절한 쿼리로 변경
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);

        // 3. JSON 객체로 변환
        JSONArray jsonArray = new JSONArray();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        while (rs.next()) {
            JSONObject jsonObject = new JSONObject();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                String columnValue = rs.getString(i);
                jsonObject.put(columnName, columnValue);
            }
            jsonArray.put(jsonObject);
        }

        // 4. JSON 파일로 저장
        String jsonString = jsonArray.toString(4); // 들여쓰기를 위한 4
        String filePath = application.getRealPath("/") + "data.json";
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonString);
        }

        out.println("JSON 파일이 성공적으로 생성되었습니다: " + filePath);

    } catch (Exception e) {
        e.printStackTrace();
        out.println("오류 발생: " + e.getMessage());
    } finally {
        // 5. 리소스 해제
        if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
        if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
%>
