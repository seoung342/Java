package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
	public static void main(String[] args) {
		String selectEmp = "select * from emp";
		String selectDept = "select * from dept";
		
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("MySql 접속 성공!!");
			stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(selectEmp);
			while(rs.next()) {
				System.out.print(rs.getString(1) + ", ");
				System.out.println(rs.getString(2));
			}
			ResultSet rs1 = stmt.executeQuery(selectDept);
			while(rs1.next()) {
				System.out.print(rs1.getString(1) + ", ");
				System.out.println(rs1.getString(2));
			}
			
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
