package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select_1 {
public static void main(String[] args) {
		
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;
		Statement stmt = null;
		String sql = "select count(*) from dept";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","mysql");
			System.out.println("접속 성공~!");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			rs.next();
			System.out.println("dept 테이블에는 총 " + rs.getInt(1) + "건의 자료가 있습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
//dept 테이블 자료 갯수 구하기