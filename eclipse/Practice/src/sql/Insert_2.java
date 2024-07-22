package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Insert_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;	// 접속 정보
		Statement stmt = null;	// 
		String sql = "select max(deptno) from dept";
		
		System.out.print("부서명 입력 > ");
		String strName = scan.nextLine();
		System.out.print("지역 입력 > ");
		String strLoc = scan.nextLine();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","mysql");
			System.out.println("접속 성공~!");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			
			int nextNum = rs.getInt(1) + 1;
			String sql2 = String.format("insert into dept(deptno, dname, loc) values ( %s, '%s', '%s')", nextNum, strName, strLoc);
			stmt.executeUpdate(sql2);
			System.out.println("쿼리 성공~!~!");
			System.out.println(sql2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
// Scanner 사용해서 입력받아 dept 테이블 자료 입력하기 ( deptno는 자동으로 들어간다 )