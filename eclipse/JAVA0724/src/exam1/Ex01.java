package exam1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex01 {
	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update dept set dname = ?, loc = ? where deptno = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","mysql");
			System.out.println("MySQL 접속 성공~!");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "테스트부");
			pstmt.setString(2, "부산");
			pstmt.setInt(3, 105);
			int ret = pstmt.executeUpdate();
			System.out.println(ret + "건 update 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
