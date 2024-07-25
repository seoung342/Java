package exam1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex03 {
	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from dept where loc like ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","mysql");
			System.out.println("MySQL 접속 성공~!");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "서울");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.printf("%d, %s, %s\n",deptno, dname, loc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
