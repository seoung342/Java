<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
    String jdbcUrl = "jdbc:mysql://localhost:3307/spring5fs";
    String jdbcUser = "root";
    String jdbcPassword = "mysql";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String action = request.getParameter("action");
    String responseJson = "";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);

        if ("create".equalsIgnoreCase(action)) {
        	String empno = request.getParameter("empno");
            String ename = request.getParameter("ename");
            String job = request.getParameter("job");
            int mgr = Integer.parseInt(request.getParameter("mgr"));
            String hiredate = request.getParameter("hiredate");
            double sal = Double.parseDouble(request.getParameter("sal"));
            double comm = Double.parseDouble(request.getParameter("comm"));
            int deptno = Integer.parseInt(request.getParameter("deptno"));

            String sql = "INSERT INTO emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, empno);
            pstmt.setString(2, ename);
            pstmt.setString(3, job);
            pstmt.setInt(4, mgr);
            pstmt.setString(5, hiredate);
            pstmt.setDouble(6, sal);
            pstmt.setDouble(7, comm);
            pstmt.setInt(8, deptno);
            int rows = pstmt.executeUpdate();
            responseJson = "{\"status\":\"success\",\"rows\":" + rows + "}";

        } else if ("read".equalsIgnoreCase(action)) {
            String sql = "SELECT * FROM emp";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            JSONArray jsonArray = new JSONArray();
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("empno", rs.getInt("empno"));
                jsonObject.put("ename", rs.getString("ename"));
                jsonObject.put("job", rs.getString("job"));
                jsonObject.put("mgr", rs.getInt("mgr"));
                jsonObject.put("hiredate", rs.getDate("hiredate"));
                jsonObject.put("sal", rs.getDouble("sal"));
                jsonObject.put("comm", rs.getDouble("comm"));
                jsonObject.put("deptno", rs.getInt("deptno"));
                jsonArray.put(jsonObject);
            }
            responseJson = jsonArray.toString();

        } else if ("update".equalsIgnoreCase(action)) {
            int empno = Integer.parseInt(request.getParameter("empno"));
            String ename = request.getParameter("ename");
            String job = request.getParameter("job");
            int mgr = Integer.parseInt(request.getParameter("mgr"));
            String hiredate = request.getParameter("hiredate");
            double sal = Double.parseDouble(request.getParameter("sal"));
            double comm = Double.parseDouble(request.getParameter("comm"));
            int deptno = Integer.parseInt(request.getParameter("deptno"));

            String sql = "UPDATE emp SET ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? WHERE empno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ename);
            pstmt.setString(2, job);
            pstmt.setInt(3, mgr);
            pstmt.setString(4, hiredate);
            pstmt.setDouble(5, sal);
            pstmt.setDouble(6, comm);
            pstmt.setInt(7, deptno);
            pstmt.setInt(8, empno);
            int rows = pstmt.executeUpdate();
            responseJson = "{\"status\":\"success\",\"rows\":" + rows + "}";

        } else if ("delete".equalsIgnoreCase(action)) {
            int empno = Integer.parseInt(request.getParameter("empno"));

            String sql = "DELETE FROM emp WHERE empno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, empno);
            int rows = pstmt.executeUpdate();
            responseJson = "{\"status\":\"success\",\"rows\":" + rows + "}";
        }

    } catch (Exception e) {
        e.printStackTrace();
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        responseJson = "{\"error\":\"An error occurred while processing the request.\"}";
    } finally {
        if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
        if (pstmt != null) try { pstmt.close(); } catch (SQLException ignore) {}
        if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
    }

    out.print(responseJson);
%>