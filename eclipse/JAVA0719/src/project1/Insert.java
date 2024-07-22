package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	public static void main(String[] args) {
		
		String insertEmp = "INSERT INTO emp VALUES(7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000, NULL, 10)";
		String insertDept = "INSERT INTO dept VALUES(10, 'ACCOUNTING', 'NEW YORK')";
		
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("MySql 접속 성공!!");
			stmt = con.createStatement();
			stmt.executeUpdate(insertEmp);
			stmt.executeUpdate(insertDept);
			System.out.println("테이블에 데이터 삽입!!!");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
