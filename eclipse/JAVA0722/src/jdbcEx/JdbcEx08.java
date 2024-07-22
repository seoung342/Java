package jdbcEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx08 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;	// 접속 정보
		Statement stmt = null;	// 
//		String sql = "select * from dept where loc ='서울'";
		
		System.out.print("부서번호 입력 > ");
		String strNo = scan.nextLine();
		System.out.print("부서명 입력 > ");
		String strName = scan.nextLine();
		System.out.print("지역 입력 > ");
		String strLoc = scan.nextLine();
		
		String sql = String.format("insert into dept(deptno, dname, loc) values ( %s, '%s', '%s')", strNo, strName, strLoc);
		System.out.println(sql);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","mysql");
			System.out.println("접속 성공~!");
			stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);
			System.out.println(res + "건을 입력!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
// Scanner 사용해서 입력받아 dept 테이블 자료 입력하기
