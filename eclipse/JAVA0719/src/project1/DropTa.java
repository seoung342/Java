package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTa {
	public static void main(String[] args) {
		String dropEmp = "drop table emp";
		String dropDept = "drop table dept";
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("MySql 접속 성공!!");
			stmt = con.createStatement();
			stmt.executeUpdate(dropEmp);
			stmt.executeUpdate(dropDept);
			System.out.println("테이블 삭제!!!");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
