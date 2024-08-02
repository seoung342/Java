package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert_0 {
	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;
		Statement stmt = null;
		String sql = "insert into dept values( 104, '총무부', '인천')";
		
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