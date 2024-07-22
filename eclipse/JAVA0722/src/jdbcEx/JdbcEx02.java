package jdbcEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcEx02 {
	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;
		Statement stmt = null;
		String sql = "drop table dept";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","mysql");
			System.out.println("접속 성공~!");
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("쿼리 성공~!~!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
// 테이블 제거