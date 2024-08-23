<!-- json 파일을 읽어서 테이블에 저장
	 테이블, 트리거, 시퀀스를 삭제하고 새로 만든다. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.sql.*, org.json.JSONObject, org.json.JSONArray" %>
<%
    // JDBC 드라이버 로드
    String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
    String dbURL = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle DB URL
    String dbUser = "scott"; // DB 사용자 이름
    String dbPassword = "tiger"; // DB 비밀번호

    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    FileInputStream fis = null;
    BufferedReader reader = null;

    try {
        // JDBC 드라이버 로드
        Class.forName(jdbcDriver);

        // JSON 파일 읽기
        File file = new File(application.getRealPath("/data.json")); // 데이터 파일 경로
        fis = new FileInputStream(file);
        reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
        StringBuilder jsonString = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            jsonString.append(line);
        }

        // JSON 파싱
        JSONObject jsonObject = new JSONObject(jsonString.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("data"); // JSON 배열 가져오기

        // DB 연결
        conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
        stmt = conn.createStatement();

        // 테이블 드롭
        String dropTableSQL = "DROP TABLE your_table_name";
        try {
            stmt.executeUpdate(dropTableSQL);
        } catch (SQLException e) {
            // 테이블이 존재하지 않더라도 무시하고 계속 진행
            if (!e.getMessage().contains("ORA-00942")) {
                throw e;
            }
        }

        // 시퀀스 드롭
        String dropSequenceSQL = "DROP SEQUENCE your_sequence_name";
        try {
            stmt.executeUpdate(dropSequenceSQL);
        } catch (SQLException e) {
            // 시퀀스가 존재하지 않더라도 무시하고 계속 진행
            if (!e.getMessage().contains("ORA-02289")) {
                throw e;
            }
        }

        // 트리거 드롭
        String dropTriggerSQL = "DROP TRIGGER your_trigger_name";
        try {
            stmt.executeUpdate(dropTriggerSQL);
        } catch (SQLException e) {
            // 트리거가 존재하지 않더라도 무시하고 계속 진행
            if (!e.getMessage().contains("ORA-04098")) {
                throw e;
            }
        }

        // 테이블 생성
        String createTableSQL = "CREATE TABLE your_table_name ("
                + "id NUMBER PRIMARY KEY, "
                + "column1 VARCHAR2(50), "
                + "column2 VARCHAR2(50), "
                + "column3 VARCHAR2(50))";
        stmt.executeUpdate(createTableSQL);

        // 시퀀스 생성
        String createSequenceSQL = "CREATE SEQUENCE your_sequence_name "
                + "START WITH 1 INCREMENT BY 1";
        stmt.executeUpdate(createSequenceSQL);

        // 트리거 생성
        String createTriggerSQL = "CREATE OR REPLACE TRIGGER your_trigger_name "
                + "BEFORE INSERT ON your_table_name "
                + "FOR EACH ROW "
                + "BEGIN "
                + "  :NEW.id := your_sequence_name.NEXTVAL; "
                + "END;";
        stmt.executeUpdate(createTriggerSQL);

        // 데이터 삽입 SQL 준비
        String insertSQL = "INSERT INTO your_table_name (column1, column2, column3) VALUES (?, ?, ?)";
        pstmt = conn.prepareStatement(insertSQL);

        // JSON 데이터 삽입
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            pstmt.setString(1, obj.getString("field1"));
            pstmt.setString(2, obj.getString("field2"));
            pstmt.setString(3, obj.getString("field3"));
            pstmt.addBatch();
        }

        pstmt.executeBatch();

        out.println("테이블, 시퀀스, 트리거가 성공적으로 생성되고 데이터가 삽입되었습니다.");
    } catch (Exception e) {
        e.printStackTrace();
        out.println("데이터 삽입 중 오류가 발생했습니다: " + e.getMessage());
    } finally {
        // 자원 정리
        try {
            if (pstmt != null) pstmt.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
            if (reader != null) reader.close();
            if (fis != null) fis.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
%>