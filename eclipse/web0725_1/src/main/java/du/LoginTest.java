package du;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;	// 접속 정보
		PreparedStatement pstmt = null;	// 
		
		String sql = "select * from account where name = ? and ssn = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","mysql");
			System.out.println("접속 성공~!");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "강하나");
			pstmt.setString(2, "911224");
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String ssn = rs.getString("ssn");
				String tel = rs.getString("tel");
				int balance =rs.getInt("balance");
				String str = String.format("%d, %s, %s, %s, %d\n", id, name, ssn, tel, balance);
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
