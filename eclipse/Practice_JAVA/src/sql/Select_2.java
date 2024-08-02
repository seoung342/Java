package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Select_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;	// 접속 정보
		Statement stmt = null;	// 
		
		System.out.print("지역 입력 > ");
		String str = scan.nextLine();
		String sql = String.format("select * from dept where loc ='%s'", str);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","mysql");
			System.out.println("접속 성공~!");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(!rs.next()) {
				System.out.println("해당 조건에 알맞는 자료가 없습니다.");
			}
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				System.out.printf("%d %s %s \n",deptno, dname, loc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
// Scanner 사용해서 입력받아 dept 테이블에서 자료 찾기
