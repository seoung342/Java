package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTa {
	public static void main(String[] args) {
		String createEmp = "CREATE TABLE IF NOT EXISTS emp"+
				"(EMPNO int(11) not null, " +
				"ENAME varchar(10) default null, "+
				"JOB varchar(9) default null, " +
				"MGR int(11) default null, " +
				"HIREDATE date default null, " +
				"SAL int(11) default null, " +
				"COMM int(11) default null, " +
				"DEPTNO int (11) default null)" +
				"ENGINE=InnoDB default charset=utf8";
		
		String createDept =  "CREATE TABLE IF NOT EXISTS dept"+
				"(DEPTNO int(11) default null, " +
				"DNAME varchar(14) default null, "+
				"LOC varchar(13) default null) " +
				"ENGINE=InnoDB default charset=utf8";
		
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("MySql 접속 성공!!");
			stmt = con.createStatement();
			stmt.executeUpdate(createEmp);
			stmt.executeUpdate(createDept);
			System.out.println("테이블 생성!!!");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
