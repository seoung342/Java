package exam1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex02 {
	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into dept(deptno, dname, loc) values (?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","mysql");
			System.out.println("MySQL 접속 성공~!");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 106);
			pstmt.setString(2, "감찰부");
			pstmt.setString(3, "인천");
			int ret = pstmt.executeUpdate();
			System.out.println(ret + "건 insert 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
